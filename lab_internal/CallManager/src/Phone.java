import java.util.*;
public class Phone {
	public static void main(String[] args) {
		
		ArrayList<Contact> contact = new ArrayList<Contact>();
		ArrayList<MissedCall> missedCall = new ArrayList<MissedCall>();
		Calendar time = Calendar.getInstance();
		contact.add(new Contact("Anurag", 8602760336L));
		contact.add(new Contact("Mum", 9424641643L));
		contact.add(new Contact("Papa", 9425390060L));
		int res=1;
		Scanner sc = new Scanner(System.in);

		while(res==1){
			System.out.println("MENU\n1 - Insert Missed Call\n2 - Done\nEnter Response: ");
			res = sc.nextInt();
			switch(res) {
			case 1:
				long number = sc.nextLong();
				String name = "PrivateCaller";
				for (Contact x: contact)
					if (x.number==number)
						name = x.name;
				missedCall.add(new MissedCall(name, number, time.HOUR+":"+time.MINUTE+":"+time.SECOND));
				if (missedCall.size()==11) 
					missedCall.remove(0);
				break;
			case 2:
				break;
			default:
				System.out.println("Invalid Input");
			}
		}
		//System.out.println(missedCall);
		
		res=1;
		
	
		int i=0;
		while (true) {
			if (i<missedCall.size()) {
			MissedCall x = missedCall.get(i);
			System.out.println("\nMissed Call: "+x.number);
			System.out.println("\nMENU\n1 - Delete Missed Call\n2 - Next Missed Call\n3 - Display Contact Details\n4 - Exit\nEnter Response: ");
			res = sc.nextInt();
			switch(res) {
			case 1:
				missedCall.remove(i);
				break;
			case 2:
				i++;
				break;
			case 3:
				System.out.println(x);
				break;
			case 4:
				System.exit(0);
				break;
			default:
				System.out.println("Invalid Input");
			}
			System.out.println("End Of Register");
		}

		else
			i=0;
		}
		
	}	
}

