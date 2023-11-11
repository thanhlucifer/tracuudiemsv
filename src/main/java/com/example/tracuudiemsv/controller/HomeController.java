package com.example.tracuudiemsv.controller;

import com.example.tracuudiemsv.model.DiemHocPhan;
import com.example.tracuudiemsv.model.SinhVien;
import com.example.tracuudiemsv.model.ThongKeHocTap;
import com.example.tracuudiemsv.service.DiemHocPhanService;
import com.example.tracuudiemsv.service.SinhVienService;
import com.example.tracuudiemsv.service.ThongKeHocTapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("user")
public class HomeController {

    @Autowired
    private SinhVienService sinhVienService;

    @Autowired
    private DiemHocPhanService diemHocPhanService;

    @Autowired
    private ThongKeHocTapService thongKeHocTapService;
    @GetMapping("")
    public String index()// test trang user
    {
        return "user/home";
    }

    @GetMapping("/tra-cuu")
    public String traCuu() {
        return "user/tracuu/tra-cuu"; // Trả về trang tra cứu (input form)
    }

    @PostMapping("/kqtra-cuu")
    public String ketquatraCuu(@RequestParam String mssv, Model model) {
        // Get SinhVien information
        Optional<SinhVien> sinhVienOptional = sinhVienService.getSinhVienById(mssv);

        if (sinhVienOptional.isPresent()) {
            SinhVien sinhVien = sinhVienOptional.get();
            model.addAttribute("sinhVien", sinhVien);

            // Get DiemHocPhan for the student
            List<DiemHocPhan> diemHocPhans = diemHocPhanService.getDiemHocPhanByMssv(mssv);
            model.addAttribute("diemHocPhans", diemHocPhans);

            // Get ThongKeHocTap for the student
            ThongKeHocTap thongKeHocTap = thongKeHocTapService.getThongKeHocTapByMssv(mssv);
            model.addAttribute("thongKeHocTap", thongKeHocTap);

            return "user/tracuu/ket-qua"; // Return the view for displaying results
        } else {
            model.addAttribute("error", "MSSV không tồn tại");
            return "user/tracuu/error"; // Return the view with an error message
        }
    }

}



