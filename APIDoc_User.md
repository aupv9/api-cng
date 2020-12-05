**API Docs**
----
<_API của user_>

### Get List User
 **URL**\
    `http://localhost:8080/api/v1/users?role=partner`

* **Method:**

  `GET` 

*  **URL Params**\
   <_default value_> role = member\
   **role** \
   **Required:**

   `role=[string]`

* **Success Response:**

    * **Code:** 200 <br />
      **Content:** \
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
      **Content:** \
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

**URL**\
`http://localhost:8080/api/v1/user`

* **Method:**

  `PUT`\
  ***Request Body \
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
      **Content:** \
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
  ***Request Body \
  Example***
   
`http://localhost:8080/api/v1/user/2312312312sdasdasd`

* **Success Response:**

    * **Code:** 200 <br />
      **Content:** \
      ```true```

* **Success Resonse**
    *  **Code:** 200 OK <br />
       **Content:** `true`
* **Error Response:**

    * **Code:** 401 UNAUTHORIZED <br />
      **Content:** `UNAUTHORIZED`<bf/>

    * **Code:** 400 BAD REQUEST <br />
      **Content:** `False`<bf/>