package com.studentesports.backend.services;

import com.studentesports.backend.models.User;
import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;

import javax.crypto.SecretKey;
import java.util.function.Function;

public interface JwtService {
    public String generateToken(User user);
    public <T> T extractClaim(String token, Function<Claims, T> resolver);
    public String extractUsername(String token);
    public Boolean isValid(String token, UserDetails user);
}