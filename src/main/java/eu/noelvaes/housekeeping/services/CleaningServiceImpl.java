package eu.noelvaes.housekeeping.services;
import javax.annotation.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Lazy
@Profile("smallHouse")
public class CleaningServiceImpl implements CleaningService {
	private CleaningTool tool;
	private float rate;

	public CleaningServiceImpl() {
		System.out.println("CleaningServiceImpl: constructor");
	}

	@Autowired
	public void setCleaningTool(CleaningTool tool) {
		this.tool = tool;
	}

	@Value("${rate}")
	public void setRate(float rate) {
		this.rate = rate;
	}

	@PostConstruct
	public void init() {
		System.out.println("CleaningService preparing for work.");
	}

	@PreDestroy
	public void destroy() {
		System.out.println("CleaningService cleaning up.");
	}

	public void clean() {
		System.out.println("Cleaning the house at " + rate + " per hour");
		tool.doCleanJob();
	}
}
