package com.example.tracuudiemsv.service;

import com.example.tracuudiemsv.model.ThongKeHocTap;
import com.example.tracuudiemsv.repository.ThongKeHocTapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class ThongKeHocTapService {

    @Autowired
    private ThongKeHocTapRepository thongKeHocTapRepository;

    // Phương thức để lấy thông tin thống kê học tập bởi MSSV
    public ThongKeHocTap getThongKeHocTapByMssv(String mssv) {
        return thongKeHocTapRepository.findBySinhVien_Mssv(mssv);
    }

    // Phương thức để lấy danh sách tất cả các thống kê học tập
    public List<ThongKeHocTap> getAllThongKeHocTap() {
        return thongKeHocTapRepository.findAll();
    }

    // Phương thức để lưu thông tin thống kê học tập
    public void saveThongKeHocTap(ThongKeHocTap thongKeHocTap) {
        thongKeHocTapRepository.save(thongKeHocTap);
    }

    // Phương thức để xóa thông tin thống kê học tập
    public void deleteThongKeHocTapById(Long id) {
        thongKeHocTapRepository.deleteById(id);
    }


}
