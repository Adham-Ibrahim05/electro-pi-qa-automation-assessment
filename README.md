# Electro Pi – QA Automation Assessment

## Overview

This repository contains the UI automation implementation for the Electro Pi Senior QA Automation Engineer Technical Assessment.

The framework automates the following inventory management flow:

1. Login as a Store Admin
2. Navigate to the Inventory module
3. Enter Product Name
4. Enter Price
5. Save the inventory item
6. Validate the success notification

## Technology Stack

* Java
* Selenium WebDriver
* TestNG
* Maven
* Page Object Model (POM)

## Framework Structure

```text
src/test/java
├── base
│   └── BaseTest.java
├── pages
│   ├── LoginPage.java
│   └── InventoryPage.java
├── tests
│   └── InventoryTest.java
└── utilities
    └── GeneralUtility.java
```

## Design Approach

The framework uses the Page Object Model to separate test logic from UI implementation.

* Page classes contain locators and page-specific actions.
* Test classes contain test scenarios and assertions.
* BaseTest manages WebDriver setup and teardown.
* GeneralUtility contains reusable Selenium functionality and explicit waits.

## Synchronization

The framework uses Selenium explicit waits and `ExpectedConditions` instead of hardcoded sleeps.

This helps reduce flaky tests when dealing with dynamic elements, loading states, and asynchronous UI operations.

## Test Execution

Run the test suite using Maven:

```bash
mvn clean test
```

## Notes

The application URL and credentials should be configured according to the target test environment and should not be committed as plain-text secrets to the repository.
