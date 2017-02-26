drop table bus;
CREATE TABLE bus (
	idbus int not null auto_increment,
	plate varchar(45) not null unique,
	password varchar(45) not null,
	driver_name varchar(45) not null,
	type varchar(45) not null,
	ticket_price int not null,
	primary key (idbus)
);

drop table bus_location;
create table bus_location(
	idbus_location int not null auto_increment,
    latitude double not null,
    longitude double not null,
    state boolean not null,
    bus_idbus int not null,
    primary key (idbus_location)
);

alter table bus_location add constraint foreign key (bus_idbus) references bus(idbus);

delimiter ;;
create procedure bus_show()
begin
	select idbus, plate, driver_name, type, ticket_price from bus;
end ;;
delimiter ;;

delimiter ;;
create procedure bus_register(in plate varchar(45), in  driver_name varchar(45), in password varchar(45), in type varchar(45), in  ticket_price int)
begin
    insert into bus(plate,password,driver_name,type, ticket_price) values(plate, password, driver_name, type, ticket_price); 
end ;;
delimiter ;

delimiter ;;
create procedure bus_location_update(in latitude int, in longitude int, in bus_idbus int)
begin
	declare conteo int;
	select count(idbus) into conteo from bus where idbus=bus_idbus;
    if conteo>0 then
		update bus_location set latitude=latitude,longitude=longitude where bus_idbus=bus_idbus;
	else
		insert into bus_location(latitude,longitude,state,bus_idbus) values(latitude,longitude,true,bus_idbus);
	end if;
end ;;
delimiter ;
