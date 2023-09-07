# Super-Saving Supermarket POS System

Welcome to the Super-Saving Supermarket Point of Sales (POS) system! This Java-based application is designed to streamline the billing process for the Super-Saving supermarket chain. Whether you're a cashier, customer, or a developer, this POS system is here to make grocery shopping a breeze.

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Getting Started](#getting-started)
- [Exception Handling](#exception-handling)
- [Serialization](#serialization)
- [Contributing](#contributing)
- [License](#license)

## Introduction

This POS system is a vital component of the Super-Saving supermarket chain. It simplifies the billing process, ensuring accuracy and efficiency while providing essential features such as handling pending bills and managing discounts.

## Features

### 1. Item Code Lookup

- Cashiers can quickly add grocery items to the bill by entering the item code.
- The system fetches item details such as price, weight/size, manufacturing date, expiry date, and manufacturer name from the database (for this exercise, we'll use hardcoded data).

### 2. Discount Management

- Items can be discounted from 0% to 75%, ensuring customers get the best deals.
- Discounts are automatically applied to the bill, showing both the total discount and the net price.

### 3. Pending Bill Handling

- The system can handle pending bills for customers who need to weigh items or perform other tasks.
- Cashiers can set a bill aside and continue serving other customers, simplifying the workflow.

### 4. Exception Handling

- The system includes custom exception handling, such as `ItemCodeNotFound`, to handle cashier mistakes and allow for re-entry of item codes.

### 5. Serialization

- Serialization is used to save and retrieve bill data, ensuring data persistence between sessions.

## Getting Started

To get started with the Super-Saving Supermarket POS system, follow these steps:

1. Clone this repository to your local machine:

   ```bash
   git clone https://github.com/chamikajaya/point_of_sales.git
