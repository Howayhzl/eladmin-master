package com.sk.waternetwork.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpStatus;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.boot.autoconfigure.http.HttpProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.*;


/**
 * Copyright by Xunge Software 2018. All right reserved
 *
 * @author YangWL
 * @date 2019/3/4 0004
 * @Description:
 */
public class Message {


//    public static boolean httpPostWithJson(String Application,String AppId , String Platform ,String Content,String Mobile){
//        boolean isSuccess = false;
//
//        HttpPost post = null;
//        try {
//           HttpClient httpClient= new HttpClient();
//        /*    // 设置超时时间
//            httpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 2000);
//            httpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 2000);*/
//
//            post = new HttpPost("http://114.116.99.96:8070/ThinkSoftService/SMS/SendMsg");
//            // 构造消息头
//            post.setHeader("Content-type", "application/json; charset=utf-8");
//            post.setHeader("Connection", "Close");
//            String sessionId = getSessionId();
//            post.setHeader("SessionId", sessionId);
//            //post.setHeader("appId", "CJsNAs8yfuRb6h7A");
//
//            // 构建消息实体
//            StringEntity entity = new StringEntity(jsonObj.toString(), Charset.forName("UTF-8"));
//            entity.setContentEncoding("UTF-8");
//            // 发送Json格式的数据请求
//            entity.setContentType("application/json");
//            post.setEntity(entity);
//
//            HttpResponse response = ((DefaultHttpClient) httpClient).execute(post);
//
//            // 检验返回码
//            int statusCode = response.getStatusLine().getStatusCode();
//            if(statusCode != HttpStatus.SC_OK){
//                LogUtil.info("请求出错: "+statusCode);
//                isSuccess = false;
//            }else{
//                int retCode = 0;
//                String sessendId = "";
//                // 返回码中包含retCode及会话Id
//                for(Header header : response.getAllHeaders()){
//                    if(header.getName().equals("retcode")){
//                        retCode = Integer.parseInt(header.getValue());
//                    }
//                    if(header.getName().equals("SessionId")){
//                        sessendId = header.getValue();
//                    }
//                }
//
//                if(ErrorCodeHelper.IAS_SUCCESS != retCode ){
//
//                    isSuccess = false;
//                }else{
//                    isSuccess = true;
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            isSuccess = false;
//        }finally{
//            if(post != null){
//                try {
//                    post.releaseConnection();
//                    Thread.sleep(500);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        return isSuccess;
//    }

//    public static String getSessionId(){
//        UUID uuid = UUID.randomUUID();
//        String str = uuid.toString();
//        return str.substring(0, 8) + str.substring(9, 13) + str.substring(14, 18) + str.substring(19, 23) + str.substring(24);
//    }

  /*//public static final String url = "http://114.116.99.96:8070/ThinkSoftService/SMS/SendMsg";
    public static String sendMessage(String url, String params ) throws Exception {

        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);// 创建httpPost
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-Type", "application/json");
        String charSet = "UTF-8";
        StringEntity entity = new StringEntity(params, charSet);
        httpPost.setEntity(entity);
        CloseableHttpResponse response = null;

        try {

            response = httpclient.execute(httpPost);
            StatusLine status = response.getStatusLine();
            int state = status.getStatusCode();
            if (state == 0) {
              HttpEntity responseEntity=response.getEntity();
                String jsonString = EntityUtils.toString(responseEntity);
                return jsonString;
            }
            else{
                Logger.error("请求返回:"+state+"("+url+")");
            }
        }
        finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return ;
    }*/

    private    String application="waternet";
    private     String appId="CJsNAs8yfuRb6h7B";
    private     String platform="SX-SL-ZA";
    private String url = "http://114.116.99.96:8070/ThinkSoftService/SMS/SendMsg";
    //调用http接口
    @RequestMapping(value="http://114.116.99.96:8070/ThinkSoftService/SMS/SendMsg", method=RequestMethod.POST)
    public String sendMessage(String mobile,String content) throws Exception{
        String result = "";
        Param jsonObject = new Param();
        jsonObject.setAppId(appId);
        jsonObject.setApplication(application);
        jsonObject.setContent(content);
        jsonObject.setMobile(mobile);
        jsonObject.setPlatform(platform);
        String json = JSONObject.toJSONString(jsonObject);
        // 创建httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        // 创建post方式请求对象
        HttpPost httpPost = new HttpPost(url);
        StringEntity stringEntity = new StringEntity(json, ContentType.APPLICATION_JSON);
        stringEntity.setContentEncoding("utf-8");
        httpPost.setEntity(stringEntity);
        // 执行请求操作，并拿到结果（同步阻塞）
        CloseableHttpResponse response = httpClient.execute(httpPost);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK)
        {
            result = EntityUtils.toString(response.getEntity(), "utf-8");
        }
        // 释放链接
        response.close();
        return result;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }
}



