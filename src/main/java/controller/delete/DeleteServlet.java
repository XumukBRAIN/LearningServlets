package controller.delete;

import dao.BrandDAO;
import model.Brand;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class DeleteServlet extends HttpServlet {

    private final BrandDAO brandDAO;
    public DeleteServlet(){
        super();
        brandDAO = new BrandDAO();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            deleteBrand(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void deleteBrand(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));

        Brand brand = new Brand(id);
        brandDAO.delete(brand);
        resp.sendRedirect("list");

    }
}
