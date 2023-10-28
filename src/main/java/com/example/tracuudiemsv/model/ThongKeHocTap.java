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
public class ThongKeHocTap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "mssv", referencedColumnName = "mssv") // Chỉ ra rằng mssv là khóa ngoại
    private SinhVien sinhVien;
    private double dtbHe4;
    private double dtbHe10;
    private int soTinChiTichLuy;
    private int tongSoMonDaHoc;
    
}
