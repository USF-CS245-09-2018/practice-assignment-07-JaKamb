public class ArrayList implements List{
	private Object[] arr;
	private int length;
	private int size;

	public ArrayList(){
		this(10);
	}
	
	public ArrayList(int len){
		length = len;
		arr = new Object[len];
		size = 0;
	}

	public void add(Object obj){
		add(size+1, obj);
	}
	public void add(int pos, Object obj){
		if(pos < 0){
			throw new IllegalArgumentException("Cannot use negative indecies");
		}
		else if(pos > length() || size() == length()-1){
			doubleLen();
			add(pos, obj);
		}
		else if(size == 0){
			arr[0] = obj;
			size++;
		}
		else{
			arrShift(pos);
			arr[pos] = obj;
			size++;
		}
		
	}
	public Object get(int pos){
		return arr[pos];
	}
	public Object remove(int pos){
		Object temp = arr[pos];
		for(int i = pos; i < size(); i++){
			arr[i] = arr[i+1];
		}
		size--;
		return temp;
	}
	public int size(){
		return size;
	}
	public int length(){
		return length;
	}
	public void arrShift(int pos){
		for(int i = size()-1; i >= pos; i--){
			arr[i+1] = arr[i];
		}
	}
	public void doubleLen(){
		Object[] temp = new Object[length*2];
		for(int i = 0; i < length; i++){
			temp[i]=arr[i];
		}
		arr = temp;
		length = length*2;
	}

	@Override
	public String toString(){
		String temp = "";
		for(int i = 0; i < length(); i++){
			temp = temp + " " + arr[i];
		}
		return temp;
	}

	public static void main(String[] args){
		ArrayList list = new ArrayList();
		System.out.println(list.size());
		System.out.println(list.length());
		list.add(5);
		list.add(33);
		list.add(6);
		list.add(34);
		list.add(7);
		list.add(2,87);
		list.add(21);
		list.add(12);
		System.out.println(list.size());
		list.add(65);
		list.add(23);
		list.add(99);
		list.add(0);
		System.out.println(list.length());
		System.out.println(list.size());
		list.remove(2);
		System.out.println(list.size());
		System.out.println(list.toString());
	}
}