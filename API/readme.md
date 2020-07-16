## 실행을 위한 설정

1. backend\src\main\resources 위치에 application-db.properties 파일을 생성한다.

2. 내용을 아래와 같이 채운다.

```properties
spring.datasource.driver-class-name=org.mariadb.jdbc.Driver
spring.datasource.url=jdbc:mariadb://localhost:3306/docfriendstask
spring.datasource.username=doc
spring.datasource.password=qwe123
```