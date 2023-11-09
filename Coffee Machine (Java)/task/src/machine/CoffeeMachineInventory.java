package machine;

class CoffeeMachineInventory {
    int water;
    int milk;
    int beans;
    int cups;
    int money;

    CoffeeMachineInventory() {
        this.water = 400;
        this.milk = 540;
        this.beans = 120;
        this.cups = 9;
        this.money = 550;
    }

    void printInventory() {
        System.out.println("The coffee machine has:");
        System.out.printf("%d ml of water\n", this.water);
        System.out.printf("%d ml of milk\n", this.milk);
        System.out.printf("%d g of coffee beans\n", this.beans);
        System.out.printf("%d disposable cups\n", this.cups);
        System.out.printf("$%d of money\n", this.money);
    }

    int takeMoney() {
        int moneyTaken = this.money;
        this.money = 0;

        return moneyTaken;
    }

    void makeEspresso() {
        this.makeCoffee(250,0,16,4);
    }

    void makeLatte() {
        this.makeCoffee(350,75,20,7);
    }

    void makeCappuccino() {
        this.makeCoffee(200,100,12,6);
    }

    void fillStock(int water, int milk, int beans, int cups) {
        this.water = this.water + water;
        this.milk = this.milk + milk;
        this.beans = this.beans + beans;
        this.cups = this.cups + cups;

    }

    private void makeCoffee(int waterNeeded, int milkNeeded, int beansNeeded, int price) {
        this.water = this.water - waterNeeded;
        this.milk = this.milk - milkNeeded;
        this.beans = this.beans - beansNeeded;
        this.cups--;
        this.money = this.money + price;

    }

}
