CREATE TABLE profile_permission (
  profile_id bigint NOT NULL,
  permission_id bigint NOT NULL,
  PRIMARY KEY (profile_id,permission_id),
  KEY FKl1xh3stwjjbnigw6ue5is47rp (permission_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8