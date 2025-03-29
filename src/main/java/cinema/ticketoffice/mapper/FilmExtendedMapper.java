package cinema.ticketoffice.mapper;

import cinema.ticketoffice.dto.FilmExtendedDTO;
import cinema.ticketoffice.model.Film;
import org.springframework.stereotype.Component;

@Component
public class FilmExtendedMapper extends GenericMapper<Film, FilmExtendedDTO> {

    public FilmExtendedMapper() {
        super(Film.class, FilmExtendedDTO.class);
    }
}
