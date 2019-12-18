package handlers.effecthandlers;

import org.l2j.gameserver.enums.CastleSide;
import org.l2j.gameserver.instancemanager.CastleManager;
import org.l2j.gameserver.model.StatsSet;
import org.l2j.gameserver.model.actor.Creature;
import org.l2j.gameserver.model.effects.AbstractEffect;
import org.l2j.gameserver.model.entity.Castle;
import org.l2j.gameserver.model.items.instance.Item;
import org.l2j.gameserver.model.skills.Skill;

import static org.l2j.gameserver.util.GameUtils.isPlayer;

/**
 * Take Castle effect implementation.
 * @author Adry_85, St3eT
 */
public final class TakeCastle extends AbstractEffect {
	private final CastleSide side;
	
	public TakeCastle(StatsSet params)
	{
		side = params.getEnum("side", CastleSide.class);
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
		
		final Castle castle = CastleManager.getInstance().getCastle(effector);
		castle.engrave(effector.getClan(), effected, side);
	}
}
