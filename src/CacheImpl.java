import java.sql.Timestamp;
import java.util.Date;

public class CacheImpl<K, V> implements Cache<K, V> {
	
	private HashTable hashtable ;
	private PQ PriorityQueue ;
	private long lookUpNumber;
	private long succeed;
	
	public CacheImpl (int size){
		hashtable= new HashTable(100);
		PriorityQueue = new PQ(100);
		lookUpNumber = 0 ;
		succeed = 0;
		
	}
	
	public V lookUp(K Key){
		lookUpNumber++;
		
		Data dummy = new Data(Key,null);
		
		dummy = hashtable.contains(dummy);
		if (dummy!=null){
			PriorityQueue.reloadTimestamp(dummy);
			succeed++;
			return (V)dummy.getValue();
		}
		
		return null;
		
		
	}
	
	public void store(K key, V value){
		Data data = new Data(key,value);
		if(lookUp((K)data.getKey())==null){
			hashtable.add(data);
			Data dummy = PriorityQueue.insert(data);
			if(dummy!=null)
				hashtable.remove(dummy);
			
		}
		
		
	}
	
	public double getHitRatio(){
		double hr = (double)succeed/lookUpNumber;
		return hr;
		
	}
	
	public long getHits(){
		return succeed;
	}
	
	public long getMisses(){
		return lookUpNumber-succeed;
		
	}
	
	public long getNumberOfLookUps(){
		return lookUpNumber;
	}
	
	public int sizeof(){
		return hashtable.size();
	}
	
	
}