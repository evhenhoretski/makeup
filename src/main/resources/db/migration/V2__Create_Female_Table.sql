create table female
(
	id bigint not null
		constraint female_pkey
			primary key,
	name varchar(255)
);

alter table female owner to postgres;

