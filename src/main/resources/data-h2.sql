INSERT INTO category (name) VALUES ('Monitori');
INSERT INTO category (name) VALUES ('Periferija');
INSERT INTO category (name) VALUES ('Kučista');
INSERT INTO category (name) VALUES ('Grafičke kartice');
INSERT INTO category (name) VALUES ('Procesori');
INSERT INTO category (name) VALUES ('Matične ploce');
INSERT INTO category (name) VALUES ('Napajanja');
INSERT INTO category (name) VALUES ('Memorija');
INSERT INTO category (name) VALUES ('Hlađenje');
INSERT INTO subcategory (name, category_id) VALUES ('Tipkovnice', 2L);
INSERT INTO subcategory (name, category_id) VALUES ('Miševi', 2L);
INSERT INTO subcategory (name, category_id) VALUES ('Podloge za miš', 2L);
INSERT INTO subcategory (name, category_id) VALUES ('Zvučnici', 2L);
INSERT INTO subcategory (name, category_id) VALUES ('Slušalice', 2L);
INSERT INTO subcategory (name, category_id) VALUES ('Mikrofoni', 2L);
INSERT INTO subcategory (name, category_id) VALUES ('Web kamere', 2L);
INSERT INTO subcategory (name, category_id) VALUES ('HDD', 8L);
INSERT INTO subcategory (name, category_id) VALUES ('SSD', 8L);
INSERT INTO subcategory (name, category_id) VALUES ('Memorijske kartice', 8L);
INSERT INTO subcategory (name, category_id) VALUES ('Ventilatori', 9L);
INSERT INTO subcategory (name, category_id) VALUES ('Hladnjaci', 9L);
INSERT INTO subcategory (name, category_id) VALUES ('Vodeno hlađenje', 9L);

INSERT INTO product (name, description, quantity_in_stock, price, subcategory_id, category_id, image) VALUES
    ( 'Monitor 32" SAMSUNG Smart LS32AM500NRXEN', '250cd/m2, 3000:1, zvučnik, Tizen, WiFi, BlueTooth, crni', 3, 2599.0000, null, 1, null);
