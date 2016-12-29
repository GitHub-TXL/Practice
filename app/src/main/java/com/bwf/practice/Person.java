package com.bwf.practice;

// Class������
public class Person {
	// Filed�������е�����
	private String name;
	private int age;
	public String tag;
	protected String str;
	// Method�������е���ͨ����
	public String getName(){
		return this.name;
	}
	private int getAge(){
		return this.age;
	}
	// Construtor������Ĺ�����
	public Person(){
		
	}
	private Person(int age){
		
	}
	
	// ����
	private void test(int num){
		System.out.println("���num = "+num);
	}
	
	private void test(int a, int b){
		System.out.println("���a = "+a+", b = "+b);
	}
	
	private void printName(){
		System.out.println("name = "+this.name);
	}
}
