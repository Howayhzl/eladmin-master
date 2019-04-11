package com.sk.waternetwork.config;

import com.sk.waternetwork.model.JSONMessageView;
import com.sun.xml.internal.ws.handler.HandlerException;
import org.springframework.asm.Handle;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.NativeWebRequest;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2019/3/7.
 */
@ResponseBody
@ControllerAdvice
public class ExceptionUnit {

    @ExceptionHandler(Exception.class)
    public JSONMessageView processUnauthenticatedException(HttpServletRequest request, Exception ex) {
        JSONMessageView json = new JSONMessageView();
        ExceptionModel model = new ExceptionModel();
        String className = request.getServerName();
        String methodName = request.getRequestURI();
        model.setIp("ip地址：" + className);
        model.setMethod("异常方法：" + methodName);
        model.setReason("异常原因：" + ex.getMessage());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time =sdf.format(new Date());
        model.setTime("异常时间：" + time);
        json.setCode(-10);
        json.setMessage("操作异常");
        json.setContent(model);
        System.out.println("ip地址：" + className);
        System.out.println("异常方法：" + methodName);
        System.out.println("异常原因：" + ex.getMessage());
        System.out.println("异常时间：" + time);
        return json; //返回一个逻辑视图名
    }
}
