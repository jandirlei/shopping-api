create table shopping.item(
	shop_id bigserial REFERENCES shopping.shop(id),
	product_identifier varchar(100) not null,
	price float not null
);