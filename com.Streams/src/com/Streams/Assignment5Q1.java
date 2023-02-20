package com.Streams;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Fruit {
    private String name;
    private int calories;
    private int price;
    private String color;

    public Fruit(String name, int calories, int price, String color) {
        this.name = name;
        this.calories = calories;
        this.price = price;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public int getCalories() {
        return calories;
    }

    public int getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }
}

public class Assignment5Q1 {

    public static List<String> reverseSort(ArrayList<Fruit> fruits) {
        return fruits.stream()
                .filter(fruit -> fruit.getCalories() < 100)
                .sorted(Comparator.comparingInt(Fruit::getCalories).reversed())
                .map(Fruit::getName)
                .collect(Collectors.toList());
    }

    public static ArrayList<Fruit> sort(ArrayList<Fruit> fruits) {
        return fruits.stream()
                .sorted(Comparator.comparing(Fruit::getColor))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public static ArrayList<Fruit> filterRedSortPrice(ArrayList<Fruit> fruits) {
        return fruits.stream()
                .filter(fruit -> "RED".equals(fruit.getColor()))
                .sorted(Comparator.comparingInt(Fruit::getPrice))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public static void main(String[] args) {
        ArrayList<Fruit> fruits = new ArrayList<>();
        fruits.add(new Fruit("Apple", 90, 20, "RED"));
        fruits.add(new Fruit("Banana", 120, 10, "YELLOW"));
        fruits.add(new Fruit("Orange", 60, 25, "ORANGE"));
        fruits.add(new Fruit("Strawberry", 80, 30, "RED"));
        fruits.add(new Fruit("Kiwi", 70, 15, "GREEN"));

        // Display the fruit names of low calories fruits i.e. calories < 100 sorted in descending order of calories.
        List<String> lowCalorieFruits = reverseSort(fruits);
        System.out.println("Low calorie fruits (calories < 100) sorted in descending order of calories: " + lowCalorieFruits);

        // Display color wise list of fruit names.
        ArrayList<Fruit> fruitsByColor = sort(fruits);
        System.out.println("Fruits sorted by color: ");
        for (Fruit fruit : fruitsByColor) {
            System.out.println(fruit.getColor() + ": " + fruit.getName());
        }

        // Display only RED color fruits sorted as per their price in ascending order.
        ArrayList<Fruit> redFruitsSortedByPrice = filterRedSortPrice(fruits);
        System.out.println("Red fruits sorted by price in ascending order: " + redFruitsSortedByPrice.stream().map(Fruit::getName).collect(Collectors.toList()));
    }
}
