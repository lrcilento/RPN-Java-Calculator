import java.util.Scanner;

public class calculadora {
	
	public static void main(String[] args) {
	
		int aux = 0;
		int aux2 = 0;
		int aux3 = 0;
		double x = 0, y, z = 0, w;
		char rule;
		Pilha<Double> pilei = new Pilha<Double>();
		Pilha<Character> pilec = new Pilha<Character>();
		Pilha<Character> piled = new Pilha<Character>();
		Scanner input = new Scanner(System.in);
	
		System.out.println("Informe a equação:");
		String equation = input.nextLine();
		
		while (aux < equation.length()) {
			
			if (equation.charAt(aux) == '(') {}
			
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
			
			else if (equation.charAt(aux) == ')' && aux2 == 1) {
				
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
				rule = pilec.pop();
				
				if (rule == '+') {x = x+y;}
				
				else if (rule == '-') {x = x-y;}
				
				else if (rule == '/') {x = x/y;}
				
				else if (rule == '*') {x = x*y;}
				
				else if (rule == '^') {x = Math.pow(x, y);}
				
			}
			
			else if (equation.charAt(aux) == ')' && aux2 == 0) {
				
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
				x = pilei.pop();
				rule = pilec.pop();
				
				if (rule == '+') {x = x+y;}
				
				else if (rule == '-') {x = x-y;}
				
				else if (rule == '/') {x = x/y;}
				
				else if (rule == '*') {x = x*y;}
				
				else if (rule == '^') {x = Math.pow(x, y);}

				aux2 = 1;
				
			}
			
			else if (equation.charAt(aux) == '0' || equation.charAt(aux) == '1' || equation.charAt(aux) == '2' || equation.charAt(aux) == '3' || equation.charAt(aux) == '4' || equation.charAt(aux) == '5' || equation.charAt(aux) == '6' || equation.charAt(aux) == '7' || equation.charAt(aux) == '8' || equation.charAt(aux) == '9'){piled.push(equation.charAt(aux));}
			
			else {System.out.println("Por favor, insira apenas número inteiros e os operadores informados no manual."); break;}
			
			aux++;
			
		}
	
		System.out.println(x);
		input.close();
	
	}
	
}
