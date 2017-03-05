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
    state boolean not null,
    bus_idbus int not null,
    primary key (idbus_location)
);

alter table bus_location add constraint foreign key (bus_idbus) references bus(idbus);


drop procedure bus_show;
delimiter ;;
create procedure bus_show()
begin
	select idbus, plate, driver_name, bus_type, ticket_price from bus;
end ;;
delimiter ;;

drop procedure bus_register;
delimiter ;;
create procedure bus_register(plate varchar(45), driver_name varchar(45), password varchar(45), bus_type varchar(45), ticket_price int)
begin
    insert into bus(plate,password,driver_name,bus_type, ticket_price) values(plate, password, driver_name, bus_type, ticket_price); 
end ;;
delimiter ;

drop procedure bus_location_update;
delimiter ;;
create procedure bus_location_update(latitude double, longitude double, bus_idbus integer)
begin
	declare conteo integer;
	select count(idbus) into conteo from bus where idbus=bus_idbus;
    if conteo>0 then
		update bus_location set latitude=latitude,longitude=longitude where bus_idbus=bus_idbus;
	else
		insert into bus_location(latitude,longitude,state,bus_idbus) values(latitude,longitude,true,bus_idbus);
	end if;
end ;;

drop procedure bus_login_register_service;
delimiter ;;
create procedure bus_login_register_service(platep varchar(45), passwordp varchar(45))
begin
	select * from bus where plate=platep and password=passwordp;
end ;;
delimiter ;

drop function bus_login_service;
delimiter ;;
create function bus_login_service(idbusp integer, platep varchar(45))
returns integer
begin
	declare conteo integer;
	select count(idbus) into conteo from bus where idbus=idbusp and plate=platep;
    return conteo;
end ;;
delimiter ;;

drop function bus_location_register_service;
delimiter ;;
create function bus_location_register_service(idbusp integer)
returns boolean
begin
	declare conteo integer;
    select count(bus_idbus) into conteo from bus_location where bus_idbus=idbusp;
    if conteo<=0 then
		insert into bus_location values(default, 5.067518914980187,-75.51735877990723, idbusp);
	end if;
	return true;
end ;;
delimiter ;;

drop function bus_location_update_service;
delimiter ;;
create function bus_location_update_service(idbusp integer, latitudep double, longitudep double)
returns boolean
begin
	update bus_location set latitude=latitudep, longitude=longitudep where bus_idbus=idbusp;
	return true;
end ;;
delimiter ;;

drop function bus_location_delete_service;
delimiter ;;
create function bus_location_delete_service(idbusp integer)
returns boolean
begin
	delete from bus_location where bus_idbus=idbusp;
	return true;
end ;;
delimiter ;;

drop procedure bus_password;
delimiter ;;
create procedure bus_login_service(idbusp varchar(45))
begin
	select password from bus where idbus=idbusp;
end ;;
delimiter ;;
