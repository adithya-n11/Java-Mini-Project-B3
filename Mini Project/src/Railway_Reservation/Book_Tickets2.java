package Railway_Reservation;

import java.io.*;

public class Book_Tickets2 
{
	int pno[] = new int[275];
	String name[] = new String[275];
	String phno[] = new String[275];
	int age[] = new int[275];
	int cl[] = new int[275];
	int pcount=0;
	int pnum=1;
	int max1=30;
	int max2=40;
	int max3=50;
	int c;
	int t;
	int ta=0;
	int l_phno=0;
	boolean z=false;
	
	Thread th = Thread.currentThread();
	
	public void Book()throws IOException 
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
		
		System.out.println("Enter class of ticket");
		System.out.println("1.AC\t2.First Class\t3.Sleeper Class :");
		try
		{
			c =Integer.parseInt(reader.readLine());	
		}
		catch(Exception e)
		{
			System.out.println("Please enter a number.");
			return;
		}
		if(c<1||c>3)
		{
			System.out.println("Please enter a number between 1-3.");
			return;
		}
		
		System.out.println("Please enter number of tickets :");
		try
		{
		t = Integer.parseInt(reader.readLine()); 
		}
		catch(Exception e)
		{
			System.out.println("Please enter a valid number.");
			return;
		}
		if(t<1)
		{
			System.out.println("Please enter a valid number.");
			return;
		}
		if(c==1 && max1>=t)
		{
		ta=1;
		}
		if(c==2 && max2>=t)
		{
		ta=1;
		}
		if(c==3 && max3>=t)
		{
		ta=1;
		}
		
		if(ta==1)
		{
			for(int i=0;i<t;i++)
			{
			pno[pcount]=pnum;
			
			System.out.println("Please enter your Name :");
			name[pcount]=reader.readLine();
			
			System.out.println("Please enter your Age :");
			try
			{
			age[pcount]=Integer.parseInt(reader.readLine());
			}
			catch(Exception e) 
			{
				 System.out.println("Please enter a Number.");
				 return;
			}
			if(age[pcount]<0)
			{
				System.out.println("Enter valid Age");
				return;
			}
			System.out.println("Please enter your Phone Number :");
			try
			{
				phno[pcount]=reader.readLine();
			}
			catch(Exception e) 
			{
				 System.out.println("Please enter a valid number.");
				 return;
			}
			
			l_phno=phno[pcount].length();
			z=isNumeric(phno[pcount]);
			
			if(!z)
			{
				System.out.println("Please enter a valid Phone number.");
				return;
			}
			if(l_phno!=10)
			{
				System.out.println("Please enter a valid Phone number.");
				return;
			}
			
			cl[pcount]=c;
			pcount++;
			pnum++;
			}
			if(c==1)
			{
			max1-=t;
			System.out.println("Please pay Rs."+t*1500);
			try
			{
			Thread.sleep(3000);
			}
			catch(Exception e)
			{
			}
			}
			System.out.println("Ticket successfully booked");
			if(c==2)
			{
			max2-=t;
			System.out.println("Please pay Rs."+t*1200);
			try
			{
			Thread.sleep(3000);
			}
			catch(Exception e)
			{
			}
			System.out.println("Ticket successfully booked");
			}
			if(c==3)
			{
			max3-=t;
			System.out.println("Please pay Rs."+t*1000);
			try
			{
			Thread.sleep(3000);
			}
			catch(Exception e)
			{
			}
			System.out.println("Ticket successfully booked");
			}
			
		}
			else
				System.out.println("Sorry. Ticket not available.");
	}
	

	public void Display_ticket()throws IOException
		{
			int i;
			
			for(i=0;i<pcount;i++)
			{
				System.out.println("Ticket Details :");
				System.out.println("Name : "+name[i]+"\tClass : "+cl[i]);
				System.out.println("Passenger number : "+pno[i]+"\tAge : "+age[i]);
				System.out.println("Arrival : Bangalore City Junction\tDestination : Chennai Central");
			}
		}
	public void doCancel()throws IOException
	{
		int t_pno[]=new int[275];
		String t_name[]=new String[275];
		String t_phno[]=new String[275];
		int t_age[]=new int[275];
		int t_cl[]=new int[275];
		int t_pcount=0;
		int passengerFound=0;
		int p;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
		
		System.out.println("Please enter the Passenger number :");
		try
		{
		p=Integer.parseInt(reader.readLine());
		}
		catch(Exception e)
		{
			System.out.println("Please enter a valid number.");
			 return;
		}
		for(int i=0;i<pcount;i++)
		{
			if(pno[i]!=p)
			{
				t_pno[t_pcount]=pno[i];
				t_name[t_pcount]=name[i];
				t_phno[t_pcount]=phno[i];
				t_age[t_pcount]=age[i];
				t_cl[t_pcount]=cl[i];
				t_pcount++;
			}
			else
			{
				passengerFound=1;
				if(cl[i]==1)
				{
					max1++;
					System.out.println("Please collect refund of Rs."+1500);
				}
				if(cl[i]==2)
				{
					max2++;
					System.out.println("Please collect refund of Rs."+1200);
				}
				if(cl[i]==3)
				{
					max3++;
					System.out.println("Please collect refund of Rs."+1000);
				}
			}
		}
		if(passengerFound==1)
		{
			pno=t_pno;
			name=t_name;
			age=t_age;
			cl=t_cl;
			phno=t_phno;
			pcount=t_pcount;
			System.out.println("Ticket successfully cancelled.");
		}
		else
		{
			System.out.println("Passenger not found.");
		}
	}
	
	public void DispUnbooked()
	{
		System.out.println("Number of booked tickets status :");
		System.out.println("AC class : "+max1);
		System.out.println("First class : "+max2);
		System.out.println("Sleeper class : "+max3);
	}
	
	public void Search()throws IOException
		{
		int f=0;
		int p;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
		System.out.println("Please enter passenger number to search :");
		
		try
		{
		p=Integer.parseInt(reader.readLine());
		}
		catch(Exception e)
		{
			System.out.println("Please enter a valid number.");
			 return;
		}
		
			for(int i=0;i<pcount;i++)
			{
				if(pno[i]==p)
				{
					System.out.println("Detail found.");
					f=1;
					System.out.println("Passenger number : "+pno[i]); 
					System.out.println("Name : "+name[i]);
					System.out.println("Class : "+cl[i]);
					System.out.println("Age : "+age[i]);
					System.out.println("Arrival : Bangalore City Junction\tDestination : Chennai Central");
				}
			}
		if(f==0)
		System.out.println("No such passenger.");
		}
	
	public boolean isNumeric(String str) 
	{
		for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
		return true;
	}
}



