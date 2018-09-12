package eu.noelvaes.housekeeping.services;

import java.util.logging.Logger;

import javax.annotation.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component("domesticService")
@Order
public class DomesticServiceImpl implements DomesticService {
   private CleaningService cleaningService;
   private GardeningService gardeningService;
   @Autowired
   private Logger logger;

   @Autowired
   public void setCleaningService(
         CleaningService cleaningService) {
      this.cleaningService = cleaningService;
   }

   @Autowired
   public void setGardeningService(
         GardeningService gardeningService) {
      this.gardeningService = gardeningService;
   }

   @PostConstruct
   public void init() {
      logger.info("DomesticService preparing for work.");
   }

   @PreDestroy
   public void destroy() {
      logger.info("DomesticService cleaning up.");
   }

   public void runHousehold() {
      logger.info("Running household");
      cleaningService.clean();
      gardeningService.garden();
   }
}