CREATE TABLE profile (
  id bigint NOT NULL AUTO_INCREMENT,
  active bit(1) DEFAULT NULL,
  change_date timestamp NOT NULL,
  creation_date timestamp NOT NULL,
  excluded bit(1) DEFAULT NULL,
  justification_inactivation text,
  user_id bigint DEFAULT NULL,
  description varchar(255) NOT NULL,
  name varchar(255) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8