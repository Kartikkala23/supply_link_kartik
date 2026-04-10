package com.edutech.progressive.service.impl;

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
    public List<Supplier> getAllSuppliers() {
        return supplierDAO.getAllSuppliers();
    }

    @Override
    public int addSupplier(Supplier supplier) {
        return supplierDAO.addSupplier(supplier);
    }

    @Override
    public List<Supplier> getAllSuppliersSortedByName() {
        List<Supplier> suppliers = supplierDAO.getAllSuppliers();
        Collections.sort(suppliers, Comparator.comparing(Supplier::getSupplierName));
        return suppliers;
    }

    @Override
    public void updateSupplier(Supplier supplier) {
        supplierDAO.updateSupplier(supplier);
    }

    @Override
    public void deleteSupplier(int supplierId) {
        supplierDAO.deleteSupplier(supplierId);
    }

    @Override
    public Supplier getSupplierById(int supplierId) {
        return supplierDAO.getSupplierById(supplierId);
    }

}
