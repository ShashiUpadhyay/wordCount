package wordCount.util;

import java.io.File;
import java.io.IOException;

/**
 * @author shashiupadhyay
 *
 */
public class InputValidations {
	
	/**
	 * @param args
	 * @return
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static boolean validateInputArguments(String[] args) throws IOException, NumberFormatException {
		if (args.length < 3 || args.length > 3) {
			LoggerHandler.writeMessage("Few Input Arguments are missing !!", LoggerHandler.DebugLevel.ERROR);
			errorInformation();
			System.exit(0);
		} else {

			if (args[0] != null && args[0].contains(".txt")) {
				FileProcessor.setInputFile(args[0]);
				if (!new File(args[0]).canRead()) {
					LoggerHandler.writeMessage("Error while reading Input file !!", LoggerHandler.DebugLevel.ERROR);
					return false;
				}
			}else{
				LoggerHandler.writeMessage("Issue in Input File !!", LoggerHandler.DebugLevel.ERROR);
				errorInformation();
				System.exit(0);
			}

			if (args[1] != null && args[1].contains(".txt")) {
				FileProcessor.setOutputFile(args[1]);
				if (new File(args[1]).exists()) {
					new File(args[1]).delete();
				}
			}else{
				LoggerHandler.writeMessage("Issue in Output File !!", LoggerHandler.DebugLevel.ERROR);
				errorInformation();
				System.exit(0);
			}

			if (args[2] != null) {
				FileProcessor.setNUM_ITERATIONS(Integer.parseInt(args[2]));
			}else{
				LoggerHandler.writeMessage("Issue in Iteration value !!", LoggerHandler.DebugLevel.ERROR);
				errorInformation();
				System.exit(0);
			}

			return true;
		}

		return false;
	}

	/**
	 * 
	 */
	public static void errorInformation() {
		LoggerHandler.writeMessage("Arguments should be in the below mentioned format !!", LoggerHandler.DebugLevel.ERROR);
		LoggerHandler.writeMessage("ant -Darg0=<InputFile> -Darg1=<OutputFile> -Darg2=<NumberOfIterations> run",
				LoggerHandler.DebugLevel.ERROR);
	}

}
