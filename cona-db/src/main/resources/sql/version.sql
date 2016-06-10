/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     5/9/2016 6:39:26 PM                          */
/*==============================================================*/


drop table if exists data_version_consumer;

drop table if exists data_version_produce;

/*==============================================================*/
/* Table: data_version_consumer                                 */
/*==============================================================*/
create table data_version_consumer
(
   VERSIONCONSUMERID    int not null auto_increment,
   CONSUMERNAME         varchar(100),
   ORIGID               int,
   VERSIONPRODUCERID    int,
   VERSION              int,
   CONSUMEREDTIME       date,
   CONSUMERED           smallint,
   primary key (VERSIONCONSUMERID)
)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARSET = utf8;

/*==============================================================*/
/* Table: data_version_produce                                  */
/*==============================================================*/
create table data_version_produce
(
   VERSIONPRODUCERID    int not null auto_increment,
   SOURCEID             int,
   TABLEID              int,
   COMPLETED            smallint,
   VERSION              int,
   START                blob,
   END                  blob,
   COMPLETEDTIME        date,
   primary key (VERSIONPRODUCERID)
)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARSET = utf8;

