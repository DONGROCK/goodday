package com.ohgiraffers.section03.thumbnail;

import net.coobird.thumbnailator.Thumbnailator;
import net.coobird.thumbnailator.Thumbnails;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@WebServlet("/transferToThumbnail")
public class TransferToThumbnailImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*썸네일 게시판 형태인 경우 원본 파일을 로드해서 사용자에게 보여주면 로딩도 느려지고 모바일로 접속하면 많은 양의 데이터 손실이 일어날 수 있다.
        * 따라서 썸네일 게시판 이미지용으로 이미지를 변환하여 보여주는 직업이 필요하다.
        *  -> thumbnailtor라이브러리를 이용하여 이미지를 변환시키자
        * https://coobird.github.io/thumbnailator/javadoc/0.4.13/
        * */

        //톰캣 컨테이너의 최상위 경로를 알고 싶은 경우! *중요 경로찾기*
        System.out.println("[path] : " + request.getSession().getServletContext().getRealPath("/"));
        System.out.println("[path] : " + request.getSession().getServletContext().getRealPath("/WEB_INF/"));

        String originFilePath = request.getSession().getServletContext().getRealPath("/") + "resources/origin-image/mybatis.PNG";
        File originFile = new File(originFilePath);

        //썸네일을 만드는 쪽
        String savePath = request.getSession().getServletContext().getRealPath("/") + "resources/thumbnail-image/";
        File thumbFilePath = new File(savePath);
        if(!thumbFilePath.exists()){
            thumbFilePath.mkdirs();
        }

        String thumbFileName = "mybatis_thumbnail.jpg";

        try {
            Thumbnails.of(originFile)
                    .size(100, 80)
                    .toFile(savePath + thumbFileName);
            System.out.println("[SAVEPATH] thumbFile : " + (thumbFilePath + thumbFileName));
            System.out.println("썸네일 변환 성공");
        } catch (IOException e){
            e.printStackTrace();
        }


    }

}