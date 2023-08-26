package br.com.matrix.shoppingapi.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.matrix.shoppingapi.model.Shop;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long> {

	List<Shop> findAllByUserIdentifier(String userIdentifier);
	
	List<Shop> findAllByTotalGreaterThan(float total);
	
	List<Shop> findAllByDateGreaterThan(LocalDateTime date);
}
