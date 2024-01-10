
INSERT INTO users (email, first_name, last_name, registered_at, password) VALUES('paolo.falco@email.com', 'Paolo', 'Falco', '2023-11-20 17:05', '{noop}paolo');
INSERT INTO users (email, first_name, last_name, registered_at, password) VALUES('john@email.com', 'John', 'Doe', '2023-11-20 17:05', '{noop}john');
INSERT INTO users (email, first_name, last_name, registered_at, password) VALUES('jane@email.com', 'Jane', 'Doe', '2023-11-20 17:05', '{noop}jane');

INSERT INTO roles (id, name) VALUES(1, 'SUPERADMIN');
INSERT INTO roles (id, name) VALUES(2, 'ADMIN');

INSERT INTO users_roles (user_id, roles_id) VALUES(1, 1);
INSERT INTO users_roles (user_id, roles_id) VALUES(2, 2);
INSERT INTO users_roles (user_id, roles_id) VALUES(3, 2);

INSERT INTO photos (created_at, title, description, image, visible, user_id) VALUES ('2023-11-23 14:50:00', 'Beautiful Landscape', 'Immerse yourself in the breathtaking beauty of nature with this captivating image. From lush green landscapes to serene water bodies, this photo captures the essence of the great outdoors. Let your imagination wander as you explore the intricate details of this picturesque scene.', 'https://images.pexels.com/photos/417074/pexels-photo-417074.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500', true, 2);
INSERT INTO photos (created_at, title, description, image, visible, user_id) VALUES ('2023-11-23 14:50:00', 'City Lights', 'Captivating night cityscape', 'https://media.istockphoto.com/id/531625878/it/foto/times-square.jpg?s=612x612&w=0&k=20&c=DP91Gw2dVJZSGFMtO_Iquaw8QwTTP9reCZ_u-u6d0QM=', true, 2);
INSERT INTO photos (created_at, title, description, image, visible, user_id) VALUES ('2023-11-23 14:50:00', 'Mysterious Forest', 'Explore the enchanted woods', 'https://images.locationscout.net/2020/03/mysterious-forest-czech-republic.jpg?h=1100&q=83', false, 2);
INSERT INTO photos (created_at, title, description, image, visible, user_id) VALUES ('2023-11-23 14:50:00', 'Mountain Peak', 'A view from the top of the world', 'https://as1.ftcdn.net/v2/jpg/05/65/76/92/1000_F_565769257_yaHRp8Pts9SjlnSzHKNrQs264KoIsiwE.jpg', true, 2);
INSERT INTO photos (created_at, title, description, image, visible, user_id) VALUES ('2023-11-23 14:50:00', 'Serene Lake', 'Relax by the calm and serene lake', 'https://www.shareoregon.com/system/images/239219/big/SereneLake.jpg?1501560016', true, 2);
INSERT INTO photos (created_at, title, description, image, visible, user_id) VALUES ('2023-11-23 14:50:00', 'Snowy Mountains', 'Embrace the beauty of snowy mountain landscapes', 'https://lp-cms-production.imgix.net/2019-06/0fdc589a5fff00344442ec641cca14d6-snowy-mountains.jpg?auto=format&w=1920&h=640&fit=crop&crop=faces,edges&q=75', true, 2);
INSERT INTO photos (created_at, title, description, image, visible, user_id) VALUES ('2023-11-23 14:50:00', 'Golden Fields', 'Fields of gold under the sunlight', 'https://static1.squarespace.com/static/51a39504e4b093105c265c24/t/58b25abfff7c508925d959d6/1573371781103/golden-fields-carranballac.jpg?format=1500w', true, 2);
INSERT INTO photos (created_at, title, description, image, visible, user_id) VALUES ('2023-11-23 14:50:00', 'Cozy Cabin', 'Escape to a cozy cabin in the woods', 'https://q-xx.bstatic.com/xdata/images/hotel/max1024x768/274524975.jpg?k=2d9c8225064ab727e611078da8c6fcce7b0473efafab45261dfaa27ac89e04be&o=', true, 2);
INSERT INTO photos (created_at, title, description, image, visible, user_id) VALUES ('2023-11-23 14:50:00', 'Tropical Paradise', 'Discover the beauty of a tropical paradise', 'https://render.fineartamerica.com/images/rendered/default/poster/8/5/break/images/artworkimages/medium/2/3-tropical-paradise-rawpixel.jpg', true, 2);
INSERT INTO photos (created_at, title, description, image, visible, user_id) VALUES ('2023-11-23 14:50:00', 'Desert Oasis', 'Find tranquility in the midst of a desert oasis', 'https://www.worldatlas.com/r/w1200/upload/e7/3c/42/shutterstock-1250207509.jpg', true, 2);
INSERT INTO photos (created_at, title, description, image, visible, user_id) VALUES ('2023-11-23 14:50:00', 'Autumn Leaves', 'Experience the colors of autumn leaves', 'https://www.elitetreecare.com/wp-content/uploads/2019/10/autum-leaves.jpg', true, 2);
INSERT INTO photos (created_at, title, description, image, visible, user_id) VALUES ('2023-11-23 14:50:00', 'Underwater World', 'Explore the wonders of the underwater world', 'https://static.vecteezy.com/system/resources/previews/023/847/397/large_2x/wonderful-and-beautiful-underwater-world-with-corals-and-tropical-fish-with-ai-generated-free-photo.jpg', false, 2);
INSERT INTO photos (created_at, title, description, image, visible, user_id) VALUES ('2023-11-23 14:50:00', 'Ancient Ruins', 'Journey through ancient ruins and history', 'https://cdn-imgix.headout.com/microbrands-banner-image/image/73648cebac314a43970ed9e6de097aaf-AdobeStock_40207802.jpeg', true, 2);
INSERT INTO photos (created_at, title, description, image, visible, user_id) VALUES ('2023-11-23 14:50:00', 'Rolling Hills', 'Rolling hills as far as the eye can see', 'https://www.kenduncan.com/wp-content/uploads/1970/01/VX1404.jpg', true, 2);
INSERT INTO photos (created_at, title, description, image, visible, user_id) VALUES ('2023-11-23 14:50:00', 'Starlit Sky', 'Gaze at the stars in a clear night sky', 'https://www.storizen.com/wp-content/uploads/2020/07/starlit-sky-min.jpg', true, 2);
INSERT INTO photos (created_at, title, description, image, visible, user_id) VALUES ('2023-11-23 14:50:00', 'Whitewater Rapids', 'Feel the adrenaline of whitewater rapids', 'https://mild2wildrafting.com/wp-content/uploads/2020/10/Upper-A.jpg', true, 3);
INSERT INTO photos (created_at, title, description, image, visible, user_id) VALUES ('2023-11-23 14:50:00', 'Cherry Blossoms', 'Enjoy the beauty of cherry blossoms in spring', 'https://hips.hearstapps.com/hmg-prod/images/fuji-and-sakura-royalty-free-image-144483163-1562593125.jpg?crop=0.668xw:1.00xh;0,0&resize=2048:*', true, 3);
INSERT INTO photos (created_at, title, description, image, visible, user_id) VALUES ('2023-11-23 14:50:00', 'Sunny Meadow', 'Relax in a sunny meadow surrounded by flowers', 'https://images.fineartamerica.com/images-medium-large-5/sunny-meadow-pobytov.jpg', true, 3);
INSERT INTO photos (created_at, title, description, image, visible, user_id) VALUES ('2023-11-23 14:50:00', 'Dramatic Cliffs', 'Witness the drama of cliffs against the sea', 'https://149808162.v2.pressablecdn.com/wp-content/uploads/2012/07/3-Cliffs-of-Moher.jpg', true, 3);
INSERT INTO photos (created_at, title, description, image, visible, user_id) VALUES ('2023-11-23 14:50:00', 'Frozen Lake', 'Experience the tranquility of a frozen lake', 'https://media.cntraveler.com/photos/5678fa4567dc82253d9f1c76/master/pass/frozen-abraham-lake-canada-cr-getty.jpg', true, 3);

