package in.oxidane.work.done.material.mapper;

import in.oxidane.work.done.material.dto.MaterialRequest;
import in.oxidane.work.done.material.dto.MaterialResponse;
import in.oxidane.work.done.material.entity.Material;
import in.oxidane.work.done.material.entity.MaterialManufacturer;
import in.oxidane.work.done.material.entity.MaterialType;
import in.oxidane.work.done.material.entity.MaterialVendor;
import org.springframework.stereotype.Component;

/**
 * Mapper class for converting between Material entity and DTOs.
 */
@Component
public class MaterialMapper {

    /**
     * Converts a MaterialRequest DTO to a Material entity.
     *
     * @param request The source MaterialRequest DTO
     * @return The mapped Material entity
     */
    public Material toEntity(MaterialRequest request) {
        if (request == null) {
            return null;
        }

        return Material.builder()
                .materialName(request.getMaterialName())
                .materialUnit(request.getMaterialUnit())
                .materialPackSize(request.getMaterialPackSize())
                .materialRatePerPack(request.getMaterialRatePerPack())
                .materialRatePerUnit(request.getMaterialRatePerUnit())
                .build();
    }

    /**
     * Updates an existing Material entity with data from MaterialRequest DTO.
     *
     * @param material The Material entity to update
     * @param request The source MaterialRequest DTO
     * @return The updated Material entity
     */
    public Material updateEntityFromRequest(Material material, MaterialRequest request) {
        if (material == null || request == null) {
            return material;
        }

        return material.toBuilder()
                .materialName(request.getMaterialName())
                .materialUnit(request.getMaterialUnit())
                .materialPackSize(request.getMaterialPackSize())
                .materialRatePerPack(request.getMaterialRatePerPack())
                .materialRatePerUnit(request.getMaterialRatePerUnit())
                .build();
    }

    /**
     * Converts a Material entity to a MaterialResponse DTO.
     *
     * @param material The source Material entity
     * @return The mapped MaterialResponse DTO
     */
    public MaterialResponse toResponse(Material material) {
        if (material == null) {
            return null;
        }

        MaterialResponse.MaterialResponseBuilder builder = MaterialResponse.builder()
                .materialName(material.getMaterialName())
                .materialUnit(material.getMaterialUnit())
                .materialPackSize(material.getMaterialPackSize())
                .materialRatePerPack(material.getMaterialRatePerPack())
                .materialRatePerUnit(material.getMaterialRatePerUnit());

        // Set manufacturer details if available
        MaterialManufacturer manufacturer = material.getMaterialManufacturer();
        if (manufacturer != null) {
            builder.materialManufacturerId(manufacturer.getMaterialManufacturerId())
                   .materialManufacturerName(manufacturer.getMaterialManufacturerName());
        }

        // Set vendor details if available
        MaterialVendor vendor = material.getMaterialVendor();
        if (vendor != null) {
            builder.materialVendorId(vendor.getMaterialVendorId())
                   .materialVendorName(vendor.getMaterialVendorName());
        }

        // Set type details if available
        MaterialType type = material.getMaterialType();
        if (type != null) {
            builder.materialTypeId(type.getMaterialTypeId())
                   .materialTypeName(type.getMaterialTypeName());
        }

        return builder.build();
    }
}
