

## h2 config in build.gradle 

## mariaDB
runtimeOnly 'org.mariadb.jdbc:mariadb-java-client'

## get all users
curl localhost:8080/users

## get user with id 1
 curl -X GET localhost:8080/user/4
## add user 
 curl -X POST localhost:8080/user -H'content-type:application/json' -d'{"firstname":"mac","lastname":"muller","e_mail":"max_mueller@gmail.com","salutation": "Mister"}}'

## update user

curl -X PUT localhost:8080/user/4 -H'content-type:application/json' -d'{"firstname":"julia","lastname":"mueller","e_mail":"julia_mueller@gmail.com","salutation": "Mister"}}'
## delete User with id 

curl -X DELETE localhost:8080/user/1


## get products
curl localhost:8080/products

## get product with id 
curl -X GET localhost:8080/product/4
## add product
//??? take the value null
curl -X POST localhost:8080/product -H'content-type:application/json' -d'{"name":"key","marke":"VW","descrpetion":"schlussel","amount": 2, "price": 50.99}'

## update product with id 

## Delete product with id 
curl -X DELETE localhost:8080/product/1

## Delete all Products
curl -X DELETE localhost:8080/products

## swagger ui
 http://localhost:8080/swagger-ui/index.html 
