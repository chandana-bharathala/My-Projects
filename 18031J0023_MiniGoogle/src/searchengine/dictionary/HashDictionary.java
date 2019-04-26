package searchengine.dictionary;

import java.util.Enumeration;
import java.util.Hashtable;

public class HashDictionary <K extends Comparable<K>, V> implements DictionaryInterface <K,V>{
   Hashtable <K,V>ht= new  Hashtable<K,V>();
	@Override
	public String[] getKeys() {
		// TODO Auto-generated method stub
		String s[]=new String[ht.size()];
		int i=0;
		Enumeration e=ht.keys();
		while(e.hasMoreElements())
		{
			s[i]=(String) e.nextElement();
			i++;
		}
		return s;
	}

	@Override
	public V getValue(K str) {
		// TODO Auto-generated method stub
		return ht.get(str);
	}

	@Override
	public void insert(K key, V value) {
		// TODO Auto-generated method stub
		if(ht.containsKey(key))
		{
			ht.replace(key, value);
		}
		ht.put(key, value);
	}

	@Override
	public void remove(K key) {
		// TODO Auto-generated method stub
		ht.remove(key);
	}

}
