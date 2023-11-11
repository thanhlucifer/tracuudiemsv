package com.example.tracuudiemsv.controller;

import com.example.tracuudiemsv.model.*;
import com.example.tracuudiemsv.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private SinhVienService sinhVienService;

    @Autowired
    private LopService lopService;

    @Autowired
    private NganhService nganhService;

    @Autowired
    private KhoaService khoaService;

    @Autowired
    private GiangVienService giangVienService;

    @Autowired
    private HocPhanService hocPhanService;

    @Autowired
    private  DiemHocPhanService diemHocPhanService;

    @Autowired
    private  UserService userService;
    @Autowired
    private  RoleService roleService;

    @GetMapping("/users")
    public String showUserList(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "admin/users/userprofile";
    }

    @GetMapping("/users/{userId}")
    public String showUserDetails(@PathVariable Integer userId, Model model) {
        Optional<User> user = userService.getUserById(userId);
        if (user.isPresent()) {
            model.addAttribute("user", user.get());
            return "admin/users/user-details";
        } else {
            return "redirect:/admin/users/userprofile";
        }
    }

    @GetMapping("/users/{userId}/edit")
    public String editUserForm(@PathVariable Integer userId, Model model) {
        Optional<User> user = userService.getUserById(userId);
        if (user.isPresent()) {
            model.addAttribute("user", user.get());
            model.addAttribute("allRoles",roleService.getAllRoles() ); // Assuming allRoles is a list of available roles
            return "admin/users/edit-user";
        } else {
            return "redirect:/admin/users";
        }
    }

    @PostMapping("/users/{userId}/edit")
    public String updateUser(@PathVariable Integer userId, @ModelAttribute("user") User updatedUser) {
        userService.updateUser(userId, updatedUser);
        return "redirect:/admin/users/userprofile";
    }



    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable(value = "id") Integer id) {
        this.userService.deleteUser(id);
        return "redirect:/admin/users";
    }
    @GetMapping("")
    public String index(Model model){

        long numberOfStudents = sinhVienService.getAllSinhVien().size();
        long numberOfCourses = hocPhanService.getAllHocPhan().size();
        long numberOfUsers = userService.getAllUsers().size();
        long numberOfLecturers = giangVienService.getAllGiangVien().size();
        model.addAttribute("numberOfStudents", numberOfStudents);
        model.addAttribute("numberOfCourses", numberOfCourses);
        model.addAttribute("numberOfUsers", numberOfUsers);
        model.addAttribute("numberOfLecturers", numberOfLecturers);
        return "admin/index";
    }

    @GetMapping("/sinhvien")
    public String sinhvien(Model model){
        List<SinhVien> danhSachSinhVien = sinhVienService.getAllSinhVien(); // Thay thế bằng phương thức lấy danh sách sinh viên của bạn
        model.addAttribute("danhSachSinhVien", danhSachSinhVien);
        return "admin/sinhvien/index";
    }



    @GetMapping("/sinhvien/them")
    public String hienThiFormThemSinhVien(Model model) {
        SinhVien sinhVien = new SinhVien();
        model.addAttribute("sinhVien", sinhVien);
        model.addAttribute("listLop", lopService.getAllLop()); // Thêm danh sách lớp
        model.addAttribute("listNganh", nganhService.getAllNganh()); // Thêm danh sách ngành
        model.addAttribute("listKhoa", khoaService.getAllKhoa()); // Thêm danh sách khoa
        return "admin/sinhvien/create";
    }

    @PostMapping("/sinhvien/luu")
    public String luuSinhVien(@ModelAttribute SinhVien sinhVien) {
        sinhVienService.saveSinhVien(sinhVien);
        return "redirect:/admin/sinhvien";
    }

    @GetMapping("/sinhvien/sua/{mssv}")
    public String hienThiFormSuaSinhVien(@PathVariable String mssv, Model model) {
        Optional<SinhVien> sinhVien = sinhVienService.getSinhVienById(mssv);
        if (sinhVien.isPresent()) {
            model.addAttribute("sinhVien", sinhVien.get());
            model.addAttribute("listLop", lopService.getAllLop());
            model.addAttribute("listNganh", nganhService.getAllNganh());
            model.addAttribute("listKhoa", khoaService.getAllKhoa());
            return "admin/sinhvien/edit";
        } else {
            return "redirect:/admin/sinhvien";
        }
    }

    @PostMapping("/sinhvien/capnhat")
    public String capNhatSinhVien(@ModelAttribute SinhVien sinhVien) {
        sinhVienService.saveSinhVien(sinhVien);
        return "redirect:/admin/sinhvien";
    }

    @GetMapping("/sinhvien/xoa/{mssv}")
    public String xoaSinhVien(@PathVariable String mssv) {
        sinhVienService.deleteSinhVienById(mssv);
        return "redirect:/admin/sinhvien";
    }

    //QL Lop

    @GetMapping("/lop")
    public String lopIndex(Model model) {
        List<Lop> danhSachLop = lopService.getAllLop();
        model.addAttribute("danhSachLop", danhSachLop);
        return "admin/lop/index";
    }

    @GetMapping("/lop/them")
    public String hienThiFormThemLop(Model model) {
        Lop lop = new Lop();
        model.addAttribute("lop", lop);
        return "admin/lop/create";
    }

    @PostMapping("/lop/luu")
    public String luuLop(@ModelAttribute Lop lop) {
        lopService.saveLop(lop);
        return "redirect:/admin/lop";
    }

    @GetMapping("/lop/sua/{maLop}")
    public String hienThiFormSuaLop(@PathVariable String maLop, Model model) {
        Optional<Lop> lop = lopService.getLopById(maLop);
        if (lop.isPresent()) {
            model.addAttribute("lop", lop.get());
            return "admin/lop/edit";
        } else {
            return "redirect:/admin/lop";
        }
    }

    @PostMapping("/lop/capnhat")
    public String capNhatLop(@ModelAttribute Lop lop) {
        lopService.saveLop(lop);
        return "redirect:/admin/lop";
    }

    @GetMapping("/lop/xoa/{maLop}")
    public String xoaLop(@PathVariable String maLop) {
        lopService.deleteLopById(maLop);
        return "redirect:/admin/lop";
    }

    //QL Ngành

    // Thêm danh sách Ngành
    @GetMapping("/nganh")
    public String nganhIndex(Model model) {
        List<Nganh> danhSachNganh = nganhService.getAllNganh();
        model.addAttribute("danhSachNganh", danhSachNganh);
        return "admin/nganh/index";
    }

    // Hiển thị form thêm Ngành
    @GetMapping("/nganh/them")
    public String hienThiFormThemNganh(Model model) {
        Nganh nganh = new Nganh();
        model.addAttribute("listKhoa", khoaService.getAllKhoa()); // Thêm danh sách khoa
        model.addAttribute("nganh", nganh);
        return "admin/nganh/create";
    }

    // Lưu Ngành
    @PostMapping("/nganh/luu")
    public String luuNganh(@ModelAttribute Nganh nganh) {
        nganhService.saveNganh(nganh);
        return "redirect:/admin/nganh";
    }

    // Hiển thị form sửa Ngành
    @GetMapping("/nganh/sua/{maNganh}")
    public String hienThiFormSuaNganh(@PathVariable String maNganh, Model model) {
        Optional<Nganh> nganh = nganhService.getNganhById(maNganh);
        if (nganh.isPresent()) {
            model.addAttribute("nganh", nganh.get());
            model.addAttribute("listKhoa", khoaService.getAllKhoa());
            return "admin/nganh/edit";
        } else {
            return "redirect:/admin/nganh";
        }
    }

    // Cập nhật Ngành
    @PostMapping("/nganh/capnhat")
    public String capNhatNganh(@ModelAttribute Nganh nganh) {
        nganhService.saveNganh(nganh);
        return "redirect:/admin/nganh";
    }

    // Xóa Ngành
    @GetMapping("/nganh/xoa/{maNganh}")
    public String xoaNganh(@PathVariable String maNganh) {
        nganhService.deleteNganhById(maNganh);
        return "redirect:/admin/nganh";
    }

    //QL Khoa

    // Hiển thị danh sách Khoa
    @GetMapping("/khoa")
    public String khoaIndex(Model model) {
        List<Khoa> danhSachKhoa = khoaService.getAllKhoa();
        model.addAttribute("danhSachKhoa", danhSachKhoa);
        return "admin/khoa/index";
    }

    // Hiển thị form thêm Khoa
    @GetMapping("/khoa/them")
    public String hienThiFormThemKhoa(Model model) {
        Khoa khoa = new Khoa();
        model.addAttribute("khoa", khoa);
        return "admin/khoa/create";
    }

    // Lưu Khoa
    @PostMapping("/khoa/luu")
    public String luuKhoa(@ModelAttribute Khoa khoa) {
        khoaService.saveKhoa(khoa);
        return "redirect:/admin/khoa";
    }

    // Hiển thị form sửa Khoa
    @GetMapping("/khoa/sua/{maKhoa}")
    public String hienThiFormSuaKhoa(@PathVariable String maKhoa, Model model) {
        Optional<Khoa> khoa = khoaService.getKhoaById(maKhoa);
        if (khoa.isPresent()) {
            model.addAttribute("khoa", khoa.get());
            return "admin/khoa/edit";
        } else {
            return "redirect:/admin/khoa";
        }
    }

    // Cập nhật Khoa
    @PostMapping("/khoa/capnhat")
    public String capNhatKhoa(@ModelAttribute Khoa khoa) {
        khoaService.saveKhoa(khoa);
        return "redirect:/admin/khoa";
    }

    // Xóa Khoa
    @GetMapping("/khoa/xoa/{maKhoa}")
    public String xoaKhoa(@PathVariable String maKhoa) {
        khoaService.deleteKhoaById(maKhoa);
        return "redirect:/admin/khoa";
    }

    //QL Giang Vien

    //QL GiangVien

    // Hiển thị danh sách GiangVien
    @GetMapping("/giangvien")
    public String giangVienIndex(Model model) {
        List<GiangVien> danhSachGiangVien = giangVienService.getAllGiangVien();
        model.addAttribute("danhSachGiangVien", danhSachGiangVien);
        return "admin/giangvien/index";
    }

    // Hiển thị form thêm GiangVien
    @GetMapping("/giangvien/them")
    public String hienThiFormThemGiangVien(Model model) {
        GiangVien giangVien = new GiangVien();
        model.addAttribute("giangVien", giangVien);
        return "admin/giangvien/create";
    }

    // Lưu GiangVien
    @PostMapping("/giangvien/luu")
    public String luuGiangVien(@ModelAttribute GiangVien giangVien) {
        giangVienService.saveGiangVien(giangVien);
        return "redirect:/admin/giangvien";
    }

    // Hiển thị form sửa GiangVien
    @GetMapping("/giangvien/sua/{magv}")
    public String hienThiFormSuaGiangVien(@PathVariable String magv, Model model) {
        Optional<GiangVien> giangVien = giangVienService.getGiangVienById(magv);
        if (giangVien.isPresent()) {
            model.addAttribute("giangVien", giangVien.get());
            return "admin/giangvien/edit";
        } else {
            return "redirect:/admin/giangvien";
        }
    }

    // Cập nhật GiangVien
    @PostMapping("/giangvien/capnhat")
    public String capNhatGiangVien(@ModelAttribute GiangVien giangVien) {
        giangVienService.saveGiangVien(giangVien);
        return "redirect:/admin/giangvien";
    }

    // Xóa GiangVien
    @GetMapping("/giangvien/xoa/{magv}")
    public String xoaGiangVien(@PathVariable String magv) {
        giangVienService.deleteGiangVienById(magv);
        return "redirect:/admin/giangvien";
    }

    //Ql hoc phan

    @GetMapping("/hocphan")
    public String hocphanIndex(Model model) {
        List<HocPhan> danhSachHocPhan = hocPhanService.getAllHocPhan();
        model.addAttribute("danhSachHocPhan", danhSachHocPhan);
        return "admin/hocphan/index";
    }


    // Hiển thị form thêm HocPhan
    @GetMapping("/hocphan/them")
    public String hienThiFormThemHocPhan(Model model) {
        HocPhan hocPhan = new HocPhan();
        model.addAttribute("hocPhan", hocPhan);
        return "admin/hocphan/create";
    }

    // Lưu HocPhan
    @PostMapping("/hocphan/luu")
    public String luuHocPhan(@ModelAttribute HocPhan hocPhan) {
        hocPhanService.saveHocPhan(hocPhan);
        return "redirect:/admin/hocphan";
    }

    // Hiển thị form sửa HocPhan
    @GetMapping("/hocphan/sua/{maHocPhan}")
    public String hienThiFormSuaHocPhan(@PathVariable String maHocPhan, Model model) {
        Optional<HocPhan> hocPhan = hocPhanService.getHocPhanById(maHocPhan);
        if (hocPhan.isPresent()) {
            model.addAttribute("hocPhan", hocPhan.get());
            return "admin/hocphan/edit";
        } else {
            return "redirect:/admin/hocphan";
        }
    }

    // Cập nhật HocPhan
    @PostMapping("/hocphan/capnhat")
    public String capNhatHocPhan(@ModelAttribute HocPhan hocPhan) {
        hocPhanService.saveHocPhan(hocPhan);
        return "redirect:/admin/hocphan";
    }

    // Xóa HocPhan
    @GetMapping("/hocphan/xoa/{maHocPhan}")
    public String xoaHocPhan(@PathVariable String maHocPhan) {
        hocPhanService.deleteHocPhanById(maHocPhan);
        return "redirect:/admin/hocphan";
    }

    //QL điểm học phần
    // Hiển thị danh sách Điểm Học Phần
    @GetMapping("/diemhocphan")
    public String diemHocPhanIndex(Model model) {
        List<DiemHocPhan> danhSachDiemHocPhan = diemHocPhanService.getAllDiemHocPhan();
        model.addAttribute("danhSachDiemHocPhan", danhSachDiemHocPhan);
        return "admin/diemhocphan/index";
    }

    // Xóa Điểm Học Phần
    @GetMapping("/diemhocphan/xoa/{id}")
    public String xoaDiemHocPhan(@PathVariable Long id) {
        diemHocPhanService.deleteDiemHocPhanById(id);
        return "redirect:/admin/diemhocphan";
    }

}




