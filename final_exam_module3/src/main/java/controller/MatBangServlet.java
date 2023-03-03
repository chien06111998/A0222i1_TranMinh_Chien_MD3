package controller;

import model.MatBang;
import service.iMatBangService;
import service.impl.matBangServiceImpl;

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

@WebServlet(name = "MatBangServlet", urlPatterns = "/matbang")
public class MatBangServlet extends HttpServlet {
    private iMatBangService matBangService = new matBangServiceImpl();

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

    private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String giaTien = request.getParameter("giaTien");
        System.out.println(giaTien);
        String soTang = request.getParameter("soTang");
        System.out.println(soTang);
        String loaiMb = request.getParameter("maLoai");
        System.out.println(loaiMb);
        List<MatBang> matBangs = matBangService.search(giaTien, soTang, loaiMb);
        RequestDispatcher requestDispatcher =request.getRequestDispatcher("view/list.jsp");
        request.setAttribute("giaTien", matBangs);
        request.setAttribute("soTang", matBangs);
        request.setAttribute("loaiMb", matBangs);
        requestDispatcher.forward(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idDelete = request.getParameter("deleteId");
        System.out.println(idDelete);
        boolean check = false;
        try {
            check = matBangService.delete(idDelete);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        String mess ="Delete success.";
        if (!check){
            mess ="Delete failse.";
        }
        request.setAttribute("mess", mess);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/list.jsp");
        request.setAttribute("matBangList", this.matBangService.selectAll());
        requestDispatcher.forward(request, response);
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) {
//        int id = Integer.parseInt(request.getParameter("id"));
//        String name = request.getParameter("name");
//        String birthDay = request.getParameter("birthday");
//        String gender = request.getParameter("gender");
//        String idCard = request.getParameter("idCard");
//        String phoneNumber = request.getParameter("phoneNumber");
//        String email = request.getParameter("email");
//        int customerTypeId = Integer.parseInt(request.getParameter("customerTypeId"));
//        String address = request.getParameter("address");
//        Customer customer = new Customer(id, name, birthDay, gender, idCard, phoneNumber, email, customerTypeId, address);
//        System.out.println(customer);
//        try {
//            customerService.update(customer);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/update.jsp");
//        try {
//            requestDispatcher.forward(request, response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        try {
//            response.sendRedirect("/resort");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
    private void addNew(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        int trangThai = Integer.parseInt(request.getParameter("idTrangThai"));
        double dienTich = Double.parseDouble(request.getParameter("dienTich"));
        int soTang = Integer.parseInt(request.getParameter("soTang"));
        int maLoai = Integer.parseInt(request.getParameter("maLoai"));
        String moTa = request.getParameter("moTa");
        int giaTien = Integer.parseInt(request.getParameter("giaTien"));
        String ngayThue = request.getParameter("ngayThue");
        String ngayTra = request.getParameter("ngayTra");
        MatBang matBang = new MatBang(id, trangThai, dienTich, soTang, maLoai, moTa, giaTien, ngayThue, ngayTra);
        Map<String, String> map = matBangService.add(matBang);
        String mess ="Them moi thanh cong.";
        if (!map.isEmpty()){
            mess = "Them moi that bai.";
            request.setAttribute("error",map);
        }
        request.setAttribute("mess", mess);
        RequestDispatcher requestDispatcher =request.getRequestDispatcher("view/create.jsp");
        requestDispatcher.forward(request, response);
        try {
            response.sendRedirect("/matbang");
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
//        request.setAttribute("matBangList", this.matBangService.selectAll());
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
        request.setAttribute("matBangList", this.matBangService.selectAll());
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormUpdate(HttpServletRequest request, HttpServletResponse response) {
//        int id = Integer.parseInt(request.getParameter("id"));
//        Customer customer = customerService.selectCustomer(id);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("view/update.jsp");
//        request.setAttribute("customerList", customer);
//        try {
//            dispatcher.forward(request, response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<MatBang> matBangList = matBangService.selectAll();
        request.setAttribute("matBangList", matBangList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/create.jsp");
        dispatcher.forward(request, response);
    }
}




