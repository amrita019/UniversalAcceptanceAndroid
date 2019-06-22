package com.amrita.universalacceptance;

public class ListDetails {

    private String id;
    private String name;
    private String email;

    public ListDetails(String id, String name, String description){
        this.id = id;
        this.name = name;
        this.email = description;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

}