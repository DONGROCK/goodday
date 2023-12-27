package com.ohg.fileupload.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/upload")
public class FileUploadController {
    @Value("${spring.servlet.multipart.location}")
    private String fileRoot;

    @PostMapping(value = "formdata", produces = "text/plain; charset=UTF-8")
    @ResponseBody
    public String postFileUploadTest(@RequestParam MultipartFile file, @RequestParam String description){

        System.out.println("file = " + file);
        System.out.println("description = " + description);

        return "";
    }
}
