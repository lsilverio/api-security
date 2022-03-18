INSERT INTO api_authenticator.`user`
(
   active,
   change_date,
   creation_date,
   excluded,
   justification_inactivation,
   user_id,
   name,
   password,
   username,
   expiration_date_uuid_password,
   uuid_password
)
VALUES
(
   1,
   NOW(),
   NOW(),
   0,
   NULL,
   1,
   'Lucas Silverio',
   '$2a$12$xJVyyBJYi6Jb/iWdTj4EaOp84qIfEJiuZq78cf255INwA9aPJEjAy',
   'sdp.silverio@gmail.com',
   NULL,
   NULL
);