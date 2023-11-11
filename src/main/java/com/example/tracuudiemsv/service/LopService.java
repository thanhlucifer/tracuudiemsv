package com.example.tracuudiemsv.service;

import com.example.tracuudiemsv.model.Lop;
import com.example.tracuudiemsv.repository.LopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LopService {
    @Autowired
    private LopRepository lopRepository;

    public List<Lop> getAllLop() {
        return lopRepository.findAll();
    }


    public Optional<Lop> getLopById(String maLop) {
        return lopRepository.findById(maLop);
    }


    public void saveLop(Lop lop) {
        lopRepository.save(lop);
    }


    public void deleteLopById(String maLop) {
        lopRepository.deleteById(maLop);
    }


    public List<String> getAllLopNames() {
        return getAllLop().stream().map(Lop::getTenLop).collect(Collectors.toList());
    }

}
