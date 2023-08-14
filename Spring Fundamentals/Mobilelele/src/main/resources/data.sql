INSERT INTO users (created, first_name, image_url, is_active, last_name, modified, password, username)
VALUES ('2023-08-08', 'Georgi', null, true, 'Bozhinov', '2023-08-08', '$2a$10$6yeJUSAJLqNo5D/x0Xdd6.I5PJY6ja1BazVsCftfi06J8JGUW1a/a', 'admin');


INSERT INTO brands(name, created, modified)
VALUES ('BMW', '2023-08-14', null),
       ('Audi', '2023-08-14', null),
       ('Mercedes', '2023-08-14', null),
       ('Nissan', '2023-08-14', null),
       ('Honda', '2023-08-14', null),
       ('Chevrolet', '2023-08-14', null);

INSERT INTO models(brand_id, name, category, created, modified, start_year, end_year, image_url)
VALUES (1, '8 Series', 'CAR', '2023-08-14', null, 1990, null, 'https://upload.wikimedia.org/wikipedia/commons/thumb/6/6e/BMW_G14_IMG_6039.jpg/800px-BMW_G14_IMG_6039.jpg'),
       (1, '7 Series', 'CAR', '2023-08-14', null, 1977, null, 'https://upload.wikimedia.org/wikipedia/commons/thumb/e/e4/BMW_G70_740d_1X7A7230.jpg/800px-BMW_G70_740d_1X7A7230.jpg'),
       (1, '6 Series', 'CAR', '2023-08-14', null, 1976, null, 'https://upload.wikimedia.org/wikipedia/commons/thumb/d/d1/BMW_640d_GT_xDrive_1X7A0311.jpg/800px-BMW_640d_GT_xDrive_1X7A0311.jpg'),
       (1, '5 Series', 'CAR', '2023-08-14', null, 1972, null, 'https://upload.wikimedia.org/wikipedia/commons/thumb/5/52/BMW_G30_FL_IMG_5351.jpg/800px-BMW_G30_FL_IMG_5351.jpg'),
       (1, '4 Series', 'CAR', '2023-08-14', null, 2014, null, 'https://upload.wikimedia.org/wikipedia/commons/thumb/d/d9/BMW_G26_IMG_6565.jpg/800px-BMW_G26_IMG_6565.jpg'),
       (1, '3 Series', 'CAR', '2023-08-14', null, 1975, null, 'https://upload.wikimedia.org/wikipedia/commons/thumb/5/57/BMW_G20_%282022%29_IMG_7316.jpg/800px-BMW_G20_%282022%29_IMG_7316.jpg'),
       (1, '2 Series', 'CAR', '2023-08-14', null, 2014, null, 'https://upload.wikimedia.org/wikipedia/commons/thumb/b/b2/BMW_G42_1X7A5766.jpg/800px-BMW_G42_1X7A5766.jpg'),
       (1, '1 Series', 'CAR', '2023-08-14', null, 2004, null, 'https://upload.wikimedia.org/wikipedia/commons/thumb/b/b2/BMW_G42_1X7A5766.jpg/800px-BMW_G42_1X7A5766.jpg'),
       (2, 'A8', 'CAR', '2023-08-14', null, 1994, null, 'https://upload.wikimedia.org/wikipedia/commons/thumb/b/b9/Audi_A8_50_TDI_%28D5%29_%E2%80%93_Frontansicht%2C_24._Dezember_2017%2C_Velbert.jpg/800px-Audi_A8_50_TDI_%28D5%29_%E2%80%93_Frontansicht%2C_24._Dezember_2017%2C_Velbert.jpg'),
       (2, 'A7', 'CAR', '2023-08-14', null, 2010, null, 'https://upload.wikimedia.org/wikipedia/commons/thumb/3/31/Audi_A7_C8_IMG_0761_%28cropped%29.jpg/800px-Audi_A7_C8_IMG_0761_%28cropped%29.jpg'),
       (2, 'A6', 'CAR', '2023-08-14', null, 1994, null, 'https://upload.wikimedia.org/wikipedia/commons/thumb/5/5f/2018_Audi_A6_TDi_Quattro_Front.jpg/800px-2018_Audi_A6_TDi_Quattro_Front.jpg'),
       (2, 'A5', 'CAR', '2023-08-14', null, 2007, null,'https://upload.wikimedia.org/wikipedia/commons/thumb/7/7b/Audi_A5_Sportback_F5_FL_IMG_6127.jpg/800px-Audi_A5_Sportback_F5_FL_IMG_6127.jpg'),
       (2, 'A4', 'CAR', '2023-08-14', null, 1994, null, 'https://upload.wikimedia.org/wikipedia/commons/thumb/7/75/Audi_A4_B9_sedans_%28FL%29_1X7A6816.jpg/800px-Audi_A4_B9_sedans_%28FL%29_1X7A6816.jpg'),
       (2, 'A3', 'CAR', '2023-08-14', null, 1996, null, 'https://upload.wikimedia.org/wikipedia/commons/thumb/9/9b/Audi_A3_Sportback_35_TFSI_%288Y%29_%E2%80%93_f_02042021.jpg/800px-Audi_A3_Sportback_35_TFSI_%288Y%29_%E2%80%93_f_02042021.jpg'),
       (2, 'A1', 'CAR', '2023-08-14', null, 2010, null,'https://upload.wikimedia.org/wikipedia/commons/thumb/9/90/Audi_A1_Sportback_GB_IMG_6036.jpg/800px-Audi_A1_Sportback_GB_IMG_6036.jpg'),
       (3, 'S-Class', 'CAR', '2023-08-14', null, 2015, null, 'https://upload.wikimedia.org/wikipedia/commons/thumb/7/75/Mercedes-Maybach_Z223_IMG_4030.jpg/800px-Mercedes-Maybach_Z223_IMG_4030.jpg'),
       (3, 'B-Class', 'CAR', '2023-08-14', null, 2005, null, 'https://upload.wikimedia.org/wikipedia/commons/thumb/a/a9/Mercedes-Benz_W247_IMG_0398.jpg/800px-Mercedes-Benz_W247_IMG_0398.jpg'),
       (3, 'G-Class', 'CAR', '2023-08-14', null, 1979, null, 'https://upload.wikimedia.org/wikipedia/commons/thumb/6/60/Mercedes-Benz_W_463_%282018%29_IMG_5250.jpg/800px-Mercedes-Benz_W_463_%282018%29_IMG_5250.jpg'),
       (3, 'E-Class', 'CAR', '2023-08-14', null, 1965, null, 'https://upload.wikimedia.org/wikipedia/commons/thumb/4/46/Mercedes-Benz_S213_FL_IMG_3473.jpg/800px-Mercedes-Benz_S213_FL_IMG_3473.jpg'),
       (3, 'C-Class', 'CAR', '2023-08-14', null, 1993, null, 'https://upload.wikimedia.org/wikipedia/commons/thumb/0/04/Mercedes-Benz_S206_IMG_5746.jpg/800px-Mercedes-Benz_S206_IMG_5746.jpg'),
       (3, 'A-Class', 'CAR', '2023-08-14', null, 2018, null, 'https://upload.wikimedia.org/wikipedia/commons/thumb/c/c2/2019_Mercedes-Benz_A220%2C_front_8.22.19.jpg/800px-2019_Mercedes-Benz_A220%2C_front_8.22.19.jpg'),
       (4, 'GTR', 'CAR', '2023-08-14', null, 2007, null, 'https://upload.wikimedia.org/wikipedia/commons/thumb/2/2e/2024_Nissan_GT-R_Premium_edition_T-Spec_%28cropped%29.jpg/800px-2024_Nissan_GT-R_Premium_edition_T-Spec_%28cropped%29.jpg'),
       (4, 'Z', 'CAR', '2023-08-14', null, 1969, null, 'https://upload.wikimedia.org/wikipedia/commons/thumb/7/75/Nissan_FAIRLADY_Z_%28Z34%29_Version_ST%2C_2022%2C_left-front.jpg/800px-Nissan_FAIRLADY_Z_%28Z34%29_Version_ST%2C_2022%2C_left-front.jpg'),
       (4, 'Skyline', 'CAR', '2023-08-14', null, 1969, null, 'https://upload.wikimedia.org/wikipedia/commons/thumb/a/ae/The_frontview_of_Nissan_DAA-HV37_SKYLINE_HYBRID_GT_Type_SP_%28cropped%29.jpg/800px-The_frontview_of_Nissan_DAA-HV37_SKYLINE_HYBRID_GT_Type_SP_%28cropped%29.jpg'),
       (5, 'Civic', 'CAR', '2023-08-14', null, 1997, null, 'https://upload.wikimedia.org/wikipedia/commons/thumb/7/7b/Honda_Civic_Type-R_For_Guangzhou_International_Auto_Show_2022_%28cropped%29.jpg/800px-Honda_Civic_Type-R_For_Guangzhou_International_Auto_Show_2022_%28cropped%29.jpg'),
       (5, 'NSX', 'CAR', '2023-08-14', null, 1990, null, 'https://upload.wikimedia.org/wikipedia/commons/thumb/e/e4/2017_Honda_NSX_3.5_Front.jpg/800px-2017_Honda_NSX_3.5_Front.jpg'),
       (6, 'Corvette', 'CAR', '2023-08-14', null, 1953, null, 'https://upload.wikimedia.org/wikipedia/commons/thumb/4/4b/Chevrolet_Corvette_C8_IAA_2021_1X7A0156.jpg/800px-Chevrolet_Corvette_C8_IAA_2021_1X7A0156.jpg'),
       (4, 'Camaro', 'CAR', '2023-08-14', null, 1966, null, 'https://upload.wikimedia.org/wikipedia/commons/thumb/5/5b/2020_Chevrolet_Camaro_LT1_1SS%2C_front_3.2.20.jpg/800px-2020_Chevrolet_Camaro_LT1_1SS%2C_front_3.2.20.jpg');