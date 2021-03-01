create table information
(
	id bigint not null
		constraint information_pkey
			primary key,
	name varchar(255)
);

alter table information owner to postgres;

