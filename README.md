# micronaut-validator

API para validar um número VAT, chamado a partir de um lambda na aws. Uso puramente para estudos do framework micronaut.

Conteudo pode ser encontrado no guia oficial do Micronaut:
http://guides.micronaut.io/micronaut-function-aws-lambda/guide/index.html

curl:

$ curl -X "POST" "http://localhost:8080/invoice/vat" -H 'Content-Type: application/json' -d $'{"countryCode": "es","vatNumber": "B86412491","lines": [{"count": 2,"price": 19.99,"productId": "1491950358"},{"count": 1,"price": 15,"productId": "1680502395"}]}'

curl AWS Lambda:

$ curl -X "POST" "<URL_AWS_LAMBDA>" -H 'Content-Type: application/json' -d $'{"memberStateCode": "es","vatNumber": "B86412491"}'
