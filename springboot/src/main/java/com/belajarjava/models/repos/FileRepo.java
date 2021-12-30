package com.belajarjava.models.repos;

import com.belajarjava.models.entities.File;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepo extends JpaRepository<File, String>{
    
}
