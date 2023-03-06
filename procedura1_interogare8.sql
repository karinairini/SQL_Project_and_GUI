use bucatarie_retete;
drop procedure if exists interogare8;
delimiter //
create procedure interogare8(ingredient_dorit varchar(50), tip_dorit varchar(25))
begin
	SELECT s.um AS `Unitate de măsură`, SUM(s.cantitate) AS `Cantitate totală`
	FROM Reteta r JOIN Set_ingrediente s ON (s.reteta_id = r.reteta_id)
	WHERE s.ingred_id = (SELECT ingred_id FROM Ingredient WHERE ingredient = ingredient_dorit) AND r.categ_id = 
	(SELECT categ_id FROM Categorie WHERE tip = tip_dorit)
	GROUP BY s.um;
end//
delimiter ;