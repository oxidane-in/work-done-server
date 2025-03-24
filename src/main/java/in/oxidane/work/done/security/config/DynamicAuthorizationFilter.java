package in.oxidane.work.done.security.config;

import in.oxidane.work.done.security.repository.RoleApiMappingRepository;
import in.oxidane.work.done.security.repository.UserApiMappingRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
public class DynamicAuthorizationFilter extends OncePerRequestFilter {

    @Autowired
    private UserApiMappingRepository userApiMappingRepository;

    @Autowired
    private RoleApiMappingRepository roleApiMappingRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
        throws ServletException, IOException {

        String token = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7);
            Long userId = jwtUtil.extractUserId(token);
            List<String> userRoles = jwtUtil.extractRoles(token);
            String requestUri = request.getRequestURI();
            String method = request.getMethod();

            boolean userHasAccess = userApiMappingRepository.findByUserIdAndApiPattern(userId, requestUri, method).isPresent();
            boolean roleHasAccess = roleApiMappingRepository.findByRoleNamesAndApiPattern(userRoles, requestUri, method).isPresent();

            if (!userHasAccess && !roleHasAccess) {
                response.sendError(HttpServletResponse.SC_FORBIDDEN, "Access Denied");
                return;
            }
        }

        chain.doFilter(request, response);
    }
}


