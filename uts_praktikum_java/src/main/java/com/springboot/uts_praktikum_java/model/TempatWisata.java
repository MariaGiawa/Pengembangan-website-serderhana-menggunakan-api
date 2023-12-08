package com.springboot.uts_praktikum_java.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TempatWisata {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tempatwisata;
    private String nama_tempat;
    private String harga_tiket;
    private String jam_operasional;

    public TempatWisata() {
        // Default constructor
    }

    public TempatWisata(String namaTempat, String hargaTiket, String jamOperasional) {
        this.nama_tempat = namaTempat;
        this.harga_tiket = hargaTiket;
        this.jam_operasional = jamOperasional;
    }

    public Long getIdTempatWisata() {
        return id_tempatwisata;
    }

    public void setIdTempatWisata(Long idTempatWisata) {
        this.id_tempatwisata = idTempatWisata;
    }

    public String getNamaTempat() {
        return nama_tempat;
    }

    public void setNamaTempat(String namaTempat) {
        this.nama_tempat = namaTempat;
    }

    public String getHargaTiket() {
        return harga_tiket;
    }

    public void setHargaTiket(String hargaTiket) {
        this.harga_tiket = hargaTiket;
    }

    public String getJamOperasional() {
        return jam_operasional;
    }

    public void setJamOperasional(String jamOperasional) {
        this.jam_operasional = jamOperasional;
    }
}
