
public class OtherClass {
	int y;
	public void methodOther1() {
		this.y=5;
		this.methodOther2();
		System.out.println("Hello ini adalah method other");
	}
	public void methodOther2() {
		System.out.println("Hello ini adalah method other");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyClass obj = new MyClass();
		obj.x = 25;
		MyClass obj2 = new MyClass();
		System.out.println("nilai x obj1 :" + obj.x); // 25
		System.out.println("nilai x obj2 :" + obj2.x); //5
		MyClass.method1();
		//obj.method2();
		//MyClass.method2();
		System.out.println("My Counter : " + MyClass.counter);
		
		//Call private property
		obj.setMyVariable(1000);
		System.out.println("Nilai MyVariable: " + obj.getMyVariable());
		
	}
}
