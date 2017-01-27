package de.digitalcollections.iiif.serverdemo.interceptor;

import de.digitalcollections.iiif.serverdemo.service.DemoPresentationServiceImpl;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class ServerUrlInterceptor extends HandlerInterceptorAdapter {

  private static final Logger LOGGER = LoggerFactory.getLogger(ServerUrlInterceptor.class);

  @Autowired
  DemoPresentationServiceImpl demoPresentationServiceImpl;

  //before the actual handler will be executed
  @Override
  public boolean preHandle(HttpServletRequest request,
          HttpServletResponse response, Object handler)
          throws Exception {
    String requestUrl = request.getRequestURL().toString();
    if (requestUrl.endsWith("/manifest")) {
      String contextPath = request.getContextPath();
      String serverUrl = requestUrl.substring(0, requestUrl.indexOf(contextPath));
      demoPresentationServiceImpl.setServerUrl(serverUrl);
    }
    return true;
  }
}
