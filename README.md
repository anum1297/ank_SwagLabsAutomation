# 🧪 Swag Labs Automation Framework

Automated Test Framework built using **Selenium WebDriver**, **TestNG**, **Extent Reports**, and **Maven** to validate the UI workflows of [Swag Labs](https://www.saucedemo.com/).

---

## 📌 Table of Contents

- [📖 Overview](#overview)
- [🧰 Tech Stack](#tech-stack)
- [🗂 Project Structure](#project-structure)
- [🚀 Setup Instructions](#setup-instructions)
- [▶️ How to Run Tests](#how-to-run-tests)
- [📊 Reporting](#reporting)
- [🔁 CI/CD Pipeline](#cicd-pipeline)
- [📫 Contribution](#contribution)
- [🔐 License](#license)

---

## 📖 Overview

This automation suite is designed to:

- Perform **end-to-end testing** of Swag Labs (login, add to cart, checkout, etc.)
- Generate clean and detailed HTML test reports
- Support **parameterized execution** via TestNG and Jenkins
- Easily scalable for different environments and browsers

---

## 🧰 Tech Stack

| Tool            | Purpose                         |
|-----------------|----------------------------------|
| Java            | Programming language             |
| Selenium WebDriver | Browser automation           |
| TestNG          | Testing framework                |
| Maven           | Build and dependency management  |
| Extent Reports  | HTML reporting                   |
| Jenkins         | CI/CD pipeline                   |
| GitHub          | Version control                  |

---

## 🗂 Project Structure

SwagLabsAutomation/
├── src/
│ ├── main/
│ │ └── java/com.swaglabs.pages/ # Page Object Model classes
│ └── test/
│ └── java/com.swaglabs.tests/ # TestNG test cases
├── testng.xml # Test suite configuration
├── pom.xml # Maven build file
├── reports/ # Extent reports output
└── README.md # Project documentation
