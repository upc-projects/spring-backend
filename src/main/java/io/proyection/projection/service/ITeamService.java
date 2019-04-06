package io.proyection.projection.service;

import io.proyection.projection.domain.Team;
import org.springframework.stereotype.Service;

@Service
public interface ITeamService {

    Team save(Team team);

    Iterable<Team> findAll();

    Team findById(Long id);

    void delete(Long id);

    Team addUser(Long user_id, Long team_id);

    Team addTask(Long task_id, Long team_id);
}
