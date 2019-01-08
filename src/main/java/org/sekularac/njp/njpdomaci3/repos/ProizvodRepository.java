package org.sekularac.njp.njpdomaci3.repos;

import org.sekularac.njp.njpdomaci3.entities.Proizvod;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProizvodRepository extends CrudRepository<Proizvod, Long> {
    List<Proizvod> findAllByIdNotIn(List<Long> id);
}
