package controllers;

import serviceLayer.OrderBLImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        System.out.println(session);
        String coffeeNames[]=req.getParameterValues("coffee");
        String sizeNames[] = req.getParameterValues("size");
        String addOnNames[] = req.getParameterValues("addOn");
        String couponCode = req.getParameter("discountCode");

        ArrayList<String> coffees = new ArrayList<>();
        ArrayList<String> sizes = new ArrayList<>();
        ArrayList<String> addOns = new ArrayList<>();

        for (int i=0; i<coffeeNames.length; i++){
            coffees.add(coffeeNames[i]);
            sizes.add(sizeNames[i]);
            addOns.add(addOnNames[i]);
        }
        OrderBLImpl orderBL = new OrderBLImpl();
        double cost = 0;
        try {
            orderBL.addOrders(couponCode);
            orderBL.addOrderTransaction(coffees,sizes,addOns);
            cost = orderBL.generateBill();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        session.setAttribute("cost", cost);
        resp.sendRedirect("./finalbill.jsp");
    }
}
