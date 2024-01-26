package com.ohgiraffers.base64;

import java.util.Base64;
import java.util.Base64.*;


public class EncodingDecoding {

    public static void main(String[] args){

        Encoder encode = Base64.getEncoder();
        Decoder decode = Base64.getDecoder();

        System.out.println("encode : "+ encode);
        System.out.println("decode" + decode);

        System.out.println();

        String testStr = "base64로인코딩한비밀키";

        byte[] testStrByteArr = testStr.getBytes();

        byte[] encodeByte = encode.encode(testStrByteArr);

        String encodeStr = new String(encodeByte);
        System.out.println("encoderStr = " + encodeStr);
        
        byte[] decodeByte = decode.decode(encodeStr);
        System.out.println("new String(decodeByte) = " + new String(decodeByte));
    }
}
