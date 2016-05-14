import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
/* Most and least repeatable bytes
 * From console enter the name of the file
 * Find the byte with the most and least amount of repeats
 * Display them in a console
 */
public class SimpleAlgorithms {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		FileInputStream fis = null;
		
		/*try catch block in order to catch an exception in case file name
		is incorrect or file does not exist */
		try {
			fis = new FileInputStream(br.readLine());
		} catch (FileNotFoundException e) {}
		findMostRepeatable(fis);
		findLeastRepeatable(fis);
		
		br.close();
		fis.close();
	}
	public static void findLeastRepeatable(FileInputStream fis) throws IOException {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int min = Integer.MAX_VALUE;
		
		while (fis.available() > 0) {
			int i = fis.read();
			if (map.containsKey(i)) {
				map.put(i, map.get(i) + 1);
			} else
				map.put(i, 0);
		}
		for (Map.Entry<Integer, Integer> entrySet : map.entrySet()) {
			if (entrySet.getValue() != 0 && entrySet.getValue() < min) {
				min = entrySet.getValue();
			}
		}
		
		for (Map.Entry<Integer, Integer> entrySet : map.entrySet()) {
			if (entrySet.getValue() == min)
				System.out.println(entrySet.getKey());
		}
	}
	
	public static void findMostRepeatable(FileInputStream fis) throws IOException {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int max = Integer.MIN_VALUE;
		
		while (fis.available() > 0) {
			int i = fis.read();
			if (map.containsKey(i)) {
				map.put(i, map.get(i) + 1);
				if (map.get(i) > max) {
					max = map.get(i);
				}
			} else
				map.put(i, 0);
		}
		
		for (Map.Entry<Integer, Integer> entrySet : map.entrySet()) {
			if (entrySet.getValue() == max)
				System.out.println(entrySet.getKey());
		}
	}
}
	
