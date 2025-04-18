package cinema.ticketoffice.mapper;

import cinema.ticketoffice.dto.FilmSessionDTO;
import cinema.ticketoffice.model.Film;
import cinema.ticketoffice.model.FilmSession;
import cinema.ticketoffice.repository.FilmRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FilmSessionMapper extends GenericMapper<FilmSession, FilmSessionDTO> implements ConverterForSpecificFields<FilmSession, FilmSessionDTO> {

    private FilmRepository filmRepository;


    public FilmSessionMapper() {
        super(FilmSession.class, FilmSessionDTO.class);
    }


    @PostConstruct
    @Override
    public void setupMapper() {
        modelMapper.createTypeMap(FilmSession.class, FilmSessionDTO.class).addMappings(m -> m.skip(FilmSessionDTO::setFilmId)).setPostConverter(toDtoConverter());

        modelMapper.createTypeMap(FilmSessionDTO.class, FilmSession.class).addMappings(m -> m.skip(FilmSession::setFilm)).setPostConverter(toEntityConverter());
    }

    @Override
    public void mapSpecificFields(FilmSessionDTO source, FilmSession destination) {
        Long filmId = source.getFilmId();
        if (filmId != null) {
            destination.setFilm(filmRepository.findById(filmId).orElse(null));
        } else destination.setFilm(null);
    }

    @Override
    public void mapSpecificFields(FilmSession source, FilmSessionDTO destination) {
        Long filmId = null;
        Film film = source.getFilm();
        if (film != null) {
            filmId = film.getId();
        }
        destination.setFilmId(filmId);
    }


    @Autowired
    public void setFilmRepository(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }
}
