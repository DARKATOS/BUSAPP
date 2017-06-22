drop procedure if exists bus_show;
drop procedure if exists bus_register;
drop procedure if exists bus_login_register_service;
drop function if exists bus_login_service;
drop procedure if exists bus_location_register_service;
drop procedure if exists bus_location_update_service;
drop procedure if exists bus_location_delete_service;
drop procedure if exists bus_update_get_service;
drop procedure if exists bus_password;
drop procedure if exists bus_update;
drop procedure if exists bus_delete;

delimiter ;;
create procedure bus_show()
begin
	select idbus, plate, driver_name, bus_type, ticket_price from bus;
end ;;


delimiter ;;
create procedure bus_register(plate varchar(45), driver_name varchar(45), bus_password varchar(45), bus_type varchar(45), ticket_price int)
begin
    insert into bus(plate,password,driver_name,bus_type, ticket_price) values(plate, bus_password, driver_name, bus_type, ticket_price); 
end ;;



delimiter ;;
create procedure bus_login_register_service(platep varchar(45), passwordp varchar(45))
begin
	select * from bus where plate=platep and password=passwordp;
end ;;

delimiter ;;
create function bus_login_service(idbusp integer, platep varchar(45))
returns integer
begin
	declare conteo integer;
	select count(idbus) into conteo from bus where idbus=idbusp and plate=platep;
    return conteo;
end ;;



delimiter ;;
create procedure bus_location_register_service(idbusp integer)
begin
	declare conteo integer;
    select count(bus_idbus) into conteo from bus_location where bus_idbus=idbusp;
    if conteo<=0 then
		insert into bus_location values(default, 5.067518914980187,-75.51735877990723, idbusp);
	end if;
end ;;


delimiter ;;
create procedure bus_location_update_service(idbusp integer, latitudep double, longitudep double)
begin
	update bus_location set latitude=latitudep, longitude=longitudep where bus_idbus=idbusp;
end ;;
delimiter ;;


delimiter ;;
create procedure bus_location_delete_service(idbusp integer)
begin
	delete from bus_location where bus_idbus=idbusp;
end ;;
delimiter ;;

delimiter ;;
create procedure bus_update_get_service()
begin
	select * from bus_location;
end ;;
delimiter ;;


delimiter ;;
create procedure bus_password(idbusp integer)
begin
	select password from bus where idbus=idbusp;
end ;;
delimiter ;;



delimiter ;;
create procedure bus_update(idbusp integer, passwordp varchar(45), driver_namep varchar(45), bus_typep varchar(45), ticket_pricep int)
begin
    update bus set password=passwordp,driver_name=driver_namep,bus_type=bus_typep, ticket_price=ticket_pricep
    where idbus=idbusp;
end ;;
delimiter ;

delimiter ;;
create procedure bus_delete(idbusp integer)
begin
     DELETE FROM bus where idbus =idbusp;
end ;;
delimiter ;

delimiter ;;
create procedure bus_way_show(idbusp integer)
begin
     select * FROM bus_way where bus_idbus=idbusp;
end ;;
delimiter ;

drop procedure bus_way_register;
delimiter ;;
create procedure bus_way_register(way_namep varchar(45), idbusp integer, idbus_locationp integer)
begin
	INSERT INTO bus_way values(default, way_namep, idbusp, idbus_locationp);
end;;
delimiter ;

drop procedure bus_way_delete;
delimiter ;;
create procedure bus_way_delete(idbus_wayp integer)
begin
	DELETE FROM bus_way WHERE idbus_way=idbus_wayp;
end;;
delimiter ;