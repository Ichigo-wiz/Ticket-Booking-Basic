# ✈️ Travel Booking System – Java CLI Project (Inspired by MakeMyTrip)

This is a command-line based **Travel Booking System** written in Java. The application allows users to register/login, choose travel dates, book tickets, select hotels, and add optional services like spa, food, bar, etc. It simulates a basic travel planning workflow, mimicking platforms like MakeMyTrip.

---

## 📁 File Structure

```
mmt1_final.java   # Main Java file with all logic: user management, bookings, billing
```

---

## 🚀 Features

- 👤 User registration and login system  
- 🔐 CAPTCHA verification to simulate real-world login validation  
- 📅 Journey date selection  
- 🚌 Travel ticket booking with number of passengers  
- 🏨 Hotel selection and booking with day-wise stay options  
- 🧾 Add-on services: extra bed, laundry, food, bar, spa  
- 💳 Full bill generation and display  

---

## 🛠️ Technologies Used

- Java (JDK 8 or above)  
- Command Line Interface (CLI)  
- Object-Oriented Programming principles  
- Scanner for user input  

---

## 📌 How to Run

### Step 1: Compile the code
```bash
javac mmt1_final.java
```

### Step 2: Run the program
```bash
java Main
```

✅ Make sure Java is installed and properly configured in your system.

---

## 🧪 Sample Flow

```
Welcome ☺️!!
Choose your option
Press 1 to Register
Press 2 to Login
Press 3 to exit
> 1

[User enters full name, mobile number, DOB, username, password]

> 2
Enter username - test_user
Enter password - ********
CAPTCHA: iJ8uGF71
Enter CAPTCHA code - iJ8uGF71

You have logged in successfully
Welcome to Make my Trip
----------------------
[Date selection, ticket booking, hotel choice, service selection, final bill]
```

---

## 🎯 Learning Objectives

- 🔄 Implementing user sessions with validation  
- 📦 Encapsulating data and logic in a class (`Customer`)  
- 🧮 Calculating dynamic totals based on selections  
- 🛂 Validating login credentials and security using CAPTCHA  
- 📅 Handling calendar date logic for booking workflows  

---

## 📄 Billing Components

- 💺 Room charge per day (based on hotel type)
- 🛏️ Extra bed: ₹600/day  
- 🧺 Laundry: ₹100/day  
- 🍽️ Food: variable per meal  
- 🍸 Bar: ₹1000/drink  
- 💆 Spa: ₹1500/session  

All values are calculated and added to the final bill.

---

## ✍️ Author

Developed by **Satvik Parihar, Chinmay Modi, DevPriya Morkhiya , Dhruvish Patel , Yug Dandawala**
🔗 [GitHub: Ichigo-wiz](https://github.com/Ichigo-wiz)

---
