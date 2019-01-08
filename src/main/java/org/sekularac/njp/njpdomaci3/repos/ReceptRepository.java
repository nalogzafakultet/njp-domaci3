package org.sekularac.njp.njpdomaci3.repos;

import org.sekularac.njp.njpdomaci3.entities.Recept;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReceptRepository extends CrudRepository<Recept, Long> {
    List<Recept> findAllByNazivContains(String naziv);
}
