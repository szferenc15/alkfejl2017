package ca.irvine.cinema_world.util;

import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class Response<T>{
    public String error;
    public T data;

    public static <T> Response<T> ok(T data){
        return new Response<T>(null, data);
    }

    public static <T> Response<T> error(String message){
        return new Response<T>(message, null);
    }
}