INSERT INTO categories (name) VALUES ('Nature');
INSERT INTO categories (name) VALUES ('Landscapes');
INSERT INTO categories (name) VALUES ('Wildlife');
INSERT INTO categories (name) VALUES ('Cityscapes');
INSERT INTO categories (name) VALUES ('Abstract');
INSERT INTO categories (name) VALUES ('Travel');
INSERT INTO categories (name) VALUES ('Architecture');
INSERT INTO categories (name) VALUES ('People');
INSERT INTO categories (name) VALUES ('Food');
INSERT INTO categories (name) VALUES ('Technology');
INSERT INTO categories (name) VALUES ('Sports');
INSERT INTO categories (name) VALUES ('Fashion');
INSERT INTO categories (name) VALUES ('Music');
INSERT INTO categories (name) VALUES ('Animals');
INSERT INTO categories (name) VALUES ('Black and White');

INSERT INTO photos_categories (photos_id, categories_id) VALUES (1, 2);
INSERT INTO photos_categories (photos_id, categories_id) VALUES (1, 3);

INSERT INTO photos_categories (photos_id, categories_id) VALUES (2, 5);
INSERT INTO photos_categories (photos_id, categories_id) VALUES (2, 6);

INSERT INTO photos_categories (photos_id, categories_id) VALUES (3, 7);
INSERT INTO photos_categories (photos_id, categories_id) VALUES (3, 8);

INSERT INTO photos_categories (photos_id, categories_id) VALUES (4, 9);
INSERT INTO photos_categories (photos_id, categories_id) VALUES (4, 10);

INSERT INTO photos_categories (photos_id, categories_id) VALUES (5, 11);
INSERT INTO photos_categories (photos_id, categories_id) VALUES (5, 12);

INSERT INTO photos_categories (photos_id, categories_id) VALUES (6, 13);
INSERT INTO photos_categories (photos_id, categories_id) VALUES (6, 14);

INSERT INTO photos_categories (photos_id, categories_id) VALUES (7, 15);
INSERT INTO photos_categories (photos_id, categories_id) VALUES (7, 1);

