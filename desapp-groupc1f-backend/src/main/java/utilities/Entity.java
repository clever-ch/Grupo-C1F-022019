package utilities;

import constants.ModelConstants;

public abstract class Entity {
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
