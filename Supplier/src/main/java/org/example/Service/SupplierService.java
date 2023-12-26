package org.example.Service;

import org.example.Entity.Supplier;

import java.util.List;

public interface SupplierService {
    List<Supplier> getAllSuppliers();
    Supplier getSupplierById(Long id);
    void createSupplier(Supplier supplier);
    void updateSupplier(Supplier supplier);
    void deleteSupplier(Long id);
}
