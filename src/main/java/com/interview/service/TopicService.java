package com.interview.service;

import com.interview.model.entity.Topic;
import com.interview.repository.AbstractRepository;
import com.interview.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService extends AbstractService<Topic, String> {

    private final TopicRepository topicRepository;

    @Autowired
    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    @Override
    protected AbstractRepository<Topic, String> getRepository() {
        return topicRepository;
    }
}
