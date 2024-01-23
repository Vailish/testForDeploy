package com.example.springserver.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
public class Test {
    @Id
    private Long id;
    private String cnt;
}
