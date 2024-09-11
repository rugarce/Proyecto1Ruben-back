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
 * Esta clase representa una venta en el sistema.
 * Representa la tabla de la base de datos y se utiliza para mapear los datos entre el sistema y la base de datos.
 */

@Entity
@Table(name = "venta")
public class VentaEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
    private Long id;
	
	@Column(name = "id_producto")
    @Getter
    @Setter
	Long id_producto;
	
	@Column(name = "id_cliente")
    @Getter
    @Setter
	Long id_cliente;

    @ManyToOne
    @JoinColumn(name = "id_producto", insertable=false, updatable=false)
    @Getter
    @Setter
    private ProductoEntity producto;

    @ManyToOne
    @JoinColumn(name = "id_cliente", insertable=false, updatable=false)
    @Getter
    @Setter
    private ClienteEntity cliente;
}
