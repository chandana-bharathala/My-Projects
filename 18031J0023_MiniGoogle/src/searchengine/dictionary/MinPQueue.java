package searchengine.dictionary;

import java.util.Scanner;

public class MinPQueue<E extends Comparable<E>> implements PQueueADT<E>{
int key=0;
E value;
static int size=5;
int count=0;
String[]a=new String[size];
	@Override
	public void enqueue(E value) {
		// TODO Auto-generated method stub
		a[key++]=(String) value;
		heapify(a);
		}
void heapify(String[] a) {
		// TODO Auto-generated method stub
	int c = 0;
	for(int i=1;i<size;i++)
	{
		int n=(i-1)/2;
		if(a[i]!=null)
		{
		c=a[i].compareTo(a[n]);
		if(c<0)
		{
			String temp=a[n];
			a[n]=a[i];
			a[i]=temp;
		}
		}
	}
	
}
	@Override
	public E dequeue() {
		// TODO Auto-generated method stub
		count++;
		
		//System.out.println("**"+size);
		String val=a[0];
		/*if(size!=0&&size<5)
		{*/
		String temp=a[0];
		a[0]=a[(size-count)];
		a[size-count]=temp;
		size--;
		//}
		heapify(a);
		return (E) val;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		/*int si=0;
		for(int i=0;i<a.length;i++)
		{
			if(a[i]!=null)
			{
				si++;
			}
		}*/
		return size;
	}

	@Override
	public boolean is_empty() {
		// TODO Auto-generated method stub
		int si=0;
		for(int i=0;i<a.length;i++)
		{
			if(a[i]!=null)
			{
			si++;
			}
		}
		if(si==0)
		{
			return true;
		}
		return false;
	}

	@Override
	public E front() {
		// TODO Auto-generated method stub
		heapify(a);
		String val=a[0];
		return (E) val;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		MinPQueue m=new MinPQueue();
		m.enqueue("3");
		m.enqueue("7");
		m.enqueue("4");
		m.enqueue("1");
		m.enqueue("5");
		System.out.println("dequeue");
		System.out.println(m.dequeue());
		System.out.println("size ");
		System.out.println(m.size());
		System.out.println("is empty ");
		System.out.println(m.is_empty());
		System.out.println("front element ");
		System.out.println(m.front());
		
		
	}
}
