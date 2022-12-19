package com.unab.tienda.IRepository;


import com.unab.tienda.Collection.UnidadesMedidas;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface IUnidadesMedidasRepository extends MongoRepository<UnidadesMedidas, String> {

}
