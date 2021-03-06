package bms.projectcrud.com.controller;

import bms.projectcrud.com.dto.Mensaje;
import bms.projectcrud.com.dto.ProductoDto;
import bms.projectcrud.com.entity.Producto;
import bms.projectcrud.com.service.ProductoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
@CrossOrigin(origins = "http://localhost:4200/")
public class Controller {
    @Autowired
    ProductoService productoService;

    @GetMapping("/lista")
    public ResponseEntity<List<Producto>>list(){
        List<Producto>list=productoService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Producto>getById(@PathVariable("id")int id){
        if (!productoService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"),HttpStatus.NOT_FOUND);
        Producto producto=productoService.getOne(id).get();
        return new ResponseEntity<Producto>(producto,HttpStatus.OK);
    }

    @GetMapping("/detailname/{nombre}")
    public ResponseEntity<Producto>getByNombre(@PathVariable("nombre")String nombre){
        if (!productoService.existsByNombre(nombre))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        Producto producto=productoService.getByNombre(nombre).get();
        return new ResponseEntity(producto, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?>create(@RequestBody ProductoDto productoDto){
        if (StringUtils.isBlank(productoDto.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"),HttpStatus.BAD_REQUEST);
        if (StringUtils.isBlank(productoDto.getCategoria()))
            return new ResponseEntity(new Mensaje("La categoria del producto es obligatorio"), HttpStatus.BAD_REQUEST);
        if (StringUtils.isBlank(productoDto.getFecha_ingreso()))
            return new ResponseEntity(new Mensaje("La fecha de ingreso es obligatorio"), HttpStatus.BAD_REQUEST);
        if (StringUtils.isBlank(productoDto.getCondicion()))
            return new ResponseEntity(new Mensaje("Es obligatorio selecionar el campos"),HttpStatus.BAD_REQUEST);
        if (productoDto.getPrecio()==null || productoDto.getPrecio()<0)
            return new ResponseEntity(new Mensaje("El precio debe ser mayor que 0"),HttpStatus.BAD_REQUEST);
        if (StringUtils.isBlank(productoDto.getDescripcion()))
            return new ResponseEntity(new Mensaje("La descripcion del producto es obligatorio"), HttpStatus.BAD_REQUEST);
        if (productoService.existsByNombre(productoDto.getNombre()))
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"),HttpStatus.BAD_REQUEST);
        Producto producto=new Producto(productoDto.getNombre(),productoDto.getCategoria(),productoDto.getFecha_ingreso(),productoDto.getCondicion(),productoDto.getPrecio(), productoDto.getDescripcion());
        productoService.save(producto);
        return new ResponseEntity(new Mensaje("Producto Creado"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?>update(@PathVariable("id")int id, @RequestBody ProductoDto productoDto){
        if (!productoService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        if (productoService.existsByNombre(productoDto.getNombre()) && productoService.getByNombre(productoDto.getNombre()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"),HttpStatus.BAD_REQUEST);

        if (StringUtils.isBlank(productoDto.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"),HttpStatus.BAD_REQUEST);
        if (productoDto.getPrecio()==null || productoDto.getPrecio()<0)
            return new ResponseEntity(new Mensaje("El precio debe ser mayor que 0"),HttpStatus.BAD_REQUEST);
        Producto producto=productoService.getOne(id).get();
        producto.setNombre(productoDto.getNombre());
        producto.setPrecio(productoDto.getPrecio());
        producto.setCategoria(productoDto.getCategoria());
        producto.setFecha_ingreso(productoDto.getFecha_ingreso());
        producto.setCondicion(productoDto.getCondicion());
        producto.setDescripcion(productoDto.getDescripcion());
        productoService.save(producto);

        return new ResponseEntity(new Mensaje("Producto Actualizado"),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>delete(@PathVariable("id")int id){
        if (!productoService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"),HttpStatus.NOT_FOUND);
        productoService.delete(id);
        return new ResponseEntity(new Mensaje("Producto Eliminado"),HttpStatus.OK);
    }
}
