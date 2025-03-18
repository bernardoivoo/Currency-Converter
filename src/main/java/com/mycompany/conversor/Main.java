/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.conversor;

/**
 *
 * @author berna
 */
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author berna
 */
public class Main {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Conversor de Moedas");
        System.out.print("Digite a moeda de origem (ex: USD): ");
        String fromCurrency = scanner.nextLine().toUpperCase();

        System.out.print("Digite a moeda de destino (ex: BRL): ");
        String toCurrency = scanner.nextLine().toUpperCase();

        System.out.print("Digite o valor a ser convertido: ");
        double amount = scanner.nextDouble();

        try {
            double convertedAmount = CurrencyApiClient.getExchangeRate(fromCurrency, toCurrency, amount);
            System.out.printf("%.2f %s equivalem a %.2f %s%n", amount, fromCurrency, convertedAmount, toCurrency);
        } catch (IOException e) {
            System.out.println("Erro ao acessar a API: " + e.getMessage());
        }
    }
}
