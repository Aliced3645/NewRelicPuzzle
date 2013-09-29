import java.io.File;


/**
 * Accepts workers' output and doing outputs.
 * @author szhang
 *
 */
public class Aggregator extends Thread{

	/**
	 * The log file handle.
	 */
	File logFile;
	
	public Aggregator(File logFile){
		this.logFile = logFile;
	}
	
	
}
