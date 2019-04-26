package searchengine.dictionary;

public class MyHashDictionary <K extends Comparable<K>, V> implements DictionaryInterface <K,V>{
	int count=0;
	int size=100;
	Node head;
	class Node <K extends Comparable<K>, V>
	{
		K key;
		V value;
		Node<K,V> next;
		Node(K key, V value)
		{
			this.key=key;
			this.value=value;
			next=null;
		}
	}
	Node[] nodes=new Node[size];
	public int hashcode(K s)
	{
		//System.out.println("======"+s);
		int index=Integer.parseInt((String) s)%size;
		return index;
		
	}
	@Override
	public String[] getKeys() {
		// TODO Auto-generated method stub
		String[] s=new String[count];
		int j=0;
		for(int i=0;i<size;i++)
		{
			Node temp=nodes[i];
			while(temp!=null)
			{
				s[j]=(String) temp.key;
				j++;
				temp=temp.next;
			}
		}
		return s;
	}
	@Override
	public V getValue(K str) {
		// TODO Auto-generated method stub
		int i= hashcode(str);
		Node temp=nodes[i];
		while(temp!=null){
			if(temp.key.equals(str))
			{
				return (V) temp.value;
			}
			temp=temp.next;			
		}
		return null;
	}

	@Override
	public void insert(K key, V value) {
		// TODO Auto-generated method stub
		Node n=new Node(key,value);
		int i=hashcode(key);
		System.out.println("---------"+i);
		Node temp=nodes[i];
			if(temp==null)
			{
				count++;
				temp=n;
			}
			else
			{
				while(temp!=null)
				{
					if(temp.key.equals(key))
					{
						temp.value=value;
					}
					else
					{
						count++;
						nodes[i]=n;
					}
					temp=temp.next;
				}
				count++;
				temp=n;
			}
	}

	@Override
	public void remove(K key) {
		// TODO Auto-generated method stub
		
	}

}
