/*
 * Copyright by Stepan Oliinyk (c) 2018.
 */

package oli.sportafford1.sport.controller;

import oli.sportafford1.sport.model.Organizer;
import oli.sportafford1.sport.repository.OrganizerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrganizerController {

    @Autowired
    private OrganizerRepository organizerRepository;

    @GetMapping("/organizers")
    public List<Organizer> getAllOrganizers(){
        return organizerRepository.findAll();
    }
}
