package TennisAPP;

import java.io.File;
import java.util.Calendar;
import java.util.Random;

import com.github.lalyos.jfiglet.FigletFont;

public class gameRule extends newGame {

	static int player1_gameCount = 0;
	static int player2_gameCount = 0;
	static int player1_setCount = 0;
	static int player2_setCount = 0;
	static int gameCount = 1;
	static int setCount	= 0;
	static int mainSetCount = 1;
	static boolean loop = true;
	static int player1Point = 0;
	static int player2Point = 0;
	static TennisDTO dto = new TennisDTO();
	static TennisDAO dao = new TennisDAO();
	static String[] score = new String[5];
	
	public static void manGame(String player1, String player2) {
		
		System.out.println("3세트를 먼저 따내면 승리입니다.");
		System.out.println("게임을 시작합니다.\n");
		loop = true;
		view.pause();
		
		System.out.println("================================================");
		System.out.println(dateTime() + player1 + " vs " + player2);
		System.out.println("================================================");
		
		pointCount(player1, player2);
		gameCount(player1, player2);
		manSetCount(player1, player2);
		
	}

	public static void womanGame(String player1, String player2) {

		System.out.println("2세트를 먼저 따내면 승리입니다.");
		System.out.println("게임을 시작합니다.\n");
		view.pause();
		
		System.out.println("================================================");
		System.out.println(dateTime() + player1 + " vs " + player2);
		System.out.println("------------------------------------------------");
		
		pointCount(player1, player2);
		gameCount(player1, player2);
		womanSetCount(player1, player2);
	}
	
	
	private static void pointCount(String player1, String player2) {
		Random rnd = new Random();
		int[] counts = { 0, 0 };
		
		while (loop) {
			System.out.printf("\t🥎<%d세트> %d 게임 시작 🥎\n",mainSetCount,gameCount);	
			System.out.printf("%s 점수 : %d\n", player1, counts[0]);
			System.out.printf("%s 점수 : %d\n", player2, counts[1]);
			break;
		}
		
		while (loop) {

			System.out.println();
			
			counts[rnd.nextInt(2)] += 1;
			if (!(counts[0] == 3 && counts[1] == 3)) {
				if (counts[0] <= 2 && counts[1] <= 2) {
					System.out.printf("%s 점수 : %d\n", player1, counts[0] * 15);
					System.out.printf("%s 점수 : %d\n", player2, counts[1] * 15);
				} else if (counts[0] == 3 && counts[1] <= 2) {
					System.out.printf("%s 점수 : %d\n", player1, 40);
					System.out.printf("%s 점수 : %d\n", player2, counts[1] * 15);
				} else if (counts[1] == 3 && counts[0] <= 2) {
					System.out.printf("%s 점수 : %d\n", player1, counts[0] * 15);
					System.out.printf("%s 점수 : %d\n", player2, 40);
				}
				

				if ((counts[0] == 4 && counts[1] <= 2)) {
					player1_gameCount++;
					gameCount++;
					System.out.println("-------------------------------------");
					System.out.println("|\t\t\t\t    |");

					System.out.printf("\t✅%s 선수 게임 획득 !\n", player1);
					System.out.println();
					System.out.println("\t  <현재 게임 스코어>");
					System.out.printf("\t%s 선수: %d게임\n", player1, player1_gameCount);
					System.out.printf("\t%s 선수: %d게임\n", player2, player2_gameCount);
					System.out.println();
					
					System.out.println("|___________________________________|");
					view.pause();
					break;
				} else if ((counts[0] <= 2 && counts[1] == 4)) {
					player2_gameCount++;
					gameCount++;
					System.out.println("-------------------------------------");
					System.out.println("|\t\t\t\t    |");
					System.out.printf("\t✅%s 선수 게임 획득 !\n", player2);
					
					System.out.println();
					System.out.println("\t  <현재 게임 스코어>");
					System.out.printf("\t%s 선수: %d게임\n", player1, player1_gameCount);
					System.out.printf("\t%s 선수: %d게임\n", player2, player2_gameCount);
					System.out.println();
					System.out.println("|___________________________________|");
					view.pause();
					break;
				}

			} else {
				System.out.printf("%s 점수 : %d\n", player1, 40);
				System.out.printf("%s 점수 : %d\n", player2, 40);
				try {
					  
				    String asciiArt3 = FigletFont.convertOneLine(new File(".\\dat\\dotmatrix.flf"), "Deuce !");     
				    System.out.println(asciiArt3);
					} catch (Exception e) {
						System.out.println("Ex70.main");
						e.printStackTrace();
					}

				view.pause();
				deuce(player1,player2);
				break;
			}
		}
	}
	
	
	
	
	

