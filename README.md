# 🏫 Student Management System

A desktop-based Student Management System built with **Java Swing**. It provides a simple GUI to manage student records — add, view, update, and delete students — with a login-protected dashboard.

---

## 📸 Screenshots

> Login → Dashboard → Manage Students

---

## ✨ Features

- 🔐 **Login System** — Secure access with username and password validation
- ➕ **Add Student** — Add students with name, roll number, admission ID, and address
- 📋 **View Students** — See all students in a clean table format
- ✏️ **Update Student** — Select and edit any student's details
- 🗑️ **Delete Student** — Remove a student with a confirmation prompt
- 🚪 **Logout** — Return to login screen from the dashboard

---

## 🗂️ Project Structure

```
StudentManagementSystem/
│
├── Login1.java           # Login screen UI and authentication
├── Dashboard.java        # Main dashboard with navigation buttons
├── AddStudent.java       # Form to add a new student
├── ViewStudents.java     # Table view of all students
├── UpdateStudent.java    # Form to update an existing student
├── DeleteStudent.java    # UI to delete a student
├── Student.java          # Student data model (name, roll, ID, address)
└── StudentsManager.java  # Static list managing all student records
```

---

## 🚀 Getting Started

### Prerequisites

- Java JDK 8 or higher installed
- A terminal / command prompt

### Compile

```bash
javac Student.java StudentsManager.java Login1.java Dashboard.java AddStudent.java ViewStudents.java UpdateStudent.java DeleteStudent.java
```

### Run

```bash
java Login1
```

---

## 🔑 Default Login Credentials

| Username | Password  |
|----------|-----------|
| admin    | admin1234 |

---

## 🛠️ Built With

- **Java** — Core programming language
- **Java Swing** — GUI framework for desktop interface
- **AWT** — Layout and styling support

---

## 📌 How It Works

1. Run the app — the **Login screen** appears
2. Enter the credentials and click **Login**
3. The **Dashboard** opens with four options: Add, View, Update, Delete
4. Each button opens a dedicated screen for that operation
5. Student data is stored **in memory** during the session (no database)
6. Click **Logout** to return to the login screen

---

## 🔮 Future Improvements

- [ ] Connect to a database (MySQL / SQLite) for persistent storage
- [ ] Add search and filter functionality in the View screen
- [ ] Input validation for Admission ID format
- [ ] Add student photo support
- [ ] Export student list to CSV or PDF

---

## 👨‍💻 Author

**Your Name**
- GitHub: [@yourusername](https://github.com/yourusername)

---

## 📄 License

This project is open source and available under the [MIT License](LICENSE).
