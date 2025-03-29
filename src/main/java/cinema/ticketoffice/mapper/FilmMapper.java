package cinema.ticketoffice.mapper;

import cinema.ticketoffice.dto.FilmDTO;
import cinema.ticketoffice.model.Film;
import org.springframework.stereotype.Component;

@Component
public class FilmMapper extends GenericMapper<Film, FilmDTO> {

    public FilmMapper() {
        super(Film.class, FilmDTO.class);
    }

}
