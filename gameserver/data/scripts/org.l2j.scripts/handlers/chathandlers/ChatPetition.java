/*
 * Copyright © 2019-2020 L2JOrg
 *
 * This file is part of the L2JOrg project.
 *
 * L2JOrg is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * L2JOrg is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package handlers.chathandlers;

import org.l2j.gameserver.enums.ChatType;
import org.l2j.gameserver.handler.IChatHandler;
import org.l2j.gameserver.instancemanager.PetitionManager;
import org.l2j.gameserver.model.actor.instance.Player;
import org.l2j.gameserver.network.SystemMessageId;

/**
 * Petition chat handler.
 * @author durgus
 * @author JoeAlisson
 */
public final class ChatPetition implements IChatHandler {

	private static final ChatType[] CHAT_TYPES = {
		ChatType.PETITION_PLAYER,
		ChatType.PETITION_GM,
	};
	
	@Override
	public void handleChat(ChatType type, Player player, String target, String text) {
		if (!PetitionManager.getInstance().isPlayerInConsultation(player)) {
			player.sendPacket(SystemMessageId.YOU_ARE_CURRENTLY_NOT_IN_A_PETITION_CHAT);
			return;
		}
		PetitionManager.getInstance().sendActivePetitionMessage(player, text);
	}
	
	@Override
	public ChatType[] getChatTypeList()
	{
		return CHAT_TYPES;
	}
}