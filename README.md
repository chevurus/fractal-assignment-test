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
REST Route GET /companies/{companyId}/transactions
GET http://localhost:8080/companies/2/transactions

Fetch Transactions for a particular category:
REST Route GET /companies/{companyId}/transactions/{category}
GET http://localhost:8080/companies/2/transactions/Rent & Office 

Fetch Transactions for a list of categories:
REST Route GET /companies/{companyId}/{categoriesList}/transactions
Get http://localhost:8080/companies/2/{Operating Expense,R&D Costs}/transactions

Update Transaction category:
PUT /companies/{companyId}/transactions/{transactionId}/{categoryId}
PUT http://localhost:8080/companies/2/transactions/fakeTrx062/a6hg1

