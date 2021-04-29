package misc;

import java.util.HashMap;
import java.util.Map;

public class ValidateRule {
	
	
	
	private boolean validate(String[] rules) {
		Map<String, int[]> positions = new HashMap<String, int[]>();
		
		for (String rule : rules) {
			String[] split = rule.split(" ");
			String start = split[0];
			String direction = split[1];
			String end = split[2];
			
			//positions.getOrDefault(d, defaultValue)(start)
		}
		
		return true;
	}

}
