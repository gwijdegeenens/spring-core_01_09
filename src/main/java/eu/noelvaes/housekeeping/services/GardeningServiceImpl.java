package eu.noelvaes.housekeeping.services;

import javax.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GardeningServiceImpl implements GardeningService{
	private GardeningTool tool;	
	
	@Autowired
	public void setGardeningTool(GardeningTool tool) {
		this.tool = tool;
	}
   
	@PostConstruct
	public void init() {
		System.out.println("GardeningService preparing for work.");
	}

   @PreDestroy
   public void destroy() {
   	System.out.println("GardeningService cleaning up.");
   }
	
	public void garden() {
   	System.out.println("Working in the garden.");
   	tool.doGardenJob();
   }
}
