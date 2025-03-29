package cinema.ticketoffice.service;

import cinema.ticketoffice.dto.FilmSessionDTO;
import cinema.ticketoffice.mapper.FilmSessionMapper;
import cinema.ticketoffice.model.FilmSession;
import cinema.ticketoffice.repository.FilmSessionRepository;
import org.springframework.stereotype.Service;

@Service
public class FilmSessionService extends GenericService<FilmSession, FilmSessionDTO> {

    public FilmSessionService(FilmSessionRepository filmSessionRepository, FilmSessionMapper filmSessionMapper) {
        repository = filmSessionRepository;
        mapper = filmSessionMapper;
    }

}
