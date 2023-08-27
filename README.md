# Math Equation Helper

This Java application assists math teachers by providing a user interface for inputting, validating, and storing mathematical equations and their roots. The application uses JavaFX for the user interface and interacts with a MySQL database to store equations and associated roots.

## Prerequisites

- Java Development Kit (JDK) 17
- MySQL database (with a pre-created database named 'equations')
- Maven

## Installation and Setup

1. Clone the repository:

```bash
git clone https://github.com/yourusername/math-equation-helper.git
cd math-equation-helper
```

2. Configure the database connection in `src/main/resources/application.properties`.

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/equations
spring.datasource.username=yourusername
spring.datasource.password=yourpassword
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```

3. Build and run the application using Maven:

```bash
mvn clean javafx:run
```

## Features

- Input and validation of mathematical equations
- Validation of parentheses placement
- Validation of correct expression format
- Input and storage of equation roots
- Search for equations based on roots
- JavaFX user interface for easy interaction

## Usage

1. Enter a mathematical equation in the input field, e.g., `2*x + 5 = 17`.
2. Enter the roots of the equation separated by commas, e.g., `3, 7, -1`.
3. Click the "Check" button to validate the equation, its parentheses, expression format, and roots.
4. Click the "Search by Root" button to find equations with a specific root.
5. Validated equations and search results are displayed in the list view.

## Contributing

Contributions are welcome! Feel free to fork the repository and submit pull requests.

## License

This project is licensed under the [MIT License](LICENSE).

---

Please note that you need to replace `'yourusername'` and `'yourpassword'` in the configuration with your actual MySQL credentials. Make sure you have set up your MySQL database with the necessary tables as mentioned in your code.
