package com.interview.repository;

import com.interview.model.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends AbstractRepository<User> {

    User findByPhone(String username);
}
