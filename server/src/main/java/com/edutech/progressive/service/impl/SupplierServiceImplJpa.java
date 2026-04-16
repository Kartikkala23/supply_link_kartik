package com.edutech.progressive.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edutech.progressive.entity.Supplier;
import com.edutech.progressive.exception.SupplierAlreadyExistsException;
import com.edutech.progressive.exception.SupplierDoesNotExistException;
import com.edutech.progressive.repository.SupplierRepository;
import com.edutech.progressive.service.SupplierService;

@Service
public class SupplierServiceImplJpa implements SupplierService {

    private SupplierRepository supplierRepository;

    @Autowired
    public SupplierServiceImplJpa(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    // ✅ ROLE CHECK METHOD
    private void validateRole(String role) {
        if (role == null || 
           (!role.equalsIgnoreCase("USER") && !role.equalsIgnoreCase("ADMIN"))) {
            throw new IllegalArgumentException("Role must be USER or ADMIN");
        }
    }

    public int addSupplier(Supplier supplier) {
        validateRole(supplier.getRole());

        if (supplierRepository.findByUsername(supplier.getUsername()) != null) {
            throw new SupplierAlreadyExistsException("Supplier already exists");
        }
        if (supplierRepository.findByEmail(supplier.getEmail()) != null) {
            throw new SupplierAlreadyExistsException("Supplier already exists");
        }

        return supplierRepository.save(supplier).getSupplierId();
    }

    public List<Supplier> getAllSuppliersSortedByName() {
        List<Supplier> suppliers = supplierRepository.findAll();
        Collections.sort(suppliers);
        return suppliers;
    }

    public void updateSupplier(int supplierId, Supplier supplier) {
        validateRole(supplier.getRole());

        Supplier existingByUsername =
                supplierRepository.findByUsername(supplier.getUsername());

        if (existingByUsername != null &&
            existingByUsername.getSupplierId() != supplierId) {
            throw new SupplierAlreadyExistsException("Username already taken");
        }

        Supplier updatedSupplier =
                supplierRepository.findBySupplierId(supplierId);

        if (updatedSupplier == null) {
            throw new SupplierDoesNotExistException("Supplier does not exist");
        }

        updatedSupplier.setSupplierName(supplier.getSupplierName());
        updatedSupplier.setEmail(supplier.getEmail());
        updatedSupplier.setPhone(supplier.getPhone());
        updatedSupplier.setAddress(supplier.getAddress());
        updatedSupplier.setUsername(supplier.getUsername());
        updatedSupplier.setPassword(supplier.getPassword());
        updatedSupplier.setRole(supplier.getRole());

        supplierRepository.save(updatedSupplier); // ✅ FIX
    }

    @Transactional
    public void deleteSupplier(int supplierId) {
        Supplier supplier = supplierRepository.findBySupplierId(supplierId);
        if (supplier == null) {
            throw new SupplierDoesNotExistException("Supplier does not exist");
        }
        validateRole(supplier.getRole());
        supplierRepository.deleteBySupplierId(supplierId);
    }

    public Supplier getSupplierById(int supplierId) {
        Supplier supplier = supplierRepository.findBySupplierId(supplierId);
        if (supplier == null) {
            throw new SupplierDoesNotExistException("Supplier does not exist");
        }
        return supplier;
    }
}
