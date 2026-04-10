package com.edutech.progressive.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Warehouse {
    
    private int warehouseId;
    private int supplierId;
    private String wareHouseName;
    private String location;
    private int capacity;
    public Warehouse() {
    }
    public Warehouse(int warehouseId, int supplierId, String wareHouseName, String location, int capacity) {
        this.warehouseId = warehouseId;
        this.supplierId = supplierId;
        this.wareHouseName = wareHouseName;
        this.location = location;
        this.capacity = capacity;
    }
    public int getWarehouseId() {
        return warehouseId;
    }
    public void setWarehouseId(int warehouseId) {
        this.warehouseId = warehouseId;
    }
    public int getSupplierId() {
        return supplierId;
    }
    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }
    public String getWareHouseName() {
        return wareHouseName;
    }
    public void setWareHouseName(String wareHouseName) {
        this.wareHouseName = wareHouseName;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    
}