package in.oxidane.work.done.lineitem.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import in.oxidane.work.done.common.constant.Endpoints;
import in.oxidane.work.done.common.exception.SchemaValidationException;
import in.oxidane.work.done.lineitem.dto.LineItemCategoryRequest;
import in.oxidane.work.done.lineitem.dto.LineItemCategoryResponse;
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

@Tag(name = "Line Item Category", description = "Line Item Category management APIs")
@RequestMapping(Endpoints.LINE_ITEM_CATEGORY_V1)
public interface LineItemCategoryController {

    @Operation(summary = "Create a new category")
    @ApiResponse(responseCode = "201", description = "Category created successfully")
    @PostMapping
    ResponseEntity<LineItemCategoryResponse> create(@RequestBody LineItemCategoryRequest request) throws JsonProcessingException, SchemaValidationException;

    @Operation(summary = "Update an existing category")
    @ApiResponse(responseCode = "200", description = "Category updated successfully")
    @PutMapping("/{id}")
    ResponseEntity<LineItemCategoryResponse> update(@PathVariable Long id, @RequestBody LineItemCategoryRequest request) throws JsonProcessingException, SchemaValidationException;

    @Operation(summary = "Get a category by ID")
    @ApiResponse(responseCode = "200", description = "Category retrieved successfully")
    @GetMapping("/{id}")
    ResponseEntity<LineItemCategoryResponse> getById(@PathVariable Long id);

    @Operation(summary = "Get a category by handle")
    @ApiResponse(responseCode = "200", description = "Category retrieved successfully")
    @GetMapping("/handle/{handle}")
    ResponseEntity<LineItemCategoryResponse> getByHandle(@PathVariable String handle);

    @Operation(summary = "Get all categories")
    @ApiResponse(responseCode = "200", description = "Categories retrieved successfully")
    @GetMapping
    ResponseEntity<List<LineItemCategoryResponse>> getAll();

    @Operation(summary = "Delete a category")
    @ApiResponse(responseCode = "204", description = "Category deleted successfully")
    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id);
}
