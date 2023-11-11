package com.example.tracuudiemsv.repository;

import com.example.tracuudiemsv.model.ThongKeHocTap;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ThongKeHocTapRepository extends JpaRepository<ThongKeHocTap, Long> {
    ThongKeHocTap findBySinhVien_Mssv(String mssv);

    List<ThongKeHocTap> findBySinhVien_Khoa_MaKhoa(String maKhoa);

    List<ThongKeHocTap> findBySinhVien_Nganh_MaNganh(String maNganh);

    List<ThongKeHocTap> findBySinhVien_Nganh_Khoa_MaKhoa(String maKhoa);
}
