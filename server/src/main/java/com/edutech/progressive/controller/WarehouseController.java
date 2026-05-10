package com.edutech.progressive.controller;

import com.edutech.progressive.entity.Warehouse;
import com.edutech.progressive.service.WarehouseService;
import com.edutech.progressive.service.impl.WarehouseServiceImplJpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/warehouse")
public class WarehouseController {
    
    @Autowired
    private WarehouseServiceImplJpa warehouseServiceImplJpa;

    @GetMapping
    public ResponseEntity<List<Warehouse>> getAllWarehouses() {
        return ResponseEntity.ok(warehouseServiceImplJpa.getAllWarehouses());
    }
    
    @GetMapping("/{warehouseId}")
    public ResponseEntity<Warehouse> getWarehouseById(@PathVariable int warehouseId) {
        return ResponseEntity.ok(warehouseServiceImplJpa.getWarehouseById(warehouseId));
    }  
    
    @PostMapping
    public ResponseEntity<Integer> addWarehouse(@RequestBody Warehouse warehouse) {
        return ResponseEntity.status(201).body(warehouseServiceImplJpa.addWarehouse(warehouse));
    }
    
    @PutMapping("/{warehouseId}")
    public ResponseEntity<Void> updateWarehouse(@PathVariable int warehouseId, @RequestBody Warehouse warehouse) {
        warehouseServiceImplJpa.updateWarehouse(warehouse);
        return ResponseEntity.ok().build();
    }
    
    @DeleteMapping("/{warehouseId}")
    public ResponseEntity<Void> deleteWarehouse(@PathVariable int warehouseId) {
        warehouseServiceImplJpa.deleteWarehouse(warehouseId);
        return ResponseEntity.status(204).build();
    }


    @GetMapping("/supplier/{supplierId}")
    public ResponseEntity<List<Warehouse>> getWarehousesBySupplier(@PathVariable int supplierId) {
        return ResponseEntity.ok(warehouseServiceImplJpa.getWarehouseBySupplier(supplierId));
    }
}