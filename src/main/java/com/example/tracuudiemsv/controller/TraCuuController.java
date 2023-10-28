package com.example.tracuudiemsv.controller;

import com.example.tracuudiemsv.model.SinhVien;
import com.example.tracuudiemsv.service.SinhVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TraCuuController {

    @Autowired
    private SinhVienService sinhVienService;

    @RequestMapping("/")
    public String tracuuForm() {
        return "tracuu"; // Trả về tên của file HTML để hiển thị trang tra cứu
    }

    @PostMapping("/tracuu")
    public String tracuuSubmit(@RequestParam("mssv") String mssv, Model model) {
        SinhVien sinhVien = sinhVienService.getSinhVienById(mssv).orElse(null);

        if (sinhVien != null) {
            model.addAttribute("sinhVien", sinhVien);
            return "ketqua_tracuu"; // Trả về tên của file HTML để hiển thị kết quả tra cứu
        } else {
            model.addAttribute("errorMessage", "Không tìm thấy sinh viên với MSSV " + mssv);
            return "error"; // Trả về trang thông báo lỗi
        }
    }
}
