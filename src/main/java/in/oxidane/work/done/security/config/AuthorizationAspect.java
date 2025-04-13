package in.oxidane.work.done.security.config;

import in.oxidane.work.done.security.repository.RoleApiMappingRepository;
import in.oxidane.work.done.security.repository.UserApiMappingRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.List;

@Aspect
@Component
public class AuthorizationAspect {

    @Autowired
    private UserApiMappingRepository userApiMappingRepository;

    @Autowired
    private RoleApiMappingRepository roleApiMappingRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Around("execution(* com.yourapp.controller..*(..))")
    public Object checkAccess(ProceedingJoinPoint joinPoint) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

        String token = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (token == null || !token.startsWith("Bearer ")) {
            throw new AccessDeniedException("Missing or invalid token");
        }

        token = token.substring(7);
        Long userId = jwtUtil.extractUserId(token);
        List<String> userRoles = jwtUtil.extractRoles(token);
        String requestUri = request.getRequestURI();
        String method = request.getMethod();

        boolean userHasAccess = userApiMappingRepository.findByUserIdAndApiPattern(userId, requestUri, method).isPresent();
        boolean roleHasAccess = roleApiMappingRepository.findByRoleNamesAndApiPattern(userRoles, requestUri, method).isPresent();

        if (!userHasAccess && !roleHasAccess) {
            throw new AccessDeniedException("Access Denied");
        }

        return joinPoint.proceed();
    }
}

