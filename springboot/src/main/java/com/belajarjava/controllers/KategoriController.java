package com.belajarjava.controllers;

import javax.validation.Valid;

import com.belajarjava.dto.ResponseData;
import com.belajarjava.models.entities.Kategori;
import com.belajarjava.services.KategoriService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/kategori")
public class KategoriController {

    @Autowired
    private KategoriService kategoriService;

    @PostMapping("/create")
    public ResponseEntity<ResponseData<Kategori>> create(@Valid @RequestBody Kategori kategori, Errors errors) {
        ResponseData<Kategori> responseData = new ResponseData<>();
        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                responseData.getMessage().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        responseData.setStatus(true);
        responseData.setPayload(kategoriService.create(kategori));
        responseData.getMessage().add("Kategori berhasil disimpan!");
        return ResponseEntity.ok(responseData);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseData<Kategori>> update(@Valid @RequestBody Kategori kategori, Errors errors) {
        ResponseData<Kategori> responseData = new ResponseData<>();
        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                responseData.getMessage().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        responseData.setStatus(true);
        responseData.setPayload(kategoriService.create(kategori));
        responseData.getMessage().add("Kategori berhasil di update!");
        return ResponseEntity.ok(responseData);
    }

    @GetMapping
    public Iterable<Kategori> findAll() {
        return kategoriService.findAll();
    }

    @DeleteMapping("/{id}")
    public void removeOne(@PathVariable("id") Long id){
        kategoriService.removeOne(id);
    }

}
