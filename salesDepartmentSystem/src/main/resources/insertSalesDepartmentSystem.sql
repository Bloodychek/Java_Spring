insert into typeofgoods (nameOfGoods, unit) values ('Гвозди', 'кг'), ('Гайки', 'кг'), ('Цемент', 'кг'), ('Кирпичи', 'кг'), ('Шурупы', 'кг'),
('Саморезы', 'кг'), ('Заклепки', 'кг'), ('Рулетки', 'штук'), ('Перфораторы', 'штук'), ('Дрели', 'штук'), ('Колбаса', 'ящиков'), 
('Тушенка', 'ящиков'), ('Сгущенка', 'ящиков'), ('Стул', 'штук');

insert into routes (departurePoint, arrivalPoint, stoppingPoint) values ('г.Жлобин', 'г.Москва Лененский просп. дом 41/2', 'г.Рославль'),
('г.Жлобин', 'г.Брянск ул. Фрунзе дом 65', 'г.Мамай'), ('г.Жлобин', 'г.Минск ул. Маяковского дом 10', '-'),
('г.Жлобин', 'г.Витебск ул. Титова дом 20', '-'), ('г.Жлобин', 'г.Санкт-Питербург просп. Славы дом 33', 'г.Псков'),
('г.Жлобин', 'г.Воронеж просп. Труда дом 48', 'г.Орел');

insert into transports(tractor, tractorBrand, semitrailer, semi_trailerBrand, driverFIO) values ('Автомобиль', 'Маз АК9169-3', 'Полуприцеп бортовой тентовый', 'KOGEL A1856B-3', 'Галаган Сергей Геннадьевич'),
('Седельный тягач', 'DAF АМ9410-3', 'Полуприцеп автомобильный бортовой', 'Wielton A6833B-3', 'Гончаров Антон Николаевич'),
('Автомобиль', 'Маз АН2715-3', 'Полуприцеп', 'МАЗ A3772B-3', 'Богородов Дмитрий Викторович'),
('Седельный тягач', 'DAF АК3558-3', 'Полуприцеп бортовой тентовый', 'Wielton A8903A-3', 'Салуян Валерий Владимирович'),
('Грузовой седельный тягач', 'DAF АН2401-3', 'Полуприцеп бортовой тентовый', 'Wielton A8133B-3', 'Симоненко Михаил Васильевич'),
('Седельный тягач', 'DAF АМ6875-3', 'Полуприцеп', 'Kaessboher Maxima 2012', 'Железко Евгений Владимирович');

insert into customers(customerName, customerPhone, customerFeedback) values ('ОАО Родник', '+831234124123', 'rodnik@gmail.com'),
('MEGATOP', '7976', 'magatopbel@gmail.com'), ('ООО Антель-Фэшион', '+375251235467', 'oooantel@gmail.com'),
('ООО Акцепт Пласт', '+877971238797', 'akceptPlast@gmail.com'), ('ООО Опстрой', '+877971238797', 'opstroy@gmail.com'),
('ОДО Альянс-Плюс', '+834556373647', 'alyansplus@gmail.com');

insert into orderexecutors(orderExecutorName, orderExecutorPhone, orderExecutorFeedback) values ('ОДО РИД', '+375291234565', 'odorid@gmail.com');

insert into applications(uploadDate, unloadingDate, paymentDayTime, currency, applicationsNumber, routeId, transportId, customerId, orderExecutorId)
 values ('2022-04-04', '2022-05-05', 10, '150 BYN', 1, 1, 1, 1, 1);

insert into goods(applicationId, typeOfGoodsId, countOfGoods, productPrice) values (1, 1, 100, '120 BYN');