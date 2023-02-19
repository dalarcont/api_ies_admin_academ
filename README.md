
# API IES Admin Academ

API REST Application for provide services to a Software of Management of IES (University).

*THIS SOFTWARE IS ONLY FOR LEARNING PURPOSES*

This API REST Application works as a provider of data that is requested by a desktop software environment to perform management operations of an University academic and administrative processes.





## API Reference

#### Get user's existence proof

```http
  GET /api/ies/users/${username}
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `{username}` | `string` | **Required**. Username |

Returns TRUE or FALSE.

#### Get user's match of credentials

```http
  GET /api/ies/users/${data}/match
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `data`      | `string` | **Required**. Encoded user's credentials |

Returns TRUE or FALSE.

#### Get user's access permission to a software environment

```http
  GET /api/ies/users/${data}/sysinfoaccess
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `data`      | `string` | **Required**. Encoded user's credentials |

Returns TRUE or FALSE.

#### Get apps permissions for an user

```http
  GET /api/ies/users/${data}/sysinfopermissions
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `data`      | `string` | **Required**. Encoded user's credentials |

Returns Object[] with app name and its respective permission.

#### Get profile data of an user

```http
  GET /api/ies/users/${data}/profiledata
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `data`      | `string` | **Required**. Encoded user's credentials |

Returns Object[] with all user data necessary to desenvolve on the software

#### Set user's last access date (for HR inspections)

```http
  GET /api/ies/users/${data}/recordaccess
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `data`      | `string` | **Required**. Encoded user's credentials |

Doesn't return any value (void).
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

