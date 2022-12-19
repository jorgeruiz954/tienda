package com.unab.tienda.IRepository;

import com.unab.tienda.Collection.Marcas;
import org.springframework.data.mongodb.repository.MongoRepository;



public interface IMarcasRepository extends MongoRepository <Marcas, String> {

}
