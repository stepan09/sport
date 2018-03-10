/*
 * Copyright by Stepan Oliinyk (c) 2018.
 */

package oli.sportafford1.sport.controller;

import oli.sportafford1.sport.model.Stadium;
import oli.sportafford1.sport.repository.StadiumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StadiumController {

    @Autowired
    private StadiumRepository stadiumRepository;

    @GetMapping("/stadiums")
    public List<Stadium> getAllStadiums(){
        return stadiumRepository.findAll();
    }
}
