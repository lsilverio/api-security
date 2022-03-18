INSERT INTO api_authenticator.profile
(
   active,
   change_date,
   creation_date,
   excluded,
   justification_inactivation,
   user_id,
   description,
   name
)
VALUES
(
   1,
   NOW(),
   NOW(),
   0,
   NULL,
   1,
   'Perfil do administrador do sistema',
   'ADMNISTRADOR'
);
