package cinema.ticketoffice.rest;

import cinema.ticketoffice.dto.ReviewDTO;
import cinema.ticketoffice.model.Review;
import cinema.ticketoffice.service.ReviewService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reviews")
@Tag(name = "Отзывы", description = "Контроллер для работы с отзывами пользователей о фильмах")
public class ReviewRestController extends GenericRestController<Review, ReviewDTO> {

    public ReviewRestController(ReviewService reviewService) {
        service = reviewService;
    }
}
