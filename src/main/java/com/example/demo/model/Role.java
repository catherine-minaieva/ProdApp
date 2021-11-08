package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

import static javax.persistence.GenerationType.AUTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "role")

public class Role implements  BaseModel<Long>{

    private static final long serialVersionUID = 726553041080466924L;

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(name = "name")
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role1 = (Role) o;
        return Objects.equals(id, role1.id) &&
                Objects.equals(name, role1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
