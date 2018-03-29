package com.examples.quickstart;

import java.util.Set;
import java.util.regex.Pattern;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;

public class MyCrawler extends WebCrawler {

	private final static Pattern FILTERS = Pattern.compile(".*(\\.(css|js|gif|jpg" + "|png|mp3|mp4|zip|gz))$");

	/**
	 * 此方法接收兩個參數。 第一個參數是頁面       *其中我們已經發現了這個新的url，第二個參數是       *新的網址。 你應該實現這個功能來指定是否      
	 * *給定的網址應該被抓取或不抓取（根據您的抓取邏輯）。       *在這個例子中，我們正在指示抓取工具忽略這個網址       *有CSS，JS，GIT，...擴展名，只接受啟動的網址
	 *       *與“http://www.ics.uci.edu/”。 在這種情況下，我們並不需要這個       *參考頁面參數做出決定。
	 * !FILTERS.matcher(href).matches() &&
	 */
	@Override
	public boolean shouldVisit(Page referringPage, WebURL url) {
		String href = url.getURL().toLowerCase();
		return href.startsWith("http://www.ics.uci.edu/");
	}

	/**
	 * 當一個頁面被提取並準備就緒時，這個函數被調用由您的程序處理。
	 */
	@Override
	public void visit(Page page) {
		String url = page.getWebURL().getURL();
		System.out.println("URL: " + url);

		if (page.getParseData() instanceof HtmlParseData) {
			HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();
			String text = htmlParseData.getText();
			String html = htmlParseData.getHtml();
			Set<WebURL> links = htmlParseData.getOutgoingUrls();

			System.out.println("Html length: " + html);
		}
	}
}
