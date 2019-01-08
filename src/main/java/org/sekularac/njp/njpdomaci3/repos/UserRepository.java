package org.sekularac.njp.njpdomaci3.repos;

import org.sekularac.njp.njpdomaci3.entities.AppUser;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<AppUser, Long> {
    AppUser findByUsername(String username);

}
