package com.bies.idea.controller;

import com.bies.idea.component.UserFeignClient;
import com.bies.idea.model.Idea;
import com.bies.idea.service.IdeaService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/idea")
@RequiredArgsConstructor
public class IdeaController {

    private final IdeaService ideaService;
    private final UserFeignClient userFeignClient;

    @GetMapping("/home")
    public String home() {
        return "Welcome to Idea Service!";
    }

//    @Secured({"USER"})
    @GetMapping("/user")
    public String user() {
        return "This is user's endpoint.";
    }

    @GetMapping("/expert")
    public String expert(Authentication authentication) {
//        Jwt jwt = (Jwt) principal;
//        return jwt.getClaim("realm_access");

        return authentication.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(" "));

//        return "This is expert's endpoint.";
    }

    @GetMapping("/feign")
    public String testFeign(Authentication authentication) {
        return userFeignClient.queryParam("EXPERT", true);
    }

    @GetMapping
    public List<Idea> findAll() {
        return ideaService.findAll();
    }

    @GetMapping("/{ideaId}")
    public Idea getIdea(@PathVariable int ideaId) {
        Idea idea = ideaService.findById(ideaId);

        if (idea == null) {
            throw new RuntimeException("Idea id not found - " + ideaId);
        }

        return idea;
    }

    @PostMapping
    public Idea addIdea(@RequestBody Idea idea) {
        idea.setId(0L);
        Idea dbIdea = ideaService.save(idea);
        return dbIdea;
    }

    @PutMapping
    public Idea updateIdea(@RequestBody Idea idea) {
        Idea dbIdea = ideaService.save(idea);
        return dbIdea;
    }

    @DeleteMapping("/{ideaId}")
    public String deleteIdea(@PathVariable int ideaId) {
        Idea idea = ideaService.findById(ideaId);

        if (idea == null) {
            throw new RuntimeException("Idea id not found - " + ideaId);
        }

        ideaService.deleteById(ideaId);

        return "Deleted idea id - " + ideaId;
    }
}
