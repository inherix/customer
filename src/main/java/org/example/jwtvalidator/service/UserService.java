package org.example.jwtvalidator.service;

import lombok.RequiredArgsConstructor;
import org.example.jwtvalidator.dto.UpdateProfile;
import org.example.jwtvalidator.model.User;
import org.example.jwtvalidator.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repo;

    public User getProfile(String id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Profile not found"));
    }

    public User createProfile(User req) {
        return repo.save(req);
    }

//    public User updateProfile( UpdateProfile req) {
//        User profile = repo.findById(id)
//                .orElseThrow(() -> new RuntimeException("Profile not found"));
//
//        profile.setFirstName(req.getFirstName());
//        profile.setLastName(req.getLastName());
//        profile.setEmail(req.getEmail());
//        profile.setAddress(req.getAddress());
//        profile.setDob(req.getDob());
//        return repo.save(profile);
//    }
}

