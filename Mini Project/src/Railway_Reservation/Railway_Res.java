package Railway_Reservation;

import java.io.*;

public class Railway_Res 
{
	public static void main(String args[])throws IOException
	{
		int ch,tr,p=0;
		Heading h = new Heading();
		Book_Tickets b = new Book_Tickets();
		Book_Tickets2 b2 = new Book_Tickets2();
		Book_Tickets3 b3 = new Book_Tickets3();
		BufferedReader reader =  new BufferedReader(new InputStreamReader(System.in)); 
		for(;;)
		{
			h.doHeading();
			System.out.println("Please Choose a train : ");
			System.out.println("1.Rajdhani Express : KSR Bengaluru - H Nizamuddin ");
			System.out.println("2.Shatabdi Express : Bangalore City Junction - Chennai Central ");
			System.out.println("3.Duronto Express : Pune Junction  – Howrah Junction  ");
			try
			{
				tr = Integer.parseInt(reader.readLine());
			}
			catch(Exception e)
			{
				System.out.println("Please enter a number.");
				continue;
			}
			if(tr<1||tr>3)
			{
				System.out.println("Please enter a number between 1-3.");
				continue;
			}
			
			switch(tr)
			{
			case 1:
				System.out.println("\t\t\t\t\t*********** Rajdhani Express ***********");
				System.out.println();
				break;
				
			case 2:
				System.out.println("\t\t\t\t\t*********** Shatabdi Express ***********");
				System.out.println();
				break;
				
			case 3:
				System.out.println("\t\t\t\t\t*********** Duronto Express ***********");
				System.out.println();
				break;
			default:
				System.out.println("Invalid choice. Please enter a number between 1-3.");
				System.out.println();
			}
			
			System.out.println("1.Book and Display ticket");
			System.out.println("2.Cancel Ticket");
			System.out.println("3.Search passenger");
			System.out.println("4.Display unbooked tickets");
			System.out.println("5.Exit");
			System.out.println("Please enter your choice :");
			
			try
			{
				ch=Integer.parseInt(reader.readLine());
			}
			catch(Exception e)
			{
				System.out.println("Please enter a number.");
				return;
			}
			
			switch(ch)
			{
			case 1 :
				if(tr==1)
				{
					b.Book();
					System.out.println("Do you want to print the ticket list : Press 1");
					try
					{
						p= Integer.parseInt(reader.readLine());
					}
					catch(Exception e)
					{
						System.out.println("Please enter a number.");
						return;
					}
					if(p==1)
					{
						b.Display_ticket();
					}
				}
				else if(tr==2)
				{
					b2.Book();
					System.out.println("Do you want to print the ticket list : Press 1");
					try
					{
						p= Integer.parseInt(reader.readLine());
					}
					catch(Exception e)
					{
						System.out.println("Please enter a number.");
						return;
					}
					if(p==1)
					{
						b2.Display_ticket();
					}
					
				}
				else
				{
					b3.Book();
					System.out.println("Do you want to print the ticket list : Press 1");
					try
					{
						p= Integer.parseInt(reader.readLine());
					}
					catch(Exception e)
					{
						System.out.println("Please enter a number.");
						return;
					}
					if(p==1)
					{
						b3.Display_ticket();
					}
				}
				break;
				
			case 2:
				if(tr==1)
				{
					b.doCancel();
				}
				else if(tr==2)
				{
					b2.doCancel();
				}
				else
				{
					b3.doCancel();
				}
				break;
				
			case 3 :
				if(tr==1)
				{
					b.Search();
				}
				else if(tr==2)
				{
					b2.Search();
				}
				else
				{
					b3.Search();
				}
				break;
				
			case 4 :
				if(tr==1)
				{
					b.DispUnbooked();
				}
				else if(tr==2)
				{
					b2.DispUnbooked();
				}
				else
				{
					b3.DispUnbooked();
				}
				break;
	
			case 5 :
				System.out.println("Thank You ");
				System.exit(0);
				break;
				
			default :
				System.out.println("Invalid choice. Please enter a number between 1-5.");
				System.out.println();
			}
		}
	}

}
