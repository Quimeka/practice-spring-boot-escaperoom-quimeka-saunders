package com.example.escaperoom.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.time.DurationMax;

import java.time.Duration;

@Entity
public class EscapeSession {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "team name required")
    private String teamName;

    private String roomTheme;

    @DurationMax(minutes = 60, inclusive = true, message = "Your Escape Room starts now")
    private Duration timeInMin;

    private int hintUsed;
    private boolean hasEscaped;
    private String teamCaptain;
    private int fearRating;

    public EscapeSession(Long id, String teamName, String roomTheme, Duration timeInMin, int hintUsed, boolean hasEscaped, String teamCaptain, int fearRating) {
        this.id = id;
        this.teamName = teamName;
        this.roomTheme = roomTheme;
        this.timeInMin = timeInMin;
        this.hintUsed = hintUsed;
        this.hasEscaped = hasEscaped;
        this.teamCaptain = teamCaptain;
        this.fearRating = fearRating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getRoomTheme() {
        return roomTheme;
    }

    public void setRoomTheme(String roomTheme) {
        this.roomTheme = roomTheme;
    }

    public Duration getTimeInMin() {
        return timeInMin;
    }

    public void setTimeInMin(Duration timeInMin) {
        this.timeInMin = timeInMin;
    }

    public int getHintUsed() {
        return hintUsed;
    }

    public void setHintUsed(int hintUsed) {
        this.hintUsed = hintUsed;
    }

    @JsonProperty("hasEscaped")
    public boolean hasEscaped() {
        return hasEscaped;
    }

    public void setEscaped(boolean escaped) {
        hasEscaped = escaped;
    }

    public String getTeamCaptain() {
        return teamCaptain;
    }

    public void setTeamCaptain(String teamCaptain) {
        this.teamCaptain = teamCaptain;
    }

    public int getFearRating() {
        return fearRating;
    }

    public void setFearRating(int fearRating) {
        this.fearRating = fearRating;
    }
}
