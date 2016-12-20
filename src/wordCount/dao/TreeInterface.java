package wordCount.dao;

import wordCount.visitors.Visitor;


/**
 * @author shashiupadhyay
 *
 */
public interface TreeInterface {

	/**
	 * @param word
	 */
	public void insertContentInNode(Word word);

	/**
	 * @param node
	 */
	public void insertNodeInTree(Node node);

	/**
	 * @param nodeWordoRemove
	 */
	public void removeNodeFromTree(Node nodeWordoRemove);

	/**
	 * @param itemWordoRemove
	 */
	public void removeContentFromNode(Word itemWordoRemove);

	/**
	 * @param node_to_be_verified
	 * @return
	 */
	public boolean doesTreeContains(Node node_to_be_verified);

	/**
	 * @param wordBeingSearched
	 * @return
	 */
	public boolean doesTreeNodeContainsWord(Word wordBeingSearched);

	/**
	 * @param word_to_be_searched
	 * @return
	 */
	public Node searchNodeContainingWord(Word word_to_be_searched);

	/**
	 * @param visitor
	 */
	public void accept(Visitor visitor);

	/**
	 * @return
	 * @throws CloneNotSupportedException
	 */
	public Object clone() throws CloneNotSupportedException;

	/**
	 * @return the rootNode
	 */
	public Node getRootNode();

	/**
	 * @param rootNode
	 *            the rootNode to set
	 */
	void setRootNode(Node rootNode);
}
