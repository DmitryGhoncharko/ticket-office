package cinema.ticketoffice.rest;

import cinema.ticketoffice.dto.FilmCreatorDTO;
import cinema.ticketoffice.model.FilmCreator;
import cinema.ticketoffice.service.FilmCreatorService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/filmCreators")
@Tag(name = "Создатели фильмов", description = "Контроллер для работы с создателями фильмов")
public class FilmCreatorRestController extends GenericRestController<FilmCreator, FilmCreatorDTO> {

    public FilmCreatorRestController(FilmCreatorService filmCreatorService) {
        service = filmCreatorService;
    }

}
