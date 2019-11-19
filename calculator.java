import java.util.Scanner;
public class calculator {
	public static void main(String[] args) {		
		int aux = 0;
		double w, x, y, z = 0, pow = 0;
		char token;
		boolean longnumber = false;
		String rpn = "";
		pile<Character> stack = new pile<Character>();
		pile<Double> operands = new pile<Double>();
		Scanner input = new Scanner(System.in);	
		System.out.println("Informe a equação:");
		String equation = input.nextLine();		
		while (aux < equation.length()) {
			token = equation.charAt(aux);
			if (token == '0' || token == '1' || token == '2' || token == '3' || token == '4' || token == '5' || token == '6' || token == '7' || token == '8' || token == '9') {
				while (aux+1 < equation.length() && (equation.charAt(aux+1) == '0' || equation.charAt(aux+1) == '1' || equation.charAt(aux+1) == '2' || equation.charAt(aux+1) == '3' || equation.charAt(aux+1) == '4' || equation.charAt(aux+1) == '5' || equation.charAt(aux+1) == '6' || equation.charAt(aux+1) == '7' || equation.charAt(aux+1) == '8' || equation.charAt(aux+1) == '9')) {
					rpn += token;
					aux++;
					token = equation.charAt(aux);
				}
				rpn += token;
				rpn += '.';
			}
			else if (token == '(') {
				stack.push(token);
			}
			else if (token == '+' || token == '-') {
				while (!stack.isEmpty() && (stack.top() == '*' || stack.top() == '/' || stack.top() == '^' || stack.top() == '+' || stack.top() == '-')) {
					rpn += stack.pop();
				}
				stack.push(token);
			}
			else if (token == '*' || token == '/') {
				while (!stack.isEmpty() && (stack.top() == '*' || stack.top() == '/' || stack.top() == '^')) {
					rpn += stack.pop();
				}
				stack.push(token);
			}
			else if (token == '^') {
				while (!stack.isEmpty() && stack.top() == '^') {
					rpn += stack.pop();
				}
				stack.push(token);
			}
			else if (token == ')') {
				while (!stack.isEmpty() && stack.top() != '(') {
					rpn += stack.pop();
				}
				if (stack.top() == '(') {
					stack.pop();
				}
			}
			aux++;
		}
		while (stack.isEmpty() == false) {
			rpn += stack.pop();
		}
		aux = 0;
		while (aux < rpn.length()) {
			token = rpn.charAt(aux);
			if (token == '0' || token == '1' || token == '2' || token == '3' || token == '4' || token == '5' || token == '6' || token == '7' || token == '8' || token == '9') {
				while (aux+1 < rpn.length() && (rpn.charAt(aux+1) == '0' || rpn.charAt(aux+1) == '1' || rpn.charAt(aux+1) == '2' || rpn.charAt(aux+1) == '3' || rpn.charAt(aux+1) == '4' || rpn.charAt(aux+1) == '5' || rpn.charAt(aux+1) == '6' || rpn.charAt(aux+1) == '7' || rpn.charAt(aux+1) == '8' || rpn.charAt(aux+1) == '9')) {
					stack.push(token);
					aux++;
					token = rpn.charAt(aux);
					longnumber = true;
				}
				if (longnumber) {
					stack.push(token);
					while (!stack.isEmpty()) {
						w = (double) (stack.pop() - '0');
						z += w * Math.pow(10, pow);
						pow++;
					}
					operands.push(z);
					pow = 0;
					z = 0;
					longnumber = false;
				}
				else {
					w = (double) (token - '0');
					operands.push(w);
				}
			}
			else if (token == '+' || token == '-' || token == '/' || token == '*' || token == '^') {
				y = operands.pop();
				x = operands.pop();
				if (token == '+') {x = x+y;}				
				else if (token == '-') {x = x-y;}				
				else if (token == '/') {x = x/y;}				
				else if (token == '*') {x = x*y;}				
				else if (token == '^') {x = Math.pow(x, y);}
				operands.push(x);
			}
			aux++;
		}
		input.close();
		System.out.println(operands.pop());
	}
}
