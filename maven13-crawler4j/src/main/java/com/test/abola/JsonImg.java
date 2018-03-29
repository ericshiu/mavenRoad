package com.test.abola;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringEscapeUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class JsonImg {
	public static void main(String[] args) {
		JsonImg.getPictures(1, "基隆港");
	}

	public static void getPictures(int page, String keyword) {
		String url = "http://image.baidu.com/search/avatarjson?tn=resultjsonavatarnew&ie=utf-8&word=" + keyword
				+ "&cg=star&pn=" + page * 30 + "&rn=30&itg=0&z=0&fr=&width=&height=&lm=-1&ic=0&s=0&st=-1&gsm="
				+ Integer.toHexString(page * 30);
		Document document;
		try {
			document = Jsoup.connect(url).data("query", "Java")// 请求参数
					.userAgent("Mozilla/4.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0)")// 设置urer-agent
																									// get();
					.timeout(5000).get();
			// 按指定模式在字符串查找
			String xmlSource = document.toString();
			xmlSource = StringEscapeUtils.unescapeHtml(xmlSource);
			// 创建 Pattern 对象
			String reg = "objURL\":\"http://.+?\\.jpg";
			Pattern pattern = Pattern.compile(reg);
			// 现在创建 matcher 对象
			Matcher m = pattern.matcher(xmlSource);
			while (m.find()) {
				String finalURL = m.group().substring(9);
				System.out.println(finalURL);
			}
		} catch (IOException e) {
		}
	}
}
