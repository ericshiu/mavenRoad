package com.examples.test;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;

/***
 * 根據一項或多項授權給Apache軟件基金會（ASF）*貢獻者許可協議。請參閱隨附的通知文件*這項工作獲得有關版權所有權的更多信息。*ASF根據Apache許可證2.0版將此文件授權給您*（“許可證”）;除遵守規定外，您不得使用此文件*許可證。您可以在獲得許可證副本**http://www.apache.org/licenses/LICENSE-2.0
 ** 除非適用法律要求或書面同意，軟件*根據許可證分發的內容是“按原樣”分發的，*無任何明示或暗示的保證或條件。*請參閱許可證以了解特定語言的管理權限和權限*許可證下的限制。
 */

public class BasicCrawlController {

	public static void main(String[] args) throws Exception {

		/*
		 * crawlStorageFolder是中間爬網數據所在的文件夾 存儲。
		 */
		String crawlStorageFolder = args[0];

		/*
		 * numberOfCrawlers顯示應該有的並發線程數 開始抓取。
		 */
		int numberOfCrawlers = Integer.parseInt(args[1]);

		CrawlConfig config = new CrawlConfig();

		config.setCrawlStorageFolder(crawlStorageFolder);

		/*
		 * 要有禮貌：確保我們每次發送的請求不超過1次 秒（請求之間1000毫秒）。
		 */
		config.setPolitenessDelay(1000);

		/*
		 * 您可以在此設置最大爬網深度。默認值為-1,無限深度
		 */
		config.setMaxDepthOfCrawling(2);

		/*
		 * 您可以設置要抓取的最大頁數。默認值 為-1表示無限數量的頁面
		 */
		config.setMaxPagesToFetch(1000);

		/**
		 * 你想crawler4j也抓取二進制數據？ 例如：pdf的內容，或圖像的元數據等
		 */
		config.setIncludeBinaryContentInCrawling(false);

		/*
		 * 你需要設置代理嗎？如果是這樣，你可以使用： config.setProxyHost（“proxyserver.example.com”）;
		 * config.setProxyPort（8080）;
		 */

		/*
		 * 此配置參數可用於將您的爬網設置為可恢復 （表示您可以從之前恢復抓取 中斷/墜毀爬行）。注意：如果您啟用恢復功能和 想要開始一個新鮮的抓取，您需要刪除的內容
		 * 手動rootFolder。
		 */
		config.setResumableCrawling(false);

		/*
		 * 實例化此爬網的控制器。
		 */
		PageFetcher pageFetcher = new PageFetcher(config);
		RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
		RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
		CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);

		/*
		 * 對於每次爬網，您需要添加一些種子網址。這是第一個 抓取的網址，然後抓取工具開始跟踪鏈接 在這些頁面中找到
		 */
		controller.addSeed("http://www.ics.uci.edu/");
		// controller.addSeed("http://www.ics.uci.edu/~lopes/");
		// controller.addSeed("http://www.ics.uci.edu/~welling/");

		/*
		 * 開始爬行。這是一個阻止操作，意味著你的代碼 只有在抓取完成後才會到達此行。
		 */
		controller.start(BasicCrawler.class, numberOfCrawlers);
	}
}
