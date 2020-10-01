package controllers;

import serviceLayer.AddOnBLImpl;
import serviceLayer.CoffeeBLImpl;
import serviceLayer.SizeBLImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class IndexController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        CoffeeBLImpl coffeeBL = new CoffeeBLImpl();
        ArrayList<String> coffeeList = new ArrayList<>();

        SizeBLImpl sizeBL = new SizeBLImpl();
        ArrayList<String> sizeList = new ArrayList<>();

        AddOnBLImpl addOnBL = new AddOnBLImpl();
        ArrayList<String> addOnList = new ArrayList<>();

        System.out.println(session);
        try {
            coffeeList = coffeeBL.getAllCoffeeNames();
            sizeList = sizeBL.getAllSizeNames();
            addOnList = addOnBL.getAllAddOnNames();
            System.out.println(coffeeList);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        session.setAttribute("coffeeList", coffeeList);
        session.setAttribute("sizeList", sizeList);
        session.setAttribute("addOnList", addOnList);
        resp.sendRedirect("./menu.jsp");
    }
}
