package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        int waterStock = askWaterStock(scanner);
        int milkStock = askMilkStock(scanner);
        int coffeeBeansStock = askCoffeeBeansStock(scanner);
        int numberCups = askCoffeeNeededInCup(scanner);

        int coffeeCanMake = coffeeInCupCanMake(waterStock, milkStock, coffeeBeansStock);

        if (numberCups == coffeeCanMake) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (numberCups > coffeeCanMake) {
            System.out.printf("No, I can make only %d cup(s) of coffee\n", coffeeCanMake);
        } else {
            System.out.printf("Yes, I can make that amount of coffee (and even %d more than that)\n", coffeeCanMake - numberCups);
        }

    }

    private static int askWaterStock(Scanner scanner) {
        System.out.println("Write how many ml of water the coffee machine has:");
        return scanner.nextInt();
    }

    private static int askMilkStock(Scanner scanner) {
        System.out.println("Write how many ml of milk the coffee machine has:");
        return scanner.nextInt();
    }

    private static int askCoffeeBeansStock(Scanner scanner) {
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        return scanner.nextInt();
    }

    private static int askCoffeeNeededInCup(Scanner scanner) {
        System.out.println("Write how many cups of coffee you will need:");
        return scanner.nextInt();
    }

    private static int coffeeInCupCanMake(int waterStock,int milkStock,int coffeeBeansStock) {
        final int waterNeed = 200;
        final int milkNeed = 50;
        final int coffeeBeansNeed = 15;

        return Math.min(Math.min(waterStock/waterNeed, milkStock/milkNeed),coffeeBeansStock/coffeeBeansNeed);
    }
}
