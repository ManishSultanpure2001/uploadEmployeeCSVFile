package com.postgres.programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Stack;
import java.util.TreeSet;

public class TestPrograms {

	public static void removeDuplicate() {
		int x[] = {12, 33, 23, 12, 32};
		LinkedHashSet<Integer> hashSet = new LinkedHashSet<Integer>();
		for (int i = 0; i < x.length; i++) {
			hashSet.add(x[i]);
		}
		System.out.println(hashSet);

	}

	public static void firstNonRepeatingCharecter() {
		String string = "my nayme is manish";
		for (int i = 0; i < string.length(); i++) {
			if (string.indexOf(string.charAt(i)) == string.lastIndexOf(string.charAt(i))) {
				System.out.println("First non reppeating = " + string.charAt(i));
				break;
			}
		}
	}

	public static void removeGivenCharecter() {
		String string = "my name is manish";
		char c = 'm';
		for (int i = 0; i < string.length(); i++) {
			string = string.replace(Character.toString(c), "");
		}
		System.out.println(string);
	}

	public static void stringInterMethod() {
		// S1 refers to Object in the Heap Area
		String s1 = new String("GFG"); // Line-1
		String s5 = new String("GFG"); // Line-1

		// S2 refers to Object in SCP Area
		String s2 = s1.intern(); // Line-2
		String s4 = s2.intern(); // Line-2

		// Comparing memory locations
		// s1 is in Heap
		// s2 is in SCP
		System.out.println(s1 == s2);
		System.out.println(s1 == s5);
		System.out.println(s2 == s4);

		// Comparing only values
		System.out.println(s1.equals(s2));

		// S3 refers to Object in the SCP Area
		String s3 = "GFG"; // Line-3

		System.out.println(s2 == s3);
	}

	public static void checkOperatorSize() {
		Number iNumber = new Integer(10);
		Number bNumber = new Byte((byte) 10);
		Number sNumber = new Short((byte) 10);
		Number dNumber = new Double(10.9);
		Number lNumber = new Long(109988898);

		System.out.println(Integer.SIZE);

		Byte byte1 = new Byte((byte) 130);
		System.out.println(byte1);
	}

	public static void varArgsExtract(int... x) {
		List<Object> list = new ArrayList<Object>();
		for (int y : x) {
			list.add(new Integer(y));
		}
		System.out.println(list);
	}

	public static void stringSort() {
		TreeSet<String> tSet = new TreeSet<String>((a, b) -> a.compareTo(b));
		tSet.add("Ram");
		tSet.add("Sita");
		tSet.add("Gita");
		tSet.add("Amit");

		System.out.println(tSet);
	}

	public static void sortStringInDecedingOrder() {
		TreeSet<String> tSet = new TreeSet<String>((a, b) -> -a.compareTo(b));
		tSet.add("Ram");
		tSet.add("Sita");
		tSet.add("Gita");
		tSet.add("Amit");

		System.out.println(tSet);
	}

	public static void sortStringOnTheBasisOFLastCahrecter() {
		TreeSet<String> tSet = new TreeSet<String>((a, b) -> a.charAt(a.length() - 1) - b.charAt(b.length() - 1));
		tSet.add("Ram");
		tSet.add("Sita");
		tSet.add("Gita");
		tSet.add("Amit");

		System.out.println(tSet);
	}

	public static void sortStringOnTheBasisOFLastCahrecterIfSameThanSecondLast() {
		TreeSet<String> tSet = new TreeSet<String>((a, b) -> (a.charAt(a.length() - 1) == b.charAt(b.length() - 1))
				? a.charAt(a.length() - 2) - b.charAt(b.length() - 2)
				: a.charAt(a.length() - 1) - b.charAt(b.length() - 1));
		tSet.add("Ram");
		tSet.add("Sita");
		tSet.add("Gita");
		tSet.add("Amit");

		System.out.println(tSet);
	}

	public static void listCheck() {
		ArrayList list1 = new ArrayList();
		list1.add(10);
		list1.add(20);
		list1.add(30);
		list1.add(40);

		ArrayList list2 = new ArrayList();
		list2.add(10);
		list2.add(20);
		list2.add(30);
		list2.add(40);

		ArrayList list3 = new ArrayList();
		list3.add(10);
		list3.add(20);
		list3.add(30);
		list3.add(40);
		System.out.println(list1.equals(list2));
		System.out.println(list1.equals(list3));
	}

	public static void arraySort() {
		int x[] = { 12, 32, 13, 42, 13, 2, 1 };
		TreeSet<Integer> treeSet = new TreeSet<Integer>((a, b) -> -a.compareTo(b));
		for (int y : x) {
			treeSet.add(y);
		}
		System.out.println(treeSet);

		String string = new String("Ram ji");
		String string2 = new String("Ram ji");
		String string5 = "Ram ji";
		String string6 = "Ram ji";
		System.out.println(string5 == string6);

		String string3 = new String("Ram ji").intern();
		String string4 = new String("Ram ji").intern();

		System.out.println(string3 == string4);
//		System.out.println(string3);
	}

	static Boolean boolean1 = false;

	public static void concurrentCheck() {
		Collection list1 = new ArrayList();
		list1.add(10);
		list1.add(20);
		list1.add(30);
		list1.add(40);
		for (Object object : list1) {
			// System.out.println(object);
		}

		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(null, null);
		// System.out.println(map);
		boolean1 = true;
		System.out.println(boolean1);
	}

	public static boolean validation(String s) {

//			String[] str = s.split(" ");
		int x[] = new int[26];
		char[] charArray = s.toLowerCase().toCharArray();
		Arrays.sort(charArray);
		System.out.println(charArray);
		String s2 = "abc";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) - 97 >= 0 && s.charAt(i) - 97 <= 26) {
				x[s.charAt(i) - 97]++;
			}
		}
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < charArray.length; j++) {
				if (charArray[j] == s.charAt(i)) {

				}
			}
		}
		return false;
	}

	public static int maxValue(int x[]) {
		int max = x[0];
		for (int i = 1; i < x.length; i++) {
			if (x[i] > max) {
				max = x[i];
			}
		}
		return max;
	}

	public static Collection<Integer> removeDuplicate1(){
		Integer x[]= {123,42,123,23,13,231,12,42};
		List<Integer> list=new ArrayList<Integer>(Arrays.asList(x));
	    Comparator cmp = Collections.reverseOrder();  
	   System.out.println(cmp.toString());
	    Collections.sort(list,cmp);  
	   return list;
	   
	}
	public static boolean balanceparanthisis(String str){
		
		Stack<Character> stack=new Stack<Character>();
	int i=0;
	while(str.length()>=i) {
		if(str.charAt(i)=='{'||str.charAt(i)=='('||str.charAt(i)=='[') {
			stack.push(str.charAt(i));
		}
		else if (str.charAt(i)=='}'||str.charAt(i)==')'||str.charAt(i)==']') {
			if(stack.peek()=='{') {
				stack.pop();
			}
		
				
			if(stack.peek()=='(') {
				stack.pop();
			}
			}
			if(stack.peek()=='[') {
				stack.pop();
			}
	i++;	
	}
	return false;
	}
	
}
