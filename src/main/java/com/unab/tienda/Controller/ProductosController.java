package com.unab.tienda.Controller;

import com.unab.tienda.Collection.Productos;
import com.unab.tienda.IService.IProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/productos")

public class ProductosController {

    @Autowired
    private IProductosService service;
    private Productos productos;

    @GetMapping
    public List <Productos> all(){
        return service.all();
    }

    @GetMapping("{id}")
    public Optional<Productos> show(@PathVariable String id){
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Productos save(@RequestBody Productos productos){
        return service.save(productos);
    }


    @PutMapping("{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public Productos update(@PathVariable String id) {
        Optional<Productos>op= service.findById(id);

        if (!op.isEmpty()) {
            Productos productosUpdate = op.get();
            productosUpdate.setNombre(productos.getNombre());
            productosUpdate.setEstado(productos.getEstado());
            productosUpdate.setMarcaId(productos.getMarcaId());
            productosUpdate.setCategoriaId(productos.getCategoriaId());
            productosUpdate.setUnidadMedidaId(productos.getUnidadMedidaId());
            return service.save(productosUpdate);
        }
        return productos;
    }

    @DeleteMapping("{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id){
        service.delete(id);
    }

}