import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.ArrayList;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Gamer implements IObserver {
    private int id;
    ArrayList<GameInfo> wishlist;

    @Override
    public void update(Object o) {
        GameInfo game = (GameInfo)o;
        for (GameInfo wish: wishlist) {
            if (wish.name.equals(game.name)) {
                if (game.cost <= wish.cost) {
                    System.out.println("Client " + id + ": I'm about to buy the game " + game.name + " for " + game.cost + ".");
                } else {
                    System.out.println("Client " + id + ": I cannot afford game " + game.name + " even with discount.");
                }
                return;
            }
        }
        System.out.println("Client " + id + ": I'm not interested in this proposal.");
    }
}
