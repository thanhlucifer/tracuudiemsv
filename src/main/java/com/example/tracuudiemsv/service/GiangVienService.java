package com.example.tracuudiemsv.service;

import com.example.tracuudiemsv.model.GiangVien;
import com.example.tracuudiemsv.repository.GiangVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GiangVienService {

    @Autowired
    private GiangVienRepository giangVienRepository;

    public List<GiangVien> getAllGiangVien() {
        return giangVienRepository.findAll();
    }

    public Optional<GiangVien> getGiangVienById(String magv) {
        return giangVienRepository.findById(magv);
    }

    public void saveGiangVien(GiangVien giangVien) {
        giangVienRepository.save(giangVien);
    }

    public void deleteGiangVienById(String magv) {
        giangVienRepository.deleteById(magv);
    }
}
