package com.example.tracuudiemsv.repository;

import com.example.tracuudiemsv.model.SinhVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SinhVienRepository extends JpaRepository<SinhVien, String> {

}
