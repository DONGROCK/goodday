package com.ohgiraffers.section01.common;

import com.oreilly.servlet.multipart.FileRenamePolicy;

import java.io.File;
import java.util.UUID;

public class UUIDFileRenamePolicy implements FileRenamePolicy {
    @Override
    public File rename(File file) {

        String fileName = file.getName();
        int dot = fileName.lastIndexOf(".");
        String body = fileName.substring(0, dot); // 파일명
        String ext = fileName.substring(dot); // 확장자

        /**/
        String fileId = UUID.randomUUID().toString().replace("-","");

        System.out.println("기존 파일명 : " + fileName);
        System.out.println("body : " + body);
        System.out.println("ext : " + ext);
        System.out.println("변경할 파일명 : " + fileId);

        //getParent() : 상위 디렉토리의 경로를 반환
        return new File(file.getParent(), fileId + ext);
    }
}
