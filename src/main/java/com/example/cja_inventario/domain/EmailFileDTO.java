package com.example.cja_inventario.domain;


import org.springframework.web.multipart.MultipartFile;

public record EmailFileDTO (String[] toUser, String subject, String massage, MultipartFile file){
}
