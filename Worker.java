import java.net.Socket;

/**
 * Worker threads accepting numbers
 * @author szhang
 *
 */
class Worker extends Thread {
	
	/**
	 * Reference to aggregator instance.
	 */
	private Aggregator aggregator;
	
	/**
	 * Reference to the socket.
	 */
	private Socket socket;

	/**
	 * Reference to the worker pool so it could return itself to.
	 */
	private WorkerPool workerPool;
	
	/**
	 * Socket setter.
	 * @param socket
	 */
	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	/**
	 * Construction method.
	 * @param aggregator
	 */
	public Worker(Aggregator aggregator, WorkerPool workerPool){
		this.aggregator = aggregator;
		this.workerPool = workerPool;
	}
	
	/**
	 * Return myself to the worker pool.
	 */
	private void returnMySelf(){
		workerPool.offer(this);
	}
	
	/**
	 * Running. receiving numbers.
	 */
	public void run(){
		
	}
	
	
	
}
