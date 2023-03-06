CREATE TABLE Categorie
(categ_id NUMBER(6,0) NOT NULL,
tip VARCHAR2(25) NOT NULL);

CREATE TABLE Reteta
(reteta_id NUMBER(6,0) NOT NULL,
nume VARCHAR2(100) NOT NULL,
descriere CLOB NULL,
categ_id NUMBER(6,0) NOT NULL,
vegetariana CHAR(1) CHECK (vegetariana IN ('D', 'N')) NULL,
timp_preparare NUMBER(4,0) NULL,
portii INTEGER NOT NULL);

CREATE TABLE Set_ingrediente
(reteta_id NUMBER(6,0) NOT NULL,
ingred_id NUMBER(6,0) NOT NULL,
cantitate NUMBER(6,2) NOT NULL,
um VARCHAR2(9) CHECK (um IN ('gr', 'ml', 'buc', 'lingura', 'lingurita', 'cana')) NOT NULL,
comentarii VARCHAR2(100) NULL);

CREATE TABLE Ingredient
(ingred_id NUMBER(6,0) NOT NULL,
ingredient VARCHAR2(50) NOT NULL);

ALTER TABLE Categorie
ADD CONSTRAINT categorie_categ_id_pk PRIMARY KEY(categ_id);

ALTER TABLE Reteta ADD 
(CONSTRAINT reteta_reteta_id_pk PRIMARY KEY(reteta_id),
CONSTRAINT reteta_categ_id_fk FOREIGN KEY(categ_id) REFERENCES Categorie(categ_id));

ALTER TABLE Ingredient
ADD CONSTRAINT ingredient_ingred_id_pk PRIMARY KEY(ingred_id);

ALTER TABLE Set_ingrediente ADD 
(CONSTRAINT set_ingrediente_reteta_id_fk FOREIGN KEY(reteta_id) REFERENCES Reteta(reteta_id),
CONSTRAINT set_ingrediente_ingred_id_fk FOREIGN KEY(ingred_id) REFERENCES Ingredient(ingred_id),
CONSTRAINT set_ingred_reteta_ingred_id_pk PRIMARY KEY (reteta_id, ingred_id));

ALTER TABLE Reteta
ADD autor VARCHAR2(50);

ALTER TABLE Categorie
ADD CONSTRAINT categorie_tip_ck CHECK (tip IN ('supa', 'ciorba', 'tocana', 'desert', 'aperitiv', 'friptura', 
'fel principal', 'salata'));

ALTER TABLE Reteta
ADD CONSTRAINT reteta_timp_preparare_ck CHECK (timp_preparare <= CASE WHEN vegetariana = 'D' THEN 15 END);

INSERT INTO Categorie(categ_id, tip) VALUES(1, 'supa');
INSERT INTO Categorie(categ_id, tip) VALUES(2, 'ciorba');
INSERT INTO Categorie(categ_id, tip) VALUES(3, 'tocana');
INSERT INTO Categorie(categ_id, tip) VALUES(4, 'desert');
INSERT INTO Categorie(categ_id, tip) VALUES(5, 'aperitiv');
INSERT INTO Categorie(categ_id, tip) VALUES(6, 'friptura');
INSERT INTO Categorie(categ_id, tip) VALUES(7, 'fel principal');


