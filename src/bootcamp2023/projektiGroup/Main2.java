package bootcamp2023.projektiGroup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main2 {
	public static void main(String[] args) {
		List<Integer> l1 = new ArrayList<>();
		l1.add(1);
		l1.add(5);
		l1.add(3);
		l1.add(7);		

		List<Integer> l2 = new ArrayList<>();
		l2.add(3);
		l2.add(8);
		String name1= "Antonela";
		String name2 = "Arber";
		
		 Map<String, List<Integer>> map = new HashMap<>();
		map.put(name1, l1);
		map.put(name2, l2);
		
		afisho(map);

	
		
		
		
}
	
	public static  Map<String, List<Integer>> afisho(Map<String, List<Integer>> map){
		Map<String, List<Integer>> newMap = new HashMap<>();
		for(Map.Entry<String, List<Integer>> map1: map.entrySet()) {
			String n = map1.getKey();
		//	System.out.println("n1: " + n);
			List<Integer> numb = map1.getValue();
			System.out.println(numb);
			for(int i : numb) {
				if(i != 1) {
					numb.add(i);
					newMap.put(n, numb);
				}
			}
				//	newMap.put(n, numb);
					//System.out.println(newMap);
		}
		
		return newMap;
		
	}
}
