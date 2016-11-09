package com.interview.repository;

import com.interview.model.entity.Topic;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepository extends AbstractRepository<Topic, String> {}
