package com.finalproject.cafegaming.model;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class EntityAuditing implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return Optional.of(username);
    }
}
