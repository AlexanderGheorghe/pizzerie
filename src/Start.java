import pizzeria.services.PizzaService;

public class Start {

    public static void main(String[] args) {
        System.out.println("Welcome to Alex's pizzeria!");
        PizzaService pizzaService = new PizzaService();
        System.out.println(pizzaService.getRandomPizza());
    }

}
