-- 테이블 mini.person 구조
CREATE TABLE IF NOT EXISTS `person` (
  `idx` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `gender` varchar(50) DEFAULT NULL,
  `phoneNumber` varchar(50) DEFAULT NULL,
  `MBTI` varchar(50) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `nickName` varchar(50) DEFAULT NULL,
  `category` varchar(50) DEFAULT NULL,
  `u_idx` int(11) DEFAULT NULL,
  PRIMARY KEY (`idx`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- 테이블 mini.user 구조
CREATE TABLE IF NOT EXISTS `user` (
  `u_idx` int(11) NOT NULL AUTO_INCREMENT,
  `u_id` varchar(50) DEFAULT NULL,
  `u_password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`u_idx`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
