package in.oxidane.work.done.security.controller;

import in.oxidane.work.done.security.model.Role;
import in.oxidane.work.done.security.model.RoleApiMapping;
import in.oxidane.work.done.security.model.User;
import in.oxidane.work.done.security.repository.RoleApiMappingRepository;
import in.oxidane.work.done.security.repository.RoleRepository;
import in.oxidane.work.done.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/admin")
@PreAuthorize("hasRole('ADMIN')")
public class RoleController {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private RoleApiMappingRepository roleApiMappingRepository;

    @Autowired
    private UserRepository userRepository;

    // ✅ 1️⃣ Create a new role
    @PostMapping("/roles")
    public ResponseEntity<Role> createRole(@RequestBody Role role) {
        if (roleRepository.findByName(role.getName()).isPresent()) {
            return ResponseEntity.badRequest().body(null);
        }
        Role savedRole = roleRepository.save(role);
        return ResponseEntity.ok(savedRole);
    }

    // ✅ 2️⃣ Assign an API pattern to a role
    @PostMapping("/roles/{roleId}/api-mappings")
    public ResponseEntity<?> addApiToRole(@PathVariable Long roleId, @RequestBody RoleApiMapping mappingRequest) {
        Role role = roleRepository.findById(roleId)
            .orElseThrow(() -> new RuntimeException("Role not found"));

        RoleApiMapping mapping = new RoleApiMapping();
        mapping.setRole(role);
        mapping.setApiPattern(mappingRequest.getApiPattern());
        mapping.setHttpMethod(mappingRequest.getHttpMethod());

        roleApiMappingRepository.save(mapping);
        return ResponseEntity.ok("API added to role successfully");
    }

    // ✅ 3️⃣ Assign a role to a user
    @PostMapping("/users/{userId}/roles")
    public ResponseEntity<?> assignRoleToUser(@PathVariable Long userId, @RequestBody String roleName) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found"));
        Role role = roleRepository.findByName(roleName)
            .orElseThrow(() -> new RuntimeException("Role not found"));

        user.getRoles().add(role);
        userRepository.save(user);

        return ResponseEntity.ok("Role assigned to user successfully");
    }

    // ✅ 4️⃣ Get all roles assigned to a user
    @GetMapping("/users/{userId}/roles")
    public ResponseEntity<Set<Role>> getUserRoles(@PathVariable Long userId) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found"));
        return ResponseEntity.ok(user.getRoles());
    }
}
