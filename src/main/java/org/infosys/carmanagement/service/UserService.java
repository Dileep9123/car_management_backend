package org.infosys.carmanagement.service;

import org.infosys.carmanagement.exception.InvalidEntityException;
import org.infosys.carmanagement.model.User;
import org.infosys.carmanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public User signUp(User user) throws InvalidEntityException {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new InvalidEntityException("Email is already registered.");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User login(String email, String password) throws InvalidEntityException {
        Optional<User> userOpt = userRepository.findByEmail(email);
        if (userOpt.isEmpty() || 
            !passwordEncoder.matches(password, userOpt.get().getPassword())) {
            throw new InvalidEntityException("Invalid email or password.");
        }
        return userOpt.get();
    }
}
