package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        final String BUY_ACTION = "buy";
        final String FILL_ACTION = "fill";
        final String TAKE_ACTION = "take";

        Scanner scanner = new Scanner(System.in);
        CoffeeMachineInventory coffeeMachineInventory = new CoffeeMachineInventory();

        coffeeMachineInventory.printInventory();
        System.out.println();

        String action = askAction(scanner);
        switch (action){
            case BUY_ACTION -> actionBuy(scanner, coffeeMachineInventory);
            case FILL_ACTION -> actionFill(scanner, coffeeMachineInventory);
            case TAKE_ACTION -> actionTake(coffeeMachineInventory);
        }
        System.out.println();

        coffeeMachineInventory.printInventory();

    }

    private static String askAction(Scanner scanner) {
        System.out.println("Write action (buy, fill, take):");
        return scanner.nextLine();
    }

    private static void actionBuy(Scanner scanner, CoffeeMachineInventory coffeeMachineInventory) {
        final int BUY_ESPRESSO = 1;
        final int BUY_LATTE = 2;
        final int BUY_CAPPUCCINO = 3;

        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
        int buyingItem = scanner.nextInt();

        switch (buyingItem) {
            case BUY_ESPRESSO -> coffeeMachineInventory.makeEspresso();
            case BUY_LATTE -> coffeeMachineInventory.makeLatte();
            case BUY_CAPPUCCINO -> coffeeMachineInventory.makeCappuccino();
        }
    }

    private static void actionFill(Scanner scanner, CoffeeMachineInventory coffeeMachineInventory) {
        System.out.println("Write how many ml of water you want to add:");
        int water = scanner.nextInt();

        System.out.println("Write how many ml of milk you want to add:");
        int milk = scanner.nextInt();

        System.out.println("Write how many grams of coffee beans you want to add:");
        int beans = scanner.nextInt();

        System.out.println("Write how many disposable cups you want to add:");
        int cups = scanner.nextInt();

        coffeeMachineInventory.fillStock(water, milk, beans, cups);

    }

    private static void actionTake(CoffeeMachineInventory coffeeMachineInventory) {
        System.out.printf("I gave you $%d", coffeeMachineInventory.takeMoney());
    }


}
