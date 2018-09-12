package eu.noelvaes.housekeeping.services;
import org.springframework.context.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Order(1)
@Profile("smallHouse")
public class Broom implements CleaningTool {
	public Broom() {
		System.out.println("Broom: constructor");
	}

	public void doCleanJob() {
		System.out.println("Scrub scrub");
	}
}
