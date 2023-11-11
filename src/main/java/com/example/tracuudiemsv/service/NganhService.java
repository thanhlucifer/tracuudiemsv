package com.example.tracuudiemsv.service;

import com.example.tracuudiemsv.model.Nganh;
import com.example.tracuudiemsv.repository.NganhRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NganhService {
    @Autowired
    private NganhRepository nganhRepository;

    public List<Nganh> getAllNganh() {
        return nganhRepository.findAll();
    }

    public List<String> getAllNganhNames() {
        List<Nganh> nganhs = getAllNganh();
        List<String> nganhNames = new ArrayList<>();
        for (Nganh nganh : nganhs) {
            nganhNames.add(nganh.getTenNganh());
        }
        return nganhNames;
    }

    public Optional<Nganh> getNganhById(String maNganh) {
        return nganhRepository.findById(maNganh);
    }

    public void saveNganh(Nganh nganh) {
        nganhRepository.save(nganh);
    }

    public void deleteNganhById(String maNganh) {
        nganhRepository.deleteById(maNganh);
    }
}
