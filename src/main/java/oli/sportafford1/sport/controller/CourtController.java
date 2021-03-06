/*
 * Copyright by Stepan Oliinyk (c) 2018.
 */

package oli.sportafford1.sport.controller;

import oli.sportafford1.sport.model.Court;
import oli.sportafford1.sport.repository.CourtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CourtController {

    @Autowired
    private CourtRepository courtRepository;

    @GetMapping("/courts")
    public List<Court> getAllCourts(){
        return courtRepository.findAll();
    }
}
