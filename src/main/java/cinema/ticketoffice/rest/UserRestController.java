package cinema.ticketoffice.rest;

import cinema.ticketoffice.dto.UserDTO;
import cinema.ticketoffice.model.User;
import cinema.ticketoffice.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@Tag(name = "Пользователи", description = "Контроллер для работы с пользователями сервиса")
public class UserRestController extends GenericRestController<User, UserDTO> {

    public UserRestController(UserService userService) {
        service = userService;
    }
}
