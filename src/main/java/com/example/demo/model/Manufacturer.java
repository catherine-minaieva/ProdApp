package com.example.demo.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Table(name = "manufacturer")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor

public class Manufacturer implements BaseModel<Long> {

    private static final long serialVersionUID = 4788865266422026234L;

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "id")
    private UUID id;

    @NotEmpty
    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "manufacturer")
    private Set<Product> products;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manufacturer that = (Manufacturer) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(products, that.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, products);
    }
}
