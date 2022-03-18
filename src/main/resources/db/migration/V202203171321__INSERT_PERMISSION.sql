INSERT INTO api_authenticator.permission
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
   'Consult all users',
   'USER_CONSULT_ALL'
),

(
   1,
   NOW(),
   NOW(),
   0,
   NULL,
   1,   
   'Consult user by id',
   'USER_CONSULT_BY_ID'
),

(
   1,
   NOW(),
   NOW(),
   0,
   NULL,
   1,   
   'Consult all users by id',
   'USER_CONSULT_ALL_BY_ID'
),

(
   1,
   NOW(),
   NOW(),
   0,
   NULL,
   1,   
   'Update user',
   'USER_UPDATE'
),

(
   1,
   NOW(),
   NOW(),
   0,
   NULL,
   1,   
   'Delete user',
   'USER_DELETE'
),

(
   1,
   NOW(),
   NOW(),
   0,
   NULL,
   1,
   'Consult all profiles',
   'PROFILE_CONSULT_ALL'
),

(
   1,
   NOW(),
   NOW(),
   0,
   NULL,
   1,   
   'Consult profile by id',
   'PROFILE_CONSULT_BY_ID'
),

(
   1,
   NOW(),
   NOW(),
   0,
   NULL,
   1,   
   'Register profile',
   'PROFILE_REGISTER'
),

(
   1,
   NOW(),
   NOW(),
   0,
   NULL,
   1,   
   'Update profile',
   'PROFILE_UPDATE'
),

(
   1,
   NOW(),
   NOW(),
   0,
   NULL,
   1,   
   'Delete profile',
   'PROFILE_DELETE'
),

(
   1,
   NOW(),
   NOW(),
   0,
   NULL,
   1,   
   'Consult all permissions',
   'PERMISSION_CONSULT_ALL'
),

(
   1,
   NOW(),
   NOW(),
   0,
   NULL,
   1,   
   'Consult permission by id',
   'PERMISSION_CONSULT_BY_ID'
),

(
   1,
   NOW(),
   NOW(),
   0,
   NULL,
   1,   
   'Update permission',
   'PERMISSION_UPDATE'
),

(
   1,
   NOW(),
   NOW(),
   0,
   NULL,
   1,   
   'Delete permission',
   'PERMISSION_DELETE'
)
;