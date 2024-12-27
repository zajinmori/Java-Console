package TennisAPP;

import java.util.Scanner;

public class readMe {

	TennisView view = new TennisView();

	public void explain() {
		helpTitle();
		
		Scanner scan = new Scanner(System.in);
		boolean loop = true;
		
		while (loop) {
		
			
			String sel = scan.nextLine();
			
			if (sel.equals("1")) {
				explain_1();
				break;
			} else if (sel.equals("2")) {
				explain_2();
				break;
			} else if (sel.equals("3")) {
				explain_3();
				break;
			} else if (sel.equals("4")) {
				explain_4();
				break;
			} else {
				loop = false;
				System.out.println("비정상적인 접근입니다. 메인으로 돌아갑니다.");
				view.backPause();
			}
			continue;
		
			
		}

	}
	
		public void helpTitle() {
		System.out.println("\r\n◎사용 설명서◎\r\n프로그램을 이용해 주셔서 감사합니다♥.\n\n"
				+ "간단한 사용 설명을 드리고자 하니 읽고 확인해주세요.\n\n");
		System.out.println("➡️ 1. 새 경기 시작\r\n");
		System.out.println("➡️ 2.지난 경기 불러오기\r\n");
		System.out.println("➡️ 3.선수 정보\r\n");
		System.out.println("➡️ 4.신규 선수 등록\r\n");
		System.out.println("◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆\n");
		}
		
		public void explain_1() {
			
			System.out.println("\r\n◎사용 설명서◎\r\n프로그램을 이용해 주셔서 감사합니다♥.\n\n"
					+ "간단한 사용 설명을 드리고자 하니 읽고 확인해주세요.\n\n"
					+ "◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆\n");
			System.out.println("➡️ 1. 새 경기 시작\r\n"		
					+ "새로운 게임을 시작할 수 있습니다.\n\r"
					+ "1) 선수이름 입력 시, 선수 정보가 보입니다.\n\r"
					+ "2) 경기 생성은 사전에 등록되어있는 선수들로만 생성이 가능합니다.\r\n"
					+ "3) 동일 성별끼리만 경기가 가능하며 선수 정보 확인은 메인 메뉴 3번에서 확인할 수 있습니다.\n\r"
					+ "4) 남성부는 5판 3선승, 여성부는 3판 2선승제로 진행됩니다.\n\r"
					+ "5) 모든 경기에는 듀스, 타이브레이크가 적용됩니다.\r\n"
					+ "6) 경기가 끝난 후 스코어 보드로 세트스코어가 출력되며 저장됩니다.\r\n");
			view.backPause();
			
			
		}
		
		public void explain_2() {
			System.out.println("➡️ 2.지난 경기 불러오기\r\n"
					+ "지난 경기를 불러올 수 있습니다.\n\r"
					+ "1) 각 경기엔 번호가 부여되어 있습니다.\n\r"
					+ "2) 리스트 형태로 간략하게 출력되어있으며, 원하는 경기 번호 입력 시, 상세 기록이 출력됩니다.\n\r");
			view.backPause();
		}
		
		public void explain_3() {
			System.out.println("➡️ 3.선수 정보\r\n"
					+ "선수 정보를 확인 합니다.\n\r"
					+ "1) 등록되어있는 선수들을 확인합니다.\n\r"
					+ "2) 등록완료 된 선수들만 경기에 참여 가능합니다.\n\r"
					+ "3) 경기 참여를 원하실 경우 "+"4. 신규 선수 등록"+"을 진행해주세요.\n\r");
			view.backPause();
		}
		
		public void explain_4() {
			System.out.println("➡️ 4.신규 선수 등록\r\n"
					+ "새로운 선수를 등록합니다.\n\r"
					+ "1) 이름 > 나이 > 성별 순으로 입력을 받습니다.\n\r"
					+ "2) 성별 입력은 표기된 남자.1 여자.2로 입력받습니다.\n\r");
			view.backPause();
			
		}

}
