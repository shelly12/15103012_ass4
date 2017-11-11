import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.io.*;
public class AutoCompletion 
{
	public static void main(String args [])throws IOException
	{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br= new BufferedReader(isr);
		System.out.print("Enter the string: ");
		String s= br.readLine();
		ArrayList<String> a=new ArrayList<>();
		a.add("this");
		a.add("is");
		a.add("the");
		a.add("program");
		a.add("by");
		a.add("shubham");
		a.add("Mittal");
		
		StringTokenizer st=new StringTokenizer(s);
		int k=0;
		while(st.hasMoreTokens())
		{
			String sr=st.nextToken().toLowerCase();
			if(a.contains(sr))
			{
				if(k==0)
				{
					sr=sr.substring(0,1).toUpperCase()+sr.substring(1);
					k++;
				}
				System.out.print(sr+" ");
			}
			else
			{
				int check=0;
				for(int i=0; i<a.size(); i++)
				{
					int match =0;
					String ss=a.get(i);
					if(ss.length() == sr.length())
					{
						for(int j=0; j<ss.length(); j++)
						{
							if(ss.charAt(j)==sr.charAt(j))
								match++;
						}
						if(match>=(sr.length()/2))
						{
							check++;
							if(k==0)
							{
								sr=sr.substring(0,1).toUpperCase()+sr.substring(1);
								k++;
							}
							System.out.print(sr+" ");
						}
					}
				}
				if(check==0)
				{
					a.add(sr);
				}
			}
			
		}
		System.out.println("\n\nUpdated Dictionary");
		Iterator i=a.iterator();
		while(i.hasNext())
		{
			System.out.print(i.next()+",");
		}
	}
}
