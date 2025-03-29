package cinema.ticketoffice.repository;

import cinema.ticketoffice.model.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends GenericRepository<Role> {

    Role getByTitle(String title);
}
