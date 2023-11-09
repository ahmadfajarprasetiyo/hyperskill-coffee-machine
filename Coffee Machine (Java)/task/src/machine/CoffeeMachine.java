package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        final String BUY_ACTION = "buy";
        final String FILL_ACTION = "fill";
        final String TAKE_ACTION = "take";
        final String REMAINING_ACTION = "remaining";
        final String EXIT_ACTION = "exit";

        Scanner scanner = new Scanner(System.in);
        CoffeeMachineInventory coffeeMachineInventory = new CoffeeMachineInventory();

        String action;
        do {
            action = askAction(scanner);
            System.out.println();

            switch (action){
                case BUY_ACTION -> actionBuy(scanner, coffeeMachineInventory);
                case FILL_ACTION -> actionFill(scanner, coffeeMachineInventory);
                case TAKE_ACTION -> actionTake(coffeeMachineInventory);
                case REMAINING_ACTION -> actionRemaining(coffeeMachineInventory);
            }
            System.out.println();

        }while (!action.equals(EXIT_ACTION));

    }

    private static String askAction(Scanner scanner) {
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        return scanner.nextLine();
    }

    private static void actionBuy(Scanner scanner, CoffeeMachineInventory coffeeMachineInventory) {
        final int BUY_ESPRESSO = 1;
        final int BUY_LATTE = 2;
        final int BUY_CAPPUCCINO = 3;
        final String BACK_ACTION = "back";

        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
        String buyAction = scanner.nextLine();

        if (buyAction.equals(BACK_ACTION)) {
            return;
        }
        int buyingItem = Integer.parseInt(buyAction);

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

    private static void actionRemaining(CoffeeMachineInventory coffeeMachineInventory) {
        coffeeMachineInventory.printInventory();
    }

    private static void actionTake(CoffeeMachineInventory coffeeMachineInventory) {
        System.out.printf("I gave you $%d", coffeeMachineInventory.takeMoney());
    }


}
