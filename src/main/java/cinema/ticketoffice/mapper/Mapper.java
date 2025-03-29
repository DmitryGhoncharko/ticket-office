package cinema.ticketoffice.mapper;

import cinema.ticketoffice.dto.GenericDTO;
import cinema.ticketoffice.model.GenericModel;

import java.util.List;

public interface Mapper<E extends GenericModel, D extends GenericDTO> {

    E toEntity(D dto);

    D toDTO(E entity);

    List<D> toDTOs(List<E> entities);
}
