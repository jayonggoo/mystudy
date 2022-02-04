import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


public class proxy {

	public class Main {
	    public static void main(String[] args) {
	    	
	    	ArrayList<String> array = new ArrayList<String>();
	    	array.add("a");
	    	array.add("b");
	    	array.add("c");
	    	
	    	List proxyList = new CopyOnWriteList(array);
	    	List proxyList2 = new CopyOnWriteList(array);
	    	
//	    	proxyList.add("e");
//	    	
//	    	System.out.println(proxyList.size());
//	    	System.out.println(proxyList2.size());
	    	
	    	proxyList2.remove("b");
	    	
	    	System.out.println(proxyList.size());
	    	System.out.println(proxyList2.size());
	    
	    }
	}
}


 class CopyOnWriteList implements List {
    
	ArrayList<String> list;
	 
	public CopyOnWriteList(List<String> list) {
		// TODO Auto-generated constructor stub
		this.list = (ArrayList<String>) list;
	}
	
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		System.out.println(contentsString(this.list));
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return list.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray(Object[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(Object e) {
		// TODO Auto-generated method stub
		
		this.list = copyOfList(this.list);
		return list.add((String)e);
		
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		this.list = copyOfList(this.list);
		return list.remove(o);
	}

	@Override
	public boolean containsAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		list.clear();
	}

	@Override
	public Object get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object set(int index, Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(int index, Object element) {
		// TODO Auto-generated method stub
	}

	@Override
	public Object remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private String contentsString(ArrayList<String> list)
	{
		StringBuffer bf = new StringBuffer();
		
		for (String strValue : list)
		{
			bf.append(strValue);
		}
		
		return bf.toString();
	}
	
	
	
	private ArrayList<String> copyOfList(ArrayList<String> originList)
	{
		ArrayList<String> oldList = new ArrayList<>();
		for(int i=0; i<originList.size(); i++) {
			oldList.add(i, originList.get(i));
		}
	    return oldList;
	}
}
