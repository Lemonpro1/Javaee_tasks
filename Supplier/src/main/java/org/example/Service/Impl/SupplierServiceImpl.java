package org.example.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.Service.SupplierService;
import org.example.Dao.SupplierDao;
import org.example.Entity.Supplier;
import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierDao supplierDao;

    @Override
    public List<Supplier> getAllSuppliers() {
        return supplierDao.getAllSuppliers();
    }

    @Override
    public Supplier getSupplierById(Long id) {
        return supplierDao.getSupplierById(id);
    }

    @Override
    public void createSupplier(Supplier supplier) {
        supplierDao.createSupplier(supplier);
    }

    @Override
    public void updateSupplier(Supplier supplier) {
        supplierDao.updateSupplier(supplier);
    }

    @Override
    public void deleteSupplier(Long id) {
        supplierDao.deleteSupplier(id);
    }
}
