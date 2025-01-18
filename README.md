# Currency Converter

This project is a solution to the challenge proposed by the ONE (Oracle Next Education) program for developing a currency converter. The program is built using **Java** and focuses on consuming a REST API to obtain real-time exchange rates. The primary objective is to demonstrate key backend development skills, including handling HTTP requests, processing JSON data, and creating interactive console applications.

## 📋 Description

The currency converter allows users to convert amounts from US Dollars (USD) to various foreign currencies. Exchange rates are retrieved in real-time from the Exchange Rate public API.

### Key Features:
- **Interactive Menu**: Displays options for users to select different target currencies.
- **REST API Consumption**: Uses `java.net.http.HttpClient` and `java.net.http.HttpRequest` library to make HTTP requests and fetch JSON data extracting data from `https://www.exchangerate-api.com/docs/java-currency-api`
- **JSON Processing**: Leverages the Gson library to parse and extract information from the response body.
- **Modularity**: Implements a structured and reusable approach to ensure code readability and maintainability.

## System Requirements

Before running this program, ensure you have the following installed on your system:
- **Java 17** or higher.
- A code editor (e.g., IntelliJ IDEA, Eclipse, VS Code).
- Internet connection to access the exchange rate API.

## Installation

Follow these steps to set up and run the program:

1. Clone this repository:
   ```bash
   git clone https://github.com/username/currency-converter.git
