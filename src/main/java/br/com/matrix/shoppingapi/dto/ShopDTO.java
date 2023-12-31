package br.com.matrix.shoppingapi.dto;

import java.time.LocalDateTime;
import java.util.List;

import br.com.matrix.shoppingapi.model.Shop;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ShopDTO {

	@NotBlank
	private String userIdentifier;
	
	@NotNull
	private float total;
	
	@NotNull
	private LocalDateTime date;
	
	@NotNull
	private List<ItemDTO> items;
	
	public static ShopDTO convert(Shop shop) {
		ShopDTO shopDTO = new ShopDTO();
		shopDTO.setUserIdentifier(shop.getUserIdentifier());
		shopDTO.setTotal(shop.getTotal());
		shopDTO.setDate(shop.getDate());
		return shopDTO;
	}
}
