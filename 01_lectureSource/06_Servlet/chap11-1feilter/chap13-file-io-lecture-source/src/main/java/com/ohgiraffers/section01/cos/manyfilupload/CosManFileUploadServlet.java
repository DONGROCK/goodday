package com.ohgiraffers.section01.cos.manyfilupload;

import com.ohgiraffers.section01.common.UUIDFileRenamePolicy;
import com.oreilly.servlet.MultipartRequest;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

@WebServlet("/cos/many")
public class CosManFileUploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if(ServletFileUpload.isMultipartContent(request)) {

            ServletContext context = request.getServletContext();
            String rootLocation = context.getInitParameter("upload-location");
            int maxFileSize = Integer.parseInt(context.getInitParameter("max-file-size"));
            String encodingType = context.getInitParameter("encoding-type");

            System.out.println("파일 저장 ROOT 경로 : " + rootLocation);
            System.out.println("최대 업로드 파일 용량 : " + maxFileSize);
            System.out.println("인코딩 방식 : " + encodingType);

            String manyFileUploadDirectory = rootLocation + "/cos/many";

            File directory = new File(manyFileUploadDirectory);


            if(!directory.exists()) {

                System.out.println("폴더 생성 : " + directory.mkdirs());
            }

            MultipartRequest multiRequest = new MultipartRequest(request, manyFileUploadDirectory, maxFileSize, encodingType, new UUIDFileRenamePolicy());

            String description = multiRequest.getParameter("description");
            System.out.println(description);

            Enumeration<String> names = multiRequest.getFileNames();

            List<String> nameList = new ArrayList<>();
            while(names.hasMoreElements()) {

                String name = names.nextElement();
                System.out.println(name);
                nameList.add(name);
            }

            Collections.reverse(nameList);

            System.out.println(nameList);

            List<String> originFileNameList = new ArrayList<>();
            List<String> fileSystemNameList = new ArrayList<>();

            for(int i = 0; i < nameList.size(); i++) {
                originFileNameList.add(multiRequest.getOriginalFileName(nameList.get(i)));
                fileSystemNameList.add(multiRequest.getFilesystemName(nameList.get(i)));
            }

            System.out.println("원본 파일명 리스트 : " + originFileNameList);
            System.out.println("파일시스템명 리스트 : " + fileSystemNameList);

            int cnt = 0;
            for(int i = 0; i < fileSystemNameList.size(); i++) {
                boolean isDeleted = new File(manyFileUploadDirectory + "/" + fileSystemNameList.get(i)).delete();
                if(isDeleted || fileSystemNameList.get(i) == null) {
                    cnt += 1;
                }
            }

            if(fileSystemNameList.size() == cnt) {
                System.out.println("모든 파일 제거 성공");
            } else {
                System.out.println("모든 파일 제거 실패");
            }
        }
    }
}