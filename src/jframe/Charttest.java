//package jframe;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Set;
//
//public class Charttest {
//	public static void main(String[] args) {
//		HashMap<String, Integer> hm = new HashMap<String, Integer>();
//		String a = "";
//		String b = "";
//
//		int x = 0;
//		int y = 0;
//		hm.put("이씨", 3);
//		hm.put("김씨", 5);
//		hm.put("박씨", 7);
//
//		// keySet을 이용한 방법
//		List<String> list1 = new ArrayList<>();
//		List<Integer> list2 = new ArrayList<>();
//
//		Iterator<String> iter = hm.keySet().iterator();uS
////		iter.hasNext();
////		String key = iter.next();
////		int score = hm.get(key);
//
//		for (int i = 0; i < hm.size(); i++) {
//			iter.hasNext();
//			String key = iter.next();
//			list1.add(key);
//			int score = hm.get(key);
//			list2.add(score);
//		}
//		a = list1.get(0);
//		b = list1.get(1);
//
//		x = list2.get(0);
//		y = list2.get(1);
//
//		System.out.println(a);
//		System.out.println(b);
//
//		System.out.println(x);
//		System.out.println(y);
//
////		while (iter.hasNext()) {
////			String key = iter.next();
////			System.out.println(key);
////			System.out.println(hm.get(key));
////			list1.add(key);
////			list2.add(hm.get(key));
////		}
//
////		System.out.println(list1);
////		System.out.println(list2);
//	}
//}
