package com.company.servlets;

import javax.servlet.ServletException;

import com.vaadin.server.BootstrapFragmentResponse;
import com.vaadin.server.BootstrapListener;
import com.vaadin.server.BootstrapPageResponse;
import com.vaadin.server.ServiceException;
import com.vaadin.server.SessionInitEvent;
import com.vaadin.server.SessionInitListener;
import com.vaadin.server.VaadinServlet;

public class TestJqueryVaadinServlet extends VaadinServlet {
	@Override
	protected void servletInitialized() throws ServletException {
		super.servletInitialized();
		getService().addSessionInitListener(new SessionInitListener() {
			@Override
			public void sessionInit(SessionInitEvent event) throws ServiceException {
				event.getSession().addBootstrapListener(new BootstrapListener() {
					@Override
					public void modifyBootstrapPage(BootstrapPageResponse response) {
						response.getDocument().head().prependElement("script").attr("type", "text/javascript").attr("src", "//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js");						
					}
					
					@Override
					public void modifyBootstrapFragment(BootstrapFragmentResponse response) {
					}
				});
			}
		});
	}
}
