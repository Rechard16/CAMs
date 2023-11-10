import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import model.Query;

public class Main {
	public static void main(String args[]) {
		Query query = new Query(5, 4, "iwiuwu");
		ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
		
		// Writing from a file
		try {
			mapper.writeValue(new File("query.yaml"), query);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Reading from a file
		try {
			Query read = mapper.readValue(new File("query.yaml"), Query.class);
			System.out.printf("Read value: userId: %d campId: %d queryId: %d, description: %s\n",
					read.getUserId(), read.getCampId(), read.getId(), read.getDescription());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
