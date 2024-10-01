package deleter;

import java.io.File;
import java.io.IOException;

import org.apache.tika.Tika;
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
			}else if (isRelatedFile(file) && fileIsOldEnough(file)){				
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
	
	private boolean isRelatedFile(File file) {
		Tika tika = new Tika();
        String mimeType;
		try {
			mimeType = tika.detect(file);
		} catch (IOException e) {
			logger.error("Error in checking file extension", e);
			return false;
		}
        
        logger.info("Detected MIME type: " + mimeType);

        // Check if MIME type is related to images or videos
        return mimeType.startsWith("image/") || mimeType.startsWith("video/");
	}
	
	private boolean fileIsOldEnough(File file) {
		return System.currentTimeMillis() -  file.lastModified() > fileLiveTimeInMilliSeconds;
	}
}
