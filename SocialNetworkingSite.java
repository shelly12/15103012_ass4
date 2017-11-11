import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
public class SocialSite 
{
	public static void main(String args[])throws IOException
	{
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		pic[] obj=new pic[5];
		obj[0]=new pic(); obj[1]=new pic();
		obj[2]=new pic(); obj[3]=new pic(); obj[4]=new pic();
		try{
		obj[0].title="Img1";
		obj[0].tag.add("Shubham");
		obj[0].tag.add("Rahul");
		obj[0].tag.add("Pushap");
		obj[1].title="Img2";
		obj[1].tag.add("Hanisha");
		obj[1].tag.add("Shubham");
		obj[2].title="Img3";
		obj[2].tag.add("Rajan");
		obj[2].tag.add("Hanisha");
		obj[3].title="Img4";
		obj[3].tag.add("Rajan");
		obj[3].tag.add("Rahul");
		obj[3].tag.add("Pushap");
		obj[4].title="Img5";
		obj[4].tag.add("Shubham");
		}
		catch(Exception e)
		{
			System.out.println("ERROR");
		}
		ArrayList<pic> p1=new ArrayList<>();
		p1.add(obj[0]); p1.add(obj[3]);
		ArrayList<pic> p2=new ArrayList<>();
		p2.add(obj[0]); p2.add(obj[1]); p2.add(obj[4]);
		ArrayList<pic> p3=new ArrayList<>();
		p3.add(obj[3]); p3.add(obj[2]);
		ArrayList<pic> p4=new ArrayList<>();
		p4.add(obj[1]); p4.add(obj[2]); p4.add(obj[4]);
		HashMap<String,ArrayList<pic>> map=new HashMap<>();
		map.put("Hanisha", p1);
		map.put("Rajan", p2);
		map.put("Shubham", p3);
		map.put("Rahul", p4);
		System.out.println("List of People on social site");
		for(Map.Entry<String,ArrayList<pic>> entry : map.entrySet())
		{
			System.out.println(""+entry.getKey());
		}
		System.out.print("Enter the name of person:");
		String name=br.readLine();
		if(map.containsKey(name))
		{
			ArrayList<pic> al=map.get(name);
			System.out.println("Photos Uploaded by "+name);
			for(int i=0; i<al.size(); i++)
			{
				pic oj=al.get(i);
				System.out.println(""+oj.title);
			}
			System.out.print("Enter the name of photo:");
			String p=br.readLine();
			int check=0;
			for(int i=0; i<al.size(); i++)
			{
				pic oj=al.get(i);
				if(p.equals(oj.title))
				{
					check=1;
					System.out.println("List Of tags");
					ArrayList<String> a=oj.tag;
					for(int j=0; j<a.size(); j++)
					{
						System.out.println(""+a.get(j));
					}
					break;
				}
			}
			if(check==0)
				System.out.println("No Tags Associated");
		}
		else
			System.out.println("Name not available");
		
		System.out.print("Enter the tag name:");
		String tname=br.readLine();
		System.out.println("Photos associated");
		for(int k=0; k<obj.length; k++)
		{
			ArrayList<String> a=obj[k].tag;
			if(a.contains(tname))
			{
				System.out.println(""+obj[k].title);
			}
		}
	}
	
}
class pic
{
	String title;
	ArrayList<String> tag=new ArrayList<>();
}
