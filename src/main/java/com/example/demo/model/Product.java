package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Table(name = "product")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product implements BaseModel<Long> {

    private static final long serialVersionUID = -3731176419549754444L;

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "id")
    private UUID id;

    @NotEmpty
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "price", length = 20)
    private BigDecimal price;

    @NotNull
    @ManyToOne()
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) &&
                Objects.equals(name, product.name) &&
                Objects.equals(price, product.price) &&
                Objects.equals(manufacturer, product.manufacturer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, manufacturer);
    }
}
