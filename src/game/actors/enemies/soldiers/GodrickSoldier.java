package game.actors.enemies.soldiers;

import game.actors.AttackType;
import game.controllers.RuneManager;
import game.controllers.RuneSource;
import game.utils.RandomNumberGenerator;

public class GodrickSoldier extends Soldier implements RuneSource {
    /**
     * Constructor that instantiates the base Enemy behaviours and being a resettable instance
     */
    public GodrickSoldier() {
        super("Godrick Solder", 'B', 198);
        addCapability(AttackType.CANNOT_ATTACK_DOGS);
        addCapability(AttackType.CANNOT_ATTACK_GODRICK_SOLDIERS); // todo: check if godrick soliders can attack other godrick soliders
    }

    /**
     * Adds rune source to lists/maps in RuneManager
     *
     * @see RuneManager
     */
    @Override
    public void addRuneSource() {
        RuneManager runeManager = RuneManager.getInstance();
        runeManager.addRuneOwner(this, RandomNumberGenerator.getRandomInt(38, 70));
        runeManager.addRuneSource(this);
    }
}
