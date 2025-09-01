package com.codegym.web;

import java.io.File;
import java.io.IOException;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.Wrapper;
import org.apache.catalina.startup.ContextConfig;
import org.apache.catalina.startup.Tomcat;
import org.apache.jasper.servlet.JasperInitializer;
import com.codegym.web.repository.InMemoryUserRepository;
import com.codegym.web.servlets.UserServlet;

public class TomcatMain {
  public static void main(String[] args) throws LifecycleException, IOException {
    Tomcat tomcat = new Tomcat();
    tomcat.setPort(8082);

    String baseDir = new File("target/tomcat").getAbsolutePath();
    tomcat.setBaseDir(baseDir);
    String webAppDir = new File("src/main/webapp").getCanonicalPath();
    new File(webAppDir).mkdirs();
    Context context = tomcat.addWebapp("", webAppDir);
    context.addWelcomeFile("index.jsp");
    context.addServletContainerInitializer(new JasperInitializer(), null);

    ContextConfig ctxCfg = new ContextConfig();
    context.addLifecycleListener(ctxCfg);
    ctxCfg.setDefaultWebXml("org/apache/catalina/startup/NO_DEFAULT_XML");
    context.setXmlValidation(false);
    context.setXmlNamespaceAware(false);


    InMemoryUserRepository inMemoryUserRepository = new InMemoryUserRepository();
    Wrapper jsp = Tomcat.addServlet(context, "jsp", "org.apache.jasper.servlet.JspServlet");
    jsp.addInitParameter("fork", "false");
    jsp.setLoadOnStartup(3);
    context.addServletMappingDecoded("*.jsp", "jsp");
    Tomcat.addServlet(context, "userServlet", new UserServlet(inMemoryUserRepository));
    context.addServletMappingDecoded("/users", "userServlet");
    context.addServletMappingDecoded("/users/new", "userServlet");
    context.addServletMappingDecoded("/users/create", "userServlet");
    context.addServletMappingDecoded("/users/update", "userServlet");
    context.addServletMappingDecoded("/users/edit", "userServlet");
    context.addServletMappingDecoded("/users/delete", "userServlet");

    tomcat.start();
    System.out.println("== Tomcat started on port " + tomcat.getConnector().getLocalPort());
    System.out.println("== Registered servlet mappings:");
    context.findChildren();
    for (String pattern : context.findServletMappings()) {
      String name = context.findServletMapping(pattern);
      System.out.println("   " + pattern + " -> " + name);
    }
    tomcat.getServer().await();
  }
}
