package com.ohgiraffers.section01.cos.singlefileupload;

import com.ohgiraffers.section01.common.UUIDFileRenamePolicy;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
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

@WebServlet("/cos/single")
public class CosSingleFileUploadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /* 요청 헤더의 context-type이 multipart/form-data이면 true, 아니면 false를 반환*/
        if(ServletFileUpload.isMultipartContent(request)){

            ServletContext context = request.getServletContext();
            String rootLocation = context.getInitParameter("upload-location");
            int maxFileSize = Integer.parseInt(context.getInitParameter("max-file-size"));
            String encodingType = context.getInitParameter("encoding-type");

            System.out.println("파일 저장 ROOT 경로 : " + rootLocation);
            System.out.println("최대 업로드 파일 용량 : " + maxFileSize);
            System.out.println("인코딩 방식 : " + encodingType);

            String singleFileUploadDirectory = rootLocation + "/cos/single";

            File directory = new File(singleFileUploadDirectory);
            // exists()는 해당 경로에 파일/폴더가 있는지 없는지를 체크하는 메소드
            if(!directory.exists()){
                // 폴더를 한개만 생성할거면 mkdir, 상위폴더도 존재하지 않아 한번에 생성할 때는 mkdirs를 이용
                System.out.println("폴더 생성 : " + directory.mkdirs());
            }

            /*
             * request, 파일저장경로, 최대파일크기(-1로 지정하면 최대 용량이 없다.) 인코딩타입, 파일이름변경정책의 정보가 필요
             * --------> MultipartRequest 객체가 생성될 떄 파일 저장을 완료한다.
             * */
//            MultipartRequest multipartRequest = new MultipartRequest(request
//                                                                    , singleFileUploadDirectory
//                                                                    , maxFileSize
//                                                                    , encodingType
//                                                                    , new DefaultFileRenamePolicy());
            /*
             * UUID란
             * 범용 고유 식별자를 말한다. util성 클래스로 java.util패키지에 존재하며
             * randomUUID()메소드를 이용하여 특정 규칙을 가진 난수를 발생시켜 고유한 식별자를 만들어주는 기능을 제공하고있다.
             * */
            MultipartRequest multipartRequest = new MultipartRequest(request
                    , singleFileUploadDirectory
                    , maxFileSize
                    , encodingType
                    , new UUIDFileRenamePolicy());
            String description = multipartRequest.getParameter("description");
            System.out.println("description = " + description);
            // 전송된 폼의 name속성값
            Enumeration<String> names = multipartRequest.getFileNames();
            while(names.hasMoreElements()){
                System.out.println(names.nextElement());
            }

            // 전송된 name값을 이용하여 폼으로 전송된 파일의 원본 이름을 반환받는다.
            String originFileName = multipartRequest.getOriginalFileName("singlefile");
            System.out.println("originFileName = " + originFileName);

            // 파일 이름 변경 후 파일시스템에 저장된 파일의 이름을 반환받는다.
            String changedFileName = multipartRequest.getFilesystemName("singlefile");
            System.out.println("changedFileName = " + changedFileName);

            // 저장된 파일의 경로는 따로 불러올 수 없으므로 필요하면 별도로 DB에 저장해야한다.
            String filePath = singleFileUploadDirectory;

            File remover = new File(singleFileUploadDirectory + "/" + changedFileName);
            System.out.println("파일 삭제 성공??? : " + remover.delete());
        }
    }
}