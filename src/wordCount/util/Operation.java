package wordCount.util;

/**
 * @author shashiupadhyay
 *
 */
public enum Operation {

	READ_OPEARATION("READ"), 
	WRITE_OPERATION("WRITE");

	private String operationOnFile;

	/**
	 * @param operationIn
	 */
	private Operation(String operationIn) {
			operationOnFile = operationIn;
	    }

	public String getStatusCode() {
		return operationOnFile;
	}
	
}
