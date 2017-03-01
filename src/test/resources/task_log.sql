DROP TABLE task_log IF EXISTS;
CREATE TABLE task_log (
  task_log_id INTEGER NOT NULL IDENTITY ,
  log_type char(1),
  task_id decimal(9) NOT NULL,
  schd_inst_id varchar(32),
  event_type char(2),
  session_id varchar(32),
  job_name varchar(200),
  job_class varchar(64),
  staff_no varchar(20),
  ip varchar(64),
  info varchar(1000),
  error_info varchar(2000),
  create_dt datetime,
  tenant_id decimal(11)
);

DROP TABLE task_manager IF EXISTS;
CREATE TABLE task_manager (
  task_id decimal(9) NOT NULL,
  task_code varchar(100) ,
  task_name varchar(50) ,
  gc_cd decimal(9) NOT NULL,
  thread_number decimal(9) NOT NULL,
  state_date datetime ,
  stop_date datetime ,
  task_state char(1) ,
  state_last_date datetime ,
  task_desc varchar(500) ,
  task_type char(1) ,
  enable_log char(1) ,
  task_type_cd decimal(9) ,
  task_style char(1) ,
  error_strategy_id decimal(9) ,
  parallelism_degree decimal(5) ,
  tenant_Id decimal(11)
);


DROP TABLE gather_cycle IF EXISTS;
CREATE TABLE gather_cycle (
  gc_cd decimal(9) NOT NULL,
  name varchar(128) ,
  gc_s_e_exp varchar(100) ,
  gc_desc varchar(500) ,
  tenant_Id decimal(11)
);

