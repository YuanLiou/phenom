package liou.rayyuan.phenom.model.domain;

import com.google.gson.Gson;

import liou.rayyuan.phenom.model.entity._Token;

/**
 * Created by louis383 on 16/4/10.
 */
public class Token extends _Token {

    public static Token JSONDeserialization(String tokenString) {
        Gson gson = new Gson();
        return gson.fromJson(tokenString, Token.class);
    }

    public static String JSONSerialization(Token token) {
        Gson gson = new Gson();
        return gson.toJson(token);
    }

}
