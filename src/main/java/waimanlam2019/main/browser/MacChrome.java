package waimanlam2019.main.browser;

import org.slf4j.LoggerFactory;

import util.PropertyLoader;

public class MacChrome implements Browser {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(MacChrome.class);

	@Override
	public String getCacheLocation() {
		logger.info("Retrieving Mac Chrome cache location.");
		return PropertyLoader.getProperty("mac.chrome.cache.location");
	}

}
