package it.polito.oop.books;

import java.util.LinkedList;

import java.util.List;

import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;


public class ExerciseChapter {

    private String title;
	private int numPages;
	
	List<Question> lQuestion=new LinkedList<>();


	public ExerciseChapter(String title, int numPages) {
    		this.title=title;
    		this.numPages=numPages;
    }
	

//	restituisce tutti gli argomenti definiti per le domande, senza ripetizioni
//	ed ordinati alfabeticamente.


	public List<Topic> getTopics() {
		
        return lQuestion.stream()
        		.map(q->q.getMainTopic())
        		.distinct()
        		.sorted(comparing(Topic::getKeyword))
        		.distinct()
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
    
	public void addQuestion(Question question) {

		lQuestion.add(question);
	
	}	
}
