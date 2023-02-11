package com.auto17.base.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auto17.base.utils.DateUtils;
import com.auto17.faceLogin.domain.AppUser;

import java.util.Calendar;

/**
 * @author
 */
public class JWTUtils {

    /**
     * get new token
     * @param user
     * @return token
     */
    public static String getToken(AppUser user) {
        Calendar instance = Calendar.getInstance();
        //Token expiration time
        instance.add(Calendar.DATE, 1);

        JWTCreator.Builder builder = JWT.create();

        return builder.withAudience(String.valueOf(user.getUserId()))
                .withClaim("userId", user.getUserId())
                .withClaim("facialId", user.getFacialId())
                .withExpiresAt(instance.getTime())
                .sign(Algorithm.HMAC256(user.getFacialId()));
    }

    /**
     * check token
     */
    public static DecodedJWT verify(String token,String key) {
        JWTVerifier build = JWT.require(Algorithm.HMAC256(key)).build();
        return build.verify(token);
    }

    public static Claim getClaimByName(String token, String name){
        return JWT.decode(token).getClaim(name);
    }

    public static String getAudience(String token){
        String audience = null;
        try {
            audience = JWT.decode(token).getAudience().get(0);
        } catch (JWTDecodeException j) {
            j.printStackTrace();
        }
        return audience;
    }

     public static void main(String[] args) {
         String timestamp="2023-02-10T04:35:55";
        System.out.println(DateUtils.dateTime("yyyy-MM-dd'T'HH:mm:ss",timestamp));
    }
}
