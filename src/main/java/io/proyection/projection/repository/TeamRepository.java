package io.proyection.projection.repository;

import io.proyection.projection.domain.Team;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends CrudRepository<Team, Long> {

    Team getById(Long id);
}
