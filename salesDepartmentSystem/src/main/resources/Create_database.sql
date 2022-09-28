CREATE TABLE `transports` (
  `Id` int PRIMARY KEY AUTO_INCREMENT,
  `tractor` varchar(40),
  `tractorBrand` varchar(50),
  `semitrailer` varchar(40),
  `semi_trailerBrand` varchar(50),
  `driverFIO` varchar(60)
);

CREATE TABLE `routes` (
  `Id` int PRIMARY KEY AUTO_INCREMENT,
  `departurePoint` varchar(200),
  `arrivalPoint` varchar(200),
  `stoppingPoint` varchar(200)
);

CREATE TABLE `goods` (
  `Id` int PRIMARY KEY AUTO_INCREMENT,
  `applicationId` int,
  `typeOfGoodsId` int,
  `countOfGoods` int,
  `productPrice` varchar(15)
);

CREATE TABLE `typeOfGoods` (
  `Id` int PRIMARY KEY AUTO_INCREMENT,
  `nameOfGoods` varchar(50),
  `unit` varchar(25)
);

CREATE TABLE `applications` (
  `Id` int PRIMARY KEY AUTO_INCREMENT,
  `uploadDate` datetime,
  `unloadingDate` datetime,
  `paymentDayTime` int,
  `currency` varchar(15),
  `applicationNumber` int,
  `routeId` int,
  `transportId` int,
  `customerId` int,
  `orderExecutorId` int
);

CREATE TABLE `customers` (
  `Id` int PRIMARY KEY AUTO_INCREMENT,
  `customerName` varchar(50),
  `customerPhone` varchar(20),
  `customerFeedback` varchar(50)
);

CREATE TABLE `orderExecutors` (
  `Id` int PRIMARY KEY AUTO_INCREMENT,
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
