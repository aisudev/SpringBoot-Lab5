package se331.lab.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import se331.lab.rest.entity.Organizer;
import se331.lab.rest.service.OrganizerService;
import se331.lab.rest.util.LabMapper;

import java.util.List;

@RestController
public class OrganizationController {
    @Autowired
    OrganizerService organizerService;
    @GetMapping("/organizers")
    ResponseEntity<?> getOrganizers(){
        return ResponseEntity.ok(LabMapper.INSTANCE.getOrganizerDTO(organizerService.getAllOrganizer()));
    }

    @PostMapping("/organizers")
    ResponseEntity<?>save(@RequestBody(required = true)Organizer organizer){
        Organizer output = organizerService.save(organizer);
        return ResponseEntity.ok(output);
    }

    @GetMapping("/organizers/{id}")
    ResponseEntity<?>getOrganizersByID(@PathVariable(value = "id")Long id){
        Organizer output = organizerService.getOrganizerByID(id);
        return ResponseEntity.ok((LabMapper.INSTANCE.getOrganizerDTO(output)));
    }
}
