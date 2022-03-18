CREATE TABLE user_profile (
  user_id bigint NOT NULL,
  profile_id bigint NOT NULL,
  PRIMARY KEY (user_id,profile_id),
  KEY FKqfbftbxicceqbmvj87g9be2qn (profile_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8