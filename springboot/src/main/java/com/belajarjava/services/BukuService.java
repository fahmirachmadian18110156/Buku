package com.belajarjava.services;

import java.util.List;

import javax.transaction.Transactional;

import com.belajarjava.models.entities.Buku;
import com.belajarjava.models.repos.BukuRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class BukuService {

    @Autowired
    private BukuRepo bukuRepo;

    public Buku create(Buku buku) {
        return bukuRepo.save(buku);
    }

    public Iterable<Buku> findAll() {
        return bukuRepo.findAll();
    }

    public Iterable<Buku> findAllPaging(Pageable pageable) {
        return bukuRepo.findAll(pageable);
    }

    public Buku findOne(Long id) {
        return bukuRepo.findById(id).get();
    }


    public void removeOne(Long id) {
        bukuRepo.deleteById(id);
    }

    public List<Buku> findByNama(String nama, String penerbit) {
        return bukuRepo.findByNamaContainsAndPenerbitContains(nama, penerbit);
    }

}
