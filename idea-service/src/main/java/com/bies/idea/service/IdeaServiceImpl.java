package com.bies.idea.service;

import com.bies.idea.model.Idea;
import com.bies.idea.repository.IdeaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IdeaServiceImpl implements IdeaService {

    private final IdeaRepository ideaRepository;
    private final KafkaTemplate<String, Idea> kafkaTemplate;

    @Override
    public List<Idea> findAll() {
        return ideaRepository.findAll();
    }

    @Override
    public Idea findById(int theId) {
        Idea idea = ideaRepository.findById(theId);
//        kafkaTemplate.send("notificationTopic", idea);
        return ideaRepository.findById(theId);
    }

    @Transactional
    @Override
    public Idea save(Idea theIdea) {
        Idea newIdea = ideaRepository.save(theIdea);
//        kafkaTemplate.send("notificationTopic", newIdea);
        return newIdea;
    }

    @Transactional
    @Override
    public void deleteById(int theId) {
        ideaRepository.deleteById(theId);
    }
}
