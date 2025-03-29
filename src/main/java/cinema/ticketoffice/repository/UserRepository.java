package cinema.ticketoffice.repository;

import cinema.ticketoffice.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends GenericRepository<User> {

    User getByLogin(String login);

    User getByEmail(String email);

    User getByChangePasswordToken(String uuid);
}
