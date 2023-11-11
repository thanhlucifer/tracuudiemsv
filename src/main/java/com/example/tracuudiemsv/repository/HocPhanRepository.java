package com.example.tracuudiemsv.repository;

import com.example.tracuudiemsv.model.HocPhan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HocPhanRepository extends JpaRepository<HocPhan, String> {

    @Query("SELECT hp.tenHocPhan FROM HocPhan hp")
    List<String> getAllHocPhanName();
}