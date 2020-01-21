package algo24;

import java.util.ArrayList;
import java.util.List;

import algo24.operations.Operations;
import algo24.operations.Stack;
import cprompt.PromptInt;
import cprompt.Prompter;
import cprompt.exception.PromptCountException;
import cprompt.rule.RangeRule;
import cprompt.rule.RuleException;

public class Main {
	
	public static void main(String[] args) {
		PromptInt pi = new PromptInt("Entrez ~4 cartes : ", new RangeRule(1, 13, true));
		Prompter prompter = new Prompter(pi);
		Operations ops = new Operations(24);
		
		while(!prompter.hasQuit()) {
			try {
			//System.out.println(prompter.runPrompt(0));
			@SuppressWarnings("unchecked")
			ArrayList<Integer> cards = (ArrayList<Integer>)prompter.runPrompt(0);
			List<Stack> stack = ops.solve(cards);
			
			if (stack == null) System.out.println("...no answer...");
			else System.out.println("-------Answer------\n"+stack);
			
			} catch (PromptCountException | NumberFormatException | RuleException e) {
				System.out.println("\n"+e.getMessage()+"\n");
				continue;
			}
		}
	}

}
