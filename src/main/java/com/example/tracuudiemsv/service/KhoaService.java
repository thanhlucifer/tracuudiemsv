package com.example.tracuudiemsv.service;

import com.example.tracuudiemsv.model.Khoa;
import com.example.tracuudiemsv.repository.KhoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class KhoaService {
    @Autowired
    private KhoaRepository khoaRepository;


    public List<Khoa> getAllKhoa() {
        return khoaRepository.findAll();
    }


    public Optional<Khoa> getKhoaById(String maKhoa) {
        return khoaRepository.findById(maKhoa);
    }


    public void saveKhoa(Khoa khoa) {
        khoaRepository.save(khoa);
    }


    public void deleteKhoaById(String maKhoa) {
        khoaRepository.deleteById(maKhoa);
    }


    public List<String> getAllKhoaNames() {
        List<Khoa> allKhoas = khoaRepository.findAll();
        List<String> khoaNames = new ArrayList<>();
        for (Khoa khoa : allKhoas) {
            khoaNames.add(khoa.getTenKhoa());
        }
        return khoaNames;
    }
}
