package com.springboot.uts_praktikum_java.repository;

import com.springboot.uts_praktikum_java.model.Ulasan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UlasanRepository extends JpaRepository<Ulasan, Long> {
	List<Ulasan> findByUlasanContaining(String keyword);
}

