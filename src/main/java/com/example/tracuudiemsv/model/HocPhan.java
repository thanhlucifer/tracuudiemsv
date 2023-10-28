package com.example.tracuudiemsv.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class HocPhan {
    @Id
    private String maHocPhan;
    private String tenHocPhan;

    // Getters, setters, constructors...
}
