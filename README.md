
# API IES Admin Academ

API REST Application for provide services to a Software of Management of Academic and Administrative (University oriented).

***THIS SOFTWARE IS ONLY FOR LEARNING PURPOSES***

***IT DOESN'T HAS TO DO WITH ANY ACADEMIC OR ADMINISTRATIVE CENTER***

This API REST Application works as a provider of data that is requested by a desktop software environment to perform management operations of an University academic and administrative of an educational center (University oriented).

Please consider that this project follows **CC BY-NC-SA** license terms.


# API Reference (for V12.2.24)
## ----- GET -----
## [USERS]
### Get user's existence proof

```http
  GET /api/ies/users/{username}
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `{username}` | `string` | **Required**. Username |

Returns TRUE or FALSE.

### Get user's existence proof by ID

```http
  GET /api/ies/users/valbyid/{id}
```

| Parameter | Type     | Description             |
|:----------| :------- |:------------------------|
| `{id}`    | `string` | **Required**. User's ID |

Returns TRUE or FALSE.

### Get association status for an EMAIL address

```http
  GET /api/ies/users/valaddemail/{email}
```

| Parameter | Type     | Description             |
|:----------| :------- |:------------------------|
| `{email}` | `string` | **Required**. User's email |

Returns TRUE or FALSE.

### Get available state of an username to signup

```http
  GET /api/ies/users/valaddusrname/{username}
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `{username}` | `string` | **Required**. Username desired |

Returns TRUE or FALSE.

### Get user's basic profile data

```http
  GET /api/ies/users/{username}/profiledata
```

| Parameter  | Type     | Description            |
|:-----------| :------- |:-----------------------|
| `username` | `string` | **Required**. Username |

Returns user profile object in JSON format

### Get employee's profile data

```http
  GET /api/ies/users/{username}/employeeprofile
```

| Parameter  | Type     | Description            |
|:-----------| :------- |:-----------------------|
| `username` | `string` | **Required**. Username |

Returns employee profile object in JSON format

### Get student's profile data

```http
  GET /api/ies/users/{username}/studentprofile
```

| Parameter  | Type     | Description            |
|:-----------| :------- |:-----------------------|
| `username` | `string` | **Required**. Username |

Returns student profile object in JSON format

### Get user's match of credentials for login

```http
  GET /api/ies/users/{data}/matchlogin
```

| Parameter | Type     | Description                              |
| :-------- | :------- |:-----------------------------------------|
| `data`      | `string` | **Required**. Encoded user's credentials |

Returns TRUE or FALSE.

### Get employee's access validation to administration software

```http
  GET /api/ies/users/{username}/dskaccess
```

| Parameter  | Type     | Description                       |
|:-----------| :------- | :-------------------------------- |
| `username` | `string` | **Required**. Username |

Returns TRUE or FALSE.

### Get student's access validation to software

```http
  GET /api/ies/users/{username}/stdaccess
```

| Parameter  | Type     | Description                       |
|:-----------| :------- | :-------------------------------- |
| `username` | `string` | **Required**. Username |

Returns TRUE or FALSE.

### Get apps permissions for an employee

```http
  GET /api/ies/users/{data}/sysinfopermissions
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `data`      | `string` | **Required**. Encoded user's credentials |

Returns List of objects that contains app name, app code, and info.

### Set user's last access date (for HR inspections)

```http
  GET /api/ies/users/{data}/dsklastaccess
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `data`      | `string` | **Required**. Encoded user's credentials |

Returns TRUE or FALSE

## [GENERAL]
### Get the full value of a shorten word or expression

```http
  GET /api/ies/general/convention/{value}
```

| Parameter | Type     | Description                              |
|:----------| :------- |:-----------------------------------------|
| `value`   | `string` | **Required**. Shorten word or expression |

Returns String with full value or meaning

### Get the status of an application

```http
  GET /api/ies/general/appstatus/{value}
```

| Parameter | Type     | Description                    |
|:----------| :------- |:-------------------------------|
| `value`   | `string` | **Required**. Application code |
* If the application code has '/' (slashes), you must replace to '!' (exclamation).

Returns application status object in JSON format

## ----- POST -----
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
    "prsn_ID":"0123456789",
    "prsn_NOM":"Lorem",
    "prsn_APE":"Ipsum",
    "prsn_USUARIO":"loremipsum",
    "prsn_GEN":"XX",
    "prsn_EMAIL_PERSONAL":"lorem@ipsum.com",
    "prsn_EMAIL_LABORAL":"lorem@ipsum.work",
    "prsn_ORIGEN_PAIS":"XXX",
    "prsn_ORIGEN_CIUDAD":"Lorem",
    "prsn_RESIDE_PAIS":"XXX",
    "prsn_RESIDE_CIUDAD":"Ipsum",
    "prsn_ESCOLARIDAD":"XXX"
  }
```
- The field `PRSN_ID` allows to use alphanumeric.
- The field `PRSN_GEN` allows to use only `MS` for male, `FM` for female and `NS` for keep in private the gender.
- The fields `PRSN_ID_ORIGEN_PAIS` and `PRSN_RESIDE_PAIS` allows to use country code as ISO 3166 Alpha3.
- The fields `PRSN_ESCOLARIDAD` allows to use `[BASC|SECU|TECN|TEKN|PROF|PRPG|MAES|DOCT]` and `NGNR` for no answer/no option.

Returns user profile added.

### Add worklog

```http
  POST /api/ies/users/worklog
