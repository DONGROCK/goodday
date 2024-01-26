package com.ohgiraffers.base64;

import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;

import java.security.Key;

public class JsonWebTokenSecretKey {

    /*
     * JWT (JSON Web Token)
     * 인증에 필요한 정보들을 암호화시킨 JSON토큰을 의미한다.
     * --> JWT 기반 인증은 JWT토큰(Access Token)을 http헤더에 담아 서버가 클라이언트를 식별하게 하는 방식이다.
     *
     * JWT는 JSON데이터를 Base64 URL-safe Encode를 통해 인코딩하여 직렬화한 것으로 토큰 내부에는 위/변조 방지를 위한 개인키를
     * 통한 전자 서명 또한 담겨있다.
     *
     *  * JWT(JSON Web Token)의 구조 (xxxxxx.yyyyy.zzzzzz)
     * 1. 헤더(Header)
     *    - typ: 토큰의 타입 지정(JWT)
     *    - alg: 해싱 알고리즘으로 Signature에서 사용 됨
     *
     * 2. 내용 또는 정보(Payload)
     *    - 토큰에 담을 정보가 들어 있음
     *  - 인코딩된 정보의 비트를 claim이라고 부름
     *  - 담는 정보의 한 조각을 클레임(claim - name과 value의 쌍으로 구성)이라 칭함
     *       a. 등록된 클레임(registered claim)
     *          : 토큰에 대한 정보가 담김
     *           (iss: 토큰 발급자(issuer)
     *            sub: 토큰 제목(subject)
     *            aud: 토큰 대상자(audience)
     *            exp: 토큰의 만료시간(expiration)
     *            nbf: 토큰 활성화(발급) 날짜(not before)
     *            iat: 토큰 활성화(발급) 시간(issued at))
     *      b. 공개 클레임(public claim) : 사용자가 정의할 수 있는 클레임 정보 전달을 위해서 사용
     *      c. 비공개 클레임(private claim) : 해당하는 당사자들 간에 정보를 공유하기 위해 만들어진 사용자 지정 클레임, 외부에
     *                                     공개되도 상관없지만 해당 유저를 특정할 수 있는 정보들을 담는다.
     * 3. 서명(Signature)
     *    - Header 인코딩 값과 Payload 인코딩 값을 합쳐서 비밀키로 해쉬하여 생성
     *
     *    Header와 Payload는 단순하게 인코딩된 값이기 때문에 조작을 할 수 있지만 Signature는 서버측에서 관리하는
     *    비밀키가 유출되지 않는 이상 복호화할 수 없다.
     *
     * */

    public static void main(String[] args) {
    /*JWT의 비밀키 생성(HMAC-SHA 알고리즘 적용) - 최소한의 길이로 랜덤 키 생성된다.*/

        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS512);
//        Key key = Keys.hmacShaKeyFor(SignatureAlgorithm)
        //BASE64로 인코딩
        String secretKey = Encoders.BASE64.encode(key.getEncoded());
        System.out.println("생성된 비밀키 = " + secretKey);

        /*JWT 토큰 생성*/
        String jws = Jwts.builder().setSubject("{\"name\": \"monkey\"}").signWith(key).compact();
        System.out.println("생성된 JWT 토큰 = " + jws);

        if (verifyToken(jws, secretKey)){
            System.out.println("토큰 인증댐");
        }
    }
    private static boolean verifyToken(String accessToken, final String secretKey) {

        boolean validation = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(accessToken).getBody().getSubject().equals("{\"name\": \"monkey\"}");

        if (!validation) {
            throw new RuntimeException("토큰 인증 되지 않음");
        }

        return true;
    }

}
