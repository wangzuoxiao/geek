package com.game.mj.jetty;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.eclipse.jetty.security.HashLoginService;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import org.eclipse.jetty.xml.XmlConfiguration;


public class JettyStarter {

	public static void main(String[] args) {
		startJetty();
	}

	private static void startJetty() {
		try {
			System.setProperty("org.apache.jasper.compiler.disablejsr199", "true");
			Server server = new Server();
			Properties p = new Properties(System.getProperties());
			p.load(ClassLoader.getSystemResourceAsStream("config.properties"));

			XmlConfiguration xmlConfig = new XmlConfiguration(ClassLoader.getSystemResourceAsStream("jetty.xml"));
			
			Map<String, String> props = new HashMap<>();
			for (Object key : p.keySet()) {
				props.put(key.toString(), String.valueOf(p.get(key)));
			}
			xmlConfig.getProperties().putAll(props);
			xmlConfig.configure();
			xmlConfig.configure(server);

			WebAppContext webAppContext = new WebAppContext();
			webAppContext.setInitParameter("org.eclipse.jetty.servlet.Default.dirAllowed", "false");// 禁止目录列表展现
			webAppContext.setInitParameter("org.eclipse.jetty.servlet.Default.redirectWelcome","false");// 禁止用redirect
			webAppContext.setResourceBase(p.getProperty("resourcebase"));
			webAppContext.setContextPath("/");
			HashLoginService dummyLoginService = new HashLoginService("TEST-SECURITY-REALM");
			webAppContext.getSecurityHandler().setLoginService(dummyLoginService);
			server.setHandler(webAppContext);
			server.start();
			server.join();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}
}