INSERT INTO Ingredient(ingred_id, ingredient) VALUES(1, 'apa');
INSERT INTO Ingredient(ingred_id, ingredient) VALUES(2, 'sare');
INSERT INTO Ingredient(ingred_id, ingredient) VALUES(3, 'piper');
INSERT INTO Ingredient(ingred_id, ingredient) VALUES(4, 'ulei');
INSERT INTO Ingredient(ingred_id, ingredient) VALUES(5, 'orez');
INSERT INTO Ingredient(ingred_id, ingredient) VALUES(6, 'carne de pui');
INSERT INTO Ingredient(ingred_id, ingredient) VALUES(7, 'carne de porc');
INSERT INTO Ingredient(ingred_id, ingredient) VALUES(8, 'muschi de vita');
INSERT INTO Ingredient(ingred_id, ingredient) VALUES(9, 'cascaval');
INSERT INTO Ingredient(ingred_id, ingredient) VALUES(10, 'lapte');
INSERT INTO Ingredient(ingred_id, ingredient) VALUES(11, 'smantana');
INSERT INTO Ingredient(ingred_id, ingredient) VALUES(12, 'ou');
INSERT INTO Ingredient(ingred_id, ingredient) VALUES(13, 'zahar');
INSERT INTO Ingredient(ingred_id, ingredient) VALUES(14, 'făina');
INSERT INTO Ingredient(ingred_id, ingredient) VALUES(15, 'drojdie');
INSERT INTO Ingredient(ingred_id, ingredient) VALUES(16, 'vanilie');
INSERT INTO Ingredient(ingred_id, ingredient) VALUES(17, 'ciocolata');
INSERT INTO Ingredient(ingred_id, ingredient) VALUES(18, 'varza');
INSERT INTO Ingredient(ingred_id, ingredient) VALUES(19, 'morcov');
INSERT INTO Ingredient(ingred_id, ingredient) VALUES(20, 'legatura patrunjel');
INSERT INTO Ingredient(ingred_id, ingredient) VALUES(21, 'ceapa');
INSERT INTO Ingredient(ingred_id, ingredient) VALUES(22, 'usturoi');
INSERT INTO Ingredient(ingred_id, ingredient) VALUES(23, 'vinete');
INSERT INTO Ingredient(ingred_id, ingredient) VALUES(24, 'fasole verde');
INSERT INTO Ingredient(ingred_id, ingredient) VALUES(25, 'suc de rosii');


INSERT INTO Reteta (reteta_id, nume, descriere, categ_id, vegetariana, timp_preparare, portii, autor)
VALUES (1, 'Sarmalute moldovenesti', 'Se taie ceapa si se caleste pana cand devine sticloasa. Se adauga o parte din sucul de
rosii si se lasa la foc, amestecand. Se pune ceapa peste carnea tocata impreuna cu condimentele si orezul spalat. Se desface
varza in foi, dupa care fiecare foaie se umple cu 1-2 lingurite de compozitie, se ruleaza si se indeasa la capete. In oala in
care urmeaza sa fie gatite, se aseaza mai intai un strat de varza taiata cat mai marunt, iar dupa se aranjeaza sarmalele, 
formand o spirala cat mai bine indesata, peste care inca un strat de varza taiata marunt, continuand acesti pasi pana se 
termina toate sarmalele. Deasupra se aseaza un ultim strat de varza taiata marunt, se toarna sosul de rosii si apa, pana 
cand lichidul incepe sa se zareasca printre sarmalute. Se pun la foc mic cu capacul pus usor inclinat.', 7, 'N', 300, 10, 
'Jamila');

