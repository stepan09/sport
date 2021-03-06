/*
 * Copyright by Stepan Oliinyk (c) 2018.
 */

package oli.sportafford1.sport.controller;

import oli.sportafford1.sport.model.Competition;
import oli.sportafford1.sport.repository.CompetitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CompetitionController {

    @Autowired
    private CompetitionRepository competitionRepository;

    @GetMapping("/competitions")
    public List<Competition> getAllCompetitions(){
        return competitionRepository.findAll();
    }
}
