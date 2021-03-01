create table advertisement
(
	id bigint not null
		constraint advertisement_pkey
			primary key,
	name varchar(255)
);

alter table advertisement owner to postgres;

create table category
(
	id bigint not null
		constraint category_pkey
			primary key,
	description varchar(255),
	name varchar(255)
);

alter table category owner to postgres;

create table customer
(
	id bigint not null
		constraint customer_pkey
			primary key,
	name varchar(255)
);

alter table customer owner to postgres;

create table information
(
	id bigint not null
		constraint information_pkey
			primary key,
	name varchar(255)
);

alter table information owner to postgres;

create table product
(
	id bigint not null
		constraint product_pkey
			primary key,
	kind varchar(255),
	name varchar(255),
	sale varchar(255),
	customer_id bigint
		constraint fkj80n6400wnfqrt86qimf9k6ys
			references customer
);

alter table product owner to postgres;