INSERT INTO Reteta (reteta_id, nume, descriere, categ_id, vegetariana, timp_preparare, portii, autor)
VALUES (2, 'Cascaval pane', 'Se bat ouale cu sare, iar faina se pune intr-o farfurie adanca. Cascavalul se taie felii, dupa 
care se dau mai intai prin faina, apoi prin ou, apoi din nou prin faina si prin ou pentru a avea o crusta mai groasa.
Uleiul trebuie sa fie incins mediu, iar cand se pun feliile in tigaie trebuie ca ele sa fie acoperite bine cu ulei, astfel 
nu va mai fi nevoie sa fie intoarse. Cand sunt aurii, feliile de cascaval pane se scot pe farfurii si se tamponeaza cu mare 
grija cu servetele absorbante.', 7, 'N', 25, 2, 'Petitchef');

INSERT INTO Reteta (reteta_id, nume, descriere, categ_id, vegetariana, timp_preparare, portii, autor)
VALUES (3, 'Ciorba ardeleneasca', 'Se lasa carnea in apa rece, apoi se spala bine si se toaca bucatele. Se pune la fiert in 
apa calda, cu sare. Separat se inabusesc legumele tocate marunt, iar cand s-au inmuiat se adauga in oala peste carne si se 
lasa sa fiarba. Cand legumele si carnea sunt pe jumatate fierte se adauga orezul si condimentele. Intr-un bol se pune 
smantana, iar dupa ce este fiarta ciorba, se adauga o parte din zeama fierbinte in bol si se combina cu smantana. La final 
se toarna aceasta combinatie in oala si se amesteca bine totul.', 2, 'N', 55, 4, 'Popescu Miruna');

INSERT INTO Reteta (reteta_id, nume, descriere, categ_id, vegetariana, timp_preparare, portii, autor)
VALUES (4, 'Ciorba de vacuta', 'Se spala si se curata bine legumele, dupa care se toaca toate marunt. Se pune apa intr-o oala
si se adauga carnea, care se lasa sa fiarba pana cand se formeaza spuma deasupra, care se indeparteaza cu ajutorul unei 
spumiere. Odata ce nu se mai formeaza spuma, se adauga legumele si se mai lasa la foc mediu. Cand s-au fiert, se adauga sucul 
de rosii si condimentele si se mai lasa inca 15 minute la fiert.', 2, 'N', 180, 7, 'Mega Image');

INSERT INTO Reteta (reteta_id, nume, descriere, categ_id, vegetariana, timp_preparare, portii, autor)
VALUES (5, 'Tocana de pui', 'Se incinge uleiul si se adauga bucatile de pui. Se rumeneste puiul pe toate partile, dupa care 
se adauga ceapa si usturoiul si se lasa pana se calesc. Se adauga sucul de rosii si condimentele si se lasa sa fiarba la 
foc mic pana capata consistenta unui sos. Se da deoparte si se adauga patrunjelul taiat marunt.', 3, 'N', 75, 4, 'Jamila');	

INSERT INTO Reteta (reteta_id, nume, descriere, categ_id, vegetariana, timp_preparare, portii, autor)
VALUES (6, 'Legume cu orez', 'Se spala legumele si se toaca cubulete. Se caleste ceapa si usturoiul cu uleiul si 
condimentele. Se adauga restul legumelor si se toarna orezul. Se lasa la calit 3 minute pana ce devine usor sticlos, in timp
ce se amesteca constant. In final se adauga apa si se amesteca bine. Dupa ce este gata se adauga patrunjelul.', 3, 'D', 13, 
2, 'Kaufland');

INSERT INTO Reteta (reteta_id, nume, descriere, categ_id, vegetariana, timp_preparare, portii, autor)
VALUES (7, 'Fasole verde la tigaie', 'Se adauga fasolea verde in tigaie impreuna cu jumatate din sucul de rosii. Cand incepe
sucul de rosii sa fiarba, se adauga cealalta jumatate, verdeata si usturoiul si se lasa sub capac pana cand fasolea e 
fiarta.', 3, 'D', 15, 3, 'Ileana Voicu');

INSERT INTO Reteta (reteta_id, nume, descriere, categ_id, vegetariana, timp_preparare, portii, autor)
VALUES (8, 'Tocana de vita', 'Se pune ceapa si usturoiul, ambele tocate marunt, intr-o tigaie unde s-a incalzit putin uleiul.
Se lasa sa se caleasca putin, dupa care se adauga morcovul, sucul de rosii si condimentele. Dupa cateva minute, se adauga 
carnea. Se lasa la foc mic, pana cand se obtine un sos mai gros si delicios cu un gust bun de carne de vita. Cand aceasta 
este fiarta in totalitate, se opreste focul si se adauga patrunjelul.', 3, 'N', 260, 3, 'Florin Dumitrescu');

INSERT INTO Reteta (reteta_id, nume, descriere, categ_id, vegetariana, timp_preparare, portii, autor)
VALUES (9, 'Supa de rosii', 'Se spala si se taie marunt legumele. Intr-o oala se pune la incins uleiul, peste care punem 
legumele si condimentele. Dupa ce se calesc putin se adauga apa si sucul se rosii si se lasa la fiert pana cand legumele 
sunt inabusite. ', 1, 'D', 12, 3, 'Gina Bradea');

INSERT INTO Reteta (reteta_id, nume, descriere, categ_id, vegetariana, timp_preparare, portii, autor)
VALUES (10, 'Friptura de porc', 'Carnea se spala, se curata de pielite si se taie felii groase de 1-2 cm. Acestea se dau cu 
putin piper si se prajesc in ulei incins pe fiecare parte. Se scot din tigaie fara sa se intepe cu furculita, ci cu o paleta
si se lasa la scurs pe un servetel de hartie. In grasimea ramasa in tigaie se calesc usor ceapa si usturoiul fin tocate cu 
putina sare. Se pun din nou feliile de carne si se lasa sa fiarba inabusit pana se patrund in intregime.', 6, 'N', 130, 6,
'Oana Badescu');

INSERT INTO Reteta (reteta_id, nume, descriere, categ_id, vegetariana, timp_preparare, portii, autor)
VALUES (11, 'Omleta', 'Se sparg ouale intr-un castron si se condimenteaza. Acestea se bat putin cu telul sau cu furculita. 
Ouale trebuie batute bine, cu forta, astfel omleta va prinde aer si va capata volum. Se incinge tigaia, apoi se adauga ouale.
In primele 20 de secunde, se plimba compozitia pentru a o aseza uniform in tigaie. Dupa putin timp se poate observa ca se 
gateste pe margine, moment in care se impatureste pe jumatate, cu ajutorul unei spatule, si se mai lasa putin pe foc.', 
5, 'D', 13, 1, 'Mama');

INSERT INTO Reteta (reteta_id, nume, descriere, categ_id, vegetariana, timp_preparare, portii, autor)
VALUES (12, 'Salata de vinete', 'Vinetele se aseaza intr-un castron incapator impreuna cu ceapa. Se amesteca si se 
condimenteaza pe parcurs. Pe masura ce se adauga si uleiul, salata de vinete devine tot mai cremoasa si mai deschisa la 
culoare.', 5, 'D', 10, 3, 'Karina Irini');

INSERT INTO Reteta (reteta_id, nume, descriere, categ_id, vegetariana, timp_preparare, portii, autor)
VALUES (13, 'Chec', 'Se pun albusurile intr-un bol, se adauga sarea si se mixeaza cu telul pana cand devin ca o spuma. Se 
adauga treptat zaharul si vanilia, pana se obtine o spuma lucioasa si tare. Se amesteca galbenusurile cu ulei intr-un 
castron separat, pana se formeaza o masa omogena. Se incorporeaza galbenusurile usor in spuma de albus. Se pune drojdia, 
faina si laptele si se amesteca. Se imparte compozitia in doua parti egale, iar ciocolata se adauga intr-o parte a 
aluatului, obtinand un chec in doua culori. In tavile cu hartie de copt se pune alternativ cate o lingura din fiecare
compozitie, astfel incat amestecul sa devina cat mai interesant si se pun tavile in cuptor.', 4, 'N', 60, 1, 'Bunica');

INSERT INTO Reteta (reteta_id, nume, descriere, categ_id, vegetariana, timp_preparare, portii, autor)
VALUES (14, 'Cozonac', 'Se cerne faina de 2-3 ori, pana cand devine foarte fina. Se prepara o maia amestecand drojdia, faina
si laptele. Se pun galbenusurile batute cu zahar si vanilie in castronul cu cealalta parte a aluatului. Se framanta 
compozitia si se lasa la dospit. Cand aluatul a crecut, se imparte in bucati egale, care se intind si se ruleaza. Dupa ce se
aseaza in tavi se mai mai asteapta putin sa mai creasca, apoi se introduc in cuptor.', 4, 'N', 300, 4, 'Jamila');


INSERT INTO Set_ingrediente(reteta_id, ingred_id, cantitate, um) VALUES(1, 7, 500, 'gr');
INSERT INTO Set_ingrediente(reteta_id, ingred_id, cantitate, um, comentarii) VALUES(1, 5, 70, 'gr', 'bob lung');
INSERT INTO Set_ingrediente(reteta_id, ingred_id, cantitate, um, comentarii) VALUES(1, 18, 1000, 'gr', 'murata');
INSERT INTO Set_ingrediente(reteta_id, ingred_id, cantitate, um) VALUES(1, 2, 3, 'lingurita');
INSERT INTO Set_ingrediente(reteta_id, ingred_id, cantitate, um) VALUES(1, 25, 250, 'ml');
INSERT INTO Set_ingrediente(reteta_id, ingred_id, cantitate, um, comentarii) VALUES (1, 1, 200, 'ml', 'rece');
INSERT INTO Set_ingrediente(reteta_id, ingred_id, cantitate, um) VALUES(2, 17, 2, 'buc');

INSERT INTO Set_ingrediente(reteta_id, ingred_id, cantitate, um) VALUES(2, 9, 400, 'gr');
INSERT INTO Set_ingrediente(reteta_id, ingred_id, cantitate, um) VALUES(2, 12, 2, 'buc');
INSERT INTO Set_ingrediente(reteta_id, ingred_id, cantitate, um) VALUES(2, 14, 5, 'lingura');
INSERT INTO Set_ingrediente(reteta_id, ingred_id, cantitate, um) VALUES(2, 4, 1, 'cana');
INSERT INTO Set_ingrediente(reteta_id, ingred_id, cantitate, um) VALUES(2, 2, 1, 'lingurita');

INSERT INTO Set_ingrediente(reteta_id, ingred_id, cantitate, um, comentarii) VALUES(3, 7, 500, 'gr', 'pulpa sau piept daca o doriti mai grasa');
INSERT INTO Set_ingrediente(reteta_id, ingred_id, cantitate, um, comentarii) VALUES(3, 5, 80, 'gr', 'prefiert');
INSERT INTO Set_ingrediente(reteta_id, ingred_id, cantitate, um) VALUES(3, 19, 1, 'buc');
INSERT INTO Set_ingrediente(reteta_id, ingred_id, cantitate, um) VALUES(3, 4, 2, 'lingura');
INSERT INTO Set_ingrediente(reteta_id, ingred_id, cantitate, um, comentarii) VALUES(3, 1, 700, 'ml', 'rece');
INSERT INTO Set_ingrediente(reteta_id, ingred_id, cantitate, um) VALUES(3, 3, 0.5, 'lingurita');
INSERT INTO Set_ingrediente(reteta_id, ingred_id, cantitate, um) VALUES(3, 14, 1, 'lingura');
INSERT INTO Set_ingrediente(reteta_id, ingred_id, cantitate, um, comentarii) VALUES(3, 11, 200, 'ml', '3.5% grasime');

INSERT INTO Set_ingrediente(reteta_id, ingred_id, cantitate, um, comentarii) VALUES (4, 8, 650, 'gr', 'taiat cubulete');
INSERT INTO Set_ingrediente(reteta_id, ingred_id, cantitate, um) VALUES (4, 1, 20, 'cana');
INSERT INTO Set_ingrediente(reteta_id, ingred_id, cantitate, um) VALUES (4, 25, 400, 'ml');
INSERT INTO Set_ingrediente(reteta_id, ingred_id, cantitate, um) VALUES (4, 19, 2, 'buc');
INSERT INTO Set_ingrediente(reteta_id, ingred_id, cantitate, um, comentarii) VALUES (4, 21, 2, 'buc', 'mari');
INSERT INTO Set_ingrediente(reteta_id, ingred_id, cantitate, um, comentarii) VALUES (4, 20, 1, 'buc', 'proaspat');

INSERT INTO Set_ingrediente(reteta_id, ingred_id, cantitate, um, comentarii) VALUES(5, 6, 1000, 'gr', 'pulpe inferioare');
INSERT INTO Set_ingrediente(reteta_id, ingred_id, cantitate, um, comentarii) VALUES (5, 21, 500, 'gr', 'alba');
INSERT INTO Set_ingrediente(reteta_id, ingred_id, cantitate, um) VALUES(5, 4, 4, 'lingura');
INSERT INTO Set_ingrediente(reteta_id, ingred_id, cantitate, um, comentarii) VALUES(5, 20, 1, 'buc', 'tocat marunt');
INSERT INTO Set_ingrediente(reteta_id, ingred_id, cantitate, um) VALUES(5, 25, 350, 'ml');
INSERT INTO Set_ingrediente(reteta_id, ingred_id, cantitate, um) VALUES (5, 2, 2, 'lingurita');
INSERT INTO Set_ingrediente(reteta_id, ingred_id, cantitate, um) VALUES(5, 3, 1, 'lingurita');
INSERT INTO Set_ingrediente(reteta_id, ingred_id, cantitate, um, comentarii) VALUES(5, 22, 30, 'gr', 'tocat marunt');

INSERT INTO Set_ingrediente(reteta_id, ingred_id, cantitate, um, comentarii) VALUES(6, 5, 100, 'gr', 'bob scurt');
INSERT INTO Set_ingrediente(reteta_id, ingred_id, cantitate, um) VALUES(6, 20, 1, 'buc');
INSERT INTO Set_ingrediente(reteta_id, ingred_id, cantitate, um) VALUES(6, 19, 2, 'buc');
INSERT INTO Set_ingrediente(reteta_id, ingred_id, cantitate, um, comentarii) VALUES(6, 1, 400, 'ml', 'calda');
INSERT INTO Set_ingrediente(reteta_id, ingred_id, cantitate, um) VALUES(6, 22, 4, 'buc');
INSERT INTO Set_ingrediente(reteta_id, ingred_id, cantitate, um, comentarii) VALUES(6, 21, 2, 'buc', 'alba');
INSERT INTO Set_ingrediente(reteta_id, ingred_id, cantitate, um) VALUES(6, 2, 2, 'lingurita');

INSERT INTO Set_ingrediente(reteta_id, ingred_id, cantitate, um) VALUES(7, 24, 600, 'gr');
INSERT INTO Set_ingrediente(reteta_id, ingred_id, cantitate, um) VALUES(7, 25, 300, 'ml');
INSERT INTO Set_ingrediente(reteta_id, ingred_id, cantitate, um) VALUES(7, 2, 1, 'lingura');
INSERT INTO Set_ingrediente(reteta_id, ingred_id, cantitate, um) VALUES(7, 3, 1, 'lingurita');
INSERT INTO Set_ingrediente(reteta_id, ingred_id, cantitate, um, comentarii) VALUES(7, 22, 50, 'gr', 'tocat marunt');

INSERT INTO Set_ingrediente(reteta_id, ingred_id, cantitate, um, comentarii) VALUES(8, 8, 500, 'gr', 'taiat marunt');
INSERT INTO Set_ingrediente(reteta_id, ingred_id, cantitate, um, comentarii) VALUES(8, 21, 3, 'buc', 'mare');
INSERT INTO Set_ingrediente(reteta_id, ingred_id, cantitate, um) VALUES(8, 22, 6, 'buc');
INSERT INTO Set_ingrediente(reteta_id, ingred_id, cantitate, um, comentarii) VALUES(8, 19, 2, 'buc', 'ras');
INSERT INTO Set_ingrediente(reteta_id, ingred_id, cantitate, um) VALUES(8, 4, 50, 'ml');
INSERT INTO Set_ingrediente(reteta_id, ingred_id, cantitate, um) VALUES(8, 2, 2, 'lingura');
INSERT INTO Set_ingrediente(reteta_id, ingred_id, cantitate, um) VALUES(8, 3, 1, 'lingura');
INSERT INTO Set_ingrediente(reteta_id, ingred_id, cantitate, um, comentarii) VALUES(8, 20, 1, 'buc', 'tocat marunt');
INSERT INTO Set_ingrediente(reteta_id, ingred_id, cantitate, um) VALUES(8, 25, 200, 'ml');

INSERT INTO Set_ingrediente(reteta_id, ingred_id, cantitate, um, comentarii) VALUES(9, 21, 1, 'buc', 'alba');
INSERT INTO Set_ingrediente(reteta_id, ingred_id, cantitate, um) VALUES(9, 25, 700, 'ml');
INSERT INTO Set_ingrediente(reteta_id, ingred_id, cantitate, um) VALUES(9, 4, 4, 'lingura');
INSERT INTO Set_ingrediente(reteta_id, ingred_id, cantitate, um) VALUES(9, 19, 3, 'buc');
INSERT INTO Set_ingrediente(reteta_id, ingred_id, cantitate, um) VALUES(9, 2, 3, 'lingurita');
INSERT INTO Set_Ingrediente(reteta_id, ingred_id, cantitate, um) VALUES(9, 3, 1.5, 'lingurita');
INSERT INTO Set_ingrediente(reteta_id, ingred_id, cantitate, um) VALUES(9, 1, 7, 'cana');

INSERT INTO Set_ingrediente(reteta_id, ingred_id, cantitate, um, comentarii) VALUES(10, 7, 1300, 'gr', 'piept cu soric');
INSERT INTO Set_ingrediente(reteta_id, ingred_id, cantitate, um) VALUES(10, 4, 2, 'lingura');
INSERT INTO Set_ingrediente(reteta_id, ingred_id, cantitate, um, comentarii) VALUES(10, 21, 2, 'buc', 'rosie');
INSERT INTO Set_ingrediente(reteta_id, ingred_id, cantitate, um) VALUES(10, 2, 2, 'lingurita');
INSERT INTO Set_ingrediente(reteta_id, ingred_id, cantitate, um) VALUES(10, 3, 2, 'lingurita');
INSERT INTO Set_ingrediente(reteta_id, ingred_id, cantitate, um, comentarii) VALUES(10, 22, 45, 'gr', 'tocat marunt');

INSERT INTO Set_ingrediente(reteta_id, ingred_id, cantitate, um) VALUES(11, 4, 0.5, 'cana');
INSERT INTO Set_ingrediente(reteta_id, ingred_id, cantitate, um) VALUES(11, 2, 1, 'lingurita');
INSERT INTO Set_ingrediente(reteta_id, ingred_id, cantitate, um) VALUES(11, 12, 2, 'buc');

INSERT INTO Set_ingrediente(reteta_id, ingred_id, cantitate, um) VALUES(12, 4, 120, 'ml');
INSERT INTO Set_ingrediente(reteta_id, ingred_id, cantitate, um, comentarii) VALUES(12, 2, 2, 'lingurita', 'dupa gust');
INSERT INTO Set_ingrediente(reteta_id, ingred_id, cantitate, um, comentarii) VALUES(12, 21, 1, 'buc', 'tocata marunt');
INSERT INTO Set_ingrediente(reteta_id, ingred_id, cantitate, um) VALUES(12, 22, 2, 'buc');
INSERT INTO Set_ingrediente(reteta_id, ingred_id, cantitate, um, comentarii) VALUES(12, 23, 1500, 'gr', 'coapte si tocate');

INSERT INTO Set_ingrediente(reteta_id, ingred_id, cantitate, um) VALUES(13, 14, 400, 'gr');
INSERT INTO Set_ingrediente(reteta_id, ingred_id, cantitate, um, comentarii) VALUES(13, 12, 10, 'buc', 'se separa albusul de galbenus');
INSERT INTO Set_ingrediente(reteta_id, ingred_id, cantitate, um) VALUES(13, 16, 4, 'lingurita');
INSERT INTO Set_ingrediente(reteta_id, ingred_id, cantitate, um) VALUES(13, 17, 4, 'lingura');
INSERT INTO Set_ingrediente(reteta_id, ingred_id, cantitate, um) VALUES(13, 13, 400, 'gr');
INSERT INTO Set_ingrediente(reteta_id, ingred_id, cantitate, um) VALUES(13, 4, 0.5, 'cana');
INSERT INTO Set_ingrediente(reteta_id, ingred_id, cantitate, um, comentarii) VALUES(13, 10, 1, 'cana', '1.5% grasime');
INSERT INTO Set_ingrediente(reteta_id, ingred_id, cantitate, um, comentarii) VALUES(13, 15, 15, 'gr', 'uscata');

INSERT INTO Set_ingrediente(reteta_id, ingred_id, cantitate, um) VALUES(14, 14, 1000, 'gr');
INSERT INTO Set_ingrediente(reteta_id, ingred_id, cantitate, um, comentarii) VALUES(14, 10, 550, 'ml', 'caldut');
INSERT INTO Set_ingrediente(reteta_id, ingred_id, cantitate, um) VALUES(14, 13, 250, 'gr');
INSERT INTO Set_ingrediente(reteta_id, ingred_id, cantitate, um, comentarii) VALUES(14, 12, 6, 'buc', 'doar galbenusurile');
INSERT INTO Set_ingrediente(reteta_id, ingred_id, cantitate, um, comentarii) VALUES(14, 15, 40, 'gr', 'proaspata');
INSERT INTO Set_ingrediente(reteta_id, ingred_id, cantitate, um) VALUES(14, 16, 4, 'lingurita');
