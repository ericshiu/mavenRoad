package com.test.abola;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.github.abola.crawler.CrawlerPack;

public class Test {

	public static void main(String[] args) {
		// 台南
		String AREA = "基隆";
		String uri = "https://www.tripadvisor.com.tw/Attractions-g317130-Activities-Keelung.html";
		// String uri = "https://www.tripadvisor.com.tw/Attractions-g293913-Activities-Taipei.html";
		ArrayList<org.jsoup.nodes.Element> a = CrawlerPack.start().getFromHtml(uri).select("a.poiTitle");
		for (int i = 0; i < a.size(); i++) {
			String nextUrl = "http://www.tripadvisor.com.tw" + a.get(i).attr("href");
			System.out.println(nextUrl);
			// 台灣省
			String countryName = CrawlerPack.start().getFromHtml(nextUrl).select("div.detail_section")
					.select("span.country-name").text();
			// 縣市
			String locality = CrawlerPack.start().getFromHtml(nextUrl).select("div.detail_section")
					.select("span.locality").text();
			// 詳細地址
			String streetAddress = CrawlerPack.start().getFromHtml(nextUrl).select("div.detail_section")
					.select("span.street-address").text();
			// 拼接地址
			String address = countryName + locality + streetAddress;
			System.out.println(address);
			ArrayList<org.jsoup.nodes.Element> contentArr = CrawlerPack.start().getFromHtml(nextUrl)
					.select("p.partial_entry");
			for (int index = 0; index < contentArr.size(); index++) {
				// 圖片網址 去google爬圖片
				// http://www.google.com.tw/search?hl=zh-TW&q=基隆忘憂谷&oq=基隆忘憂谷&tbm=isch
				String imgsUrl = "http://www.google.com.tw/search?hl=zh-TW&q=" + a.get(i).text()
						+ "&source=lnms&tbm=isch";
				System.out.println(imgsUrl);
				// // System.out.println(a.get(i).text() + ":" +
				// // contentArr.get(index).text().replaceAll("閱讀更多", ""));
				// // Test.aotoSql(a.get(i).text(), contentArr.get(index).text().replaceAll("閱讀更多",
				// // ""), AREA);
				// // System.out.println(contentArr.get(index).text().replaceAll("閱讀更多", ""));
			}
		}
	}

	public static void aotoSql(String title, String content, String AREA) {
		int a = (int) (Math.random() * 2018) + 1;
		int b = (int) (Math.random() * 9) + 1;
		int VOTE = (int) (Math.random() * 100) + 1;
		FileWriter v = null;
		try {
			v = new FileWriter("C:\\Users\\as110\\Desktop\\Test\\" + AREA + ".txt", true);
			v.write("insert into GUIDE (GUIDE_ID,MEM_ID,GUIDE_TITLE,GUIDE_CONTENT,GUIDE_AREA,GUIDE_READ_SIZE,GUIDE_COMM_SIZE,GUIDE_VOTE_SIZE,GUIDE_MAP) "
					+ "values ('G'||LPAD(to_char(GUIDE_pk_seq.NEXTVAL), 6, '0'),'M00000" + b + "','" + title + "','"
					+ content + "','" + AREA + "'," + a + ",0," + VOTE + ",'123');" + "\r\n");
			v.flush();
			v.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
