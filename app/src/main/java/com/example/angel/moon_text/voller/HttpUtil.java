package com.example.angel.moon_text.voller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Angel on 2016/10/28.
 */

public class HttpUtil {
    private HttpURLConnection connection;

    public static String getUrlcontent(){
        StringBuffer sb = new StringBuffer();
        try {
            URL url = new URL("http://apis.juhe.cn/mobile/get?phone=13429667914&key=6978b1f7fed65bbb4d0d2ad96c73f191");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            //设置超时  如果超过5秒未连接  则连接中断
            connection.setConnectTimeout(5000);
            //如果响应码是200  则证明连接正确
            if (connection.getResponseCode() == 200){
                InputStream is = connection.getInputStream();
                byte[] b = new byte[1024];
                int len = 0;
               while ((len = is.read(b)) != -1){
                   sb.append(new String(b,0,len));
               }
                is.close();
                BufferedReader br = new BufferedReader(new InputStreamReader(is,"utf-8"));
                String line = "";
                while ((line = br.readLine()) != null){
                    sb.append(line);
                }
                br.close();
                connection.disconnect();//断开连接
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}

