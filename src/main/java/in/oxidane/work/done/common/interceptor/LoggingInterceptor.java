package in.oxidane.work.done.common.interceptor;

import in.oxidane.work.done.common.config.LoggingProperties;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class LoggingInterceptor implements HandlerInterceptor {

    private final LoggingProperties loggingProperties;
    private static final String REQUEST_ID = "requestId";
    private static final String USER = "user";
    private static final String ENDPOINT = "endpoint";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!loggingProperties.isEnabled() || !request.getRequestURI().contains("/api/")) {
            return true;
        }

        String requestId = UUID.randomUUID().toString();
        String endpoint = request.getMethod() + " " + request.getRequestURI();

        // Store requestId in request attributes for later use
        request.setAttribute(REQUEST_ID, requestId);

        MDC.put(REQUEST_ID, requestId);
        //TODO: Get user from security context
        MDC.put(USER, "mock_user");
        MDC.put(ENDPOINT, endpoint);

        if (!(request instanceof ContentCachingRequestWrapper)) {
            request = new ContentCachingRequestWrapper(request);
        }

        log.info("Incoming request");

        if (loggingProperties.isIncludeHeaders()) {
            log.debug("Request Headers: {}", getHeaders(request));
        }

        if (loggingProperties.isIncludeRequestBody()) {
            String requestBody = new String(((ContentCachingRequestWrapper) request).getContentAsByteArray());
            log.debug("Request Body: {}", requestBody);
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if (!loggingProperties.isEnabled() || !request.getRequestURI().contains("/api/")) {
            return;
        }

        // Retrieve requestId from request attributes
        String requestId = (String) request.getAttribute(REQUEST_ID);
        String endpoint = request.getMethod() + " " + request.getRequestURI();

        // Re-set MDC context for response logging
        MDC.put(REQUEST_ID, requestId);
        MDC.put(USER, "mock_user");
        MDC.put(ENDPOINT, endpoint);

        ContentCachingResponseWrapper responseWrapper;
        if (response instanceof ContentCachingResponseWrapper) {
            responseWrapper = (ContentCachingResponseWrapper) response;
        } else {
            responseWrapper = new ContentCachingResponseWrapper(response);
        }

        log.info("Response Status: {}", response.getStatus());

        if (loggingProperties.isIncludeHeaders()) {
            log.debug("Response Headers: {}", getHeaders(response));
        }

        if (loggingProperties.isIncludeResponseBody()) {
            byte[] responseBody = responseWrapper.getContentAsByteArray();
            if (responseBody.length > 0) {
                String body = new String(responseBody);
                if (body.length() > loggingProperties.getMaxBodyLength()) {
                    body = body.substring(0, loggingProperties.getMaxBodyLength()) + "...";
                }
                log.debug("Response Body: {}", body);
            }
            responseWrapper.copyBodyToResponse(); // Important: copy content to the response
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        MDC.clear();
    }

    private String getHeaders(HttpServletRequest request) {
        StringBuilder headers = new StringBuilder();
        request.getHeaderNames().asIterator().forEachRemaining(headerName -> {
            if (!isSecurityHeader(headerName)) {
                headers.append(headerName).append(": ").append(request.getHeader(headerName)).append(", ");
            }
        });
        return headers.toString();
    }

    private String getHeaders(HttpServletResponse response) {
        StringBuilder headers = new StringBuilder();
        response.getHeaderNames().forEach(headerName -> {
            if (!isSecurityHeader(headerName)) {
                headers.append(headerName).append(": ").append(response.getHeader(headerName)).append(", ");
            }
        });
        return headers.toString();
    }

    private boolean isSecurityHeader(String headerName) {
        return headerName.toLowerCase().contains("authorization") ||
            headerName.toLowerCase().contains("cookie") ||
            headerName.toLowerCase().contains("secret");
    }
}
