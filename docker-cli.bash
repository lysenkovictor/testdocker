######## run container mysql

docker run \
  --name db_mysql \
  -t \
  --rm \
  -p 3306:3306 \
  --network test-network \
  -v db-data:/var/lib/mysql \
  -v $(pwd)/app/database/databaseschema.sql:/docker-entrypoint-initdb.d/databaseschema.sql:ro \
  -e MYSQL_ROOT_PASSWORD=123456789 \
  -d \
  mysql

####  run container adminer

docker run -d       \
    --name adminer  \
    --network test-network  \
    -p 8080:8080 \
    adminer

######## run app warehouse

docker run \
  --name warehouse \
  --network test-network \
  -p 80:8080 \
  --rm \
  -e SPRING_DATASOURCE_URL=jdbc:mysql://db_mysql/service?serverTimezone=EST5EDT \
  -e SPRING_DATASOURCE_PASSWORD=123456789 \
  -e SPRING_DATASOURCE_USERNAME=root \
  -d \
  testapp/warehouse:1.0


######## run test
docker run \
  --name=tests \
  --network test-network \
  -t \
  --rm \
  -w /usr/src/mymaven \
  -v ~/.m2:/var/maven/.m2 \
  -v $(pwd):/usr/src/mymaven \
  -e MAVEN_CONFIG=/var/maven/.m2 \
  -e url.baseUrl=http://warehouse:8080 \
  -e MAVEN_CONFIG=/var/maven/.m2 \
  -u $(id -u):$(id -g) \
  maven:3-jdk-14 mvn -Duser.home=/var/maven test
