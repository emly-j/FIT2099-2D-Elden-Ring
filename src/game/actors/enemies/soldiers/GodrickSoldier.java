package game.actors.enemies.soldiers;

import game.actors.AttackType;
import game.controllers.RuneManager;
import game.controllers.RuneSource;
import game.items.weapons.Club;
import game.items.weapons.Scimitar;
import game.utils.RandomNumberGenerator;

public class GodrickSoldier extends Soldier implements RuneSource {
    /**
     * Constructor that instantiates the base Enemy behaviours and being a resettable instance
     */
    public GodrickSoldier() {
        super("Godrick Solder", 'p', 198);
        addCapability(AttackType.CANNOT_ATTACK_DOGS);
        addCapability(AttackType.CANNOT_ATTACK_GODRICK_SOLDIERS);
        addWeaponToInventory(new Club());
        addRuneSource();
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
