DROP TABLE IF EXISTS sys_area;
CREATE TABLE sys_area
(
  id BIGINT NOT NULL AUTO_INCREMENT,
  parent_id BIGINT NOT NULL,
  parent_ids VARCHAR(2000) NOT NULL,
  name VARCHAR(100) NOT NULL,
  sort DECIMAL(10,0) NOT NULL,
  code VARCHAR(100),
  type CHAR(1),
  icon varchar(100),
  remarks VARCHAR(255),
  version BIGINT NOT NULL ,
  CONSTRAINT PK_SYS_AREA PRIMARY KEY (id)
);
CREATE INDEX sys_area_parent_id ON sys_area (parent_id);



