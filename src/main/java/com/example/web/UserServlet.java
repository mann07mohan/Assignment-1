package com.example.web;

import java.io.IOException;
import java.sql.SQLException;
import java.time.OffsetDateTime;
import java.util.List;

import javax.persistence.criteria.Expression;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dao.UserDao;
import com.example.model.User;

@WebServlet("/")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao;
	
	public void init() {
		userDao = new UserDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertUser(request, response);
				break;
			case "/delete":
				deleteUser(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateUser(request, response);
				break;
			case "/cList":
				getUserByCriteria(request, response);
				break;
			case "/getCList":
				showUserByCriteria(request, response);
				break;
			default:
				listUser(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void getUserByCriteria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("criteria-form.jsp");
		dispatcher.forward(request, response);
		
	}
	
private void showUserByCriteria(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String key = request.getParameter("criteria");
		String value = request.getParameter("cValue");
		List<User> listUser = userDao.getAllUserByCriteria(key,value);
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
		dispatcher.forward(request, response);
	}

	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<User> listUser = userDao.getAllUser();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		User existingUser = userDao.getUser(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		request.setAttribute("user", existingUser);
		dispatcher.forward(request, response);

	}

	private void insertUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String name = request.getParameter("name");
		String salary = request.getParameter("salary");
		String age = request.getParameter("age");
		String gender = request.getParameter("gender");
		String mobile = request.getParameter("mobile");
		String status = "false";
		String createdBy = request.getParameter("name");
		OffsetDateTime createdOn = OffsetDateTime.now();
		
		User user = new User(name,salary,age,gender,mobile,status,createdBy,createdOn,null,null);
		userDao.saveUser(user);
		response.sendRedirect("list");
	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		
		User user = new User();
		user.setId(Integer.parseInt(request.getParameter("id")));
		user.setName(request.getParameter("name"));
		user.setSalary(request.getParameter("salary"));
		user.setAge(request.getParameter("age"));
		user.setGender(request.getParameter("gender"));
		user.setMobile(request.getParameter("mobile"));
		user.setStatus(request.getParameter("status"));
		user.setCreatedBy(request.getParameter("createdBy"));
		user.setCreatedOn(OffsetDateTime.parse(request.getParameter("createdOn")));
		user.setModifiedBy(request.getParameter("name"));
		user.setModifiedOn(OffsetDateTime.now());
		userDao.updateUser(user);
		response.sendRedirect("list");
	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		userDao.deleteUser(id);
		response.sendRedirect("list");
	}
}
