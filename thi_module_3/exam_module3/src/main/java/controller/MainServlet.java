package controller;

import model.Main;
import model.Second;
import service.iMainService;
import service.iSeconService;
import service.impl.mainServiceImpl;
import service.impl.seconServiceImpl;

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

@WebServlet(name = "MainServlet", urlPatterns = "/main")
public class MainServlet extends HttpServlet {
    private iMainService mainService = new mainServiceImpl();
    private iSeconService seconService = new seconServiceImpl();

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
        List<Main> main = mainService.search(giaTien, soTang, loaiMb);
        RequestDispatcher requestDispatcher =request.getRequestDispatcher("view/list.jsp");
        List<Second> secondList = seconService.selectAll();
        request.setAttribute("mainList", main);
        request.setAttribute("secondList", secondList);
        request.setAttribute("giaTien", giaTien);
        request.setAttribute("soTang", soTang);
//        request.setAttribute("loaiMb", loaiMb);
        requestDispatcher.forward(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idDelete = request.getParameter("deleteId");
        boolean check = false;
        try {
            check = mainService.delete(idDelete);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        String mess ="Delete success.";
        if (!check){
            mess ="Delete failse.";
        }
        request.setAttribute("mess", mess);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/list.jsp");
        request.setAttribute("mainList", this.mainService.selectAll());
        requestDispatcher.forward(request, response);
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        int trangThai = Integer.parseInt(request.getParameter("idNote"));
        int dienTich = Integer.parseInt(request.getParameter("dienTich"));
        int soTang = Integer.parseInt(request.getParameter("soTang"));
        int maLoai = Integer.parseInt(request.getParameter("idType"));
        String moTa = request.getParameter("moTa");
        int giaTien = Integer.parseInt(request.getParameter("giaTien"));
        String ngayThue = request.getParameter("ngayThue");
        String ngayTra = request.getParameter("ngayTra");
        Main main = new Main();
        try {
            mainService.update(main);
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
            response.sendRedirect("/main");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void addNew(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        int trangThai = Integer.parseInt(request.getParameter("idNote"));
        int dienTich = Integer.parseInt(request.getParameter("dienTich"));
        int soTang = Integer.parseInt(request.getParameter("soTang"));
        int maLoai = Integer.parseInt(request.getParameter("idType"));
        String moTa = request.getParameter("moTa");
        int giaTien = Integer.parseInt(request.getParameter("giaTien"));
        String ngayThue = request.getParameter("ngayThue");
        String ngayTra = request.getParameter("ngayTra");
        Main main = new Main();
        Map<String, String> map = mainService.add(main);
        String mess = "Them moi thanh cong.";
        if (!map.isEmpty()) {
            mess = "Them moi that bai.";
            request.setAttribute("error", map);
        }
        request.setAttribute("mess", mess);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/create.jsp");
        requestDispatcher.forward(request, response);
        try {
            response.sendRedirect("/main");
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
        request.setAttribute("secondList", this.seconService.selectAll());
//        request.setAttribute("noteList", this.typeNote.selectAll());
        request.setAttribute("mainList", this.mainService.selectAll());
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
        request.setAttribute("secondList", this.seconService.selectAll());
//        request.setAttribute("noteList", this.typeNote.selectAll());
        request.setAttribute("mainList", this.mainService.selectAll());
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
        Main main = mainService.select(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/update.jsp");
        request.setAttribute("mainList", main);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Main> matBangList = mainService.selectAll();
        request.setAttribute("secondList", this.seconService.selectAll());
//        request.setAttribute("noteList", this.typeNote.selectAll());
        request.setAttribute("mainList", this.mainService.selectAll());
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/create.jsp");
        dispatcher.forward(request, response);
    }
}
