package br.com.matrix.shoppingapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.matrix.shoppingapi.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

}
