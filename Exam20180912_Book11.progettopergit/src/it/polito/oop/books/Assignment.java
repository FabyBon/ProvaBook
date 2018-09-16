package it.polito.oop.books;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


public class Assignment {

    private String ID;
	private ExerciseChapter chapter;
	
	private double FP=0;
	private double FN=0;
	private double N=0;
	private double RS=0;

	private double sumPoint=0;
    private double point=0;


	public Assignment(String iD, ExerciseChapter chapter) {
    	this.ID=iD;
    	this.chapter=chapter;
    }

	public String getID() {
        return ID;
    }

    public ExerciseChapter getChapter() {
        return chapter;
    }

    public double addResponse(Question q,List<String> answers) {    	
    	List<String> lAnswerStud=new LinkedList<>();
    	FP=0;

    	//Prendo le risposte dello studente
    	for(String s:answers) {
    		lAnswerStud.add(s);     	
    	}     
    	
    	RS=(double)lAnswerStud.size();
    	N=(double)q.numAnswers();
    
      for(String lAS:lAnswerStud) {    	  
    			if(q.getIncorrectAnswers().contains(lAS))	{
    				FP++;
    			}   		    			
    	}
      
        FN=(double)((double)(q.getCorrectAnswers().size())-(RS-FP));
       
        point=(double)((N-FP-FN)/N);
        sumPoint=sumPoint+point;
               
        
        return point;    
        
    }
    
    public double totalScore() {
        return sumPoint;
    }
    
    
    
    public double getScore() {
        return point;
    }
    
    public double getTotalScore() {
        return sumPoint;
    }
    
}
