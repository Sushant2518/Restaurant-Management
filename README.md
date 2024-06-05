# Restaurant-Management
This project is a Restaurant Management System built using Spring Boot, Spring Security, and MySQL. It provides various REST API endpoints for managing users, tables, restaurants, reservations, orders, order items, and menus.

## Prerequisites
- Java 11 or higher
- Maven
- MySQL
- Spring Boot

## API Endpoints

### User Controller

- **Register a new user**
  - `POST /user/register`
  
- **Login**
  - `POST /user/login`
  
- **Update user details** (Protected: Admin only)
  - `PATCH /user/update`
  
- **Get user by email**
  - `GET /user/getbyemail`
  
- **Get all users**
  - `GET /user/getall`
  
- **Delete a user**
  - `DELETE /user/delete`

### Tables Controller (Protected: Admin only)

- **Create a new table**
  - `POST /tables/createtable`
  
- **Delete a table**
  - `DELETE /tables/delete`

### Restaurant Controller (Protected: Admin only)

- **Create a new restaurant**
  - `POST /restaurant/create`
  
- **Delete a restaurant**
  - `DELETE /restaurant/delete`

### Reservation Controller

- **Create a new reservation**
  - `POST /reservation/createRes`
  
- **Delete a reservation**
  - `DELETE /reservation/delete`

### Order Controller

- **Create a new order**
  - `POST /orders/createorder`
  
- **Get all orders**
  - `GET /orders/getAll`
  
- **Delete an order**
  - `DELETE /orders/delete`

### Order Item Controller (Protected: Admin only)

- **Create a new order item**
  - `POST /orderitem/create`
  
- **Delete an order item**
  - `DELETE /orderitem/delete`

### Menu Controller (Protected: Admin only)

- **Add a new menu**
  - `POST /menu/addMenu`
  
- **Get all menus**
  - `GET /menu/findAll`
  
- **Delete a menu**
  - `DELETE /menu/delete`

## Security

This project uses Spring Security for authentication and authorization. Role-based authentication is implemented to protect specific endpoints. The following endpoints are restricted to admin users only:
- `PATCH /user/update`
- Endpoints in the Tables Controller
- Endpoints in the Restaurant Controller
- Endpoints in the Order Item Controller
- Endpoints in the Menu Controller
