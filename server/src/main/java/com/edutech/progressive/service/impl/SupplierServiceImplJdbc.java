package com.edutech.progressive.service.impl;

import java.sql.SQLException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.edutech.progressive.dao.SupplierDAO;
import com.edutech.progressive.entity.Supplier;
import com.edutech.progressive.service.SupplierService;

public class SupplierServiceImplJdbc implements SupplierService {
    private SupplierDAO supplierDAO;

    public SupplierServiceImplJdbc(SupplierDAO supplierDAO) {
        this.supplierDAO = supplierDAO;
    }

    @Override
    public List<Supplier> getAllSuppliers() throws SQLException {
        return supplierDAO.getAllSuppliers();
    }

    @Override
    public int addSupplier(Supplier supplier) throws SQLException {
        try {
            return supplierDAO.addSupplier(supplier);
        } catch (SQLException e) {
            throw e;
        } finally {

        }
    }

    @Override
    public List<Supplier> getAllSuppliersSortedByName() throws SQLException {
        try {
            List<Supplier> sortSuppliers = supplierDAO.getAllSuppliers();
            Collections.sort(sortSuppliers, Comparator.comparing(Supplier::getSupplierName));
            return sortSuppliers;
        } catch (SQLException e) {
            throw e;
        } finally {

        }
    }

    @Override
    public void updateSupplier(Supplier supplier) throws SQLException {
        try {
            supplierDAO.updateSupplier(supplier);
        } catch (SQLException e) {
            throw e;
        } finally {

        }
    }

    @Override
    public void deleteSupplier(int supplierId) throws SQLException {
        try {
            supplierDAO.deleteSupplier(supplierId);
        } catch (SQLException e) {
            throw e;
        } finally {
        }
    }

    @Override
    public Supplier getSupplierById(int supplierId) throws SQLException {
        try {
            return supplierDAO.getSupplierById(supplierId);
        } catch (SQLException e) {
            throw e;
        } finally {

        }
    }

}