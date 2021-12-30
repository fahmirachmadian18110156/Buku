package com.belajarjava.dto;

import javax.validation.constraints.NotEmpty;

public class BukuData {

    @NotEmpty(message = "Nama is required!")
    private String nama;

    @NotEmpty(message = "Deskripsi is required!")
    private String deskripsi;

    @NotEmpty(message = "Penerbit is required!")
    private String penerbit;

    private String tahun;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getPenerbit() {
        return penerbit;
    }

    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }

    public String getTahun() {
        return tahun;
    }

    public void setTahun(String tahun) {
        this.tahun = tahun;
    }

}
