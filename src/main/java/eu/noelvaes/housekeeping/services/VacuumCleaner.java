package eu.noelvaes.housekeeping.services;

import org.springframework.context.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Order(2)
@Profile("!smallHouse")
public class VacuumCleaner implements CleaningTool {
	public VacuumCleaner() {
		System.out.println("VacuumCleaner: constructor");
	}

   public void doCleanJob() {
      System.out.println("Zuuuuuuuuuuu");
   }
}
