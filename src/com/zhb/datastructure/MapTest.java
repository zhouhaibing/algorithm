package com.zhb.datastructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapTest {
	public static void main(String[] args){
		//����map
//		Map<String,String> map = new HashMap<String,String>();
//		map.put("a", "aa");
//		map.put("b", "bb");
//		map.put("c", "cc");
//		map.put("d", "aa");
//		for(Map.Entry<String, String> m : map.entrySet()){
//			System.out.println(m.getKey() + "  " + m.getValue());
//		}
//		if(map.containsValue("aa"))
//			System.out.println("have a");
		
		//�ϲ�����list�γ�һ���µ�list
		ArrayList<String> list = new ArrayList<String>();
		list.add("str1");
		list.add("str2");
		list.add("str3");
		List<String> list2 = new ArrayList<String>();
		list.add("strq");
		list.add("strw");
		list.add("stre");
		List<String> listAll = (ArrayList<String>)list.clone();
		listAll.addAll(list2);
		for(String s : listAll){
			System.out.println(s);
		}
		
	}

}
