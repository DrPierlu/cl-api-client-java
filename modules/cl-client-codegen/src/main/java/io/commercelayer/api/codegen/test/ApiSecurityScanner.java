package io.commercelayer.api.codegen.test;

import java.io.IOException;
import java.net.URL;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.commercelayer.api.codegen.test.ApiSecurityMap.Permissions;
import io.commercelayer.api.util.CLInflector;

public class ApiSecurityScanner {
	
	private static final Logger logger = LoggerFactory.getLogger(ApiSecurityScanner.class);

	public ApiSecurityMap scan(URL clPermissionsPageUrl) throws IOException {
		return scan(clPermissionsPageUrl.toString());
	}
	
	public ApiSecurityMap scan(String clPermissionsPage) throws IOException {
		
		logger.info("Scanning HTML page from page: {}", clPermissionsPage);
		
		Document doc;
		try {
			doc = Jsoup.connect(clPermissionsPage).userAgent("Mozilla").get();
		} catch (IOException ioe) {
			logger.error("HTML page scan terminated with error: {}", ioe.getMessage());
			throw ioe;
		}

		Element acTable = getAccessControlTable(doc.body());
		
		// Get permissions rows
		Elements rows = acTable.getElementsByTag("tbody").first().children();
		
		ApiSecurityMap asMap = new ApiSecurityMap();
		
		logger.info("Found {} resources:", rows.size());
		
		for (Element row : rows) {
			
			Element td = row.children().first();
			
			String resource = CLInflector.getInstance().singularize(td.ownText());
			resource = StringUtils.remove(resource, ' ');
			td = td.nextElementSibling();
			
			boolean create = !td.getElementsByTag("i").isEmpty();
			td = td.nextElementSibling();
			
			boolean read = !td.getElementsByTag("i").isEmpty();
			td = td.nextElementSibling();
			
			boolean update = !td.getElementsByTag("i").isEmpty();
			td = td.nextElementSibling();
			
			boolean delete = !td.getElementsByTag("i").isEmpty();
			td = td.nextElementSibling();
			
			asMap.setResourcePermissions(resource, create, read, update, delete);
		
			logger.info("{} [create={}, read={}, update={}, delete={}]", resource, create, read, update, delete);
			
		}
		
		logger.info("HTML page scan succesfully terminated.");
		
//		logger.info("---------- ---------- ---------- ----------");
//		logResourcePermissions(asMap);
		
		return asMap;

	}
	
	@SuppressWarnings("unused")
	private void logResourcePermissions(ApiSecurityMap asMap) {
		logger.info("ApiSecurityMap resources:");
		for (Map.Entry<String, Permissions> entry : asMap.getPermissions().entrySet()) {
			logger.info("{} {}", entry.getKey(), entry.getValue());
		}
	}
	
	private Element getAccessControlTable(Element body) {
		
		Element cc = body.getElementsMatchingOwnText("^Client Credentials$").first();
		
		return cc.nextElementSibling().nextElementSibling();
		
	}

	public static void main(String[] args) {
		try {
			new ApiSecurityScanner().scan(new URL("https://commercelayer.io/api/reference/roles-and-permissions/"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
