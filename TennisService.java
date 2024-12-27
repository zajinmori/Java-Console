package TennisAPP;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class TennisService {
	
	
	private TennisDAO dao;
	private TennisView view;
	private Scanner scan;
	
	public TennisService() {
		
		this.view = new TennisView();
		this.dao = new TennisDAO();
		this.scan = new Scanner(System.in);
		
	}
	
	public void playerCheck() {
		String playerPATH = ".\\dat\\dummy.txt";
		//String playerPATH = "./dat/dummy.txt";
		final int perPage = 15;		
			System.out.println("저장된 선수 목록을 불러옵니다.");
			
			try {
			    BufferedReader reader = new BufferedReader(new FileReader(playerPATH));
			    String line;
			    int lineNumber = 0;
			    
			    while ((line = reader.readLine()) != null) {
			    	lineNumber++;
			    	System.out.println(line);
			    	
			    	if (lineNumber % perPage == 0) {
			    		System.out.print("\n 다음 목록으로..(엔터)");
			    		waitForEnter();
			    	}
				}
			    System.out.println();
			    System.out.println("마지막 페이지..");
			    System.out.println("엔터를 누르면 처음으로 돌아갑니다.");
			    reader.close();					
			    
			} catch (Exception e) {
					System.out.println("파일을 읽는 중 오류가 발생했습니다.");
					e.printStackTrace();
					
			}
			scan.skip("\r\n");
		}

	private void waitForEnter() {
		try {
			BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
			consoleReader.readLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public void addPlayer() {

		Scanner scan = new Scanner(System.in);
		TennisDAO dao = new TennisDAO();
		TennisView view = new TennisView();
		TennisDTO dto = new TennisDTO();

		String name = "";
		String age = "";
		int gender = 0;

		view.subTitle("신규 선수 등록");

		
		while (true) {
			
		    System.out.print("이름 : ");
		    name = scan.nextLine();
			
		    boolean isDuplicate = (dao.get(name) != null);
		    boolean isHangul = true;
		    
		    for (int i = 0; i < name.length(); i++) {
		        char ch = name.charAt(i);
		        if (!(ch >= '가' && ch <= '힣')) {
		            isHangul = false;
		            break;
		        }
		    }
		    
		    boolean lengthLoop = (name.length() >= 2 && name.length() <= 5);
		    
		    if (isDuplicate) {
		        System.out.println("이미 등록된 선수입니다. 다시 입력해주세요.");
		        view.pause();
		    } else if (!isHangul) {
		        System.out.println("선수 이름은 한글로만 입력할 수 있습니다. 다시 입력해주세요.");
		        view.pause();
		    } else if (!lengthLoop) {
		        System.out.println("이름을 2자~5자 이내로 입력하세요.");
		        view.pause();
		    } else {
		        // 모든 조건을 만족한 경우
		        dto.setName(name);
		        break;
		    }
		}


		System.out.print("나이 : ");
		age = scan.nextLine();

		while (true) {
			if (Integer.parseInt(age) >= 18 && Integer.parseInt(age) <= 45) {
				dto.setAge(age);
				break;
			} else {
				System.out.println("18세 이상, 45세 이하만 등록 가능합니다.");
				view.pause();
				System.out.print("나이 : ");
				age = scan.nextLine();
			}
		}

		while (dto.getGender() == null) {
			System.out.print("성별(남:1 / 여:2) : ");

			gender = scan.nextInt();

			if (gender == 1) {
				dto.setGender("남");
				break;
			} else if (gender == 2) {
				dto.setGender("여");
				break;
			} else {
				System.out.println("남자라면 1, 여자라면 2를 입력해주세요.");
			}
		}

		scan.skip("\r\n");
		dao.addPlayer(dto);

		System.out.println("선수 등록 완료 !");

		view.pause();
	}


	public void getResult() {
		view.subTitle("경기확인");
		TennisDTO record = dao.getRecord();
		System.out.print("경기 번호 : ");
		String num = scan.nextLine();
		
		TennisDTO dto = dao.getResult(num);
		
		if(dto != null) {
			System.out.printf("%s",dto.getBoard());
		}else {
			System.out.println("경기가 없습니다.");
		}
		view.pause();
	}

}
