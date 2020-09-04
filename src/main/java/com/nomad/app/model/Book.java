package com.nomad.app.model;


public class Book {
    private String id;
    private String name;
    private String authorName;

    public String getId() {
        return id;
    }

    public Book setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Book setName(String name) {
        this.name = name;
        return this;
    }

    public String getAuthorName() {
        return authorName;
    }

    public Book setAuthorName(String authorName) {
        this.authorName = authorName;
        return this;
    }
}
