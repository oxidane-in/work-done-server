package in.oxidane.work.done.project.mapper;

import in.oxidane.work.done.common.config.MapstructMapperConfig;
import in.oxidane.work.done.project.dto.ClientRequest;
import in.oxidane.work.done.project.dto.ClientResponse;
import in.oxidane.work.done.project.entity.Client;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(config = MapstructMapperConfig.class)
public interface ClientMapper {

    ClientResponse toResponse(Client entity);

    Client toEntity(ClientRequest request);

    List<ClientResponse> toResponse(List<Client> clients);

    Client toUpdateEntityFromRequest(ClientRequest request, @MappingTarget Client entity);
} 