package me.F_o_F_1092.WeatherVote.VotingGUI;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class VotingGUIListener {

	static List<VotingGUIPlayer> votingGuiPlayers = new ArrayList<>();

	public static void addVotingGUIPlayer(UUID uuid, String worldName) {
		VotingGUIPlayer votingGUIPlayer = new VotingGUIPlayer(uuid, worldName);
		votingGUIPlayer.openVoteingGUI();
		votingGuiPlayers.add(votingGUIPlayer);
	}
	
	public static void removeVotingGUIPlayer(UUID uuid) {
		votingGuiPlayers.remove(getVotingGUIPlayer(uuid));
	}
	
	static VotingGUIPlayer getVotingGUIPlayer(UUID uuid) {
		for (VotingGUIPlayer votingGUIPlayer : votingGuiPlayers) {
			if (votingGUIPlayer.getUUID().equals(uuid)) {
				return votingGUIPlayer;
			}
		}
		
		return null;
	}
	
	static List<VotingGUIPlayer> getVotingGUIPlayers(String worldName) {
		List<VotingGUIPlayer> votingGuiPlayersAtWorld = new ArrayList<>();
		
		for (VotingGUIPlayer votingGUIPlayer : votingGuiPlayers) {
			if (votingGUIPlayer.getWorldName().equals(worldName)) {
				votingGuiPlayersAtWorld.add(votingGUIPlayer);
			}
		}
		
		return votingGuiPlayersAtWorld;
	}
	
	public static boolean isVotingGUIPlayer(UUID uuid) {
		return getVotingGUIPlayer(uuid) != null;
	}
	

	public static void closeVotingGUIsAtWorld(String worldName) {
		for (VotingGUIPlayer votingGUIPlayer : getVotingGUIPlayers(worldName)) {
			votingGUIPlayer.closeInventory();
		}
	}
}
