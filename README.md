# Aggregator-Design-Pattern
The Aggregator Design Pattern for Microservices Architecture

# Problem that Aggregator Design Pattern solves
When breaking the business functionality into several smaller logical pieces of code, it becomes necessary to think about how to collaborate the data returned by each service. This responsibility cannot be left with the consumer, as then it might need to understand the internal implementation of the producer application.

# Solution for this problem 
The Aggregator pattern helps to address this. It talks about how we can aggregate the data from different services and then send the final response to the consumer. A composite aggregator microservice will make calls to all the required microservices, consolidate the data, and transform the data before sending back.

# Prerequisites
  - Java Development Kit (JDK 8 or above)
  - Maven
  - IDE like STS(Spring Tool Suite) or Eclipse

# Architecture Overview
We will create 3 microservices : 
  - Account Service -> Manages Bank Account creation and fetching
  - Fund Transfer Service -> Manages trasnfer of funds for accounts
  - Report Service -> This will be Aggregator Service that will aggregate data from Account Service and Fund Transfer Service to send a unified response back to client.

# Steps : 
  1. Create Microservices :
      Create three separate Spring Boot projects (either via Spring Initializr or your preferred method). 

  2. Add Dependencies :
      For Report Service, add just web dependency :
     ![image](https://github.com/dnyanesh-genpact/Aggregator-Design-Pattern/assets/152908296/00294a58-3a08-48e3-8217-60ef1a7bd454)

      For Account and Fund Transfer service, add following dependencies :
        ![image](https://github.com/dnyanesh-genpact/Aggregator-Design-Pattern/assets/152908296/cf699ba3-9153-4ce7-8c1c-ea5c642f5430)

  4. Business Logic :
       1) Account Service - Create a REST API to get an account by account number.
       2) Fund Transfer Service - Create a REST API to get transaction details for specific account.
       3) Report Service(Aggregator Service) - Create a REST API to call above services and aggregate the data.

  5. Aggregation Logic : 

     ![image](https://github.com/dnyanesh-genpact/Aggregator-Design-Pattern/assets/152908296/dfd886fd-73d8-4662-af5e-84bb2bb61e4f)

  6. Run the services : 
      Start all 3 services i.e. Account Service, Fund Transfer Service and Aggregator Service.

  7. Test and connect h2 DB connection : 
      Connect to Account Service DB using jdbc:h2:mem:AccountService_DB on h2 console.
      Connect to Account Service DB using jdbc:h2:mem:FundTransfer_DB on h2 console.
      
  8. Make few post calls(So that we can have sample data in DB to fetch later) on both Account and Fund Transfer Services using following URLs : 
      Account Service POST call - http://localhost:5051/banking/account/createAccount
      Fund Transfer Service POST call - http://localhost:5052/banking/fundTransfer/newFundTransferRequest

  9. Test Aggregator
      Test by calling http://localhost:5055/banking/report/getTxnDetails/976435618



# Microservices Configuration
Customize the behavior of services by editing the respective application.properties file. Adjust settings such as port, logging, and error handling.

 ![image](https://github.com/dnyanesh-genpact/Aggregator-Design-Pattern/assets/152908296/bfda74dc-097c-4b7e-bcff-bfa827195d0e)


 ![image](https://github.com/dnyanesh-genpact/Aggregator-Design-Pattern/assets/152908296/cbb933cf-a442-47f3-a23b-d073329d5cf3)


  ![image](https://github.com/dnyanesh-genpact/Aggregator-Design-Pattern/assets/152908296/345913e1-0775-4bc4-99d4-d672ef00a59f)



# Sample Code for Controllers and Models
 **Account Controller** : 

![image](https://github.com/dnyanesh-genpact/Aggregator-Design-Pattern/assets/152908296/d512c8de-348f-4948-86e8-314fbb19309f)


**Account Model** : 

![image](https://github.com/dnyanesh-genpact/Aggregator-Design-Pattern/assets/152908296/b1d28399-57ac-4e5b-b97b-c0dc450b41ad)


**FundTransfer Controller** : 

![image](https://github.com/dnyanesh-genpact/Aggregator-Design-Pattern/assets/152908296/bc4d3069-634e-43dc-aae5-c0b37f1bb8c5)


**FundTransfer model** : 

![image](https://github.com/dnyanesh-genpact/Aggregator-Design-Pattern/assets/152908296/6a13fb64-5f08-43f7-92c0-0db4137da220)


**Report Controller (Aggregator Controller)** : 

![image](https://github.com/dnyanesh-genpact/Aggregator-Design-Pattern/assets/152908296/4af50a19-96c6-4cd1-b4a1-b372325160c3)


**Report Model** : 

![image](https://github.com/dnyanesh-genpact/Aggregator-Design-Pattern/assets/152908296/01df56f7-ca3f-45d4-9698-9a7cfb51fb59)


# Contributing
  Contributions are welcome!

# Contact
  For questions or feedback, please email at tathoded@gmail.com OR dnyaneshsunilrao.tathode@genpact.com.



   
     
      

  

