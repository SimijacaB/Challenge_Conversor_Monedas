import model.CurrencyExchange;
import model.ExchangeRate;
import service.ConsumoAPI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String output = """
                Programa para convertir monedas!
                """;

        List<CurrencyExchange> exchangeList= new ArrayList<>();

        int exit = 0;
        while (exit != 1) {

            String menu ="""
                    Selecciona la opción de conversión de moneda:
                    1) USD =>> ARS
                    2) ARS =>> USD
                    3) USD =>> BRL
                    4) BRL =>> USD
                    5) USD =>> COP
                    6) COP =>> USD
                    7) Salir
                    8) Mostar todas las conversiones

                    USD: United States Dollar
                    ARS: Argentine Peso
                    BRL: Brazilian Real
                    COP: Colombian Peso
                    """;
            System.out.println(menu);

            Scanner scanner = new Scanner(System.in);

            System.out.println("Ingresa la opción de conversión: ");

            try {
                int exchangeOption = Integer.parseInt(scanner.nextLine());

                String fromCurrency;
                String toCurrency;
                switch (exchangeOption) {
                    case 1:
                        fromCurrency = "USD";
                        toCurrency = "ARS";
                        break;
                    case 2:
                        fromCurrency = "ARS";
                        toCurrency = "USD";
                        break;
                    case 3:
                        fromCurrency = "USD";
                        toCurrency = "BRL";
                        break;
                    case 4:
                        fromCurrency = "BRL";
                        toCurrency = "USD";
                        break;
                    case 5:
                        fromCurrency = "USD";
                        toCurrency = "COP";
                        break;
                    case 6:
                        fromCurrency = "COP";
                        toCurrency = "USD";
                        break;
                    case 7:
                        exit = 1;
                        fromCurrency = null;
                        toCurrency = null;
                        break;
                    default:
                        fromCurrency = null;
                        toCurrency = null;
                        break;
                }

                if (exchangeOption >= 1 && exchangeOption <= 6) {
                    ConsumoAPI consumoAPI = new ConsumoAPI();
                    ExchangeRate exchangeRate = consumoAPI.exchangeRate(fromCurrency, toCurrency) ;

                    System.out.println("The current exchange rate is: " + exchangeRate.conversionRate());

                    System.out.println("How much " + fromCurrency + " do you want to convert? ");
                    Double total = Double.valueOf(scanner.nextLine());

                    double newTotal = total * exchangeRate.conversionRate();

                    System.out.println("The exchange from " +
                            total +
                            " [" + fromCurrency + "]" +
                            " is " +
                            newTotal +
                            " [" + toCurrency + "]");

                    CurrencyExchange exchange = new CurrencyExchange(fromCurrency, toCurrency, total, newTotal);
                    exchangeList.add(exchange);
                } else if (exchangeOption == 7) {
                    System.out.println("Fue un gusto atenderte!\n");
                } else if (exchangeOption == 8) {
                    exchangeList.forEach(System.out::println);
                } else {
                    System.out.println("Ingresa una opción válida");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Ingresa un número válido");
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
