package com.example.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ROOT")
public class Vo {

	@XmlAttribute
	private String example = "a";

	@XmlElement(name = "bb")
	private String name;
	
	@XmlElement
	private String age;
	
	@XmlElement(defaultValue = "-")
	private String tip;
	
	@XmlElement
	private HashMap<String, String> X1 = new HashMap<String, String>();
	
	@XmlElement
	private List<String> X2 = Arrays.asList("a","b","c","d","e");


	public Vo() {
		super();
	}

	public Vo(String name, String age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public Vo(String name, String age, String tip) {
		super();
		this.name = name;
		this.age = age;
		this.tip = tip;
	}

}
