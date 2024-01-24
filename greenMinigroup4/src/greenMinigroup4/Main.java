package greenMinigroup4;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		User user = new User();
		Person person = new Person();
		Login login = new Login();
		Search search = new Search();
		Delete delete = new Delete();
		Insert insert = new Insert();
		
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
							// 회원 리스트 나온다.
							System.out.println();
							if (person.getName() == null) {
								System.out.println("   등록된 사람이 없습니다.  ");
							} else {
								int n = 0;
								n++;
								System.out
										.println(num + ". " + person.getName() + " : " + person.getPhoneNumber());
							}

							break;
						case 2:
							// 등록하는 입력 창

							System.out.println("<2.등록하기>");
							System.out.println();

							System.out.print(" -  이름 : ");
							String name = scan.next();
							
							System.out.print(" -  나이 : ");
							String age = scan.next();

							System.out.print(" -  성별 : ");
							String gender = scan.next();

							System.out.print(" -  전화번호( - 포함해서 입력해주세요) : ");
							String phone = scan.next();

							System.out.print(" -  MBTI : ");
							String MBTI = scan.next();

							System.out.print(" -  주소 : ");
							String adr = scan.next();

							System.out.print(" -  별명 : ");
							String nick = scan.next();
							
							System.out.print(" -  카테고리 : ");
							String ca = scan.next();
							
							System.out.println();
							System.out.println(person.toString());
							
							person = new Person(name,age,gender, phone, MBTI,adr,nick,ca,user.getIdx());
							insert.insert(person);
							
							System.out.println();
							System.out.println(" [ 등록되었습니다. ] ");

							break;
						case 3:
							// 수정하는 부분
							System.out.println("<3.수정하기>");
							System.out.println();

							System.out.println(" 이름 수정하기 = " + person.getName()+ " -> ");
							person.setName(scan.next());

							System.out.println();
							System.out.println(" [ 수정되었습니다. ] ");
							break;
						case 4:
	// 삭제하는 부분  || 삭제 할 사람 정하는 것을 번호로 할 것인지, 이름으로 할 것인지?
							System.out.println("<4.삭제하기>");
							System.out.println();
							System.out.print("삭제할 사람의 번호는 입력해주세요 : ");	
							int d = scan.nextInt();
							
							if(delete.deleteperson(d)==1) {
								System.out.println(" [ 삭제되었습니다. ] ");
							} else if (delete.deleteperson(d) == 0) {
								System.out.println("주소록에 없는 사람입니다.");
							}
							
							break;
						case 5:
							// 검색하는 부분
							System.out.println("<5.검색하기>");
							System.out.println("검색어를 입력하세요 : ");
							String keyword = scan.next();
							
							break;
						case 6:
							// 종료하는 부분
							System.out.println();
							break stop;
						case 7:
							// 설정하는 부분
							System.out.println("<7.설정>");
							System.out.println();
							System.out.println("1.탈퇴하기  2.user이름 수정하기");
							num = scan.nextInt();
							if(num ==1) {
								System.out.print("id 를 입력해주세요 : ");
								id = scan.next();
								System.out.print("비밀번호 를 입력해주세요 : ");
								password = scan.next();
								
								if(num==1) {
									if (delete.delete(id, password) == 1) {
										System.out.print("정말로 탈퇴하시겠습니까? < 1 : yes> : ");
										num = scan.nextInt();
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
								
							}
							break;
						default:
							break;
						}
					}

				}

			} else if(start==2) {
				System.out.println("    >>>>   회원가입  하기   <<<<   ");
				System.out.println("  ●  아이디를 입력하세요: ");
				String newId = scan.next();
				
				System.out.println("  ●  비밀번호를 입력하세요: ");
				String newPassword = scan.next();
				
				login.join(newId, newPassword);
				
			}
		}

	}
}
