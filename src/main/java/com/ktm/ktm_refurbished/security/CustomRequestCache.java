package com.ktm.ktm_refurbished.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.web.savedrequest.HttpSessionRequestCache;

class CustomRequestCache extends HttpSessionRequestCache {
//Zwischenspeicher, um Anfragen zu bearbeiten.
	@Override
	public void saveRequest(HttpServletRequest request, HttpServletResponse response) {

		if (!SecurityUtils.isFrameworkInternalRequest(request)) {
			super.saveRequest(request, response);
		}
	}

}