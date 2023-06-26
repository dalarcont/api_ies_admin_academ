
# API IES Admin Academ

API REST Application for provide services to a Software of Management of IES (University).

*THIS SOFTWARE IS ONLY FOR LEARNING PURPOSES*

This API REST Application works as a provider of data that is requested by a desktop software environment to perform management operations of an University academic and administrative processes.




## API Reference (for V3.6.23)

### Get user's existence proof

```http
  GET /api/ies/users/${username}
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `{username}` | `string` | **Required**. Username |

Returns TRUE or FALSE.

### Get user's basic profile data

```http
  GET /api/ies/users/${username}/profiledata
```

| Parameter | Type     | Description            |
| :-------- | :------- |:-----------------------|
| `data`      | `string` | **Required**. Username |

Returns user profile object in JSON format

### Get employee's profile data

```http
  GET /api/ies/users/${username}/employeeprofile
```

| Parameter | Type     | Description            |
| :-------- | :------- |:-----------------------|
| `data`      | `string` | **Required**. Username |

Returns employee profile object in JSON format

### Get student's profile data

```http
  GET /api/ies/users/${username}/profiledata
```

| Parameter | Type     | Description            |
| :-------- | :------- |:-----------------------|
| `data`      | `string` | **Required**. Username |

Returns student profile object in JSON format

### Get user's match of credentials for login

```http
  GET /api/ies/users/${data}/matchlogin
```

| Parameter | Type     | Description                              |
| :-------- | :------- |:-----------------------------------------|
| `data`      | `string` | **Required**. Encoded user's credentials |

Returns TRUE or FALSE.

### Get employee's access validation to administration software

```http
  GET /api/ies/users/${username}/dskaccess
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `data`      | `string` | **Required**. Encoded user's credentials |

Returns TRUE or FALSE.

### Get student's access validation to software

```http
  GET /api/ies/users/${username}/dskaccess
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `data`      | `string` | **Required**. Encoded user's credentials |

Returns TRUE or FALSE.

### Get apps permissions for an employee

```http
  GET /api/ies/users/${data}/sysinfopermissions
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `data`      | `string` | **Required**. Encoded user's credentials |

Returns List of objects that contains app name, app code, and info.

### Set user's last access date (for HR inspections)

```http
  GET /api/ies/users/${data}/dsklastaccess
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `data`      | `string` | **Required**. Encoded user's credentials |

Returns TRUE or FALSE

### Add a new user

```http
  POST /api/ies/users
```

| Parameter                             | Type                      | Description                                      |
|:--------------------------------------|:--------------------------|:-------------------------------------------------|
| No parameter required in endpoint URL |
 Example of JSON Object required in the body request:
```http
  {
    "idPersona":"0123456789",
    "nombres":"Lorem",
    "apellidos":"Ipsum",
    "username":"loremipsum",
    "genero":"F",
    "email_personal":"lorem@ipsum.com",
    "email_laboral":"lorem@ipsum.work",
    "origen_pais":"ABC",
    "origen_ciudad":"Lorem",
    "reside_pais":"DEF",
    "reside_ciudad":"Ipsum",
    "escolaridad":"ESC1"
  }
```
- The field idPersona allows to use alphanumeric.
- The field genero allows to use only 'F' or 'M'.
- The fields origen_pais and reside_pais allows to use country code as ISO 3166 Alpha3
- The fields escolaridad allows to use ESC1 up to ESC9 being ESC9 the highest academic level

Returns user profile added.

### Update user attribute

```http
  PATCH /api/ies/users/${username}
```

| Parameter | Type            | Description                                  |
| :-------- |:----------------|:---------------------------------------------|
| `data`      | `String` | **Required**. User's username to be affected |
Example of JSON Object required in the body request:
```http
  [
    {"op": "replace", "path":"/reside_ciudad", "value":"new york"}
  ]
```
- For the "op" attribute you have to set "replace".
- For the "path" attribute you have to set the attribute's name you want update, don't forget to start with "/".
- For the "value" attribute you have to write the new value you want to set there.

Returns user profile after patch operations, so the new attribute values can be seen.

### Update user profile

```http
  PUT /api/ies/users/${username}
```

| Parameter | Type            | Description                                  |
| :-------- |:----------------|:---------------------------------------------|
| `data`      | `String` | **Required**. User's username to be affected |
Example of JSON Object required in the body request:
```http
  {
    "idPersona":"0123456789",
    "nombres":"Lorem",
    "apellidos":"Ipsum",
    "username":"loremipsum",
    "genero":"F",
    "email_personal":"lorem@ipsum.com",
    "email_laboral":"lorem@ipsum.work",
    "origen_pais":"ABC",
    "origen_ciudad":"Lorem",
    "reside_pais":"DEF",
    "reside_ciudad":"Ipsum",
    "escolaridad":"ESC1"
  }
```
- The field idPersona allows to use alphanumeric.
- The field genero allows to use only 'F' or 'M'.
- The fields origen_pais and reside_pais allows to use country code as ISO 3166 Alpha3
- The fields escolaridad allows to use ESC1 up to ESC9 being ESC9 the highest academic level

Returns user profile updated.

### Delete user profile

```http
  DELETE /api/ies/users/${username}
```

| Parameter | Type            | Description                                 |
| :-------- |:----------------|:--------------------------------------------|
| `data`      | `String` | **Required**. User's username to be deleted |

Returns TRUE or FALSE

## Authors

Daniel Alarcón Tabares

Colombia
- [@GitHub](https://www.github.com/dalarcont)
- [@LinkedIn](https://www.linkedin.com/in/dalarcont/)


## Roadmap

- ### VERSION 0.0.1-SNAPSHOT
  #### Service User:
  GET [EXISTENCE; MATCH; SYSINFOACCESS; SYSINFOPERMISSIONS; PROFILEDATA; RECORDACCESS]
- ### VERSION 0.0.2-SNAPSHOT
  #### Service User:
  GET [EXISTENCE; MATCH; SYSINFOACCESS; SYSINFOPERMISSIONS; PROFILEDATA; RECORDACCESS]
    - Correction on query designed to get user's apps permissions and its data, now it gets apps allowed to the user and app's info package.  
- ### VERSION 3.6.23-SNAPSHOT
  #### Service User:
- GET [EXISTENCEPROOF; MATCH_LOGIN; GET_USER_PROFILE; GET_EMPLOYEE_PROFILE; GET_STUDENT_PROFILE; SYSTEM_DESKAPP_RECORDACCESS;SYSTEM_STD_RECORD_ACCESS; DESKAPP_ACCESS; STUDENT_ACCESS; SYSINFO_PERMISSIONS]
- POST [User]
- PATCH [User]
- PUT [User]
- DELETE [User]
- Application changes:
  - Refactoring service endpoint controller
  - Refactoring service business logic 
  - Refactoring service repository operations
  - Refactoring objects and classes and its mappers interaction with repository
  - JUnit/Mock Unit Test


