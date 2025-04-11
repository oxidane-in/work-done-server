package in.oxidane.work.done.common.interceptor;

import in.oxidane.work.done.common.config.LoggingProperties;
import in.oxidane.work.done.common.wrapper.CachedBodyHttpServletRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class LoggingInterceptor implements HandlerInterceptor {

    private final LoggingProperties loggingProperties;
    private static final String REQUEST_ID = "requestId";
    private static final String USER = "user";
    private static final String ENDPOINT = "endpoint";
    private static final String START_TIME = "startTime";
    private static final String API_REGEX = ".*/v[1-2]/.*";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!loggingProperties.isEnabled() || !request.getRequestURI().matches(API_REGEX)) {
            return true;
        }

        String requestId = UUID.randomUUID().toString();
        String endpoint = request.getMethod() + " " + request.getRequestURI();

        request.setAttribute(START_TIME, System.currentTimeMillis());
        request.setAttribute(REQUEST_ID, requestId);

        MDC.put(REQUEST_ID, requestId);
        MDC.put(USER, "mock_user");
        MDC.put(ENDPOINT, endpoint);

        log.info("Incoming request: {} {}", request.getMethod(), request.getRequestURI());

        if (loggingProperties.isIncludeHeaders()) {
            log.debug("Request Headers: {}", getHeaders(request));
        }

        if (loggingProperties.isIncludeRequestBody() && request instanceof CachedBodyHttpServletRequest) {
            try {
                String requestBody = new String(StreamUtils.copyToByteArray(request.getInputStream()));
                if (!requestBody.isEmpty()) {
                    log.debug("Request Body: {}", requestBody);
                }
            } catch (IOException e) {
                log.warn("Failed to read request body", e);
            }
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if (!loggingProperties.isEnabled() || !request.getRequestURI().matches(API_REGEX)) {
            return;
        }

        String requestId = (String) request.getAttribute(REQUEST_ID);
        String endpoint = request.getMethod() + " " + request.getRequestURI();
        Long startTime = (Long) request.getAttribute(START_TIME);
        long duration = System.currentTimeMillis() - startTime;

        MDC.put(REQUEST_ID, requestId);
        MDC.put(USER, "mock_user");
        MDC.put(ENDPOINT, endpoint);

        // Handle response logging
        ContentCachingResponseWrapper responseWrapper = null;
        if (response instanceof ContentCachingResponseWrapper) {
            responseWrapper = (ContentCachingResponseWrapper) response;
        }

        log.info("Request completed in {} ms with status: {}", duration, response.getStatus());

        if (loggingProperties.isIncludeHeaders()) {
            log.debug("Response Headers: {}", getHeaders(response));
        }

        if (responseWrapper != null && loggingProperties.isIncludeResponseBody()) {
            byte[] responseBody = responseWrapper.getContentAsByteArray();
            if (responseBody.length > 0) {
                String body = new String(responseBody, StandardCharsets.UTF_8);
                if (body.length() > loggingProperties.getMaxBodyLength()) {
                    body = body.substring(0, loggingProperties.getMaxBodyLength()) + "...";
                }
                log.debug("Response Body: {}", body);
            }
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        MDC.clear();
    }

    private String getRequestBody(ContentCachingRequestWrapper request) {
        try {
            // Read the request body and cache it
            request.getInputStream().readAllBytes();
            byte[] buf = request.getContentAsByteArray();
            if (buf.length > 0) {
                String body = new String(buf, StandardCharsets.UTF_8);
                return body.length() > loggingProperties.getMaxBodyLength()
                    ? body.substring(0, loggingProperties.getMaxBodyLength()) + "..."
                    : body;
            }
        } catch (Exception e) {
            log.warn("Failed to read request body", e);
        }
        return "";
    }

    private String getResponseBody(ContentCachingResponseWrapper response) {
        byte[] buf = response.getContentAsByteArray();
        if (buf.length == 0) {
            return "";
        }
        String body = new String(buf, StandardCharsets.UTF_8);
        return body.length() > loggingProperties.getMaxBodyLength()
            ? body.substring(0, loggingProperties.getMaxBodyLength()) + "..."
            : body;
    }

    private String getHeaders(HttpServletRequest request) {
        StringBuilder headers = new StringBuilder();
        request.getHeaderNames().asIterator().forEachRemaining(headerName -> {
            if (isSecurityHeader(headerName)) {
                headers.append(headerName).append(": ").append(request.getHeader(headerName)).append(", ");
            }
        });
        return headers.toString();
    }

    private String getHeaders(HttpServletResponse response) {
        StringBuilder headers = new StringBuilder();
        response.getHeaderNames().forEach(headerName -> {
            if (isSecurityHeader(headerName)) {
                headers.append(headerName).append(": ").append(response.getHeader(headerName)).append(", ");
            }
        });
        return headers.toString();
    }

    private boolean isSecurityHeader(String headerName) {
        return !headerName.toLowerCase().contains("authorization") &&
            !headerName.toLowerCase().contains("cookie") &&
            !headerName.toLowerCase().contains("secret");
    }
}
