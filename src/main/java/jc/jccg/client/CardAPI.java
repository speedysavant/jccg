package jc.jccg.client;

public class CardAPI {
	public static String registerNewPlayer() {
		return "registerNewPlayer";
	}
	public static String joinGameAs(String player) {
		return "joinGameAs";
	}
	public static String getHand(String player) {
		return "getHand";
	}
	public static String getHome(String player) {
		return "getHome";
	}
	public static String getFleets(String player) {
		return "getFleets";
	}
	public static String drawOneCard(String player) {
		return "drawOneCard";
	}
}
