## h2 config in build.gradle 
## mariaDB
runtimeOnly 'org.mariadb.jdbc:mariadb-java-client'
## get all users
curl localhost:8080/users
## get user with id 1
 curl -X GET localhost:8080/user/4
 ## get user  with firstname 
 curl -X GET localhost:8080/username/mac
 ## add user without adress
 curl -X POST localhost:8080/user -H'content-type:application/json' -d'{"firstname":"mac","lastname":"muller","e_mail":"max_mueller@gmail.com","salutation": "Mister"}}'
## add user with adress
curl -X POST localhost:8080/user -H'content-type:application/json' -d'{"firstname":"mac","lastname":"muller","e_mail":"max_mueller@gmail.com","adress":{"street":"hechinger str." ,"city":"Tuebingen","postCode":123},"salutation":"Mister"}]}}'
## update user
curl -X PUT localhost:8080/user/4 -H'content-type:application/json' -d'{"firstname":"julia","lastname":"mueller","e_mail":"julia_mueller@gmail.com","salutation": "Mister"}}'
## update user with adress 
curl -X PUT localhost:8080/user/4 -H'content-type:application/json' -d'{"firstname":"max","lastname":"maxer","e_mail":"max_mueller@gmail.com","adress":{"street":"tuebinger str." ,"city":"Tu","postCode":172112},"salutation":"Mister"}]}}}'
## delete User with id 
curl -X DELETE localhost:8080/user/1
## get products
curl localhost:8080/products
## get product with id 
curl -X GET localhost:8080/product/4
## get product with name 
curl -X GET localhost:8080/productWithName/name
## get Ptoduct with name and specife marke :,
curl -X GET localhost:8080/productWithNameAndMarke/name/marke
## add product
//??? take the value null
curl -X POST localhost:8080/product -H'content-type:application/json' -d'{"name":"key","marke":"VW","descrpetion":"schlussel","amount": 2, "price": 50.99}}'
## update product with id 
## Delete product with id 
curl -X DELETE localhost:8080/product/1
## Delete all Products
curl -X DELETE localhost:8080/products

## Cart getMyCart
 curl -X GET localhost:8080/myCart/1
## get Products my  Cart as List 
curl -X GET localhost:8080/listALLProductsMyCart/1
## addItemToCart
curl -X POST localhost:8080/addItemToCart/1/2/12
## Delete Product from Cart 
curl -X DELETE localhost:8080/deleteProductFromCart/1/5 
## Delete the cart 
curl -X DELETE localhost:8080/deleteCart/1
## checkout
curl -X POST localhost:8080/checkout/1
## Review user order
curl -X GET localhost:8080/ordered/1
## add question
curl -X POST localhost:8080/addQuestion/1 -H'content-type:application/json' -d{"subject":"mac","descrpetion":"muller"}}'
## put question 
curl -X PUT localhost:8080/updateRequest/2 -H'content-type:application/json' -d'{}
## get ALL  Request From user
 curl -X GET localhost:8080/requestes/2
## get a specific Request From user 
curl -X GET localhost:8080/requestes/1/3
## Delete  ALL  Request From user
curl -X DELETE localhost:8080/deleteAllRquestFromU/1 
## Delete  a specific Request From user 
curl -X DELETE localhost:8080/deleteARquestFromU/1/4
## swagger ui
http://localhost:8080/swagger-ui/index.html 


