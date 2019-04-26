package in.msitprogram.jntu.paypal.persistance;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

import in.msitprogram.jntu.paypal.accounts.PPAccount;
import in.msitprogram.jntu.paypal.accounts.PPRestrictedAccount;
import in.msitprogram.jntu.paypal.console.MainMenu;

public class DataStore 
{
	public static PPAccount lookupAccount(String email, String password) throws IOException, ClassNotFoundException 
	{
		{
			PPAccount account = null; //initialize it after reading from file
			// write code to open the files, read
			
			File f=new File("F:\\Paypal.txt");
			if(f.exists())
			{
				FileInputStream fin=new FileInputStream(f);
				ObjectInputStream oin=new ObjectInputStream(fin);
				Vector<PPAccount> vi= (Vector<PPAccount>)oin.readObject();
				//System.out.println(vi.size());
				for(int i=0;i<vi.size();i++)
				{
					account=vi.get(i);
					if(account.getEmail().equals(email))
					{
						
					    return account;
					}
				}
			}
			
		}
		return null;
	}
		public static void writeAccount(PPAccount account) throws Exception, ClassNotFoundException
		{
			PPAccount account1=null;
			Vector<PPAccount> v=new Vector<PPAccount>();
			File f=new File("F:\\Paypal.txt");
			
			if(f.exists())
			{
				FileInputStream fin=new FileInputStream(f);
				try
				{
				ObjectInputStream oin=new ObjectInputStream(fin);
				
		        v= (Vector<PPAccount>)oin.readObject();
				for(int i=0;i<v.size();i++)
				{
					account1=v.get(i);
				 	if(account1.getEmail().equals(account.getEmail()))
					{
					v.remove(account1);
					break;
					}
				}
				}catch(Exception e)
				{
				
				}
					FileOutputStream fout =new FileOutputStream(f);
					ObjectOutputStream oi=new ObjectOutputStream(fout);
					v.addElement(account);
					oi.writeObject(v);
					oi.close();
			}
			else
			{
				FileOutputStream fout =new FileOutputStream(f);
				ObjectOutputStream oi=new ObjectOutputStream(fout);
				v.addElement(account);
				//System.out.println("done");
						oi.writeObject(v);
						oi.close();
			}	
		}
	}
