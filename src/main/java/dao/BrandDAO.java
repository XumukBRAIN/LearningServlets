package dao;

import model.Brand;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BrandDAO implements Dao{
    @Override
    public Optional find(String id) throws SQLException {

        String sql = "SELECT brand_id, name, description, location, established FROM appliancesbrands WHERE brand_id = ?";
        int brand_id = 0, established = 0;
        String name = "", description = "", location = "";

        Connection connection;
        try {
            connection = DataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                brand_id = resultSet.getInt("brand_id");
                name = resultSet.getString("name");
                description = resultSet.getString("description");
                location = resultSet.getString("location");
                established = resultSet.getInt("established");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        return Optional.of(new Brand(brand_id, name, description, location, established));
    }

    @Override
    public List<Brand> findAll() throws SQLException {
        List<Brand> listBrand = new ArrayList<>();
        String sql = "SELECT * FROM appliancesbrands";

        Connection connection;
        try {
            connection = DataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                int id = resultSet.getInt("brand_id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                String location = resultSet.getString("location");
                int established = resultSet.getInt("established");

                Brand brand = new Brand(id, name, description, location, established);
                listBrand.add(brand);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return listBrand;
    }

    @Override
    public boolean save(Brand brand) throws SQLException {

        String sql = "INSERT INTO appliancesbrands (name, description, location, established) VALUES(?, ?, ?, ?)";
        boolean rowInserted = false;
        Connection connection;
        try {
            connection = DataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, brand.getName());
            statement.setString(2, brand.getDescription());
            statement.setString(3, brand.getLocation());
            statement.setInt(4, brand.getEstablished());
            rowInserted = statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return rowInserted;
    }

    @Override
    public boolean update(Brand brand) throws SQLException {

        String sql = "UPDATE appliancesbrands SET (name = ?, description = ?, location = ?, established = ?)";
        sql += "WHERE brand_id = ?";
        boolean rowUpdated = false;

        try {
            Connection connection = DataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, brand.getName());
            statement.setString(2, brand.getDescription());
            statement.setString(3, brand.getLocation());
            statement.setInt(4, brand.getEstablished());
            statement.setInt(5, brand.getId());
            rowUpdated = statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }

    @Override
    public boolean delete(Brand brand) throws SQLException {

        String sql = "DELETE FROM appliancesbrands WHERE brand_id = ?";
        boolean rowDeleted = false;

        try {
            Connection connection = DataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, brand.getId());
            rowDeleted = statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }
}
