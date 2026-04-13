package com.edutech.progressive.controller;

import com.edutech.progressive.entity.Supplier;
import com.edutech.progressive.service.SupplierService;

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

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/supplier")
public class SupplierController {

    @Autowired
    SupplierService supplierService;

    @GetMapping
    public ResponseEntity<List<Supplier>> getAllSuppliers() {
        return null;
    }

    @GetMapping("/{supplierId}")
    public ResponseEntity<Supplier> getSupplierById(
            @PathVariable Integer supplierId) {
        return null;
    }

    @PostMapping
    public ResponseEntity<Integer> addSupplier(
            @RequestBody Supplier supplier) {
        return null;
    }

    @PutMapping("/{supplierId}")
    public ResponseEntity<Void> updateSupplier(
            @PathVariable Integer supplierId,
            @RequestBody Supplier supplier) {
        return null;
    }

    @DeleteMapping("/{supplierId}")
    public ResponseEntity<Void> deleteSupplier(
            @PathVariable Integer supplierId) {
        return null;
    }

    @GetMapping("/fromArrayList")
    public ResponseEntity<List<Supplier>> getAllSuppliersFromArrayList() throws SQLException {

        List<Supplier> list = supplierService.getAllSuppliers();

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/toArrayList")
    public ResponseEntity<Integer> addSupplierToArrayList(
            @RequestBody Supplier supplier) throws SQLException {

        int id = supplierService.addSupplier(supplier);

        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

    @GetMapping("/fromArrayList/all")
    public ResponseEntity<List<Supplier>> getAllSuppliersSortedByNameFromArrayList() throws SQLException {

        List<Supplier> sortedList = supplierService.getAllSuppliersSortedByName();

        return new ResponseEntity<>(sortedList, HttpStatus.OK);
    }
}