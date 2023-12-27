package com.ohgiraffers.section01.cos.multifileupload;

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
import java.util.Enumeration;

@WebServlet("/cos/multi")
public class CosMultiFileUploadServlet extends HttpServlet {


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

            String multiFileUploadDirectory = rootLocation + "/cos/multi";

            File directory = new File(multiFileUploadDirectory);


            if(!directory.exists()) {

                System.out.println("폴더 생성 : " + directory.mkdirs());
            }

            MultipartRequest multiRequest = new MultipartRequest(request, multiFileUploadDirectory, maxFileSize, encodingType, new UUIDFileRenamePolicy());


            String description = multiRequest.getParameter("description");
            System.out.println(description);


            Enumeration<String> names = multiRequest.getFileNames();
            while(names.hasMoreElements()) {
                System.out.println(names.nextElement());
            }

            String originFileName = multiRequest.getOriginalFileName("multifile");
            System.out.println("form 전송된 파일의 원본 이름 : " + originFileName);

            String changedFileName = multiRequest.getFilesystemName("multifile");
            System.out.println("파일 시스템에 저장된 변경된 파일의 이름 : " + changedFileName);


            String filePath = multiFileUploadDirectory;

            File remover = new File(multiFileUploadDirectory + "/" + changedFileName);

            System.out.println("파일 삭제 성공? : " + remover.delete());

        }

    }
}