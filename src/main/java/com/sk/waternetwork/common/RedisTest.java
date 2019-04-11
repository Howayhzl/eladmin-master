package com.sk.waternetwork.common;

import com.sk.waternetwork.service.HomeService;
import com.sk.waternetwork.service.impl.HomeServiceImp;
import com.sk.waternetwork.viewModel.PipelineViewModel;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * Created by Administrator on 2019/3/15.
 */
public class RedisTest {
    public static List<PipelineViewModel> getgetPipelineByCompanyCode(String CompanyCode){
        Jedis jedis = new Jedis("114.116.99.96");
        jedis.auth("thinksoft@88");
        JSONArray jsonObject = JSONArray.fromObject(jedis.get(CompanyCode));
        List<PipelineViewModel> pipelineViewModelList=(List<PipelineViewModel>)jsonObject;
        return pipelineViewModelList;
    }
    public static void main(String[] args) {
        /*//连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");
        //查看服务是否运行
        System.out.println("服务正在运行: "+jedis.ping());*/
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("114.116.99.96");
        jedis.auth("thinksoft@88");
        System.out.println("连接成功");
        //存储数据到列表中
        /*jedis.lpush("site-list", "Runoob");
        jedis.lpush("site-list", "Google");
        jedis.lpush("site-list", "Taobao");
        // 获取存储的数据并输出
        List<String> list = jedis.lrange("site-list", 0 ,2);
        for(int i=0; i<list.size(); i++) {
            System.out.println("列表项为: "+list.get(i));
        }*/
        HomeService homeService = new HomeServiceImp();
        List<PipelineViewModel> pipelineViewModelList = homeService.getPipelineByCompanyCode("657D24644466ADA43DB0729A2CDF4EB4");
        /*JSONObject jsonObj = new JSONObject();
        for (int i = 0; i < pipelineViewModelList.size(); i++) {
            jsonObj.put(pipelineViewModelList.get(i).toString(), pipelineViewModelList.get(i));
        }
        String str =jsonObj.toString();*/
        JSONArray json = JSONArray.fromObject(pipelineViewModelList);
        String str =json.toString();
        jedis.set("657D24644466ADA43DB0729A2CDF4EB4",str);
        //System.out.println(jedis.get("pipelineViewModelList"));
        /*JSONObject jsonObject = JSONObject.fromObject(jedis.get("pipelineViewModelList"));
        Object  object=(Object)JSONObject.toBean(jsonObject);
        System.out.println(object);*/
    }
}
