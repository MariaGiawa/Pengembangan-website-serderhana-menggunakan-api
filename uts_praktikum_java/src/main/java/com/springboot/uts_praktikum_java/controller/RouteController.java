package com.springboot.uts_praktikum_java.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RouteController {

    @GetMapping("/register")
    public String showRegisterPage() {
        return "register";
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @GetMapping("/tempatwisata-page")
    public String showTempatWisataPage() {
        return "tempatwisata";
    }

    @GetMapping("/ulasan")
    public String showUlasanPage() {
        return "ulasan";
    }
    public class LogoutController {

        @GetMapping("/logout")
        public String logout(HttpServletRequest request, HttpServletResponse response) {
            // Lakukan tindakan logout yang sesuai di sini, seperti menghapus sesi atau token otentikasi pengguna.
            
            // Setelah logout, arahkan pengguna ke halaman login
            return "redirect:/login"; // Mengarahkan ke URL /login
        }
    }
}
