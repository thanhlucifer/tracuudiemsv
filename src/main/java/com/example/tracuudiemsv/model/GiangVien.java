package com.example.tracuudiemsv.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "giangvien")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GiangVien {

    @Id
    @Column(name = "magv")
    private String magv;

    @Column(name = "tengv")
    private String tengv;

    @Column(name = "diachi")
    private String diachi;

    @Column(name = "sdt")
    private String sdt;

    @Column(name = "email")
    private String email;

    @ManyToMany(mappedBy = "giangViens")
    private Set<HocPhan> hocPhans = new HashSet<>();

}

