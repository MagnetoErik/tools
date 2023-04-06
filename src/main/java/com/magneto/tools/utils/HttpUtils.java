package com.magneto.tools.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

@Component
public class HttpUtils {

    @Autowired
    private static RandomIpUtils randomIpUtils;

    public static String getReq(String path) {
        try {
            URL url = new URL(path);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setRequestMethod("GET");
            conn.setRequestProperty("setRequestProperty", randomIpUtils.getRandomIp());
            if (conn.getResponseCode() == 200) {
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String s = null;
                while ((s = in.readLine()) != null) {
                    return s;
                }
                in.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void postReq(String path, String args) {
        try {
            URL url = new URL(path);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            //发送数据
            conn.setDoOutput(true);
            OutputStream out = conn.getOutputStream();
            out.write(args.getBytes("UTF-8"));
            if (conn.getResponseCode() == 200) {
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String s = null;
                while ((s = in.readLine()) != null) {
                    System.out.println(s);
                }
                in.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void putReq(String path, String args) {
        try {
            URL url = new URL(path);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setRequestMethod("PUT");
            conn.setRequestProperty("Content-Type", "application/json");
            //发送数据
            conn.setDoOutput(true);
            OutputStream out = conn.getOutputStream();
            out.write(args.getBytes("UTF-8"));
            if (conn.getResponseCode() == 200) {
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String s = null;
                while ((s = in.readLine()) != null) {
                    System.out.println(s);
                }
                in.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteReq(String path) {
        try {
            URL url = new URL(path);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setRequestMethod("DELETE");
            if (conn.getResponseCode() == 200) {
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String s = null;
                while ((s = in.readLine()) != null) {
                    System.out.println(s);
                }
                in.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    public static String getLockShop(String path) {
        try {
            URL url = new URL(path);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setRequestMethod("GET");
            conn.setRequestProperty("setRequestProperty", randomIpUtils.getRandomIp());
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("authority", "sapi.hrce.commethod");
            conn.setRequestProperty("method", "GET");
            conn.setRequestProperty("path", "/api/buy/generate-order?salePrice=250&publishId=1431469");
            conn.setRequestProperty("scheme", "https");
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("accept-language", "zh-CN,zh;q=0.9,en;q=0.8,en-GB;q=0.7,en-US;q=0.6");
            conn.setRequestProperty("appid", "1007");
            conn.setRequestProperty("authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1aWQiOjMzMTI3NDYsInVOYW1lIjoi6YaJ57-B5Lqt6K6wIiwic2NvcGUiOjgsImV4cCI6MTY4MzA3NDA5NSwiaWF0IjoxNjgwNDgyMDk1fQ.Ql409bGMEgtbiUgpeH3b94xpDNRaKSjdUyYJb7H1sZs");
            if (conn.getResponseCode() == 200) {
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String s = null;
                while ((s = in.readLine()) != null) {
                    return s;
                }
                in.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
