import java.util.Scanner;
import java.util.Random;
import java.util.Date;
import java.util.InputMismatchException;
import java.text.SimpleDateFormat;

public class LoaningSystem1 {
	
	@SuppressWarnings("resource")
	
	public static void main(String[] args) {
		
		String accInfos[][] = new String[50][10];
		String paymentDateTime[][] = new String[50][1000];
		String loanDateTime[][] = new String[50][2];
		double transDetails[][] = new double[50][10];
		int payRef[][] = new int[50][1000];
		double payment[][] = new double [50][1000];
		int paymentNow = 0;
		int paymentCount1[][] = new int[50][1000];

		Date currentDate = new Date();
		SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm");
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");

		
		Random gen = new Random();
		System.out.println("++------------------------------------------------------------------+ ");
		System.out.println("||    --    -----    --     --  -- -- --  --  ----                  |          ");
		System.out.println("||    ||    || ||   /__\\\\   | \\ || || | \\ || || ===                 |");
		System.out.println("||    ||__  ||_||  //   \\\\  ||\\\\|| || ||\\\\|| ||___||                |  ");
		System.out.println("||    '---' '---' '-     -' '- '-' -- '- '-' '----'     	    |  ");
		System.out.println("||                  ------- --  -- ------- ------ ------ --    --   |");
		System.out.println("||                  '__---' ''--'' '__---' '-,,-' | ===' | \\  / |   |  ");
		System.out.println("||                   ---' |   ||    ---' |   ||   | ===, ||\\\\//||   |      ");
		System.out.println("||                  '-----'   --   '-----'   --   -----' -- -- --   |     ");
		System.out.println("++==================================================================+ ");
		System.out.println("Welcome to Loaning System, to proceed please create an account first.\n");
		
		
		int regCount = 0;
		do {																														// Register
			Scanner sc = new Scanner(System.in);
			
			int loopCounter1 = 0;
			
			String userN, userP, firstN, lastN, addr, eMail, pNumber;
			
            System.out.println(".-------------------------------------------------------------------.");
			System.out.println("|  :: Sign Up                                                 _ X   |");
            System.out.println("'-------------------------------------------------------------------'");

			System.out.println("Please enter your account information.\n");
            
			System.out.print("First name: ");
			firstN = sc.nextLine();
			
			System.out.print("Last name: ");
			lastN = sc.nextLine();
			
			System.out.print("Address: ");
			addr = sc.nextLine();
			
			System.out.print("Email Address: ");
			eMail = sc.nextLine();
			
			System.out.print("Phone number: ");
			pNumber = sc.nextLine();

			System.out.println(" ");
			do {
				int x = 0;

				System.out.print("Desired Username: ");
				userN = sc.nextLine();

				for (int k = 0; k < accInfos.length; k++){
					if (userN.equals(accInfos[k][0])){
						x = 1;
						System.out.println("Username has already been taken.");
						break;
					} else {
						continue;
					}
				}
				if (x == 0){
					break;
				} else {
					continue;
				}
				
			} while(true);
				
			
			System.out.print("Desired Password: ");
			userP = sc.nextLine();

			int userID = 2000 + regCount;
			String userID1 = "0" + Integer.toString(userID);

			
			accInfos[regCount][0] = userN;
			accInfos[regCount][1] = firstN;
			accInfos[regCount][2] = lastN;
			accInfos[regCount][3] = addr;
			accInfos[regCount][4] = eMail;
			accInfos[regCount][5] = pNumber;
			accInfos[regCount][6] = userP;
			accInfos[regCount][7] = userID1;

			

			regCount++;
			
			do {																													// Login
				System.out.println("====================================================================");
				System.out.println("   :: Accounts                                                      "); 
                System.out.println("====================================================================");
                System.out.print("\n [1] to Register \n [2] to Log In (User) \n [3] to Log In (Admin) \n [4] to exit \n\n=> Key: ");
				char choice1 = sc.next().charAt(0);
				
				switch (choice1) {
					
					case '1':
						loopCounter1++;
						break;
					case '2':
						Scanner sc1 = new Scanner(System.in);
						
						int loopCounter2 = 0;
						System.out.println("====================================================================");
						System.out.println("   :: Log In                                                         ");
						System.out.println("====================================================================");
						System.out.print("Enter your username\t\t: ");
						userN = sc1.nextLine();
						System.out.print("Enter your password\t\t: ");
						userP = sc1.nextLine();
                        
						
						for (int i = 0; i < accInfos.length; i++) {
							
							
							if (userN.equals(accInfos[i][0]) && userP.equals(accInfos[i][6])){
								
								System.out.println("\nYou have successfully logged in!\n");
								
								do {																								// Account Details
									Scanner sc2 = new Scanner(System.in);
									
									int accNow = i;
									
									for (int j = 0; j < paymentCount1.length; j++){
										if (payRef[accNow][j] == 0){
											paymentNow = j;
											break;
										} else {
											continue;
										}
									}
									

						            System.out.println("====================================================================");
									System.out.println("   :: Account Details                                                ");
                                    System.out.println("====================================================================");
									System.out.println("User ID\t\t\t\t|" + accInfos[accNow][7]);
									System.out.println("Name\t\t\t\t|" + accInfos[accNow][2] + ", " + accInfos[accNow][1]);
									System.out.println("Address\t\t\t\t|" + accInfos[accNow][3]);
									System.out.println("Email\t\t\t\t|" + accInfos[accNow][4]);
									System.out.println("Phone Number\t\t\t|" + accInfos[accNow][5]);
                                    System.out.println("---------------------------------------------------");
									if (transDetails[accNow][6] <= 0.0) {
										System.out.println("Balance\t\t\t\t: " + 0.0);
									} else if (transDetails[accNow][6] >= 0.01){
										System.out.printf("Balance\t\t\t\t: %.2f", transDetails[accNow][6]);
										if (transDetails[accNow][5] == 0) {
											System.out.println("\nWeeks remaining\t\t\t: " + Math.round(transDetails[accNow][8]));
											if (transDetails[accNow][8] == 0) {
												
											} else {
												System.out.printf("\nTo pay for next week\t\t: %.2f", transDetails[accNow][7]);
												System.out.println(" ");
											}
											
										} else {
											System.out.println("\nMonths remaining\t\t: " + Math.round(transDetails[accNow][8]));
											if (transDetails[accNow][8] == 0) {
												
											} else {
												System.out.printf("To pay for next month\t\t: %.2f", transDetails[accNow][7]);
												System.out.println(" ");
											}
											
										}
									}
									
									//System.out.println("\n====================================================================");
									//System.out.println("   :: Utilities                                                      ");
									//System.out.println("====================================================================");
									System.out.println("--------------------------------------------------------------------");
									System.out.println("\n>>> Utilities: ");
                                    System.out.println("\n[1] Loan \n[2] Pay \n[3] Check Details \n[4] Log Out\n");
									System.out.print("=> Key: ");
									
									char choice2 = sc2.next().charAt(0);
									
									switch (choice2) {																							// Utilities choices
										case '1':																								//Loan case
											
											if (transDetails[accNow][6] != 0) {
												Scanner sc9 = new Scanner(System.in);
												System.out.println("--------------------------------------------------------------------");
                                                System.out.println("You still have an outstanding balance. \nFully pay first before loaning again.");
												System.out.println("\nPress [ENTER] to continue");
												
												String choice8 = sc9.nextLine();
												
												if (choice8.equals("")) {
													break;
												} else {
													break;
												}
												
												
											} else {
												double rate = 0.05;
												double loan, total, mrate, weeks, weeklies, monthlies;
												int duration;
												
												Scanner sc3 = new Scanner(System.in);
												
                                                System.out.println("====================================================================");
												System.out.println("   :: Loan                                                          ");
                                                System.out.println("====================================================================");
												System.out.print("Enter desired  amount\t\t: ");
												loan = sc3.nextDouble();
										        System.out.print("Enter Payment Duration in Months: "); 

												try {
													duration = sc3.nextInt();
												} catch (InputMismatchException ex){
													System.out.println("\nSystem error: Input digits only.");
													break;
												}

										        System.out.println("\nPayment Option: ");
										        System.out.println("\n[W] Weekly Payment");
										        System.out.println("[M] Monthly Payment");
										        System.out.println("[ANY KEY] to Cancel");
										        System.out.print("\n=> Option\t\t\t: ");
										        
										        total = (Math.round((((loan * rate) * duration) + loan) * 100)/100.0); 
										        mrate = (Math.round((loan * rate) * 100)/100.0);
										        weeks = duration * 4;
										        weeklies = (Math.round((total/weeks) * 100)/100.0);
										        monthlies = (Math.round((total/duration) * 100)/100.0);		
										        char choice3;
												do {
													choice3 = sc3.next().charAt(0);
												} while (Character.isDigit(choice3));
										        
										        
										        if (Character.toUpperCase(choice3) == 'W') {
										        	System.out.println("--------------------------------------------------------------------");
											        System.out.println("   :: Transaction Details                                            ");
											        System.out.println("--------------------------------------------------------------------");
											        System.out.println("Amount Loaned\t\t\t: " + loan);
											        System.out.println("Interest per month\t\t: " + mrate);
											        System.out.println("Total amount with interest\t: " + total);
											        System.out.println("Weekly payment for " + duration + " months\t: " + weeklies);
											        System.out.println("--------------------------------------------------------------------");
											        System.out.println("Confirm Transaction?\n\n[Y] Continue\n[ANY KEY] to cancel");
											        System.out.print("\n=> Key: ");
											        
											        char choice7 = sc3.next().charAt(0);
											        
											        if (Character.toUpperCase(choice7) == 'Y') {
											        	transDetails[accNow][0] = loan;
											            transDetails[accNow][1] = mrate;
											            transDetails[accNow][2] = total;
											            transDetails[accNow][3] = duration;
											            transDetails[accNow][4] = weeklies;  
											            transDetails[accNow][5] = 0;
											            transDetails[accNow][6] = total;
											            transDetails[accNow][7] = weeklies;
											            transDetails[accNow][8] = weeks;
														transDetails[accNow][9] = gen.nextInt(100000, 200000);
														loanDateTime[accNow][0] = dateFormat.format(currentDate);
														loanDateTime[accNow][1] = timeFormat.format(currentDate);
                                                        System.out.println("--------------------------------------------------------------------");
														System.out.println("Prompt: Loan success(" +Math.round(transDetails[accNow][9]) + " " + loanDateTime[accNow][0] + " " + loanDateTime[accNow][1] + "), \nproceeding to account details...");
											        	
											        } else {
											        	System.out.println("--------------------------------------------------------------------");
                                                        System.out.println("Transaction cancelled, proceeding to account details...");
											        }
										        } else if (Character.toUpperCase(choice3) == 'M'){
										        	System.out.println("--------------------------------------------------------------------");
											        System.out.println("   :: Transaction Details                                           ");
											        System.out.println("--------------------------------------------------------------------");
											        System.out.println("Amount Loaned\t\t\t: " + loan);
											        System.out.println("Interest per month\t\t: " + mrate);
											        System.out.println("Total amount with interest\t: " + total);
											        System.out.println("Monthly payment for " + duration + " months\t: " + monthlies);
											        System.out.println("--------------------------------------------------------------------");
											        System.out.println("Confirm Transaction?\n[Y]Continue\n[ANY KEY] to cancel\n");
											        System.out.print("=> Key: ");
											        char choice8 = sc3.next().charAt(0);
											        
											        if (Character.toUpperCase(choice8) == 'Y') {
											        	transDetails[accNow][0] = loan;
											            transDetails[accNow][1] = mrate;
											            transDetails[accNow][2] = total;
											            transDetails[accNow][3] = duration;
											            transDetails[accNow][4] = monthlies;
											            transDetails[accNow][5] = 1;
											            transDetails[accNow][6] = total;
											            transDetails[accNow][7] = monthlies;
											            transDetails[accNow][8] = duration;
														transDetails[accNow][9] = gen.nextInt(100000, 200000);
														loanDateTime[accNow][0] = dateFormat.format(currentDate);
														loanDateTime[accNow][1] = timeFormat.format(currentDate);
											        	//System.out.println("--------------------------------------------------------------------");
														
                                                        System.out.println("\nPrompt: Loan success(" +Math.round(transDetails[accNow][9]) + " " + loanDateTime[accNow][0] + " " + loanDateTime[accNow][1] + "), \nproceeding to account details...");
											        } else {
											        	System.out.println("--------------------------------------------------------------------");
                                                        System.out.println("Prompt: Transaction cancelled, proceeding to account details...");
											        }
										        } else {
										        	System.out.println("\nTransaction cancelled...\n");
										        	break;
										        }
												break;
											}	
											//------------------------------------------------------------------------------------------------			
										case '2':																										//Payment case
                                            System.out.println("====================================================================");
											System.out.println("   :: Payment                                                       ");
                                            System.out.println("====================================================================");
											
											Scanner sc10 = new Scanner(System.in);
											
											if (transDetails[accNow][6] == 0) {
												System.out.println("--------------------------------------------------------------------");
                                                System.out.println("You don't have any loan yet.\nPress [ENTER] to continue");
                                                
                                                String choice11 = sc10.nextLine();
                                                
                                                if (choice11.equals("")) {
                                                	break;
                                                } else {
                                                	break;
                                                }
                                                
											} else {
												String paymentChoice, paymentInterest;
												
												if(transDetails[accNow][5] == 0) {
													paymentChoice = "week/s";
													
												} else{
													paymentChoice = "month/s";
													
												}

												if (transDetails[accNow][8] == 0){
													System.out.print("Enter payment amount: ");
													double payAmount0 = sc.nextDouble();
													if (payAmount0 == transDetails[accNow][6]){
														transDetails[accNow][6] -= payAmount0;
														System.out.println("\nYou have successfully paid your loan!");
													} else if (payAmount0 > transDetails[accNow][6]) {
														System.out.println("\nSystem error: You entered an excessive amount.");
														break;
													} else {
														double lapseAmt0 = transDetails[accNow][6] - payAmount0;
														double lapseWithInt0;
														if (transDetails[accNow][5] == 0) {
															lapseWithInt0 = lapseAmt0 * 1.015;
															transDetails[accNow][6] = (Math.round(lapseWithInt0 * 100)/100) ;
															System.out.println("Your balance has been adjusted to " + transDetails[accNow][6] + " with 1.5% interest.");
														} else {
															lapseWithInt0 = lapseAmt0 * 1.035;
															transDetails[accNow][6] = (Math.round(lapseWithInt0 * 100)/100) ;
															System.out.println("Your balance has been adjusted to " + transDetails[accNow][6] + " with 3.5% interest.");
														}
													}

													payment[accNow][paymentNow] = payAmount0;
													payRef[accNow][paymentNow] = gen.nextInt(100000, 200000);
													paymentDateTime[accNow][paymentNow] = timeFormat.format(currentDate) + " " + dateFormat.format(currentDate);
													System.out.println("\nReference no. " + payRef[accNow][paymentNow]);
													System.out.println("Date: " + dateFormat.format(currentDate));
													System.out.println("Time: " + timeFormat.format(currentDate));
													paymentNow++;
													System.out.print("\nPress [ENTER] to continue.");
													String enterAny0 = sc10.nextLine();
													break;


												} else {
													System.out.print("Enter payment amount: ");
													double payAmount = sc.nextDouble();

													if(payAmount > transDetails[accNow][6]) {
														System.out.println("\nSystem error: You entered an excessive amount.");
														break;
													} else if(payAmount == transDetails[accNow][6]) {
														System.out.println("You have totally paid your balance of " + payAmount + ".");
													} else if (payAmount < transDetails[accNow][6]) {
														if(payAmount == transDetails[accNow][4]){
															transDetails[accNow][8]--;
															System.out.println("You successfully paid " + payAmount + " that amounts for 1 " + paymentChoice + ".");
														} else {
															if(payAmount == transDetails[accNow][7]){
																transDetails[accNow][8]--;
																transDetails[accNow][7] = transDetails[accNow][4];
																System.out.println("You successfully paid " + payAmount + " that amounts for 1 " + paymentChoice + ".");
															} else if (payAmount < transDetails[accNow][7]) {
																double lapseAmt = transDetails[accNow][7] - payAmount;
																double lapseWithInt;
																if(transDetails[accNow][5] == 0) {
																	lapseWithInt = lapseAmt * 1.015;
																} else {
																	lapseWithInt = lapseAmt * 1.035;
																}
																transDetails[accNow][7] += lapseWithInt;
																transDetails[accNow][8]--;
																System.out.println("You paid an amount of " + payAmount + ".");
																System.out.println("Your next payment will be adjusted to " + transDetails[accNow][7]);
															} else if (payAmount > transDetails[accNow][7]){
																double extraAmt = payAmount - transDetails[accNow][7];
																transDetails[accNow][8]--;
																if (extraAmt < transDetails[accNow][4]){
																	transDetails[accNow][7] = transDetails[accNow][4] - extraAmt;
																	System.out.println("You successfully paid " + payAmount + " that amounts for 1 " + paymentChoice + ".");
																} else if (payAmount == transDetails[accNow][7]) {
																	transDetails[accNow][8]--;
																	transDetails[accNow][7] = transDetails[accNow][4];
																	System.out.println("You successfully paid " + payAmount + " that amounts for 2 " + paymentChoice + ".");
																} else if (payAmount > transDetails[accNow][4]) {
																	int minusWeeks1 = (int) (extraAmt / transDetails[accNow][4]);
																	transDetails[accNow][8] -= minusWeeks1;
																	double minusPayment = extraAmt % transDetails[accNow][4];
																	transDetails[accNow][7] = transDetails[accNow][4] - minusPayment;
																	int minusWeeksAct = minusWeeks1 + 2;
																	System.out.println("You successfully paid " + payAmount + " that amounts for " + minusWeeksAct + " " + paymentChoice + ".");
																}
															}
														}
													}
													transDetails[accNow][6] -= payAmount;
													payment[accNow][paymentNow] = payAmount;
													payRef[accNow][paymentNow] = gen.nextInt(100000, 200000);
													paymentDateTime[accNow][paymentNow] = timeFormat.format(currentDate) + " " + dateFormat.format(currentDate);
													System.out.println("\nReference no. " + payRef[accNow][paymentNow]);
													System.out.println("Date: " + dateFormat.format(currentDate));
													System.out.println("Time: " + timeFormat.format(currentDate));
													paymentNow++;
													System.out.print("\nPress [ENTER] to continue.");
													String enterAny = sc10.nextLine();
													break;
												}
												
													
												 //So I stopped here, I still have to fix the bug when balance is less than the weekly payment/payment this week. And the monthlies also.
													 
												
											}
											
											
										case '3':																												// check details case										
											if (transDetails[accNow][0] != 0) {
												Scanner sc4 = new Scanner(System.in);
												
                                                System.out.println("--------------------------------------------------------------------");
												System.out.println("   :: Transaction Details                                           ");
                                                System.out.println("--------------------------------------------------------------------");
												System.out.println("Reference ID\t\t\t: " + Math.round(transDetails[accNow][9]));
												System.out.println("Amount Loaned\t\t\t: " + transDetails[accNow][0]);
									            System.out.printf("\nInterest per month\t\t: %.2f" , transDetails[accNow][1]);
									            System.out.printf("\nTotal amount with interest\t: %.2f" , transDetails[accNow][2]);
									            System.out.println("\n");
									            if (transDetails[accNow][5] == 1) {
									            	System.out.println("------------------------------------------------");
                                                    System.out.println("Monthly payment for " + Math.round(transDetails[accNow][3]) + " months\t: " + (Math.round(transDetails[accNow][4] * 100)/100.0));
									            } else {
									            	System.out.println("------------------------------------------------");
                                                    System.out.println("Weekly payment for " + Math.round(transDetails[accNow][3]) + " months\t: " + (Math.round(transDetails[accNow][4] * 100)/100.0));
									            }
									            
									            System.out.println("\n=> Press [ENTER] to go back");
									            
									            String choice5 = sc4.nextLine();
												
									            if (choice5.equals("")) {
									            	System.out.println("--------------------------------------------------------------------");
                                                    System.out.println("Proceeding back to the account details...");
									            } else {
									            	System.out.println("--------------------------------------------------------------------");
                                                    System.out.println("Proceeding back to the account details...");
									            }
											} else {
												Scanner sc5 = new Scanner(System.in);
												System.out.println("--------------------------------------------------------------------");
                                                System.out.println("You don't have outstanding loan.\nPress [ENTER] to go back.");
												String choice6 = sc5.nextLine();
												if (choice6.equals("")){
													continue;
												} else {
													continue;
												}
											}
												
								            
											break;
											
										case '4':
											loopCounter2++;
											break;
										default:
											System.out.println("Invalid input! Please try again.");
											continue;
									}
									
								} while (loopCounter2 == 0);								
							} else {
								continue;
							}
						}
						
						if (loopCounter2 == 0) {
                            System.out.println("\nIncorrect username or password!");
						} else {
                            System.out.println("You have successfully logged out!");
						}
						break;
						
					case '3':
						    
						    String amPass;
						    int loopCounter12 = 0;
						    Scanner sc11 = new Scanner(System.in);
						    System.out.println("--------------------------------------------------------------------");
						    System.out.println("    :: Admin Login");
						    System.out.println("--------------------------------------------------------------------");

						    System.out.print("\nEnter Password: ");
						    amPass = sc11.nextLine();
						    
						    if (amPass.equals("admin69420")){
						        
						        System.out.println("\nYou have successfully logged in!\n");
						        
						        do {
						            System.out.println("====================================================================");
						            System.out.println("    :: Admin Phase");
						            System.out.println("====================================================================");
						            System.out.println("\n[1] Check User Details \n[2] Logout\n");
						            
						            System.out.print("=> Key: ");
						            char key1 = sc11.next().charAt(0);
						            
						            switch (key1){
						                case '1':
											System.out.println("--------------------------------------------------------------------");
						                    System.out.println("    :: Check User Details");
											System.out.println("--------------------------------------------------------------------");

											System.out.println("\tUser ID         |       Name");
											System.out.println("--------------------------------------------------------------------");

											for (int j = 0; j < accInfos.length; j++){
												if (accInfos[j][7] == null){
													System.out.print("\n=> Select a user: ");
													int chooseUser = sc11.nextInt();
													int actualUser = chooseUser - 1;
													int loopCounter13 = 0;

													if (accInfos[actualUser][7] == null) {
														System.out.println("\nUser does not exist, please try again.");
														break;
													} else {
														do {

															System.out.println("====================================================================");
															System.out.println("    :: "+accInfos[actualUser][2] + ", " + accInfos[actualUser][1] + "'s Account");
															System.out.println("====================================================================");
															System.out.println("Options:\n");
															System.out.println("[1] Account information\n[2] Current Loan Details\n[3] Payment History\n[4] Go back\n");
															System.out.print("=> Key: ");
															int chooseOptions = sc11.nextInt();
	
															Scanner sc18 = new Scanner(System.in);
	
															switch (chooseOptions) {
																case 1:
																	System.out.println("--------------------------------------------------------------------");
																	System.out.println("   :: Account Details                                                ");
																	System.out.println("--------------------------------------------------------------------");
																	System.out.println("Name\t\t\t\t|" + accInfos[actualUser][2] + ", " + accInfos[actualUser][1]);
																	System.out.println("Address\t\t\t\t|" + accInfos[actualUser][3]);
																	System.out.println("Email\t\t\t\t|" + accInfos[actualUser][4]);
																	System.out.println("Phone Number\t\t\t|" + accInfos[actualUser][5]);
																	System.out.println("\nUser ID: " + accInfos[actualUser][7]);
	
																	System.out.print("\nPress [ENTER] to continue");
																	String choiceEnter = sc18.nextLine();
																	System.out.println("Proceeding to user account menu...");
	
																	break;
																case 2:
																	if (transDetails[actualUser][0] != 0) {
																		Scanner sc4 = new Scanner(System.in);
																		
																		System.out.println("--------------------------------------------------------------------");
																		System.out.println("   :: Loan Details                                           ");
																		System.out.println("--------------------------------------------------------------------");
																		
																		System.out.println("Amount Loaned\t\t\t: " + transDetails[actualUser][0]);
																		System.out.printf("\nInterest per month\t\t: %.2f" , transDetails[actualUser][1]);
																		System.out.printf("\nTotal amount with interest\t: %.2f" , transDetails[actualUser][2]);
																		System.out.println("\n");
																		if (transDetails[actualUser][5] == 1) {
																			System.out.println("------------------------------------------------");
																			System.out.println("Monthly payment for " + Math.round(transDetails[actualUser][3]) + " months\t: " + (Math.round(transDetails[actualUser][4] * 100)/100.0));
																		} else {
																			System.out.println("------------------------------------------------");
																			System.out.println("Weekly payment for " + Math.round(transDetails[actualUser][3]) + " months\t: " + (Math.round(transDetails[actualUser][4] * 100)/100.0));
																		}
																		System.out.println("\nReference ID: " + Math.round(transDetails[actualUser][9]));
																		System.out.println("Date Loaned: " + loanDateTime[actualUser][0] + " " + loanDateTime[actualUser][1]);
																		System.out.print("\n=> Press [ENTER] to go back");
																		
																		String choice5 = sc4.nextLine();
																		
																		if (choice5.equals("")) {
																			
																			System.out.println("Proceeding back to the account menu...");
																		} else {
																			
																			System.out.println("Proceeding back to the account menu...");
																		}
																	} else {
																		Scanner sc5 = new Scanner(System.in);
																		System.out.println("--------------------------------------------------------------------");
																		System.out.println("The user does not have any outstanding loan.\n\nPress [ENTER] to go back.");
																		String choice6 = sc5.nextLine();
																		if (choice6.equals("")){
																			continue;
																		} else {
																			continue;
																		}
																	}
																	break;
																case 3:
																	if (payRef[actualUser][0] <= 0){
																		System.out.println("--------------------------------------------------------------------");
																		System.out.println("\nThe user does not have any payment yet.");
																		System.out.println("\nPress [ENTER] to continue");
																		String choiceEnter2String = sc18.nextLine();
																		System.out.println("Proceeding to user account menu...");
																	} else {
																		System.out.println("--------------------------------------------------------------------");
																		System.out.println("   :: Payment History");
																		System.out.println("--------------------------------------------------------------------");
																		System.out.println("         Date & Time       |  Reference No.   |      Amount Paid    ");
																		System.out.println("--------------------------------------------------------------------");
																		for (int l = 0; l < payRef.length; l++){
																			if (payment[actualUser][l] == 0.0){
																				System.out.println("\nPress [ENTER] to continue");
																				String choiceEnter1 = sc18.nextLine();
																				System.out.println("Proceeding to user account menu...");
																				break;
																			} else {
																				System.out.println("\t" + paymentDateTime[actualUser][l] + "\t\t" + payRef[actualUser][l] + "\t\t\t" + payment[actualUser][l]);
																			}
																		}
																	}
																	break;
																case 4:
																	loopCounter13++;
																	break;
																default:
																	System.out.println("\nInvalid input, please try again!");
																	continue;
															}
															
														} while (loopCounter13 == 0);
													}
													break;
													
												} else {
													int userSelectionCount = j + 1;
													System.out.println("[" + userSelectionCount +"]\t" + accInfos[j][7] + "\t\t\t" + accInfos[j][2] + ", " + accInfos[j][1]);
												}
											}
						                    break;
						                
						                case '2':
											System.out.println("\nYou have successfully logged out!");
											loopCounter12++;
											break;
						                
						                default:
											continue;
						                    
						            }
						            
						        } while (loopCounter12 == 0);
						    } else {
								System.out.println("\nIncorrect password! Contact and administrator to proceed.");
							}
						    break;
					
					case '4':
						System.out.println("--------------------------------------------------------------------");
					    System.out.println("                      The program has exited!");
						System.out.println("--------------------------------------------------------------------");
					    ++loopCounter1;
					    regCount = -1;
					    break;
					
					default:
					System.out.println("--------------------------------------------------------------------");	
                    System.out.println("Wrong input, please try again.");
						continue;
						
				}	
			} while (loopCounter1 == 0);
			
		} while(regCount > 0);
	}
}