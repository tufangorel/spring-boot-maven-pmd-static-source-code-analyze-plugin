## spring-boot-maven-pmd-static-source-code-analyze-plugin

Purpose : Analyze java source code statically at build time before generating final artifact in your IDE. <br/>
Result : Get detailed report about coding issues such as dead code, empty blocks, unused imports etc. <br/>

### Local run steps <br/>
1- To activate maven pmd plugin run the following maven command : <br/>
NOT : Execute maven command from where the pom.xml is located in the project directory. <br/>
<pre> 
$ mvn clean jxr:jxr install <br/>
</pre>

[INFO] PMD Failure: service.unit.test.ProductServiceUnitTest:38 Rule:LocalVariableCouldBeFinal Priority:3 Local variable 'p1' could be declared final. <br/>
[INFO] PMD Failure: service.unit.test.ProductServiceUnitTest:40 Rule:ShortVariable Priority:3 Avoid variables with short names like p2. <br/>
[INFO] PMD Failure: service.unit.test.ProductServiceUnitTest:40 Rule:LocalVariableCouldBeFinal Priority:3 Local variable 'p2' could be declared final. <br/>
[INFO] PMD Failure: service.unit.test.ProductServiceUnitTest:44 Rule:LawOfDemeter Priority:3 Potential violation of Law of Demeter (method chain calls). <br/>
[INFO] PMD Failure: service.unit.test.ProductServiceUnitTest:46 Rule:LocalVariableCouldBeFinal Priority:3 Local variable 'response' could be declared final. <br/>
[INFO] PMD Failure: service.unit.test.ProductServiceUnitTest:48 Rule:LawOfDemeter Priority:3 Potential violation of Law of Demeter (object not created locally). <br/>
[INFO] ------------------------------------------------------------------------ <br/>
[INFO] BUILD FAILURE <br/> 
[INFO] ------------------------------------------------------------------------ <br/>
[INFO] Total time:  34.803 s <br/>
[INFO] Finished at: 2021-10-02T15:28:18+03:00 <br/>
[INFO] ------------------------------------------------------------------------ <br/>
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-pmd-plugin:3.15.0:check (default) on project spring-boot-maven-pmd-static-source-code-analyze-plugin: You have 630 PMD violations. <br/>
[ERROR] <br/>

![Maven PMD Plugin](docs/maven_pmd_plugin.png) <br/>

### Tech Stack
Java 11 <br/>
H2 Database Engine <br/>
spring boot <br/>
spring boot starter data jpa <br/>
spring boot starter web <br/>
spring boot starter test <br/>
hibernate <br/>
logback <br/>
maven <br/>
maven-pmd-plugin <br/>
springfox-swagger-ui <br/>
datasource-proxy <br/>
Docker <br/>
<br/>

### Docker build run steps
NOT : Execute docker commands from where the DockerFile is located. <br/>
<pre>
$ docker system prune <br/>
$ docker build . --tag demo  <br/>
$ docker run -p 8080:8080 -e "SPRING_PROFILES_ACTIVE=dev" demo:latest <br/>
</pre>

## API OPERATIONS
### Save store with products successfully to database

Method : HTTP.POST <br/>
URL : http://localhost:8080/customer-info/store/save <br/>

Request : 
<pre>
curl --location --request POST 'http://localhost:8080/customer-info/store/save' \
--header 'Content-Type: application/json' \
--data-raw '{
  "name": "jeans_store",
  "products": [
    {
      "name": "prod1"
    },
    {
      "name": "prod2"
    },
    {
      "name": "prod3"
    }
  ]
}'
</pre><br/>

Response : 

HTTP response code 200 <br/>
<pre>
{
    "id": 1,
    "name": "jeans_store",
    "products": [
        {
            "id": 1,
            "name": "prod3"
        },
        {
            "id": 2,
            "name": "prod1"
        },
        {
            "id": 3,
            "name": "prod2"
        }
    ]
}
</pre>


### List Store saved to database

Method : HTTP.GET <br/>
URL : http://localhost:8080/customer-info/store/list <br/>

Request : 
<pre>
curl --location --request GET 'http://localhost:8080/customer-info/store/list'
</pre><br/>

Response : 

HTTP response code 200 <br/>
<pre>
[
    {
        "id": 1,
        "name": "jeans_store",
        "products": [
            {
                "id": 1,
                "name": "prod3"
            },
            {
                "id": 2,
                "name": "prod1"
            },
            {
                "id": 3,
                "name": "prod2"
            }
        ]
    }
]
</pre><br/>
