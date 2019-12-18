package handlers.effecthandlers;

import org.l2j.gameserver.RecipeController;
import org.l2j.gameserver.enums.PrivateStoreType;
import org.l2j.gameserver.model.StatsSet;
import org.l2j.gameserver.model.actor.Creature;
import org.l2j.gameserver.model.actor.instance.Player;
import org.l2j.gameserver.model.effects.AbstractEffect;
import org.l2j.gameserver.model.items.instance.Item;
import org.l2j.gameserver.model.skills.Skill;
import org.l2j.gameserver.network.SystemMessageId;

import static org.l2j.gameserver.util.GameUtils.isPlayer;

/**
 * Open Common Recipe Book effect implementation.
 * @author Adry_85
 */
public final class OpenCommonRecipeBook extends AbstractEffect {
	public OpenCommonRecipeBook(StatsSet params) {
	}
	
	@Override
	public boolean isInstant()
	{
		return true;
	}
	
	@Override
	public void instant(Creature effector, Creature effected, Skill skill, Item item) {
		if (!isPlayer(effector)) {
			return;
		}
		
		final Player player = effector.getActingPlayer();
		if (player.getPrivateStoreType() != PrivateStoreType.NONE) {
			player.sendPacket(SystemMessageId.ITEM_CREATION_IS_NOT_POSSIBLE_WHILE_ENGAGED_IN_A_TRADE);
			return;
		}
		
		RecipeController.getInstance().requestBookOpen(player, false);
	}
}
