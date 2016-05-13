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
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int max = 0;
		
		/*try catch block in order to catch an exception in case file name
		is incorrect or file does not exist */
		try {
			fis = new FileInputStream(br.readLine());
		} catch (FileNotFoundException e) {}
		
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
		
		br.close();
		fis.close();
	}
}
	
