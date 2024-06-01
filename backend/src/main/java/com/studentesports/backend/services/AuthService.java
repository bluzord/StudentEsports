package com.studentesports.backend.services;

import com.studentesports.backend.models.AuthenticationResponse;
import com.studentesports.backend.models.User;
import com.studentesports.backend.respositories.UserRepository;

public interface AuthService {
    public AuthenticationResponse register(User request);

    public AuthenticationResponse authenticate(User request);
}
