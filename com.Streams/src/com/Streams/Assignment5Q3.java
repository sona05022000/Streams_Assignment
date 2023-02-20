package com.Streams;
import java.util.ArrayList;
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
    @Override
    public String toString() {
        return "Trader name='" + name + "', city='" + city ;
    }
}

public class Assignment5Q3 {

    public static List<String> printUniqueCities(List<Trader> traders) {
        return traders.stream()
                .map(Trader::getCity)
                .distinct()
                .collect(Collectors.toList());
    }

    public static List<String> tradersFromPuneSortByName(List<Trader> traders) {
        return traders.stream()
                .filter(trader -> trader.getCity().equals("Pune"))
                .map(Trader::getName)
                .sorted()
                .collect(Collectors.toList());
    }

    public static String allTrader3Names(List<Trader> traders) {
        return traders.stream()
                .map(Trader::getName)
                .sorted()
                .collect(Collectors.joining(", "));
    }
    
    public static ArrayList<Trader> areAnyTradersFromIndore(ArrayList<Trader> traders) {
    	        return traders.stream()
                .filter(trader -> trader.getCity().equals("Indore"))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public static void main(String[] args) {
        ArrayList<Trader> traders = new ArrayList<>();
        traders.add(new Trader("Alice", "Mumbai"));
        traders.add(new Trader("Bob", "Pune"));
        traders.add(new Trader("Charlie", "Delhi"));
        traders.add(new Trader("David", "Pune"));
        traders.add(new Trader("Eva", "Bangalore"));
        traders.add(new Trader("Frank", "Indore"));
        traders.add(new Trader("George", "Pune"));
        traders.add(new Trader("Hannah", "Mumbai"));
        traders.add(new Trader("Harry", "Mumbai"));

        System.out.println("Unique cities where traders work: " + printUniqueCities(traders));
        System.out.println("Traders from Pune sorted by name: " + tradersFromPuneSortByName(traders));
        System.out.println("All traders' names sorted alphabetically: " + allTrader3Names(traders));
        System.out.println("Traders based in Indore: " + areAnyTradersFromIndore(traders));
    }
}
