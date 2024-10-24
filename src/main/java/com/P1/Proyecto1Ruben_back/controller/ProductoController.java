package com.P1.Proyecto1Ruben_back.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.P1.Proyecto1Ruben_back.dto.MessageResponseDto;
import com.P1.Proyecto1Ruben_back.dto.PaginadoDto;
import com.P1.Proyecto1Ruben_back.dto.ProductoAllDto;
import com.P1.Proyecto1Ruben_back.dto.ProductoDto;
import com.P1.Proyecto1Ruben_back.provider.ProductoProvider;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Valid;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import lombok.extern.slf4j.Slf4j;

/**
 * Controlador para manejar operaciones relacionadas con productos.
 * 
 * Este controlador expone rutas para realizar operaciones CRUD sobre productos.
 */

@RestController
@RequestMapping("/producto")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Slf4j
public class ProductoController {
	@Autowired
	private ProductoProvider provider;

	/**
	 * Obtiene todos los productos.
	 * 
	 * @return Un mensaje con la lista de todas las entidades producto, o un mensaje
	 *         de error ante cualquier excepcion.
	 */
	@GetMapping("/all")
	public MessageResponseDto<List<ProductoAllDto>> allProductos() {
		try {
			return MessageResponseDto.success(provider.allProducts());
		} catch (Exception e) {
			return MessageResponseDto.fail("Se ha producido un error");
		}
	}

	/**
	 * Crea un nuevo producto.
	 * 
	 * @param producto El objeto ProductoDto que contiene los detalles del nuevo
	 *                 producto.
	 * @return Un mensaje que contiene la entidad producto creada, o un mensaje de
	 *         error si algun dato introducido no existe.
	 */
	@PostMapping("/create")
	public Long createProduct(@Valid @RequestBody ProductoDto producto) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();


		Set<ConstraintViolation<ProductoDto>> violations = validator.validate(producto);
		if (!violations.isEmpty()) {
	    	for(ConstraintViolation<ProductoDto> violation: violations) {
	    		violation.getMessage();
	    	}
		}
		return provider.createProducto(producto);
	}

	/**
	 * Actualiza un producto existente.
	 * 
	 * @param id       El identificador del producto a actualizar.
	 * @param producto El objeto ProductoDto con los detalles actualizados del
	 *                 producto.
	 * @return Un mensaje que contiene la entidad producto actualizada, o un mensaje
	 *         de error si el producto no se encuentra.
	 */
	@PutMapping("/update/{id}")
	public MessageResponseDto<ProductoDto> updatePerson(@RequestBody ProductoDto producto) {
		try {
			return MessageResponseDto.success(provider.updateProducto(producto));
		} catch (EntityNotFoundException e) {
			return MessageResponseDto.fail(e.getMessage());
		}
	}

	/**
	 * Obtiene un producto por su identificador.
	 * 
	 * @param id El identificador del producto a obtener.
	 * @return Un mensaje que contiene la entidad producto si se encuentra, o un
	 *         mensaje de error si no se encuentra.
	 */
	@GetMapping("/{id}")
	public MessageResponseDto<ProductoAllDto> findbyId(@PathVariable Long id) {
		try {
			return MessageResponseDto.success(provider.findProductoById(id));
		} catch (EntityNotFoundException e) {
			return MessageResponseDto.fail(e.getMessage());
		}
	}

	/**
	 * Elimina un producto por su identificador.
	 * 
	 * @param id El identificador del producto a eliminar.
	 * @return Un mensaje exitoso si el producto fue eliminada exitosamente, o un
	 *         mensaje de error si el producto no se encuentra.
	 */
	@DeleteMapping("/delete/{id}")
	public MessageResponseDto<String> deletePerson(@PathVariable Long id) {
		try {
			provider.deleteProductoById(id);
			return MessageResponseDto.success("El producto con id " + id + " ha sido eliminado.");
		} catch (IllegalArgumentException e) {
			return MessageResponseDto.fail(e.getMessage());
		}
	}

	@GetMapping("/pagina")
	public MessageResponseDto<PaginadoDto<ProductoAllDto>> obtenerProductosPaginados(
			@RequestParam int NumPagina,
			@RequestParam int TamanoPagina, 
			@RequestParam(required = false) String nombre,
			@RequestParam(required = false) List<String> marcas, 
			@RequestParam(required = false) List<String> tiendas,
			@RequestParam(required = false) List<String> proveedores,
			@RequestParam(required = false) Float precio, 
			@RequestParam(required = false) Integer cantidad) {
		try {
			log.info("Recibidos: NumPagina={}, TamanoPagina={}, nombre={}, marcas={}, tiendas={}, proveedores={}, precio={}, cantidad={}",
		             NumPagina, TamanoPagina, nombre, marcas, tiendas, proveedores, precio, cantidad);
			return MessageResponseDto.success(provider.obtenerProductosPaginados(NumPagina, TamanoPagina,nombre,marcas,tiendas,proveedores, precio,cantidad));
		} catch (Exception e) {
			log.info("Error", e);
			return MessageResponseDto.fail("Se ha producido un error");
		}
	}

	@GetMapping("/buscar")
	public MessageResponseDto<List<ProductoAllDto>> buscarProductos(@RequestParam(required = false) String nombre,
			@RequestParam(required = false) String marca, @RequestParam(required = false) String tienda,
			@RequestParam(required = false) Float precio, @RequestParam(required = false) Integer cantidad) {
		try {
			return MessageResponseDto.success(provider.buscarProductos(nombre, marca, tienda, precio, cantidad));
		} catch (EntityNotFoundException e) {
			return MessageResponseDto.fail(e.getMessage());
		}
	}

}
