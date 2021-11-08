package com.example.demo.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Objects;
import java.util.UUID;

import static javax.persistence.GenerationType.AUTO;

@Data
@Getter @Setter
@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class User {

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(name = "email")
    @NotEmpty
    @Email
    private String email;

    @Column(name = "password")
    @NotEmpty
    private String password;

    @Column(name = "firstName")
    @NotEmpty
    private String firstName;

    @NotEmpty
    @Column(name = "lastName")
    private String lastName;

    @ManyToOne
    private Role role;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(email, user.email) &&
                Objects.equals(password, user.password) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(role, user.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password, firstName, lastName, role);
    }
}
