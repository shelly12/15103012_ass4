import java.io.*;
import java.util.*;
public class TextEditor 
{
	public static void main(String args[])throws IOException
	{
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		System.out.print("Enter the String: ");
		String str=br.readLine();
		
		HashMap<Integer,String> m=new HashMap<>();
		String s=new String(str);
		int key=0;    
		m.put(key, "");
		boolean on=false;
		for(int i=0; i<str.length(); i++)
		{
			char c= str.charAt(i);
			if(on)
			{
				if(c=='$' || c=='@' || c=='#' || c=='^' || c=='>' || c=='<' || c=='?' )
				{
				}
				else
				{
					s=s.toUpperCase();
					c=s.charAt(i);
				}
			}
			if(c=='$')   // make new entry
			{
				key++;
				m.put(key,"");
			}
			else if(c=='@')  
			{
				on=!on;
			}
			else if(c=='#')
			{
				String st=m.get(key);
				if(st=="")
				{
					key=key-1;
				}
				else
				{
					try
					{
					st=st.substring(0,st.length()-1);
					m.put(key, st);
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
			}
			else if(c=='^')  //go to previous entry
			{
				key=key-1;
			}
			else if(c=='>')
			{
				
			}
			else if(c=='<')
			{
				
			}
			else if(c=='?') // go to next entry;
			{
				key=key+1;
				if(!m.containsKey(key))
					m.put(key,"");
			}
			else
			{
				String f=m.get(key)+c;
				m.put(key,f);
			}
		}
		
		for(Map.Entry map : m.entrySet() )
		{
			System.out.println(""+map.getValue());
		}
	}
}
