package ch.heigvd.ptl.sc.persistence;

import ch.heigvd.ptl.sc.model.IssueType;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IssueTypeRepository extends MongoRepository<IssueType, String> {
	public List<IssueType> findByName(String name);

}
