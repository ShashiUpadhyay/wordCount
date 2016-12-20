package wordCount.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import wordCount.util.LoggerHandler.DebugLevel;

/**
 * @author shashiupadhyay
 *
 */
public class FileProcessor {

	private static String inputFileName;
	private static String outputFileName;
	private static File inputFileRef;
	private static File outputFileRef;
	private static int NUM_ITERATIONS;

	private Operation operation;
	private BufferedReader bufferedReader;
	private BufferedWriter bufferedWriter;
	
	/**
	 * @param filenameIn
	 * @param operationIn
	 */
	public FileProcessor(String filenameIn, Operation operationIn) {
		LoggerHandler.writeMessage("Constructor : " + this.getClass().getSimpleName(), DebugLevel.CONSTRUCTOR);
		try {
			if (filenameIn != null && operationIn != null) {
				if (validateFileOperation(filenameIn, operationIn)) {
					if (operationIn == Operation.READ_OPEARATION) {
						bufferedReader = new BufferedReader(new FileReader(getInputFile()));
					}
			
					if (operationIn == Operation.WRITE_OPERATION) {
						bufferedWriter = new BufferedWriter(new FileWriter(getOutputFile()));
					}
				}else{
					System.out.println("Else operationIn --> " + operationIn);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		} finally {
		}
	}

	/**
	 * @param filenameIn
	 * @param operationIn
	 * @return
	 * @throws IOException
	 */
	public boolean validateFileOperation(String filenameIn, Operation operationIn) throws IOException {
		if (filenameIn != null && operationIn != null) {
//			setInputFile(filenameIn);
			if (operationIn == Operation.READ_OPEARATION) {
				inputFileRef = new File(getInputFile());
				if (inputFileRef.exists() && inputFileRef.canRead()) {
					return true;
				}
			}

			if (operationIn == Operation.WRITE_OPERATION) {
//				setOutputFile(filenameIn);
				outputFileRef = new File(getInputFile());
				if (outputFileRef.canWrite()) {
					return true;
				}
			}
		}
		return false;
	}

	public String fetchNextLine() {
		String line = null;
		try {
			line = bufferedReader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		} finally {
		}
		return line;
	}
	
//	
//	/**
//	 * @param LineIn
//	 */
//	public void insertLine(String LineIn) {
//		if(LineIn != null){
//			try {
//				bufferedWriter.write(LineIn);
//				bufferedWriter.write("\n");
//				bufferedWriter.flush();
//			} catch (IOException e) {
//				e.printStackTrace();
//				System.exit(1);
//			}catch (Exception e) {
//				e.printStackTrace();
//			}
//			finally {
//			}
//		}
//	}
	
	/**
	 * @return the bufferedReader
	 */
	public BufferedReader getBufferedReader() {
		return bufferedReader;
	}

	/**
	 * @param bufferedReader the bufferedReader to set
	 */
	public void setBufferedReader(BufferedReader bufferedReader) {
		this.bufferedReader = bufferedReader;
	}

	/**
	 * @return the bufferedWriter
	 */
	public BufferedWriter getBufferedWriter() {
		return bufferedWriter;
	}

	/**
	 * @param bufferedWriter the bufferedWriter to set
	 */
	public void setBufferedWriter(BufferedWriter bufferedWriter) {
		this.bufferedWriter = bufferedWriter;
	}

	public static String getInputFile() {
		return inputFileName;
	}

	/**
	 * @param inputFile
	 */
	public static void setInputFile(String inputFile) {
		FileProcessor.inputFileName = inputFile;
	}

	public static String getOutputFile() {
		return outputFileName;
	}

	/**
	 * @param outputFile
	 */
	public static void setOutputFile(String outputFile) {
		FileProcessor.outputFileName = outputFile;
	}

	/**
	 * @return the nUM_ITERATIONS
	 */
	public static int getNUM_ITERATIONS() {
		return NUM_ITERATIONS;
	}

	/**
	 * @param nUM_ITERATIONS the nUM_ITERATIONS to set
	 */
	public static void setNUM_ITERATIONS(int nUM_ITERATIONS) {
		NUM_ITERATIONS = nUM_ITERATIONS;
	}

	/**
	 * @return the inputFileRef
	 */
	public static File getInputFileRef() {
		return inputFileRef;
	}

	/**
	 * @param inputFileRef the inputFileRef to set
	 */
	public static void setInputFileRef(File inputFileRef) {
		FileProcessor.inputFileRef = inputFileRef;
	}

	/**
	 * @return the outputFileRef
	 */
	public static File getOutputFileRef() {
		return outputFileRef;
	}

	/**
	 * @param outputFileRef the outputFileRef to set
	 */
	public static void setOutputFileRef(File outputFileRef) {
		FileProcessor.outputFileRef = outputFileRef;
	}

	public void closeFilesOnExit() throws IOException {
		if(bufferedReader != null){
			bufferedReader.close();
		}
		if(bufferedWriter != null){
			bufferedWriter.close();
		}		
	}

	public Operation getOperation() {
		return operation;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		if(operation == Operation.READ_OPEARATION){
			sb.append(" InputFileName\t:\t" + inputFileName + "\t|\tOperation\t:\t" + operation );
		}else if (operation == Operation.WRITE_OPERATION){
			sb.append(" OutputFileName\t:\t" + outputFileName + "\t|\tOperation\t:\t" + operation );
		}
		return sb.toString();
	}
}
