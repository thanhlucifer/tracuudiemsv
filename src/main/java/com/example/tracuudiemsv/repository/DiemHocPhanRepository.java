package com.example.tracuudiemsv.repository;

import com.example.tracuudiemsv.model.DiemHocPhan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiemHocPhanRepository extends JpaRepository<DiemHocPhan, Long> {

    List<DiemHocPhan> findBySinhVien_Mssv(String mssv);
}
