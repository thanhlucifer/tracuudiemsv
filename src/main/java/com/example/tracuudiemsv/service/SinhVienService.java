package com.example.tracuudiemsv.service;


import com.example.tracuudiemsv.model.SinhVien;
import com.example.tracuudiemsv.repository.SinhVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class SinhVienService {

    @Autowired
    private SinhVienRepository sinhVienRepository;

    public List<SinhVien> getAllSinhVien() {
        return sinhVienRepository.findAll();
    }


    public Optional<SinhVien> getSinhVienById(String mssv) {
        return sinhVienRepository.findById(mssv);
    }

    public void saveSinhVien(SinhVien sinhVien) {
        sinhVienRepository.save(sinhVien);
    }

    public void deleteSinhVienById(String mssv) {
        sinhVienRepository.deleteById(mssv);
    }

    public List<String> getAllSinhVienName() {
        return sinhVienRepository.getAllSinhVienName(); // Thay bằng phương thức tương ứng trong repository
    }



}
