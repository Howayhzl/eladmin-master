package com.sk.waternetwork.baseModel;

/**
* Created by lujintao on 2019/2/11.
 * Http通信返回公共类
*/
public class HttpResponse<T> {

    //状态码
    private int code ;

    //消息
    private String message;

    //数据
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
