**API Docs**
----
<_API của user_>

### Get List ALL District
**URL**\
`http://localhost:8080/api/v1/district`

* **Method:**

  `GET`

* **Success Response:**

    * **Code:** 200 <br />
      **Content:** 
      ```
      [
          {
          "id": "5fcc5179c8b004163cb29755",
          "status": "active",
          "code": "791",
          "name": "Quan 1",
          "createdBy": "anonymousUser",
          "createdDate": "2020-12-06T10:35:21.092",
          "lastModifiedBy": "anonymousUser",
          "lastModifiedDate": "2020-12-06T10:35:21.092",
          "province": null
          },
          {
          "id": "5fcc52f34bf7ff015bc5c2ea",
          "status": "active",
          "code": "791",
          "name": "Quan 1",
          "createdBy": "anonymousUser",
          "createdDate": "2020-12-06T10:41:39.201",
          "lastModifiedBy": "anonymousUser",
          "lastModifiedDate": "2020-12-06T10:41:39.201",
          "province": null
          },
          {
          "id": "5fcc52f64bf7ff015bc5c2eb",
          "status": "active",
          "code": "791",
          "name": "Quan 1",
          "createdBy": "anonymousUser",
          "createdDate": "2020-12-06T10:41:42.77",
          "lastModifiedBy": "anonymousUser",
          "lastModifiedDate": "2020-12-06T10:41:42.77",
          "province": null
          }
       ]
      ```

* **Error Response:**

    * **Code:** 401 UNAUTHORIZED <br />
      **Content:** `UNAUTHORIZED`

    * **Code:** 404 NOT FOUND <br />
      **Content:** `False`





### Get List User By Province
**URL**\
`http://localhost:8080/api/v1/district-province`

* **Method:**

  `GET`

*  **URL Params**<br/>
   * **province** <br/>
   **Required:**

   `province=[string]`
   "98", "79"
* **Success Response:**

    * **Code:** 200 <br />
      **Content:** 
      ```
      [
        {
          "id": "5fcbb04ca1e7be1298e10fed",
          "status": null,
          "createdBy": "anonymousUser",
          "createdDate": "2020-12-05T23:07:40.903",
          "lastModifiedBy": "anonymousUser",
          "lastModifiedDate": "2020-12-05T23:07:40.903",
          "username": "batman123",
          "roles": [
          "ROLE_ADMIN"
          ],
          "firstName": "jet",
          "lastName": "lk",
          "birthday": "2020-11-29T16:08:14.908",
          "image": "",
          "address": null,
          "email": "tenten@gmail.com",
          "isActive": null,
          "phone": null
         }
      ]
      ```

* **Error Response:**

    * **Code:** 401 UNAUTHORIZED <br />
      **Content:** `UNAUTHORIZED`

    * **Code:** 404 NOT FOUND <br />
      **Content:** `False`



### Create new User

**URL**\
`http://localhost:8080/api/v1/user`

* **Method:**

  `POST`\
  ***Request Body \
  Example***
  ```` {
  "id": "5fcbb04ca1e7be1298e10fed",
  "status": "",
  "username": "batman123",
  "roles": [
  "ROLE_ADMIN"
  ],
  "firstName": "jet",
  "lastName": "lk",
  "birthday": "2020-11-29T16:08:14.908",
  "image": "",
  "address": ".....",
  "email": "tenten@gmail.com",
  "isActive": true,
  "phone": "09389734734"
  }
  ````
* **Success Response:**

    * **Code:** 200 <br />
      **Content:** 
      ```
      
        {
          "id": "5fcbb04ca1e7be1298e10fed",
          "status": null,
          "username": "batman123",
          "roles": [
          "ROLE_ADMIN"
          ],
          "firstName": "jet",
          "lastName": "lk",
          "birthday": "2020-11-29T16:08:14.908",
          "image": "",
          "address": null,
          "email": "tenten@gmail.com",
          "isActive": null,
          "phone": null
         }
     
      ```

* **Success Resonse**
    *  **Code:** 200 OK <br />
       **Content:** `true`
* **Error Response:**

    * **Code:** 401 UNAUTHORIZED <br />
      **Content:** `UNAUTHORIZED`

    * **Code:** 404 NOT FOUND <br />
      **Content:** `False`

    * **Code:** 400 BAD REQUEST <br/>
      **Content:** `Username is already` `Email is already`

###UPDATE  User

**URL**
`http://localhost:8080/api/v1/user`

* **Method:**

  `PUT`<br/>
  ***Request Body 
  Example***
  ```` 
  {
      "id": "5fcbb04ca1e7be1298e10fed",
      "status": "",
      "roles": [
      "ROLE_ADMIN"
      ],
      "firstName": "jet",
      "lastName": "lk",
      "birthday": "2020-11-29T16:08:14.908",
      "image": "",
      "address": ".....",
      "email": "tenten@gmail.com",
      "isActive": true,
      "phone": "09389734734"
  }
  ````
* **Success Response:**

    * **Code:** 200 <br />
      **Content:** 
      ```true```

* **Success Resonse**
    *  **Code:** 200 OK <br />
       **Content:** `true`
* **Error Response:**

    * **Code:** 401 UNAUTHORIZED <br />
      **Content:** `UNAUTHORIZED`<bf/>

    * **Code:** 400 BAD REQUEST <br />
      **Content:** `False`<bf/>

###DELETE  User

**URL**\
`http://localhost:8080/api/v1/user/{id}`

* **Method:**

  `DELETE`\
  ***Request Body 
  Example***

`http://localhost:8080/api/v1/user/2312312312sdasdasd`

* **Success Response:**

    * **Code:** 200 <br />
      **Content:** 
      ```true```

* **Success Resonse**
    *  **Code:** 200 OK <br />
       **Content:** `true`
* **Error Response:**

    * **Code:** 401 UNAUTHORIZED <br />
      **Content:** `UNAUTHORIZED`<bf/>

    * **Code:** 400 BAD REQUEST <br />
      **Content:** `False`<bf/>



###LOGIN  User

**URL**\
`http://localhost:8080/api/v1/user/authenticate`

* **Method:**

  `POST`\
  ***Request Body 
  Example***

`http://localhost:8080/api/v1/user/authenticate`

* **Success Response:**

    * **Code:** 200 <br />
      **Content:** 
      ```
      {
          "token": "eyJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2MDgwOTE1MTMsInVzZXJuYW1lIjoiYmF0bWFuMTIzIn0.BAU3I_RwkiYuM9DWIzZ-dkphe5_EvFzd4qj-hJ4aUVg",
          "roles": [
          "ROLE_ADMIN"
          ],
          "message": "Login Success"
      }
      ```
  **token** dung de gui kem request de authortiry

* **Error Response:**

    * **Code:** 400 BAD REQUEST <br />
      **Content:** `

        ````
        {
             "token": null,
             "roles": null,
             "message": "Wrong user name or password"
         }
    
        ````

  `<bf/>
  ***Exception**
    * **Code:** 500 Internal Server Error <br />
      **Content:**
        ````
        {
             "token": null,
             "roles": null,
             "message": "Internal Server Error"
         }
    
        ````<bf/>