package com.godlife.godlifeback.service;

import javax.annotation.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {

    String upload(MultipartFile file);
    Resource getFile(String fileName);    
} 