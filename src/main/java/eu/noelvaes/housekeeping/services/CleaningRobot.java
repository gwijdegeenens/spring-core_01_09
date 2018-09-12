package eu.noelvaes.housekeeping.services;
import java.util.List;
import javax.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Lazy
@Profile("bigHouse")
public class CleaningRobot implements CleaningService {
	private List<CleaningTool> tools;

	@Autowired
	public void setCleaningTools(List<CleaningTool> tools) {
		this.tools = tools;
	}

	@PostConstruct
	public void init() {
		System.out.println("CleaningRobot starting up.");
	}

   @PreDestroy
   public void destroy() {
   	System.out.println("CleaningRobot shutting down.");
   }

	public void clean() {
		System.out.println("Cleaning the house");
		tools.forEach(CleaningTool::doCleanJob);
	}
}
