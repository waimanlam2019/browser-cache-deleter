package waimanlam2019.main;

import org.slf4j.LoggerFactory;

import deleter.Deleter;
import waimanlam2019.main.browser.Browser;
import waimanlam2019.main.browser.MacChrome;
import waimanlam2019.main.browser.MacVivaldi;
import waimanlam2019.main.browser.WindowsChrome;

public class BrowserCacheDeleter {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(BrowserCacheDeleter.class);
	
	public static void main(String[] args) {
		Browser macChrome = new MacChrome();
		Browser macVivaldi = new MacVivaldi();
		Browser windowsChrome = new WindowsChrome();
		Deleter deleter = new Deleter();
		
		String os = System.getProperty("os.name").toLowerCase();
		logger.info("Current os : {}", os);
		if (os.contains("win")) {
			deleter.deleteCacheFromFolder(windowsChrome.getCacheLocation());
        } else if (os.contains("mac")) {
        	deleter.deleteCacheFromFolder(macChrome.getCacheLocation());
    		deleter.deleteCacheFromFolder(macVivaldi.getCacheLocation());
        } 
	}

}
