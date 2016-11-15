package com.interview.service;

import com.interview.model.entity.Direction;
import com.interview.repository.AbstractRepository;
import com.interview.repository.DirectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DirectionService extends AbstractService<Direction, String> {

    private DirectionRepository directionRepository;

    @Autowired
    public DirectionService(MessageService messageService, DirectionRepository directionRepository) {
        super(messageService);
        this.directionRepository = directionRepository;
    }

    @Override
    protected AbstractRepository<Direction, String> getRepository() {
        return directionRepository;
    }
}
