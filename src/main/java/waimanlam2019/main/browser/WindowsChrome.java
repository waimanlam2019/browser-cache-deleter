package waimanlam2019.main.browser;

import org.slf4j.LoggerFactory;

import util.PropertyLoader;

public class WindowsChrome implements Browser {

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(WindowsChrome.class);

	@Override
	public String getCacheLocation() {
		logger.info("Retrieving Windows Chrome cache location.");
		return PropertyLoader.getProperty("windows.chrome.cache.location");
	}

}
