package deleter;

import java.io.File;

import org.slf4j.LoggerFactory;

import util.PropertyLoader;

public class Deleter {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(Deleter.class);
	
	private static long fileLiveTimeInMilliSeconds;
	
	static {
		fileLiveTimeInMilliSeconds = Long.parseLong(PropertyLoader.getProperty("file.live.time.in.milliseconds"));
	}
	
	public void deleteCacheFromFolder(String folderPath) {
		logger.info("Loading files from folder {}", folderPath);
		
		File folder = new File(folderPath);
		if (!folder.exists()) {
			return;
		}

		File[] files = folder.listFiles();
		for (File file: files) {
			logger.debug("Checking file {}", file.getName());
			if ( file.isDirectory() ) {
				deleteCacheFromFolder(file.getAbsolutePath());
			}else {
				if (System.currentTimeMillis() -  file.lastModified() > fileLiveTimeInMilliSeconds) {
					logger.info("File {} has lived longer than expected time {} milliseconds, deleting", file.getAbsolutePath(), fileLiveTimeInMilliSeconds);
					boolean deleted = file.delete();
					if ( deleted ) {
						logger.info("Deleted cache file {}", file.getAbsolutePath());
					}else {
						logger.info("Cannot delete cache file {}", file.getAbsolutePath());
					}
				}
			}
		}
		
	}
}
