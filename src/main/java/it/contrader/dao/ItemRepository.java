package it.contrader.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Client;
import it.contrader.model.Item;
import it.contrader.model.User;

@Repository
@Transactional
public interface ItemRepository extends CrudRepository<Item, Long> {

	Item findById(long id);
	List<Item> findAllByImmagineAndLink(String a,String b);
	List<Item> findAllBytipo(String a);

}