INSERT INTO photos_categories (photos_id, categories_id) VALUES (8, 2);
INSERT INTO photos_categories (photos_id, categories_id) VALUES (8, 3);

INSERT INTO photos_categories (photos_id, categories_id) VALUES (9, 4);
INSERT INTO photos_categories (photos_id, categories_id) VALUES (9, 5);

INSERT INTO photos_categories (photos_id, categories_id) VALUES (10, 6);
INSERT INTO photos_categories (photos_id, categories_id) VALUES (10, 7);

INSERT INTO photos_categories (photos_id, categories_id) VALUES (11, 8);
INSERT INTO photos_categories (photos_id, categories_id) VALUES (11, 9);

INSERT INTO photos_categories (photos_id, categories_id) VALUES (12, 10);
INSERT INTO photos_categories (photos_id, categories_id) VALUES (12, 11);

INSERT INTO photos_categories (photos_id, categories_id) VALUES (13, 12);
INSERT INTO photos_categories (photos_id, categories_id) VALUES (13, 13);

INSERT INTO photos_categories (photos_id, categories_id) VALUES (14, 14);
INSERT INTO photos_categories (photos_id, categories_id) VALUES (14, 15);

INSERT INTO photos_categories (photos_id, categories_id) VALUES (15, 1);
INSERT INTO photos_categories (photos_id, categories_id) VALUES (15, 2);

INSERT INTO photos_categories (photos_id, categories_id) VALUES (16, 3);
INSERT INTO photos_categories (photos_id, categories_id) VALUES (16, 4);

INSERT INTO photos_categories (photos_id, categories_id) VALUES (17, 5);
INSERT INTO photos_categories (photos_id, categories_id) VALUES (17, 6);

INSERT INTO photos_categories (photos_id, categories_id) VALUES (18, 7);
INSERT INTO photos_categories (photos_id, categories_id) VALUES (18, 8);

INSERT INTO photos_categories (photos_id, categories_id) VALUES (19, 9);
INSERT INTO photos_categories (photos_id, categories_id) VALUES (19, 10);

INSERT INTO photos_categories (photos_id, categories_id) VALUES (20, 11);
INSERT INTO photos_categories (photos_id, categories_id) VALUES (20, 12);

INSERT INTO messages (email, message, created_at, user_id) VALUES('nicola.falco@email.com', 'Volevo esprimere la mia ammirazione per la tua straordinaria abilità nel catturare momenti così magici attraverso il tuo obiettivo. La tua ultima foto, intitolata "Natura Incontaminata", è un vero capolavoro che trasmette la bellezza pura e incontaminata della natura. Ogni dettaglio è stato catturato in modo così nitido, e la composizione è davvero stupefacente. Grazie per condividere la tua visione unica con noi. Questa immagine è davvero ispiratrice e mi ha regalato un momento di serenità nel mio giorno.', '2023-11-23 14:50:00', 1);
INSERT INTO messages (email, message, created_at, user_id) VALUES('nicola.falco@email.com', 'Volevo esprimere la mia ammirazione per la tua straordinaria abilità nel catturare momenti così magici attraverso il tuo obiettivo. La tua ultima foto, intitolata "Natura Incontaminata", è un vero capolavoro che trasmette la bellezza pura e incontaminata della natura. Ogni dettaglio è stato catturato in modo così nitido, e la composizione è davvero stupefacente. Grazie per condividere la tua visione unica con noi. Questa immagine è davvero ispiratrice e mi ha regalato un momento di serenità nel mio giorno.', '2023-11-23 14:50:00', 1);
INSERT INTO messages (email, message, created_at, user_id) VALUES('nicola.falco@email.com', 'Volevo esprimere la mia ammirazione per la tua straordinaria abilità nel catturare momenti così magici attraverso il tuo obiettivo. La tua ultima foto, intitolata "Natura Incontaminata", è un vero capolavoro che trasmette la bellezza pura e incontaminata della natura. Ogni dettaglio è stato catturato in modo così nitido, e la composizione è davvero stupefacente. Grazie per condividere la tua visione unica con noi. Questa immagine è davvero ispiratrice e mi ha regalato un momento di serenità nel mio giorno.', '2023-11-23 14:50:00', 1);
INSERT INTO messages (email, message, created_at, user_id) VALUES('mario.rossi@email.com', 'La tua capacità di catturare la bellezza è davvero straordinaria. La foto "Tramonto Infuocato" mi ha lasciato senza parole. Grazie per regalarci momenti così speciali.', '2023-11-23 15:00:00', 3);
INSERT INTO messages (email, message, created_at, user_id) VALUES('giovanna.verdi@email.com', 'Ho apprezzato molto la tua ultima serie di foto paesaggistiche. Ogni immagine racconta una storia unica. La tua passione per la fotografia è evidente in ogni scatto.', '2023-11-23 15:15:00', 3);
INSERT INTO messages (email, message, created_at, user_id) VALUES('luca.bianchi@email.com', 'La tua foto "Riflessi Urbani" è davvero suggestiva. Hai saputo una anima nella città, in un modo unico. Continua a stupirci con il tuo talento.', '2023-11-23 15:30:00', 3);