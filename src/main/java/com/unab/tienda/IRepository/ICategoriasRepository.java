package com.unab.tienda.IRepository;

import com.unab.tienda.Collection.Categorias;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ICategoriasRepository extends MongoRepository<Categorias, String> {

}