	private static void deuce(String player1,String player2) {
		Random rnd = new Random();
	     int[] counts = { 0, 0 };
		    
	     	while (loop) {
	         	
	     		counts[rnd.nextInt(2)] += 1;
	         	System.out.printf("%s 점수 : %d\n", player1, counts[0]);
	 			System.out.printf("%s 점수 : %d\n", player2, counts[1]);

	 			if (counts[0] - counts[1] == 1) {
	 				System.out.println();
	 				System.out.printf("%s선수 AD\n", player1);
	 			}else if (counts[0] - counts[1] == 2) {
	 					System.out.println();
	 					System.out.println("-------------------------------------");
						System.out.println("|\t\t\t\t    |");
	 					System.out.printf("\t✅%s선수 게임 획득 !\n", player1);
	 					player1_gameCount++;
	 					gameCount++;
	 					System.out.println("\t  <현재 게임 스코어>");
	 					System.out.printf("\t%s선수: %d게임\n", player1, player1_gameCount);
						System.out.printf("\t%s선수: %d게임\n", player2, player2_gameCount);
	 					System.out.println();
	 					System.out.println("|___________________________________|");


						view.pause();
	 					break;
	 			} 
	 			
	 			else if (counts[1] - counts[0] == 1) {
	 				System.out.println();
	 				System.out.printf("%s선수 AD\n", player2);
	 				System.out.println();
	 				
	 			} else if (counts[1] - counts[0] == 2) {
	 					System.out.println();
	 					System.out.println("-------------------------------------");
						System.out.println("|\t\t\t\t    |");
	 					System.out.printf("\t✅%s선수 게임 획득 !\n", player2);
	 					player2_gameCount++;
	 					gameCount++;
	 					System.out.println();
	 					System.out.println("\t  <현재 게임 스코어>");
	 					System.out.printf("\t%s 선수: %d게임\n", player1, player1_gameCount);
						System.out.printf("\t%s 선수: %d게임\n", player2, player2_gameCount);
	 					System.out.println();
	 					System.out.println("|___________________________________|");


						view.pause();
	 				
						break;
	 				
	 			} else {
	 				System.out.println("\t👉 듀스"); 
	 			}
	     	}

	}

	private static void gameCount(String player1, String player2) {
		
		while (loop) {
		
			if((player1_gameCount == 5 && player2_gameCount == 5)
			|| (player1_gameCount == 6 && player2_gameCount == 5)
			|| (player1_gameCount == 5 && player2_gameCount == 6)){
				
				
				System.out.println("듀스");
				gameDeuce(player1, player2);
				
			} else if (player1_gameCount == 6 && player2_gameCount == 6) {
				System.out.println("타이브레이크");
				tiebreak(player1, player2);
				break;
			} else if (player1_gameCount == 7 && player2_gameCount == 5) {
				recordscore(player1,player2);
				setCount++;
				mainSetCount++;
				player1_setCount++;
				System.out.println("-------------------------------------");
				System.out.println("|\t\t\t\t    |");
				System.out.printf("\n\t✅%s 선수 세트 획득\n", player1);
				System.out.println();
				break;
			} else if (player2_gameCount == 7 && player1_gameCount == 5) {
				recordscore(player1,player2);
				setCount++;
				mainSetCount++;
				player2_setCount++;
				System.out.println("-------------------------------------");
				System.out.println("|\t\t\t\t    |");
					System.out.printf("\n\t✅%s 선수 세트 획득 !!\n", player2);
					System.out.println();
					break;
			} else if((player1_gameCount >= 6 || player2_gameCount >= 6)
					&& !(player1_gameCount == 6 && player2_gameCount == 5)
					&& !(player1_gameCount == 5 && player2_gameCount == 6)
					&& !(player1_gameCount == 6 && player2_gameCount == 6)
					&& !(player1_gameCount == 7 && player2_gameCount == 5)
					&& !(player1_gameCount == 5 && player2_gameCount == 7)) {
				
				if(player1_gameCount >= 6) {
					recordscore(player1,player2);
					setCount++;
					mainSetCount++;
					player1_setCount++;
					System.out.println("-------------------------------------");
					System.out.println("|\t\t\t\t    |");

					System.out.printf("\n\t✅%s 선수 세트 획득 !!\n", player1);
					System.out.println();
					break;
				} else if (player2_gameCount >= 6) {
					recordscore(player1,player2);
					setCount++;
					mainSetCount++;
					player2_setCount++;
					System.out.println("-------------------------------------");
					System.out.println("|\t\t\t\t    |");

					System.out.printf("\n\t✅%s 선수 세트 획득 !!\n", player2);
					System.out.println();
					break;
				} 
					
			} else {
				pointCount(player1, player2);
			}
		}
	}
	
	
		
