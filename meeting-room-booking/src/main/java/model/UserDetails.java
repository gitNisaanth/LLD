package model;

import java.util.UUID;

public class UserDetails {
    private String id;
    private String name;

    public UserDetails(String name) {
        this.id = UUID.randomUUID().toString();;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
