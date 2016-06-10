/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     6/9/2016 11:11:13 PM                         */
/*==============================================================*/


drop table if exists attr_conf;

drop table if exists configuration;

drop table if exists conf_dict;

drop table if exists conf_dict_element;

drop table if exists data_dict;

drop table if exists data_dict_element;

drop table if exists data_source;

drop table if exists data_source_info;

drop table if exists mapping_between_origin_attr_and_target_attr;

drop table if exists mapping_between_origin_table_and_target_table;

drop table if exists origin_attr;

drop table if exists origin_table;

drop table if exists rule_def;

drop table if exists rule_mapping;

drop table if exists target_attr;

drop table if exists target_attr_and_attr_conf;

drop table if exists target_table;

/*==============================================================*/
/* Table: attr_conf                                             */
/*==============================================================*/
create table attr_conf
(
   attr_conf_id         int not null,
   conf_dict_id         int,
   aconf_name_en        varchar(60),
   aconf_name_cn        varchar(60),
   is_optional          bool,
   column_type          varchar(60),
   default_value        varchar(60),
   description          varchar(255),
   primary key (attr_conf_id)
)
engine = innodb
auto_increment = 1
default charset = utf8;

/*==============================================================*/
/* Table: configuration                                         */
/*==============================================================*/
create table configuration
(
   configuration_id     int not null auto_increment,
   conf_key             varchar(255),
   conf_value           varchar(255),
   primary key (configuration_id)
)
engine = innodb
auto_increment = 1
default charset = utf8;

/*==============================================================*/
/* Table: conf_dict                                             */
/*==============================================================*/
create table conf_dict
(
   conf_dict_id         int not null,
   name_en              varchar(60),
   name_cn              varchar(60),
   is_type              bool,
   description          varchar(255),
   primary key (conf_dict_id)
)
engine = innodb
auto_increment = 1
default charset = utf8;

/*==============================================================*/
/* Table: conf_dict_element                                     */
/*==============================================================*/
create table conf_dict_element
(
   conf_dict_elem_id    int not null,
   conf_dict_id         int,
   elem_value           varchar(60),
   description          varchar(60),
   is_default           bool,
   primary key (conf_dict_elem_id)
)
engine = innodb
auto_increment = 1
default charset = utf8;

/*==============================================================*/
/* Table: data_dict                                             */
/*==============================================================*/
create table data_dict
(
   data_dict_id         int not null,
   dict_name            varchar(60),
   dict_type            varchar(60),
   description          varchar(255),
   primary key (data_dict_id)
)
engine = innodb
auto_increment = 1
default charset = utf8;

/*==============================================================*/
/* Table: data_dict_element                                     */
/*==============================================================*/
create table data_dict_element
(
   data_dict_elem_id    int not null,
   data_dict_id         int,
   element_key          varchar(255),
   element_value        varchar(255),
   primary key (data_dict_elem_id)
)
engine = innodb
auto_increment = 1
default charset = utf8;

/*==============================================================*/
/* Table: data_source                                           */
/*==============================================================*/
create table data_source
(
   data_source_id       int not null,
   source_name          varchar(60),
   sample_value         varchar(255),
   primary key (data_source_id)
)
engine = innodb
auto_increment = 1
default charset = utf8;

/*==============================================================*/
/* Table: data_source_info                                      */
/*==============================================================*/
create table data_source_info
(
   data_source_info_id  int not null,
   data_source_id       int,
   source_info_name     varchar(60),
   url                  varchar(255),
   username             varchar(60),
   password             varchar(60),
   owner                varchar(60),
   schema_split         varchar(60),
   schema_input         varchar(255),
   primary key (data_source_info_id)
)
engine = innodb
auto_increment = 1
default charset = utf8;

/*==============================================================*/
/* Table: mapping_between_origin_attr_and_target_attr           */
/*==============================================================*/
create table mapping_between_origin_attr_and_target_attr
(
   target_attr_id       int not null,
   origin_attr_id       int not null,
   value                varchar(255),
   primary key (target_attr_id, origin_attr_id)
)
engine = innodb
auto_increment = 1
default charset = utf8;

/*==============================================================*/
/* Table: mapping_between_origin_table_and_target_table         */
/*==============================================================*/
create table mapping_between_origin_table_and_target_table
(
   target_table_id      int not null,
   origin_table_id      int not null,
   primary key (target_table_id, origin_table_id)
)
engine = innodb
auto_increment = 1
default charset = utf8;

/*==============================================================*/
/* Table: origin_attr                                           */
/*==============================================================*/
create table origin_attr
(
   origin_attr_id       int not null,
   origin_table_id      int,
   attr_name            varchar(60),
   sample               varchar(255),
   column_type          int,
   description          varchar(255),
   row_order            int,
   primary key (origin_attr_id)
)
engine = innodb
auto_increment = 1
default charset = utf8;