	private static void gameDeuce(String player1, String player2) {
		
		if (player1_gameCount == 5 && player2_gameCount == 5) {
			pointCount(player1, player2);
		} else if ((player1_gameCount == 6 && player2_gameCount == 5 )
				||(player1_gameCount == 5 && player2_gameCount == 6 )) {
			pointCount(player1, player2);
		} 
		
	}
			
		private static void tiebreak(String player1, String player2) {
			Random rnd = new Random();
			System.out.println();
			try {
				  
			    String asciiArt3 = FigletFont.convertOneLine(new File(".\\dat\\slant.flf"), "TieBreak !");     
			    System.out.println(asciiArt3);
				} catch (Exception e) {
					System.out.println("Ex70.main");
					e.printStackTrace();
				}
			System.out.println("게임이 6대6 동점이므로 타이브레이크를 진행합니다. \n");
			System.out.println();
			int[] lastGamePoint = { 6, 6 }; // 직전 경기 점수


			if (lastGamePoint[0] == lastGamePoint[1]) {

				while (loop) {
					
					System.out.printf("%s 점수 : %d\n", player1, player1Point);
					System.out.printf("%s 점수 : %d\n", player2, player2Point);
					System.out.println();
					
					int winner = rnd.nextInt(2) + 1;

					if (winner == 1) {
						player1Point++;
					} else {
						player2Point++;
					}
					
					if (player1Point >= 7 && player1Point >= player2Point + 2) {
						System.out.printf("%s 점수 : %d\n", player1, player1Point);
						System.out.printf("%s 점수 : %d\n", player2, player2Point);
						System.out.println("-------------------------------------");
						System.out.println("|\t\t\t\t    |");

						System.out.printf("\n\t✅%s선수 게임 획득 !\n",player1);
						recordscore(player1,player2);
						player1_setCount++;
						setCount++;
						mainSetCount++;
						System.out.println();
						
						break;
					} else if (player2Point >= 7 && player2Point >= player1Point + 2) {
						System.out.printf("%s 점수 : %d\n", player1, player1Point);
						System.out.printf("%s 점수 : %d\n", player2, player2Point);
						System.out.println("-------------------------------------");
						System.out.println("|\t\t\t\t    |");

						System.out.printf("\n%s\t✅선수 게임 획득 !\n",player2);
						recordscore(player1,player2);
						player2_setCount++;
						setCount++;
						mainSetCount++;
						System.out.println();
						

						break;
					}
				}
				player1Point=0;
				player2Point=0;

			} else {
				System.out.println("타이브레이크를 진행하지 않습니다. 경기를 종료합니다. ");
			}

		}

	
	
	private static void manSetCount(String player1, String player2) {
		player2_gameCount = 0;
		player1_gameCount = 0;
		gameCount = 1;
		
		
		while(loop) {
			System.out.println("\t <현재 세트 스코어>");
			System.out.printf("\t[%s] : %d\n", player1, player1_setCount);
			System.out.printf("\t[%s] : %d\n", player2, player2_setCount);
			System.out.println();
			System.out.println("|___________________________________|");
			
			if(player1_setCount < 3 && player2_setCount < 3) {
				manGame(player1, player2);
				pointCount(player1, player2);
			} else if (player1_setCount == 3) {
				System.out.println();
				System.out.println();
				System.out.println("  __   _   _  _   __  ___   _   ___  _ _  _     _   ___  _   _   _  _  __ ||||\r\n"
						+ " / _| / \\ | \\| | / _|| o \\ / \\ |_ _|| | || |   / \\ |_ _|| | / \\ | \\| |/ _|L|L|\r\n"
						+ "( (_ ( o )| \\\\ |( |_n|   /| o | | | | U || |_ | o | | | | |( o )| \\\\ |\\_ \\    \r\n"
						+ " \\__| \\_/ |_|\\_| \\__/|_|\\\\|_n_| |_| |___||___||_n_| |_| |_| \\_/ |_|\\_||__/()()\r\n"
						+ "                                                                              \r\n"
						+ "");
				System.out.printf("\t\t (*´▽`*) 🎉 축하합니다 🎉 (*´▽`*) \n");
				System.out.printf("\t\t\t[%s선수]의 승리 🏆✨ !!\n",player1);
				System.out.println();
				System.out.println();
				System.out.println("경기가 종료되었습니다.\n");
				loop = false;
				manFinalScore(player1, player2);
			} else{
				
				
				
				
				System.out.println();
				System.out.println();
				System.out.println("  __   _   _  _   __  ___   _   ___  _ _  _     _   ___  _   _   _  _  __ ||||\r\n"
						+ " / _| / \\ | \\| | / _|| o \\ / \\ |_ _|| | || |   / \\ |_ _|| | / \\ | \\| |/ _|L|L|\r\n"
						+ "( (_ ( o )| \\\\ |( |_n|   /| o | | | | U || |_ | o | | | | |( o )| \\\\ |\\_ \\    \r\n"
						+ " \\__| \\_/ |_|\\_| \\__/|_|\\\\|_n_| |_| |___||___||_n_| |_| |_| \\_/ |_|\\_||__/()()\r\n"
						+ "                                                                              \r\n"
						+ "");
				System.out.printf("\t (*´▽`*) 🎉 축하합니다 🎉 (*´▽`*) \n");
				System.out.printf("\t\t[%s선수]의 승리 🏆✨ !!\n",player2);
				System.out.println();
				System.out.println();
				System.out.println("경기가 종료되었습니다.\n");
				loop = false;
				manFinalScore(player1, player2);
			} 
		}
	}
	
