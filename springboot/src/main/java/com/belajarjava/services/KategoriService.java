package com.belajarjava.services;

import javax.transaction.Transactional;

import com.belajarjava.models.entities.Kategori;
import com.belajarjava.models.repos.KategoriRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class KategoriService {

    @Autowired
    private KategoriRepo kategoriRepo;

    public Kategori create(Kategori kategori) {
        return kategoriRepo.save(kategori);
    }

    public Iterable<Kategori> findAll() {
        return kategoriRepo.findAll();
    }

    public void removeOne(Long id) {
        kategoriRepo.deleteById(id);
    }

}
