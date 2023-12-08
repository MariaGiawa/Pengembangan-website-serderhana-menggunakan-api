package com.springboot.uts_praktikum_java.service;

import com.springboot.uts_praktikum_java.model.TempatWisata;
import com.springboot.uts_praktikum_java.model.Ulasan;
import com.springboot.uts_praktikum_java.repository.TempatWisataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TempatWisataService {
    private final TempatWisataRepository tempatWisataRepository;

    @Autowired
    public TempatWisataService(TempatWisataRepository tempatWisataRepository) {
        this.tempatWisataRepository = tempatWisataRepository;
    }

    public List<TempatWisata> getAllTempatWisata() {
        return tempatWisataRepository.findAll();
    }

    public TempatWisata getTempatWisataById(Long id) {
        return tempatWisataRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public TempatWisata createTempatWisata(TempatWisata tempatWisata) {
        return tempatWisataRepository.save(tempatWisata);
    }

    public TempatWisata updateTempatWisata(Long id, TempatWisata updatedTempatWisata) {
        TempatWisata existingTempatWisata = getTempatWisataById(id);
        updatedTempatWisata.setIdTempatWisata(existingTempatWisata.getIdTempatWisata());
        return tempatWisataRepository.save(updatedTempatWisata);
    }

    public void deleteTempatWisata(Long id) {
        tempatWisataRepository.deleteById(id);
    }
    
    // Tambahkan metode pencarian yang sesuai untuk entitas TempatWisata
    public List<TempatWisata> searchTempatWisata(String keyword) {
        return tempatWisataRepository.findByNamaTempatContaining(keyword);
    }
}
