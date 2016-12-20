package wordCount.util;

import java.io.IOException;

public class Result {

	/**
	 * @param LineIn
	 */
	public static void insertLine(String LineIn, FileProcessor fileprocessor) {
		if(LineIn != null){
			try {
				fileprocessor.getBufferedWriter().write(LineIn);
				fileprocessor.getBufferedWriter().write("\n");
				fileprocessor.getBufferedWriter().flush();
			} catch (IOException e) {
				e.printStackTrace();
				System.exit(1);
			}catch (Exception e) {
				e.printStackTrace();
			}
			finally {
			}
		}
	}
	
}
