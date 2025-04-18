package in.oxidane.work.done.health.check.controller;

import in.oxidane.work.done.common.constant.Endpoints;
import in.oxidane.work.done.health.check.dto.HealthResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Endpoints.HEALTH_CHECK)
@Tag(name = "Health", description = "Health check API for service status monitoring")
public class HealthCheckController {

    @Operation(summary = "Get service health status", description = "Returns the current health status of the service along with timestamp")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Service is healthy",
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = HealthResponse.class)))
    })
    @GetMapping
    public ResponseEntity<HealthResponse> healthCheck() {
        HealthResponse response = HealthResponse.builder()
            .status("UP")
            .timestamp(System.currentTimeMillis())
            .service("work-done-server")
            .build();

        return ResponseEntity.ok(response);
    }
}
