# fractal-assignment-test - Spring Boot Web Project

1. Build the project:
mvn clean install
Generates a .jar file under the target folder.
e.g git/fractal-assignment-test/fractal-assignment-test/target/fractal-assignment-test-0.0.1-SNAPSHOT.jar

2. Run the project: Starts the spring boot project.
Run the following command on CommandLine at the location of the jar. The command starts the spring boot project.
java -jar fractal-assignment-test-0.0.1-SNAPSHOT.jar

3. Rest URLs:

Fetch all Transactions for company.
REST Route GET /companies/{companyId}/transactions
GET http://localhost:8080/companies/2/transactions

Fetch Transactions for a particular category:
REST Route GET /companies/{companyId}/transactions/{category}
GET http://localhost:8080/companies/2/transactions/Rent & Office 

Fetch Transactions for a list of categories: Lists all transactions for categories mentioned as comma separated values. Can be a single value as well.
REST Route GET /companies/{companyId}/categories/{categoriesList}/transactions
Get http://localhost:8080/companies/2/categories/Operating Expense,R&D Costs/transactions
Get http://localhost:8080/companies/2/categories/Operating Expense/transactions

Update Transaction category:
PUT /companies/{companyId}/categories/{categoryId}/transactions/{transactionId}
PUT http://localhost:8080/companies/2/categories/a6hg1/transactions/fakeTrx062

