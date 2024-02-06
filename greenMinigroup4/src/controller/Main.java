package controller;

import java.util.Scanner;

import greenMinigroup4.CategorySearch;
import greenMinigroup4.ConsoleTextColor;
import greenMinigroup4.Delete;
import greenMinigroup4.Insert;
import greenMinigroup4.Signup;
import greenMinigroup4.List;
import greenMinigroup4.Login;
import greenMinigroup4.Search;
import greenMinigroup4.Signout;
import greenMinigroup4.Update;
import infor.Person;
import infor.User;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		User user = new User();
		Person person = new Person();
		Login login = new Login();
		Signup signup = new Signup();
		Signout signout = new Signout();
		Search search = new Search();
		Insert insert = new Insert();
		Update update = new Update();
		List list = new List();
		Delete delete = new Delete();
		CategorySearch categorysearch = new CategorySearch();

		boolean check = true;
		String start = null;

		System.out.println("******************************************");
		System.out.println("*             주소록 관리 프로그램             *");
		System.out.println("******************************************");

		start: while (true) {
			System.out.println("------------------------------------------");
			System.out.println(" 1. 로그인           ||  2. 회원가입      ");
			start = scan.next();

			if (start.equals("1")) {
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
						case 1: // 리스트 확인하는 창
							String name = null;
							int u_idx = insert.idx(id);
							System.out.println("<1.리스트>");
							System.out.println();

							list.listall(u_idx);

							break;

						case 2: // 등록하는 입력 창
							System.out.println("<2.등록하기>");
							System.out.println();

							int Insertidx = insert.idx(id);
							insert.insert(person, Insertidx);

							break;

						case 3:// 수정하는 부분
							System.out.println("<3.수정하기>");
							System.out.println();

							System.out.println(" 수정할 사람의 이름을 입력:");
							String OldName1 = scan.next();
							System.out.println(" 수정할 사람의 전화번호를 입력:");
							String OldPhone1 = scan.next();
							int uIdx1 = insert.idx(id);
							
							System.out.println("수정하고자 하는 것을 고르시오");
							System.out.println("1.전체수정 2.이름 3.나이 4.성별 5.전화번호 6.MBTI 7.주소 8.별명 9.카테고리 ");
							int num1 = 0;
							num1 = scan.nextInt();
							if(num1==1) {
								update.AllUpdate(OldName1, OldPhone1, uIdx1);
							}else if(num1==2){
								update.NameUpdate(OldName1, OldPhone1, uIdx1);
							}else if(num1==3){
								update.AgeUpdate(OldName1, OldPhone1, uIdx1);
							}else if(num1==4){
								update.GenderUpdate(OldName1, OldPhone1, uIdx1);
							}else if(num1==5){
								update.PhonenumberUpdate(OldName1, OldPhone1, uIdx1);
							}else if(num1==6){
								update.MBTIUpdate(OldName1, OldPhone1, uIdx1);
							}else if(num1==7){
								update.AddressUpdate(OldName1, OldPhone1, uIdx1);
							}else if(num1==8){
								update.NicknameUpdate(OldName1, OldPhone1, uIdx1);
							}else if(num1==9){
								update.CategoryUpdate(OldName1, OldPhone1, uIdx1);
							}
							System.out.println();
							System.out.println(" [ 수정되었습니다. ] ");
							break;

						case 4: // 삭제하는 부분
							System.out.println("<4.삭제하기>");
							System.out.println();

							delete.deleteChoice(id);

							break;

						case 5: // 검색하는 부분
							u_idx = insert.idx(id);

							System.out.println("<5.검색하기>");
							System.out.println("1.이름으로 검색하기  2.카테고리로 검색하기");
							num = scan.nextInt();

							if (num == 1) {
								System.out.print("  ●  이름을 입력하세요: ");
								name = scan.next();

								search.searchDetail(name, u_idx);

							} else if (num == 2) {
								System.out.print("  ●  카테고리를 입력하세요: ");
								name = scan.next();
								categorysearch.categorysearch(name, u_idx);
							}
							break;

						case 6:
							// 종료하는 부분
							break start;

						case 7:
							// 설정하는 부분
							System.out.println("<7.설정>");
							System.out.println();
							System.out.println("1.탈퇴하기  2.로그아웃");
							num = scan.nextInt();

							if (num == 1) {
								ConsoleTextColor.printColorln("  경고! 신중하게 결정하세요 ", "red");	
								System.out.println("-   회원정보가 삭제됩니다!   -");
								System.out.println();
								System.out.print("  ●  비밀번호 를 입력하세요 : ");
								password = scan.next();
								int dd = delete.selectIdx(id);
								
								if (signout.delete(id, password) == 1) {
									signout.deleteIdxPerson(dd);
									System.out.println();
									System.out.println("------------------------------------------");
									System.out.println(" [ 회원정보가 삭제되었습니다. ] ");
									System.out.println("안녕히 가세요.");
									System.out.println("------------------------------------------");
									System.out.println("******************************************");
									break start;
								} else if (signout.delete(id, password) == 0) {
									System.err.println(" [ 비밀번호가 일지하지 않아서 탈퇴할 수 없습니다. ]");
								}
							} else if (num == 2) {
								ConsoleTextColor.printColorln(" [ 로그아웃 되었습니다. ]", "purple");

								break stop;
							} else
								System.err.println(" [ 잘못 눌렀습니다. ]");
							break;
						default:
							System.err.println(" [ 잘못 입력했습니다. ]");
							break;
						}
					}

				}

			} else if (start.equals("2")) {
				System.out.println("    >>>>   회원가입  하기   <<<<   ");
				signup.join();
			} else
				System.err.println(" [ 잘못 입력했습니다. ]");
		}
		System.out.println(" =========  프로그램이 종료되었습니다.  ========= ");
	}
}
