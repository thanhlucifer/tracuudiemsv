package com.example.tracuudiemsv.service;

import com.example.tracuudiemsv.model.HocPhan;
import com.example.tracuudiemsv.repository.HocPhanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HocPhanService {
    @Autowired
    private HocPhanRepository hocPhanRepository;

    public List<HocPhan> getAllHocPhan() {
        return hocPhanRepository.findAll();
    }

    public Optional<HocPhan> getHocPhanById(String maHocPhan) {
        return hocPhanRepository.findById(maHocPhan);
    }


    public void saveHocPhan(HocPhan hocPhan) {
        hocPhanRepository.save(hocPhan);
    }


    public void deleteHocPhanById(String maHocPhan) {
        hocPhanRepository.deleteById(maHocPhan);
    }

    public List<String> getAllHocPhanName() {
        return hocPhanRepository.getAllHocPhanName(); // Thay bằng phương thức tương ứng trong repository
    }
}
