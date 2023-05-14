package com.bies.idea.repository;

import com.bies.idea.model.Idea;
import com.bies.idea.model.Idea;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class IdeaRepositoryImpl implements IdeaRepository {

    private final EntityManager entityManager;

    @Override
    public List<Idea> findAll() {

        TypedQuery<Idea> theQuery = entityManager.createQuery("from Idea", Idea.class);

        List<Idea> ideas = theQuery.getResultList();

        return ideas;
    }

    @Override
    public Idea findById(int theId) {
        Idea idea = entityManager.find(Idea.class, theId);
        return idea;
    }

    @Override
    public Idea save(Idea theIdea) {
        Idea dbIdea = entityManager.merge(theIdea);
        return dbIdea;
    }

    @Override
    public void deleteById(int theId) {
        Idea idea = entityManager.find(Idea.class, theId);
        entityManager.remove(idea);
    }
}
