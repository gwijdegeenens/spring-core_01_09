package eu.noelvaes.housekeeping;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import eu.noelvaes.housekeeping.services.DomesticService;

public class HouseApp {
   public static void main(String[] args) {
      try (
         AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext()) {
         ctx.getEnvironment().setActiveProfiles("smallHouse");
         ctx.register(AppConfig.class);
         ctx.refresh();
         DomesticService service = ctx.getBean("domesticService",
            DomesticService.class);
         service.runHousehold();
      }
   }
}
