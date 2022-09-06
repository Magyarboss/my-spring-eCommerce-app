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
INSERT INTO product (name, description, quantity_in_stock, price, subcategory_id, category_id, image) VALUES
    ( N'Monitor 49" SAMSUNG Odyssey LS49AG950NUXEN', N'240Hz, 1ms, 300cd/m2, 1000:1, zakrivljeni, crno/bijeli', 1, 16899.0000, NULL, 1, NULL);
INSERT INTO product (name, description, quantity_in_stock, price, subcategory_id, category_id, image) VALUES
    ( N'Miš RAZER Basilisk Ultimate', N'optički, 20000dpi, crni, USB', 4, 1357.0000, 2, 2, NULL);
INSERT INTO product (name, description, quantity_in_stock, price, subcategory_id, category_id, image) VALUES
    ( N'Tipkovnica RAZER Huntsman V2 Analog', N'Analog Switch, RGB, UK + HR Layout, USB', 5, 1999.0000, 1, 2, NULL);
INSERT INTO product (name, description, quantity_in_stock, price, subcategory_id, category_id, image) VALUES
    ( N'Vodeno hlađenje NZXT Kraken X73', N'socket 1200/115X/1366/2011/2011-3/2066/AM4/sTRX4/TR4', 4, 2199.9900, 13, 9, N'1.jpg');
INSERT INTO product (name, description, quantity_in_stock, price, subcategory_id, category_id, image) VALUES
    ( N'Tvrdi disk 10000 GB TOSHIBA MG06ACA10TE', N'SATA, 256MB cache, 3.5", 7200 okr./min za server', 9, 3549.9900, 8, 8, N'2.jpg');
INSERT INTO product (name, description, quantity_in_stock, price, subcategory_id, category_id, image) VALUES
    ( N'Tipkovnica RAZER BlackWidow V3 Pro', N'bežična, mehanička, Green, RGB, UK+HR Layout, crna, USB', 4, 1850.0000, 1, 2, N'3.jpg');
INSERT INTO product (name, description, quantity_in_stock, price, subcategory_id, category_id, image) VALUES
    ( N'Tipkovnica ASUS ROG Claymore II', N'RGB, mehanička, US Layout, crna, USB', 2, 1775.0000, 1, 2, N'4.jpg');
INSERT INTO product (name, description, quantity_in_stock, price, subcategory_id, category_id, image) VALUES
    ( N'Miš RAZER Naga Pro', N'optički, bežični, 20000dpi, crni, USB', 5, 1230.0000, 2, 2, N'5.jpg');

INSERT INTO product (name, description, quantity_in_stock, price, subcategory_id, category_id, image) VALUES
    ( N'Miš RAZER Viper Ultimate Quartz', N'optički, 20000 dpi, rozi, bežični, USB', 3, 1215.0000, 2, 2, N'6.jpg');
INSERT INTO product (name, description, quantity_in_stock, price, subcategory_id, category_id, image) VALUES
    ( N'Podloga za miš, LOGITECH G840 XL', N'LoL Edition, Gaming, platnena, za miš i tipkovnicu', 4, 375.5500, 3, 2, N'7.jpg');
INSERT INTO product (name, description, quantity_in_stock, price, subcategory_id, category_id, image) VALUES
    ( N'Podloga za miš, LOGITECH G840 XL', N'LoL Edition, Gaming, platnena, za miš i tipkovnicu', 4, 375.5500, 3, 2, N'7.jpg');
INSERT INTO product (name, description, quantity_in_stock, price, subcategory_id, category_id, image) VALUES
    ( N'Zvučnici LOGITECH Z200', N'2.0, 5W, bijeli', 4, 249.0000, 4, 2, N'10.jpg');
INSERT INTO product (name, description, quantity_in_stock, price, subcategory_id, category_id, image) VALUES
    ( N'Zvučnici TRUST GXT 635 Rumax, 2.1', N'RGB, 40W, Bluetooth, crni', 1, 623.0000, 4, 2, N'11.jpg');
INSERT INTO product (name, description, quantity_in_stock, price, subcategory_id, category_id, image) VALUES
    ( N'Slušalice HyperX Cloud Alpha S Gaming', N'HX-HSCAS-BL/WW, crno-plave', 2, 799.0000, 5, 2, N'12.jpg');
INSERT INTO product (name, description, quantity_in_stock, price, subcategory_id, category_id, image) VALUES
    ( N'Slušalice HyperX Gaming Earphones', N'X-HSCEB-RD Cloud Earbuds, stereo, in-ear, mikrofon, crne', 3, 287.0000, 5, 2, N'13.jpg');
