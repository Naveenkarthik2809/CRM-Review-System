CRM Review Management System (Java)

Introduction
The CRM Review Management System is a simple Java console-based application designed for beginners to practice Object-Oriented Programming concepts such as classes, objects, inheritance, encapsulation, and polymorphism. This project also demonstrates how to persist data using text files in Java. It allows customers to submit reviews about their experience, and administrators to manage and analyze these reviews for better decision-making.

Project Objective
The objective of this project is to provide a beginner-friendly example of a review management workflow that includes:

1. Customer interaction through console menus.
2. Review storage and retrieval using a text file.
3. Role-based operations (Customer and Admin).
4. Practical implementation of core Java OOP concepts.

Features

Customer Features

1. Submit a new review with details such as customer ID, experience duration, and review text.
2. Automatically assign a unique ID to each review.
3. View all reviews submitted by the customer.

Admin Features

1. View all customer reviews submitted in the system.
2. Filter reviews based on customer ID or keywords.
3. Generate insights by categorizing reviews (positive/negative/neutral).
4. Delete irrelevant or inappropriate reviews.

File Handling Features

1. All reviews are saved to a text file named reviews.txt so that records are not lost when the program is stopped.
2. On restarting the program, the system reloads all reviews from the file.
3. File format is simple and line-based. Each review is saved in the following format:

   ReviewID|CustomerID|ExperienceDuration|ReviewText

Example:
1|C101|2 Years|Great service and friendly staff
2|C102|6 Months|Average experience, needs improvement

Project Structure
The project consists of four Java files:

1. Review\.java – Model class representing a review object with fields like id, customerId, duration, and reviewText.
2. CustomerService.java – Handles customer-related operations such as submitting new reviews and viewing their history.
3. AdminService.java – Handles admin-related operations such as viewing reviews, filtering, generating insights, and deleting reviews.
4. Main.java – The entry point of the program which provides a console-based menu for customers and admins.

How the System Works

1. When the program starts, it loads any existing reviews from reviews.txt.
2. Users can choose to log in as Customer or Admin.
3. If logged in as Customer:
   a. The customer can submit a new review by providing their ID, duration, and feedback.
   b. The review is assigned a unique ID and saved into reviews.txt.
   c. The customer can also view all reviews they have submitted.
4. If logged in as Admin:
   a. The admin can view all reviews in the system.
   b. The admin can filter reviews by customer ID or search for specific keywords.
   c. The admin can categorize reviews as positive, neutral, or negative.
   d. The admin can delete reviews if necessary.
5. All operations are reflected in the text file immediately to ensure persistence.

How to Run the Project

Using Command Line
Step 1: Save all four Java files (Review\.java, CustomerService.java, AdminService.java, Main.java) in the same folder.
Step 2: Open terminal or command prompt in that folder.
Step 3: Compile the code using:
javac \*.java
Step 4: Run the program using:
java Main

Using an IDE (Eclipse, IntelliJ, NetBeans)

1. Create a new Java project.
2. Add all four Java files in the src folder.
3. Run Main.java.

Sample Run

Welcome to CRM Review Management System

1. Customer
2. Admin
3. Exit
   Enter your choice: 1

Customer Menu

1. Submit a new review
2. View my reviews
3. Back
   Enter your choice: 1
   Enter Customer ID: C101
   Enter Experience Duration: 2 Years
   Enter Review Text: Great service and friendly staff
   Review submitted successfully with ID: 1

Customer Menu

1. Submit a new review
2. View my reviews
3. Back
   Enter your choice: 2
   Reviews:
   ID: 1 | CustomerID: C101 | Duration: 2 Years | Review: Great service and friendly staff

Returning to Main Menu...

Admin Menu

1. View all reviews
2. Filter reviews
3. Categorize reviews
4. Delete a review
5. Back
   Enter your choice: 1
   All Reviews:
   ID: 1 | CustomerID: C101 | Duration: 2 Years | Review: Great service and friendly staff

Admin Menu
Enter your choice: 2
Enter Customer ID to filter: C101
Filtered Reviews:
ID: 1 | CustomerID: C101 | Duration: 2 Years | Review: Great service and friendly staff

Admin Menu
Enter your choice: 3
Enter Review ID to categorize: 1
Enter Category (Positive/Neutral/Negative): Positive
Review categorized successfully!

All changes are saved to reviews.txt

Benefits of This Project

1. Beginner-friendly and easy to understand.
2. Demonstrates practical use of classes, objects, and OOP principles.
3. Shows how to persist data using file handling.
4. Simple modular design with separate files for model, customer service, admin service, and main application.
5. Can be extended to use advanced concepts such as databases, analytics, and GUI later.

Author
Developed by Naveen Karthik B
For learning purposes in Java programming, file handling, and object-oriented concepts.
