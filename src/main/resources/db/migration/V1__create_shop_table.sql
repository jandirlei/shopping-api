CREATE SCHEMA IF NOT EXISTS shopping;

CREATE TABLE shopping.shop(
	id bigserial primary key,
	user_identifier varchar(100) not null,
	date timestamp not null,
	total float not null
);