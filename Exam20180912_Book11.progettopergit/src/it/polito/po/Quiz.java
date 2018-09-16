package it.polito.po;

public class Quiz {
	final static public String[] questions = {
	"Quali di queste affermazioni sono valide? / Which among the following statements are correct?",
	"Quali di queste affermazioni sono valide per lo sviluppo agile? / Which among the following statements are correct for agile development?",
	"Quali di queste affermazioni sono valide per una espressione lambda? / Which among the following statements are correct for a lambda expression?"
	};
	final static public String[][] options = {
	{//1,3,4
		
		"Il pair programming puo' facilitare il training on the job dei neoassunti. / Pair programming may ease training on the job for new employees",
		"Nella programmazione estrema il refactoring si riferisce alla pianificazione incrementale dello sviluppo del software. / In extreme programming, refactoring refers to the incremental planning of software development",
		"Il CMM ha l'obiettivo di rivoluzionare il processo di sviluppo del software. / CMM has the goal of revolutionizing software development",
		"Mainline sta a versioni di sistema come codeline sta a versioni di componente. / Mainline stands to system versions as codeline stands to component versions",
		"La proprietà collettiva e' un obiettivo della programmazione estrema. / Collective ownership is an extreme programming goal"	},
	{
		"E' necessario che i requisiti siano stabili / stable requirements are required",
		"E' importante produrre una documentazione completa / producing a complete documentation is important",
		"E' facile adattarsi al cambiamento dei requisiti / it is easy to adapt to changing requirements",
		"Viene effettuato periodicamente il code refactoring / code refactoring is applied repeatedly",
		"Durante un'iterazione di tengono in considerazione quelle future / during an iteration all the future ones are considered"	},
	{
		"Una lambda puo' implementare una qualunque interfaccia / A lambda can implement any interface",
		"Una lambda restituisce un oggetto / A lambda returns an object",
		"Una lambda puo' sostituire qualsiasi method reference / A lambda can replace any method reference",
		"Una lambda implementa sempre una classe astratta / A lambda implements always an abstract class",
		"Una lambda puo' implementare un iteratore / A lambda can implement an iterator"	}
	};
	
	/**
	 * Return the index of the right option(s) for the given question 
	 * If no option is correct return an empty array
	 */
	public static int[] answer(int question){
		// TODO: answer the question
		
		switch(question){
			case 0: return new int[] {2}; // replace with your answers
			case 1: return null; // replace with your answers
			case 2: return new int[] {2,4};
			
			// replace with your answers
		}
		return null;
	
	}

	/**
	 * When executed will show the answers you selected
	 */
	public static void main(String[] args){
		for(int q=0; q<questions.length; ++q){
			System.out.println("Question: " + questions[q]);
			int[] a = answer(q);
			if(a==null || a.length==0){
				System.out.println("<undefined>");
				continue;
			}
			System.out.println("Answer" + (a.length>1?"s":"") + ":" );
			for(int i=0; i<a.length; ++i){
				System.out.println(a[i] + " - " + options[q][a[i]]);
			}
		}
	}
}

