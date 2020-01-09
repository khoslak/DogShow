package ca.sheridancollege.bean;

import java.io.Serializable;

public class Dog implements Serializable {
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String dog_name;
private String  owner_name;
private String dog_breed;
private String dog_group;
private String dog_gender;
private String dog_type;
private int entry_number;
public Dog() {
	super();
}
public Dog(String dog_name, String owner_name, String dog_breed, String dog_group, String dog_gender, String dog_type) {
	super();
	this.dog_name = dog_name;
	this.owner_name = owner_name;
	this.dog_breed = dog_breed;
	this.dog_group = dog_group;
	this.dog_gender = dog_gender;
	this.dog_type = dog_type;
}
public void setEntry_number(int entry_number)
{
	this.entry_number=entry_number;
}
public int getEntry_number()
{
	return this.entry_number;
}
public String getDog_name() {
	return dog_name;
}
public void setDog_name(String dog_name) {
	this.dog_name = dog_name;
}
public String getOwner_name() {
	return owner_name;
}
public void setOwner_name(String owner_name) {
	this.owner_name = owner_name;
}
public String getDog_breed() {
	return dog_breed;
}
public void setDog_breed(String dog_breed) {
	this.dog_breed = dog_breed;
}
public String getDog_group() {
	return dog_group;
}
public void setDog_group(String dog_group) {
	this.dog_group = dog_group;
}
public String getDog_gender() {
	return dog_gender;
}
public void setDog_gender(String dog_gender) {
	this.dog_gender = dog_gender;
}
public String getDog_type() {
	return dog_type;
}
public void setDog_type(String dog_type) {
	this.dog_type = dog_type;
}
@Override
public String toString() {
	return "dog_name=" + dog_name + "\n Owner_name=" + owner_name + "\n dog_breed=" + dog_breed + "\n  dog_group="
			+ dog_group + "\n dog_gender=" + dog_gender + "\n  dog_type=" + dog_type + "";
}




}
