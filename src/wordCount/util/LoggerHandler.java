package wordCount.util;

/**
 * @author shashiupadhyay
 *
 */
public class LoggerHandler {
	public static enum DebugLevel {
		CONSTRUCTOR, ERROR, NODE_POPULATED, COUNT_WORDS, NODE_MODIFIED, NODE_CLONED, NODE_VISITED, NO_OUTPUT, EXCEPTION, OUTPUT
	};

	private static DebugLevel debugLevel;

	/**
	 * @param levelIn
	 */
	public static void setDebugValue(DebugLevel levelIn) {
		if (levelIn != null) {
			debugLevel = levelIn;
		} else {
			return;
		}
	}

	/**
	 * @param message
	 * @param levelIn
	 */
	public static void writeMessage(String message, DebugLevel levelIn) {
		if (message != null && levelIn != null) {
			if (levelIn == debugLevel) {
				if (levelIn == DebugLevel.ERROR || levelIn == DebugLevel.EXCEPTION) {
					System.err.println("ERROR Message -> " + message);
				} else {
					System.out.println("Logger Message -> " + message);
				}
			} else {
				if (levelIn == DebugLevel.ERROR || levelIn == DebugLevel.EXCEPTION) {
					System.err.println("ERROR Message -> " + message);
				}
			}
		}
	}

	/*
	 * @return none
	 */
	public String toString() {
		return "Enabled Debug Level : " + debugLevel;
	}
}
