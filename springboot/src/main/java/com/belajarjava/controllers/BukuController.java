package com.belajarjava.controllers;

import java.util.List;

import javax.validation.Valid;

import com.belajarjava.dto.BukuData;
import com.belajarjava.dto.ResponseData;
import com.belajarjava.dto.SearchKeyData;
import com.belajarjava.models.entities.Buku;
import com.belajarjava.services.BukuService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
@RequestMapping("/api/buku")
public class BukuController {

    @Autowired
    private BukuService bukuService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/create")
    public ResponseEntity<ResponseData<Buku>> create(@Valid @RequestBody BukuData bukuData, Errors errors) {
        ResponseData<Buku> responseData = new ResponseData<>();
        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                responseData.getMessage().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

        Buku buku = modelMapper.map(bukuData, Buku.class);

        responseData.setStatus(true);
        responseData.getMessage().add("Data Berhasil Disimpan!");
        responseData.setPayload(bukuService.create(buku));
        return ResponseEntity.ok(responseData);
    }

    @GetMapping
    public Iterable<Buku> findAll() {
        return bukuService.findAll();
    }

    @GetMapping("/pagesort")
    public Iterable<Buku> findAllPaging() {
        Pageable pageable = PageRequest.of(1, 3, Sort.by("id"));
        return bukuService.findAllPaging(pageable);
    }

    @GetMapping("/{id}")
    public Buku findOne(@PathVariable("id") Long id) {
        return bukuService.findOne(id);
    }

    @PostMapping("/search")
    public List<Buku> search(@RequestBody SearchKeyData searchKeyData) {
        return bukuService.findByNama(searchKeyData.getSearchKey(), searchKeyData.getSearchOtherKey());
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseData<Buku>> update(@Valid @RequestBody Buku buku, Errors errors) {
        ResponseData<Buku> responseData = new ResponseData<>();
        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                responseData.getMessage().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

        responseData.setStatus(true);
        responseData.setPayload(bukuService.create(buku));
        responseData.getMessage().add("Data berhasil di Update!");
        return ResponseEntity.ok(responseData);
    }

    @DeleteMapping("/delete/{id}")
    public void removeOne(@PathVariable("id") Long id) {
        bukuService.removeOne(id);
    }

}
