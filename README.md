# Fawry E-Commerce System

This project implements an e-commerce system as part of the Fawry Quantum Internship Challenge. The system supports various product types with different characteristics (expirable, shippable) and provides complete checkout functionality.
## Class Diagram
![Class Diagram](https://github.com/user-attachments/assets/1a9ecad9-1abf-481d-8ea4-8b4ef71a9420)
## Features

- **Product Management**:
  - Basic products with name, price, and quantity
  - Expirable products (e.g., Cheese, Biscuits)
  - Shippable products with weight information (e.g., TV, Cheese)
  - Products that are both expirable and shippable

- **Shopping Cart**:
  - Add products with specific quantities
  - Validate stock availability
  - Check for expired products
  - Calculate subtotal, shipping fees, and total amount

- **Checkout System**:
  - Process payments and validate customer balance
  - Generate detailed receipts
  - Handle shipping notifications for shippable items
  - Comprehensive error handling for various scenarios



## Implementation Details

### Core Classes

- **Product**: Base class for all products
- **ExpirableProduct**: Extends Product and implements Expirable interface
- **ShippableProduct**: Extends Product and implements Shippable interface
- **ShippableExpirableProduct**: Combines both expirable and shippable features
- **Cart**: Manages products added by user and calculates totals
- **User**: Represents a customer with balance and cart

### Key Methods

- `addItem()`: Adds product to cart with quantity validation
- `checkoutCart()`: Processes payment and generates receipt
- `calculateSubTotal()`: Computes sum of all items
- `calculateShipping()`: Calculates shipping fees based on weight
- `isExpired()`: Checks if product has expired
