package in.oxidane.work.done.lineitem.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import in.oxidane.work.done.common.constant.Endpoints;
import in.oxidane.work.done.common.exception.SchemaValidationException;
import in.oxidane.work.done.lineitem.dto.LineItemSubCategoryRequest;
import in.oxidane.work.done.lineitem.dto.LineItemSubCategoryResponse;
import io.swagger.v3.oas.annotations.Operation;
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

@Tag(name = "Line Item Sub Category", description = "Line Item Sub Category Management APIs")
@RequestMapping(Endpoints.LINE_ITEM_SUB_CATEGORY_V1)
public interface LineItemSubCategoryController {

    @Operation(summary = "Create new sub category")
    @PostMapping
    ResponseEntity<LineItemSubCategoryResponse> create(@RequestBody LineItemSubCategoryRequest request) throws JsonProcessingException, SchemaValidationException;

    @Operation(summary = "Update existing sub category")
    @PutMapping("/{id}")
    ResponseEntity<LineItemSubCategoryResponse> update(@PathVariable Long id, @RequestBody LineItemSubCategoryRequest request) throws JsonProcessingException, SchemaValidationException;

    @Operation(summary = "Get sub category by ID")
    @GetMapping("/{id}")
    ResponseEntity<LineItemSubCategoryResponse> getById(@PathVariable Long id);

    @Operation(summary = "Get sub category by handle")
    @GetMapping("/handle/{handle}")
    ResponseEntity<LineItemSubCategoryResponse> getByHandle(@PathVariable String handle);

    @Operation(summary = "Get all sub categories")
    @GetMapping
    ResponseEntity<List<LineItemSubCategoryResponse>> getAll();

    @Operation(summary = "Delete sub category")
    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id);
}
