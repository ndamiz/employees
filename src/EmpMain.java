

import java.util.Scanner;

import emp.Login;

public class EmpMain {
	Scanner scan = new Scanner(System.in);
	public EmpMain() {
		
	}
	public void start() {
		// 아이디와 비밀번호를 입력받아 로그인 구현하기 
		Login.id = conInput("아이디");
		Login.pwd = conInput("비밀번호");
		if(Login.loginCheck()) { //로그인 성공 시 메뉴를 보여줘야
			
		}else { //로그인 실패 
			System.out.println("로그인 실패하였습니다.");
		}
	}
	//콘솔에서 문자 입력받아서 리턴하는 메소드 
	public String conInput(String msg) {
		System.out.print(msg+ "=");
		return scan.nextLine();
	}
	
	public static void main(String[] args) {
		new EmpMain().start();

	}

}