```

| Parameter                             | Type                      | Description                                      |
|:--------------------------------------|:--------------------------|:-------------------------------------------------|
| No parameter required in endpoint URL |

Example of JSON Object required in the body request:
```http
  {
    "cod_EMPLEADO":"loremipsum",
    "reg_APPSET":"APPCODE",
    "reg_ACTION_DESCR":"Lorem Ipsum worklog"
  }
```
- The field `cod_EMPLEADO` refers to the user who will have the worklog related.
- The field `reg_APPSET` refers to the running application code from where the logwork addition was requested..
- The fields `reg_ACTION_DESCR` is for a description of the worklog.

Returns TRUE or FALSE.

### Add student log

```http
  POST /api/ies/users/stdntlog
```

| Parameter                             | Type                      | Description                                      |
|:--------------------------------------|:--------------------------|:-------------------------------------------------|
| No parameter required in endpoint URL |

Example of JSON Object required in the body request:
```http
  {
    "cod_ESTUDIANTE":"loremipsum",
    "reg_APPSET":"APPCODE",
    "reg_ACTION_DESCR":"Lorem Ipsum worklog"
  }
```
- The field `cod_ESTUDIANTE` refers to the user who will have the student log related.
- The field `reg_APPSET` refers to the running application code from where the logwork addition was requested..
- The fields `reg_ACTION_DESCR` is for a description of the worklog.

Returns TRUE or FALSE.

## ----- PATCH -----
### Update user's basic profile attribute

```http
  PATCH /api/ies/users/{username}
```

| Parameter  | Type            | Description                                  |
|:-----------|:----------------|:---------------------------------------------|
| `username` | `String` | **Required**. User's username to be affected |
Example of JSON Object required in the body request:
```http
  [
    {"op": "replace", "path":"/field", "value":"new value"}
  ]
```
- For the "op" attribute you have to set "replace".
- For the "path" attribute you have to set the attribute's name you want update, don't forget to start with "/".
- For the "value" attribute you have to write the new value you want to set there.

Returns user profile after patch operations, so the new attribute values can be seen.

### Update the last access date of an employee

```http
  PATCH /api/ies/users/{data}/dsklastaccess
```

| Parameter  | Type            | Description                                  |
|:-----------|:----------------|:---------------------------------------------|
| `data`      | `string` | **Required**. Encoded user's credentials |

Returns TRUE or FALSE.

### Update the last access date of an student

```http
  PATCH /api/ies/users/{data}/stdlastaccess
```

| Parameter  | Type            | Description                                  |
|:-----------|:----------------|:---------------------------------------------|
| `data`      | `string` | **Required**. Encoded user's credentials |

Returns TRUE or FALSE.

## ----- PUT -----
### Update user profile

```http
  PUT /api/ies/users/{username}
```

| Parameter  | Type            | Description                                  |
|:-----------|:----------------|:---------------------------------------------|
| `username` | `String` | **Required**. User's username to be affected |
Example of JSON Object required in the body request:
```http
  {
    "prsn_ID":"0123456789",
    "prsn_NOM":"Lorem",
    "prsn_APE":"Ipsum",
    "prsn_USUARIO":"loremipsum",
    "prsn_GEN":"XX",
    "prsn_EMAIL_PERSONAL":"lorem@ipsum.com",
    "prsn_EMAIL_LABORAL":"lorem@ipsum.work",
    "prsn_ORIGEN_PAIS":"XXX",
    "prsn_ORIGEN_CIUDAD":"Lorem",
    "prsn_RESIDE_PAIS":"XXX",
    "prsn_RESIDE_CIUDAD":"Ipsum",
    "prsn_ESCOLARIDAD":"XXX"
  }
```
- _To know about the fields possible values, get reference on POST->Add a new user_

Returns user profile updated.

## ----- DELETE -----
## [USERS]
```http
  DELETE /api/ies/users/{username}
```

| Parameter  | Type            | Description                                  |
|:-----------|:----------------|:---------------------------------------------|
| `username` | `String` | **Required**. User's username to be affected |

Returns TRUE or FALSE.

## Authors

Daniel Alarcón Tabares
Colombia
- [@GitHub](https://www.github.com/dalarcont)
- [@LinkedIn](https://www.linkedin.com/in/dalarcont/)


## Roadmap

- ### VERSION 0.0.1-SNAPSHOT
  Roadmap description removed.
- ### VERSION 0.0.2-SNAPSHOT
  Roadmap description removed.
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
- ### VERSION 3.10.23-SNAPSHOT
- GET|POST|PATCH|PUT Endpoints described on this document.
- Application changes:
  - Added general environment endpoints
  - Refactoring models and entities
  - Refactoring mismatch endpoint's category
  - Refactoring DDBB queries
  - Refactoring JUnit/Mock Unit Tests with new version of models and entities
- ### VERSION 12.2.24
- GET|POST|PATCH|PUT|DELETE Endpoints described on this document.
- Application changes:
  - Added general environment endpoints
  - Refactoring models and entities
  - Refactoring mismatch endpoint's category
  - Refactoring DDBB queries
  - Refactoring endpoints with same functionality


