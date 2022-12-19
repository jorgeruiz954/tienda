package com.unab.tienda.Controller;

import com.unab.tienda.Collection.Marcas;
import com.unab.tienda.IService.IMarcasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/marcas")

public class MarcasController {

    @Autowired
    private IMarcasService service;
    private Marcas marcas;

    @GetMapping
    public List <Marcas> all(){
        return service.all();
    }

    @GetMapping("{id}")
    public Optional<Marcas> show(@PathVariable String id){
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Marcas save(@RequestBody Marcas marcas){
        return service.save(marcas);
    }


    @PutMapping("{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public Marcas update(@PathVariable String id) {
        Optional<Marcas>op= service.findById(id);

        if (!op.isEmpty()) {
            Marcas marcasUpdate = op.get();
            marcasUpdate.setNombre(marcas.getNombre());
            marcasUpdate.setEstado(marcas.getEstado());
            return service.save(marcasUpdate);
        }
        return marcas;
    }

    @DeleteMapping("{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id){
        service.delete(id);
    }

}