package com.unab.tienda.IRepository;

import com.unab.tienda.Collection.Productos;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IProductosRepository extends MongoRepository<Productos, String> {

}
