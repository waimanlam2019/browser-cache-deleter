package waimanlam2019.main.browser;

import org.slf4j.LoggerFactory;

import util.PropertyLoader;

public class MacVivaldi implements Browser {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(MacVivaldi.class);

	@Override
	public String getCacheLocation() {
		logger.info("Retrieving Mac Vivaldi cache location.");
		return PropertyLoader.getProperty("mac.vivaldi.cache.location");
	}

}
