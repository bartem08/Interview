package com.interview.service;

import com.interview.model.entity.User;
import com.interview.repository.AbstractRepository;
import com.interview.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService extends AbstractService<User, String> {

    private PasswordEncoder passwordEncoder;

    private UserRepository userRepository;

    @Autowired
    protected UserService(MessageService messageService, PasswordEncoder passwordEncoder,
                          UserRepository userRepository) {
        super(messageService);
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    protected AbstractRepository<User, String> getRepository() {
        return userRepository;
    }

    @Transactional(readOnly = true)
    public Optional<User> findByPhone(String phone) {

        User user = userRepository.findByPhone(phone);
        return Optional.ofNullable(user);
    }

    public void encodePassword(User user) {

        String encoded = passwordEncoder.encode(user.getPassword());
        user.setPassword(encoded);
    }
}
