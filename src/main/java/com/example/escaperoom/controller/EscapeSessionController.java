package com.example.escaperoom.controller;

import com.example.escaperoom.model.EscapeSession;
import com.example.escaperoom.repository.EscapeSessionRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/escaperoom")
public class EscapeSessionController {
    private final EscapeSessionRepo escapeSessionRepo;

    public EscapeSessionController(EscapeSessionRepo escapeSessionRepo){
        this.escapeSessionRepo = escapeSessionRepo;
    }

    @GetMapping("/json")
    public List<EscapeSession> getEscapeSessionsJson() {
        return escapeSessions;
    }

    @GetMapping("/html")
    public String getEscapeSessionsHtml() {
        String escapeSessionList = "<ul>";
        for (EscapeSession escapeSession : escapeSessions) {
                escapeSessionList += "<li>" + escapeSession.getName() +
                        " by " + escapeSession.getArtist() + "</li>";
        }
        escapeSessionList += "</ul>";

        return """
                    <html>
                    <body>
                        <h1>EscapeSessions</h1>
                        <ul>
                """ +
                    escapeSessionList +
                    """
                            </ul>
                        </body>
                    """;
    }
}

