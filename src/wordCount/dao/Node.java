package wordCount.dao;

import java.util.ArrayList;
import java.util.List;


/**
 * @author shashiupadhyay
 *
 */
public class Node implements Subject, Observer, Cloneable {

	private TreeInterface treeInterface;
	private Node left_child_node;
	private Node right_child_node;
	private Word node_contents;
//	Subject will maintain list of observers who are going to.
	private List<Observer> list_of_observers;

	/**
	 * @param wordContentsIn
	 */
	public Node(Word wordContentsIn) {
		node_contents = wordContentsIn;
		list_of_observers = new ArrayList<>();
	}

	/**
	 * @param wordContentsIn
	 * @param treeIn
	 */
	public Node(Word wordContentsIn, TreeInterface treeIn) {
		this(wordContentsIn);
		treeInterface = treeIn;
	}
	
//	Subjects Method: Here Node is serving as Subject as well as listener
/*	Subject Section   - START */
	@Override
	public void registerObserver(Node observer) {
		list_of_observers.add(observer);
	}

	@Override
	public void removeObserver(Node observer) {
		list_of_observers.remove(observer);
	}

	@Override
	public void notifyObserver() {
		for (Observer observer : list_of_observers) {
			observer.update(this.getNode_contents());
		}
	}
/*	Subject Section   - END */	
	
//	Observer method: Here Node is serving as Subject as well as listener
/*	Observer Section   - START */	
	/* (non-Javadoc)
	 * @see wordCount.dao.Observer#update(wordCount.dao.Word)
	 */
	@Override
	public void update(Word updatedData) {
		this.setNode_contents(updatedData);
		int compare = updatedData.compareTo(this.node_contents);
		if(compare > 0 || compare < 0) {
			this.treeInterface.removeNodeFromTree(this);
			this.treeInterface.insertNodeInTree(this);
		}	
	}
/*	Observer Section   - END */	
	
/* Cloneable Section - START*/	
	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	public Object clone() throws CloneNotSupportedException {
		Node cloned_node = (Node) super.clone();
		cloned_node.node_contents = ((Word) this.node_contents.clone());
		cloned_node.list_of_observers = new ArrayList<>();
		return cloned_node;
	}
	/* Cloneable Section - END*/	
	
	
	public Node getLeftChild() {
		return left_child_node;
	}
	
	/**
	 * @param leftChildIn
	 */
	public void setLeftChild(Node leftChildIn) {
		left_child_node = leftChildIn;
	}
	
	public Node getRightChild() {
		return right_child_node;
	}
	
	/**
	 * @param rightChildIn
	 */
	public void setRightChild(Node rightChildIn) {
		right_child_node = rightChildIn;
	}

	public Word getNode_contents() {
		return node_contents;
	}

	/**
	 * @param wordIn
	 */
	public void setNode_contents(Word wordIn) {
		this.node_contents = wordIn;
		notifyObserver();
	}
	
	public TreeInterface getTree() {
		return treeInterface;
	}

	/**
	 * @param treeInterface
	 */
	public void setTree(TreeInterface treeInterface) {
		this.treeInterface = treeInterface;
	}
	
	@Override
	public String toString() {
		return "Node: "+ node_contents.toString();
	}
}
