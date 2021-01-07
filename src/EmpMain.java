

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import emp.EmpVO;
import emp.Login;
import emp.empDataSet;

public class EmpMain {
	Scanner scan = new Scanner(System.in);
	public EmpMain() {
		
	}
	public void start() {
		// 아이디와 비밀번호를 입력받아 로그인 구현하기 
		Login.id = conInput("아이디");
		Login.pwd = conInput("비밀번호");
		if(Login.loginCheck()) { //로그인 성공 시 메뉴를 보여줘야
			//초기데이터 셋팅 
			empDataSet.setEmpList();
			do {
				String menu=conInput("메뉴[1.사원전체 목록, 2.사원등록, 3.사원수정, 4.사원삭제, 5.프로그램종료]");
				if(menu.equals("5")) {
					break;
				}else if(menu.equals("1")) {//사원목록 
					empOutput();
				}else if(menu.equals("2")) {//사원등록 
					empInsert();
					empOutput();
				}
			
			}while(true);
			
		}else { //로그인 실패 
			System.out.println("로그인 실패하였습니다.");
		}
		
	}
	//사원 전체 목록 출력 
	public void empOutput() {
		Set<String> KeyList = empDataSet.empList.keySet();
		Iterator<String> ii = KeyList.iterator();
		while(ii.hasNext()) {
			EmpVO vo = empDataSet.empList.get(ii.next());
			System.out.printf("%d\t%s\t%s\t%s\t%s\n", vo.getEmpNo(), vo.getEmpName(), 
								vo.getTel(), vo.getDepart(), vo.getPosition());
		}
	}
	//사원등록 
	public void empInsert() {
		int no = Integer.parseInt(conInput("사원번호"));
		String name = conInput("사원명");
		String tel = conInput("연락처");
		String depart = conInput("부서명");
		String position = conInput("직급");
		
		empDataSet.empList.put(name, new EmpVO(no, name, tel, depart, position));
	}
	//콘솔에서 문자 입력받아서 리턴하는 메소드 
	public String conInput(String msg) {
		System.out.print(msg+ "=");
		return scan.nextLine();
	}
	
	public static void main(String[] args) {
		new EmpMain().start();
		System.out.println("프로그램 종료 되었습니다");
	}

}
