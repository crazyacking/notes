package com.ht.util;

import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mail {
	
	public static void send(String strAddress) throws Exception {
		try {
			Properties pros = new Properties();
			pros.setProperty("mail.transport.protocol", "smtp");
			pros.setProperty("mail.smtp.auth", "true");

			Session session = Session.getInstance(pros);
			Transport transport = session.getTransport();
			Message msg = new MimeMessage(session);
			msg.setSubject("订单客户通知");
			msg.setFrom(InternetAddress.parse("hueter0@qq.com")[0]);
			msg.setSentDate(new Date(2011, 2, 28));
			msg.setText("您的商品已经发货,请登录查询订单详情");
			transport.connect("smtp.qq.com", "295813128@qq.com", "430000172790");
			Address[] address = new Address[1];
			address[0] =  new InternetAddress(strAddress);
			transport.sendMessage(msg, address);
			transport.close();
		} catch (Exception e) {

		}
	}
}