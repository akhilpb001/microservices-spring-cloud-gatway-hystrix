# microservices-spring-cloud-gatway-hystrix

API Gateway
-----------
```bash
URL: http://localhost:9190/api/v1/order/bookOrder
HTTP Method: POST
```
JSON Request:
```json
{
    "order": {
        "name": "Mobile",
        "qty": 1,
        "price": 15000
    }
}
```
JSON Response:
```json
{
    "order": {
        "id": 1,
        "name": "Mobile",
        "qty": 1,
        "price": 15000.0
    },
    "amount": 15000.0,
    "transactionId": "72be7949-ad40-4d1d-838e-1bb888f5a5b6",
    "paymentStatus": "success",
    "message": "Payment successful and order placed successfully."
}

```
```bash
URL: http://localhost:9190/api/v1/payment/1
HTTP Method: GET
```
JSON Response:
```json
{
    "paymentId": 1,
    "paymentStatus": "success",
    "transactionId": "72be7949-ad40-4d1d-838e-1bb888f5a5b6",
    "orderId": 1,
    "amount": 15000.0
}
```

Reference: https://www.youtube.com/watch?v=tljuDMmfJz8
