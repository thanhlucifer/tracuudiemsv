package com.example.tracuudiemsv.repository;

import com.example.tracuudiemsv.model.HocPhan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HocPhanRepository extends JpaRepository<HocPhan, Long> {
}