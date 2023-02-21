package glacialExpedition.models.explorers;

public class NaturalExplorer extends BaseExplorer {

    private static final double INITIAL_ENERGY = 60;

    public NaturalExplorer(String name) {
        super(name, INITIAL_ENERGY);
    }

    @Override
    public void search() {
        try {
            super.setEnergy(super.getEnergy() - 7);
        } catch (IllegalArgumentException e) {
            super.setEnergy(0);
        }
    }
}