	private static void womanSetCount(String player1, String player2) {
		
		player2_gameCount = 0;
		player1_gameCount = 0;
		gameCount = 1;
		
		
		while(loop) {
			System.out.println("\t <현재 세트 스코어>");
			System.out.printf("\t[%s] : %d\n", player1, player1_setCount);
			System.out.printf("\t[%s] : %d\n", player2, player2_setCount);
			System.out.println();
			System.out.println("|___________________________________|");
			
			if(player1_setCount < 2 && player2_setCount < 2) {
				womanGame(player1, player2);
				pointCount(player1, player2);
			} else if (player1_setCount == 2) {
				System.out.println();
				System.out.printf("\t (*´▽`*) 🎉 축하합니다 🎉 (*´▽`*) \n");
				System.out.printf("\t\t[%s선수]의 승리 !!\n",player1);
				System.out.println();
				System.out.println("경기가 종료되었습니다.\n");
				loop = false;
				womanFinalScore(player1, player2);

			} else{
				System.out.println();
				System.out.printf("\t (*´▽`*) 🎉 축하합니다 🎉 (*´▽`*) \n");
				System.out.printf("\t\t[%s선수]의 승리 !!\n",player2);
				System.out.println();
				System.out.println("경기가 종료되었습니다.\n");
				loop = false;
				womanFinalScore(player1, player2);
			} 
		}
	}
	
	private static void recordscore(String player1, String player2) {
		
		while(loop) {
		
		if(player1_gameCount>player2_gameCount) {
			score[setCount] = player1_gameCount+","+player2_gameCount+","+ player1 +",";
		}else if(player2_gameCount>player1_gameCount) {
			score[setCount] = player1_gameCount+","+player2_gameCount+","+player2+",";			
		}
		else if(player1Point>player2Point) {
			score[setCount] = player1Point+"/T"+","+player2Point+"/T"+","+player1+",";
		}
		else if(player2Point>player1Point) {
			score[setCount] = player1Point+"/T"+","+player2Point+"/T"+","+player2+",";
		}
		break;
		}
		
	}



