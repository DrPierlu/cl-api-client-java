package io.commercelayer.api.util;

import java.net.InetAddress;
import java.net.UnknownHostException;

public final class NetUtils {

	private NetUtils() {
		super();
	}
	
	public static String getHostName() {

		try {
			InetAddress addr = InetAddress.getLocalHost();
			return addr.getHostName();			
		}
		catch (UnknownHostException ex) {
			LogUtils.singleErrorMessage(NetUtils.class, "Hostname can not be resolved");
			return null;
		}

	}
	
}
