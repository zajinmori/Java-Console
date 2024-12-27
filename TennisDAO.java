package TennisAPP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TennisDAO {

	private final String PLAYERPATH = ".\\dat\\dummy.txt";
	// private final String SCOREPATH = ".\\dat\\scoreboard.txt";
	private final String RESULTPATH = ".\\dat\\경기결과.txt";
	private final String DETAILRESULTPATH = ".\\dat\\경기상세결과.txt";

//	private final String PLAYERPATH = "/Users/choeyujeong/Downloads/TennisProject/dat/dummy.txt";
//	//private final String SCOREPATH = ".\\dat\\scoreboard.txt";
//	private final String RESULTPATH = "/Users/choeyujeong/Downloads/TennisProject/dat/경기결과.txt";
//	private final String DETAILRESULTPATH = "/Users/choeyujeong/Downloads/TennisProject/dat/경기상세결과.txt";

	public void addScoreBoard(TennisDTO dto) {
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(DETAILRESULTPATH));
			
			String line = null;
			int n = 0;
			
			while ((line = reader.readLine()) != null) {
				
				n = Integer.parseInt(line.split(",")[0]);
				
			}
			
			reader.close();
			
			n++;
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(DETAILRESULTPATH, true)); //append

			writer.write(n + "," + dto.getSaveboard() + "\r\n");

			writer.close();
			

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void addRecord(TennisDTO dto) {

		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(RESULTPATH));
			
			String line = null;
			int n = 0;
			
			while ((line = reader.readLine()) != null) {
				
				n = Integer.parseInt(line.split(",")[0]);
				
			}
			
			reader.close();
			
			n++;
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(RESULTPATH, true)); //append

			writer.write(n + "," + dto.getSaverecord() + "\r\n");

			writer.close();
			

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public void addPlayer(TennisDTO dto) {

		try {

			BufferedWriter writer = new BufferedWriter(new FileWriter(PLAYERPATH, true));
			String line = String.format("%s,%s,%s세\n", dto.getName(), dto.getGender(), dto.getAge());

			writer.write(line);

			writer.close();

		} catch (Exception e) {
			System.out.println("TennisDAO.add");
			e.printStackTrace();
		}

	}


	public TennisDTO get(String name) {

		try {
			BufferedReader reader = new BufferedReader(new FileReader(PLAYERPATH));

			String line = null;

			while ((line = reader.readLine()) != null) {

				if (line.startsWith(name)) {

					String[] temp = line.split(",");

					TennisDTO dto = new TennisDTO();

					// 아무개,남,11세
					if (name != "") {

						dto.setName(temp[0]);
						dto.setGender(temp[1]);
						dto.setAge(temp[2]);
					} else {
						dto.setName("");
						dto.setGender("");
						dto.setAge("");
					}
					return dto;
				}
			}

			reader.close();

		} catch (Exception e) {
			System.out.println("TennisDAO.get");
			e.printStackTrace();
		}

		return null;

	}

	public TennisDTO getRecord() {

		try {
			BufferedReader reader = new BufferedReader(new FileReader(RESULTPATH));
			String line = null; // 1 line
			String total = "";
			TennisDTO dto = new TennisDTO();

			while ((line = reader.readLine()) != null) {
				total += line + "\n";
			}

			dto.setRecord(String.format("%s", line));
			System.out.println(total);
			reader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	public TennisDTO getResult(String num) {

		try {
			BufferedReader detailreader = new BufferedReader(new FileReader(DETAILRESULTPATH));

			String Dline = null;

			while ((Dline = detailreader.readLine()) != null) {
				if (Dline.startsWith(num)) {
					String[] temp = Dline.split(",");
					TennisDTO dto = new TennisDTO();
					if (temp.length == 21) {
						dto.setBoard(String.format(
										"-------------------------------------------------------------------\n"
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
										+ "-------------------------------------------------------------------\n",
								temp[1],temp[3],temp[6],temp[9],temp[12],temp[15],temp[18]
								,temp[2],temp[4],temp[7],temp[10],temp[13],temp[16],temp[19]
								,temp[5],temp[8],temp[11],temp[14],temp[17],temp[20]));

						return dto;
					} else {
						dto.setBoard(String.format(
										"---------------------------------------------------\n"
										+ "|선수\\set | 1set |  2set |  3set |\ttotal     |\n"
										+ "--------------------------------------------------\n"
										+ "|\t |\t|\t|\t|\t\t  |\n"
										+ "| %s\t |  %s\t|  %s\t|  %s\t|\t%s\t  |\n"
										+ "|\t |\t|\t|\t|\t\t  |\n"
										+ "--------------------------------------------------\n"
										+ "|\t |\t|\t|\t|\t\t  |\n"
										+ "| %s\t |  %s\t|  %s\t|  %s\t|\t%s\t  |\n"
										+ "|\t |\t|\t|\t|\t\t  |\n"
										+ "---------------------------------------------------\n"
										+ "|\t |\t|\t|\t|\t\t  |\n" 
										+ "| win\t | %s\t| %s\t| %s\t|  %s\t  |\n"
										+ "|\t |\t|\t|\t|\t\t  |\n"
										+ "---------------------------------------------------\n",
								temp[1],temp[3],temp[6],temp[9],temp[12]
								,temp[2],temp[4],temp[7],temp[10],temp[13]
								,temp[5],temp[8],temp[11],temp[14]));
						return dto;
					}
				}
			}

			detailreader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
