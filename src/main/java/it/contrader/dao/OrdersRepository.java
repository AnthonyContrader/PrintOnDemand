package it.contrader.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Client;
import it.contrader.model.Orders;
import it.contrader.model.User;

@Repository
@Transactional
public interface OrdersRepository extends CrudRepository<Orders, Long> {

	Orders findById(long id);
	List<Orders> findByclientIn(List<Client> client);
}