package com.example.tracuudiemsv.repository;

import com.example.tracuudiemsv.model.GiangVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GiangVienRepository extends JpaRepository<GiangVien, Long> {
}
