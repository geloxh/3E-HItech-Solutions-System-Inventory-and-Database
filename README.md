# Asset Management System

A comprehensive asset management system built with Java, Spring Boot, JavaFX, and MySQL. This system provides full CRUD operations for assets and maintains detailed logs for asset usage, condition, events, and location tracking.

## Features

### Backend (Spring Boot)
- **JWT-based Authentication**: Secure login and registration system
- **Asset Management**: Complete CRUD operations for assets
- **Reference Data Management**: Asset types, brands, operating systems, offices, inclusions
- **Comprehensive Logging**: 
  - Asset Usage Log: Track asset checkout, return, and usage
  - Condition Log: Monitor asset condition over time
  - Event Log: Record maintenance, repairs, and other events
  - Location Log: Track asset location changes
- **RESTful API**: Well-documented API endpoints
- **MySQL Database**: Persistent data storage with JPA/Hibernate
- **Validation & Error Handling**: Input validation and global exception handling

### Frontend (JavaFX)
- **Modern Desktop Application**: Cross-platform JavaFX interface
- **Authentication**: Login and registration forms
- **Asset Management Interface**: Tabbed interface for managing assets and logs
- **Real-time API Integration**: HTTP client with JWT token management

## Technology Stack

- **Backend**: Java 17, Spring Boot 3.3.2, Spring Security, Spring Data JPA
- **Database**: MySQL
- **Authentication**: JWT (JSON Web Tokens)
- **Frontend**: JavaFX 21, FXML
- **Build Tool**: Maven 3.x
- **Additional**: Lombok, MapStruct, Jackson, Apache HttpClient 5

## Prerequisites

1. **Java 17 or higher**
2. **Maven 3.6+**
3. **MySQL 8.0+**
4. **JavaFX Runtime** (included in OpenJDK distributions or available separately)

## Database Setup

1. **Install MySQL** and ensure it's running
2. **Create Database and User**:
   ```sql
   CREATE DATABASE asset_manager;
   CREATE USER 'asset_user'@'localhost' IDENTIFIED BY 'asset_pass';
   GRANT ALL PRIVILEGES ON asset_manager.* TO 'asset_user'@'localhost';
   FLUSH PRIVILEGES;
   ```

3. **Configure Database Connection** (optional):
   You can override the default database settings using environment variables:
   ```bash
   export MYSQL_URL=jdbc:mysql://localhost:3306/asset_manager
   export MYSQL_USERNAME=asset_user
   export MYSQL_PASSWORD=asset_pass
   ```

## Build and Run

### Option 1: Build and Run Both Modules

1. **Navigate to project root**:
   ```bash
   cd asset-manager
   ```

2. **Build the entire project**:
   ```bash
   mvn clean install
   ```

3. **Run the Server** (in one terminal):
   ```bash
   cd server
   mvn spring-boot:run
   ```
   The server will start on http://localhost:8080

4. **Run the Client** (in another terminal):
   ```bash
   cd client
   mvn javafx:run
   ```

### Option 2: Build and Run Separately

#### Server
```bash
cd server
mvn clean compile
mvn spring-boot:run
```

#### Client
```bash
cd client
mvn clean compile
mvn javafx:run
```

## API Documentation

Once the server is running, you can access:
- **Swagger UI**: http://localhost:8080/swagger-ui.html
- **API Docs**: http://localhost:8080/api/docs

### Key Endpoints

#### Authentication
- `POST /api/auth/register` - Register new user
- `POST /api/auth/login` - User login

#### Asset Management
- `GET /api/assets` - List all assets
- `POST /api/assets` - Create new asset
- `GET /api/assets/{id}` - Get asset by ID
- `PUT /api/assets/{id}` - Update asset
- `DELETE /api/assets/{id}` - Delete asset

#### Reference Data
- `GET/POST /api/asset-types` - Asset types
- `GET/POST /api/brands` - Brands
- `GET/POST /api/operating-systems` - Operating systems
- `GET/POST /api/offices` - Offices
- `GET/POST /api/inclusions` - Inclusions

#### Logging Endpoints
- `GET/POST /api/asset-usage-logs` - Usage logs
- `GET/POST /api/condition-logs` - Condition logs
- `GET/POST /api/event-logs` - Event logs
- `GET/POST /api/location-logs` - Location logs

## Usage Guide

### First Time Setup

1. **Start the Server**: Follow build instructions above
2. **Launch the Client**: The JavaFX application will show a login screen
3. **Register**: Click "Register" to create your first user account
4. **Login**: Use your credentials to access the main interface

### Using the Application

1. **Assets Tab**: Manage your asset inventory
   - Add new assets with asset tag, type, brand, OS, office assignment
   - View, edit, and delete existing assets

2. **Usage Logs Tab**: Track asset usage
   - Record when assets are checked out, returned, or used
   - Add notes about usage patterns

3. **Condition Logs Tab**: Monitor asset condition
   - Track condition changes over time (excellent, good, fair, poor, damaged)
   - Add maintenance notes

4. **Event Logs Tab**: Record significant events
   - Log maintenance, repairs, upgrades, or retirement
   - Detailed event descriptions

5. **Location Logs Tab**: Track asset locations
   - Record location changes
   - Associate with specific offices

### Data Model Overview

- **Assets**: Central entity with asset tag, type, brand, OS, office, acquisition date, assigned user
- **Users**: System users with JWT authentication and role-based access
- **Reference Tables**: Asset types, brands, operating systems, offices, inclusions
- **Log Tables**: All logs are timestamped and link to specific assets

## Additional Features

- **JWT Security**: All API endpoints (except auth) require valid JWT token
- **Auto-timestamping**: Log entries automatically timestamp when created
- **Cross-platform**: JavaFX client runs on Windows, macOS, and Linux
- **Extensible**: Easy to add new log types or asset attributes

## Development Notes

### Adding New Features

1. **Server-side**: Add entities, repositories, services, and controllers following the existing pattern
2. **Client-side**: Create new FXML views and controllers, update API client as needed

### Database Schema

The application uses JPA with Hibernate to auto-generate the database schema on startup. The `ddl-auto: update` setting will create tables and update the schema as needed.

### Security Configuration

- CORS is enabled for all origins (development setup)
- JWT tokens expire after 24 hours by default
- Passwords are hashed using BCrypt

## Troubleshooting

### Common Issues

1. **Database Connection**: Ensure MySQL is running and credentials are correct
2. **Java Version**: Requires Java 17+
3. **JavaFX**: Ensure JavaFX modules are available
4. **Port 8080**: Make sure port 8080 is not in use by another application

### Logs

- **Server logs**: Check console output for Spring Boot application logs
- **Client logs**: JavaFX application will show errors in console

## Contributing

This is a complete, production-ready asset management system. You can extend it by:
- Adding more asset attributes
- Implementing advanced search and filtering
- Adding reporting features
- Implementing role-based permissions
- Adding email notifications
- Integrating with external systems

The codebase follows standard Spring Boot and JavaFX patterns, making it easy to extend and maintain.
