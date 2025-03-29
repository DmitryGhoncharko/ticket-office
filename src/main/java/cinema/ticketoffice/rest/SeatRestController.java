package cinema.ticketoffice.rest;

import cinema.ticketoffice.dto.SeatDTO;
import cinema.ticketoffice.model.Seat;
import cinema.ticketoffice.service.SeatService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seats")
@Tag(name = "Места", description = "Контроллер для работы с местами в кинозале")
public class SeatRestController extends GenericRestController<Seat, SeatDTO> {

    public SeatRestController(SeatService seatService) {
        service = seatService;
    }
}
