use bucatarie_retete;
drop procedure if exists nr_ingrediente;
delimiter //
create procedure nr_ingrediente (litera varchar(1))
begin
	set @ingred_litera = CONCAT('_',litera,'%');
	SELECT COUNT(*) FROM Ingredient WHERE ingredient LIKE @ingred_litera;
end//
delimiter ;