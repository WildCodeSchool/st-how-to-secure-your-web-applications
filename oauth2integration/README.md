## Taken from baeldung.com, for complete Keycloak example with Tests, SOAP and Web Services see https://www.baeldung.com/spring-boot-keycloak

### Setup Demo

Follow the steps for the Keycloak Realm and Client setup in the [Baeldung post](https://www.baeldung.com/spring-boot-keycloak) linked above.  
_Note: This Spring Web Application will run on port 9090, adjust the URLs (eg. Redirect URL) in the sample accordingly._ 

### Run Demo

#### In IDE

* Add project as Maven project
* Start `SpringBoot`

#### With Maven

* `mvn spring-boot:run`

### Start Demo

* Open `http://localhost:9090`

### User login data

```
"User",  Role USER,  username: user,  password: user
"Admin", Role ADMIN, username: admin, password: admin
```