package com.unab.tienda.IService;


import com.unab.tienda.Collection.UnidadesMedidas;

import java.util.List;
import java.util.Optional;

public interface IUnidadesMedidasService {
    public List<UnidadesMedidas> all ();
    public Optional<UnidadesMedidas> findById(String id);
    public UnidadesMedidas save(UnidadesMedidas unidadesMedidas);
    public void delete(String id);

}
