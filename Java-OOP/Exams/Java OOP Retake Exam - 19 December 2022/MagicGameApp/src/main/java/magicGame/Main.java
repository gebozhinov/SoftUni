package magicGame;

import magicGame.core.Engine;
import magicGame.core.EngineImpl;
import magicGame.models.magicians.Magician;
import magicGame.models.magicians.MagicianImpl;
import magicGame.models.magics.Magic;

public class Main {
    public static void main(String[] args) {
        Engine engine = new EngineImpl();
        engine.run();

    }
}
