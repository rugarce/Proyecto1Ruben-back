package com.P1.Proyecto1Ruben_back.provider;

import java.util.List;


import com.P1.Proyecto1Ruben_back.entity.ProveedorEntity;

public interface ProveedorProvider {
	ProveedorEntity findProveedorById(Long id);
	ProveedorEntity createProveedor(ProveedorEntity proveedor);
	ProveedorEntity updateProveedor(ProveedorEntity proveedor);
    void deleteProveedorById(Long id);
    public List<ProveedorEntity> allMProveedores();
}
