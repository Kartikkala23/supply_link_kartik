package com.edutech.progressive.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.edutech.progressive.config.DatabaseConnectionManager;
import com.edutech.progressive.entity.Supplier;

public class SupplierDAOImpl implements SupplierDAO {

    @Override
    public int addSupplier(Supplier supplier) throws SQLException {
        int generatedID = -1;

        String sql = "INSERT INTO supplier (supplier_name, email, phone, username, password, address, role) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, supplier.getSupplierName());
            statement.setString(2, supplier.getEmail());
            statement.setString(3, supplier.getPhone());
            statement.setString(4, supplier.getUsername());
            statement.setString(5, supplier.getPassword());
            statement.setString(6, supplier.getAddress());
            statement.setString(7, supplier.getRole());

            statement.executeUpdate();

            try (ResultSet resultSet = statement.getGeneratedKeys()) {
                if (resultSet.next()) {
                    generatedID = resultSet.getInt(1);
                    supplier.setSupplierId(generatedID);
                }
            }
        }

        return generatedID;
    }

    @Override
    public Supplier getSupplierById(int supplierId) throws SQLException {
        String sql = "SELECT * FROM supplier WHERE supplier_id = ?";

        try (Connection connection = DatabaseConnectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, supplierId);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String supplierName = resultSet.getString("supplier_name");
                    String email = resultSet.getString("email");
                    String phone = resultSet.getString("phone");
                    String username = resultSet.getString("username");
                    String password = resultSet.getString("password");
                    String address = resultSet.getString("address");
                    String role = resultSet.getString("role");

                    return new Supplier(supplierId, supplierName, email, phone, username, password, address, role);
                }
            }
        }

        return null;
    }

    @Override
    public void updateSupplier(Supplier supplier) throws SQLException {
        String sql = "UPDATE supplier SET supplier_name = ?, email = ?, phone = ?, username = ?, password = ?, address = ?, role = ? WHERE supplier_id = ?";

        try (Connection connection = DatabaseConnectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, supplier.getSupplierName());
            statement.setString(2, supplier.getEmail());
            statement.setString(3, supplier.getPhone());
            statement.setString(4, supplier.getUsername());
            statement.setString(5, supplier.getPassword());
            statement.setString(6, supplier.getAddress());
            statement.setString(7, supplier.getRole());
            statement.setInt(8, supplier.getSupplierId());

            statement.executeUpdate();
        }
    }

    @Override
    public void deleteSupplier(int supplierId) throws SQLException {
        String sql = "DELETE FROM supplier WHERE supplier_id = ?";

        try (Connection connection = DatabaseConnectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, supplierId);
            statement.executeUpdate();
        }
    }

    @Override
    public List<Supplier> getAllSuppliers() throws SQLException {
        List<Supplier> suppliers = new ArrayList<>();
        String sql = "SELECT * FROM supplier";

        try (Connection connection = DatabaseConnectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int supplierId = resultSet.getInt("supplier_id");
                String supplierName = resultSet.getString("supplier_name");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String address = resultSet.getString("address");
                String role = resultSet.getString("role");

                suppliers.add(new Supplier(supplierId, supplierName, email, phone, username, password, address, role));
            }
        }

        return suppliers;
    }
}