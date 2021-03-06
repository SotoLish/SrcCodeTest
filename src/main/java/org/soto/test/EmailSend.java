package org.soto.test;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: liuqixin
 * @date: 2020/12/24 17:37
 */
public class EmailSend {

    public static void main(String[] args) throws EmailException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        SimpleEmail email = new SimpleEmail();
        email.setHostName("smtp.163.com");
        email.setAuthentication("sotolish@163.com", "XHBSMIYITJBQJPCC");//邮件服务器验证：用户名/密码
        email.setCharset("UTF-8");// 必须放在前面，否则乱码
        email.addTo("qixin.liu@hand-china.com");
        email.setFrom("sotolish@163.com", "邮件发送测试");
        email.setSubject("赔偿单统计信息-" + sdf.format(new Date()));
        StringBuilder msgInfo = new StringBuilder();
        msgInfo.append("赔偿单统计信息如下：").append("\r\n\t");
        msgInfo.append("1、待赔付数量：4").append("\r\n\t");
        msgInfo.append("2、赔付中数量：5").append("\r\n\t");
        msgInfo.append("3、赔付失败数量：6").append("\r\n\t");
        msgInfo.append("统计时间：").append(sdf.format(new Date()));
        email.setMsg(msgInfo.toString());
        email.send();

    }
}
