package br.com.matrix.shoppingapi.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.matrix.shoppingapi.dto.ShopDTO;
import br.com.matrix.shoppingapi.model.Shop;
import br.com.matrix.shoppingapi.repositories.ShopRepository;

@Service
public class ShopService {

	@Autowired
	private ShopRepository shopRepository;
	
	public List<ShopDTO> getAll(){
		List<Shop> shops = shopRepository.findAll();
		return shops.stream().map(ShopDTO::convert).collect(Collectors.toList());
	}
	
	public List<ShopDTO> getByUser(String userIdentifier){
		List<Shop> shops = shopRepository.findAllByUserIdentifier(userIdentifier);
		return shops.stream().map(ShopDTO::convert).collect(Collectors.toList());
	}
	
	public List<ShopDTO> getByDate(ShopDTO shopDTO){
		List<Shop> shops = shopRepository.findAllByDateGreaterThan(shopDTO.getDate());
		return shops.stream().map(ShopDTO::convert).collect(Collectors.toList());
	}
	
	public ShopDTO findById(Long ProductId) {
		Optional<Shop> shop = shopRepository.findById(ProductId);
		if (shop.isPresent()) {
			return ShopDTO.convert(shop.get());
		}
		return null;
	}
	
	public ShopDTO save(ShopDTO shopDTO) {
		shopDTO.setTotal(shopDTO.getItems()
				.stream()
				.map(x-> x.getPrice())
				.reduce((float) 0, Float::sum));
		
		Shop shop = Shop.convert(shopDTO);
		shop.setDate(LocalDateTime.now());
		
		shop =shopRepository.save(shop);
		return ShopDTO.convert(shop);
	}
}
