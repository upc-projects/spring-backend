package io.proyection.projection.web;

import io.proyection.projection.domain.Team;
import io.proyection.projection.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/teams")
@CrossOrigin
public class TeamController {

    @Autowired
    private TeamService teamService;

    @PostMapping("")
    public ResponseEntity<?> addTeam(@Valid @RequestBody Team team, BindingResult result) {

        if(result.hasErrors()){
            Map<String, String> errorMap = new HashMap<>();

            for(FieldError error: result.getFieldErrors()) {
                errorMap.put(error.getField(), error.getDefaultMessage());
            }

            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
        }

        Team newTeam = teamService.save(team);

        return new ResponseEntity<Team>(newTeam, HttpStatus.CREATED);
    }

    @GetMapping("")
    public Iterable<Team> getAllTeams() {
        return teamService.findAll();
    }

    @GetMapping("/{team_id}")
    public ResponseEntity<?> getTeamById(@PathVariable Long team_id){
        Team team = teamService.findById((team_id));
        return new ResponseEntity<Team>(team, HttpStatus.OK);
    }

    @DeleteMapping("/{team_id}")
    public ResponseEntity<?> deleteTeam(@PathVariable Long team_id){
        teamService.delete(team_id);

        return new ResponseEntity<String>("Team deleted", HttpStatus.OK);
    }
}
