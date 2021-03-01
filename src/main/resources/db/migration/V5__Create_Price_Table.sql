create table price
(
	id bigint not null
		constraint price_pkey
			primary key,
	name varchar(255),
	price numeric(19,2)
);

alter table price owner to postgres;

