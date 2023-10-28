package com.example.tracuudiemsv.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Nganh {
    @Id
    private String maNganh;
    private String tenNganh;

    @ManyToOne
    @JoinColumn(name = "khoa_id", referencedColumnName = "maKhoa")
    private Khoa khoa;


}