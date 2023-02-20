package com.Streams;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Trader {
    private String name;
    private String city;

    public Trader(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }
}

class Transaction {
    private Trader trader;
    private int year;
    private int value;

    public Transaction(Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }

    public Trader getTrader() {
        return trader;
    }

    public int getYear() {
        return year;
    }

    public int getValue() {
        return value;
    }
}

public class Assignment5Q4 {
    public static List<Transaction> sortTransactions(List<Transaction> transactions) {
        return transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparingInt(Transaction::getValue))
                .collect(Collectors.toList());
    }

    public static List<Integer> transactionsValuesDelhi(List<Transaction> transactions) {
        return transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Delhi"))
                .map(Transaction::getValue)
                .collect(Collectors.toList());
    }

    public static int highestTransaction(List<Transaction> transactions) {
        return transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max)
                .orElse(0);
    }

    public static int smallestTransaction(List<Transaction> transactions) {
        return transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::min)
                .orElse(0);
    }

    public static void main(String[] args) {
        Trader t1 = new Trader("Alice", "Delhi");
        Trader t2 = new Trader("Bob", "Mumbai");
        Trader t3 = new Trader("Charlie", "Delhi");
        Trader t4 = new Trader("David", "Mumbai");
        Trader t5 = new Trader("Eva", "Delhi");

        List<Transaction> transactions = List.of(
                new Transaction(t1, 2011, 100),
                new Transaction(t2, 2012, 200),
                new Transaction(t3, 2011, 300),
                new Transaction(t4, 2013, 400),
                new Transaction(t5, 2011, 500)
        );

        System.out.println("All transactions in 2011 sorted by value: " + sortTransactions(transactions));
        System.out.println("Transactions values of traders living in Delhi: " + transactionsValuesDelhi(transactions));
        System.out.println("Highest transaction value: " + highestTransaction(transactions));
        System.out.println("Smallest transaction value: " + smallestTransaction(transactions));
    }
}
