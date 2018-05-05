package com.zhb.datastructure;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetTest {
	public static void main(String[] args){
		Set s = new HashSet();
		s.add(new Student(1,"zhb"));
		s.add(new Student(2,"lala"));
		System.out.println(s.size());
		
		//Set<Student> s1 = new TreeSet<Student>(new StudentComparator());
		//上面使用自定义的排序会覆盖该类实现comparable接口
		Set<Student> s1 = new LinkedHashSet<Student>();
		s1.add(new Student(1,"zhb"));
		s1.add(new Student(3,"xhb"));
		s1.add(new Student(2,"diej"));
		s1.add(new Student(2,"ggghb"));
		for(Student stu : s1){
			System.out.println(stu.num + " " + stu.name);
		}
		
		Integer i = 128;
		int j = 128;
		System.out.println(i==j);
		
		Integer t1 = 127;//java在编译的时候,被翻译成-> Integer i5 = Integer.valueOf(127);
		Integer t2 = 127;
		System.out.println(t1 == t2);
		
		Integer m1 = 128;
		Integer m2 = 128;
		System.out.println(String.valueOf(m1 == m2) + " " + m1.hashCode() + " " + m2.hashCode());
		//m1,m2的hashcode都是128,重写了object的hashcode，返回的是拆箱后的int值。
		
		Integer m3 = new Integer(127);
		System.out.println(t1 == m3);
		
		System.out.println(100%3);
		System.out.println(-100%3.0);
	}

}

class Student implements Comparable{
	public int num;
	public String name;
	public Student(int num,String name){
		this.num = num;
		this.name = name;
	}
	
	public int hashCode(){
		return num * name.hashCode();
	}
	public boolean equals(Object o){
		if(o instanceof Student){
			Student s = (Student)o;
			return s.num == this.num && s.name.equals(this.name);
		}
		return false;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		int result = 0;
		if(o instanceof Student){
			Student s = (Student)o;
			result = s.num == this.num ? 0 : (s.num < this.num) ? 1 : -1; 
			if(result == 0){
				result = s.name.compareTo(this.name) * -1;
			}
		}		
		return result;
	}
}

class StudentComparator implements Comparator<Student>{

	@Override
	public int compare(Student a, Student b) {
		// TODO Auto-generated method stub
		int result = 0;
		if(a instanceof Student && b instanceof Student){
			Student s1 = (Student)a;
			Student s2 = (Student)b;
			result = s1.num == s2.num ? 0 : (s1.num < s2.num) ? 1 : -1; 
			if(result == 0){
				result = s1.name.compareTo(s2.name) * -1;
			}
		}
		return result;
	}
	
}