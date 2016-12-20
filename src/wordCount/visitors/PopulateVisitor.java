package wordCount.visitors;

import java.util.StringTokenizer;

import wordCount.dao.Node;
import wordCount.dao.TreeInterface;
import wordCount.dao.Word;
import wordCount.util.FileProcessor;


public class PopulateVisitor implements Visitor {

	private FileProcessor readfileProcessor;
	private TreeInterface tree;

	public PopulateVisitor(FileProcessor fileProcessor_in) {
		readfileProcessor = fileProcessor_in;
	}

	@Override
	public void visit(TreeInterface tree_in) {
		tree = tree_in;
		String stringline;
		String wordtoken;
		Word word;
		Node node;
		StringTokenizer stringtokenizer;
		try {
			stringline = readfileProcessor.fetchNextLine();
			while (stringline != null) {
				stringtokenizer = new StringTokenizer(stringline);
				while (stringtokenizer.hasMoreTokens()) {
					wordtoken = stringtokenizer.nextToken();
					word = new Word(wordtoken,1);
					node = tree.searchNodeContainingWord(word);
					if (node == null) {
						tree.insertContentInNode(word);
					} else {
						word = node.getNode_contents();
						word.setWordCount(word.getWordCount() + 1);
						word.setNumberOfCharacters(word.getWordCount() * word.getWord().length());
					}
				}
				stringline = readfileProcessor.fetchNextLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		} finally {

		}
	}
}
