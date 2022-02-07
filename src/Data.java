import java.util.Date;
import java.sql.Timestamp;

public class Data<K, V>{
	
	private V value;
	private K key;
	private Timestamp ts;
	
	Data (K k,V v){
		key=k;
		value=v;
		ts = new Timestamp(System.currentTimeMillis());
	}
	
	// return the key of the data
	public K getKey(){
		return key;
	} 
	//return the data
	public V getValue(){
		return value;
	}
	//reset the timestamp
	public void setTimeStamp(){
	    ts = new Timestamp(System.currentTimeMillis());
	}	
	//return the timestamp
	public Timestamp getTimestamp(){
		return ts;
	}
	
}