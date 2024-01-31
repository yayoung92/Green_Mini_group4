package greenMinigroup4;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		User user = new User();
		Person person = new Person();
		Login login = new Login();
		Search search = new Search();

		Insert insert = new Insert();
		Update update = new Update();
		List list = new List();
		
		Delete delete = new Delete();
		
		G_Test g_test = new G_Test(); 
		
		CategorySearch categorysearch = new CategorySearch();
		
		boolean check = true;
		int start = 0;

		System.out.println("******************************************");
		System.out.println("*             주소록 관리 프로그램             *");
		System.out.println("******************************************");
		
		start :while (true) {
			System.out.println("------------------------------------------");
			System.out.println(" 1. 로그인           ||  2. 회원가입      ");
			start = scan.nextInt();

			if (start == 1) {
				System.out.println("------------------------------------------");
				System.out.println("          <      로그인 하기      >          ");
				System.out.print("  ●  아이디를 입력하세요: ");
				String id = scan.next();

				System.out.print("  ●  비밀번호를 입력하세요: ");
				String password = scan.next();
				System.out.println();

				if (login.login(id, password) == 1) {

					// 로그인 성공했을 경우
					System.out.println("-----------     로그인 성공!!     -----------");
					System.out.println();
					System.out.println(">>           " + id + " 님 환영합니다!           <<");

					stop: while (check) {
						System.out.println();
						System.out.println("******************************************");
						System.out.println("*             주소록 관리 프로그램             *");
						System.out.println("******************************************");
						System.out.println();
						System.out.println("1.리스트  2.등록  3.수정  4.삭제  5.검색  6.종료  7.설정");
						System.out.println("------------------------------------------");
						System.out.print("> 메뉴번호 : ");
						int num = 0;
						num = scan.nextInt();
						System.out.println();

						switch (num) {
						case 1:
							System.out.println("<1.리스트>");
							System.out.println();
							
							
							
							 
						       

						case 2: // 등록하는 입력 창
							
							System.out.println("<2.등록하기>");
							System.out.println();

							int Insertidx = insert.idx(id);
							insert.insert(person,Insertidx);

							break;
							
						case 3:// 수정하는 부분

							System.out.println("<3.수정하기>");
							System.out.println();

							Test test = new Test();

							System.out.println(" 수정할 사람의 이름을 입력:");
							String UN = scan.next();
							System.out.println(" 수정할 사람의 번호를 입력:");
							String UP = scan.next();
							int Uidx = insert.idx(id);
							
							test.test(UN, UP, Uidx);
							
							System.out.println();
							System.out.println(" [ 수정되었습니다. ] ");
							break;
							
						case 4:
						// 삭제하는 부분
							System.out.println("<4.삭제하기>");
							System.out.println();						
							
							if(delete.deleteperson(delete.selectIdx(id))==1) {
								System.out.println(" [ 삭제되었습니다. ] ");
							} else if (delete.deleteperson(delete.selectIdx(id)) == 0) {
								System.out.println("주소록에 없는 사람입니다.");
							}
							
							break;
						case 5:
							int u_idx = insert.idx(id);
							
							System.out.println("<5.검색하기>");

							System.out.print("  ●  이름을 입력하세요: ");
							String name = scan.next();

							
							search.searchDetail(name,u_idx);
							
							break;
						case 6:
							// 종료하는 부분
							System.out.println();
							break stop;
							
							
						case 7:
							// 설정하는 부분
							System.out.println("<7.설정>");
							System.out.println();
							System.out.println("1.탈퇴하기  2.user이름 수정하기  3.로그아웃");
							System.out.print("번호 선택  :  ");
							num = scan.nextInt();

							if(num ==1) {
								System.out.print("id 를 입력해주세요 : ");
								id = scan.next();
								System.out.print("비밀번호 를 입력해주세요 : ");
								password = scan.next();
                                System.out.print("정말로 탈퇴하시겠습니까? < 1 : yes> : ");
                                num = scan.nextInt();
								
								if(num==1) {
									delete.deleteIdxPerson(delete.selectIdx(id));
									if (delete.delete(id, password) == 1) {
										System.out.println();
										System.out.println("------------------------------------------");
										System.out.println("회원정보가 삭제되었습니다.");
										System.out.println("안녕히 가세요.");
										System.out.println("------------------------------------------");
										System.out.println("******************************************");
										break start;
									} else if (delete.delete(id, password) == 0) {
										System.out.println("회원정보가 일지하지 않습니다.");
									}
								} 
								
							} else if(num == 3) {
								ConsoleTextColor.printColorln("로그아웃 되었습니다.", "purple");
								
								break stop;
							} else
								System.err.println("잘못 눌렀습니다.");
							break;
						default:
							System.err.println("잘못 입력했습니다.");
							break;
						}
					}

				}

			} else if(start==2) {
				System.out.println("    >>>>   회원가입  하기   <<<<   ");
				login.join();
			} else
				System.err.println("잘못 입력했습니다.");
		}

	}




}
