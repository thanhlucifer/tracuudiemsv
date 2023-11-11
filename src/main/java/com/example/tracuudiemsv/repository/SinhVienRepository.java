package com.example.tracuudiemsv.repository;

import com.example.tracuudiemsv.model.SinhVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SinhVienRepository extends JpaRepository<SinhVien, String> {

    @Query("SELECT sv.hoTen FROM SinhVien sv")
    List<String> getAllSinhVienName();

}
