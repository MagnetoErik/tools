package com.magneto.tools.application;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.magneto.tools.utils.HttpUtils;
import com.magneto.tools.utils.SendMailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


import java.util.Date;
import java.util.List;

@Component
@EnableScheduling
public class GetSCChinaMessageTask {

    @Autowired
    HttpUtils httpUtils;

    @Autowired
    SendMailUtils sendMailUtils;

    @Scheduled(cron = "*/1 * * * * ?")
    public void getSCChinaMessageTask() throws InterruptedException {
        String path = "https://news.dingxinwen.com/api/user/targetnews?tab=0&page=1&size=10&target=448508&token=&timestamp=1680599765&app_id=210710201732916889&sign=9403291834c571a51cc81eed78008472";
        JSONObject resString = JSON.parseObject(httpUtils.getReq(path));
        JSONObject firstResString = JSON.parseObject(resString.getJSONObject("data")
                .getObject("returnData", List.class)
                .get(0).toString());

        String title = firstResString.getObject("n_title", String.class);
        String displayTime = firstResString.getObject("display_time", String.class);
        if ((displayTime.equals("刚刚")&&(title.contains("百年")||title.contains("红馆")||title.contains("文化")))) {
            String setTo = "2227591877@qq.com";//收件人
            String setSubject = title;//邮件主题
            String setText = displayTime;//邮件内容
            sendMailUtils.sendMail(setTo, setSubject, setText);//发送邮件
            System.out.println(new Date());
            Thread.sleep(40*1000);
        }

    }




}
