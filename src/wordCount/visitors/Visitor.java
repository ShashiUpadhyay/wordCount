package wordCount.visitors;

import wordCount.dao.TreeInterface;


public interface Visitor {
	public void visit(TreeInterface treeInterface);
}
