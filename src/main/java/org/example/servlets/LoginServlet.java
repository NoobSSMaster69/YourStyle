//package org.example.servlets;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//import org.example.dao.UserDAOImpl;
//import org.example.models.User;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.io.IOException;
//
//@WebServlet("/login")
//public class LoginServlet extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//    private UserDAOImpl userDAO;
//    @Autowired
//    public LoginServlet(UserDAOImpl userDAO) {
//        this.userDAO = userDAO;
//    }
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        User user = new User();
//        user.setUserName(username);
//        user.setUserPass(password);
//
//        try {
//            if (userDAO.validate(loginBean)) {
//                //HttpSession session = request.getSession();
//                // session.setAttribute("username",username);
//                response.sendRedirect("loginsuccess.jsp");
//            } else {
//                HttpSession session = request.getSession();
//                //session.setAttribute("user", username);
//                //response.sendRedirect("login.jsp");
//            }
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//}