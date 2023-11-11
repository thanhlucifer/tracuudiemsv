package com.example.tracuudiemsv.service;

import com.example.tracuudiemsv.model.DiemHocPhan;
import com.example.tracuudiemsv.model.SinhVien;
import com.example.tracuudiemsv.model.ThongKeHocTap;
import com.example.tracuudiemsv.repository.DiemHocPhanRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class DiemHocPhanService {

    @Autowired
    private DiemHocPhanRepository diemHocPhanRepository;
    @Autowired
    private  ThongKeHocTapService thongKeHocTapService;
    @Autowired
    private  SinhVienService sinhVienService;

    public List<DiemHocPhan> getDiemHocPhanByMssv(String mssv) {
        return diemHocPhanRepository.findBySinhVien_Mssv(mssv);
    }
    public List<DiemHocPhan> getAllDiemHocPhan() {
        return diemHocPhanRepository.findAll();
    }

    public Optional<DiemHocPhan> getDiemHocPhanById(Long id) {
        return diemHocPhanRepository.findById(id);
    }

    public void saveDiemHocPhan(DiemHocPhan diemHocPhan) {
        diemHocPhanRepository.save(diemHocPhan);
    }

    public void deleteDiemHocPhanById(Long id) {
        diemHocPhanRepository.deleteById(id);
    }

    public void capNhatDiemTrungBinh(String mssv) {
        List<DiemHocPhan> diemHocPhans = getDiemHocPhanByMssv(mssv);

        double tongDiem = 0.0;
        int tongSoTinChi = 0;

        for (DiemHocPhan diemHocPhan : diemHocPhans) {
            double diem = diemHocPhan.getDiem();
            int soTinChi = diemHocPhan.getHocPhan().getSoTinChi();

            tongDiem += diem * soTinChi;
            tongSoTinChi += soTinChi;
        }

        double diemTrungBinh = tongSoTinChi > 0 ? (tongDiem / tongSoTinChi) : 0.0;

        // Lấy thông tin thống kê học tập của sinh viên
        ThongKeHocTap thongKeHocTap = thongKeHocTapService.getThongKeHocTapByMssv(mssv);

        // Cập nhật điểm trung bình
        thongKeHocTap.setDtbHe4(diemTrungBinh);

        // Lưu thông tin thống kê học tập
        thongKeHocTapService.saveThongKeHocTap(thongKeHocTap);
    }


}
