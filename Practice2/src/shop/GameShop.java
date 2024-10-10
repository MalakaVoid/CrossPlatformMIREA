package shop;
import java.util.*;

public class GameShop {
    private Map<String, BoardGame> gamesCatalog;
    private float earnings;

    public GameShop() {
        this.gamesCatalog = new HashMap<>();
        this.earnings = 0;
    }

    public void addGameToCatalog(BoardGame game) {
        gamesCatalog.putIfAbsent(game.getName(), game);
    }

    public float getEarnings() {
        return earnings;
    }

    public List<BoardGame> getCatalog() {
        return new ArrayList<>(gamesCatalog.values());
    }

    public void buyGame(String gameName, float moneyInWallet) {
        BoardGame game = gamesCatalog.get(gameName);
        if (game != null) {
            if (moneyInWallet >= game.getPrice()) {
                earnings += game.getPrice();
                gamesCatalog.remove(gameName);
                System.out.println("Продано: " + game.getName() + " за " + game.getPrice());
            } else {
                System.out.println("У покупателя недостаточно средств на счету для покупки " + game.getName());
            }
        } else {
            System.out.println("Игра " + gameName + " не найдена в каталоге.");
        }
    }
}