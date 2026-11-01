package com.example.escaperoom.controller;

import com.example.escaperoom.model.EscapeSession;
import com.example.escaperoom.repository.EscapeSessionRepo;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/escaperoom")
public class EscapeSessionController {
    private final EscapeSessionRepo escapeSessionRepo;

    public EscapeSessionController(EscapeSessionRepo escapeSessionRepo) {
        this.escapeSessionRepo = escapeSessionRepo;
    }

    @GetMapping
    public ResponseEntity<List<EscapeSession>> getAllSessions() {
        List<EscapeSession> sessions = escapeSessionRepo.findAll();
        return ResponseEntity.ok(sessions);
    }

    @PostMapping
    public ResponseEntity<EscapeSession> addSession(@Valid @RequestBody EscapeSession session){
        EscapeSession savedSession = escapeSessionRepo.save(session);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedSession);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSession(@PathVariable int id){
        escapeSessionRepo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}