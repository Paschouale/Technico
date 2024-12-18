# Final Project - Property Management System

## Project Overview
This project is a property management system designed for a renovation contractor agency. It includes two roles:

- **Admin**: Manages properties, property owners, and repairs.
- **Property Owner**: Manages their own properties and repairs.

The system provides a comprehensive API for managing properties, property owners, and repairs with full CRUD functionality, authentication, and authorization.

---

## Project Features

### **1. Authentication & Authorization:**
- Login functionality with role-based access.
- Admin and Property Owner roles.

### **2. CRUD Operations:**
- **Property Owners:** Create, read, update, and delete.
- **Properties:** Create, read, update, and delete.
- **Repairs:** Create, read, update, and delete.

### **3. Exception Handling:**
- Custom exception handling for validation errors like invalid VAT numbers, emails, and phone numbers.

### **4. Reporting:**
- Fetching repairs by property owner, property, repair date, and repair date range.

### **5. Data Loading:**
- Initial data population using a `DataLoader` class.

---

## Technology Stack

- **Backend:** Java 23, Spring Boot
- **Database:** MySQL Server
- **Build Tool:** Maven
- **IDE:** IntelliJ IDEA

---

## Project Structure
gr.ote.finalproject

├── bootstrap          # Data loader for initial setup

├── configuration      # Application configuration (CORS settings)

├── controller         # REST API controllers

├── domain             # Entity classes

├── enumeration        # Enumerations for fixed values

├── exception          # Custom exception handlers

├── repository         # Spring Data JPA repositories

├── service            # Business logic layer

├── transfer           # DTO classes

└── FinalProjectApplication.java  # Main Spring Boot application class


---

## Endpoints Overview

### **Authentication:**
- `POST /api/login`

### **Property Owners:**
- `POST /api/propertyOwners` - Create a property owner
- `GET /api/propertyOwners/{id}` - Get a property owner by ID
- `GET /api/propertyOwners/vat/{vatNumber}` - Get by VAT number
- `GET /api/propertyOwners/email/{email}` - Get by email
- `PUT /api/propertyOwners/{id}` - Update property owner
- `DELETE /api/propertyOwners/{id}` - Delete property owner

### **Properties:**
- `POST /api/properties` - Create a property
- `GET /api/properties/id/{propertyIdNumber}` - Get property by ID
- `GET /api/properties/propertyOwner/{vatNumber}` - Get properties by owner VAT
- `PUT /api/properties/{propertyIdNumber}` - Update property
- `DELETE /api/properties/{propertyIdNumber}` - Delete property

### **Repairs:**
- `POST /api/repairs` - Create a repair
- `GET /api/repairs/id/{id}` - Get repair by ID
- `GET /api/repairs/propertyOwner/{id}` - Get repairs by property owner ID
- `GET /api/repairs/date/{date}` - Get repairs by specific date
- `GET /api/repairs/date-range?startDate={start}&endDate={end}` - Get repairs by date range
- `PUT /api/repairs/{id}` - Update repair
- `DELETE /api/repairs/{id}` - Delete repair

---

## Installation and Setup

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/finalproject.git

   
2. Configure the database in application.properties:
- `spring.datasource.url=jdbc:mysql://localhost:3306/technico`
- `spring.datasource.username=root`
- `spring.datasource.password=`
- `spring.jpa.hibernate.ddl-auto=create`
- `spring.jpa.show-sql=true`
  
3. Run the application:
- ` mvn spring-boot:run`

  
---

## Database Schema

-Tables:

- ` login_users - Stores user credentials.`

- ` property_owners - Contains property owner details.`

- ` properties - Stores property information.`

- `repairs - Logs repair details.`

## Custom Exceptions

- `EmailException - Invalid email format.`

- `PhoneNumberException - Invalid phone number.`

- `VatNumberException - Incorrect VAT number.`

- `NumberE9Exception - Duplicate or invalid property number.`

- `ResourceNotFoundException - Resource not found.`

## Future Enhancements

- `Add detailed repair history reporting.`

- `Implement property valuation reports.`

- `Improve security with JWT authentication.`

## Contributors

- `Dora Vasiladioti - Developer `
- `Dimitrios Paschalis - Developer `
- `Dimitris Zachos - Developer `


## License

- `This project is licensed under the MIT License.`

## Acknowledgements

- A big thanks to CodeHub and OTE Group of Companies for their support!!

- `Spring Boot Framework`

- `MySQL Database`

- `IntelliJ IDEA IDE`


