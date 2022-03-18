insert into api_authenticator.oauth_client_details
(
   creation_date,
   change_date,
   user_id,
   client_id,
   resource_ids,
   client_secret,
   `scope`,
   authorized_grant_types,
   web_server_redirect_uri,
   authorities,
   access_token_validity,
   refresh_token_validity,
   additional_information,
   autoapprove
)
values
(
   NOW(),
   NOW(),
   1,
   'lstecnologia',
   null,
   '$2a$12$HD08hsMiGqlmvfwvGxuSTeg1SHYSizR9pmzOK5bnR1.0jJ6uhdnte',
   'READ,WRITE',
   'password,client_credentials,refresh_token',
   null,
   null,
   99999,
   99999,
   null,
   ''
);