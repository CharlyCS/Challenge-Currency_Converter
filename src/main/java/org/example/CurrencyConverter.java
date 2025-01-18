package org.example;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.net.URI;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CurrencyConverter {

    private static final String API_URL = "https://v6.exchangerate-api.com/v6/1e9458a95556bbcc3b9fce9e/latest/USD";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean iterator = true;

        while (iterator) {
            System.out.println("***************************************");
            System.out.println("Bienvenido/a al Conversor de Monedas:");
            System.out.println("1) Dólar =>> Peso argentino (ARS)");
            System.out.println("2) Dólar =>> Euro (EUR)");
            System.out.println("3) Dólar =>> Libra esterlina (GBP)");
            System.out.println("4) Dólar =>> Soles (PEN)");
            System.out.println("5) Salir");
            System.out.println("Seleccione una opción válida:");
            System.out.println("***************************************");

            int option = input.nextInt();

            switch (option) {
                case 1:
                    convertCurrency("ARS");
                    break;
                case 2:
                    convertCurrency("EUR");
                    break;
                case 3:
                    convertCurrency("GBP");
                    break;
                case 4:
                    convertCurrency("PEN");
                    break;
                case 5:
                    iterator = false;
                    System.out.println("Gracias por usar el conversor de monedas. ¡Adiós!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        }

        input.close();
    }

    private static void convertCurrency(String targetCurrency) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(API_URL))
                    .GET()
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            URL url = new URL(API_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            if (response.statusCode() == 200) {
                // Parsear el JSON de la respuesta
                JsonObject responseJson = JsonParser.parseString(response.body()).getAsJsonObject();
                JsonObject conversionRates = responseJson.getAsJsonObject("conversion_rates");

                // Obtener la tasa de conversión para la moneda objetivo
                double conversionRate = conversionRates.get(targetCurrency).getAsDouble();

                // Pedir al usuario la cantidad a convertir
                Scanner input = new Scanner(System.in);
                System.out.println("Ingrese la cantidad en USD que desea convertir:");
                double amountInUsd = input.nextDouble();

                // Calcular el monto convertido y mostrar el resultado
                double convertedAmount = amountInUsd * conversionRate;
                System.out.printf("El monto convertido es: %.2f %s%n", convertedAmount, targetCurrency);

            } else {
                System.out.println("Error al conectar con la API. Código de respuesta: " + connection.getResponseCode());
            }
        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
        }
    }
}
