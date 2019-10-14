package utilities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import constants.ModelConstants;

@javax.persistence.Entity
public abstract class Entity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private ModelConstants modelConstants = new ModelConstants();
	
	public long getId() {
		return this.id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public ModelConstants getModelConstants() {
		return this.modelConstants;
	}
}
