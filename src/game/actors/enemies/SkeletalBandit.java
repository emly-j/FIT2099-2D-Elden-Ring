package game.actors.enemies;

import game.RandomNumberGenerator;
import game.RuneManager;
import game.RuneSource;
import game.items.weapons.Scimitar;

public class SkeletalBandit extends Skeleton implements RuneSource {
    /**
     * Constructor.
     *
     */
    public SkeletalBandit() {
        super("Skeletal Bandit", 'b', 184);
        addWeaponToInventory(new Scimitar());
        RuneManager.getInstance().addRuneOwner(this, RandomNumberGenerator.getRandomInt(35,892));
        System.out.println("I AM SKELETON BANDIT" + RuneManager.getInstance().getRunes(this));
    }


    @Override
    public void addRuneSource() {

    }
}
