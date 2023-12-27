package com.ohgiraffers.section02.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;


public class Application {
    public static void main(String[] args) throws IOException {

        //헤더 출력 서버
        //브라우저 요청 소캣에 넣어
        //                             응답  서버

        ServerSocket serverSocket = new ServerSocket(8000); //포트번호입력

        Socket client;

        while ((client = serverSocket.accept()) != null){

            Socket finalClient = client;

            //스레드안에 익명함수 넣
            //BufferedReader 문자단위로 읽어
            new Thread(() -> {
                try {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(finalClient.getInputStream()));
                    
                    //General header parsing
                    String generalHeader = reader.readLine();
                    System.out.println("generalHeader = " + generalHeader);

                    String requestMethod = generalHeader.split(" ")[0];
                    String requestPath = generalHeader.split(" ")[1];

                    System.out.println("requestMethod = " + requestMethod);
                    System.out.println("requestPath = " + requestPath);


                    //Request header parsing
                    Map<String, String> requestHeader = new HashMap<>();
                    String line;
                    while ((line = reader.readLine()) != null){

                        if(line.isBlank()){
                            break;
                        }

                        String key = line.split(": ")[0];
                        String value = line.split(": ")[1];

                        requestHeader.put(key, value);
                    }
                    System.out.println("requestHeader = " + requestHeader);

                    //body parsing when request method is POST
                    //요청 방식이 !POST!인 경우에만 body영역을 파싱해요~
                    String body = null;
                    if("POST".equals(requestMethod)){

                        int contentLength = Integer.parseInt(requestHeader.get("Content-Length"));
                        char[] temp = new char[contentLength];
                        reader.read(temp);
                        body = new String(temp).trim();
                    }
                    System.out.println("body = " + body);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}

//사용자가 어떤 내용을 보낼건지 보는 서버
//요청을 받을준비를 하는
//약속된 특정한 값을 받으면 다시 보내주는 역할

//클라이언트 가 서버에 요청 (아이피)
//주소창을 직접 연결할때 GET방식이다.

//was서버, DB서버

//GET방식은 url에 다 출력됨
//url 은 한정적인 길이를 가지고 있음.(255자)