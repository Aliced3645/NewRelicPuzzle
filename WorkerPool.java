import java.util.LinkedList;
import java.util.concurrent.locks.Lock;


/**
 * a container of workers
 * @author szhang
 */
public class WorkerPool {

	/**
	 * Thread pool for workers
	 */
	private LinkedList<Worker> workers = new LinkedList<Worker>();
	
	private Lock lock;
	
	public WorkerPool(int size, Aggregator aggregator){
		for(int i = 0; i < size; i ++){
			workers.add(new Worker(aggregator, this));
		}
	}
	
	public boolean isEmpty(){
		lock.lock();
		boolean result = workers.isEmpty();
		lock.unlock();
		return result;
	}
	
	public Worker poll(){
		lock.lock();
		Worker worker = workers.poll();
		lock.unlock();
		return worker;
	}
	
	public void offer(Worker worker){
		lock.lock();
		workers.offer(worker);
		lock.unlock();
	}
	
}
