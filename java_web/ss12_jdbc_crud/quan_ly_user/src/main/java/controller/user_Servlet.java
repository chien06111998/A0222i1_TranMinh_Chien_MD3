package controller;

import model.UserDao;
import service.iUserDaoService;
import service.impl.iUserDaoServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet(name = "user_Servlet", urlPatterns = "/user")
public class user_Servlet extends HttpServlet {
//    private UserDao userDao;
//
//    @Override
//    public void init() throws ServletException {
//        userDao = new UserDao();
//    }
    private iUserDaoService userDaoService = new iUserDaoServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action =request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                addNewUser(request, response);
                break;
            case "delete":
                deleteUser(request, response);
                break;
            case "update":
                editUser(request, response);
                break;
            default:
                System.out.println("Action null.");
        }
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) {
        int idDelete = Integer.parseInt(request.getParameter("idDelete"));
        try {
            userDaoService.deleteUser(idDelete);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        List<UserDao> userDaoList = userDaoService.selectAllUsers();
        request.setAttribute("userList", userDaoList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/list.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        boolean check = false;
//        try {
//            check = userDaoService.deleteUser(idDelete);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        String mess ="xoa thành công";
//        if (!check){
//            mess =" xoá không thành công";
//        }
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/list.jsp");
//        request.setAttribute("usertList", this.userDaoService.selectAllUsers());
//        try {
//            requestDispatcher.forward(request, response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    private void editUser(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        UserDao user = new UserDao(id, name, email, country);
        try {
            userDaoService.updateUser(user);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/update.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        UserDao userDao = this.userDaoService.findById(id);
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/update/jsp");
//        userDao.setName(name);
//        userDao.setEmail(email);
//        userDao.setCountry(country);
//        request.setAttribute("userList", userDao);
//        try {
//            requestDispatcher.forward(request, response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    private void addNewUser(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        UserDao userDao = new UserDao(name,email,country);
        Map<String, String>map = userDaoService.insertUser(userDao);
        String mess ="them moi  thanh cong";
        if (!map.isEmpty()){
            mess="Them moi khong thanh cong";
            request.setAttribute("error",map);
        }
        request.setAttribute("mess", mess);
        try {
            response.sendRedirect("/user");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action =request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showFormCreate(request, response);
                break;
            case "update":
                showFormUpdate(request, response);
                break;
            default:
                showListUser(request, response);
        }
    }

    private void showListUser(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/list.jsp");
        request.setAttribute("userList", this.userDaoService.selectAllUsers());
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void showFormUpdate(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        UserDao userDao = userDaoService.selectUser(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/update.jsp");
        request.setAttribute("userList", userDao);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
