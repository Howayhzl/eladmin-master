/*==============================================================*/
/* DBMS name:      Microsoft SQL Server 2008                    */
/* Created on:     2019/4/11 18:06:43                           */
/*==============================================================*/


if exists (select 1
            from  sysobjects
           where  id = object_id('company')
            and   type = 'U')
   drop table company
go

if exists (select 1
            from  sysobjects
           where  id = object_id('data_dictionary')
            and   type = 'U')
   drop table data_dictionary
go

if exists (select 1
            from  sysobjects
           where  id = object_id('data_type')
            and   type = 'U')
   drop table data_type
go

if exists (select 1
            from  sysobjects
           where  id = object_id('general_survey')
            and   type = 'U')
   drop table general_survey
go

if exists (select 1
            from  sysobjects
           where  id = object_id('meter_reading')
            and   type = 'U')
   drop table meter_reading
go

if exists (select 1
            from  sysobjects
           where  id = object_id('picture_resources')
            and   type = 'U')
   drop table picture_resources
go

/*==============================================================*/
/* Table: company                                               */
/*==============================================================*/
create table company (
   id                   bigint               not null,
   parent_id            bigint               null,
   name                 varchar(20)          not null,
   person               varchar(15)          null,
   phone                varchar(15)          null,
   address              varchar(50)          null,
   create_time          datetime             not null,
   valid_status         bit                  not null,
   constraint PK_COMPANY primary key (id)
)
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '主键',
   'user', @CurrentUser, 'table', 'company', 'column', 'id'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '父节点编码',
   'user', @CurrentUser, 'table', 'company', 'column', 'parent_id'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '公司名称',
   'user', @CurrentUser, 'table', 'company', 'column', 'name'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '联系人',
   'user', @CurrentUser, 'table', 'company', 'column', 'person'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '联系方式',
   'user', @CurrentUser, 'table', 'company', 'column', 'phone'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '地址',
   'user', @CurrentUser, 'table', 'company', 'column', 'address'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '创建时间',
   'user', @CurrentUser, 'table', 'company', 'column', 'create_time'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '状态',
   'user', @CurrentUser, 'table', 'company', 'column', 'valid_status'
go

/*==============================================================*/
/* Table: data_dictionary                                       */
/*==============================================================*/
create table data_dictionary (
   id                   bigint               not null,
   company_id           bigint               null,
   type_id              bigint               not null,
   type_value           varchar(15)          not null,
   create_time          datetime             not null,
   valid_status         bit                  not null,
   constraint PK_DATA_DICTIONARY primary key (id)
)
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '主键',
   'user', @CurrentUser, 'table', 'data_dictionary', 'column', 'id'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '公司编码',
   'user', @CurrentUser, 'table', 'data_dictionary', 'column', 'company_id'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '类型id',
   'user', @CurrentUser, 'table', 'data_dictionary', 'column', 'type_id'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '类型值',
   'user', @CurrentUser, 'table', 'data_dictionary', 'column', 'type_value'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '创建时间',
   'user', @CurrentUser, 'table', 'data_dictionary', 'column', 'create_time'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '状态',
   'user', @CurrentUser, 'table', 'data_dictionary', 'column', 'valid_status'
go

/*==============================================================*/
/* Table: data_type                                             */
/*==============================================================*/
create table data_type (
   id                   bigint               not null,
   name                 varchar(15)          not null,
   create_time          datetime             not null,
   valid_status         bit                  not null,
   constraint PK_DATA_TYPE primary key (id)
)
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '主键',
   'user', @CurrentUser, 'table', 'data_type', 'column', 'id'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '类型值',
   'user', @CurrentUser, 'table', 'data_type', 'column', 'name'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '创建时间',
   'user', @CurrentUser, 'table', 'data_type', 'column', 'create_time'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '状态',
   'user', @CurrentUser, 'table', 'data_type', 'column', 'valid_status'
go

