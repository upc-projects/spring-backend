# Application properties 

Create the Schema in MySQL Workbench named `projectionapi`.  
Then create the `application.properties` inside `src/main/resources` file with this lines:


`server.port=8080`   
`spring.datasource.url=jdbc:mysql://localhost:3306/projectionapi?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC`  
`spring.datasource.username=YOUR_DB_USERNAME`  
`spring.datasource.password=YOUR_DB_PASSWORD`  
`spring.jpa.hibernate.ddl-auto=update`  
`spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver`  
`spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5InnoDBDialect`


  
