package com.sahil.library_tracking.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Book {
    final UUID id;
    final String name;
    final String subject;
    final int availCnt;
    final String location;

    public Book(@JsonProperty("id") UUID id, @JsonProperty("name") String name, @JsonProperty("subject") String subject,
            @JsonProperty("location") String location, @JsonProperty("availCnt") int availCnt) {
        this.availCnt = availCnt;
        this.id = id;
        this.location = location;
        this.name = name;
        this.subject = subject;
    }

    public int getAvailCnt() {
        return availCnt;
    }

    public UUID getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public String getSubject() {
        return subject;
    }

}