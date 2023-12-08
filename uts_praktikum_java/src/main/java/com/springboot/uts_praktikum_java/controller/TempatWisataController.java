package com.springboot.uts_praktikum_java.controller;
import com.springboot.uts_praktikum_java.model.TempatWisata;
import com.springboot.uts_praktikum_java.model.Ulasan;
import com.springboot.uts_praktikum_java.service.TempatWisataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/tempatwisata")
public class TempatWisataController {
    @Autowired
    TempatWisataService tempatWisataService;

    @GetMapping("")
    public List<TempatWisata> list() {
        return tempatWisataService.getAllTempatWisata();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TempatWisata> get(@PathVariable Long id) {
        try {
            TempatWisata tempatWisata = tempatWisataService.getTempatWisataById(id);
            return new ResponseEntity<>(tempatWisata, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<TempatWisata> add(@RequestBody TempatWisata tempatWisata) {
        TempatWisata createdTempatWisata = tempatWisataService.createTempatWisata(tempatWisata);
        return new ResponseEntity<>(createdTempatWisata, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TempatWisata> update(@RequestBody TempatWisata tempatWisata, @PathVariable Long id) {
        try {
            TempatWisata existTempatWisata = tempatWisataService.getTempatWisataById(id);
            tempatWisata.setIdTempatWisata(id);
            TempatWisata updatedTempatWisata = tempatWisataService.updateTempatWisata(id, tempatWisata);
            return new ResponseEntity<>(updatedTempatWisata, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        tempatWisataService.deleteTempatWisata(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @GetMapping("/search/{keyword}")
    public List<TempatWisata> search(@PathVariable String keyword) {
        return tempatWisataService.searchTempatWisata(keyword);
    }
   
}


