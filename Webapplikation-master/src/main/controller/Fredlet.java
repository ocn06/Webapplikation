package main.controller;
import businesslogic.Login;
import businesslogic.LoginImplementation;
import models.ContentModel;
import models.CredModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by fede0004@stud.kea.dk on 22-10-2016.
 */
public class Fredlet extends HttpServlet {
	private static Logger logger = Logger.getLogger(Fredlet.class.getName());
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		logger.log(Level.INFO, "doPost start...");
		logger.log(Level.INFO, "Username: " + username);
		logger.log(Level.INFO, "Password: " + password);
		logger.log(Level.INFO, "Checkbox: " + request.getParameter("rememberMe"));
		
		// TODO:
		// differentiate based on role
		Login login = new LoginImplementation();
		CredModel creds = login.fetchUser(username, password);
		if (creds != null) {
			List<ContentModel> contentList = login.fetchContent();
			request.setAttribute("contentList", contentList);
			if (creds.getRole().equals("admin")) {
				logger.log(Level.INFO, "creds valid as admin: " + creds.toString());
				RequestDispatcher rd=request.getRequestDispatcher("/loginSuccessAdmin.jsp");
				rd.forward(request, response);
			} else {		// normal user
				logger.log(Level.INFO, "creds valid: " + creds.toString());
				RequestDispatcher rd=request.getRequestDispatcher("/loginSuccess.jsp");
				rd.forward(request, response);
			}
		} else {
			logger.log(Level.INFO, "creds invalid");
			request.setAttribute("errorMessage", "true");
			RequestDispatcher rd=request.getRequestDispatcher("/index.jsp");
			rd.forward(request, response);
		}
		
	}
}
