package com.edutech.progressive.service.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.edutech.progressive.dao.WarehouseDAO;
import com.edutech.progressive.entity.Warehouse;
import com.edutech.progressive.service.WarehouseService;

public class WarehouseServiceImplJdbc implements WarehouseService {

    private WarehouseDAO warehouseDAO;

    public WarehouseServiceImplJdbc(WarehouseDAO warehouseDAO) {
        this.warehouseDAO = warehouseDAO;
    }

    @Override
    public List<Warehouse> getAllWarehouses() {
        return warehouseDAO.getAllWarehouse();
    }

    @Override
    public int addWarehouse(Warehouse warehouse) {
        return warehouseDAO.addWarehouse(warehouse);
    }

    @Override
    public List<Warehouse> getWarehousesSortedByCapacity() {
        List<Warehouse> sortWarehouses = warehouseDAO.getAllWarehouse();
        Collections.sort(sortWarehouses, Comparator.comparing(Warehouse::getCapacity));
        return sortWarehouses;
    }

    @Override
    public void updateWarehouse(Warehouse warehouse) {
        warehouseDAO.updateWarehouse(warehouse);
    }

    @Override
    public void deleteWarehouse(int warehouseId) {
        warehouseDAO.deleteWarehouse(warehouseId);
    }

    @Override
    public Warehouse getWarehouseById(int warehouseId) {
        return warehouseDAO.getWarehouseById(warehouseId);
    }

    @Override
    public List<Warehouse> getWarehouseBySupplier(int supplierId) {
        return null;
    }
}