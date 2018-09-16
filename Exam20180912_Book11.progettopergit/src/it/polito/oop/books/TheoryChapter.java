package it.polito.oop.books;

import java.util.LinkedList;

import java.util.List;

import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;


public class TheoryChapter {
	
	

    private String title;
	private int numPages;
	private String text;
	
	List<Topic> lTopic= new LinkedList<>();

	public TheoryChapter(String title, int numPages, String text) {

    	this.title=title;
    	this.numPages=numPages;
    	this.text=text;
    
    }

	public String getText() {
		return text;
	}

    public void setText(String newText) {
    	text=newText;
    	
    }
   
    
    //restituisce tutti gli argomenti
	public List<Topic> getTopics() {
		
        return  lTopic.stream()
        		.distinct()
        		.sorted(comparing(Topic::getKeyword))
        		.collect(toList());
	}

    public String getTitle() {
        return title;
    }

    public void setTitle(String newTitle) {
    	title=newTitle;
    }

    public int getNumPages() {
        return numPages;
    }
    
    public void setNumPages(int newPages) {
    	numPages=newPages;
    }
    
    public void addTopic(Topic topic) {
    	lTopic.add(topic);
    	
    	if(topic.getSubTopics()!=null) {
    		for(Topic t:topic.getSubTopics()) {
    			lTopic.add(t);
    			if(t.getSubTopics()!=null) {
    				for(Topic st:t.getSubTopics()) {
    					lTopic.add(st);
    				}
    			}    				
    		}    		
    	}    	
    }
    
}
