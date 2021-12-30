package com.belajarjava.models.repos;

import com.belajarjava.models.entities.Kategori;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface KategoriRepo extends PagingAndSortingRepository<Kategori, Long>{
    
}
