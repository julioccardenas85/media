//CÁLCULO DE MEDIA DE UN ARREGLO
//Descripción: se calcula el valor de media de un arreglo con los datos ingresados por usuario.
//Desarrollador: Julio César Cárdenas Alvarado.
//Institución: CUCEA MTI
//Realización: 13/09/2021

import java.util.Scanner;
import java.util.InputMismatchException;

public class media {
	public static void main (String args []) {
		Scanner dataIn = new Scanner(System.in);
		float sum = 0;
		float media = 0;
		int size = 0;
		boolean repeat = false;
		boolean repeatB = false;
		char option;
		System.out.println("Calcule la media de un grupo de valores");
		
		do {
			do {
				try {
					System.out.print("Ingrese la cantidad de valores a calcular (elija un valor mayor a 5 y menor o igual a 15): ");
					size = dataIn.nextInt();
					repeat = false;
				}
				
				catch (InputMismatchException e) {
					System.err.println("Valor incorrecto. Introduzca un número entero.");
					dataIn = new Scanner( System.in );
					repeat = true;
				}
			}
			while (repeat == true);
			
			if (size > 5 && size < 16) {
				float data [] = new float [size];
				System.out.println("Ingrese los valores para calcular la media (elija valores entre 10 y 100): ");
				vectorData(size, data, dataIn, repeat);
				printVector(data, size);
				sum = totalSum(data, sum);
				System.out.println("La sumatoria de los datos ingresados es: " + sum);
				media = calcMedia(sum, size, media);
				System.out.println("La media de los datos ingresados es: " + media);
			}
			else {
				System.out.println("Valor incorrecto, ingrese un valor mayor de 5 e igual o menor a 15");
				repeat = true;
			}
			
			do {
				System.out.println("¿Desea hacer un nuevo cálculo? s/n");
				option = dataIn.next().charAt(0);
				if (option == 's') {
					System.out.println();
					repeat = true;
					repeatB = false;
					break;
				}
				else if (option == 'n') {
					System.out.println("Programa terminado. ¡Hasta luego!");
					repeat = false;
					repeatB = false;
					break;
				}
				
				else {
					System.out.println("Opción incorrecta");
					repeatB = true;
					break;
				}
			}
			while (repeatB == true);
		}
		
		while (repeat == true);
	}
	
	public static void vectorData (int size, float data[], Scanner dataIn, boolean repeat) {
		for (int i = 0; i < size; i++) {
			do {
				do {
					try {
						System.out.print("Ingrese el valor " + (i + 1) + ": ");
						data [i] = dataIn.nextFloat();
						repeat = false;
					}
					catch (InputMismatchException e) {
						System.err.println("Valor incorrecto. Introduzca un número.");
						dataIn = new Scanner( System.in );
						repeat = true;
					}
				}
				while (repeat == true);
				
				if (data[i] >= 10 && data[i] <= 100) {
					repeat = false;
					break;
				}
				else {
					System.out.println("Valor incorrecto, ingrese un número entre 10 y 100");
					repeat = true;
				}
			}
			while (repeat = true);
		}
	}
	
	public static void printVector(float data [], int size) {
		System.out.print("Los datos ingresados son: ");
		
		for (int i = 0; i < size; i++) {
			System.out.print(data[i] + " ");
		}
		
		System.out.println();
	}
	
	public static float totalSum (float data [], float sum) {
		sum = 0;
		
		for (int i = 0; i < data.length ; i++) {
			sum = sum + data[i];
		}
		
		return sum;
	}
	
	public static float calcMedia(float sum, int size, float media) {
		media = sum / size;
		return media;
	}
}
