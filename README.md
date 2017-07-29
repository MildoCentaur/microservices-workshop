
#### First build the application
**Mac/Linux**:
`./mvnw clean package` (or) `mvnw clean package`

#### Start all apps in docker
`docker-compose up --build --force-recreate -d`


#### Config Server: 
catalog-service: http://localhost:8888/config-server/catalog-service/default.json

customer-service: http://localhost:8888/config-server/customer-service/default.json

order-service: http://localhost:8888/config-server/order-service/default.json

#### Eureka Dashboard: 
http://localhost:8888/eureka-dashboard
