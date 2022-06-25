package controller.create;

import dao.BrandDAO;
import model.Brand;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class InsertServlet extends HttpServlet {

    private final BrandDAO brandDAO;
    public InsertServlet(){
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
            insertBrand(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void insertBrand(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException {

        String name = req.getParameter("name");
        String description = req.getParameter("description");
        String location = req.getParameter("location");
        int established = Integer.parseInt(req.getParameter("established"));

        Brand brand = new Brand(name, description, location, established);
        brandDAO.save(brand);
        resp.sendRedirect("list");

    }
}
