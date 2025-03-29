package cinema.ticketoffice.mapper;

import cinema.ticketoffice.dto.SeatDTO;
import cinema.ticketoffice.model.Seat;
import org.springframework.stereotype.Component;

@Component
public class SeatMapper extends GenericMapper<Seat, SeatDTO> {

    public SeatMapper() {
        super(Seat.class, SeatDTO.class);
    }

}
