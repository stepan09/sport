/*
 * Copyright by Stepan Oliinyk (c) 2018.
 */

package oli.sportafford1.sport.controller;

import oli.sportafford1.sport.exception.ResourceNotFoundException;
import oli.sportafford1.sport.model.Sportsman;
import oli.sportafford1.sport.repository.SportsmanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SportsmanController {

    @Autowired
    private SportsmanRepository sportsmanRepository;

    List<Sportsman> sportsmen = Arrays.asList(
            new Sportsman(1L,"Oliinyk", "Stepan", "Dmytrovych", Date.from(Instant.now())),
            new Sportsman(2L,"Shpylka", "Anton", "Vasyliovych", Date.from(Instant.now())),
            new Sportsman(3L,"Tsurkan", "Vitalii", "Evhenovych", Date.from(Instant.now()))
            );

    @GetMapping("/sportsmen")
    public List<Sportsman> getAllSportsmen(){
        return sportsmanRepository.findAll();
        //return sportsmen;
    }

    @PostMapping("/sportsmen")
    public Sportsman createSportsman(@Valid @RequestBody Sportsman sportsman){
        return sportsmanRepository.save(sportsman);
    }

    @GetMapping("/sportsmen/{id}")
    public Sportsman getSportsmanById(@PathVariable(value = "id") Long sportsmanId){
        return sportsmanRepository.findById(sportsmanId)
                .orElseThrow(() -> new ResourceNotFoundException("Sportsman", "id", sportsmanId));
    }

    @PutMapping("sportsmen/{id}")
    public Sportsman updateSportsman(@PathVariable(value = "id") Long sportsmanId,
                                     @Valid @RequestBody Sportsman sportsmanDetails){
        Sportsman sportsman = sportsmanRepository.findById(sportsmanId)
                .orElseThrow(() -> new ResourceNotFoundException("Sportsman", "id", sportsmanId));

        sportsman.setLastName(sportsmanDetails.getLastName());
        sportsman.setFirstName(sportsmanDetails.getFirstName());
        sportsman.setMiddleName(sportsmanDetails.getMiddleName());
        sportsman.setBirthDate(sportsmanDetails.getBirthDate());

        Sportsman updateSportsman = sportsmanRepository.save(sportsman);
        return updateSportsman;
    }

    @DeleteMapping("/sportsmen/{id}")
    public ResponseEntity<?> deleteSportsman(@PathVariable(value = "id") Long sportsmanId) {
        Sportsman sportsman = sportsmanRepository.findById(sportsmanId)
                .orElseThrow(() -> new ResourceNotFoundException("Sportsman", "id", sportsmanId));

        sportsmanRepository.delete(sportsman);

        return ResponseEntity.ok().build();
    }
}
