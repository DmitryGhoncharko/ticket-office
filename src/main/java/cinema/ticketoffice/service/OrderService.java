package cinema.ticketoffice.service;

import cinema.ticketoffice.dto.DatePeriodDTO;
import cinema.ticketoffice.dto.OrderDTO;
import cinema.ticketoffice.dto.OrderInfoDTO;
import cinema.ticketoffice.mapper.OrderMapper;
import cinema.ticketoffice.model.Order;
import cinema.ticketoffice.repository.OrderRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrderService extends GenericService<Order, OrderDTO> {

    public OrderService(OrderRepository orderRepository, OrderMapper orderMapper) {
        repository = orderRepository;
        mapper = orderMapper;
    }


    public Page<OrderInfoDTO> getAllInfoByUserId(Long userId, PageRequest pageRequest) {
        return ((OrderRepository) repository).getAllInfoByUserId(userId, pageRequest);
    }

    public Long getTotalCost(DatePeriodDTO datePeriodDTO) {
        return ((OrderRepository) repository).getTotalCost(datePeriodDTO.getStartDate(), datePeriodDTO.getEndDate().plusDays(1));
    }

    public Long getTotalTickets(DatePeriodDTO datePeriodDTO) {
        return ((OrderRepository) repository).getTotalTickets(datePeriodDTO.getStartDate(), datePeriodDTO.getEndDate().plusDays(1));
    }

    public OrderDTO purchase(OrderDTO orderDTO) {
        OrderDTO existingOrderDTO = getById(orderDTO.getId());
        if (existingOrderDTO != null) {
            existingOrderDTO.setPurchase(true);
            existingOrderDTO.setCreatedWhen(LocalDateTime.now());
            update(existingOrderDTO);
        }
        return existingOrderDTO;
    }
}
