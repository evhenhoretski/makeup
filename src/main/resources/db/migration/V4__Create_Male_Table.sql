create table male
(
	id bigint not null
		constraint male_pkey
			primary key,
	name varchar(255)
);

alter table male owner to postgres;

