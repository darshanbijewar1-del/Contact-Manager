# 📞 Contact Information Display System (Java - OOP)

## 📌 Project Overview

This project is a **Contact Information Display System** built using **Core Java** and **Object-Oriented Programming (OOP)** concepts.
It allows users to **add, display, and store contacts permanently using file handling**.

---

## 🎯 Features

* ➕ Add Personal Contact
* ➕ Add Business Contact
* 📋 Display All Contacts
* 💾 Save Contacts to File
* 📂 Load Contacts from File

---

## 🧠 OOP Concepts Used

| Concept       | Implementation                                         |
| ------------- | ------------------------------------------------------ |
| Encapsulation | Private variables with getters                         |
| Inheritance   | `PersonalContact` & `BusinessContact` extend `Contact` |
| Polymorphism  | `displayInfo()` method overriding                      |
| Abstraction   | Abstract class `Contact`                               |

---

## 🏗️ Project Structure

```
Contact (Abstract Class)
│
├── PersonalContact
├── BusinessContact
│
ContactManager
│
Main
```

---

## 📂 File Handling

### Save Data

* Contacts are stored in `contacts.txt`
* Format:

```
PERSONAL,Name,Phone,Relation
BUSINESS,Name,Phone,Company
```

### Load Data

* Reads from file
* Converts text back into objects

---

## ▶️ How to Run

### 1. Compile all files

```
javac *.java
```

### 2. Run the program

```
java Main
```

---

## 🧪 Sample Output

```
1. ADD PERSONAL CONTACT
2. ADD BUSINESS CONTACT
3. DISPLAY ALL CONTACT
4. Exit
```

---

## 🚀 Future Improvements

* 🔍 Search Contact
* ❌ Delete Contact
* ✏️ Update Contact
* 🖥️ GUI using Java Swing

---

## 🎤 Viva Questions

**Q: Why use abstract class?**
To define common structure and enforce method implementation.

**Q: What is polymorphism?**
Same method behaves differently in different classes.

**Q: Why file handling?**
To store data permanently.

---

## 👨‍💻 Author

Darshan Bijewar

---

## 📌 Conclusion

This project demonstrates how **Java OOP concepts + File Handling** can be used to build a real-world application.

---
