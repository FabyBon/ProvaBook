package it.polito.oop.books;

import java.util.ArrayList;


import java.util.List;
import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;



public class Topic {

	private String keyword;
	
	//Fa rif. alla lista dei sotto Topic
	List<Topic> lTopic= new ArrayList<>();

	public Topic(String keyword) {
		this.keyword=keyword;
	}

	public String getKeyword() {
        return keyword;
	}
	
	@Override
	public String toString() {
	    return keyword;
	}

	public boolean addSubTopic(Topic topic) {
		if(lTopic.contains(topic)) {
			return false;
		}
		
		lTopic.add(topic);
		
        return true;
	}

	/*
	 * Returns a sorted list of subtopics. Topics in the list *MAY* be modified without
	 * affecting any of the Book topic.
	 */
	public List<Topic> getSubTopics() {
		
        return lTopic.stream()
        		.sorted(comparing(Topic::getKeyword))
        		.collect(toList());
	}
}
