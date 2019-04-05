package io.proyection.projection.service;

import io.proyection.projection.domain.Team;
import io.proyection.projection.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService implements ITeamService {

    @Autowired
    private TeamRepository teamRepository;

    public Team save(Team team) {
        return teamRepository.save(team);
    }

    public Iterable<Team> findAll() {
        return teamRepository.findAll();
    }

    public Team findById(Long id){
        return teamRepository.getById(id);
    }

    public void delete(Long id){
        Team team = findById(id);
        teamRepository.delete(team);
    }
}

