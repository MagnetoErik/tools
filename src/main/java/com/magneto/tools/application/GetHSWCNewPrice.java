package com.magneto.tools.application;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.magneto.tools.utils.HttpUtils;
import com.magneto.tools.utils.RandomIpUtils;
import com.magneto.tools.utils.SendMailUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * 获取华数最新的售价
 */
@Component
@EnableScheduling
public class GetHSWCNewPrice {

    final static String setTo = "2227591877@qq.com";

    @Autowired
    HttpUtils httpUtils;

    @Autowired
    private SendMailUtils sendMailUtils;

    @Test
    @Scheduled(cron = "*/1 * * * * ?")
    public void getPrice()  {

        String selectFirstStr = "https://sapi.hrce.com/api/publish/product/listV1?pageNum=1&pageSize=30&listOrder=1&productId=";
        String selectEndStr = "&makerId=&isSid=0&matchKey=";

        Map<String, Integer> items = new HashMap<>();
        items.put("贵州种植基地", 12254);
        items.put("创世-红馆", 12128);
        items.put("AI中医-厚朴", 12090);
        items.put("我和我的祖国", 11716);
        items.put("3D《百年经典留声机》", 11292);
        items.put("虎守健康", 12152);
        items.put("小红心觉醒", 12268);
        items.put("红馆信念徽章", 12250);
        items.put("医圣张仲景", 12028);
        items.put("十全大补汤", 11873);
        items.put("针灸鼻祖皇甫谧", 12141);
        items.put("药王孙思邈", 12017);
        items.put("医祖扁鹊像", 11325);
        items.put("神医华佗像", 11243);
        items.put("六味地黄丸", 11975);
        items.put("药圣李时珍", 12000);
        items.put("麻沸散", 11410);
        items.put("虎守中医药博物馆", 12253);
        items.put("宇宙之晶-岫", 12236);
        items.put("《百年荣光》-纸艺", 12201);
        items.put("兔宝贝-圆圆", 12153);
        items.put("兔宝贝-团团", 12154);
        //items.put("东方之子印记",12128);


        Set<Map.Entry<String, Integer>> set = items.entrySet();
        for (Map.Entry<String, Integer> entry : set) {
            try {
                JSONObject resString = JSON.parseObject(httpUtils.getReq(selectFirstStr + entry.getValue() + selectEndStr));
                JSONObject firstResString = JSON.parseObject(resString.getJSONObject("data")
                        .getJSONObject("pageInfo")
                        .getObject("list", List.class)
                        .get(0).toString());
                String ID = firstResString.getObject("id", String.class);
                String productName = firstResString.getObject("productName", String.class);
                Integer publishPrice = firstResString.getObject("publishPrice", Integer.class);
                String doBalanceFirstStr = "https://sapi.hrce.com/api/buy/generate-order?salePrice=";
                String doBalanceEndStr = "&publishId=";
                System.out.println(productName+"\t"+publishPrice);
                switch (productName) {
                    case "贵州种植基地":
                        if (publishPrice <= 180) {
                            sendMailUtils.sendMail(setTo, "【" + productName + "】:" + "【" + publishPrice.toString() + "】", "");
                            HttpUtils.getLockShop(doBalanceFirstStr + publishPrice + doBalanceEndStr + ID);
                            Thread.sleep(180 * 1000);
                        }
                        break;
                    case "创世-红馆":
                        if (publishPrice <= 8400) {
                            sendMailUtils.sendMail(setTo, "【" + productName + "】:" + "【" + publishPrice.toString() + "】", "");
                            HttpUtils.getLockShop(doBalanceFirstStr + publishPrice + doBalanceEndStr + ID);
                            Thread.sleep(180 * 1000);
                        }
                        break;
                    case "AI中医-厚朴":
                        if (publishPrice <= 700) {
                            sendMailUtils.sendMail(setTo, "【" + productName + "】:" + "【" + publishPrice.toString() + "】", "");
                            HttpUtils.getLockShop(doBalanceFirstStr + publishPrice + doBalanceEndStr + ID);
                            Thread.sleep(180 * 1000);
                        }
                        break;
                    case "我和我的祖国":
                        if (publishPrice <= 600) {
                            sendMailUtils.sendMail(setTo, "【" + productName + "】:" + "【" + publishPrice.toString() + "】", "");
                            HttpUtils.getLockShop(doBalanceFirstStr + publishPrice + doBalanceEndStr + ID);
                            Thread.sleep(180 * 1000);
                        }
                        break;
                    case "3D《百年经典留声机》":
                        if (publishPrice <= 300) {
                            sendMailUtils.sendMail(setTo, "【" + productName + "】:" + "【" + publishPrice.toString() + "】", "");
                            HttpUtils.getLockShop(doBalanceFirstStr + publishPrice + doBalanceEndStr + ID);
                            Thread.sleep(180 * 1000);
                        }
                        break;
                    case "虎守健康":
                        if (publishPrice <= 1500) {
                            sendMailUtils.sendMail(setTo, "【" + productName + "】:" + "【" + publishPrice.toString() + "】", "");
                            HttpUtils.getLockShop(doBalanceFirstStr + publishPrice + doBalanceEndStr + ID);
                            Thread.sleep(180 * 1000);
                        }
                        break;
                    case "小红心觉醒":
                        if (publishPrice <= 220) {
                            sendMailUtils.sendMail(setTo, "【" + productName + "】:" + "【" + publishPrice.toString() + "】", "");
                            HttpUtils.getLockShop(doBalanceFirstStr + publishPrice + doBalanceEndStr + ID);
                            Thread.sleep(180 * 1000);
                        }
                        break;
                    case "红馆信念徽章":
                        if (publishPrice <= 200) {
                            sendMailUtils.sendMail(setTo, "【" + productName + "】:" + "【" + publishPrice.toString() + "】", "");
                            HttpUtils.getLockShop(doBalanceFirstStr + publishPrice + doBalanceEndStr + ID);
                            Thread.sleep(180 * 1000);
                        }
                        break;
                    case "医圣张仲景":
                        if (publishPrice <= 180) {
                            sendMailUtils.sendMail(setTo, "【" + productName + "】:" + "【" + publishPrice.toString() + "】", "");
                            HttpUtils.getLockShop(doBalanceFirstStr + publishPrice + doBalanceEndStr + ID);
                            Thread.sleep(180 * 1000);
                        }
                        break;
                    case "十全大补汤":
                        if (publishPrice <= 180) {
                            sendMailUtils.sendMail(setTo, "【" + productName + "】:" + "【" + publishPrice.toString() + "】", "");
                            HttpUtils.getLockShop(doBalanceFirstStr + publishPrice + doBalanceEndStr + ID);
                            Thread.sleep(180 * 1000);
                        }
                        break;
                    case "针灸鼻祖皇甫谧":
                        if (publishPrice <= 180) {
                            sendMailUtils.sendMail(setTo, "【" + productName + "】:" + "【" + publishPrice.toString() + "】", "");
                            HttpUtils.getLockShop(doBalanceFirstStr + publishPrice + doBalanceEndStr + ID);
                            Thread.sleep(180 * 1000);
                        }
                        break;
                    case "药王孙思邈":
                        if (publishPrice <= 180) {
                            sendMailUtils.sendMail(setTo, "【" + productName + "】:" + "【" + publishPrice.toString() + "】", "");
                            HttpUtils.getLockShop(doBalanceFirstStr + publishPrice + doBalanceEndStr + ID);
                            Thread.sleep(180 * 1000);
                        }
                        break;
                    case "医祖扁鹊像":
                        if (publishPrice <= 180) {
                            sendMailUtils.sendMail(setTo, "【" + productName + "】:" + "【" + publishPrice.toString() + "】", "");
                            HttpUtils.getLockShop(doBalanceFirstStr + publishPrice + doBalanceEndStr + ID);
                            Thread.sleep(180 * 1000);
                        }
                        break;
                    case "神医华佗像":
                        if (publishPrice <= 180) {
                            sendMailUtils.sendMail(setTo, "【" + productName + "】:" + "【" + publishPrice.toString() + "】", "");
                            HttpUtils.getLockShop(doBalanceFirstStr + publishPrice + doBalanceEndStr + ID);
                            Thread.sleep(180 * 1000);
                        }
                        break;
                    case "六味地黄丸":
                        if (publishPrice <= 180) {
                            sendMailUtils.sendMail(setTo, "【" + productName + "】:" + "【" + publishPrice.toString() + "】", "");
                            HttpUtils.getLockShop(doBalanceFirstStr + publishPrice + doBalanceEndStr + ID);
                            Thread.sleep(180 * 1000);
                        }
                        break;
                    case "药圣李时珍":
                        if (publishPrice <= 180) {
                            sendMailUtils.sendMail(setTo, "【" + productName + "】:" + "【" + publishPrice.toString() + "】", "");
                            HttpUtils.getLockShop(doBalanceFirstStr + publishPrice + doBalanceEndStr + ID);
                            Thread.sleep(180 * 1000);
                        }
                        break;
                    case "麻沸散":
                        if (publishPrice <= 180) {
                            sendMailUtils.sendMail(setTo, "【" + productName + "】:" + "【" + publishPrice.toString() + "】", "");
                            HttpUtils.getLockShop(doBalanceFirstStr + publishPrice + doBalanceEndStr + ID);
                            Thread.sleep(180 * 1000);
                        }
                        break;
                    case "虎守中医药博物馆":
                        if (publishPrice <= 400) {
                            sendMailUtils.sendMail(setTo, "【" + productName + "】:" + "【" + publishPrice.toString() + "】", "");
                            HttpUtils.getLockShop(doBalanceFirstStr + publishPrice + doBalanceEndStr + ID);
                            Thread.sleep(180 * 1000);
                        }
                        break;
                    case "宇宙之晶-岫":
                        if (publishPrice <= 550) {
                            sendMailUtils.sendMail(setTo, "【" + productName + "】:" + "【" + publishPrice.toString() + "】", "");
                            HttpUtils.getLockShop(doBalanceFirstStr + publishPrice + doBalanceEndStr + ID);
                            Thread.sleep(180 * 1000);
                        }
                        break;
                    case "《百年荣光》-纸艺":
                        if (publishPrice <= 780) {
                            sendMailUtils.sendMail(setTo, "【" + productName + "】:" + "【" + publishPrice.toString() + "】", "");
                            HttpUtils.getLockShop(doBalanceFirstStr + publishPrice + doBalanceEndStr + ID);
                            Thread.sleep(180 * 1000);
                        }
                        break;
                    case "兔宝贝-圆圆":
                        if (publishPrice <= 300) {
                            sendMailUtils.sendMail(setTo, "【" + productName + "】:" + "【" + publishPrice.toString() + "】", "");
                            HttpUtils.getLockShop(doBalanceFirstStr + publishPrice + doBalanceEndStr + ID);
                            Thread.sleep(180 * 1000);
                        }
                        break;
                    case "兔宝贝-团团":
                        if (publishPrice <= 300) {
                            sendMailUtils.sendMail(setTo, "【" + productName + "】:" + "【" + publishPrice.toString() + "】", "");
                            HttpUtils.getLockShop(doBalanceFirstStr + publishPrice + doBalanceEndStr + ID);
                            Thread.sleep(180 * 1000);
                        }
                        break;
                    default:
                        System.out.println(productName+"名称不一致");
                }
            } catch (Exception e) {
                System.out.println("已退市");
            }

        }
    }


    @Scheduled(cron = "0 0 * * * ?")
    public void task() {
        System.out.println(new Date() + "--------------------------------------------");
    }

}

