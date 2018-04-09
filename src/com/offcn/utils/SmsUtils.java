package com.offcn.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class SmsUtils {
	
	private static String x_id = "����˺�";
	private static String x_pwd = "�������";

	
	public static String SendSms(String mobile) throws UnsupportedEncodingException {
		
		//����6λ�����֤��
		String verification_code = getRandNum();
		//����ģ��
		String content = "�����֤����:"+verification_code;
		
		HttpURLConnection httpconn = null;
		StringBuilder sb = new StringBuilder();
		sb.append("http://service.winic.org:8009/sys_port/gateway/index.asp?");

		// �����ǲ���
		// Ϊ����Ĳ��Է����յ����ţ���������ݱ༭Ϊ�������֤��Ϊ��123456��������ͨ�š�
		sb.append("id=").append(URLEncoder.encode(x_id, "gb2312"));
		sb.append("&pwd=").append(x_pwd);
		sb.append("&to=").append(mobile);
		sb.append("&content=").append(URLEncoder.encode(content, "gb2312"));
		sb.append("&time=").append("");
		try {
			URL url = new URL(sb.toString());
			httpconn = (HttpURLConnection) url.openConnection();
			BufferedReader rd = new BufferedReader(new InputStreamReader(httpconn.getInputStream()));
			rd.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (httpconn != null) {
				httpconn.disconnect();
				httpconn = null;
			}
		}
		return verification_code;
	}

	public static String getRandNum() {
		int randNum = 1 + (int) (Math.random() * ((999999 - 1) + 1));
		return randNum + "";
	}

}
