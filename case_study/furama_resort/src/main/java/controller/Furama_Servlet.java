package controller;

import model.Customer;
import model.CustomerType;
import service.iCustomerService;
import service.iCustomerTypeService;
import service.impl.customerServiceImpl;
import service.impl.customerTypeServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "Furama_Servlet", urlPatterns = "/resort")
public class Furama_Servlet extends HttpServlet {
    private iCustomerService customerService = new customerServiceImpl();
    private iCustomerTypeService customerTypeService = new customerTypeServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action =request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                addNew(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
            case "update":
                edit(request, response);
                break;
            case "search":
                search(request, response);
                break;
            default:
                System.out.println("Action null.");
        }
    }

    private void search(HttpServletRequest request, HttpServletResponse response) {
        String idCustomer = request.getParameter("idCustomer");
        String nameCustomer = request.getParameter("nameCustomer");
        String idCustomerType = request.getParameter("idCustomerType");
        List<Customer> customer = customerService.search(idCustomer, nameCustomer, idCustomerType);
        RequestDispatcher requestDispatcher =request.getRequestDispatcher("view/list.jsp");
        List<CustomerType> customerTypes = customerTypeService.selectAll();
        request.setAttribute("customerList", customer);
        request.setAttribute("customerTypeList", customerTypes);
        request.setAttribute("idCustomer", idCustomer);
        request.setAttribute("nameCustomer", nameCustomer);
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        int idDelete = Integer.parseInt(request.getParameter("deleteId"));
        boolean check = false;
        try {
            check = customerService.delete(idDelete);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        String mess ="Delete success.";
        if (!check){
            mess ="Delete failse.";
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/list.jsp");
        request.setAttribute("customerList", this.customerService.selectAll());
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String birthDay = request.getParameter("birthday");
        String gender = request.getParameter("gender");
        String idCard = request.getParameter("idCard");
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        int customerTypeId = Integer.parseInt(request.getParameter("customerTypeId"));
        String address = request.getParameter("address");
        Customer customer = new Customer(id, name, birthDay, gender, idCard, phoneNumber, email, customerTypeId, address);
        System.out.println(customer);
        try {
            customerService.update(customer);
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
        try {
            response.sendRedirect("/resort");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void addNew(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String birthDay = request.getParameter("birthday");
        String gender = request.getParameter("gender");
        String idCard = request.getParameter("idCard");
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        int customerTypeId = Integer.parseInt(request.getParameter("customerTypeId"));
        String address = request.getParameter("address");
        Customer customer = new Customer(id, name, birthDay, gender, idCard, phoneNumber, email, customerTypeId, address);
        Map<String, String> map = customerService.add(customer);
//        String mess ="them moi  thanh cong";
        boolean mess = true;
        if (!map.isEmpty()){
            mess = false;
            request.setAttribute("error",map);
        }
        request.setAttribute("mess", mess);
        RequestDispatcher requestDispatcher =request.getRequestDispatcher("view/create.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            response.sendRedirect("/resort");
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
            case "search":
                showFormSearch(request, response);
            default:
                showList(request, response);
        }
    }

    private void showFormSearch(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/search.jsp");
        request.setAttribute("customerList", this.customerService.selectAll());
        request.setAttribute("customerTypeList", this.customerTypeService.selectAll());
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/list.jsp");
        request.setAttribute("customerList", this.customerService.selectAll());
        request.setAttribute("customerTypeList", this.customerTypeService.selectAll());
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
        Customer customer = customerService.selectCustomer(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/update.jsp");
        request.setAttribute("customerList", customer);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {
        List<CustomerType> customerTypeList = customerTypeService.selectAll();
        request.setAttribute("customerTypeList", customerTypeList);
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