	private static void manFinalScore(String player1, String player2) {

		System.out.println("최종 결과");
		String line = String.format("%s,%s,",player1,player2); 
		for(int i=0;i<5;i++) {
			if(score[i]!=null) {
				line += score[i];
			}else {
				line += "0,0,0,";
			}
		}
		if(player1_setCount>player2_setCount) {
			line += String.format("%s,%s,%s 승",player1_setCount,player2_setCount,player1);
		}else if(player2_setCount>player1_setCount) {
			line += String.format("%s,%s,%s 승",player1_setCount,player2_setCount,player2);			
		}
		dto = new TennisDTO();
		dto.setSaveboard(line);
		String[] temp = line.split(",");
		
		System.out.println("===================================================================");
		System.out.println(dateTime() + "\t"+player1 + " vs " + player2);
		System.out.printf("-------------------------------------------------------------------\n"
						+ "|선수\\set | 1set |  2set |  3set |  4set |  5set |\ttotal     |\n"
						+ "-------------------------------------------------------------------\n"
						+ "|\t |\t|\t|\t|\t|\t|\t\t  |\n"
						+ "| %s\t |  %s\t|  %s\t|  %s\t|  %s\t|  %s\t|\t%s\t  |\n"
						+ "|\t |\t|\t|\t|\t|\t|\t\t  |\n"
						+ "-------------------------------------------------------------------\n"
						+ "|\t |\t|\t|\t|\t|\t|\t\t  |\n"
						+ "| %s\t |  %s\t|  %s\t|  %s\t|  %s\t|  %s\t|\t%s\t  |\n"
						+ "|\t |\t|\t|\t|\t|\t|\t\t  |\n"
						+ "-------------------------------------------------------------------\n"
						+ "|\t |\t|\t|\t|\t|\t|\t\t  |\n" 
						+ "| win\t | %s\t| %s\t| %s\t| %s\t| %s\t|  %s\t  |\n"
						+ "|\t |\t|\t|\t|\t|\t|\t\t  |\n"
						+ "-------------------------------------------------------------------\n"
						,temp[0],temp[2],temp[5],temp[8],temp[11],temp[14],temp[17]
						,temp[1],temp[3],temp[6],temp[9],temp[12],temp[15],temp[18]
						,temp[4],temp[7],temp[10],temp[13],temp[16],temp[19]);
		System.out.println();
		if(player1_setCount>player2_setCount) {
			dto.setSaverecord(player1+","+player2+","+player1+" 승");
		}else if(player2_setCount>player1_setCount) {
			dto.setSaverecord(player1+","+player2+","+player2+" 승");
		}
		dao.addRecord(dto);
		dao.addScoreBoard(dto);
		view.backPause();
		player1_gameCount = 0;
		player2_gameCount = 0;
		player1_setCount = 0;
		player2_setCount = 0;
		gameCount = 1;
		setCount = 0;
		mainSetCount = 1;
	}

	
	private static void womanFinalScore(String player1, String player2) {
		String line = String.format("%s,%s,",player1,player2); 
		for(int i=0;i<3;i++) {
			if(score[i]!=null) {
				line += score[i];
			}else {
				line += "0,0,0,";
			}
		}
		if(player1_setCount>player2_setCount) {
			line += String.format("%s,%s,%s 승",player1_setCount,player2_setCount,player1);
		}else if(player2_setCount>player1_setCount) {
			line += String.format("%s,%s,%s 승",player1_setCount,player2_setCount,player2);			
		}
		dto = new TennisDTO();
		dto.setSaveboard(line);
		String[] temp = line.split(",");
		System.out.println("최종 결과");

		System.out.println("==================================================");
		System.out.println(dateTime() + player1 + " vs " + player2);
		System.out.printf("---------------------------------------------------\n"
						+ "|선수\\set | 1set |  2set |  3set |\ttotal     |\n"
						+ "---------------------------------------------------\n"
						+ "|\t |\t|\t|\t|\t\t  |\n"
						+ "| %s\t |  %s\t|  %s\t|  %s\t|\t%s\t  |\n"
						+ "|\t |\t|\t|\t|\t\t  |\n"
						+ "---------------------------------------------------\n"
						+ "|\t |\t|\t|\t|\t\t  |\n"
						+ "| %s\t |  %s\t|  %s\t|  %s\t|\t%s\t  |\n"
						+ "|\t |\t|\t|\t|\t\t  |\n"
						+ "---------------------------------------------------\n"
						+ "|\t |\t|\t|\t|\t\t  |\n" 
						+ "| win\t | %s\t| %s\t| %s\t|  %s\t  |\n"
						+ "|\t |\t|\t|\t|\t\t  |\n"
						+ "---------------------------------------------------\n"
						,temp[0],temp[2],temp[5],temp[8],temp[11]
						,temp[1],temp[3],temp[6],temp[9],temp[12]
						,temp[4],temp[7],temp[10],temp[13]);
		System.out.println();

		System.out.println();
		if(player1_setCount>player2_setCount) {
			dto.setSaverecord(player1+","+player2+","+player1+" 승");
		}else if(player2_setCount>player1_setCount) {
			dto.setSaverecord(player1+","+player2+","+player2+" 승");
		}
		dao.addRecord(dto);
		dao.addScoreBoard(dto);

		view.backPause();
		player1_gameCount = 0;
		player2_gameCount = 0;
		player1_setCount = 0;
		player2_setCount = 0;
		gameCount = 1;
		setCount = 0;
		mainSetCount = 1;
		
	}

	private static String dateTime() {
		
		Calendar now = Calendar.getInstance();
		return String.format("%tF\t%tT\t", now, now);
		
	}
	

}
