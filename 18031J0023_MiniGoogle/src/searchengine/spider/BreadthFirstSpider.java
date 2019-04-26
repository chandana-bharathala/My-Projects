/**  
 * 
 * Copyright: Copyright (c) 2004 Carnegie Mellon University
 * 
 * This program is part of an implementation for the PARKR project which is 
 * about developing a search engine using efficient Datastructures.
 * 
 * Modified by Mahender on 12-10-2009
 */
package searchengine.spider;

import java.io.IOException;
import java.net.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Vector;

import searchengine.dictionary.ObjectIterator;
import searchengine.element.PageElementInterface;
import searchengine.element.PageHref;
import searchengine.element.PageWord;
import searchengine.indexer.Indexer;
import searchengine.parser.PageLexer;
import searchengine.url.URLTextReader;

/** Web-crawling objects.  Instances of this class will crawl a given
 *  web site in breadth-first order.
 */
public class BreadthFirstSpider implements SpiderInterface {

	/** Create a new web spider.
	@param u The URL of the web site to crawl.
	@param i The initial web index object to extend.
	 */

	private Indexer i = null;
	private URL u; 

	public BreadthFirstSpider (URL u, Indexer i) {
		this.u = u;
		this.i = i;

	}

	/** Crawl the web, up to a certain number of web pages.
	@param limit The maximum number of pages to crawl.
	 */
	
	
	
	public Indexer crawl (int limit) {
	
		////////////////////////////////////////////////////////////////////
	    //  Write your Code here as part of Breadth First Spider assignment
	    //  
	    ///////////////////////////////////////////////////////////////////
		int y=0;
		Queue queue=new LinkedList<URL>();
		Set<URL> visited=new HashSet<URL>();
		queue.add(u);
		visited.add(u);
		while(y!=limit&&!queue.isEmpty())
		{
		Vector word =new Vector<String>();
		u= (URL) queue.poll();
		URLTextReader ut=new URLTextReader(u);
		try {
			PageLexer<PageElementInterface> p=new PageLexer<PageElementInterface>(ut,u);
			while(p.hasNext())
			{
				PageElementInterface pei= (PageElementInterface) p.next();
				
				if(pei instanceof PageHref)
				{
				//	System.out.println("href : "+pei);
					if(!visited.contains(u))
					queue.add(new URL(String.valueOf(pei)));
				}
				if(pei instanceof PageWord)
				{
					
					//System.out.println("word "+pei);
					word.add(String.valueOf(pei));
				}
			}
			ObjectIterator<Vector> itr = new ObjectIterator<Vector>(word);
			i.addPage(u, itr);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		y++;
	}
		return i;
}

	/** Crawl the web, up to the default number of web pages.
	 */
	public Indexer  crawl() {
		// This redirection may effect performance, but its OK !!
		System.out.println("Crawling: "+u.toString());
		return  crawl(crawlLimitDefault);
	}

	/** The maximum number of pages to crawl. */
	public int crawlLimitDefault = 10;

}
