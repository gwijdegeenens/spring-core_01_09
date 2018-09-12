package eu.noelvaes.housekeeping.services;

import org.springframework.context.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Order(3)
@Profile("!smallHouse")
public class Sponge implements CleaningTool {
	public Sponge() {
		System.out.println("Sponge: constructor");
	}

   public void doCleanJob() {
      System.out.println("Splash splash");
   }
}
