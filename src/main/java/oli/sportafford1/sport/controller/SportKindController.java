/*
 * Copyright by Stepan Oliinyk (c) 2018.
 */

package oli.sportafford1.sport.controller;

import oli.sportafford1.sport.model.SportKind;
import oli.sportafford1.sport.repository.SportKindRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SportKindController {

    @Autowired
    private SportKindRepository sportKindRepository;

    public List<SportKind> getAllSportKinds(){
        return sportKindRepository.findAll();
    }
}
