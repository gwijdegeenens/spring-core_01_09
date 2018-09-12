package eu.noelvaes.housekeeping.services;

import java.util.logging.Logger;

import org.springframework.beans.factory.InjectionPoint;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

@Component
public class LoggerFactory {
   @Bean
   @Scope("prototype")
   public Logger logger(InjectionPoint ip) {
      return Logger.getLogger(ip.getClass().getName());
   }
}
