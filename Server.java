import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

public class Server {

	/**
	 * Socket listening for connections.
	 */
	private static ServerSocket serverSocket;
	
	/**
	 * Aggregator.
	 */
	private static Aggregator aggregator;
	
	/**
	 * Worker Pool
	 */
	private static WorkerPool workerPool;
	
	/**
	 * Initialization
	 */
	static {
		
		/**
		 * Open/clear the file
		 */
		File file = new File("numbers.log");

		try {
			file.createNewFile();
			serverSocket = new ServerSocket(4000);
		} catch (IOException e) {
			System.out.println("Error Initializing the server");
			System.exit(-1);
		}
		
		/**
		 * Aggregator initialization
		 */
		aggregator = new Aggregator(file);
		
		/**
		 * Worker pool initialization
		 */
		workerPool = new WorkerPool(5, aggregator);
	}

	/**
	 * Main loop of the server
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		while(!workerPool.isEmpty()){
			Socket socket = serverSocket.accept();
			Worker worker = workerPool.poll();
			worker.setSocket(socket);
			worker.run();
		}
		System.out.println("Too many connections");
		System.exit(-1);
	}
}
