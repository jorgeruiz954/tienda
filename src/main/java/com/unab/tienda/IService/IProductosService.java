package com.unab.tienda.IService;


import com.unab.tienda.Collection.Productos;

import java.util.List;
import java.util.Optional;

public interface IProductosService {
    public List<Productos> all ();
    public Optional<Productos> findById(String id);
    public Productos save(Productos productos);
    public void delete(String id);

}
