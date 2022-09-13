package controller;

import model.Contract;
import model.Customer;
import service.iContractService;
import service.iCustomerService;
import service.impl.contractServiceImpl;
import service.impl.customerServiceImpl;

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

@WebServlet(name = "ContractServlet", urlPatterns = "/contract")
public class ContractServlet extends HttpServlet {
    private iCustomerService customerService = new customerServiceImpl();
    private iContractService contractService = new contractServiceImpl();

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
        String idContract = request.getParameter("idContract");
        String idCustomer = request.getParameter("idCustomer");
        List<Contract> contracts = contractService.search(idContract, idCustomer);
        RequestDispatcher requestDispatcher =request.getRequestDispatcher("view/contract/listC.jsp");
        List<Customer> customer = customerService.selectAll();
        request.setAttribute("contractList", contracts);
        request.setAttribute("customerList", customer);
        request.setAttribute("idContract", idContract);
        request.setAttribute("idCustomer", idCustomer);
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        String idDelete = request.getParameter("deleteId");
        boolean check = false;
        try {
            check = contractService.delete(idDelete);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        String mess ="Delete success.";
        if (!check){
            mess ="Delete failse.";
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/contract/listC.jsp");
        request.setAttribute("contractList", this.contractService.selectAll());
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        double deposit = Double.parseDouble(request.getParameter("deposit"));
        double totalMoney = Double.parseDouble(request.getParameter("totalMoney"));
        int idCustomer = Integer.parseInt(request.getParameter("idCustomer"));
        Contract contract = new Contract(id, startDate, endDate, deposit, totalMoney, idCustomer);
        System.out.println(contract);
        try {
            contractService.update(contract);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/contract/updateC.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            response.sendRedirect("/contract");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void addNew(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        double deposit = Double.parseDouble(request.getParameter("deposit"));
        double totalMoney = Double.parseDouble(request.getParameter("totalMoney"));
        int idCustomer = Integer.parseInt(request.getParameter("idCustomer"));
        Contract contract = new Contract(id, startDate, endDate, deposit, totalMoney, idCustomer);
        Map<String, String> map = contractService.add(contract);
//        String mess ="them moi  thanh cong";
        boolean mess = true;
        if (!map.isEmpty()){
            mess = false;
            request.setAttribute("error",map);
        }
        request.setAttribute("mess", mess);
        RequestDispatcher requestDispatcher =request.getRequestDispatcher("view/contract/createC.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            response.sendRedirect("/contract");
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
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/contract/searchC.jsp");
        request.setAttribute("customerList", this.customerService.selectAll());
        request.setAttribute("contractList", this.contractService.selectAll());
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/contract/listC.jsp");
        request.setAttribute("contractList", this.contractService.selectAll());
        request.setAttribute("customerList", this.customerService.selectAll());
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormUpdate(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Contract contract = contractService.selectContract(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/contract/updateC.jsp");
        request.setAttribute("contractList", contract);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customerList = customerService.selectAll();
        request.setAttribute("customerList", customerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/contract/createC.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
