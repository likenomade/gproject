package javaTest;

import static org.junit.Assert.*;
import org.junit.Test;

//맴버 필드 3개 정의 , 맴버 필드 3개를 초기화 하는 생성자를 만드세요~
class Book{
	String title;
	String author;
	int price;

	Book(String title, String author, int price) {
		this.title = title;
		this.author = author;
		this.price = price;
	} // 생성자

	public boolean isBook(boolean b) {
		return b;
	}//isBook
}//Book


//** @ 종류
//=> @Before - @Test - @After
//=> @ 적용 메서드 : non static, void 로 정의 해야 함.

//** org.junit.Assert 가 지원하는 다양한 Test용 Method 
//1. assertEquals(a,b) : a와 b의  값(Value) 이 같은지 확인
//2. assertSame(a,b) : 객체 a와b가 같은 객체임(같은 주소) 을 확인
//3. assertTrue(a) : a가 참인지 확인
//4. assertNotNull(a) : a객체가 Null 이 아님을 확인
//5. assertArrayEquals(a,b) : 배열 a와b가 일치함을 확인

public class ex01_BookTest {

	//1). assertEquals(a,b)  : a와 b의  값(Value) 이 같은지 확인
	public void equalsTest() {
		Book b1 = new Book("노인과 바다","헤밍웨이",79000);
		assertEquals(b1.author,"홍길동");
		//True : 성공 , False : 실패(오류)
	}
	
	//2) assertSame(a,b) : 객체 a와b가 같은 객체임(같은 주소) 을 확인
	public void SameTest() {
		Book b1 = new Book("노인과 바다","헤밍웨이",79000);
		Book b2 = new Book("개미","베르나르베르베르",81000);
		Book b3 = new Book("홍길동전","작가미상",11000);
		assertSame(b1,b2); //False 가나옴
		//결과 true 로 만들려면 b3=b2; 하고  assertSame(b3,b2); 
	}

	   // 3) assertTrue(a) a가 참인지 확인
	public void trueTest() {
		Book b1 = new Book("노인과 바다","헤밍웨이",79000);
		assertTrue(b1.isBook(true));
		//True : 성공 , False : 실패(오류)
	}

	//4. assertNotNull(a) : a객체가 Null 이 아님을 확인
	public void notNullTest() {
		Book b1 = new Book("노인과 바다","헤밍웨이",79000);
		Book b2 = null;
		// assertNotNull(b1);  //True
		 assertNotNull(b2);  //False
	}
	
	@Test
	//5. assertArrayEquals(a,b) : 배열 a와b가 일치함을 확인
	public void ArrayEqualsTest() {
		String[] a1 = new String[] {"가","나","다"};
		String[] a2 = new String[] {"가","나","다"};
		String[] a3 = new String[] {"가","다","나"};
		String[] a4 = new String[] {"가","라","다"};
		//5.1  두배열의 순서 ,값 모두 동일(a1,a2)
	//	assertArrayEquals(a1, a2); //True
		//5.2  두배열의 순서가 다르나  값은  동일(a2,a3)
	//	assertArrayEquals(a2, a3); //False
		//5.3  두배열의 순서,  값은 모두 다를경우(a3,a4)
		assertArrayEquals(a3, a4); //False
	}
} // BookTest