/*==============================================================*/
/* Table: origin_table                                          */
/*==============================================================*/
create table origin_table
(
   origin_table_id      int not null,
   data_source_info_id  int,
   tb_name_en           varchar(60),
   tb_name_cn           varchar(60),
   description          varchar(255),
   is_incremental       int,
   incre_col_name       varchar(60),
   incre_col_type       int,
   primary key (origin_table_id)
)
engine = innodb
auto_increment = 1
default charset = utf8;

/*==============================================================*/
/* Table: rule_def                                              */
/*==============================================================*/
create table rule_def
(
   rule_def_id          int not null,
   rule_name            varchar(60),
   rule_type            varchar(60),
   description          varchar(255),
   param                text,
   annotation           varchar(60),
   primary key (rule_def_id)
)
engine = innodb
auto_increment = 1
default charset = utf8;

/*==============================================================*/
/* Table: rule_mapping                                          */
/*==============================================================*/
create table rule_mapping
(
   rule_mapping_id      int not null,
   attr_mapping_id      int,
   rule_def_id          int,
   param_value          varchar(255),
   rule_order           int,
   primary key (rule_mapping_id)
)
engine = innodb
auto_increment = 1
default charset = utf8;

alter table rule_mapping comment '????';

/*==============================================================*/
/* Table: target_attr                                           */
/*==============================================================*/
create table target_attr
(
   target_attr_id       int not null,
   target_table_id      int,
   attr_name_en         varchar(60),
   attr_name_cn         varchar(60),
   sample               varchar(255),
   column_type          varchar(60),
   origin_tb_is_existed bool,
   description          varchar(255),
   primary key (target_attr_id)
)
engine = innodb
auto_increment = 1
default charset = utf8;

/*==============================================================*/
/* Table: target_attr_and_attr_conf                             */
/*==============================================================*/
create table target_attr_and_attr_conf
(
   attr_conf_id         int not null,
   target_attr_id       int not null,
   conf_value           varchar(60),
   primary key (attr_conf_id, target_attr_id)
)
engine = innodb
auto_increment = 1
default charset = utf8;

/*==============================================================*/
/* Table: target_table                                          */
/*==============================================================*/
create table target_table
(
   target_table_id      int not null,
   label_en             varchar(60),
   label_cn             varchar(60),
   tb_number            int,
   element_type         varchar(60),
   description          varchar(255),
   version              varchar(60),
   primary key (target_table_id)
)
engine = innodb
auto_increment = 1
default charset = utf8;

alter table attr_conf add constraint fk_attr_conf_and_conf_param foreign key (conf_dict_id)
      references conf_dict (conf_dict_id) on delete restrict on update restrict;

alter table conf_dict_element add constraint fk_conf_dict_and_conf_element foreign key (conf_dict_id)
      references conf_dict (conf_dict_id) on delete restrict on update restrict;

alter table data_dict_element add constraint fk_rule_dict_and_rule_dict_element foreign key (data_dict_id)
      references data_dict (data_dict_id) on delete restrict on update restrict;

alter table data_source_info add constraint fk_data_source_info_and_data_source foreign key (data_source_id)
      references data_source (data_source_id) on delete restrict on update restrict;

alter table mapping_between_origin_attr_and_target_attr add constraint fk_mapping_between_origin_attr_and_target_attr foreign key (target_attr_id)
      references target_attr (target_attr_id) on delete restrict on update restrict;

alter table mapping_between_origin_attr_and_target_attr add constraint fk_mapping_between_origin_attr_and_target_attr2 foreign key (origin_attr_id)
      references origin_attr (origin_attr_id) on delete restrict on update restrict;

alter table mapping_between_origin_table_and_target_table add constraint fk_mapping_between_origin_table_and_target_table foreign key (target_table_id)
      references target_table (target_table_id) on delete restrict on update restrict;

alter table mapping_between_origin_table_and_target_table add constraint fk_mapping_between_origin_table_and_target_table2 foreign key (origin_table_id)
      references origin_table (origin_table_id) on delete restrict on update restrict;

alter table origin_attr add constraint fk_origin_table_and_origin_attr foreign key (origin_table_id)
      references origin_table (origin_table_id) on delete restrict on update restrict;

alter table origin_table add constraint fk_origin_table_and_data_source_info foreign key (data_source_info_id)
      references data_source_info (data_source_info_id) on delete restrict on update restrict;

alter table rule_mapping add constraint fk_mapping_object_and_rule foreign key (rule_def_id)
      references rule_def (rule_def_id) on delete restrict on update restrict;

alter table target_attr add constraint fk_target_table_and_target_attr foreign key (target_table_id)
      references target_table (target_table_id) on delete restrict on update restrict;

alter table target_attr_and_attr_conf add constraint fk_target_attr_and_attr_conf foreign key (attr_conf_id)
      references attr_conf (attr_conf_id) on delete restrict on update restrict;

alter table target_attr_and_attr_conf add constraint fk_target_attr_and_attr_conf2 foreign key (target_attr_id)
      references target_attr (target_attr_id) on delete restrict on update restrict;

