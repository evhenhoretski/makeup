create table sales
(
	id bigint not null
		constraint sales_pkey
			primary key,
	name varchar(255),
	price numeric(19,2)
);

alter table sales owner to postgres;

