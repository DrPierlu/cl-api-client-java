package io.commercelayer.api.codegen;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.commercelayer.api.codegen.CodegenConfig.Module;

public final class ApiLicense {
	
	private static final String LICENSE_FILE = CodegenConfig.getProperty(Module.Source, "license.file");
	private static final String CHARSET = "UTF-8";

	private static final Logger logger = LoggerFactory.getLogger(ApiLicense.class);
	
	private static List<String> licenseLines;
	
	private ApiLicense() {
		
	}
	
	public static List<String> getTextLines() {
		if (licenseLines == null)
			try {
				readLicense();
			}
			catch (IOException ioe) {
				logger.error(ioe.getMessage(), ioe);
			}
		return licenseLines;
	}
	
	
	private static Path getLicenseFilePath() {
		return Paths.get("src/main/resources", "io/commercelayer/api/codegen/license", LICENSE_FILE);
	}
	
	private static List<String> readLicense() throws IOException {
		return licenseLines = Files.readAllLines(getLicenseFilePath(), Charset.forName(CHARSET));
	}
	
	public static void insertLicenseHeader(Path filePath) {
		
		try {
			
			List<String> oldLines = Files.readAllLines(filePath, Charset.forName(CHARSET));
			boolean hasCommentMarker = oldLines.get(0).startsWith("/**");
			
			List<String> newLines = new ArrayList<>();
			
			if (!hasCommentMarker) newLines.add("/**");
			for (String line : getTextLines()) {
				newLines.add(hasCommentMarker? line : " * ".concat(line));
			}
			if (!hasCommentMarker) newLines.add(" */");
			
			newLines.addAll(oldLines);
			
			Files.write(filePath, newLines, Charset.forName(CHARSET));
			
			logger.info("Added License header to file {}", filePath.getFileName());
			
		}
		catch (IOException ioe) {
			logger.error(ioe.getMessage(), ioe);
		}
		
	}
	
}
