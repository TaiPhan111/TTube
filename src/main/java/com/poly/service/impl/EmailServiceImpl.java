package com.poly.service.impl;

import javax.servlet.ServletContext;

import com.poly.entity.User;
import com.poly.service.EmailService;
import com.poly.util.SendEmailUtil;

public class EmailServiceImpl implements EmailService{
	private static final String EMAIL_WELCOME_SUBJECT = "Welcome to Online Entertaiment";
	private static final String EMAIL_FORGOT_PASSWORD = "Online Entertaiment - New passwword";

	@Override
	public void sendEmail(ServletContext context, User recipient, String type) {
		// TODO Auto-generated method stub
		String host = context.getInitParameter("host");
		String port = context.getInitParameter("port");
		String user = context.getInitParameter("user");
		String pass = context.getInitParameter("pass");
		
		try {
			String content= null;
			String subject= null;
			switch (type) {
			case "welcome":
				subject = EMAIL_WELCOME_SUBJECT;
				content = "Dear: "+ recipient.getUsername()+", hope you have a good time";
				break;
			case "forgot":
				subject = EMAIL_FORGOT_PASSWORD;
				content = "Dear: "+ recipient.getUsername()+", your new password here: "+recipient.getPassword();
				break;
			default:
				subject = "Online Entertaiment";
				content = "Maybe this email is wrong";
				break;
			}
			SendEmailUtil.sendEmail(host, port, user, pass,recipient.getEmail(), subject, content);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
