package bms.projectcrud.com.entity;

import javax.persistence.*;

@Entity
@Table(name = "producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name="categoria", nullable = false)
    private String categoria;
    @Column(name = "fecha_ingreso", nullable = false)
    private String fecha_ingreso;
    @Column(name = "condicion", nullable = false)
    private String condicion;
    @Column(name = "precio", nullable = false)
    private Float precio;
    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    public Producto() {

    }

    public Producto(String nombre, String categoria, String fecha_ingreso, String condicion, Float precio, String descripcion) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.fecha_ingreso = fecha_ingreso;
        this.condicion = condicion;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
