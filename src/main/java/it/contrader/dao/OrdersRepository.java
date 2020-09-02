package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Orders;



@Repository
@Transactional
public interface OrdersRepository extends CrudRepository<Orders, Long>{

	Orders findById(long id);
	
}
