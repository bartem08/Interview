package com.interview.service;

import com.interview.model.entity.Topic;
import com.interview.repository.AbstractRepository;
import com.interview.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService extends AbstractService<Topic, String> {

    @Autowired
    private TopicRepository topicRepository;

    @Override
    protected AbstractRepository<Topic, String> getRepository() {
        return topicRepository;
    }
}
