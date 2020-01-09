package ca.sheridancollege.bean;

import java.io.Serializable;

public class DogList implements Serializable {
	
	private String dog_breeds;
	private int count;
	private int maleClass;
	private int maleSpecial;
	private int femaleClass;
	private int femaleSpecial;
	public DogList() {
		super();
	}
	public DogList(String dog_breeds, int count) {
		super();
		this.dog_breeds = dog_breeds;
		this.count = count;
	}
	public String getDog_breeds() {
		return dog_breeds;
	}
	public void setDog_breeds(String dog_breeds) {
		this.dog_breeds = dog_breeds;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getMaleClass() {
		return maleClass;
	}
	public void setMaleClass(int maleClass) {
		this.maleClass = maleClass;
	}
	public int getMaleSpecial() {
		return maleSpecial;
	}
	public void setMaleSpecial(int maleSpecial) {
		this.maleSpecial = maleSpecial;
	}
	public int getFemaleClass() {
		return femaleClass;
	}
	public void setFemaleClass(int femaleClass) {
		this.femaleClass = femaleClass;
	}
	public int getFemaleSpecial() {
		return femaleSpecial;
	}
	public void setFemaleSpecial(int femaleSpecial) {
		this.femaleSpecial = femaleSpecial;
	}
	
	@Override
	public String  toString()
	{
		return ""+this.getCount()+" "+this.getDog_breeds()+""+this.getMaleClass()+" "+this.getFemaleClass()+" "+this.getMaleSpecial()+" "+this.getFemaleSpecial();
	}
	
	
	

}
