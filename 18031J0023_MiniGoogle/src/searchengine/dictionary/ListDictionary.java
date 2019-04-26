package searchengine.dictionary;

public class ListDictionary <K extends Comparable<K>, V> implements DictionaryInterface <K,V>{
	Node head;
	static int size=0;
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
	@Override
	public String[] getKeys() {
		// TODO Auto-generated method stub
		String[] keys=new String[size];
		Node temp=head;
		int i=0;
		while(temp!=null)
		{
			if(i<size)
			{
			keys[i]=(String) temp.key;
			i++;
			temp=temp.next;
			}
			//temp=temp.next;
		}
		return keys;
	}

	@Override
	public V getValue(K str) {
		// TODO Auto-generated method stub
		Node temp=head;
		V val = (V) temp.value;
		while(temp!=null)
		{
			if(temp.key.equals(str))
			{
				val=(V) temp.value;
			}
			temp=temp.next;
		}
		return val;
		
	}

	@Override
	public void insert(K key, V value) {
		// TODO Auto-generated method stub
		Node n=new Node(key,value);
		if(head==null)
		{
			head=n;
			size=size+1;
		}
		else
		{
			Node temp=head;
			while(temp.next!=null)
			{
				if(temp.key.equals(key))
				{
					temp.value=value;
					temp=temp.next;
				} 
				temp=temp.next;
			}
			temp.next=n;
			size=size+1;
	}
	}
	@Override
	public void remove(K key) {
		// TODO Auto-generated method stub
		Node temp=head;
		Node t1 = null;
		if(temp.key.equals(key))
		{
			head=head.next;
			size=size-1;
		}
		else
		{
		while(temp!=null)
		{
			if(temp.key.equals(key))
			{
				t1.next=temp.next;
				size=size-1;
				break;
			}
			t1=temp;
			temp=temp.next;
		}
	}
	}

}
