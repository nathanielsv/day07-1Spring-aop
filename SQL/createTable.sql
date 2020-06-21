drop table if exists t_customer;

/*==============================================================*/
/* Table: t_customer                                            */
/*==============================================================*/
create table t_customer
(
   cid                  varchar(60) not null,
   cname                varchar(60),
   cbalance             float,
   primary key (cid)
);


DROP TABLE IF EXISTS t_transfer_log;

/*==============================================================*/
/* Table: t_transfer_log                                        */
/*==============================================================*/
CREATE TABLE t_transfer_log
(
   NO                   VARCHAR(60) NOT NULL,
   sid                  VARCHAR(60),
   tid                  VARCHAR(60),
   money                FLOAT,
   begin_time           DATETIME,
   end_time             DATETIME,
   STATUS               VARCHAR(60),
   msg                  VARCHAR(60),
   exception            VARCHAR(255),
   PRIMARY KEY (NO)
);
