package javaTest;

import static org.junit.Assert.*;
import org.junit.Test;


//맴버 필드 3개 정의 , 맴버 필드 3개를 초기화 하는 생성자를 생성
class Car{
	String name;
	String color;
	int price;

	Car(String name, String color, int price) {
		this.name = name;
		this.color = color;
		this.price = price;
	}

	public boolean isCar(boolean c) {
	return c;
		
	}//isCar
}//Car


public class test1 {
	//1). assertEquals(a,b)  : a와 b의  값(Value) 이 같은지 확인
		public void equalsTest() {
			Car c1 = new Car("제네시스","white",1500000);
			assertEquals(c1.color,"black");
			//True : 성공 , False : 실패(오류)
		}
		
		
		
		//2) assertSame(a,b) : 객체 a와b가 같은 객체임(같은 주소) 을 확인
		public void SameTest() {
			Car c1 = new Car("제네시스","white",1500000);
			Car c2 = new Car("벤츠","black",190000);
			 c1=c2; 
			assertSame(c1,c2); 
		}
		
		@Test
		//3. assertArrayEquals(a,b) : 배열 a와b가 일치함을 확인
		public void ArrayEqualsTest() {
			String[] a1 = new String[] {"가","나","다"};
			String[] a2 = new String[] {"가","나","바"};
			assertArrayEquals(a1, a2); 
		}
	
	
}




























