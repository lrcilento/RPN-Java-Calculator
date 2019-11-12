import java.util.Scanner;
public class calculadora {	
	public static void main(String[] args) {	
		int aux = 0, aux2 = 0, aux3 = 0, aux5 = 0;
		double x = 0, y, z = 0, w;
		char rule, ruleaux;
		Pilha<Double> pilei = new Pilha<Double>();
		Pilha<Double> pileiaux = new Pilha<Double>();
		Pilha<Double> pilet = new Pilha<Double>();
		Pilha<Character> pilec = new Pilha<Character>();
		Pilha<Character> pilecp = new Pilha<Character>();
		Pilha<Character> pilecaux = new Pilha<Character>();
		Pilha<Character> piled = new Pilha<Character>();
		Scanner input = new Scanner(System.in);	
		System.out.println("Informe a equação:");
		String equation = input.nextLine();		
		while (aux < equation.length()) {			
			if (equation.charAt(aux) == '(') {pilet.push(x);}			
			else if (equation.charAt(aux) == '+' || equation.charAt(aux) == '-' || equation.charAt(aux) == '/' || equation.charAt(aux) == '*' || equation.charAt(aux) == '^') {				
				pilec.push(equation.charAt(aux));
				if (piled.isEmpty() == false) {
					while (piled.isEmpty() == false) {
						w = (double) (piled.pop() - '0');
						z += w * Math.pow(10, aux3);
						aux3++;
					}
					pilei.push(z);
					aux3 = 0;
					z = 0;
				}			
			}						
			else if (equation.charAt(aux) == ')') {				
				if (piled.isEmpty() == false) {
					while (piled.isEmpty() == false) {
						w = (double) (piled.pop() - '0');
						z += w * Math.pow(10, aux3);
						aux3++;
					}
					pilei.push(z);
					aux3 = 0;
					z = 0;
				}				
				y = pilei.pop();				
				if (pilei.isEmpty() == true) {x = pilet.pop();}
				else {x = pilei.pop();}
				rule = pilec.pop();
				if (rule == '+') {x = x+y;}				
				else if (rule == '-') {x = x-y;}				
				else if (rule == '/') {x = x/y;}				
				else if (rule == '*') {x = x*y;}				
				else if (rule == '^') {x = Math.pow(x, y);}
				pilei.push(x);				
			}			
			else if (equation.charAt(aux) == '0' || equation.charAt(aux) == '1' || equation.charAt(aux) == '2' || equation.charAt(aux) == '3' || equation.charAt(aux) == '4' || equation.charAt(aux) == '5' || equation.charAt(aux) == '6' || equation.charAt(aux) == '7' || equation.charAt(aux) == '8' || equation.charAt(aux) == '9'){piled.push(equation.charAt(aux));}			
			else {System.out.println("Por favor, insira apenas números inteiros e os operadores informados no manual."); break;}			
			aux++;						
		}
		while (pilec.isEmpty() == false || pilecaux.isEmpty() == false) {
			if (piled.isEmpty() == false) {
				while (piled.isEmpty() == false) {
					w = (double) (piled.pop() - '0');
					z += w * Math.pow(10, aux3);
					aux3++;
				}
				pilei.push(z);
				aux3 = 0;
				z = 0;
			}
			while (pilec.isEmpty() == false) {
				ruleaux = pilec.pop();
				if (ruleaux == '*' || ruleaux == '/' || ruleaux == '^') {
					aux5 = 1;
				}
				pilecp.push(ruleaux);
			}
			while (pilecp.isEmpty() == false) {pilec.push(pilecp.pop());}
			while (pilec.isEmpty() == false) {pilecaux.push(pilec.pop());}
			while (pilei.isEmpty() == false) {pileiaux.push(pilei.pop());}
			if (aux5 == 0) {
				while (pilecaux.isEmpty() == false) {
					System.out.println(x);
					rule = pilecaux.pop();
					if (aux2 == 0) {
						y = pileiaux.pop();
						x = pileiaux.pop();
						aux2 = 1;
					}
					else {
						y = pileiaux.pop();
					}
					if (rule == '+') {x = x+y;}				
					else if (rule == '-') {x = x-y;}				
					else if (rule == '/') {x = x/y;}				
					else if (rule == '*') {x = x*y;}
				}
			}
			else if (aux5 == 1) {
				while (pilecaux.isEmpty() == false) {
					x = pileiaux.pop();
					ruleaux = pilecaux.pop();
					if (ruleaux == '*' || ruleaux == '/' || ruleaux == '^') {
						y = pileiaux.pop();
						if (ruleaux == '/') {x = x/y;}				
						else if (ruleaux == '*') {x = x*y;}				
						else if (ruleaux == '^') {x = Math.pow(x, y);}	
						pileiaux.push(x);
					}
					else {pilec.push(ruleaux); pilei.push(x);}
				}
				while (pileiaux.isEmpty() == false) {pilei.push(pileiaux.pop());}
				while (pilec.isEmpty() == false) {pilecaux.push(pilec.pop());}
				while (pilei.isEmpty() == false) {pileiaux.push(pilei.pop());}
				while (pilecaux.isEmpty() == false) {
					rule = pilecaux.pop();
					if (aux2 == 0) {
						y = pileiaux.pop();
						x = pileiaux.pop();
						aux2 = 1;
					}
					else {
						y = pileiaux.pop();
					}
					if (rule == '+') {x = x+y;}				
					else if (rule == '-') {x = x-y;}				
					else if (rule == '/') {x = x/y;}				
					else if (rule == '*') {x = x*y;}
				}
			}
		}
		System.out.println(x);
		input.close();	
	}	
}
