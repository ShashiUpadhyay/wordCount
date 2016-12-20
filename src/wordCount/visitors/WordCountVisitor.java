package wordCount.visitors;

import java.util.Stack;

import wordCount.dao.Node;
import wordCount.dao.TreeInterface;
import wordCount.util.FileProcessor;
import wordCount.util.Result;


/**
 * @author shashiupadhyay
 *
 */
public class WordCountVisitor implements Visitor {

	private FileProcessor writeProcessor;
	private int wordcount, charactercount, distinctwordcount;

	/**
	 * @param fileProcessor_in
	 */
	public WordCountVisitor(FileProcessor fileProcessor_in) {
		writeProcessor = fileProcessor_in;
	}

	/**
	 * @param treeInterface
	 */
	private void fetchContentsOfTree(TreeInterface treeInterface) {
		Stack<Node> stack = new Stack<Node>();
		stack.push(treeInterface.getRootNode());
		Node left_child;
		Node right_child;
		Node current_node;
		while (!stack.isEmpty()) {
			current_node = (Node) stack.pop();
			left_child = current_node.getLeftChild();
			if (left_child != null){
				stack.push(left_child);
			}
			
			right_child = current_node.getRightChild();
			if (right_child != null){
				stack.push(right_child);
			}
			
			charactercount += current_node.getNode_contents().getNumberOfCharacters();			
			wordcount += current_node.getNode_contents().getWordCount();
			distinctwordcount++;
		}

	}
	
	/* (non-Javadoc)
	 * @see wordCount.visitors.Visitor#visit(wordCount.dao.TreeInterface)
	 */
	@Override
	public void visit(TreeInterface treeInterface) {
		try {
			
			this.fetchContentsOfTree(treeInterface);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		} finally {

		}
		
		try {
			this.redirectOutputToFile();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		} finally {

		}
	}
	
	private void redirectOutputToFile(){
		if(this.writeProcessor != null){
			Result.insertLine("Total words\t\t:\t" + wordcount, this.writeProcessor);
			Result.insertLine("Distinct Words\t:\t" + distinctwordcount, this.writeProcessor);
			Result.insertLine("Characters\t\t:\t" + charactercount, this.writeProcessor);
		}
	}

}
