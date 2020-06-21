-- 降低高水位
truncate table t_customer ;
insert into t_customer(cid,cname,cbalance) values ('c1','zhang3','100000') ;
insert into t_customer(cid,cname,cbalance) values ('c2','li4','100000') ;
insert into t_customer(cid,cname,cbalance) values ('c3','wang5','100000') ;
commit;
select * from t_customer ;