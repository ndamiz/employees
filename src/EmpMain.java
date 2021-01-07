

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
				}else if(menu.equals("2")) {//사원등록 
					empInsert();
				}else if(menu.equals("3")) {//사원수정 
					empEdit();
				}else if(menu.equals("4")) {//사원삭제
					empDel();
				}
				//모든 문장이 끝나고 Output이 필요하므로, 아예 if 문 밖으로 빼서 실행되게 하자  
				empOutput();
			
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
	//사원수정 (tel, depart, position만 수정가능)
	public void empEdit() {
		//사원명 입력받기 
		String empName = conInput("수정할 사원 명"); 
		// 해당 사원의 정보가 없을때 
		EmpVO vo = empDataSet.empList.get(empName);
		if(vo==null) {
			System.out.println("존재하지 않는 사원명입니다... ");
		}else { //해당사원의 정보가 있을 때 
			// 연락처 , 부서명, 직급 
			String subMenu = conInput("수정할 필드 선택 [1.연락처, 2.부서명, 3.직급]");
			if(subMenu.equals("1")) {
				String tel = conInput("수정할 연락처");
				vo.setTel(tel);
			}else if(subMenu.equals("2")) {
				String depart = conInput("수정할 부서명");
				vo.setDepart(depart);
			}else if(subMenu.equals("3")) {
				String position = conInput("수정할 직급");
				vo.setPosition(position);
			}
		}
	}
	public void empDel() { //사원명 입력받아 삭제 
		String empName = conInput("삭제할 사원명");
		empDataSet.empList.remove(empName);
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
