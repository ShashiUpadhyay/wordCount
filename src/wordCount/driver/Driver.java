package wordCount.driver;

import wordCount.dao.BST;
import wordCount.dao.TreeInterface;
import wordCount.util.FileProcessor;
import wordCount.util.InputValidations;
import wordCount.util.LoggerHandler;
import wordCount.util.LoggerHandler.DebugLevel;
import wordCount.util.Operation;
import wordCount.util.PerformanceValidation;
import wordCount.visitors.CloneAndObserverVisitor;
import wordCount.visitors.PopulateVisitor;
import wordCount.visitors.Visitor;
import wordCount.visitors.WordCountVisitor;

public class Driver {

	public static void main(String[] args) {
		LoggerHandler.setDebugValue(DebugLevel.OUTPUT);
		try {
			if (InputValidations.validateInputArguments(args)) {
				FileProcessor read_processing, write_processing;
				TreeInterface treeInterface;
				String inputFile = FileProcessor.getInputFile();
				String outputFile = FileProcessor.getOutputFile();
				int NUM_ITERATIONS = FileProcessor.getNUM_ITERATIONS();

				long startTime = System.currentTimeMillis();
				int iteration = 0;
				while (iteration < NUM_ITERATIONS) {
					read_processing = new FileProcessor(inputFile, Operation.READ_OPEARATION);
					treeInterface = new BST();
					new PopulateVisitor(read_processing).visit(treeInterface);
					write_processing = new FileProcessor(outputFile, Operation.WRITE_OPERATION);
					new WordCountVisitor(write_processing).visit(treeInterface);
					read_processing.closeFilesOnExit();
					write_processing.closeFilesOnExit();
					iteration++;
				}

				long finishTime = System.currentTimeMillis();
				long total_time = (finishTime - startTime) / NUM_ITERATIONS;
				LoggerHandler.writeMessage("Total Execution Time\t:\t" + total_time + " milliseconds",
						LoggerHandler.DebugLevel.OUTPUT);

//				Verifying cloning
				TreeInterface cloneverificationInterface, backupTree;
				Visitor  clone_and_observer_visitor;
				FileProcessor read_processing_clone_verification; 
				
//				THis is for the verification of cloning
				FileProcessor.setInputFile("input_clone_verification.txt");
				read_processing_clone_verification = new FileProcessor(inputFile, Operation.READ_OPEARATION);
				cloneverificationInterface = new BST();
				new PopulateVisitor(read_processing_clone_verification).visit(cloneverificationInterface);
				clone_and_observer_visitor = new CloneAndObserverVisitor();
				clone_and_observer_visitor.visit(cloneverificationInterface);
				backupTree = ((CloneAndObserverVisitor) clone_and_observer_visitor).getBackupTree();
				PerformanceValidation.veryfyingWorkingOfObserverPattern(cloneverificationInterface, backupTree);
				read_processing_clone_verification.closeFilesOnExit();
			} else {
				LoggerHandler.writeMessage("Few Input Arguments are missing !!", LoggerHandler.DebugLevel.ERROR);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		} finally {

		}
	}

}
