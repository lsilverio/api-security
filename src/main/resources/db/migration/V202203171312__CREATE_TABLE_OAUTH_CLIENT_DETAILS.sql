CREATE TABLE oauth_client_details (
  change_date timestamp NOT NULL,
  creation_date timestamp NOT NULL,
  user_id bigint DEFAULT NULL,
  client_id varchar(255) NOT NULL,
  resource_ids varchar(256) DEFAULT NULL,
  client_secret varchar(256) DEFAULT NULL,
  scope varchar(256) DEFAULT NULL,
  authorized_grant_types varchar(256) DEFAULT NULL,
  web_server_redirect_uri varchar(256) DEFAULT NULL,
  authorities varchar(256) DEFAULT NULL,
  access_token_validity int DEFAULT NULL,
  refresh_token_validity int DEFAULT NULL,
  additional_information varchar(4096) DEFAULT NULL,
  autoapprove varchar(256) DEFAULT NULL,
  PRIMARY KEY (client_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8