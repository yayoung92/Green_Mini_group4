-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        11.4.0-MariaDB - mariadb.org binary distribution
-- 서버 OS:                        Win64
-- HeidiSQL 버전:                  12.3.0.6589
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- 테이블 mini.person 구조 내보내기
CREATE TABLE IF NOT EXISTS `person` (
  `idx` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `age` varchar(50) DEFAULT NULL,
  `gender` varchar(50) DEFAULT NULL,
  `phoneNumber` varchar(50) DEFAULT NULL,
  `MBTI` varchar(50) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `nickName` varchar(50) DEFAULT NULL,
  `category` varchar(50) DEFAULT NULL,
  `u_idx` int(11) DEFAULT NULL,
  PRIMARY KEY (`idx`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- 테이블 데이터 mini.person:~100 rows (대략적) 내보내기
INSERT INTO `person` (`idx`, `name`, `age`, `gender`, `phoneNumber`, `MBTI`, `address`, `nickName`, `category`, `u_idx`) VALUES
	(1, 'Ginelle Ramelet', '13', 'F', '551-684-5137', '', 'Luozhuang', 'Asoka', 'Ford', 1),
	(2, 'Janie Bruntjen', '47', 'F', '618-904-6220', '', 'Mizhhir’ya', 'Zathin', 'Mazda', 1),
	(3, 'Anjela Compfort', '80', 'M', '360-740-4189', '', 'Oslo', 'Home Ing', 'BMW', 1),
	(4, 'Jennie Main', '91', 'M', '502-784-8838', '', 'Louisville', 'Trippledex', 'Chevrolet', 1),
	(5, 'Patricia Jiggens', '64', 'F', '521-194-8317', '', 'Har-Us', 'Transcof', 'Pontiac', 1),
	(6, 'Feodor Beament', '30', 'F', '113-308-0753', '', 'Sankanan', 'Prodder', 'Ford', 1),
	(7, 'Kristen Blackshaw', '88', 'F', '220-775-5313', '', 'Voronezh', 'Transcof', 'Cadillac', 2),
	(8, 'Keane Janacek', '53', 'M', '489-592-5599', '', 'Jinguoping', 'Transcof', 'Volvo', 2),
	(9, 'Allister Roffe', '60', 'M', '876-531-9955', '', 'Casal', 'Solarbreeze', 'Mazda', 2),
	(10, 'Patrica Pawlyn', '16', 'M', '922-601-3122', '', 'Ganquan', 'Domainer', 'Acura', 2),
	(11, 'Paige Grimmert', '48', 'F', '686-928-5257', '', 'Zhaitou', 'Cardguard', 'Cadillac', 2),
	(12, 'Gabey Mulholland', '67', 'M', '447-629-2468', '', 'Laoqiao', 'Viva', 'Pontiac', 3),
	(13, 'Kizzie Morais', '14', 'M', '352-290-0526', '', 'Zhangfeng', 'Tin', 'Mercedes-Benz', 3),
	(14, 'Gustavus Blasgen', '29', 'M', '745-866-0012', '', 'Padasuka', 'Zamit', 'Mazda', 3),
	(15, 'Javier Fawthrop', '56', 'F', '207-956-5327', '', 'Novaya Tavolzhanka', 'Asoka', 'Ford', 4),
	(16, 'Konstanze Cowup', '27', 'F', '441-682-7939', '', 'Dongpu', 'Sonair', 'Mazda', 4),
	(17, 'Gayla Attenborrow', '41', 'M', '291-976-6299', '', 'Besteiros', 'Konklux', 'Pontiac', 4),
	(18, 'Durand Pierrepoint', '23', 'F', '331-485-4930', '', 'San Juan de la Maguana', 'Aerified', 'Toyota', 5),
	(19, 'Winn Braisher', '90', 'M', '554-274-0243', '', 'Laslovo', 'Stronghold', 'Pontiac', 5),
	(20, 'Sonnie Ride', '8', 'F', '524-395-7078', '', 'Malambo', 'Home Ing', 'Mitsubishi', 5),
	(21, 'Austen Winscomb', '15', 'M', '132-983-7927', '', 'Wanzu', 'Transcof', 'Volvo', 6),
	(22, 'Anissa Dunsmore', '95', 'F', '698-204-1025', '', 'Le Lamentin', 'Fintone', 'Lexus', 6),
	(23, 'Alexis Berrycloth', '89', 'F', '790-981-8684', '', 'Kėdainiai', 'Stringtough', 'Pontiac', 6),
	(24, 'Luisa Lampel', '84', 'F', '796-966-7372', '', 'Los Mangos', 'Latlux', 'Toyota', 6),
	(25, 'Johnath Upstell', '23', 'M', '694-382-6928', '', 'Ilinden', 'Veribet', 'Dodge', 7),
	(26, 'Juliet Boar', '59', 'F', '473-299-0781', '', 'Sobo', 'Alphazap', 'Ford', 7),
	(27, 'Jerry Sarfat', '99', 'F', '774-704-2616', '', 'Sano', 'Namfix', 'Bentley', 7),
	(28, 'Olga Curado', '25', 'F', '440-227-9666', '', 'Catalina', 'Bitchip', 'Toyota', 7),
	(29, 'Maryjane Redan', '89', 'M', '529-874-4229', '', 'Wonorejo', 'Greenlam', 'Lincoln', 7),
	(30, 'Corbet Coveney', '67', 'F', '580-402-9370', '', 'Ampasimanolotra', 'Flexidy', 'Chevrolet', 8),
	(31, 'Nikolos Campkin', '77', 'F', '853-546-5609', '', 'Tân Sơn', 'Bytecard', 'Subaru', 8),
	(32, 'Hercule Dyke', '20', 'F', '970-649-6123', '', 'Sidamulya Satu', 'Job', 'Nissan', 8),
	(33, 'Silva Merriday', '97', 'M', '932-631-6718', '', 'Volkhovskiy', 'Hatity', 'Ford', 8),
	(34, 'Robby Brierly', '88', 'M', '411-453-4954', '', 'Nanyang', 'Kanlam', 'Chevrolet', 8),
	(35, 'Salem Robberecht', '21', 'F', '477-138-3488', '', 'Chaiyo', 'Tin', 'Mitsubishi', 9),
	(36, 'Rhody Rooney', '63', 'F', '767-853-8363', '', 'Taishihe', 'Y-find', 'Chevrolet', 10),
	(37, 'Tammie Argrave', '51', 'F', '550-705-8526', '', 'Cerro Blanco', 'Andalax', 'Plymouth', 10),
	(38, 'Estell Bubear', '75', 'M', '792-770-7032', '', 'Bukabu', 'Andalax', 'Ram', 10),
	(39, 'Kim Callard', '67', 'F', '891-384-4693', '', 'Tojal', 'Sub-Ex', 'Toyota', 10),
	(40, 'Brigitte Jonson', '24', 'F', '407-164-4478', '', 'Kondangrege', 'Asoka', 'Kia', 10),
	(41, 'Thia Streatfield', '50', 'M', '989-214-0903', '', 'San Jose', 'Lotlux', 'Cadillac', 10),
	(42, 'Annice Barrasse', '69', 'M', '501-819-5353', '', 'Chatuchak', 'Voltsillam', 'Nissan', 11),
	(43, 'Cristabel Gell', '95', 'F', '938-999-1457', '', 'Gouqi', 'Pannier', 'Mercedes-Benz', 11),
	(44, 'Afton Hansie', '72', 'M', '423-701-4440', '', 'Moyo', 'Zaam-Dox', 'Chevrolet', 11),
	(45, 'Durant Flucker', '68', 'F', '156-643-0782', '', 'Qīr Moāv', 'Biodex', 'Mitsubishi', 11),
	(46, 'Caresa Swalwell', '79', 'F', '510-872-6178', '', 'Longxian Chengguanzhen', 'Viva', 'Chevrolet', 12),
	(47, 'Beryl Whifen', '82', 'M', '264-407-4937', '', 'Sanchang', 'Job', 'Chrysler', 12),
	(48, 'Rochette Gergler', '96', 'M', '333-785-7473', '', 'Umeå', 'Duobam', 'BMW', 12),
	(49, 'Forest Warbey', '83', 'M', '818-202-4546', '', 'Boksitogorsk', 'Wrapsafe', 'Saturn', 13),
	(50, 'Eustacia Firminger', '27', 'M', '271-409-7842', '', 'Boa Vista', 'Bytecard', 'Chevrolet', 13),
	(51, 'Sigismondo Shillitto', '64', 'M', '863-575-2747', '', 'Lakeland', 'Voyatouch', 'Suzuki', 13),
	(52, 'Auroora Asmus', '16', 'M', '696-683-9991', '', 'Hualin', 'Kanlam', 'Chevrolet', 14),
	(53, 'Marie De Lascy', '35', 'M', '252-977-2151', '', 'Subusub', 'Konklux', 'Saturn', 14),
	(54, 'Lev McCuish', '55', 'M', '250-316-3677', '', 'Palauig', 'Ronstring', 'Buick', 14),
	(55, 'Winnie Wearing', '53', 'M', '161-160-5632', '', 'Saint-Louis', 'Job', 'Pontiac', 14),
	(56, 'Emmery Restall', '85', 'F', '570-479-4712', '', 'Malekān', 'Zaam-Dox', 'GMC', 15),
	(57, 'Even Kem', '22', 'M', '540-925-3551', '', 'Sepekov', 'Subin', 'Acura', 15),
	(58, 'Elisa Beardwell', '46', 'M', '824-391-2806', '', 'Niimi', 'Toughjoyfax', 'Volkswagen', 15),
	(59, 'Henry Aikenhead', '99', 'M', '309-867-2469', '', 'Bugarama', 'Fix San', 'Kia', 16),
	(60, 'Delainey Levay', '56', 'F', '272-119-6048', '', 'Claremorris', 'Keylex', 'Subaru', 17),
	(61, 'Raphael Keyworth', '88', 'M', '365-737-7690', '', 'Kokologo', 'Alphazap', 'Lincoln', 18),
	(62, 'Blinnie Leebetter', '41', 'M', '506-739-8178', '', 'Gaïtánion', 'Job', 'Acura', 19),
	(63, 'Kendall Scirman', '20', 'F', '951-327-7699', '', 'Hengshui', 'Stim', 'Ford', 18),
	(64, 'Estell Mercy', '91', 'M', '753-707-7358', '', 'Chengnan', 'Treeflex', 'GMC', 18),
	(65, 'Marcie Atyea', '61', 'F', '947-187-8317', '', 'Burayevo', 'Zathin', 'Chevrolet', 18),
	(66, 'Tremain Verty', '26', 'M', '598-564-8173', '', 'Gul’cha', 'Redhold', 'Toyota', 19),
	(67, 'Cirilo Harber', '8', 'F', '899-938-7353', '', 'Ivyanyets', 'Veribet', 'Ford', 19),
	(68, 'Dana Hackwell', '44', 'F', '896-629-6092', '', 'Buriwutung', 'Sonsing', 'Mitsubishi', 19),
	(69, 'Arleta Tonn', '58', 'F', '100-980-7139', '', 'Zhangshui', 'Span', 'Saturn', 19),
	(70, 'Hynda Blanch', '78', 'M', '797-740-9344', '', 'Shahezi', 'Toughjoyfax', 'Buick', 19),
	(71, 'Helene Kienzle', '33', 'M', '615-224-1650', '', 'Karangsonojabon', 'Tresom', 'Nissan', 19),
	(72, 'Alida Hawley', '30', 'F', '238-756-4376', '', 'Aubervilliers', 'Voyatouch', 'Ford', 20),
	(73, 'Fax McClifferty', '69', 'F', '222-723-3356', '', 'Helong', 'Latlux', 'Toyota', 20),
	(74, 'Creigh Moss', '54', 'M', '318-570-9847', '', 'Bambuí', 'Biodex', 'Bentley', 20),
	(75, 'Michael Varsey', '81', 'F', '771-428-6671', '', 'Sagang', 'Zontrax', 'Mitsubishi', 20),
	(76, 'Judi Boadby', '76', 'F', '513-844-3847', '', 'Cincinnati', 'Y-find', 'Pontiac', 20),
	(77, 'Rebe Letty', '58', 'M', '430-732-5261', '', 'Bobadela', 'Greenlam', 'Chevrolet', 21),
	(78, 'Morgen Brody', '96', 'M', '708-438-5446', '', 'Piedra del Águila', 'Otcom', 'GMC', 21),
	(79, 'Dudley McBay', '2', 'F', '446-926-5270', '', 'Coayllo', 'Y-find', 'Chevrolet', 10),
	(80, 'Shayne Barstowk', '59', 'F', '818-820-3391', '', 'Antiguo Cuscatlán', 'Veribet', 'Chevrolet', 10),
	(81, 'Vlad Aslie', '51', 'F', '360-323-0456', '', 'Same', 'Sub-Ex', 'Chevrolet', 10),
	(82, 'Tome Thomesson', '12', 'M', '221-998-2637', '', 'Bantay', 'Alpha', 'Ford', 11),
	(83, 'Norby Orford', '93', 'M', '397-703-6754', '', 'Itumbiara', 'Stringtough', 'Toyota', 4),
	(84, 'Nanni Dorran', '70', 'F', '514-411-0135', '', 'Xijiang', 'Keylex', 'GMC', 4),
	(85, 'Silvio Congrave', '28', 'F', '572-481-8460', '', 'Hirosaki', 'Cardguard', 'GMC', 5),
	(86, 'Darryl Hamer', '23', 'F', '477-637-8180', '', 'Chistopol’', 'Flexidy', 'Honda', 5),
	(87, 'Cordie Calam', '24', 'M', '191-540-9066', '', 'Javānrūd', 'Konklab', 'Toyota', 6),
	(88, 'Bartholemy Crofthwaite', '89', 'F', '648-803-5171', '', 'Kuidou', 'Stronghold', 'Saturn', 6),
	(89, 'Marrilee Stallion', '6', 'F', '166-789-8730', '', 'Wufeng', 'Stronghold', 'Mercedes-Benz', 7),
	(90, 'Hinze Tolhurst', '54', 'F', '680-229-6239', '', 'Sobhādero', 'Tampflex', 'Mitsubishi', 7),
	(91, 'Orion Pendreigh', '65', 'F', '795-496-2282', '', 'Lyubar', 'Zathin', 'Suzuki', 8),
	(92, 'Lucas Pashen', '57', 'F', '376-522-5140', '', 'Kuala Terengganu', 'Otcom', 'Ford', 8),
	(93, 'Winni MacDearmaid', '31', 'F', '567-932-8533', '', 'Olhos de Água', 'Temp', 'Mitsubishi', 8),
	(94, 'Jazmin Tchaikovsky', '32', 'F', '140-965-2076', '', 'Faro', 'Fintone', 'Mitsubishi', 9),
	(95, 'Alon Tytcomb', '22', 'F', '388-881-7746', '', 'Kórnik', 'Lotstring', 'Oldsmobile', 9),
	(96, 'Wallie Ketch', '72', 'F', '765-711-2681', '', 'Santo Anastácio', 'Sonair', 'Buick', 18),
	(97, 'Samson Bootland', '37', 'M', '438-377-2264', '', 'Gaogu', 'Latlux', 'GMC', 18),
	(98, 'Merralee Cammidge', '54', 'F', '947-131-3192', '', 'Xinzhou', 'Holdlamis', 'Mercury', 18),
	(99, 'Wadsworth Lockart', '67', 'M', '329-134-7549', '', 'Örbyhus', 'Aerified', 'Honda', 17),
	(100, 'Rod MacAllester', '64', 'F', '909-385-8158', '', 'Zhougao', 'Ventosanzap', 'Acura', 17);

-- 테이블 mini.user 구조 내보내기
CREATE TABLE IF NOT EXISTS `user` (
  `u_idx` int(11) NOT NULL AUTO_INCREMENT,
  `u_id` varchar(50) DEFAULT NULL,
  `u_password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`u_idx`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- 테이블 데이터 mini.user:~21 rows (대략적) 내보내기
INSERT INTO `user` (`u_idx`, `u_id`, `u_password`) VALUES
	(1, 'Talboy', '7'),
	(2, 'Eakle', '37124'),
	(3, 'Bruneton', '85'),
	(4, 'Stroulger', '6070'),
	(5, 'Sanches', '2'),
	(6, 'Blenkhorn', '22762'),
	(7, 'Ghirigori', '67186'),
	(8, 'Peaurt', '98'),
	(9, 'Kingshott', '8'),
	(10, 'Bulfoy', '81'),
	(11, 'Sibun', '88497'),
	(12, 'Scapens', '9292'),
	(13, 'Mcmanaman', '95538'),
	(14, 'Kirsz', '6305'),
	(15, 'Sutherden', '643'),
	(16, 'Heak', '85'),
	(17, 'Bentham3', '8'),
	(18, 'Tourmell', '297'),
	(19, 'Moxstead', '81'),
	(20, 'Fellibrand', '1'),
	(21, 'aaaa', '1111');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
