import java.util.*;
class Main
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		Customer c1=new Customer();
		char c=(char)1;
		System.out.println("Welcome "+c+"!!");
		int temporary=0;
		boolean b=true;
		do
		{
			System.out.println("Choose your option");
			System.out.println("Press 1 to Register");
			System.out.println("Press 2 to Login");
			System.out.println("Press 3 to exit");
			int n=sc.nextInt();
			switch (n)
			{
				case 1:
				{
					c1.register();
				}
				break;
				case 2:
				{
					sc.nextLine();
					System.out.println("Enter username - ");
					String s=sc.nextLine();
					boolean bl1,bl2,bl3;
					int x=0,y=0,z=0;
					bl1=bl2=bl3=true;
					while(bl1)
					{
						if (s.equals(c1.username))
						{
							x++;
							while(bl2)
							{
								System.out.println("Enter password - ");
								String pass=sc.next();
								if(pass.equals(c1.password))
								{
									y++;
									while(bl3)
									{
										System.out.println();
										String cap="iJ8uGF71";
										System.out.println(cap);
										System.out.println("Enter CAPTCHA code as shown to confirm you are a human");
										String cap1=sc.next();
										if (cap1.equals(cap))
										{
											z++;
											System.out.println("You have logged in successfully");
											System.out.println("Welcome to Make my Trip ");
											System.out.println("----------------------");
											c1.dateSelection();
											c1.ticket();
											c1.hotelChoice();
											c1.hotelBooking();
											c1.billGeneration();
										}
										else 
										{
											System.out.println("Invalid captcha");
											System.out.println("Enter captcha again");
											continue;
										}
										if (z!=0)
										{
											bl3=false;
										}
									}
								}
								else
								{
									System.out.println("Invalid password");
									System.out.println("Enter password again");
									continue;
								}
								if (y!=0)
								{
									bl2=false;
								}
							}
						}
						else 
						{
							System.out.println("Username not found");
							System.out.println("Enter username again");
							continue;
						}
						if (x!=0)
						{
							bl1=false;
						}
					}
				}
				break;
				case 3:
				{
					b=false;
				}
				break;
				default :
				{
					System.out.println("Invalid option");
				}
			}
		}
		while (b);
	}
}
class Customer
{
	Scanner sc=new Scanner(System.in);
	String Full_Name;
	String Mobile_number;
	String Date_Of_Birth;
	String username;
	String password;
	String dateOfJourney;
	double roomChargePerDay = 0.0;
    double extraBedChargePerDay = 600.0;
    double laundryChargePerDay = 100.0;
    double foodChargePerMeal = 0.0;
    double barChargePerDrink = 1000.0;
    double spaChargePerSession = 1500.0;
    double totalBill = 0.0;
	String year=null, setYear=null,setMonth=null;
	int count=0, date=1,days=0,dayStay=0,numberOfPassengers=0;
	int choiceOfDeparture=0,choiceOfArrival=0;
	String departure=null,arrival=null,hotelName=null;
	String[] transport={"Flight","Train","Bus"};
	String[][] flight={{"Air India","Spice Jet","Indigo"},{"Business Class","First Class","Economy Class"},{"Window","Middle","Aisle"}};
	String[][] train={{"Vande Bharat","Rajdhani Express","Shatabdi Express"},{"First Ac","Second Ac","Third Ac"},{"Upper Birth","Middle Berth","Lower Berth"}};
	String[][] bus={{"Volvo","Traveller","Mini Bus"},{"Ac","Deluxe","Non Ac"},{"Window","Middle","Aisle"}};
	String flightCompany=null,flightClass=null,flightSeat=null,trainType=null,trainClass=null,trainBerth=null,busType=null,busClass=null,busSeat=null;
	double cost=0.0,finalBill=0.0;
	String choiceOfTransport=null;
	void register()
	{
		System.out.print("Enter Full Name - ");
		Full_Name=sc.nextLine();
		System.out.println();
		boolean b1=true;
		while(b1)
		{
			System.out.print("Enter Mobile Number - ");
			Mobile_number=sc.nextLine();
			System.out.println();
			int temp=Mobile_number.length();
			if (temp==10)
			{
				int i;
				for (i=0;i<temp;i++)
				{
					if (Mobile_number.charAt(i)>='0' && Mobile_number.charAt(i)<='9')
					{
						continue;
					}
					else 
					{
						System.out.println("Mobile number can only have numbers");
						System.out.println("Enter mobile number again");
						break;
					}
				}
				if (i==10)
				{
					b1=false;
				}
			}
			else 
			{
				System.out.println("Mobile Number can have only 10 digits");
				System.out.println("Enter Mobile Number again");
			}
		}
		b1=true;
		while(b1)
		{
			System.out.print("Enter Date of birth (YYYY-MM-DD)  - ");
			Date_Of_Birth=sc.nextLine();
			System.out.println();
			int temp=Date_Of_Birth.length();
			if (temp==10)
			{
				if (Date_Of_Birth.charAt(0)=='1')
				{
					if (Date_Of_Birth.charAt(1)=='9')
					{
						if (Date_Of_Birth.charAt(2)>='0'&&(Date_Of_Birth.charAt(2)<='9'))
						{
							if (Date_Of_Birth.charAt(3)>='0'&&(Date_Of_Birth.charAt(3)<='9'))
							{
								if (Date_Of_Birth.charAt(4)=='-')
								{
									if (Date_Of_Birth.charAt(5)=='0')
									{
										if (Date_Of_Birth.charAt(6)>='0' && Date_Of_Birth.charAt(6)<='9')
										{
											if (Date_Of_Birth.charAt(7)=='-')
											{
												if (Date_Of_Birth.charAt(8)>='0'&& Date_Of_Birth.charAt(8)<='2')
												{
													if (Date_Of_Birth.charAt(9)>='0' && Date_Of_Birth.charAt(9)<='9')
													{
														break;
													}
													else 
													{
														System.out.println("Wrong format");
														System.out.println("Enter Date of Birth again");
														continue;
													}
												}
												else if (Date_Of_Birth.charAt(8)=='3')
												{
													if (Date_Of_Birth.charAt(9)>='0' && Date_Of_Birth.charAt(9)<='1')
													{
														break;
													}
													else 
													{
														System.out.println("Wrong format");
														System.out.println("Enter Date of Birth again");
														continue;
													}
												}
												else 
												{
													System.out.println("Wrong format");
													System.out.println("Enter Date of Birth again");
													continue;
												}
											}
											else 
											{
												System.out.println("Wrong format");
												System.out.println("Enter Date of Birth again");
												continue;
											}
										}
										else 
										{
											System.out.println("Wrong format");
											System.out.println("Enter Date of Birth again");
											continue;
										}
									}
									else if(Date_Of_Birth.charAt(5)=='1')
									{
										if (Date_Of_Birth.charAt(6)>='0' && Date_Of_Birth.charAt(6)<='2')
										{
											if (Date_Of_Birth.charAt(7)=='-')
											{
												if (Date_Of_Birth.charAt(8)>='0'&& Date_Of_Birth.charAt(8)<='2')
												{
													if (Date_Of_Birth.charAt(9)>='0' && Date_Of_Birth.charAt(9)<='9')
													{
														break;
													}
													else 
													{
														System.out.println("Wrong format");
														System.out.println("Enter Date of Birth again");
														continue;
													}
												}
												else if (Date_Of_Birth.charAt(8)=='3')
												{
													if (Date_Of_Birth.charAt(9)>='0' && Date_Of_Birth.charAt(9)<='1')
													{
														break;
													}
													else 
													{
														System.out.println("Wrong format");
														System.out.println("Enter Date of Birth again");
														continue;
													}
												}
												else 
												{
													System.out.println("Wrong format");
													System.out.println("Enter Date of Birth again");
													continue;
												}
											}
											else 
											{
												System.out.println("Wrong format");
												System.out.println("Enter Date of Birth again");
												continue;
											}
										}
										else 
										{
											System.out.println("Wrong format");
											System.out.println("Enter Date of Birth again");
											continue;
										}
									}
									else 
									{
										System.out.println("Wrong format");
										System.out.println("Enter Date of Birth again");
										continue;
									}
								}
								else 
								{
									System.out.println("Wrong format");
									System.out.println("Enter Date of Birth again");
									continue;
								}
							}
							else
							{
								System.out.println("Wrong format");
								System.out.println("Enter Date of Birth again");
								continue;
							}
						}
						else
						{
							System.out.println("Wrong format");
							System.out.println("Enter Date of Birth again");
							continue;
						}
					}
					else
					{
						System.out.println("Wrong format");
						System.out.println("Enter Date of Birth again");
						continue;
					}
				}
				else if (Date_Of_Birth.charAt(0)=='2')
				{
					if (Date_Of_Birth.charAt(1)=='0')
					{
						if (Date_Of_Birth.charAt(2)>='0'&&(Date_Of_Birth.charAt(2)<='1'))
						{
							if (Date_Of_Birth.charAt(3)>='0'&&(Date_Of_Birth.charAt(3)<='9'))
							{
								if (Date_Of_Birth.charAt(4)=='-')
								{
									if (Date_Of_Birth.charAt(5)=='0')
									{
										if (Date_Of_Birth.charAt(6)>='0' && Date_Of_Birth.charAt(6)<='9')
										{
											if (Date_Of_Birth.charAt(7)=='-')
											{
												if (Date_Of_Birth.charAt(8)>='0'&& Date_Of_Birth.charAt(8)<='2')
												{
													if (Date_Of_Birth.charAt(9)>='0' && Date_Of_Birth.charAt(9)<='9')
													{
														break;
													}
													else 
													{
														System.out.println("Wrong format");
														System.out.println("Enter Date of Birth again");
														continue;
													}
												}
												else if (Date_Of_Birth.charAt(8)=='3')
												{
													if (Date_Of_Birth.charAt(9)>='0' && Date_Of_Birth.charAt(9)<='1')
													{
														break;
													}
													else 
													{
														System.out.println("Wrong format");
														System.out.println("Enter Date of Birth again");
														continue;
													}
												}
												else 
												{
													System.out.println("Wrong format");
													System.out.println("Enter Date of Birth again");
													continue;
												}
											}
											else 
											{
												System.out.println("Wrong format");
												System.out.println("Enter Date of Birth again");
												continue;
											}
										}
									}
									else if(Date_Of_Birth.charAt(5)=='1')
									{
										if (Date_Of_Birth.charAt(6)>='0' && Date_Of_Birth.charAt(6)<='2')
										{
											if (Date_Of_Birth.charAt(7)=='-')
											{
												if (Date_Of_Birth.charAt(8)>='0'&& Date_Of_Birth.charAt(8)<='2')
												{
													if (Date_Of_Birth.charAt(9)>='0' && Date_Of_Birth.charAt(9)<='9')
													{
														break;
													}
													else 
													{
														System.out.println("Wrong format");
														System.out.println("Enter Date of Birth again");
														continue;
													}
												}
												else if (Date_Of_Birth.charAt(8)=='3')
												{
													if (Date_Of_Birth.charAt(9)>='0' && Date_Of_Birth.charAt(9)<='1')
													{
														break;
													}
													else 
													{
														System.out.println("Wrong format");
														System.out.println("Enter Date of Birth again");
														continue;
													}
												}
												else 
												{
													System.out.println("Wrong format");
													System.out.println("Enter Date of Birth again");
													continue;
												}
											}
											else 
											{
												System.out.println("Wrong format");
												System.out.println("Enter Date of Birth again");
												continue;
											}
										}
										else 
										{
											System.out.println("Wrong format");
											System.out.println("Enter Date of Birth again");
											continue;
										}
									}
									else 
									{
										System.out.println("Wrong format");
										System.out.println("Enter Date of Birth again");
										continue;
									}
								}
								else 
								{
									System.out.println("Wrong format");
									System.out.println("Enter Date of Birth again");
									continue;
								}
							}
							else
							{
								System.out.println("Wrong format");
								System.out.println("Enter Date of Birth again");
								continue;
							}
						}
						else if(Date_Of_Birth.charAt(2)>='2')
						{
							if (Date_Of_Birth.charAt(3)>='0'&&(Date_Of_Birth.charAt(3)<='4'))
							{
								if (Date_Of_Birth.charAt(4)=='-')
								{
									if (Date_Of_Birth.charAt(5)=='0')
									{
										if (Date_Of_Birth.charAt(6)>='0' && Date_Of_Birth.charAt(6)<='9')
										{
											if (Date_Of_Birth.charAt(7)=='-')
											{
												if (Date_Of_Birth.charAt(8)>='0'&& Date_Of_Birth.charAt(8)<='2')
												{
													if (Date_Of_Birth.charAt(9)>='0' && Date_Of_Birth.charAt(9)<='9')
													{
														break;
													}
													else 
													{
														System.out.println("Wrong format");
														System.out.println("Enter Date of Birth again");
														continue;
													}
												}
												else if (Date_Of_Birth.charAt(8)=='3')
												{
													if (Date_Of_Birth.charAt(9)>='0' && Date_Of_Birth.charAt(9)<='1')
													{
														break;
													}
													else 
													{
														System.out.println("Wrong format");
														System.out.println("Enter Date of Birth again");
														continue;
													}
												}
												else 
												{
													System.out.println("Wrong format");
													System.out.println("Enter Date of Birth again");
													continue;
												}
											}
											else 
											{
												System.out.println("Wrong format");
												System.out.println("Enter Date of Birth again");
												continue;
											}
										}
									}
									else if(Date_Of_Birth.charAt(5)=='1')
									{
										if (Date_Of_Birth.charAt(6)>='0' && Date_Of_Birth.charAt(6)<='2')
										{
											if (Date_Of_Birth.charAt(7)=='-')
											{
												if (Date_Of_Birth.charAt(8)>='0'&& Date_Of_Birth.charAt(8)<='2')
												{
													if (Date_Of_Birth.charAt(9)>='0' && Date_Of_Birth.charAt(9)<='9')
													{
														break;
													}
													else 
													{
														System.out.println("Wrong format");
														System.out.println("Enter Date of Birth again");
														continue;
													}
												}
												else if (Date_Of_Birth.charAt(8)=='3')
												{
													if (Date_Of_Birth.charAt(9)>='0' && Date_Of_Birth.charAt(9)<='1')
													{
														break;
													}
													else 
													{
														System.out.println("Wrong format");
														System.out.println("Enter Date of Birth again");
														continue;
													}
												}
												else 
												{
													System.out.println("Wrong format");
													System.out.println("Enter Date of Birth again");
													continue;
												}
											}
											else 
											{
												System.out.println("Wrong format");
												System.out.println("Enter Date of Birth again");
												continue;
											}
										}
										else 
										{
											System.out.println("Wrong format");
											System.out.println("Enter Date of Birth again");
											continue;
										}
									}
									else 
									{
										System.out.println("Wrong format");
										System.out.println("Enter Date of Birth again");
										continue;
									}
								}
								else 
								{
									System.out.println("Wrong format");
									System.out.println("Enter Date of Birth again");
									continue;
								}
							}
							else
							{
								System.out.println("Wrong format");
								System.out.println("Enter Date of Birth again");
								continue;
							}
						}
						else
						{
							System.out.println("Wrong format");
							System.out.println("Enter Date of Birth again");
							continue;
						}
					}
					else
					{
						System.out.println("Wrong format");
						System.out.println("Enter Date of Birth again");
						continue;
					}
				}
				else 
				{
					System.out.println("Wrong format");
					System.out.println("Enter Date of Birth again");
					continue;
				}
			}
			else 
			{
				System.out.println("Wrong format");
				System.out.println("Enter Date of Birth again");
				continue;
			}
		}
		String ar[]=Full_Name.split(" ");
		String dob[]=Date_Of_Birth.split("-");
		username=ar[0].concat(dob[0]);
		System.out.println("Your username is - "+username);
		System.out.println("Password must contain at least :");
		System.out.println("1 upper case character");
		System.out.println("1 lower case character");
		System.out.println("1 number");
		System.out.println("Password must contain minimum 8 letters ");
		b1=true;
		while (b1)
		{
			System.out.println("Enter password - ");
			password=sc.next();
			int x=0;
			if (password.length()>=8)
			{
				for (int i=0;i<password.length();i++)
				{
					if (password.charAt(i)>='A' && password.charAt(i)<='Z')
					{
						x++;
						continue;
					}
				}
				if (x==0)
				{
					System.out.println("Password must contain at least one upper case character");
					System.out.println("Enter password again");
					continue;
				}
				else 
				{
					int x1=0;
					for (int i=0;i<password.length();i++)
					{
						if (password.charAt(i)>='a' && password.charAt(i)<='z')
						{
							x1++;
							continue;
						}
					}
					if (x1==0)
					{
						System.out.println("Password must contain at least one lower case character");
						System.out.println("Enter password again");
						continue;
					}
					else 
					{
						int x2=0;
						for (int i=0;i<password.length();i++)
						{
							if (password.charAt(i)>='0' && password.charAt(i)<='9')
							{
								x2++;
								continue;
							}
						}
						if (x2==0)
						{
							System.out.println("Password must contain at least one number");
							System.out.println("Enter password again");
							continue;
						}
						else 
						{
							b1=false;
						}
					}
				}
				b1=false;
			}
			else 
			{
				System.out.println("Password must contain minimum 8 letters ");
				System.out.println("Enter password again");
			}
		}
	}
	void hotelBooking() 
	{
		totalBill = 0.0;
		System.out.println("Welcome to the Hotel Billing System!");
		boolean b = true;
		System.out.println("Enter number of days you want to stay in our hotel");
		dayStay=sc.nextInt();
		System.out.println("----------------------");
		while(true)
		{
			System.out.println("Types of rooms: Twin Bed, Double Bed, Suite");
			System.out.println("Press 1 for Twin Bed Room. Price : 6500/-");
			System.out.println("Press 2 for Double Bed Room. Price : 7500/-");
			System.out.println("Press 3 for Suite. Price : 8000/-");
			int ch = sc.nextInt();
			if(ch==1)
			{
				System.out.println("Twin Bed Room Selected");
				roomChargePerDay = 6500;
				totalBill += roomChargePerDay;
				break;
			}
			else if(ch==2)
			{
				System.out.println("Double Bed Room Selected");
				roomChargePerDay = 7500;
				totalBill += roomChargePerDay;
				break;
			}
			else if(ch==3)
			{
				System.out.println("Suit Selected");
				roomChargePerDay = 8000;
				totalBill += roomChargePerDay;
				break;
			}
			else
			{
				System.out.println("You Have Not Selected Any Room!");
				continue;
			}
		}
		totalBill*=dayStay;
		System.out.println("----------------------");
		while(b)
		{
			System.out.println("Choose an option:");
			System.out.println("1. Show available services");
			System.out.println("2. Free Room Services");
			System.out.println("3. Extra Bed");
			System.out.println("4. Food Order");
			System.out.println("5. Laundry");
			System.out.println("6. Bar");
			System.out.println("7. Spa & Salon");
			System.out.println("8. Cancel/Exit");
			System.out.println();
			System.out.print("Your Choice= ");
			System.out.println();
			int choice = sc.nextInt();
			switch (choice) 
			{
				case 1:
				{
					System.out.println("----------------------");
					System.out.println("Available services:");
					System.out.println("Free Wi-Fi \nWheel-Chair Available \nBreakfast included with stay \nParking Available");
					System.out.println("-----------------------");
				}
				break;
				case 2:
				{
					System.out.println("----------------------");
					System.out.println("Room service includes Hair-dryer,iron,kettle,Hot-Water Bath without any extra charges");
					System.out.println("------------------------");
				}
				break;
				case 3:
				{
					boolean b123=true;
					while(b123)
					{
						System.out.println("----------------------");
						System.out.println("Extra BedCharges Per Day = 600.0 per bed");
						System.out.println("Would you like to select Extra Bed ?(yes/no) - ");
						String ans = sc.next();
						if(ans.equalsIgnoreCase("yes"))
						{
							System.out.print("How many extra beds do you want ? ");
							System.out.println();
							int bed=sc.nextInt();
							System.out.println(bed+" Extra Bed selected.");
							totalBill +=dayStay*bed*extraBedChargePerDay;
							
							b123=false;
						}
						else if(ans.equalsIgnoreCase("no"))
						{
							System.out.println("You Have not selected Any Extra Bed!");
							b123=false;
						}
						else
						{
							System.out.println("Invalid Input");
							continue;
						}
					}
					System.out.println("----------------------");
				}
				break;
				case 4:
				{
					System.out.println("----------------------");
					boolean b123=true;
					while(b123)
					{
						System.out.println("Which food would you prefer?");
						System.out.println("Enter 1 for veg food(Food Charges Per Meal =1200)");
						System.out.println("Enter 2 for nonveg food (Food Charges Per Meal =1500)");
						System.out.print("Enter choice - ");
						int c = sc.nextInt();
						System.out.println();
						if(c==1)
						{
							foodChargePerMeal =1200;
							totalBill += dayStay*foodChargePerMeal;
							b123=false;
						}
						else if (c==2)
						{
							foodChargePerMeal = 1500;
							totalBill += dayStay*foodChargePerMeal;
							b123=false;
						}
						else 
						{
							System.out.println("Invalid input");
							continue;
						}
					}
					System.out.println("----------------------");
				}
				break;
				case 5:
				{
					boolean b123=true;
					while(b123)
					{
						System.out.println("----------------------");
						System.out.println("Laundry Charges Per Day = 100.0");
						System.out.println("Would you like to select Laundry service?(yes/no) - ");
						String answ = sc.next();
						if(answ.equalsIgnoreCase("yes"))
						{
							System.out.println("Laundry selected.");
							totalBill +=dayStay*laundryChargePerDay;
							b123=false;
						}
						else if(answ.equalsIgnoreCase("no"))
						{
							System.out.println("You Have not selected Laundry Service!");
							b123=false;
						}
						else
						{
							System.out.println("Invalid input");
						}
					}
					System.out.println("----------------------");
				}
				break;
				case 6:
				{
					boolean b123=true;
					while(b123)
					{
						System.out.println("----------------------");
						System.out.println("Bar Charges Per Drink = 1000.0");
						System.out.println("Would you like to use our bar service ?(yes/no) - ");
						String answe= sc.next();
						if(answe.equalsIgnoreCase("yes"))
						{
							System.out.println("Bar selected.");
							System.out.println("Enter number of drinks per day - ");
							int drink=sc.nextInt();
							totalBill +=dayStay*drink*barChargePerDrink; 
							b123=false;
						}
						else if(answe.equalsIgnoreCase("no"))
						{
							System.out.println("You Have not selected bar service!");
							b123=false;
						}
						else 
						{
							System.out.println("Invalid input");
						}
					}
					System.out.println("----------------------");
				}
				break;
				case 7:
				{
					boolean b123=true;
					while(b123)
					{
						System.out.println("----------------------");
						System.out.println("Spa Charges Per Session = 1500.0");
						System.out.println("Would you like to use our Spa & Salon service ?(yes/no) - ");
						String answer = sc.next();
						if(answer.equalsIgnoreCase("yes"))
						{
							System.out.println("Spa & Salon selected.");
							totalBill +=spaChargePerSession;
							b123=false;
						}
						else if(answer.equalsIgnoreCase("no"))
						{
							System.out.println("You Have not selected Spa & Salon Service!");
							b123=false;
						}
						else
						{
							System.out.println("Invalid Input");
						}
					}
					System.out.println("-----------------------");
				}
				break;
				case 8:
				{
					System.out.println("----------------------");
					System.out.println("Total Bill: " + totalBill+" Rs. Only/-");
					System.out.println("Exiting the Hotel Booking System.");
					System.out.println("Thank You For Choosing Our Hotel");
					System.out.println("--------------------------");
					b =false;
				}
				break;
				default:
				{
					System.out.println("Invalid choice. Please choose a valid option.");
				}
				break;
			}
		}
    }
	void dateSelection()
	{
		boolean loop1=true;
		while(loop1)
		{
			boolean checkYear=true;
			int choice1,noYear=0;
			while(checkYear)
			{
				System.out.println("Enter the year [4 digits only allowed (2024-2025)]");
				setYear= sc.next();
				if (setYear.length()==4)
				{
					int i=0;
					for (i=0;i<4;i++)
					{
						if (setYear.charAt(i)>='0' && setYear.charAt(i)<='9')
						{
							continue;
						}
						else 
						{
							break;
						}
					}
					if (i==4)
					{
						if (setYear.charAt(0)=='2')
						{
							if (setYear.charAt(1)=='0')
							{
								if (setYear.charAt(2)=='2')
								{
									if (setYear.charAt(3)>='4' && setYear.charAt(3)<='5')
									{
										year=setYear;
										checkYear=false;
									}
									else 
									{
										System.out.println("Invalid format for Year");
										continue;
									}
								}
								else 
								{
									System.out.println("Invalid format for Year");
									continue;
								}
							}
							else 
							{
								System.out.println("Invalid format for Year");
								continue;
							}
						}
						else 
						{
							System.out.println("Invalid format for Year");
							continue;
						}
					}
					else 
					{
						System.out.println("Invalid format for Year");
						continue;
					}
				}
				else 
				{
					System.out.println("Year must have 4 digits");
					continue;
				}
			}
			boolean boolDate= true;
			//Choosing Months and Setting No. of Days to The particular months.
			//selection of months
			String[] months= {"January","February","March","April","May","June","July","August","September","October","November","December"};
			int typeDays[] = {28,29,30,31};
			if (setYear.equals("2024"))
			{
				boolean check=true;
				while(check)
				{	
					System.out.println("Select Date of Journey ");
					System.out.println();
					System.out.println("Please select Month from the following");
					System.out.println("Press 2 for February");
					System.out.println("Press 3 for March");
					System.out.println("Press 4 for April");
					System.out.println("Press 5 for May");
					System.out.println("Press 6 for June");
					System.out.println("Press 7 for July");
					System.out.println("Press 8 for August");
					System.out.println("Press 9 for September");
					System.out.println("Press 10 for October");
					System.out.println("Press 11 for November");
					System.out.println("Press 12 for December");
					System.out.println("Enter you choice");
					choice1= sc.nextInt();
					//Setting days to particular months
					switch(choice1) 
					{
						case 2:
						{
							setMonth= months[(choice1-1)]; 												
							//February=28/29(leap year)
							days=typeDays[1];
						}
						break;
						case 3:
						{
							setMonth= months[(choice1-1)]; 												
							//March=31
							days=typeDays[3];
						}
						break;
						case 4:
						{
							setMonth= months[(choice1-1)];
							//April=30
							days=typeDays[2];
						}
						break;
						case 5:
						{
							setMonth= months[(choice1-1)];		
							//May=31
							days=typeDays[3];
						}
						break;
						case 6:
						{
							setMonth= months[(choice1-1)];											
							//June=30
							days=typeDays[2];
						}
						break;
						case 7:
						{
							setMonth= months[(choice1-1)];												
							//July=31
							days=typeDays[3];
						}
						break;
						case 8:
						{
							setMonth= months[(choice1-1)];												
							//August=31
							days=typeDays[3];
						}
						break;
						case 9:
						{
							setMonth= months[(choice1-1)];												
							//September=30
							days=typeDays[2];
						}
						break;
						case 10:
						{
							setMonth= months[(choice1-1)]; 										
							//October=31
							days=typeDays[3];
						}
						break;
						case 11:
						{
							setMonth= months[(choice1-1)];												
							//November=30
							days=typeDays[2];
						}
						break;
						case 12:
						{
							setMonth= months[(choice1-1)];	
							//December=31
							days=typeDays[3];
						}
						break;
						default:
						{
							System.out.println("Invalid Choice.");
							continue;
						}
					}
					System.out.println("Enter the date you want to book for :");
					int setDate= sc.nextInt();
					int currentDate= 17;
					if (setMonth.equals("February"))
					{
						if(setDate>=currentDate && setDate<=days)
						{
							date= setDate;
							check=false;
							loop1=false;
						}
						else
						{
							System.out.println("Invalid Date");
							continue;
						}
					}
					else 
					{
						if(setDate>0 && setDate<=days)
						{
							date= setDate;
							boolDate=false;
							loop1=false;
							check=false;
						}
						else
						{
							System.out.println("Invalid Date");
							continue;
						}
					}
				}
			}
			else 
			{
				while(boolDate)
				{	
					System.out.println("Select Date of Journey ");
					System.out.println();
					System.out.println("Please select Month from the following");
					System.out.println("Press 1 for January");
					System.out.println("Press 2 for February");
					System.out.println("Press 3 for March");
					System.out.println("Press 4 for April");
					System.out.println("Press 5 for May");
					System.out.println("Press 6 for June");
					System.out.println("Press 7 for July");
					System.out.println("Press 8 for August");
					System.out.println("Press 9 for September");
					System.out.println("Press 10 for October");
					System.out.println("Press 11 for November");
					System.out.println("Press 12 for December");
					System.out.println("Enter you choice");
					choice1= sc.nextInt();
					//Setting days to particular months
					switch(choice1) 
					{
						case 1: 
						{
							setMonth= months[(choice1-1)];
							//January=31
							days=typeDays[3];
						}
						break;
						case 2:
						{
							setMonth= months[(choice1-1)]; 												
							//February=28/29(leap year)
							days=typeDays[0];
						}
						break;
						case 3:
						{
							setMonth= months[(choice1-1)]; 												
							//March=31
							days=typeDays[3];
						}
						break;
						case 4:
						{
							setMonth= months[(choice1-1)];
							//April=30
							days=typeDays[2];
						}
						break;
						case 5:
						{
							setMonth= months[(choice1-1)];		
							//May=31
							days=typeDays[3];
						}
						break;
						case 6:
						{
							setMonth= months[(choice1-1)];											
							//June=30
							days=typeDays[2];
						}
						break;
						case 7:
						{
							setMonth= months[(choice1-1)];												
							//July=31
							days=typeDays[3];
						}
						break;
						case 8:
						{
							setMonth= months[(choice1-1)];												
							//August=31
							days=typeDays[3];
						}
						break;
						case 9:
						{
							setMonth= months[(choice1-1)];												
							//September=30
							days=typeDays[2];
						}
						break;
						case 10:
						{
							setMonth= months[(choice1-1)]; 										
							//October=31
							days=typeDays[3];
						}
						break;
						case 11:
						{
							setMonth= months[(choice1-1)];												
							//November=30
							days=typeDays[2];
						}
						break;
						case 12:
						{
							setMonth= months[(choice1-1)];	
							//December=31
							days=typeDays[3];
						}
						break;
						default:
						{
							System.out.println("Invalid Choice.");
							continue;
						}
					}
					System.out.println("Enter the date you want to book for :");
					int setDate= sc.nextInt();int currentDate= 17;
					if(setDate>0 && setDate<=days)
					{
						date= setDate;
						boolDate=false;
						loop1=false;
					}
					else
					{
						System.out.println("Invalid Date");
						continue;
					}
				}
			}
		}
		dateOfJourney=date+"/"+setMonth+"/"+year;
		System.out.println("Year:"+year);
		System.out.println("Month:"+setMonth);
		System.out.println("Date:"+date);
		System.out.println("Date :"+date+"/"+setMonth+"/"+year);
		System.out.println("---------------------------");
	}
	void ticket()
	{
		boolean bo13=true;
		while(bo13)
		{
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter number of passengers (maximum 25) - ");
			numberOfPassengers=sc.nextInt();
			if (numberOfPassengers<=25)
			{
				boolean bo1=true;
				while(bo1)
				{
					System.out.println("Choose Departure Place");
					System.out.println("Press 1 for Ahmedabad.");
					System.out.println("Press 2 for Banglore.");
					System.out.println("Press 3 for Chennai.");
					System.out.println("Press 4 for Delhi.");
					System.out.println("Press 5 for Hyderabad.");
					System.out.println("Press 6 for Kolkata.");
					System.out.println("Press 7 for Mumbai.");
					System.out.println("Press 8 for Pune.");
					System.out.println("Enter your choice - ");
					choiceOfDeparture=sc.nextInt();
					switch(choiceOfDeparture)
					{
						case 1:
						{
							departure="Ahmedabad";
							bo1=false;
						}
						break;
						case 2:
						{
							departure="Bangalore";
							bo1=false;
						}
						break;
						case 3:
						{
							departure="Chennai";
							bo1=false;
						}
						break;
						case 4:
						{
							departure="Delhi";
							bo1=false;
						}
						break;
						case 5:
						{
							departure="Hyderabad";
							bo1=false;
						}
						break;
						case 6:
						{
							departure="Kolkata";
							bo1=false;
						}
						break;
						case 7:
						{
							departure="Mumbai";
							bo1=false;
						}
						break;
						case 8:
						{
							departure="Pune";
							bo1=false;
						}
						break;
						default:
						{
							System.out.println("Invalid Choice");
							System.out.println("----------------------------------------------");
							continue;
						}
					}
				}
				bo13=false;
			}
			else
			{
				System.out.println("Maximum 25 Passengers Allowed");
				continue;
			}
		}
		boolean bo1=true;
		while(bo1)
		{
			System.out.println("Choose Arrival Place");
			System.out.println("Press 1 for Ahmedabad.");
			System.out.println("Press 2 for Banglore.");
			System.out.println("Press 3 for Chennai.");
			System.out.println("Press 4 for Delhi.");
			System.out.println("Press 5 for Hyderabad.");
			System.out.println("Press 6 for Kolkata.");
			System.out.println("Press 7 for Mumbai.");
			System.out.println("Press 8 for Pune.");
			System.out.println("Enter your choice - ");
			choiceOfArrival=sc.nextInt();
			if (choiceOfArrival==choiceOfDeparture)
			{
				System.out.println("Arrival Place cannot be same as Departure Place");
				System.out.println("----------------------------------------------");
				continue;
			}
			else
			{
				switch(choiceOfArrival)
				{
					case 1:
					{
						arrival="Ahmedabad";
						bo1=false;
					}
					break;
					case 2:
					{
						arrival="Bangalore";
						bo1=false;
					}
					break;
					case 3:
					{
						arrival="Chennai";
						bo1=false;
					}
					break;
					case 4:
					{
						arrival="Delhi";
						bo1=false;
					}
					break;
					case 5:
					{
						arrival="Hyderabad";
						bo1=false;
					}
					break;
					case 6:
					{
						arrival="Kolkata";
						bo1=false;
					}
					break;
					case 7:
					{
						arrival="Mumbai";
						bo1=false;
					}
					break;
					case 8:
					{
						arrival="Pune";
						bo1=false;
					}
					break;
					default:
					{
						System.out.println("Invalid Choice");
						System.out.println("----------------------------------------------");
						continue;
					}
				}
			}
		}
		switch(choiceOfDeparture)
		{
			case 1:
			{
				switch(choiceOfArrival)
				{
					case 1:
					{
						cost+=0;
					}
					break;
					case 2:
					{
						cost+=14;
					}
					break;
					case 3:
					{
						cost+=18;
					}
					break;
					case 4:
					{
						cost+=9;
					}
					break;
					case 5:
					{
						cost+=12;
					}
					break;
					case 6:
					{
						cost+=20;
					}
					break;
					case 7:
					{
						cost+=5;
					}
					break;
					case 8:
					{
						cost+=6;
					}
					break;
				}
			}
			break;
			case 2:
			{
				switch(choiceOfArrival)
				{
					case 1:
					{
						cost+=14;
					}
					break;
					case 2:
					{
						cost+=0;
					}
					break;
					case 3:
					{
						cost+=3;
					}
					break;
					case 4:
					{
						cost+=21;
					}
					break;
					case 5:
					{
						cost+=5;
					}
					break;
					case 6:
					{
						cost+=18;
					}
					break;
					case 7:
					{
						cost+=10;
					}
					break;
					case 8:
					{
						cost+=8;
					}
					break;
				}
			}
			break;
			case 3:
			{
				switch(choiceOfArrival)
				{
					case 1:
					{
						cost+=18;
					}
					break;
					case 2:
					{
						cost+=3;
					}
					break;
					case 3:
					{
						cost+=0;
					}
					break;
					case 4:
					{
						cost+=21;
					}
					break;
					case 5:
					{
						cost+=6;
					}
					break;
					case 6:
					{
						cost+=16;
					}
					break;
					case 7:
					{
						cost+=13;
					}
					break;
					case 8:
					{
						cost+=12;
					}
					break;
				}
			}
			break;
			case 4:
			{
				switch(choiceOfArrival)
				{
					case 1:
					{
						cost+=9;
					}
					break;
					case 2:
					{
						cost+=21;
					}
					break;
					case 3:
					{
						cost+=21;
					}
					break;
					case 4:
					{
						cost+=0;
					}
					break;
					case 5:
					{
						cost+=15;
					}
					break;
					case 6:
					{
						cost+=15;
					}
					break;
					case 7:
					{
						cost+=14;
					}
					break;
					case 8:
					{
						cost+=14;
					}
					break;
				}
			}
			break;
			case 5:
			{
				switch(choiceOfArrival)
				{
					case 1:
					{
						cost+=12;
					}
					break;
					case 2:
					{
						cost+=5;
					}
					break;
					case 3:
					{
						cost+=6;
					}
					break;
					case 4:
					{
						cost+=15;
					}
					break;
					case 5:
					{
						cost+=0;
					}
					break;
					case 6:
					{
						cost+=15;
					}
					break;
					case 7:
					{
						cost+=7;
					}
					break;
					case 8:
					{
						cost+=5;
					}
					break;
				}
			}
			break;
			case 6:
			{
				switch(choiceOfArrival)
				{
					case 1:
					{
						cost+=20;
					}
					break;
					case 2:
					{
						cost+=18;
					}
					break;
					case 3:
					{
						cost+=16;
					}
					break;
					case 4:
					{
						cost+=15;
					}
					break;
					case 5:
					{
						cost+=15;
					}
					break;
					case 6:
					{
						cost+=0;
					}
					break;
					case 7:
					{
						cost+=19;
					}
					break;
					case 8:
					{
						cost+=18;
					}
					break;
				}
			}
			break;
			case 7:
			{
				switch(choiceOfArrival)
				{
					case 1:
					{
						cost+=5;
					}
					break;
					case 2:
					{
						cost+=10;
					}
					break;
					case 3:
					{
						cost+=13;
					}
					break;
					case 4:
					{
						cost+=14;
					}
					break;
					case 5:
					{
						cost+=7;
					}
					break;
					case 6:
					{
						cost+=19;
					}
					break;
					case 7:
					{
						cost+=0;
					}
					break;
					case 8:
					{
						cost+=1;
					}
					break;
				}
			}
			break;
			case 8:
			{
				switch(choiceOfArrival)
				{
					case 1:
					{
						cost+=6;
					}
					break;
					case 2:
					{
						cost+=8;
					}
					break;
					case 3:
					{
						cost+=12;
					}
					break;
					case 4:
					{
						cost+=14;
					}
					break;
					case 5:
					{
						cost+=5;
					}
					break;
					case 6:
					{
						cost+=18;
					}
					break;
					case 7:
					{
						cost+=1;
					}
					break;
					case 8:
					{
						cost+=0;
					}
					break;
				}
			}
			break;
		}
		boolean bo2=true;
		int choice=0;
		while(bo2)
		{
			System.out.println("Enter Choice of Transport");
			System.out.println("Enter 1 for Flight");
			System.out.println("Enter 2 for Train");
			System.out.println("Enter 3 for Bus");
			System.out.println("Enter your Choice - ");
			choice=sc.nextInt();
			if (choice>0 && choice<3)
			{
				choiceOfTransport=transport[choice-1];
				bo2=false;
			}
			else 
			{
				System.out.println("Invalid choice");
				System.out.println("----------------------------------------");
				continue;
			}
		}
		int choice1=0;
		switch (choice)
		{
			case 1:
			{
				boolean bo3=true;
				while(bo3)
				{
					System.out.println("Choose Flight");
					System.out.println("Enter 1 for Air India");
					System.out.println("Enter 2 for SpiceJet");
					System.out.println("Enter 3 for Indigo");
					System.out.println("Enter your choice - ");
					choice1=sc.nextInt();
					switch(choice1)
					{
						case 1:
						{
							cost*=60;
							flightCompany=flight[0][0];
							bo3=false;
						}
						break;
						case 2:
						{
							cost*=50;
							flightCompany=flight[0][1];
							bo3=false;
						}
						break;
						case 3:
						{
							cost*=40;
							flightCompany=flight[0][2];
							bo3=false;
						}
						break;
						default:
						{
							System.out.println("Invalid Choice");
							System.out.println("-----------------------------------------");
							continue;
						}
					}
				}
			}
			break;
			case 2:
			{
				boolean bo3=true;
				while(bo3)
				{
					System.out.println("Choose Train");
					System.out.println("Enter 1 for Vande Bharat");
					System.out.println("Enter 2 for Rajdhani Express");
					System.out.println("Enter 3 for Shatabdi Express");
					System.out.println("Enter your choice - ");
					choice1=sc.nextInt();
					switch(choice1)
					{
						case 1:
						{
							cost*=30;
							trainType=train[0][0];
							bo3=false;
						}
						break;
						case 2:
						{
							cost*=25;
							trainType=train[0][1];
							bo3=false;
						}
						break;
						case 3:
						{
							cost*=20;
							trainType=train[0][2];
							bo3=false;
						}
						break;
						default:
						{
							System.out.println("Invalid Choice");
							System.out.println("-----------------------------------------");
							continue;
						}
					}
				}
			}
			break;
			case 3:
			{
				boolean bo3=true;
				while(bo3)
				{
					System.out.println("Choose Bus");
					System.out.println("Enter 1 for Volvo");
					System.out.println("Enter 2 for Traveller");
					System.out.println("Enter 3 for Mini Bus");
					System.out.println("Enter your choice - ");
					choice1=sc.nextInt();
					switch(choice1)
					{
						case 1:
						{
							cost*=15;
							busType=bus[0][0];
							bo3=false;
						}
						break;
						case 2:
						{
							cost*=13;
							busType=bus[0][1];
							bo3=false;
						}
						break;
						case 3:
						{
							cost*=10;
							busType=bus[0][2];
							bo3=false;
						}
						break;
						default:
						{
							System.out.println("Invalid Choice");
							System.out.println("-----------------------------------------");
							continue;
						}
					}
				}
			}
			break;
		}
		int choice2=0;
		switch(choice)
		{
			case 1:
			{
				boolean bo4=true;
				while(bo4)
				{
					System.out.println("Choose Class");
					System.out.println("Enter 1 for Business Class");
					System.out.println("Enter 2 for First Class");
					System.out.println("Enter 3 for Economy");
					System.out.println("Enter your choice - ");
					choice2=sc.nextInt();
					switch (choice2)
					{
						case 1:
						{
							cost+=5000;
							flightClass=flight[1][0];
							bo4=false;
						}
						break;
						case 2:
						{
							cost+=7000;
							flightClass=flight[1][1];
							bo4=false;
						}
						break;
						case 3:
						{
							cost+=3000;
							flightClass=flight[1][2];
							bo4=false;
						}
						break;
						default:
						{
							System.out.println("Invalid Choice");
							System.out.println("----------------------------------------------");
							continue;
						}
					}
				}
			}
			break;
			case 2:
			{
				boolean bo4=true;
				while(bo4)
				{
					System.out.println("Choose Class");
					System.out.println("Enter 1 for First Ac");
					System.out.println("Enter 2 for Second Ac");
					System.out.println("Enter 3 for Third Ac");
					System.out.println("Enter your choice - ");
					choice2=sc.nextInt();
					switch (choice2)
					{
						case 1:
						{
							cost+=2500;
							trainClass=train[1][0];
							bo4=false;
						}
						break;
						case 2:
						{
							cost+=2000;
							trainClass=train[1][1];
							bo4=false;
						}
						break;
						case 3:
						{
							cost+=1000;
							trainClass=train[1][2];
							bo4=false;
						}
						break;
						default:
						{
							System.out.println("Invalid Choice");
							System.out.println("----------------------------------------------");
							continue;
						}
					}
				}
			}
			break;
			case 3:
			{
				boolean bo4=true;
				while(bo4)
				{
					System.out.println("Choose Class");
					System.out.println("Enter 1 for Ac");
					System.out.println("Enter 2 for Deluxe");
					System.out.println("Enter 3 for Non Ac");
					System.out.println("Enter your choice - ");
					choice2=sc.nextInt();
					switch (choice2)
					{
						case 1:
						{
							cost+=1250;
							busClass=bus[1][0];
							bo4=false;
						}
						break;
						case 2:
						{
							cost+=1100;
							busClass=bus[1][1];
							bo4=false;
						}
						break;
						case 3:
						{
							cost+=900;
							busClass=bus[1][2];
							bo4=false;
						}
						break;
						default:
						{
							System.out.println("Invalid Choice");
							System.out.println("----------------------------------------------");
							continue;
						}
					}
				}
			}
			break;
		}
		int choice3=0;
		int windowSeat=65,middleSeat=90,aisleSeat=45,upperBerth=78,middleBerth=89,lowerBerth=30;
		int windowSeat1=65,middleSeat1=90,aisleSeat1=45;
		switch(choice)
		{
			case 1:
			{
				boolean bo5=true;
				while(bo5)
				{
					System.out.println("Available window Seat - "+windowSeat);
					System.out.println("Available middle Seat - "+middleSeat);
					System.out.println("Available aisle Seat - "+aisleSeat);
					System.out.println("----------------------------------------------");
					System.out.println("Choose Seat Type");
					System.out.println("Enter 1 for Window");
					System.out.println("Enter 2 for Middle");
					System.out.println("Enter 3 for Aisle");
					System.out.println("Enter your choice - ");
					choice3=sc.nextInt();
					switch(choice3)
					{
						case 1:
						{
							windowSeat-=numberOfPassengers;
							System.out.println("Remaining window seats - "+windowSeat);
							cost+=800;
							flightSeat=flight[2][0];
							bo5=false;
						}
						break;
						case 2:
						{
							cost+=200;
							middleSeat-=numberOfPassengers;
							System.out.println("Remaining middle seats - "+middleSeat);
							flightSeat=flight[2][1];
							bo5=false;
						}
						break;
						case 3:
						{
							aisleSeat-=numberOfPassengers;
							System.out.println("Remaining aisle seats - "+aisleSeat);
							cost+=400;
							flightSeat=flight[2][2];
							bo5=false;
						}
						break;
						default:
						{
							System.out.println("Invalid Choice");
							System.out.println("-----------------------------------------");
							continue;
						}
					}
				}
			}
			break;
			case 2:
			{
				boolean bo5=true;
				while(bo5)
				{
					System.out.println("Available upper berth - "+upperBerth);
					System.out.println("Available middle berth - "+middleBerth);
					System.out.println("Available lower berth - "+lowerBerth);
					System.out.println("----------------------------------------------");
					System.out.println("Choose Seat Type");
					System.out.println("Enter 1 for Upper Berth");
					System.out.println("Enter 2 for Middle Berth");
					System.out.println("Enter 3 for Lower Berth");
					System.out.println("Enter your choice - ");
					choice3=sc.nextInt();
					switch(choice3)
					{
						case 3:
						{
							lowerBerth-=numberOfPassengers;
							System.out.println("Remaining lower Berths - "+lowerBerth);
							cost+=1000;
							trainBerth=train[2][0];
							bo5=false;
						}
						break;
						case 2:
						{
							cost+=500;
							middleBerth-=numberOfPassengers;
							System.out.println("Remaining middle Berths - "+middleBerth);
							trainBerth=train[2][1];
							bo5=false;
						}
						break;
						case 1:
						{
							upperBerth-=numberOfPassengers;
							System.out.println("Remaining upper Berths - "+upperBerth);
							cost+=750;
							trainBerth=train[2][2];
							bo5=false;
						}
						break;
						default:
						{
							System.out.println("Invalid Choice");
							System.out.println("-----------------------------------------");
							continue;
						}
					}
				}
			}
			break;
			case 3:
			{
				boolean bo5=true;
				while(bo5)
				{
					System.out.println("Available window Seat - "+windowSeat1);
					System.out.println("Available middle Seat - "+middleSeat1);
					System.out.println("Available aisle Seat - "+aisleSeat1);
					System.out.println("----------------------------------------------");
					System.out.println("Choose Seat Type");
					System.out.println("Enter 1 for Window");
					System.out.println("Enter 2 for Middle");
					System.out.println("Enter 3 for Aisle");
					System.out.println("Enter your choice - ");
					choice3=sc.nextInt();
					switch(choice3)
					{
						case 1:
						{
							windowSeat1-=numberOfPassengers;
							System.out.println("Remaining window seats - "+windowSeat1);
							cost+=400;
							busSeat=bus[2][0];
							bo5=false;
						}
						break;
						case 2:
						{
							cost+=200;
							middleSeat1-=numberOfPassengers;
							System.out.println("Remaining middle seats - "+middleSeat1);
							busSeat=bus[2][1];
							bo5=false;
						}
						break;
						case 3:
						{
							aisleSeat1-=numberOfPassengers;
							System.out.println("Remaining aisle seats - "+aisleSeat1);
							cost+=400;
							busSeat=bus[2][2];
							bo5=false;
						}
						break;
						default:
						{
							System.out.println("Invalid Choice");
							System.out.println("-----------------------------------------");
							continue;
						}
					}
				}
			}
			break;
		}
		cost*=numberOfPassengers;
		System.out.println("Total cost = "+cost);
	}
	void hotelChoice()
	{
		int hotel1=0;
		String array[][]=new String[8][4];
		array[0][0]="Lemon Tree";
		array[0][1]="Marriot";
		array[0][2]="Wyndham";
		array[0][3]="Courtyard";
		array[1][0]="Royal Orchid";
		array[1][1]="Blue Ocean";
		array[1][2]="The Pride";
		array[1][3]="The Rialto";
		array[2][0]="Gokulam";
		array[2][1]="Ginger";
		array[2][2]="Goutham Manor";
		array[2][3]="The Residency";
		array[3][0]="Roseate House";
		array[3][1]="Orania B&B";
		array[3][2]="Hilton Garden";
		array[3][3]="Goldfinch";
		array[4][0]="Purple Leaf";
		array[4][1]="Minerva Grand";
		array[4][2]="Swagath";
		array[4][3]="Hampshire Plaza";
		array[5][0]="The Park";
		array[5][1]="Treebo Tryst";
		array[5][2]="Hindusthan";
		array[5][3]="The Lindsay";
		array[6][0]="Radisson";
		array[6][1]="ITC Grand";
		array[6][2]="Residency Park";
		array[6][3]="Bentleys";
		array[7][0]="Parc Estique";
		array[7][1]="Orchid";
		array[7][2]="The Fern";
		array[7][3]="Novotel";
		if (arrival.equals("Ahmedabad"))
		{
			boolean bo9=true;
			while(bo9)
			{
				System.out.println("Choose from available hotels in Ahmedabad :");
				System.out.println("Enter 1 for "+array[0][0]);
				System.out.println("Enter 2 for "+array[0][1]);
				System.out.println("Enter 3 for "+array[0][2]);
				System.out.println("Enter 4 for "+array[0][3]);
				System.out.println("Enter your choice - ");
				hotel1=sc.nextInt();
				switch(hotel1)
				{
					case 1:
					{
						hotelName=array[0][0];
						bo9=false;
					}
					break;
					case 2:
					{
						hotelName=array[0][1];
						bo9=false;
					}
					break;
					case 3:
					{
						hotelName=array[0][2];
						bo9=false;
					}
					break;
					case 4:
					{
						hotelName=array[0][3];
						bo9=false;
					}
					break;
					default:
					{
						System.out.println("Invalid Choice");
						System.out.println("----------------------------------------");
						continue;
					}
				}
			}
		}
		else if (arrival.equals("Bangalore"))
		{
			boolean bo9=true;
			while(bo9)
			{
				System.out.println("Choose from available hotels in Bangalore :");
				System.out.println("Enter 1 for "+array[1][0]);
				System.out.println("Enter 2 for "+array[1][1]);
				System.out.println("Enter 3 for "+array[1][2]);
				System.out.println("Enter 4 for "+array[1][3]);
				System.out.println("Enter your choice - ");
				hotel1=sc.nextInt();
				switch(hotel1)
				{
					case 1:
					{
						hotelName=array[1][0];
						bo9=false;
					}
					break;
					case 2:
					{
						hotelName=array[1][1];
						bo9=false;
					}
					break;
					case 3:
					{
						hotelName=array[1][2];
						bo9=false;
					}
					break;
					case 4:
					{
						hotelName=array[1][3];
						bo9=false;
					}
					break;
					default:
					{
						System.out.println("Invalid Choice");
						System.out.println("----------------------------------------");
						continue;
					}
				}
			}
		}
		else if (arrival.equals("Chennai"))
		{
			boolean bo9=true;
			while(bo9)
			{
				System.out.println("Choose from available hotels in Chennai :");
				System.out.println("Enter 1 for "+array[2][0]);
				System.out.println("Enter 2 for "+array[2][1]);
				System.out.println("Enter 3 for "+array[2][2]);
				System.out.println("Enter 4 for "+array[2][3]);
				hotel1=sc.nextInt();
				switch(hotel1)
				{
					case 1:
					{
						hotelName=array[2][0];
						bo9=false;
					}
					break;
					case 2:
					{
						hotelName=array[2][1];
						bo9=false;
					}
					break;
					case 3:
					{
						hotelName=array[2][2];
						bo9=false;
					}
					break;
					case 4:
					{
						hotelName=array[2][3];
						bo9=false;
					}
					break;
					default:
					{
						System.out.println("Invalid Choice");
						System.out.println("----------------------------------------");
						continue;
					}
				}
			}
		}
		else if (arrival.equals("Delhi"))
		{
			boolean bo9=true;
			while(bo9)
			{
				System.out.println("Choose from available hotels in Delhi :");
				System.out.println("Enter 1 for "+array[3][0]);
				System.out.println("Enter 2 for "+array[3][1]);
				System.out.println("Enter 3 for "+array[3][2]);
				System.out.println("Enter 4 for "+array[3][3]);
				hotel1=sc.nextInt();
				switch(hotel1)
				{
					case 1:
					{
						hotelName=array[3][0];
						bo9=false;
					}
					break;
					case 2:
					{
						hotelName=array[3][1];
						bo9=false;
					}
					break;
					case 3:
					{
						hotelName=array[3][2];
						bo9=false;
					}
					break;
					case 4:
					{
						hotelName=array[3][3];
						bo9=false;
					}
					break;
					default:
					{
						System.out.println("Invalid Choice");
						System.out.println("----------------------------------------");
						continue;
					}
				}
			}
		}
		else if (arrival.equals("Hyderabad"))
		{
			boolean bo9=true;
			while(bo9)
			{
				System.out.println("Choose from available hotels in Hyderabad :");
				System.out.println("Enter 1 for "+array[4][0]);
				System.out.println("Enter 2 for "+array[4][1]);
				System.out.println("Enter 3 for "+array[4][2]);
				System.out.println("Enter 4 for "+array[4][3]);
				System.out.println("Enter your choice - ");
				hotel1=sc.nextInt();
				switch(hotel1)
				{
					case 1:
					{
						hotelName=array[4][0];
						bo9=false;
					}
					break;
					case 2:
					{
						hotelName=array[4][1];
						bo9=false;
					}
					break;
					case 3:
					{
						hotelName=array[4][2];
						bo9=false;
					}
					break;
					case 4:
					{
						hotelName=array[4][3];
						bo9=false;
					}
					break;
					default:
					{
						System.out.println("Invalid Choice");
						System.out.println("----------------------------------------");
						continue;
					}
				}
			}
		}
		else if (arrival.equals("Kolkata"))
		{
			boolean bo9=true;
			while(bo9)
			{
				System.out.println("Choose from available hotels in Kolkata :");
				System.out.println("Enter 1 for "+array[5][0]);
				System.out.println("Enter 2 for "+array[5][1]);
				System.out.println("Enter 3 for "+array[5][2]);
				System.out.println("Enter 4 for "+array[5][3]);
				System.out.println("Enter your choice - ");
				hotel1=sc.nextInt();
				switch(hotel1)
				{
					case 1:
					{
						hotelName=array[5][0];
						bo9=false;
					}
					break;
					case 2:
					{
						hotelName=array[5][1];
						bo9=false;
					}
					break;
					case 3:
					{
						hotelName=array[5][2];
						bo9=false;
					}
					break;
					case 4:
					{
						hotelName=array[5][3];
						bo9=false;
					}
					break;
					default:
					{
						System.out.println("Invalid Choice");
						System.out.println("----------------------------------------");
						continue;
					}
				}
			}
		}
		else if (arrival.equals("Mumbai"))
		{
			boolean bo9=true;
			while(bo9)
			{
				System.out.println("Choose from available hotels in Mumbai : ");
				System.out.println("Enter 1 for "+array[6][0]);
				System.out.println("Enter 2 for "+array[6][1]);
				System.out.println("Enter 3 for "+array[6][2]);
				System.out.println("Enter 4 for "+array[6][3]);
				System.out.println("Enter your choice - ");
				hotel1=sc.nextInt();
				switch(hotel1)
				{
					case 1:
					{
						hotelName=array[6][0];
						bo9=false;
					}
					break;
					case 2:
					{
						hotelName=array[6][1];
						bo9=false;
					}
					break;
					case 3:
					{
						hotelName=array[6][2];
						bo9=false;
					}
					break;
					case 4:
					{
						hotelName=array[6][3];
						bo9=false;
					}
					break;
					default:
					{
						System.out.println("Invalid Choice");
						System.out.println("----------------------------------------");
						continue;
					}
				}
			}
		}
		else if (arrival.equals("Pune"))
		{
			boolean bo9=true;
			while(bo9)
			{
				System.out.println("Choose from available hotels in Pune :");
				System.out.println("Enter 1 for "+array[7][0]);
				System.out.println("Enter 2 for "+array[7][1]);
				System.out.println("Enter 3 for "+array[7][2]);
				System.out.println("Enter 4 for "+array[7][3]);
				System.out.println("Enter your choice - ");
				hotel1=sc.nextInt();
				switch(hotel1)
				{
					case 1:
					{
						hotelName=array[7][0];
						bo9=false;
					}
					break;
					case 2:
					{
						hotelName=array[7][1];
						bo9=false;
					}
					break;
					case 3:
					{
						hotelName=array[7][2];
						bo9=false;
					}
					break;
					case 4:
					{
						hotelName=array[7][3];
						bo9=false;
					}
					break;
					default:
					{
						System.out.println("Invalid Choice");
						System.out.println("----------------------------------------");
						continue;
					}
				}
			}
		}
	}
	void billGeneration()
	{
		String trans=null,type=null,seat=null,temp1=null;
		System.out.println("******************************************************************************");
		System.out.println("                                Make My Trip ");
		System.out.println("               --------------------------------------------------- ");
		System.out.println("                               PASSENGER DETAILS ");
		System.out.println();
		System.out.println("   Passenger Name          - " + Full_Name);
		System.out.println();
		System.out.println("   Passenger Mobile Number - " + Mobile_number);
		System.out.println();
		System.out.println("   Number of Passenger     - " + numberOfPassengers);
		System.out.println();
		System.out.println("   Date of Journey         - " + dateOfJourney);
		System.out.println();
		System.out.println("   Departure form          - " + departure);
		System.out.println();
		System.out.println("   Arrival at              - "+ arrival);
		System.out.println("               --------------------------------------------------- ");
		System.out.println("                               TRAVELLING DETAILS ");
		System.out.println();
		if (choiceOfTransport.equals("Flight"))
		{
			System.out.println("   Mode of Transport       - "+"Flight");
			System.out.println();
			System.out.println("   Type of Transport       - "+flightCompany);
			System.out.println();
			System.out.println("   Class                   - "+flightClass);
			System.out.println();
			System.out.println("   Seat                    - "+flightSeat);
			System.out.println();
		}
		else if (choiceOfTransport.equals("Train"))
		{
			System.out.println("   Mode of Transport       - "+"Train");
			System.out.println();
			System.out.println("   Type of Transport       - "+trainType);
			System.out.println();
			System.out.println("   Class                   - "+trainClass);
			System.out.println();
			System.out.println("   Seat                    - "+trainBerth);
			System.out.println();
		}
		else if (choiceOfTransport.equals("Bus"))
		{
			System.out.println("   Mode of Transport       - "+"Bus");
			System.out.println();
			System.out.println("   Type of Transport       - "+busType);
			System.out.println();
			System.out.println("   Class                   - "+busClass);
			System.out.println();
			System.out.println("   Seat                    - "+busSeat);
			System.out.println();
		}
		System.out.println("               --------------------------------------------------- ");
		System.out.println("                               HOTEL DETAILS ");
		System.out.println();
		System.out.println("   City                    - "+arrival);
		System.out.println();
		System.out.println("   Hotel Name              - "+hotelName);
		System.out.println();
		System.out.println("   Number of Days          - "+dayStay);
		System.out.println();
		System.out.println("   Hotel Bill              - "+"Rs. "+totalBill);
		System.out.println();
		System.out.println("               --------------------------------------------------- ");
		System.out.println("                               BILL DETAILS ");
		System.out.println();
		System.out.println("   Travelling Bill         - "+"Rs. "+cost);
		System.out.println();
		System.out.println("   Hotel Bill              - "+"Rs. "+totalBill);
		System.out.println();
		finalBill=cost+totalBill;
		System.out.println("   Total Bill              - "+"Rs. "+finalBill);
		System.out.println();
		System.out.println("   Taxes                   - "+"18%");
		System.out.println();
		System.out.println("   Bill(inicluding Taxes)  - "+"Rs. "+finalBill);
		System.out.println();
		finalBill=finalBill+(finalBill*0.18);
		System.out.println("   Discount                - "+"5%");
		System.out.println();
		finalBill=finalBill-(finalBill*0.05);
		System.out.println("   Final Bill              - "+"Rs. "+finalBill);
		System.out.println();
		System.out.println("******************************************************************************");
		payment();
	}
	void payment()
	{
		boolean bo10=true;
		while(bo10)
		{
			System.out.println("Enter 'Y' for proceeding with payment ");
			System.out.println("Enter 'N' for cancelling ");
			char pay=sc.next().charAt(0);
			if (pay=='Y' || pay=='y')
			{
				boolean bo12=true;
				while (bo12)
				{
					System.out.println("Choose Payment option :");
					System.out.println("Enter 1 for Debit Card ");
					System.out.println("Enter 2 for Credit Card ");
					System.out.println("Enter 3 for Paytm ");
					System.out.println("Enter 4 for UPI ");
					System.out.println("Enter 5 for Google Pay ");
					System.out.println("Enter Your Choice - ");
					int pay1=sc.nextInt();
					switch(pay1)
					{
						case 1:
						{
							boolean bo11=true;
							while (bo11)
							{
								System.out.println("Enter Debit Card Number (16 Digit)");
								String debit=sc.next();
								if (debit.length()==16)
								{
									int i1=0;
									for( i1=0;i1<debit.length();i1++)
									{
										if(debit.charAt(i1)>='0' && debit.charAt(i1)<='9')
										{
											continue;
										}
										else
										{
											break;
										}
									}
									if (i1==debit.length())
									{
										System.out.println("Booking Successfull !!");
										bo12=false;
										bo11=false;
										bo10=false;
									}
								}
								else 
								{
									System.out.println("Invalid Number");
									continue;
								}
							}
						}
						break;
						case 2:
						{
							boolean bo11=true;
							while (bo11)
							{
								System.out.println("Enter Credit Card Number (16 Digit)");
								String credit=sc.next();
								if (credit.length()==16)
								{
									int i1=0;
									for( i1=0;i1<credit.length();i1++)
									{
										if(credit.charAt(i1)>='0' && credit.charAt(i1)<='9')
										{
											continue;
										}
										else
										{
											break;
										}
									}
									if (i1==credit.length())
									{
										System.out.println("Booking Successfull !!");
										bo12=false;
										bo11=false;
										bo10=false;
									}
								}
								else 
								{
									System.out.println("Invalid Number");
									continue;
								}
							}
						}
						break;
						case 3:
						{
							boolean bo11=true;
							while (bo11)
							{
								System.out.println("Enter UPI number for Paytm");
								String paytm=sc.next();
								if (paytm.length()==10)
								{
									int i1=0;
									for( i1=0;i1<paytm.length();i1++)
									{
										if(paytm.charAt(i1)>='0' && paytm.charAt(i1)<='9')
										{
											continue;
										}
										else
										{
											break;
										}
									}
									if (i1==paytm.length())
									{
										System.out.println("Booking Successfull !!");
										bo12=false;
										bo11=false;
										bo10=false;
									}
								}
								else 
								{
									System.out.println("Invalid Number");
									continue;
								}
							}
						}
						break;
						case 4:
						{
							boolean bo11=true;
							while (bo11)
							{
								System.out.println("Enter UPI number ");
								String upi=sc.next();
								if (upi.length()==10)
								{
									int i1=0;
									for( i1=0;i1<upi.length();i1++)
									{
										if(upi.charAt(i1)>='0' && upi.charAt(i1)<='9')
										{
											continue;
										}
										else
										{
											break;
										}
									}
									if (i1==upi.length())
									{
										System.out.println("Booking Successfull !!");
										bo12=false;
										bo11=false;
										bo10=false;
									}
								}
								else 
								{
									System.out.println("Invalid Number");
									continue;
								}
							}
						}
						break;
						case 5:
						{
							boolean bo11=true;
							while (bo11)
							{
								System.out.println("Enter UPI number for Google Pay");
								String gpay=sc.next();
								if (gpay.length()==10)
								{
									int i1=0;
									for( i1=0;i1<gpay.length();i1++)
									{
										if(gpay.charAt(i1)>='0' && gpay.charAt(i1)<='9')
										{
											continue;
										}
										else
										{
											break;
										}
									}
									if (i1==gpay.length())
									{
										System.out.println("Booking Successfull !!");
										bo12=false;
										bo11=false;
										bo10=false;
									}
								}
								else 
								{
									System.out.println("Invalid Number");
									continue;
								}
							}
						}
						break;
						default:
						{
							System.out.println("Invalid Input");
							continue;
						}
					}
				}
			}
			else if(pay=='N' || pay=='n')
			{
				bo10=false;
			}
			else
			{
				System.out.println("Invalid Choice");
				continue;
			}
		}
	}
}