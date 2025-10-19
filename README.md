# migrate-data-example


keycloak:
    http://localhost:8082/
	http://localhost:8082/admin/master/console/#/my-keycloak
	
	user: admin
	password: admin

users:
user: customer_username
password: newpassword

user: manager_username
password: newpassword



 POST http://localhost:8081/api/v1/user
     {
        "id": 1,
        "name": "my name",
        "surname": "my surname"
    }
 GET http://localhost:8081/api/v1/user/1

 GET http://localhost:8081/api/v1/user/all

 POST http://localhost:8081/api/v1/user/copy-users
