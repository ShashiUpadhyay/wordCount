package wordCount.dao;


/**
 * @author shashiupadhyay
 *
 */
public interface Observer {
	/**
	 * @param wordIn
	 */
	public void update(Word wordIn);
}
