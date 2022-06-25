package controller.read;

import dao.BrandDAO;
import model.Brand;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ListServlet extends HttpServlet {

    private final BrandDAO brandDAO;
    public ListServlet(){
        super();
        brandDAO = new BrandDAO();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        doGet(req, resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            listBrand(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



    private void listBrand(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        List<Brand> listBrand = brandDAO.findAll();
        req.setAttribute("listBrand", listBrand);
        RequestDispatcher dispatcher = req.getRequestDispatcher("BrandList.jsp");

        dispatcher.forward(req, resp);
    }

}
