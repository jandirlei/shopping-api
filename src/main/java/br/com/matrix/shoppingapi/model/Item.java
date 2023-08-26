package br.com.matrix.shoppingapi.model;

import java.io.Serializable;

import br.com.matrix.shoppingapi.dto.ItemDTO;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Embeddable
public class Item implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private String productIdentifier;
	
	
	private float price;
	
	public static Item convert(ItemDTO itemDTO) {
		Item item = new Item();
		item.setProductIdentifier(itemDTO.getProductIdentifier());
		item.setPrice(itemDTO.getPrice());
		return item;
	}
}
