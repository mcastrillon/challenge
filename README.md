# Challenge

Execute the command spring-boot:build-image -DskipTests to generate the images

* maucasse/ontop-configserver
* maucasse/ontop-naming-server
* maucasse/ontop-transaction
* maucasse/ontop-status

Finally execute docker-compose up to start-up all the images

## To test the endpoint, execute:

* Post Call http://localhost:8080/account
 
Body: {
  "firstName": "Tony",
  "lastName": "Stark",
  "routingNumber": 123456,
  "idNumber": 1,
  "accountNumber": 123
  }
* Post Call http://localhost:8080/transfer

Body {
  "idNumber": 1,
  "amount":50,
  "currencySource": "USD",
  "currencyDestination": "USD"

}

Verify in h2 console ports 8080 and 8000 rows created
