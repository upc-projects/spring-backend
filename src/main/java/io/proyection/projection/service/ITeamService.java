package io.proyection.projection.service;

import io.proyection.projection.domain.Team;
import org.springframework.stereotype.Service;

@Service
public interface ITeamService {

    public Team save(Team team);

    public Iterable<Team> findAll();

    public Team findById(Long id);

    public void delete(Long id);

    public Team addUser(Long user_id, Long team_id);
}
