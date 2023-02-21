package magicGame.models.magics;

import static magicGame.common.ExceptionMessages.INVALID_MAGIC_BULLETS_COUNT;
import static magicGame.common.ExceptionMessages.INVALID_MAGIC_NAME;

public abstract class MagicImpl implements Magic{

    private String name;
    private int bulletsCount;


    protected MagicImpl(String name, int bulletsCount) {
        setName(name);
        setBulletsCount(bulletsCount);
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(INVALID_MAGIC_NAME);
        }
        this.name = name;
    }

    private void setBulletsCount(int bulletsCount) {
        if (bulletsCount < 0) {
            throw new IllegalArgumentException(INVALID_MAGIC_BULLETS_COUNT);
        }
        this.bulletsCount = bulletsCount;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getBulletsCount() {
        return this.bulletsCount;
    }

}