/*==============================================================*/
/* Table: general_survey                                        */
/*==============================================================*/
create table general_survey (
   id                   bigint               not null,
   company_id           bigint               not null,
   unit_name            varchar(30)          not null,
   meter_brand          varchar(15)          null,
   caliber              varchar(15)          null,
   form                 varchar(15)          null,
   serial_number        varchar(20)          null,
   Installation_time    datetime             null,
   length               varchar(5)           null,
   piping_material      varchar(5)           null,
   valve_type           varchar(5)           null,
   valve_diameter       varchar(5)           null,
   flange_number        varchar(20)          null,
   position             varchar(50)          null,
   online_performance   varchar(50)          not null,
   constraint PK_GENERAL_SURVEY primary key (id)
)
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '主键',
   'user', @CurrentUser, 'table', 'general_survey', 'column', 'id'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '公司id',
   'user', @CurrentUser, 'table', 'general_survey', 'column', 'company_id'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '单位',
   'user', @CurrentUser, 'table', 'general_survey', 'column', 'unit_name'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '水表品牌',
   'user', @CurrentUser, 'table', 'general_survey', 'column', 'meter_brand'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '口径',
   'user', @CurrentUser, 'table', 'general_survey', 'column', 'caliber'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '制式',
   'user', @CurrentUser, 'table', 'general_survey', 'column', 'form'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '编号',
   'user', @CurrentUser, 'table', 'general_survey', 'column', 'serial_number'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '安装年限',
   'user', @CurrentUser, 'table', 'general_survey', 'column', 'Installation_time'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '长度',
   'user', @CurrentUser, 'table', 'general_survey', 'column', 'length'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '管道材质',
   'user', @CurrentUser, 'table', 'general_survey', 'column', 'piping_material'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '阀门制式',
   'user', @CurrentUser, 'table', 'general_survey', 'column', 'valve_type'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '阀门口径',
   'user', @CurrentUser, 'table', 'general_survey', 'column', 'valve_diameter'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '法栏孔数',
   'user', @CurrentUser, 'table', 'general_survey', 'column', 'flange_number'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '位置',
   'user', @CurrentUser, 'table', 'general_survey', 'column', 'position'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '在线运行情况',
   'user', @CurrentUser, 'table', 'general_survey', 'column', 'online_performance'
go

/*==============================================================*/
/* Table: meter_reading                                         */
/*==============================================================*/
create table meter_reading (
   id                   bigint               not null,
   company_id           bigint               not null,
   unit_name            varchar(20)          not null,
   water_consumption    bitint               not null,
   create_time          datetime             not null,
   valid_status         bit                  not null,
   constraint PK_METER_READING primary key (id)
)
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '主键',
   'user', @CurrentUser, 'table', 'meter_reading', 'column', 'id'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '公司编码',
   'user', @CurrentUser, 'table', 'meter_reading', 'column', 'company_id'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '单位名称',
   'user', @CurrentUser, 'table', 'meter_reading', 'column', 'unit_name'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '用水量',
   'user', @CurrentUser, 'table', 'meter_reading', 'column', 'water_consumption'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '抄表时间',
   'user', @CurrentUser, 'table', 'meter_reading', 'column', 'create_time'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '状态',
   'user', @CurrentUser, 'table', 'meter_reading', 'column', 'valid_status'
go

/*==============================================================*/
/* Table: picture_resources                                     */
/*==============================================================*/
create table picture_resources (
   id                   bigint               not null,
   general_id           bigint               not null,
   url                  varchar(50)          not null,
   constraint PK_PICTURE_RESOURCES primary key (id)
)
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '主键',
   'user', @CurrentUser, 'table', 'picture_resources', 'column', 'id'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '普查id',
   'user', @CurrentUser, 'table', 'picture_resources', 'column', 'general_id'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '图片路径',
   'user', @CurrentUser, 'table', 'picture_resources', 'column', 'url'
go

