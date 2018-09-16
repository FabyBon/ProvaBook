package it.polito.oop.books;

import java.util.HashMap;


import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

import java.util.ArrayList;

import static java.util.Comparator.*;

public class Book {

	
	Map<String,Topic> mTopic=new HashMap<>();
	Map<String,Question> mQuestion=new HashMap<>();

	List<ExerciseChapter> lCEsercizi= new ArrayList<>();

	
	List<TheoryChapter> lCTeoria=new LinkedList<>();
//	Topic t;
	List<Topic> lTopic= new LinkedList<>();
    /**
	 * Creates a new topic, if it does not exist yet, or returns a reference to the
	 * corresponding topic.
	 * 
	 * @param keyword the unique keyword of the topic
	 * @return the {@link Topic} associated to the keyword
	 * @throws BookException
	 */
	public Topic getTopic(String keyword) throws BookException {
		
		if(keyword==null || keyword=="") throw new BookException();
		
		if(mTopic.get(keyword)!=null) {
			return mTopic.get(keyword);
		}
		
		Topic t=new Topic(keyword);
		mTopic.put(keyword, t);
		
	    return t;
		
	}

	public Question createQuestion(String question, Topic mainTopic) {
		
		Question q=new Question(question,mainTopic);
		mQuestion.put(question,q);
        return q;
	}

	public TheoryChapter createTheoryChapter(String title, int numPages, String text) {
		
		TheoryChapter tc=new TheoryChapter(title,numPages,text);

		lCTeoria.add(tc);
		
        return tc ;
	}

	public ExerciseChapter createExerciseChapter(String title, int numPages) {
		
		
		ExerciseChapter ec= new ExerciseChapter(title,numPages);
		lCEsercizi.add(ec);
		
//		for(Topic t:ec.getTopics()) {
//			lTopic.add(t);
//		}
        return ec;
	}

	public List<Topic> getAllTopics() {
      
      
       this.lTopic.addAll(lCEsercizi.stream().flatMap(ec->ec.getTopics().stream()).collect(toList()));
       this.lTopic.addAll(lCTeoria.stream().flatMap(tc->tc.getTopics().stream()).collect(toList()));
       
       
       return this.lTopic.stream().distinct().sorted(comparing(Topic::getKeyword)).collect(toList());			
        		
	}
	public boolean checkTopics() {

		
		for(TheoryChapter tc:lCTeoria) {		
		   boolean b= tc.getTopics().containsAll(lCEsercizi.stream()
		    		.flatMap(ec->ec.getTopics().stream())
		    		.distinct()
		    		.collect(toList()));
		   
		   if(b==true) {
			  return b;
			}			
		}				
		return false;	
	   
    }
       
	

	public Assignment newAssignment(String ID, ExerciseChapter chapter) {
		
		Assignment a=new Assignment(ID,chapter);
        return a;
	}
	
    /**
     * builds a map having as key the number of answers and 
     * as values the list of questions having that number of answers.
     * @return
     */
	
    public Map<Long,List<Question>> questionOptions(){
    	
        return mQuestion.values().stream().collect(groupingBy(Question::numAnswers,mapping(q->q,toList())));
    }
    
    
    
    //DA ELIMINARE
    
    public List<TheoryChapter> getlTC(){
    	return lCTeoria;
    }
    public List<ExerciseChapter> getlEC(){
    	return lCEsercizi;
    }
}
