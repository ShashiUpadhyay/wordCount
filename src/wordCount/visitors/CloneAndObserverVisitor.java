package wordCount.visitors;

import wordCount.dao.Node;
import wordCount.dao.TreeInterface;


public class CloneAndObserverVisitor implements Visitor {

	private TreeInterface originalTree;
	private TreeInterface backupTree;

	private void recursiveClone(Node nodeIn) throws CloneNotSupportedException {
		Node existing_copy, cloned_copy;
		if(nodeIn.getLeftChild() == null && nodeIn.getRightChild() == null){
			return;
		} 
		if (nodeIn.getRightChild() != null) {
			existing_copy = nodeIn.getRightChild();
			cloned_copy = (Node) existing_copy.clone();
			nodeIn.setRightChild(cloned_copy);
			cloned_copy.setTree(backupTree);
			existing_copy.registerObserver(cloned_copy);
			recursiveClone(cloned_copy);
		}
		if (nodeIn.getLeftChild() != null) {
			existing_copy = nodeIn.getLeftChild();
			cloned_copy = (Node) existing_copy.clone();
			nodeIn.setLeftChild(cloned_copy);
			cloned_copy.setTree(backupTree);
			existing_copy.registerObserver(cloned_copy);
			recursiveClone(cloned_copy);
		}
	}
	
	@Override
	public void visit(TreeInterface treeIn) {
		try {
			originalTree = treeIn;
			backupTree = (TreeInterface) originalTree.clone();
			Node backupTreeRoot = (Node) (originalTree.getRootNode().clone());
			backupTree.setRootNode(backupTreeRoot);
			backupTreeRoot.setTree(backupTree);
			originalTree.getRootNode().registerObserver(backupTree.getRootNode());
			recursiveClone(backupTree.getRootNode());
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		} finally {

		}
	}



	public TreeInterface getBackupTree() {
		return backupTree;
	}

}
