
------------------------------------
DROP TABLE IF EXISTS `reply`;
DROP TABLE IF EXISTS `post`;
DROP TABLE IF EXISTS `user`;
DROP TABLE IF EXISTS `theme`;



------------------------------------
--user table
CREATE TABLE `user` (
  `userId` int(100) NOT NULL AUTO_INCREMENT,
  `userName` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(320) NOT NULL unique ,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

------------------------------------
-- theme table
CREATE TABLE `theme` (
  `themeId` int(100) NOT NULL AUTO_INCREMENT,
  `themeName` varchar(50) NOT NULL,
  PRIMARY KEY (`themeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

------------------------------------
--post table
CREATE TABLE `post` (
  `postId` int(100) NOT NULL AUTO_INCREMENT,
  `themeId` int(100) NOT NULL,
  `title` varchar(255) NOT NULL,
  `message`  varchar(2048) NOT NULL,
  `userId` int(100) NOT NULL,
  `postName` varchar(50) NOT null,
  `postTime` timestamp NOT NULL,
  `replyNum` int (100) DEFAULT 0 NOT NULL,
  PRIMARY KEY (`postId`),
  FOREIGN KEY fk_uId(userId) REFERENCES `user`(userId),
  FOREIGN KEY fk_tId(themeId) REFERENCES `theme`(themeId)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-------------------------------------
--reply table
CREATE TABLE `reply` (
  `postId`  int(100) NOT NULL,
  `layerNum` int(100) NOT NULL,
  `userId` int(100) NOT NULL,
  `replyName`  varchar(40) NOT NULL,
  `replyLayerNum` int(100) DEFAULT 0 NOT NULL,
  `content` varchar(1024) NOT NULL,
CONSTRAINT PK_PL PRIMARY KEY (`postId`,`layerNum`),
FOREIGN KEY fk_pId(postId) REFERENCES `post`(postId),
FOREIGN KEY fk_uId_R(userId) REFERENCES `user`(userId)
)ENGINE=InnoDB  DEFAULT CHARSET=utf8;


