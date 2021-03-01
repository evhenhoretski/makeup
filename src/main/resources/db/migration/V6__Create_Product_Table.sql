create table product
(
	id bigint not null
		constraint product_pkey
			primary key,
	kind varchar(255),
	name varchar(255),
	sale varchar(255),
	female_id bigint
		constraint fkp1pdb0qclb3f1wyyc68s4c2df
			references female,
	male_id bigint
		constraint fka0s39m7a1mvpm6n7cnvfnuxgm
			references male,
	price_id bigint
		constraint fk2l5ugesxirs8wp4iqcmji7g8m
			references price,
	sales_id bigint
		constraint fkqnvwo9ts3xoc65jocsqm4ysn9
			references sales
);

alter table product owner to postgres;

