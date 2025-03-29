package cinema.ticketoffice.service;

import cinema.ticketoffice.dto.FilmCreatorDTO;
import cinema.ticketoffice.mapper.FilmCreatorMapper;
import cinema.ticketoffice.model.FilmCreator;
import cinema.ticketoffice.repository.FilmCreatorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmCreatorService extends GenericService<FilmCreator, FilmCreatorDTO> {

    public FilmCreatorService(FilmCreatorRepository filmCreatorRepository, FilmCreatorMapper filmCreatorMapper) {
        repository = filmCreatorRepository;
        mapper = filmCreatorMapper;
    }


    public List<FilmCreatorDTO> searchFilmCreators(final String fullName) {
        List<FilmCreator> filmCreators = ((FilmCreatorRepository) repository).getAllByFullNameContainsIgnoreCase(fullName);
        return mapper.toDTOs(filmCreators);
    }
}