INSERT INTO product (name, description, quantity_in_stock, price, subcategory_id, category_id, image) VALUES
    ( N'Mikrofon KINGSTON HyperX QuadCast HX-MICQC-BK', N'stolni, crno-crveni', 1, 648.9900, 6, 2, N'14.jpg');
INSERT INTO product (name, description, quantity_in_stock, price, subcategory_id, category_id, image) VALUES
    ( N'Mikrofon HyperX SoloCast HMIS1X-XX-BK/G', N'stolni, crni', 2, 298.9900, 6, 2, N'15.jpg');
INSERT INTO product (name, description, quantity_in_stock, price, subcategory_id, category_id, image) VALUES
    ( N'Web kamera LOGITECH HD WebCam BRIO Stream', N'4K UHD, XSplit licenca, USB 3.0, crna', 1, 1199.0000, 7, 2, N'16.jpg');
INSERT INTO product (name, description, quantity_in_stock, price, subcategory_id, category_id, image) VALUES
    ( N'Web kamera TRUST Spotlight Pro', N'USB', 4, 184.9900, 7, 2, N'17.jpg');
INSERT INTO product (name, description, quantity_in_stock, price, subcategory_id, category_id, image) VALUES
    ( N'Tvrdi disk 1000 GB Blue Mobile WESTERN DIGITAL', N'WD10SPZX, SATA3, 128MB cache, 5400 okr./min, 2.5", za laptop', 6, 378.9900, 8, 8, N'18.jpg');
INSERT INTO product (name, description, quantity_in_stock, price, subcategory_id, category_id, image) VALUES
    ( N'Tvrdi disk 10000 GB WESTERN DIGITAL Gold', N'WD102KRYZ, SATA, 256MB cache, 7200okr./min, 3.5", za desktop', 4, 2379.0000, 8, 8, N'19.jpg');
INSERT INTO product (name, description, quantity_in_stock, price, subcategory_id, category_id, image) VALUES
    ( N'SSD 240 GB KINGSTON A400 SA400S37/240G', N'SATA3, 2.5", maks do 500/350 MB/s', 2, 264.0000, 9, 8, N'20.jpg');
INSERT INTO product (name, description, quantity_in_stock, price, subcategory_id, category_id, image) VALUES
    ( N'SSD 250 GB KINGSTON KC2500', N'SKC2500M8/250G, M.2/NVMe, 2280, maks 3200/1200 MB/s', 5, 379.0000, 9, 7, N'21.jpg');
INSERT INTO product (name, description, quantity_in_stock, price, subcategory_id, category_id, image) VALUES
    ( N'SSD 1000 GB CRUCIAL BX500, CT1000BX500SSD1', N'SATA 3, 2.5", maks do 540/500 MB/s', 2, 721.0000, 9, 8, N'22.jpg');
INSERT INTO product (name, description, quantity_in_stock, price, subcategory_id, category_id, image) VALUES
    ( N'Memorija PC-19200, 8 GB, G.SKILL Ripjaws 4 series', N'4-2400C15D-8GRR, DDR4 2400MHz, kit 2x4GB', 6, 261.9900, 10, 8, N'23.jpg');
INSERT INTO product (name, description, quantity_in_stock, price, subcategory_id, category_id, image) VALUES
    ( N'Memorija PC-26600, 16 GB, GIGABYTE GP-ARS16G33 Aorus RGB', N'DDR4 3333MHz, kit 2x8GB', 2, 749.0000, 10, 8, N'24.png');
INSERT INTO product (name, description, quantity_in_stock, price, subcategory_id, category_id, image) VALUES
    ( N'Memorija PC-28800, 16 GB, G.SKILL Trident Z Royal', N'F4-3600C16D-16GTRGC, DDR4 3600MHz, kit 2x8GB', 2, 860.0000, 10, 8, N'25.jpg');
INSERT INTO product (name, description, quantity_in_stock, price, subcategory_id, category_id, image) VALUES
    ( N'Ventilator ARCTIC BioniX F140 PWM PST', N'140mm, 1800 okr/min, crveni', 4, 69.0000, 11, 9, N'26.jpg');
INSERT INTO product (name, description, quantity_in_stock, price, subcategory_id, category_id, image) VALUES
    ( N'PC test', N'123', 1, 400.0000, 2, 2, N'6.jpg');