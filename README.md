# Create Sale Order Service

Built a microservice that handles the creation of sale orders and utilizes Kafka for messaging between different components

### Step 1: Set up a Spring Boot Project
Creating a new Spring Boot project using a build tool like Maven or Gradle. You can use Spring Initializr (https://start.spring.io/) to generate the project with the necessary dependencies.

### Step 2: Add Dependencies
In your pom.xml (if using Maven), add the necessary dependencies for Spring Boot and Kafka:
```
<dependencies>
    <!-- Spring Boot Starter Web -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <!-- Spring Boot Starter Data JPA -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>

    <!-- Spring Kafka -->
    <dependency>
        <groupId>org.springframework.kafka</groupId>
        <artifactId>spring-kafka</artifactId>
        <version>3.0.6</version>
    </dependency>

    <!-- My SQL Connector -->
    <dependency>
        <groupId>com.mysql</groupId>
        <artifactId>mysql-connector-j</artifactId>
        <scope>runtime</scope>
    </dependency>

    <!-- Lombok -->
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <optional>true</optional>
    </dependency>

    <!-- Spring Boot Starter Test -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
</dependencies>
```

### Step 3: Configure Kafka
Configure Kafka properties in your application.properties file:
```
spring.application.name=<your-application-name>
spring.kafka.bootstrap-servers=<your-kafka-bootstrap-servers>

<!-- Data Source Config -->
spring.datasource.name=<your-datasource-name>
spring.datasource.url=jdbc:mysql://<your-datasource-url>
spring.datasource.username=<your-datasource-username>
spring.datasource.password=<your-datasource-password>

<!-- JPA Config -->
spring.jpa.hibernate.ddl-auto=none
spring.jpa.show-sql=false
spring.jpa.open-in-view=true
```

### Step 4: Create a Sale Order Model
Create a Java class to represent the sale order entity.
```
public class SaleOrder {
    // Add attributes here
}
```

### Step 5: Implement Kafka Producer
Create a Kafka producer to send sale order messages to a Kafka topic.
```
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.createsaleorderservice.createsaleorderservice.record.MessageRequest;

@RestController
@RequestMapping("/api/send-kafka-messages")
public class MessageController {

    private KafkaTemplate<String, String> kafkaTemplate;

    public MessageController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping
    public void publish(@RequestBody MessageRequest messageRequest) {
        kafkaTemplate.send("statustopic", messageRequest.message());
    }
    
}
```

### Step 6: Implement Sale Order Controller
Create a controller class to expose an endpoint for creating sale orders.
```
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SaleOrderController {
    
    @Autowired
    private SaleOrderService saleOrderService;

    @PostMapping("/create-saleorder")
    public String createSaleorder(@RequestBody SaleOrder saleOrder)
    {
        saleOrderService.saveSaleOrder(saleOrder);
        return "Create a Sale Order Success!!";
    }

    @GetMapping("/get-all-saleorders")
    public List<SaleOrder> getAllSaleOrders() 
    {
        System.out.println("Get All Sale Orders Successfully!!");
        return saleOrderService.listAllSaleOrders();
    }

    @GetMapping("/get-saleorder-by-id/{id}")
    public ResponseEntity<?> getSaleOrderByID(@PathVariable Integer id)
    {
        try {
            SaleOrder saleOrder = saleOrderService.getSaleOrderByID(id);
            System.out.println("Search a Sale Order by ID Successfully!!");
            return new ResponseEntity<SaleOrder>(saleOrder, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<SaleOrder>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update-saleorder/{id}")
    public ResponseEntity<?> updateSaleorder(@RequestBody SaleOrder saleOrder, @PathVariable Integer id) {
        try {
            // SaleOrder existSaleOrder = saleOrderService.getSaleOrderByID(id);
            saleOrder.setSaleorder_id(id);
            saleOrderService.saveSaleOrder(saleOrder);;
			System.out.println("Update a Sale Order Successfully!");
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
	@DeleteMapping("/delete-saleorder/{id}")
    public String delete(@PathVariable Integer id) {
		saleOrderService.deleteSaleOrder(id);;
		System.out.println("Delete a Sale Order Successfully!");
		return "Delete a Sale Order Success!!"; 
    }

    @GetMapping("/check-confirmed-order")
    public List<SaleOrder> checkOrderStatus() 
    {
        System.out.println("Check Confirmed Order Successfully!!");
        return saleOrderService.checkOrderStatus();
    }

}
```

### Step 7: Implement Kafka Consumer
Create a Kafka consumer to process sale order messages from the Kafka topic.
```
import org.springframework.stereotype.Component;

@Component
public class KafkaListener {

    @org.springframework.kafka.annotation.KafkaListener(topics = "kafkatopic", groupId = "groupId")
    void listener(String message) {
        System.out.println(message);
    }
    
}
```

### Step 8: Run the Application
Run your Spring Boot application. Ensure that your Kafka server is running, and the topics are created.

### Step 9: Test the Service
Use tools like Postman or curl to send POST requests to the /createSaleOrder endpoint with JSON data representing sale orders. Check the console for messages processed by the Kafka consumer.

---

### 🪚 Tools Used:
![Static Badge](https://img.shields.io/badge/spring-%252320232a.svg?style=for-the-badge&logo=spring&logoColor=%233cb043&color=%23fbec5d)
![Static Badge](https://img.shields.io/badge/spring%20boot-%252320232a.svg?style=for-the-badge&logo=springboot&logoColor=%233cb043&color=%23fbec5d)
![Static Badge](https://img.shields.io/badge/apache%20kafka-%252320232a.svg?style=for-the-badge&logo=apachekafka&logoColor=%23000000&color=%2300bdfe)
![Static Badge](https://img.shields.io/badge/visual%20studio%20code-%252320232a.svg?style=for-the-badge&logo=visualstudiocode&logoColor=%230000FF&color=%235dbb63)
