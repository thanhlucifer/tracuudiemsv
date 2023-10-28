package com.example.tracuudiemsv.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SinhVien {
    @Id
    private String mssv; // Đặt mssv là khóa chính

    private String hoTen;
    private String phai;
    private Date ngaySinh;
    private String noiSinh;

    @ManyToOne
    @JoinColumn(name = "lop_id",referencedColumnName = "maLop")
    private Lop lop;

    @ManyToOne
    @JoinColumn(name = "nganh_id",referencedColumnName = "maNganh")
    private Nganh nganh;

    @ManyToOne
    @JoinColumn(name = "khoa_id",referencedColumnName = "maKhoa")
    private Khoa khoa;

    @OneToMany(mappedBy = "sinhVien")
    private List<DiemHocPhan> diemHocPhans;

    @OneToOne(mappedBy = "sinhVien") // Thêm mối quan hệ với ThongKeHocTap
    private ThongKeHocTap thongKeHocTap;
}
