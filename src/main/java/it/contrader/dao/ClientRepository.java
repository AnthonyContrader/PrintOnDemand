package it.contrader.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.dto.UserDTO;
import it.contrader.model.Client;
import it.contrader.model.User;

@Repository
@Transactional
public interface ClientRepository extends CrudRepository<Client, Long> {

	Client findById(long id);
	List<Client> findAllByuser(User user);
}