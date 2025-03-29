package cinema.ticketoffice.mapper;

import org.springframework.stereotype.Component;
import cinema.ticketoffice.dto.FilmCreatorDTO;
import cinema.ticketoffice.model.FilmCreator;

@Component
public class FilmCreatorMapper extends GenericMapper<FilmCreator, FilmCreatorDTO> {

    public FilmCreatorMapper() {
        super(FilmCreator.class, FilmCreatorDTO.class);
    }

}
