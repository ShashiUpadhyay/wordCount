package wordCount.util;

import java.io.IOException;

import wordCount.dao.Node;
import wordCount.dao.TreeInterface;
import wordCount.dao.Word;

/**
 * @author shashiupadhyay
 *
 */
public class PerformanceValidation {
	
	/**
	 * @param originalTree
	 * @param backupTree
	 * @throws IOException 
	 */
	public static void veryfyingWorkingOfObserverPattern(TreeInterface originalTree, TreeInterface backupTree) throws IOException {
//		Trying to update Root node value and then trying to verify its status in backup tree
		Node originalCopy_Rootnode = originalTree.getRootNode();
		Word priorupdate_word = originalCopy_Rootnode.getNode_contents();
		
		FileProcessor.setOutputFile("output_clone_verification_original_tree_before_update.txt");
		FileProcessor write_processing_clone_verification_priorupdate = new FileProcessor(FileProcessor.getOutputFile(), Operation.WRITE_OPERATION);
		Result.insertLine("\n\nPrinting Original Tree Before Update", write_processing_clone_verification_priorupdate);
		printInOrderTree(originalTree,write_processing_clone_verification_priorupdate);
		write_processing_clone_verification_priorupdate.closeFilesOnExit();
	
		Word postupdate_word = new Word(priorupdate_word.getWord(), 1000);
		originalCopy_Rootnode.setNode_contents(postupdate_word);

//		Trying to update Left child node of root node and then trying to verify its status in backup tree		
		Node originalCopy_Rootnode_LeftNode = originalTree.getRootNode().getLeftChild();
		Word lchild_priorupdate = originalCopy_Rootnode_LeftNode.getNode_contents();
		Word lchild_postupdate = new Word(lchild_priorupdate.getWord(), 4000);
		originalCopy_Rootnode_LeftNode.setNode_contents(lchild_postupdate);
		
		FileProcessor.setOutputFile("output_clone_verification_original_post_update.txt");
		FileProcessor write_processing_clone_verification = writingOutputToFile(originalTree, priorupdate_word,
				postupdate_word, lchild_priorupdate, lchild_postupdate);
		write_processing_clone_verification.closeFilesOnExit();
		
		FileProcessor.setOutputFile("output_clone_verification_backup.txt");
		FileProcessor write_processing_clone_verification_backup = writingBackupToFile(backupTree, priorupdate_word,
				postupdate_word, lchild_priorupdate, lchild_postupdate);
		write_processing_clone_verification_backup.closeFilesOnExit();
		
	}

	/**
	 * @param backupTree
	 * @param priorupdate_word
	 * @param postupdate_word
	 * @param lchild_priorupdate
	 * @param lchild_postupdate
	 * @return
	 */
	public static FileProcessor writingBackupToFile(TreeInterface backupTree, Word priorupdate_word,
			Word postupdate_word, Word lchild_priorupdate, Word lchild_postupdate) {
		FileProcessor write_processing_clone_verification_backup = new FileProcessor(FileProcessor.getOutputFile(), Operation.WRITE_OPERATION);
		Result.insertLine("\n Root Node -> Prior Update "+ priorupdate_word,write_processing_clone_verification_backup);
		Result.insertLine("\n Root Node -> Post Update "+ postupdate_word, write_processing_clone_verification_backup);
		Result.insertLine("\n Root Node -> Left Child : Prior update "+ lchild_priorupdate, write_processing_clone_verification_backup);
		Result.insertLine("\n Root Node -> Left Child : Post update "+ lchild_postupdate, write_processing_clone_verification_backup);
		Result.insertLine("\nLeft Child post update "+ lchild_postupdate, write_processing_clone_verification_backup);
		Result.insertLine("\n\nPrinting Cloned Copy", write_processing_clone_verification_backup);
		printInOrderTree(backupTree,write_processing_clone_verification_backup);
		return write_processing_clone_verification_backup;
	}

	/**
	 * @param originalTree
	 * @param priorupdate_word
	 * @param postupdate_word
	 * @param lchild_priorupdate
	 * @param lchild_postupdate
	 * @return
	 */
	public static FileProcessor writingOutputToFile(TreeInterface originalTree, Word priorupdate_word,
			Word postupdate_word, Word lchild_priorupdate, Word lchild_postupdate) {
		FileProcessor write_processing_clone_verification = new FileProcessor(FileProcessor.getOutputFile(), Operation.WRITE_OPERATION);
		Result.insertLine("\n Root Node -> Prior Update "+ priorupdate_word, write_processing_clone_verification);
		Result.insertLine("\n Root Node -> Post Update "+ postupdate_word, write_processing_clone_verification);
		Result.insertLine("\n Root Node -> Left Child : Prior update "+ lchild_priorupdate, write_processing_clone_verification);
		Result.insertLine("\n Root Node -> Left Child : Post update "+ lchild_postupdate, write_processing_clone_verification);
		Result.insertLine("\nLeft Child post update "+ lchild_postupdate, write_processing_clone_verification);
		Result.insertLine("\n\nPrinting Original Copy", write_processing_clone_verification);
		printInOrderTree(originalTree, write_processing_clone_verification);
		return write_processing_clone_verification;
	}
	
	/**
	 * @param tree
	 */
	public static void printInOrderTree(TreeInterface tree, FileProcessor write){
		if(tree.getRootNode() != null){
			printInOrder(tree.getRootNode(), write);
		}
	}
	
	/**
	 * @param node
	 */
	private static void printInOrder(Node node,FileProcessor write){
		if(node != null){
			printInOrder(node.getLeftChild(), write);
			Result.insertLine(node.getNode_contents().toString(), write);
			printInOrder(node.getRightChild(), write);
		}
	}
	
	/**
	 * @param tree
	 */
	public static void printPostOrderTree(TreeInterface tree){
		System.out.println("Printing the contents of Tree in Postorder format");
		if(tree.getRootNode() != null){
			printPostOrder(tree.getRootNode());
		}
	}
	
	/**
	 * @param node
	 */
	private static void printPostOrder(Node node){
		if(node != null){
			printPostOrder(node.getLeftChild());
			printPostOrder(node.getRightChild());
			System.out.println(node.getNode_contents());
		}
	}
	
	/**
	 * @param tree
	 */
	public static void printPreOrderTree(TreeInterface tree){
		System.out.println("Printing the contents of Tree in Preorder format");
		if(tree.getRootNode() != null){
			printPreOrder(tree.getRootNode());
		}
	}
	
	/**
	 * @param node
	 */
	private static void printPreOrder(Node node){
		if(node != null){
			printPreOrder(node.getLeftChild());
			printPreOrder(node.getRightChild());
			System.out.println(node.getNode_contents());
		}
	}
	
}


