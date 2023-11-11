package com.example.tracuudiemsv.repository;

import com.example.tracuudiemsv.model.Lop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LopRepository extends JpaRepository<Lop, String> {

}