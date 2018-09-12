package eu.noelvaes.housekeeping.services;
import java.time.LocalTime;
import javax.annotation.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

@Component
public class HedgeTrimmerFactory {
	@Value("${startHour}")
	private int startHour;
	
	@Value("${endHour}")
	private int endHour;
	
	
	@Bean
	@Profile("bigHouse")
	public GardeningTool getHedgeTrimmer() {
		int hour = LocalTime.now().getHour();
		if (hour > startHour && hour < endHour) {
			return () -> System.out.println("Trimming electric (noisily)");
		} else {
			return () -> System.out.println("Trimming manual (silently)");
		}
	}
	
	@PostConstruct
	public void init() {
		System.out.println("HedgeTrimmerFactory intializing.");
	}

   @PreDestroy
   public void destroy() {
   	System.out.println("HedgeTrimmerFactory closing.");
   }

}
