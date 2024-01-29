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
		
		Delete delete = new Delete();
		
		G_Test test = new G_Test();
		
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
							
							test.selectList(test.selectIdx(id));
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
							String address = scan.next();

							System.out.print(" -  별명 : ");
							String nickName = scan.next();
							
							System.out.print(" -  카테고리 : ");
							String category = scan.next();
							
							System.out.println();
							System.out.println(person.toString());
							
							person = new Person(name,age,gender, phone, MBTI,address, nickName, category, insert.selectIdx(id));

							insert.insert(person);
							
							System.out.println();
							System.out.println(" [ 등록되었습니다. ] ");

							break;
						case 3:
						    // 수정하는 부분
						    System.out.println("<3.수정하기>");
						    System.out.println();

						    // 현재 사용자의 정보 출력
						    System.out.println(" 현재 정보:");
						    System.out.println(person.toString());

						    // 수정할 정보 입력
						    System.out.print(" 새로운 이름 입력: ");
						    String newName = scan.next();
						    person.setName(newName);

						    System.out.print(" 새로운 나이 입력: ");
						    String newAge = scan.next();
						    person.setAge(newAge);

						    System.out.print(" 새로운 성별 입력: ");
						    String newGender = scan.next();
						    person.setGender(newGender);

						    System.out.print(" 새로운 전화번호 입력( - 포함해서 입력해주세요): ");
						    String newPhone = scan.next();
						    person.setPhoneNumber(newPhone);

						    System.out.print(" 새로운 MBTI 입력: ");
						    String newMBTI = scan.next();
						    person.setMBTI(newMBTI);

						    System.out.print(" 새로운 주소 입력: ");
						    String newAddress = scan.next();
						    person.setAddress(newAddress);

						    System.out.print(" 새로운 별명 입력: ");
						    String newNickName = scan.next();
						    person.setNickName(newNickName);

						    System.out.print(" 새로운 카테고리 입력: ");
						    String newCategory = scan.next();
						    person.setCategory(newCategory);

						    // 수정된 정보를 데이터베이스에 업데이트
//						    update.Update(person);

						    System.out.println();
						    System.out.println(" [ 수정되었습니다. ] ");
						    break;

						case 4:
	// 삭제하는 부분  || 삭제 할 사람 정하는 것을 번호로 할 것인지, 이름으로 할 것인지?
							System.out.println("<4.삭제하기>");
							System.out.println();
							System.out.print("삭제할 사람의 이름을 입력해주세요 : ");
							String d = scan.next();
							System.out.print("삭제할 사람의 번호를 입력해주세요 : ");	
							String p = scan.next();
							
							if(delete.deleteperson(d,p,delete.selectIdx(id))==1) {
								System.out.println(" [ 삭제되었습니다. ] ");
							} else if (delete.deleteperson(d,p,delete.selectIdx(id)) == 0) {
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
				System.out.print("  ●  아이디를 입력하세요: ");
				String newId = scan.next();
				
				System.out.print("  ●  비밀번호를 입력하세요: ");
				String newPassword = scan.next();
				
				login.join(newId, newPassword);		
			} else
				System.err.println("잘못 입력했습니다.");
		}

	}
}
