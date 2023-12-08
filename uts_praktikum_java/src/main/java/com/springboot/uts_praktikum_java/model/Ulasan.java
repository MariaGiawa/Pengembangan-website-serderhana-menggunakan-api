package com.springboot.uts_praktikum_java.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
public class Ulasan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUlasan; // Secara otomatis di-generate oleh database
    private String ulasan; // Mengganti tipe data menjadi String
    @Temporal(TemporalType.DATE)
    private Date tanggalUlasan;
    private Long tempatWisata;

    public Ulasan() {
        // Default constructor
    }

    public Ulasan(String ulasan, Date tanggalUlasan, Long tempatWisata) {
        this.ulasan = ulasan;
        this.tanggalUlasan = tanggalUlasan;
        this.tempatWisata = tempatWisata;
    }

    public Long getIdUlasan() {
        return idUlasan;
    }

    public void setIdUlasan(Long idUlasan) {
        this.idUlasan = idUlasan;
    }

    public String getUlasan() {
        return ulasan;
    }

    public void setUlasan(String ulasan) {
        this.ulasan = ulasan;
    }

    public Date getTanggalUlasan() {
        return tanggalUlasan;
    }

    public void setTanggalUlasan(Date tanggalUlasan) {
        this.tanggalUlasan = tanggalUlasan;
    }

    public Long getTempatWisata() {
        return tempatWisata;
    }

    public void setTempatWisata(Long tempatWisata) {
        this.tempatWisata = tempatWisata;
    }
}
