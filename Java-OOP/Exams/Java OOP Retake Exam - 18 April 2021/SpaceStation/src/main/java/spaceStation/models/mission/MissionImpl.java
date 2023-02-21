package spaceStation.models.mission;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.planets.Planet;

import java.util.Collection;

public class MissionImpl implements Mission {


    @Override
    public void explore(Planet planet, Collection<Astronaut> astronauts) {
        for (Astronaut astronaut : astronauts) {
            while (astronaut.canBreath()) {
                String item = planet.getItems().stream().findFirst().orElse(null);
                if (item == null) {
                    break;
                }
                astronaut.breath();
                astronaut.getBag().getItems().add(item);
                planet.getItems().remove(item);
            }
        }
    }
}
