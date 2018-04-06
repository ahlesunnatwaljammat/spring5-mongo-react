package edu.learn.mongo.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * store in document without @Id - "role.role"
 * store in document with @Id - "role._id"
 */
@Document(collection = "role")
public class Role {
    @Id
    private Roles role;

    public Role() {
    }

    public Role(Roles role) {
        this.role = role;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Role{" +
                "role=" + role +
                '}';
    }
}