package main.controller;

import businesslogic.Login;
import businesslogic.LoginImplementation;
import models.ContentModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by fede0004@stud.kea.dk on 29-10-2016.
 */
public class ContentController extends HttpServlet {
	private static Logger logger = Logger.getLogger(Fredlet.class.getName());
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String newContent = request.getParameter("newContent");
		ContentModel content = new ContentModel(newContent);
		logger.log(Level.INFO, "doPost start...");
		logger.log(Level.INFO, newContent);
		Login login = new LoginImplementation();
		login.addContent(content);
		logger.log(Level.INFO, "alt godt");
		HttpSession session = request.getSession();
		List<ContentModel> contentList = login.fetchContent();
		session.setAttribute("contentList", contentList);
		String redirect = response.encodeRedirectURL(request.getContextPath() + "/loginSuccessAdmin.jsp");
		response.sendRedirect(redirect);
	}
}
