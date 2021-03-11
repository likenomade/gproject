package javaTest;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.DriverManager;
import org.junit.Test;

//** @ 종류
//=> @Before - @Test - @After
//=> @ 적용 메서드 : non static, void 로 정의 해야 함.
public class ex02_DBConnection {
	
	
	//1) nonStatic, void Test
	public void getConnectionNon() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 1) DB 드라이버 이름 지정
			String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";// 2) DB 드라이버 위치 지정
			DriverManager.getConnection(url, "student", "test1"); // 3) 로그인 ( Connection 생성 )
			System.out.println("** DB 연결 성공**");  //green 으로 나옴
		} catch (Exception e) {
			System.out.println("** DB 연결 실패 => "+e.toString()); //green 으로 나옴 sysout으로 확인할수있다.
		}
	}//getConnectionNon
	
	
	//2) static Test
	//=> test method 를 작성해서 Test
	public static Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 1) DB 드라이버 이름 지정
			String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";// 2) DB 드라이버 위치 지정
			return DriverManager.getConnection(url, "student", "test"); // 3) 로그인 ( Connection 생성 )
		} catch (Exception e) {
			System.out.println("** DB 연결 실패 => "+e.toString());
			return null;
		}
	} // getConnection
	
	@Test
	//연결 성공 : NotNull  / 실패 : Null
	public void connectionTest() {
		System.out.println("** Connection => "+getConnection());
	  assertNotNull(getConnection()); //성공 : green , 실패 : red
	}
	
}//class

//DB 드라이버 이름 지정
//DB 드라이버 위치 지정
//Connection 생성
