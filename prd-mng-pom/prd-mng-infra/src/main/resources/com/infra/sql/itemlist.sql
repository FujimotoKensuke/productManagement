/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  kk
 */

CREATE TABLE `itemlist` (
  `itemid` varchar(12) NOT NULL,
  `itemname` varchar(255) NOT NULL,
  `itemprice` int(11) NOT NULL,
  `deletedFlg` int(11) NOT NULL,
  `version` bigint(20) NOT NULL,
  PRIMARY KEY (`itemid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8