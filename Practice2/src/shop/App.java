package shop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class App {
    public static void main(String[] args) {
        GameShop gameShop = new GameShop();
        Random random = new Random();

        gameShop.addGameToCatalog(new BoardGame("Игра 1", 3, 4, 90, 10, 30f));
        gameShop.addGameToCatalog(new BoardGame("Игра 2", 2, 5, 35, 7, 25f));
        gameShop.addGameToCatalog(new BoardGame("Игра 3", 2, 5, 30, 8, 50f));
        gameShop.addGameToCatalog(new BoardGame("Игра 4", 2, 4, 45, 13, 40f));
        gameShop.addGameToCatalog(new BoardGame("Игра 5", 3, 7, 30, 10, 35f));
        gameShop.addGameToCatalog(new BoardGame("Игра 6", 3, 6, 30, 8, 30f));
        gameShop.addGameToCatalog(new BoardGame("Игра 7", 2, 4, 30, 10, 40f));
        gameShop.addGameToCatalog(new BoardGame("Игра 8", 2, 4, 30, 8, 30f));
        gameShop.addGameToCatalog(new BoardGame("Игра 9", 1, 5, 120, 12, 55f));
        gameShop.addGameToCatalog(new BoardGame("Игра 10", 4, 8, 15, 14, 20f));

        List<Customer> customers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            String randomGame = gameShop.getCatalog().get(random.nextInt(gameShop.getCatalog().size())).getName();
            float randomMoney = random.nextFloat() * 100;
            customers.add(new Customer(randomGame, randomMoney));
        }

        for (Customer customer : customers) {
            gameShop.buyGame(customer.getGameName(), customer.getMoney());
        }

        System.out.println("Общий заработок магазина: " + gameShop.getEarnings());
        System.out.println("Осталось игр в каталоге: " + gameShop.getCatalog().size());
    }
}