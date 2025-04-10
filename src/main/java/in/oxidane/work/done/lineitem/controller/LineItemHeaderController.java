package in.oxidane.work.done.lineitem.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import in.oxidane.work.done.common.constant.Endpoints;
import in.oxidane.work.done.common.exception.SchemaValidationException;
import in.oxidane.work.done.lineitem.dto.LineItemHeaderRequest;
import in.oxidane.work.done.lineitem.dto.LineItemHeaderResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Tag(name = "Line Item Header", description = "Line Item Header Management APIs")
@RequestMapping(Endpoints.LINE_ITEM_HEADER_V1)
public interface LineItemHeaderController {

    @Operation(summary = "Create a new line item header")
    @ApiResponse(responseCode = "201", description = "Line item header created successfully")
    @PostMapping
    ResponseEntity<LineItemHeaderResponse> create(@RequestBody LineItemHeaderRequest request) throws JsonProcessingException, SchemaValidationException;

    @Operation(summary = "Update an existing line item header")
    @ApiResponse(responseCode = "200", description = "Line item header updated successfully")
    @PutMapping("/{id}")
    ResponseEntity<LineItemHeaderResponse> update(@PathVariable Long id, @RequestBody LineItemHeaderRequest request) throws JsonProcessingException, SchemaValidationException;

    @Operation(summary = "Get a line item header by ID")
    @ApiResponse(responseCode = "200", description = "Line item header retrieved successfully")
    @GetMapping("/{id}")
    ResponseEntity<LineItemHeaderResponse> getById(@PathVariable Long id);

    @Operation(summary = "Get a line item header by handle")
    @ApiResponse(responseCode = "200", description = "Line item header retrieved successfully")
    @GetMapping("/handle/{handle}")
    ResponseEntity<LineItemHeaderResponse> getByHandle(@PathVariable String handle);

    @Operation(summary = "Get all line item headers")
    @ApiResponse(responseCode = "200", description = "Line item headers retrieved successfully")
    @GetMapping
    ResponseEntity<List<LineItemHeaderResponse>> getAll();

    @Operation(summary = "Delete a line item header")
    @ApiResponse(responseCode = "204", description = "Line item header deleted successfully")
    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id);
}
