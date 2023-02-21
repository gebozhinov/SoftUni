package glacialExpedition.models.mission;

import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.states.State;

import java.util.Collection;

public class MissionImpl implements Mission {


    @Override
    public void explore(State state, Collection<Explorer> explorers) {
        for (Explorer explorer : explorers) {
            if (explorer.canSearch()) {
                if (!state.getExhibits().isEmpty()) {
                    explorer.search();
                    String currentExhibit = state.getExhibits().stream().findFirst().orElse("");
                    explorer.getSuitcase().getExhibits().add(currentExhibit);
                    state.getExhibits().remove(currentExhibit);
                }

            }
        }
    }
}
