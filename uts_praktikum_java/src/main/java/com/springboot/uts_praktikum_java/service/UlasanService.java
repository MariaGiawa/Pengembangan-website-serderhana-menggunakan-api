package com.springboot.uts_praktikum_java.service;

import com.springboot.uts_praktikum_java.model.Ulasan;
import com.springboot.uts_praktikum_java.repository.UlasanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UlasanService {
    private final UlasanRepository ulasanRepository;

    @Autowired
    public UlasanService(UlasanRepository ulasanRepository) {
        this.ulasanRepository = ulasanRepository;
    }

    public List<Ulasan> getAllUlasans() {
        return ulasanRepository.findAll();
    }

    public Ulasan getUlasanById(Long id) {
        return ulasanRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public Ulasan createUlasan(Ulasan ulasan) {
        return ulasanRepository.save(ulasan);
    }

    public Ulasan updateUlasan(Long id, Ulasan updatedUlasan) {
        Ulasan existingUlasan = getUlasanById(id);
        updatedUlasan.setIdUlasan(existingUlasan.getIdUlasan());
        return ulasanRepository.save(updatedUlasan);
    }

    public void deleteUlasan(Long id) {
        ulasanRepository.deleteById(id);
    }
    
    public List<Ulasan> getUlasanByUlasan(String ulasan) {
        return ulasanRepository.findByUlasanContaining(ulasan);
    }
}
