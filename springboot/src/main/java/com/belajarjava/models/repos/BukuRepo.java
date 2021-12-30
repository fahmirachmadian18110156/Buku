package com.belajarjava.models.repos;

import java.util.List;

import com.belajarjava.models.entities.Buku;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface BukuRepo extends PagingAndSortingRepository<Buku, Long> {

    List<Buku> findByNamaContainsAndPenerbitContains(String nama, String penerbit);

}
