drop table bus;
CREATE TABLE bus (
	idbus int not null auto_increment,
	plate varchar(45) not null unique,
	password varchar(45) not null,
	driver_name varchar(45) not null,
	bus_type varchar(45) not null,
	ticket_price int not null,
	primary key (idbus)
);

drop table bus_location;
create table bus_location(
	idbus_location int not null auto_increment,
    latitude double not null,
    longitude double not null,
    bus_idbus int not null,
    primary key (idbus_location)
);

drop table bus_way;
create table bus_way(
	idbus_way int not null auto_increment,
    way_name varchar(45) not null,
    bus_idbus int not null,
    bus_location_idbus_location int not null,
    primary key(idbus_way)
);

alter table bus_location add constraint foreign key (bus_idbus) references bus(idbus);
alter table bus_way add constraint foreign key (bus_idbus) references bus(idbus);
alter table bus_way add constraint foreign key (bus_location_idbus_location) references bus_location(idbus_location);

