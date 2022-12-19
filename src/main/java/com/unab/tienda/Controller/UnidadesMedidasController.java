package com.unab.tienda.Controller;

import com.unab.tienda.Collection.UnidadesMedidas;
import com.unab.tienda.IService.IUnidadesMedidasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/unidadesMedidas")

public class UnidadesMedidasController {

    @Autowired
    private IUnidadesMedidasService service;
    private UnidadesMedidas unidadesMedidas;

    @GetMapping
    public List <UnidadesMedidas> all(){
        return service.all();
    }

    @GetMapping("{id}")
    public Optional<UnidadesMedidas> show(@PathVariable String id){
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public UnidadesMedidas save(@RequestBody UnidadesMedidas unidadesMedidas){
        return service.save(unidadesMedidas);
    }


    @PutMapping("{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public UnidadesMedidas update(@PathVariable String id) {
        Optional<UnidadesMedidas>op= service.findById(id);

        if (!op.isEmpty()) {
            UnidadesMedidas unidadesMedidasUpdate = op.get();
            unidadesMedidasUpdate.setNombre(unidadesMedidas.getNombre());
            unidadesMedidasUpdate.setEstado(unidadesMedidas.getEstado());
            return service.save(unidadesMedidasUpdate);
        }
        return unidadesMedidas;
    }

    @DeleteMapping("{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id){
        service.delete(id);
    }

}