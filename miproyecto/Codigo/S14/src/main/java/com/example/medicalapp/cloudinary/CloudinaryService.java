package com.example.medicalapp.cloudinary;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
public class CloudinaryService {

    private final Cloudinary cloudinary;

    public CloudinaryService() {
        this.cloudinary = new Cloudinary(ObjectUtils.asMap(
            "cloud_name", "TUNUBE",
            "api_key", "TUAPIKEY",
            "api_secret", "TUAPISECRET"
        ));
    }

    public String subirImagen(MultipartFile archivo) throws IOException {
        Map uploadResult = cloudinary.uploader().upload(archivo.getBytes(), ObjectUtils.emptyMap());
        return uploadResult.get("secure_url").toString();
    }
}