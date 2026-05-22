package yeolmok.mongo;

import com.mongodb.client.MongoClients;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@SpringBootApplication
public class MongoApplication {

	public static void main(String[] args) {
		MongoOperations mongoOperations = new MongoTemplate(MongoClients.create(), "database");
		mongoOperations.insert(new Person("Yeolmok", 31));

		System.out.println(mongoOperations.query(Person.class).matching(where("name").is("Yeolmok")).firstValue());

		mongoOperations.dropCollection("person");
	}

}
