package com.bies.idea.service;

import com.bies.idea.model.Idea;

import java.util.List;

public interface IdeaService {

    List<Idea> findAll();

    Idea findById(int theId);

    Idea save(Idea theIdea);

    void deleteById(int theId);
}
