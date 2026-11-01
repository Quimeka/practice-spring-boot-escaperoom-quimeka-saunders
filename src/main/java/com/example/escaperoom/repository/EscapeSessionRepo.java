package com.example.escaperoom.repository;

import com.example.escaperoom.model.EscapeSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EscapeSessionRepo extends JpaRepository<EscapeSession, Integer> {
}
