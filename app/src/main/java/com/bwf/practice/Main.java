package com.bwf.practice;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
	public static void main(String[] args) throws Exception, SecurityException {
		//test();
		
		//testNewInstance1();
		//testNewInstance2();
		// ��ʾ���ô�������Method����
		//testInvokePrivateMethod2();
	}

	private static void testInvokePrivateMethod2()
			throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		Class cls = Person.class;
		Person p = new Person();
		Method m = cls.getDeclaredMethod("test", int.class, int.class);
		m.setAccessible(true);
		m.invoke(p, 200, 500);
	}

	private static void testNewInstance2()
			throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
		Class cls = Person.class;
		Constructor constructor = cls.getDeclaredConstructor(null);
		constructor.setAccessible(true);
		Object obj = constructor.newInstance(null);
		if(obj instanceof Person){
			System.out.println("obj��Person����");
		} else {
			System.out.println("----------obj����Person����");
		}
	}

	private static void testNewInstance1()
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		// ����:ͨ��������ƻ�ȡPerson�Ķ���p
		Class cls = Class.forName("com.test.Person");
		Object obj = cls.newInstance();
		if(obj instanceof Person){
			System.out.println("obj��Person����");
		} else {
			System.out.println("----------obj����Person����");
		}
	}

	private static void test() throws ClassNotFoundException {
		// ��ȡPerson���Class����
//		Class cls = null;
//		cls = Person.class;
//		cls = Class.forName("com.test.Person");
//		Person person = new Person();
//		cls = person.getClass();
		
		//testField(cls);
		//testMethod(cls);
		
		//testModifyPrivateField(cls, person);
		
		// ����:����Person�е�˽�з���printName
		//testInvokePrivateMethod(cls, person);
	}

	private static void testInvokePrivateMethod(Class cls, Person person)
			throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		Method method = cls.getDeclaredMethod("printName", null);
		method.setAccessible(true);
		method.invoke(person, null);
	}

	// �����Person˽������name�޸�Ϊ"����"
	private static void testModifyPrivateField(Class cls, Person person)
			throws NoSuchFieldException, IllegalAccessException {
		System.out.println("�޸�ǰPerson��nameΪ:"+person.getName());
		Field field = cls.getDeclaredField("name");
		field.setAccessible(true);
		field.set(person, "����");
		System.out.println("�����޸ĺ�Person��nameΪ:"+person.getName());
	}

	private static void testMethod(Class cls) throws NoSuchMethodException {
		Method[] methods = cls.getMethods();
		for (Method method : methods) {
			System.out.println(method.getName());
		}
		
		System.out.println("....................");
		methods = cls.getDeclaredMethods();
		for (Method method : methods) {
			System.out.println(method.getName());
		}
		
		Method method = cls.getDeclaredMethod("getAge", null);
		System.out.println(method);
		
		//method = cls.getDeclaredMethod("test", Class<Integer.class>);
		//System.out.println(method);
	}

	private static void testField(Class cls) throws NoSuchFieldException {
		// ��ȡPerson�е�Field����
		Field[] fields = cls.getFields();
		System.out.println("Person�������еĹ�������:"+fields.length);
		for (Field field : fields) {
			System.out.println(field.getName());
		}
		
		System.out.println("------------------");
		fields = cls.getDeclaredFields();
		for (Field field : fields) {
			System.out.println(field.getName());
		}
		System.out.println("Person�������е���������:"+fields.length);
		
		// �õ�tag����Field����
		Field fieldTag = cls.getField("tag");
		System.out.println(fieldTag.getName());
		Field fieldName = cls.getDeclaredField("name");
		System.out.println(fieldName.getName());
	}

	/*private static void testChar() {
		char c = 'Ů';
		System.out.println((char)(c+19));
		System.out.println((char)(c+20));
		System.out.println((char)(c+21));
	}*/
	
}
