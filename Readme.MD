# Payment

Project Implementation Payment


## Documentation

First, clone this repository to the local repository

```bash
    https://github.com/muratbek2255/Payment-Implemantion.git
```

```bash
    build gradle
```
```bash
    And run com/example/payment/Payment2Application.java
```
```bash
Add configuration in src/main/resources/application.properties
    #YOUR DATABASE URL jdbc:postgresql://port_db/db
spring.datasource.url=your_db
spring.datasource.driver-class-name=org.postgresql.Driver
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

server.servlet.context-path=/api/v1
#Your server port
server.port=

```

```bash
    Endpoints:
    
      http://localhost:8000/api/v1/favour-categories/update-favour-category-child/{id}
      Put: Add parent to child category
      
      http://localhost:8000/api/v1/favour-categories/delete-favour-category-child/{id}
      Delete parent to child category
    
      http://localhost:8000/api/v1/payment:
        Post-method: Payment is checked
  
      http://localhost:8000/api/v1/payment
          Put-method:Result: Payment Created!
              
              
      http://localhost:8000/api/v1/payment/setStatus/5
          Put-method: Result: Your status in payment: STATUS_SUCCESS
              
              
      http://localhost:8000/api/v1/payment/rollbackStatus/5
          Put-method: Result: Rollback payment
              
      http://localhost:8000/api/v1/payment/status
                 Param: status = ?
                 
           Get-method: Result: Payment with status: [list]
```