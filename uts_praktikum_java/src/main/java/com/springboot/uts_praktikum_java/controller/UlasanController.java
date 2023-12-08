package com.springboot.uts_praktikum_java.controller;
import com.springboot.uts_praktikum_java.model.Ulasan;
import com.springboot.uts_praktikum_java.service.UlasanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/ulasans")
public class UlasanController {
    @Autowired
    UlasanService ulasanService;

    @GetMapping("")
    public List<Ulasan> list() {
        return ulasanService.getAllUlasans();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ulasan> get(@PathVariable Long id) {
        try {
            Ulasan ulasan = ulasanService.getUlasanById(id);
            return new ResponseEntity<>(ulasan, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Ulasan> add(@RequestBody Ulasan ulasan) {
        Ulasan createdUlasan = ulasanService.createUlasan(ulasan);
        return new ResponseEntity<>(createdUlasan, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ulasan> update(@RequestBody Ulasan ulasan, @PathVariable Long id) {
        try {
            Ulasan existUlasan = ulasanService.getUlasanById(id);
            ulasan.setIdUlasan(id);
            Ulasan updatedUlasan = ulasanService.updateUlasan(id, ulasan);
            return new ResponseEntity<>(updatedUlasan, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        ulasanService.deleteUlasan(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @GetMapping("/search")
    public ResponseEntity<List<Ulasan>> searchByUlasan(@RequestParam String ulasan) {
        List<Ulasan> ulasanList = ulasanService.getUlasanByUlasan(ulasan);

        if (ulasanList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(ulasanList, HttpStatus.OK);
        }
    }

}
