# Incident Management Sample Application

This is a sample CAP (Cloud Application Programming Model) application that demonstrates how to use the SAP CAP Java repository template in a real project.

## About This Sample

This sample application showcases:
- How to integrate the emoji template as a dependency in your CAP Java project
- A complete incident management application with services, UI, and data model
- Best practices for structuring a CAP Java application
- Integration with the template's emoji functionality

## Prerequisites

- Java 17 or higher
- Maven 3.6.3 or higher
- Node.js 20 or higher (for CDS development)

## Getting Started

### 1. Install the Template

First, you need to install the emoji template to your local Maven repository:

```bash
# From the root of the repository-template project
cd ../..
mvn clean install
```

### 2. Build the Sample

```bash
# From this directory (samples/incident-app)
mvn clean package
```

### 3. Run the Application

You have several options to run the application:

**Option A: Using CDS Watch (Recommended for development)**
```bash
cds watch
```

**Option B: Using Maven**
```bash
mvn spring-boot:run -pl srv
```

**Option C: Using Java directly**
```bash
java -jar srv/target/incident-management-exec.jar
```

### 4. Access the Application

Once running, you can access:
- **Application**: http://localhost:8080
- **Service Endpoints**: http://localhost:8080/$metadata
- **Fiori Launchpad**: http://localhost:8080/launchpage.html

## Project Structure

```
incident-app/
├── app/                    # UI applications
│   └── incidents/         # Fiori Elements app for incidents
├── db/                    # Data model and sample data
├── srv/                   # Service layer (Java)
├── package.json          # Node.js dependencies
└── pom.xml              # Maven parent POM
```

## Features Demonstrated

1. **CAP Service Definition**: Services defined in `srv/services.cds`
2. **Java Service Implementation**: Custom logic in `srv/src/main/java/`
3. **Data Model**: Entity definitions in `db/schema.cds`
4. **UI Integration**: Fiori Elements application
5. **Template Integration**: Uses the emoji template functionality

## Testing

Run the tests:

```bash
mvn test
```

## Template Integration

This sample shows how to:
1. Add the template as a Maven dependency in `srv/pom.xml`
2. Use template functionality in your service handlers
3. Configure the template through application properties

Check the `srv/src/main/java/customer/incident_app/handler/` directory for examples of using the template features.

## Development

For active development:

1. Start the application with `cds watch`
2. Make changes to your code
3. The application will automatically reload

## Troubleshooting

**Build Issues**: Make sure you have installed the template first (`mvn install` from the root)

**Runtime Issues**: Check that Java 21 is being used and all dependencies are resolved

**Port Conflicts**: If port 8080 is busy, set `server.port=8081` in `srv/src/main/resources/application.yaml`

## Next Steps

- Explore the service implementations in `srv/src/main/java/`
- Check the data model in `db/schema.cds`
- Customize the UI in `app/incidents/`
- Add your own services and handlers following the same patterns
