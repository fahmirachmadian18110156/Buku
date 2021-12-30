package com.belajarjava.services;

import java.io.IOException;
import java.util.stream.Stream;

import com.belajarjava.models.entities.File;
import com.belajarjava.models.repos.FileRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {
    
    @Autowired
    private FileRepo fileRepo;

    public File store(MultipartFile file) throws IOException{
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        File FileDB =   new File(fileName, file.getContentType(), file.getBytes());

        return fileRepo.save(FileDB);
    }

    public File getFile(String id){
        return fileRepo.findById(id).get();
    }

    public Stream<File> getAllFiles(){
        return fileRepo.findAll().stream();
    }

}
