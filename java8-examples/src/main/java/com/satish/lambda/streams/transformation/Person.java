package com.satish.lambda.streams.transformation;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

class Person{
	
	private final long id;
	
	private final String name;
	
	private final int age;
	
	private final String city;
	
	public Person(long id, String name, int age,String city){
		this.id = id;
		this.name = name;
		this.age = age;
		this.city = city;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
	
	public String getCity() {
		return city;
	}
	
	public static List<Person> getPersons(){
		return Arrays.asList(
				new Person(1L, "Harry", 23, "NY"),
				new Person(2L, "John", 32, "NJ"),
				new Person(3L, "Peter", 43, "CA"),
				new Person(4L, "Michel", 32, "NY"),
				new Person(5L, "Steve", 18, "NY"),
				new Person(6L, "John", 35, "NJ"),
				new Person(7L, "Dave", 15, "CA"),
				new Person(8L, "Mary", 41, "NY")
				);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, name, age, city);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(id, other.id) &&
				Objects.equals(name, other.name) &&
				Objects.equals(age, other.age) &&
				Objects.equals(city, other.city);
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age + ", city=" + city +"]";
	}

	
}