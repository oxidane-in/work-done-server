package in.oxidane.work.done.lineitem.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import in.oxidane.work.done.common.constant.Endpoints;
import in.oxidane.work.done.common.exception.SchemaValidationException;
import in.oxidane.work.done.lineitem.dto.LineItemMaterialRequest;
import in.oxidane.work.done.lineitem.dto.LineItemMaterialResponse;
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

@Tag(name = "Line Item Material", description = "Line Item Material Management APIs")
@RequestMapping(Endpoints.LINE_ITEM_MATERIAL_V1)
public interface LineItemMaterialController {

    @Operation(summary = "Create a new line item material")
    @ApiResponse(responseCode = "201", description = "Line item material created successfully")
    @PostMapping
    ResponseEntity<LineItemMaterialResponse> create(@RequestBody LineItemMaterialRequest request) throws JsonProcessingException, SchemaValidationException;

    @Operation(summary = "Get a line item material by ID")
    @ApiResponse(responseCode = "200", description = "Line item material found")
    @GetMapping("/{id}")
    ResponseEntity<LineItemMaterialResponse> getById(@PathVariable Long id);

    @Operation(summary = "Get all line item materials")
    @ApiResponse(responseCode = "200", description = "List of line item materials")
    @GetMapping
    ResponseEntity<List<LineItemMaterialResponse>> getAll();

    @Operation(summary = "Update a line item material")
    @ApiResponse(responseCode = "200", description = "Line item material updated successfully")
    @PutMapping("/{id}")
    ResponseEntity<LineItemMaterialResponse> update(@PathVariable Long id, @RequestBody LineItemMaterialRequest request) throws JsonProcessingException, SchemaValidationException;

    @Operation(summary = "Delete a line item material")
    @ApiResponse(responseCode = "204", description = "Line item material deleted successfully")
    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id);
}
