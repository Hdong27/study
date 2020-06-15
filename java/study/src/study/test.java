package study;

public class test {
	public static void main(String[] args) {
		/**
		 * stack 테스트
		 */
		
		/*
		Stack st = new Stack();
		
		System.out.println("비어있는가 : " + st.isEmpty());

		st.push(1);
		st.push(2);
		st.push(3);
		st.push(2);
		st.push(1);

		System.out.println("현재 스택의 길이 : " + st.getLength());
		System.out.println("현재 값 검색 : " + st.peek());
		System.out.println("현재 값 검색 후 빼기 : " + st.pop());
		System.out.println("현재 값 검색 후 빼기 : " + st.pop());
		System.out.println("현재 값 검색 : " + st.peek());
		
		System.out.println("비어있는가 : " + st.isEmpty());

		Stack st2 = new Stack();
		
		for (int i = 1; i <= 100; i++) {
			st2.push(i);
		}
		
		System.out.println("가득찼는가 : " + st2.isFull());
		
		for (int i = 0; i < 100; i++) {
			System.out.println(st2.pop());
		}
		*/
		
		Queue q = new Queue();
		
		System.out.println(q.pull());
		
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		q.add(5);
		
		System.out.println(q.getLength());
		System.out.println(q.peek());
		System.out.println(q.pull());
		System.out.println(q.pull());
		System.out.println(q.pull());
		System.out.println(q.pull());
	}
}
