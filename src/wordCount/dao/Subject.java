package wordCount.dao;


/**
 * @author shashiupadhyay
 *
 */
public interface Subject {
	/**
	 * @param observerIn
	 */
	public void registerObserver(Node observerIn);
	
	/**
	 * @param observerIn
	 */
	public void removeObserver(Node observerIn);
	
	public void notifyObserver();
}
