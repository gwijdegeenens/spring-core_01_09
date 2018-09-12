package eu.noelvaes.housekeeping;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import eu.noelvaes.housekeeping.services.DomesticService;

public class HouseAppXML {
   public static void main(String[] args) {
      try (ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext()) {
         ctx.getEnvironment().setActiveProfiles("smallHouse");
         ctx.setConfigLocation("housekeeping.xml");
         ctx.refresh();
         DomesticService service = ctx.getBean("domesticService",
               DomesticService.class);
         service.runHousehold();
      }
   }
}
