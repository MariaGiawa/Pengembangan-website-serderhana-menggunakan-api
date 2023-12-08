package com.springboot.uts_praktikum_java.repository;

import com.springboot.uts_praktikum_java.model.TempatWisata;
import com.springboot.uts_praktikum_java.model.Ulasan;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TempatWisataRepository extends JpaRepository<TempatWisata, Long> {
    // Di sini Anda dapat menambahkan metode tambahan khusus jika diperlukan
	
	 // Pencarian barang berdasarkan nama yang mengandung kata kunci
	@Query("SELECT tw FROM TempatWisata tw WHERE tw.nama_tempat LIKE %:keyword%")
    List<TempatWisata> findByNamaTempatContaining(@Param("keyword") String keyword);
}