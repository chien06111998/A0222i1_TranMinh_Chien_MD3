package controller;

import model.CustomerType;
import service.iCustomerTypeService;
import service.impl.customerTypeServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

@WebServlet(name = "CustomerTypeServlet", urlPatterns = "/customer_type")
public class CustomerTypeServlet extends HttpServlet {
    private iCustomerTypeService customerTypeService = new customerTypeServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action =request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                addNewCustomerType(request, response);
                break;
            case "delete":
                deleteCustomerType(request, response);
                break;
            case "update":
                editCustomerType(request, response);
                break;
            default:
                System.out.println("Action null.");
        }
    }

    private void editCustomerType(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("idCustomerType"));
        String name = request.getParameter("nameCustomerType");
        CustomerType customerType = new CustomerType(id, name);
        try {
            customerTypeService.update(customerType);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/customerType/updateCT.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            response.sendRedirect("/customer_type");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteCustomerType(HttpServletRequest request, HttpServletResponse response) {
        int idDelete = Integer.parseInt(request.getParameter("deleteId"));
        boolean check = false;
        try {
            check = customerTypeService.delete(idDelete);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        String mess ="Delete success.";
        if (!check){
            mess ="Delete failse.";
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/customerType/listCT.jsp");
        request.setAttribute("customerTypeList", this.customerTypeService.selectAll());
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            response.sendRedirect("/customer_type");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addNewCustomerType(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("idCustomerType"));
        String name = request.getParameter("nameCustomerType");
        CustomerType customerType = new CustomerType(id, name);
        Map<String, String> map = customerTypeService.add(customerType);
        String mess ="them moi  thanh cong";
        if (!map.isEmpty()){
            mess="Them moi khong thanh cong";
            request.setAttribute("error",map);
        }
        request.setAttribute("mess", mess);
        try {
            response.sendRedirect("/customer_type");
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
                showFormCreateCT(request, response);
                break;
            case "update":
                showFormUpdateCT(request, response);
                break;
            default:
                showListCT(request, response);
        }
    }

    private void showListCT(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/customerType/listCT.jsp");
        request.setAttribute("customerTypeList", this.customerTypeService.selectAll());
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormUpdateCT(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("idCustomerType"));
        CustomerType customerType = customerTypeService.selectCustomer(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customerType/updateCT.jsp");
        request.setAttribute("customerTypeList", customerType);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormCreateCT(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customerType/createCT.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
