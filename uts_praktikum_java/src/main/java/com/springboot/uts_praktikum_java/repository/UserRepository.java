package com.springboot.uts_praktikum_java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.uts_praktikum_java.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username); // Contoh: Metode untuk mencari pengguna berdasarkan nama pengguna (username)

    // Anda dapat menambahkan metode tambahan sesuai kebutuhan aplikasi Anda
}
