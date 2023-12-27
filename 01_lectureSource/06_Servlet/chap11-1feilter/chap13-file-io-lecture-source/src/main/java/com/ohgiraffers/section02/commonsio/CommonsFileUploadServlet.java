package com.ohgiraffers.section02.commonsio;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.*;

@WebServlet("/commons/single")
public class CommonsFileUploadServlet extends HttpServlet {
    private String rootLocation;
    private int maxFileSize;
    private String encodingType;

    @Override
    public void init() throws ServletException {
        ServletContext context = getServletContext();
        rootLocation = context.getInitParameter("upload-location");
        maxFileSize = Integer.parseInt(context.getInitParameter("max-file-size"));
        encodingType = context.getInitParameter("encoding-type");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //commons fileupload는 내부에서 commons io라이브러리와 의존관계에 있기에 둘다 추가를 하고.
        //여기서 작성하는 코드는 input file 태그가 한개이든 여러개이든, 혹은 multiple속성이 있든 없든 상관없이 다 처리 가능하도록 작성한다.

        if (ServletFileUpload.isMultipartContent(request)){
            System.out.println("파일 저장 ROOT 경로 : " + rootLocation);
            System.out.println("최대 업로드 파일 용량 : " + maxFileSize);
            System.out.println("인코딩 방식 : " + encodingType);

            String fileuploadDirectory = rootLocation + "/commons";

            File directory = new File(fileuploadDirectory);

            if (!directory.exists()){
                System.out.println("폴더 생성 : " + directory.mkdirs());
            }

            //DB에서 사용할 객체
            Map<String, String> parameter = new HashMap<>();    //파라미터의 정보를 담을 객체
            List<Map<String, String>> fileList = new ArrayList<>(); // 파일에 대한 정보를 담을 객체

            //파일을 업로드할 때 최대 크기나 임시 저장할 폴더의 경로등을 포함하기 위해서 DiskFileItemFactory라는 객체를 생성해서 담아 놓는다.
            DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
            fileItemFactory.setRepository(new File(fileuploadDirectory));
            fileItemFactory.setSizeThreshold(maxFileSize);

            ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);

            try {
                //request를 파싱하여 데이터 하나하나를 FileItem인스턴스로 반환한다.
                List<FileItem> fileItems = fileUpload.parseRequest(request);

                for (FileItem item: fileItems){
                    //폼데이터는 isFormField속성이 ture이고, 파일은 isFormField 속성이 false이다.
                    System.out.println(item);
                }
                for (int i = 0; i < fileItems.size(); i++){
                    FileItem item = fileItems.get(i);

                    if (!item.isFormField()){//파일인 경우

                        if (item.getSize() > 0){


                            String fileName = item.getFieldName();
                            String originFileName = item.getName();

                            int dot = originFileName.lastIndexOf(".");
                            String ext = originFileName.substring(dot);

                            String randomFileName = UUID.randomUUID().toString().replace("-","")+ ext;

                            File storeFile = new File(fileuploadDirectory + "/" + randomFileName);

                            //저장한다.
                            item.write(storeFile);

                            //데이터베이스에 저장할 때 필요한 정보를 Map에 담기
                            Map<String, String> fileMap = new HashMap<>();
                            fileMap.put("fileName", fileName);
                            fileMap.put("originFileName", originFileName);
                            fileMap.put("saveFileName", randomFileName);
                            fileMap.put("savePath", fileuploadDirectory);

                            fileList.add(fileMap);
                        }
                    }else { //일반 폼데이터인 경우
                        /*
                        * 폼데이터인 경우
                        * 전송된 폼의 name은 getFileName()으로 받아오고, 해당 필드의 value는 getString()으로 받아온다.
                        * 하지만 인코딩 설정을 하더라도 전송되는 파라미턴느 ISO-8859-1로 처리된다.
                        * 별도로 ISO-8859-1로 해석된 한글을 UTF-8로 변경해야 한다.*/
//                            parameter.put(item.getFieldName(), item.getString());
                        parameter.put(item.getFieldName(), new String(item.getString().getBytes("ISO-8859-1"),"UTF-8"));

                    }
                }
                System.out.println("parameter : " + parameter);
                System.out.println("fileList : " + fileList);

            } catch (FileUploadException e) {
                for (int i =0; i< fileList.size();i++){
                    Map<String, String> file = fileList.get(i);

                    File deleteFile = new File(fileuploadDirectory + "/" + file.get("savedFile"));
//                            boolean isDeleted
                }

                e.printStackTrace();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

    }
}