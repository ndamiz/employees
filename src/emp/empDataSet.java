package emp;

import java.util.HashMap;

// 원래 데이터베이스에서 받아와야 하는정보를 가상으로 여기에 입력할 것입니다. 
public class empDataSet {
	public static HashMap<String, EmpVO> empList = new HashMap<String, EmpVO>();
	public empDataSet() {
	}
	public static void setEmpList() {
		empList.put("홍과장", new EmpVO(1, "홍과장", "010-1111-2222", "총무부", "과장"));
		empList.put("이부장", new EmpVO(2, "이부장", "010-3333-4444", "인사부", "부장"));
		empList.put("박대리", new EmpVO(3, "박대리", "010-5555-9999", "기획부", "대리"));
		empList.put("김대리", new EmpVO(4, "김대리", "010-9999-3333", "영업부", "대리"));
		empList.put("정신입", new EmpVO(5, "정신입", "010-0000-0000", "기획부", "사원"));
	}
}
