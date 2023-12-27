package com.ohgiraffers.file;

import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class FileUploadController {

    @PostMapping("single-file")
    public String singleFileUpload(@RequestParam MultipartFile singleFile, String singleFileDescription, Model model){

        System.out.println("singleFile = " + singleFile);
        System.out.println("singleFileDescription = " + singleFileDescription);

        /* 파일을 저장할 경로 설정*/
        String root = "c:/upload-files";
        String filePath = root + "/single";

        File dir = new File(filePath);
        System.out.println(dir.getAbsolutePath());

        if(!dir.exists()){
            dir.mkdirs();
        }

        //파일명 변경처리
        String originFileName = singleFile.getOriginalFilename(); //파일이 가지고 있는 원본 파일명을 넘겨준다.
        String ext = originFileName.substring(originFileName.lastIndexOf(".")); //확장자 찾기
        String savedName = UUID.randomUUID().toString().replace("-", "") + ext;

        //파일을 저장

        try {
            singleFile.transferTo(new File(filePath + "/" + savedName)); //transferTo()를 통해서 파일을 업로드한다.
            model.addAttribute("message","파일 업로드 성공!");
        } catch (IOException e) {
            e.printStackTrace();
            new File(filePath + "/" + savedName).delete();
            model.addAttribute("message", "파일 업로드 실패!");
        }

        return "result";
    }

    @PostMapping("multi-flie")
    public String multiFileUpload(@RequestParam List<MultipartFile> multiFiles, String multiFileDescription, Model model){

        System.out.println("multiFiles = " + multiFiles);
        System.out.println("multiFileDescription = " + multiFileDescription);

        /* 파일을 저장할 경로 설정*/
        String root = "c:/upload-files";
        String filePath = root + "/multi";

        File dir = new File(filePath);
        System.out.println(dir.getAbsolutePath());

        if(!dir.exists()){
            dir.mkdirs();
        }

        //파일업로드를 하면서 데이터베이스에 전달할 객체를 하나 선언
        List<FileDTO> files = new ArrayList<>();

        try{
            for (MultipartFile file : multiFiles){

                String originFileName = file.getOriginalFilename(); //파일이 가지고 있는 원본 파일명을 넘겨준다.
                String ext = originFileName.substring(originFileName.lastIndexOf(".")); //확장자 찾기
                String savedName = UUID.randomUUID().toString().replace("-", "") + ext;

                files.add(new FileDTO(originFileName, savedName, multiFileDescription));
                /*파일을 저장*/
                file.transferTo(new File(filePath + "/" + savedName));
            }

            model.addAttribute("message", "파일 업로드 성공");

        }catch (Exception e){
            e.printStackTrace();
            //
            for (FileDTO file : files){
                new File(filePath + "/" + file.getSavedName()).delete();
            }

            model.addAttribute("message", "파일업로드 실패");

        }

        return "result";
    }
}

