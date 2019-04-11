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
   '����',
   'user', @CurrentUser, 'table', 'company', 'column', 'id'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '���ڵ����',
   'user', @CurrentUser, 'table', 'company', 'column', 'parent_id'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '��˾����',
   'user', @CurrentUser, 'table', 'company', 'column', 'name'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '��ϵ��',
   'user', @CurrentUser, 'table', 'company', 'column', 'person'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '��ϵ��ʽ',
   'user', @CurrentUser, 'table', 'company', 'column', 'phone'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '��ַ',
   'user', @CurrentUser, 'table', 'company', 'column', 'address'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '����ʱ��',
   'user', @CurrentUser, 'table', 'company', 'column', 'create_time'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '״̬',
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
   '����',
   'user', @CurrentUser, 'table', 'data_dictionary', 'column', 'id'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '��˾����',
   'user', @CurrentUser, 'table', 'data_dictionary', 'column', 'company_id'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '����id',
   'user', @CurrentUser, 'table', 'data_dictionary', 'column', 'type_id'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '����ֵ',
   'user', @CurrentUser, 'table', 'data_dictionary', 'column', 'type_value'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '����ʱ��',
   'user', @CurrentUser, 'table', 'data_dictionary', 'column', 'create_time'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '״̬',
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
   '����',
   'user', @CurrentUser, 'table', 'data_type', 'column', 'id'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '����ֵ',
   'user', @CurrentUser, 'table', 'data_type', 'column', 'name'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '����ʱ��',
   'user', @CurrentUser, 'table', 'data_type', 'column', 'create_time'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '״̬',
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
   '����',
   'user', @CurrentUser, 'table', 'general_survey', 'column', 'id'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '��˾id',
   'user', @CurrentUser, 'table', 'general_survey', 'column', 'company_id'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '��λ',
   'user', @CurrentUser, 'table', 'general_survey', 'column', 'unit_name'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'ˮ��Ʒ��',
   'user', @CurrentUser, 'table', 'general_survey', 'column', 'meter_brand'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '�ھ�',
   'user', @CurrentUser, 'table', 'general_survey', 'column', 'caliber'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '��ʽ',
   'user', @CurrentUser, 'table', 'general_survey', 'column', 'form'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '���',
   'user', @CurrentUser, 'table', 'general_survey', 'column', 'serial_number'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '��װ����',
   'user', @CurrentUser, 'table', 'general_survey', 'column', 'Installation_time'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '����',
   'user', @CurrentUser, 'table', 'general_survey', 'column', 'length'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '�ܵ�����',
   'user', @CurrentUser, 'table', 'general_survey', 'column', 'piping_material'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '������ʽ',
   'user', @CurrentUser, 'table', 'general_survey', 'column', 'valve_type'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '���ſھ�',
   'user', @CurrentUser, 'table', 'general_survey', 'column', 'valve_diameter'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '��������',
   'user', @CurrentUser, 'table', 'general_survey', 'column', 'flange_number'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'λ��',
   'user', @CurrentUser, 'table', 'general_survey', 'column', 'position'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '�����������',
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
   '����',
   'user', @CurrentUser, 'table', 'meter_reading', 'column', 'id'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '��˾����',
   'user', @CurrentUser, 'table', 'meter_reading', 'column', 'company_id'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '��λ����',
   'user', @CurrentUser, 'table', 'meter_reading', 'column', 'unit_name'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '��ˮ��',
   'user', @CurrentUser, 'table', 'meter_reading', 'column', 'water_consumption'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '����ʱ��',
   'user', @CurrentUser, 'table', 'meter_reading', 'column', 'create_time'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '״̬',
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
   '����',
   'user', @CurrentUser, 'table', 'picture_resources', 'column', 'id'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '�ղ�id',
   'user', @CurrentUser, 'table', 'picture_resources', 'column', 'general_id'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'ͼƬ·��',
   'user', @CurrentUser, 'table', 'picture_resources', 'column', 'url'
go

