CREATE TABLE user (
  id bigint NOT NULL AUTO_INCREMENT,
  active bit(1) DEFAULT NULL,
  change_date timestamp NOT NULL,
  creation_date timestamp NOT NULL,
  excluded bit(1) DEFAULT NULL,
  justification_inactivation text,
  user_id bigint DEFAULT NULL,
  name varchar(255) NOT NULL,
  password varchar(255) NOT NULL,
  username varchar(255) NOT NULL,
  expiration_date_uuid_password datetime NULL,
  uuid_password varchar(255) NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8