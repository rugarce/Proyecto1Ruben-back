package com.P1.Proyecto1Ruben_back.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * Esta clase representa un producto en el sistema.
 * Representa la tabla de la base de datos y se utiliza para mapear los datos entre el sistema y la base de datos.
 */

@Entity
@Table(name = "producto")
public class ProductoEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
    private Long id;
	
	@Getter
    @Setter
    private String nombre;

	@Getter
    @Setter
	@Column(name = "id_marca")
	Long id_marca;
	
	@Getter
    @Setter
	@Column(name = "id_proveedor")
	Long id_proveedor;
	

	@Getter
    @Setter
	@Column(name = "id_tienda")
	Long id_tienda;
	
    @ManyToOne
    @JoinColumn(name = "id_marca", insertable=false, updatable=false)
    @Getter
    @Setter
    private MarcaEntity marca;

    @ManyToOne
    @JoinColumn(name = "id_proveedor", insertable=false, updatable=false)
    @Getter
    @Setter
    private ProveedorEntity proveedor;

    @ManyToOne
    @JoinColumn(name = "id_tienda", insertable=false, updatable=false)
    @Getter
    @Setter
    private TiendaEntity tienda;

    @Getter
    @Setter
    private float precio;
    @Getter
    @Setter
    private int cantidad;
}
