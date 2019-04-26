package searchengine.dictionary;

public class BSTDictionary <K extends Comparable<K>, V> implements DictionaryInterface <K,V>{
Node root;
int si=0;
int k=0;
int i;
String[] str;
class Node <K extends Comparable<K>, V>
{
	K key;
	V value;
	Node<K,V> left;
	Node<K,V> right;
	Node(K key, V value)
	{
		this.key=key;
		this.value=value;
	}
}
	@Override
	public String[] getKeys() {
		// TODO Auto-generated method stub
		 i=0;
		//System.out.println("lennnnnn"+si);
		str=new String[si];
		inorder(root);
		/*for(i=0;i<st.length;i++)
		{
		System.out.println("***"+st[i]);
		}*/
		return str;
	}
public void inorder(Node root)
{
	if(root!=null)
	{
		inorder(root.left);
		if(root.key!=null && root.value!=null)
		{
			str[i++]=(String) root.key;
		}
		inorder(root.right);
	}
	//return str;
	
}
	@Override
	public V getValue(K str) {
		// TODO Auto-generated method stub
		if(str!=null)
		return get(str,root);
		return null;
		
	}
public V get(K k, Node x )
{
	if(x!=null && str!=null)
	{
		//System.out.println("in value"+ k+"%$$"+root.key);
		int c=k.compareTo((K) x.key);
		if(c<0)
		{
			return get(k,x.left);
		}
		if(c>0)
		{
			return get(k,x.right);
		}
		else
		{
			return (V) x.value;
		}
	}
	return null;
}
	@Override
	public void insert(K key, V value) {
		// TODO Auto-generated method stub
		root=put(key,value,root);
	}
	Node put(K key, V value, Node x)
	{
		if(x==null)
		{
			si++;
			return new Node(key,value);
		}
		else
		{
			int c=key.compareTo((K) x.key);
			if(c<0)
			{
				x.left=put(key,value,x.left);
			}
			if(c>0)
			{
				x.right=put(key,value,x.right);
			}
			if(c==0)
			{
				x.value=value;
			}	
		}
			return x;
	}
	@Override
	public void remove(K key) {
		// TODO Auto-generated method stub
		root=delete(root,key);
	}
Node delete(Node x, K key)
{
	if(root==null)
	{
		si--;
		return null;
	}
	int c=key.compareTo((K) x.key);
	if(c<0)
	{
		x.left=delete(x.left,key);
	}
	if(c>0)
	{
			x.right=delete(x.right,key);
	}
	else {
		if(x.right==null)
		{   
			si--;
			return x.left;
		}
		if(x.left==null)
		{
			si--;
			return x.right;
		}
		Node t=x;
		x=min(t.right);
		x.right=deletemin(t.right);
		x.left=t.left;
		si--;
	}
	return x;
}
Node deletemin(Node x) {
	if(x.left==null)
		return x.right;
	x.left=deletemin(x.left);
	si--;
	return x;
}
 K min() {
	return (K) min(root).key;
}
 Node min(Node right)
{
	if(right.left==null)
		return right;
	else
		return min(right.left);
}
}