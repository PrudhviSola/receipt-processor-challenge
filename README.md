# Receipt Processor Challenge

This is a RESTful application for processing receipts and calculating reward points based on predefined rules. The application uses Spring Boot and supports Docker for containerization.

## Features

1. Process receipts and calculate reward points.
2. Apply multiple business rules for point calculation:
    - Item Count Rule
    - Item Description Rule
    - Odd Day Rule
    - Quarter Multiple Rule
    - Round Dollar Rule
    - Retailer Name Rule
    - Time Range Rule
3. Retrieve the total points for a given receipt ID.

## API Documentation

### Endpoints

#### 1. Process Receipt
- **POST** `/receipts/process`
- Submits a receipt for processing.
- Returns the ID assigned to the receipt.
- Request Body:
  ```json
  {
    "retailer": "Target",
    "purchaseDate": "2022-01-01",
    "purchaseTime": "13:01",
    "items": [
      {
        "shortDescription": "Mountain Dew 12PK",
        "price": "6.49"
      }
    ],
    "total": "6.49"
  }
  ```
- Response:
  ```json
  {
    "id": "adb6b560-0eef-42bc-9d16-df48f30e89b"
  }
  ```

#### 2. Get Points
- **GET** `/receipts/{id}/points`
- Returns the points awarded for the receipt.
- Response:
  ```json
  {
    "points": 32
  }
  ```




## Setup and Usage

### Prerequisites
1. Install Docker and Docker Compose
2. Clone the repository
   ```bash
   git clone https://github.com/PrudhviSola/receipt-processor-challenge.git
   ```
   
### Using Docker
1. Navigate to the project root directory
2. Build the Docker image:
   ```bash
   docker build -t receipt-processor-challenge .
   ```
3. Run the container:
   ```bash
   docker run -p 8080:8080 receipt-processor-challenge
   ```
4. The application will be available at `http://localhost:8080`

### Using Docker Compose
1. Start the application:
   ```bash
   docker compose up --build
   ```
2. Stop the application
   ```bash
   docker compose down
   ```
3. The application will be available at `http://localhost:8080`


### Run without Docker

#### Prerequisites
- Java 17 or higher
- Maven 3.9.x or higher 

#### Steps
1. Navigate to the project root directory
2. Build the project:
   ```bash
   # Using Maven
   mvn clean package
   ```
3. Run the application:
   ```bash
   # Using Maven
   mvn spring-boot:run

   ```
6. The application will be available at `http://localhost:8080`

## Testing
1. Run unit tests:
 ```bash
   # Using Maven
   mvn test

  # Run specific test class
  mvn test -Dtest=ReceiptControllerTest
   ```

## Project Structure

```bash

src
├── main
│   ├── java/com/fetch/receipt/processor/challenge
│   │   ├── config            # Config Class (e.g., RuleConfiguration)
│   │   ├── controller        # Controllers (e.g., ReceiptController)
│   │   ├── service           # Service Layer (e.g., ReceiptService)
│   │   ├── rules             # Business Rules (e.g., OddDayRule, QuarterMultipleRule)
│   │   ├── dto               # Data Transfer Objects (e.g., ReceiptDTO, PointsResponseDTO)
│   │   └── ReceiptProcessingApplication.java
│   └── resources
│       ├── application.yml   # Configuration
│       └── static            # Static Resources
├── test
│   └── java/com/fetch/receipt/processor/challenge
│       ├── controller        # Controller Tests
│       ├── service           # Service Tests
│       └── rules             # Rule Tests
│
│
```



