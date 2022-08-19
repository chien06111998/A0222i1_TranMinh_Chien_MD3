import customer.customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    private static List<customer> customerList = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        customerList.add(new customer("Mai Van Hoang", "1983-08-20", "Ha Noi", 1));
        customerList.add(new customer("Nguyen Van Nam", "1983-08-21", "Bac Giang", 2));
        customerList.add(new customer("Nguyen Thai Hoang", "1983-08-22", "Nam Dinh", 3));
        customerList.add(new customer("Tran Dang Khoa", "1983-08-23", "Hoi An", 4));
        customerList.add(new customer("Nguyen Dinh Thi", "1983-08-24", "Da Nang", 5));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher =request.getRequestDispatcher("customer/list.jsp");
        request.setAttribute("customerList", customerList);
        requestDispatcher.forward(request, response);
    }

}
