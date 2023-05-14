package com.bies.idea.controller;

import com.bies.idea.model.Idea;
import com.bies.idea.service.IdeaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/idea")
@RequiredArgsConstructor
public class IdeaController {

    private final IdeaService ideaService;

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
        idea.setId(0);
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
