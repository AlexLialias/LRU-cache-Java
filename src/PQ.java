import java.sql.Timestamp;

public class PQ  {
	
	private Data[] heap;
    private int size;
    //create  heap that contains Data objects
    public PQ(int capacity) {
        if (capacity < 1) throw new IllegalArgumentException();
        this.heap = new Data[capacity+1];
        this.size = 0;
    }
	
	//reload the timestamp of a data if it was lookedUp
	public void reloadTimestamp(Data data){
		int i=1;
		while (i<size){
			if (data.getTimestamp().getTime()==heap[i].getTimestamp().getTime()){
				break;
			}
			i++;
		}
		data.setTimeStamp();
		swim(i);
		
		
		
	}

    public Data insert(Data data) {
        // Ensure data is not null
        if (data == null) throw new IllegalArgumentException();
        // Check available space if not delete the oldest used data 
        if (size == heap.length - 1){
			return getMax();
		}
        // Place data at the next available position
        heap[++size] = data;
        // Let the newly added data swim
        swim(size);
		
		return null;
    }
   
    public Data getMax() {
        // Ensure not empty
        if (size == 0) throw new IllegalStateException();
        // Keep a reference to the root object
        Data data = heap[1];
        // Replace root object with the one at rightmost leaf
        if (size > 1) heap[1] = heap[size];
        // Dispose the rightmost leaf
        heap[size--] = null;
        // Sink the new root element
        sink(1);
        // Return the object removed
        return data;
    }

    private void swim(int i) {
        while (i > 1) {  //if i root (i==1) return
            int p = i/2;  //find parent
            if(heap[i].getTimestamp().getTime()<heap[p].getTimestamp().getTime()){
				swap(i,p);
				i=p;
			}else
				return;
        }
    }

    private void sink(int i){
        int left=2*i,right=left+1,min = left;
		while (left <= size){
			if (right<=size){
				min = heap[left].getTimestamp().getTime()<heap[right].getTimestamp().getTime() ? left : right;
			}
			if(heap[i].getTimestamp().getTime()<heap[min].getTimestamp().getTime()) return ;
			swap(i,min);
			i = min; left=2*i; right = left+i; min = left;
			
		}
    }
    
    private void swap(int i, int j) {
        Data tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }
    public void print() {
        for (int i=1; i<=size; i++){
            System.out.print(heap[i]+ " ");
        }
        System.out.println();
    }
    boolean empty(){
        return size == 0;
    }

}