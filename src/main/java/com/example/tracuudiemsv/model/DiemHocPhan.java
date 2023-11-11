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
public class DiemHocPhan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ma_hoc_phan", referencedColumnName = "maHocPhan")
    private HocPhan hocPhan;

    private double diem;

    @ManyToOne
    @JoinColumn(name = "mssv",referencedColumnName = "mssv")
    private SinhVien sinhVien;

}
