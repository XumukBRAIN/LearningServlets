package controller.update;

import dao.BrandDAO;
import model.Brand;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


public class UpdateServlet extends HttpServlet {

    private final BrandDAO brandDAO;
    public UpdateServlet(){
        super();
        brandDAO = new BrandDAO();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            updateBrand(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateBrand(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("brand_id"));
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        String location = req.getParameter("location");
        int established = Integer.parseInt(req.getParameter("established"));

        Brand brand = new Brand(id, name, description, location, established);
        brandDAO.update(brand);
        resp.sendRedirect("list");

    }
}
