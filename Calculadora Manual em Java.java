import java.util.Scanner;
import java.text.DecimalFormat;

public class Calculadora Manual em Java {	
    public static void main(String[] args) {        	
    	int running = 1;
    	Scanner input = new Scanner(System.in);    	
    	while (running == 1) {    		 
    		System.out.println("Qual operação deseja realizar? (1 = Soma, 2 = Subtração, 3 = Divisão, 4 = Multiplicação, 5 = Exponenciação e 6 = Radiciação)");
   	    	int choice = (input.nextInt());   	    	
   	    	if (choice == 1) {  	    	
   	    		System.out.println("Insira o primeiro numero da adição:");
   	    		double x = (input.nextDouble());
   	   	    	System.out.println("Insira o segundo numero da adição:");
   	   	    	double y = (input.nextDouble());
	   	    	sum(x, y);   	    	
   	    	}   	    
   	    	else if (choice == 2) {  	    
   	    		System.out.println("Insira o número do qual será feita a subtração:");
   	    		double x = (input.nextDouble());
   	   	    	System.out.println("Insira o valor a ser subtraído:");
   	   	    	double y = (input.nextDouble());
	   	    	subtract(x, y);  	    	
   	    	}   	    	
   	    	else if (choice == 3) {  	    		
   	    		System.out.println("Insira o número a ser dividido:");
   	    		double x = (input.nextDouble());
   	   	    	System.out.println("Insira por quanto será dividido:");
   	   	    	double y = (input.nextDouble());
	   	    	divide(x, y);  	    		
   	    	}  	    	
   	    	else if (choice == 4) {   	    		
   	    		System.out.println("Insira o primeiro numero da multiplicação:");
   	    		double x = (input.nextDouble());
   	   	    	System.out.println("Insira o segundo numero da multiplicação:");
   	   	    	double y = (input.nextDouble());
	   	    	multiply(x, y);  	    		
   	    	}   	    	
   	    	else if (choice == 5) {   	    		
   	    		System.out.println("Insira o número a ser potencializado:");
   	    		double x = (input.nextDouble());
   	   	    	System.out.println("Insira a potência desejada:");
   	   	    	int y = (input.nextInt());
	   	    	pow(x, y);   	    		
   	    	}   	    	
   	    	else if (choice == 6) {   	    		
   	    		System.out.println("Deseja saber a raiz quadrada de qual número?");
   	    		int x = (input.nextInt());
   	    		sqrt(x);   	    		
   	    	}   	    	
   	    	else {System.out.println("Valor da operação inválido.");}  	    
   	    	System.out.println("Deseja realizar mais alguma operação? (0 = Não | 1 = Sim)");
   	    	running = (input.nextInt());    	   	    	
    	}   	
    	System.out.println("Espero ter ajudado!");
    	input.close();   	
    }        
    
    public static void sum (double x, double y) {    	
    	double z = x + y;   	
    	System.out.println(x+" + "+y+" = "+z+".");
    }
    
    public static void subtract (double x, double y) {    	
    	double z = x - y;    	
    	System.out.println(x+" - "+y+" = "+z+".");    	
    }
    
    public static void divide (double x, double y) {   	
    	double z = x / y;   	
    	System.out.println(x+" / "+y+" = "+z+".");
    }
    
    public static void multiply (double x, double y) {    	
    	double z = x * y;    	
    	System.out.println(x+" x "+y+" = "+z+".");    	
    }
    
    public static void pow (double x, int y) {    	    	
    	double z = x;
    	int i = 1;    	
    	if (y == 0) {z = 1;}
    	else if (y < 0) {System.out.println("Insira uma potência inteira e positiva.");}
    	else {  		
       		while (i < y) {
    			z = z * x;
    			i++;
    		}
       	}    	
    	System.out.println(x+" elevado a "+y+" é igual a: "+z+".");    	
    }
    
    public static void sqrt (int x) {    	
    	double z = 1;
    	int i = 1;   	   		
    	while (i > 0) {  		
    		if (z*z < x) {z = z + 0.01;}
    		else {i = 0;}	
    	}
    	DecimalFormat df = new DecimalFormat(".##");
    	System.out.println("A raiz quadrada de "+x+" é igual a: "+df.format(z)+".");
    }
}
