package wordCount.dao;

import wordCount.util.LoggerHandler;
import wordCount.util.LoggerHandler.DebugLevel;
import wordCount.visitors.Visitor;

/**
 * @author shashiupadhyay
 *
 */
public class BST implements TreeInterface, Cloneable{

	private Node rootNode;

	public BST() {
		LoggerHandler.writeMessage("\tConstructor : " + this.getClass().getSimpleName(), DebugLevel.CONSTRUCTOR);
	}

	/* (non-Javadoc)
	 * @see wordCount.dao.d#insertContentInNode(wordCount.dao.Word)
	 */
	@Override
	public void insertContentInNode(Word word) {
		LoggerHandler.writeMessage("Content is inserted in Node\t:\t" + word, DebugLevel.NODE_POPULATED);
		rootNode = traverseTreeToInsertNode(rootNode, word);
	}

	/**
	 * @param parent
	 * @param itemToInsert
	 * @return
	 */
	private Node traverseTreeToInsertNode(Node parent, Word itemToInsert) {
		if (parent == null)
			return new Node(itemToInsert, this);
		int compare = parent.getNode_contents().compareTo(itemToInsert);
		if (compare == 0) {
			return parent;
		} else if (compare > 0) {
			parent.setLeftChild(traverseTreeToInsertNode(parent.getLeftChild(), itemToInsert));
		} else {
			parent.setRightChild(traverseTreeToInsertNode(parent.getRightChild(), itemToInsert));
		}
		return parent;
	}

	/* (non-Javadoc)
	 * @see wordCount.dao.d#removeNodeFromTree(wordCount.dao.Node)
	 */
	@Override
	public void removeNodeFromTree(Node nodeWordoRemove) {
		removeContentFromNode(nodeWordoRemove.getNode_contents());
	}

	/* (non-Javadoc)
	 * @see wordCount.dao.d#removeContentFromNode(wordCount.dao.Word)
	 */
	@Override
	public void removeContentFromNode(Word itemWordoRemove) {
		if (itemWordoRemove != null) {
			traverseToRemoveWord(rootNode, itemWordoRemove);
		} else {
			return;
		}
	}

	/**
	 * @param node
	 * @param itemWordoRemove
	 * @return
	 */
	private Node traverseToRemoveWord(Node node, Word itemWordoRemove) {
		if (node == null) {
			LoggerHandler.writeMessage(
					"Deletion of this word is not possible. " + "\n Since it is not associated with any parent node",
					DebugLevel.NODE_MODIFIED);
			return null;
		} 
		int word_compare_status = itemWordoRemove.compareTo(node.getNode_contents());
		if (word_compare_status < 0) {
			node.setLeftChild(traverseToRemoveWord(node.getLeftChild(), itemWordoRemove));
		} else if (word_compare_status > 0) {
			node.setRightChild(traverseToRemoveWord(node.getRightChild(), itemWordoRemove));
		} else {
			// Case 1: No child
			if (node.getLeftChild() == null && node.getRightChild() == null) {
				return node;
			}
			// Case 2: Only Right Child
			else if (node.getLeftChild() == null) {
				return node.getRightChild();
			}
			// Case 3: Only Left Child
			else if (node.getRightChild() == null) {
				return node.getLeftChild();
			}
			// Case 4: When both child exist: In this case we need to replace
			// with the smallest
			// value in the rightmost tree
			else {
			
				Word content_Of_NextMinimumValue = getNextMinimumValue(node);
				node.setNode_contents(content_Of_NextMinimumValue);
				node.setLeftChild(traverseToRemoveWord(node.getLeftChild(), content_Of_NextMinimumValue));
			}
		}
		return node;
	}

//	Value of Rightmost node of Left Tree	
	private Word getNextMinimumValue(Node nodeIn) {
		nodeIn = nodeIn.getLeftChild();
		while (nodeIn.getRightChild() != null) {
			nodeIn = nodeIn.getRightChild();
		}
		return nodeIn.getNode_contents();
	}
	
	/* (non-Javadoc)
	 * @see wordCount.dao.d#doesTreeContains(wordCount.dao.Node)
	 */
	@Override
	public boolean doesTreeContains(Node node_to_be_verified) {
		if (node_to_be_verified == null) {
			return false;
		}
		
		if (node_to_be_verified != null && node_to_be_verified.getNode_contents() != null) {
			return doesTreeNodeContainsWord(node_to_be_verified.getNode_contents());
		}
		
		return false;
	}

	/* (non-Javadoc)
	 * @see wordCount.dao.d#doesTreeNodeContainsWord(wordCount.dao.Word)
	 */
	/* (non-Javadoc)
	 * @see wordCount.dao.TreeInterface#doesTreeNodeContainsWord(wordCount.dao.Word)
	 */
	@Override
	public boolean doesTreeNodeContainsWord(Word wordBeingSearched) {
		if (wordBeingSearched == null) {
			return false;
		} else {
			return traverseTreeToFindWord(getRootNode(), wordBeingSearched);
		}
	}

	/**
	 * @param parentNode
	 * @param wordBeingSearched
	 * @return
	 */
	private boolean traverseTreeToFindWord(Node parentNode, Word wordBeingSearched) {
		if (parentNode != null) {
			int comparison_status = wordBeingSearched.compareTo(parentNode.getNode_contents());
			if (comparison_status == 0) {
				return true;
			} else if (comparison_status < 0) {
				return traverseTreeToFindWord(parentNode.getLeftChild(), wordBeingSearched);
			} else {
				return traverseTreeToFindWord(parentNode.getRightChild(), wordBeingSearched);
			}
		} else {
			
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see wordCount.dao.d#searchNodeContainingWord(wordCount.dao.Word)
	 */
	@Override
	public Node searchNodeContainingWord(Word word_to_be_searched) {
		if (word_to_be_searched == null) {
			return null;
		} else {
			return traverseTreeToFindNode(rootNode, word_to_be_searched);
		}
	}

	/**
	 * @param parent_node
	 * @param wordBeingSearched
	 * @return
	 */
	private Node traverseTreeToFindNode(Node parent_node, Word wordBeingSearched) {
		if (parent_node == null) {
			return null;
		}else {
			int comparison_status = wordBeingSearched.compareTo(parent_node.getNode_contents());
			if (comparison_status == 0) {
				return parent_node;
			} else if (comparison_status > 0) {
				return traverseTreeToFindNode(parent_node.getRightChild(), wordBeingSearched);
			} else {
				return traverseTreeToFindNode(parent_node.getLeftChild(), wordBeingSearched);
			}
		} 
	}
	
	/* (non-Javadoc)
	 * @see wordCount.dao.d#insertNodeInTree(wordCount.dao.Node)
	 */
	@Override
	public void insertNodeInTree(Node node) {
		
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BST [rootNode=" + rootNode + "]";
	}

	/* (non-Javadoc)
	 * @see wordCount.dao.d#accept(wordCount.visitors.Visitor)
	 */
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	/* (non-Javadoc)
	 * @see wordCount.dao.d#clone()
	 */
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	/* (non-Javadoc)
	 * @see wordCount.dao.d#getRootNode()
	 */
	@Override
	public Node getRootNode() {
		return rootNode;
	}

	/* (non-Javadoc)
	 * @see wordCount.dao.d#setRootNode(wordCount.dao.Node)
	 */
	@Override
	public void setRootNode(Node rootNode) {
		this.rootNode = rootNode;
	}
}
