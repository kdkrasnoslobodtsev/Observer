import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.ArrayList;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class SteamMarket implements IObservable {
    private final ArrayList<GameInfo> games;
    private final ArrayList<IObserver> clients;

    public SteamMarket(ArrayList<GameInfo> games) {
        this.games = games;
        clients = new ArrayList<IObserver>();
    }

    public void Discount(String gameName, double percent) {
        for (GameInfo game : games) {
            if (game.name.equals(gameName)) {
                game.cost *= percent;
                System.out.println("Game " + game.name + " reduced its cost to " + game.cost);
                notifyObservers(game);
            }
        }
    }

    @Override
    public void addObserver(IObserver o) {
        clients.add(o);
    }

    @Override
    public void removeObserver(IObserver o) {
        clients.remove(o);
    }

    @Override
    public void notifyObservers(Object o) {
        for (IObserver observer: clients) {
            observer.update(o);
        }
    }
}
