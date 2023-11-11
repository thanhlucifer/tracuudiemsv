package com.example.tracuudiemsv.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class HocPhan {
    @Id
    private String maHocPhan;
    private String tenHocPhan;
    private int soTinChi; // Thêm trường soTinChi
    @ManyToMany
    @JoinTable(
            name = "hocphan_giangvien",
            joinColumns = @JoinColumn(name = "maHocPhan"),
            inverseJoinColumns = @JoinColumn(name = "magv")
    )
    private Set<GiangVien> giangViens = new HashSet<>();
}
