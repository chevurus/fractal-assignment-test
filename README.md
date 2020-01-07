# fractal-assignment-test - Spring Boot Web Project

1. Build the project:
mvn clean install
Generates a .jar file under the target folder.
e.g git/fractal-assignment-test/fractal-assignment-test/target/fractal-assignment-test-0.0.1-SNAPSHOT.jar

2. Run the project:
Run the following command on CommandLine at the location of the jar. The command starts the spring boot project.
java -jar fractal-assignment-test-0.0.1-SNAPSHOT.jar

3. Rest URLs:

Fetch all Transactions:
REST Route GET /transactions
GET http://localhost:8080/transactions

Fetch Transactions for a particular category:
REST Route GET /transactions/{category}
GET http://localhost:8080/transactions/Rent & Office 

Fetch Transactions for a list of categories:
REST Route GET /transactions/{transactionId}/{categoryId}/{companyId}
Get http://localhost:8080/{Operating Expense,R&D Costs}/transactions

Update Transaction category:
PUT /transactions/{transactionId}/{categoryId}/{companyId}
PUT http://localhost:8080/transactions/fakeTrx062/a6hg1/2
