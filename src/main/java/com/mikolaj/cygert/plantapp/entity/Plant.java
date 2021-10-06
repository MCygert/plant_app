package com.mikolaj.cygert.plantapp.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class Plant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique = true)
    private String publicId;

    @NotBlank
    private String plantName;

    @NotNull
    @Positive
    private BigDecimal amount;

    private String description;

    @NotNull
    @Enumerated(EnumType.STRING)
    private StatusOfBuying statusOfBuying;


    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private User user;

}
