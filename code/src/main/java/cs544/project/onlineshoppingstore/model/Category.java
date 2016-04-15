package cs544.project.onlineshoppingstore.model;

import java.util.HashSet;
import java.util.Set;


public class Category {
	
	public enum CAT { SCIENCE,ENGINEERING,MEDICAL,COMPUTER,
					  SOCIAL,PHILOSOPHY, LANGUAGE,GEOEGRAPHY,
					  HISTORY,FICTION,ARTS,BUISNESS
					 }
	
	private Set<CAT> category = new HashSet<CAT>(); // ?? 

}
