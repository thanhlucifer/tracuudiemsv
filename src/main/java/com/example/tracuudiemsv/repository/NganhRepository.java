package com.example.tracuudiemsv.repository;

import com.example.tracuudiemsv.model.Nganh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NganhRepository extends JpaRepository<Nganh, String> {
    // Có thể thêm các phương thức tùy chỉnh nếu cần
}