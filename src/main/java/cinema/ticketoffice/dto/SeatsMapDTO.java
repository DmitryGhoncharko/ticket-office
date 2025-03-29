package cinema.ticketoffice.dto;

public interface SeatsMapDTO {

    Long getSeatId();
    Byte getRow();
    Byte getPlace();
    Long getOrderId();
    boolean isDeleted();
}
