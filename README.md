# FrontendTesting Framework

This project is a frontend testing framework using **Playwright**, **Cucumber**, and **Groovy** for automated browser testing. The framework is designed to support different environments (e.g., **staging**, **production**) and can be run using **Maven**.

## Prerequisites

Before running the tests, ensure the following dependencies are installed:

- **Java 17** or above
- **Maven 3.6+**
- **Playwright** (Java bindings)
- **Cucumber** (Java and Groovy support)

## Setup

1. **Clone the repository:**

   ```bash
   git clone https://github.com/your-repository.git
   cd ZitexFrontendTesting
   ```

2. **Run tests:**
    Current support only for staging env
   ```bash
    mvn test -Denv=staging   
   ```
   
3. **Run tests with tag:**
    ```bash
    mvn -Denv=staging -D"cucumber.filter.tags"="@with_account" test
   ```
