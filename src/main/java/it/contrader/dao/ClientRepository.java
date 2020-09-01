package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Client;


@Repository
@Transactional
public interface ClientRepository extends CrudRepository<Client, Long>{

	Client findById(long id);
	
}
