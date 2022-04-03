package bms.projectcrud.com.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class ProductoDto {
    @NotBlank
    private String nombre;
    @NotBlank
    private String categoria;
    @NotBlank
    private String fecha_ingreso;
    @NotBlank
    private String condicion;
    @NotBlank
    private String descripcion;
    @Min(0)
    private Float precio;

    public ProductoDto() {
    }

    public ProductoDto(String nombre, String categoria, String fecha_ingreso, String condicion, String descripcion, Float precio) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.fecha_ingreso = fecha_ingreso;
        this.condicion = condicion;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }
}
