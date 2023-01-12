CREATE TABLE `transports` (
  `Id` int NOT NULL AUTO_INCREMENT PRIMARY KEY ,
  `tractor` varchar(40),
  `tractorBrand` varchar(50),
  `semitrailer` varchar(40),
  `semi_trailerBrand` varchar(50),
  `driverFIO` varchar(60)
);

CREATE TABLE `routes` (
  `Id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `departurePoint` varchar(200),
  `arrivalPoint` varchar(200),
  `stoppingPoint` varchar(200)
);

CREATE TABLE `goods` (
  `Id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `applicationId` int,
  `typeOfGoodsId` int,
  `countOfGoods` int,
  `productPrice` varchar(15)
);

CREATE TABLE `typeOfGoods` (
  `Id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `nameOfGoods` varchar(50),
  `unit` varchar(25)
);

CREATE TABLE `applications` (
  `Id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `uploadDate` datetime,
  `unloadingDate` datetime,
  `paymentDayTime` int,
  `currency` varchar(15),
  `applicationsNumber` int,
  `routeId` int,
  `transportId` int,
  `customerId` int,
  `orderExecutorId` int
);

CREATE TABLE `customers` (
  `Id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `customerName` varchar(50),
  `customerPhone` varchar(20),
  `customerFeedback` varchar(50)
);

CREATE TABLE `orderExecutors` (
  `Id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `orderExecutorName` varchar(50),
  `orderExecutorPhone` varchar(20),
  `orderExecutorFeedback` varchar(50)
);

ALTER TABLE `goods` ADD FOREIGN KEY (`applicationId`) REFERENCES `applications` (`Id`) ON DELETE CASCADE;

ALTER TABLE `goods` ADD FOREIGN KEY (`typeOfGoodsId`) REFERENCES `typeOfGoods` (`Id`) ON DELETE CASCADE;

ALTER TABLE `applications` ADD FOREIGN KEY (`routeId`) REFERENCES `routes` (`Id`) ON DELETE CASCADE;

ALTER TABLE `applications` ADD FOREIGN KEY (`transportId`) REFERENCES `transports` (`Id`) ON DELETE CASCADE;

ALTER TABLE `applications` ADD FOREIGN KEY (`customerId`) REFERENCES `customers` (`Id`) ON DELETE CASCADE;

ALTER TABLE `applications` ADD FOREIGN KEY (`orderExecutorId`) REFERENCES `orderExecutors` (`Id`) ON DELETE CASCADE;