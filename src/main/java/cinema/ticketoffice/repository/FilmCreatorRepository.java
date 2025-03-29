package cinema.ticketoffice.repository;

import cinema.ticketoffice.model.FilmCreator;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmCreatorRepository extends GenericRepository<FilmCreator> {

    List<FilmCreator> getAllByFullNameContainsIgnoreCase(String fullName);
}
