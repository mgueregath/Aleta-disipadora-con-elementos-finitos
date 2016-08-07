import java.io.*;

class lectura {
	
	int mat[][], trans[][], f, c;
	double deter=1.0;
	double inv[][];
	double n1,n2,n3,n4,n5,n6,n7,n8,n9;
	double ind1,ind2,ind3;
	double ecu[][], ecu2[],ecu3[][];
	int op;
	
	BufferedReader h;
	void ini(){
		h=new BufferedReader(new InputStreamReader(System.in));
	}
	
	int entero (String x) throws IOException{
		int a=0;
		System.out.print(x);
		try {
			a=Integer.parseInt(h.readLine());
		} catch(NumberFormatException e) {
			System.out.println("\tERROR: NO ES UN NUMERO");
		}
		return a;
	}
	
	double doble (String x) throws IOException{
		double a=0;
		System.out.print(x);
		try {
			a=Double.parseDouble(h.readLine());
		} catch(NumberFormatException e) {
			System.out.println("\tERROR: NO ES UN NUMERO");
		}
		return a;
	}
	
	void menu(int op) throws IOException {
		matrices m=new matrices();
		ini();
		do {
				System.out.println("\n\t\t\t         M E N U         ");
				System.out.println("     ================================================================");
				System.out.println("	[1] Matriz transpuesta");
				System.out.println("	[2] Determinante de una matriz");
				System.out.println("	[3] Matriz inversa");
				System.out.println("	[4] Resolucion de sistemas de 3 ecuaciones con 3 incognitas");
				System.out.println("	[5] Salir");
				System.out.println();
				op=entero("\tElige una opcion: ");
				System.out.println();
				switch(op) {
					case 1: 
							//Matriz transpuesta
							System.out.println("\tMatriz transpuesta");
							f=entero("\tIngrese el numero de filas==> ");
							c=entero("\tIngrese el numero de columnas==> ");
							System.out.println();
							
							mat=m.lee_M(f,c);
							System.out.println("\tMATRIZ ORIGINAL");
							System.out.println();
							m.imp_M(mat);
							
							System.out.println();
							trans=m.transpuesta(mat,f,c);
							System.out.println();
							System.out.println("\tMATRIZ TRANSPUESTA");
							System.out.println();
							m.imp_M(trans);
							/****************************************************/
							break;
					
					case 2: 
							//Determinante de una matriz
							System.out.println();
							System.out.println();
							System.out.println("\tDeterminante de una matriz");
							f=entero("\tIngrese el numero de filas y columnas==> ");
							System.out.println();
							
							mat=m.lee_M(f,f);
							System.out.println("\tMATRIZ ORIGINAL");
							System.out.println();
							m.imp_M(mat);
							
							System.out.println();
							deter=m.determinate(mat,f);
							System.out.println("\tDeterminante==> "+deter);
							/****************************************************/
							break;
							
					case 3:
							//Matriz inversa
							System.out.println();
							System.out.println();
							System.out.println("\tMatriz inversa");
							f=entero("\tIngrese el numero de filas y columnas==> ");
							System.out.println();
							
							mat=m.lee_M(f,f);
							System.out.println("\tMATRIZ ORIGINAL");
							System.out.println();
							m.imp_M(mat);
							
							System.out.println();
							inv=m.inversa2(mat,f);
							System.out.println("\tMATRIZ INVERSA");
							System.out.println();
							m.imp_M2(inv);
							/****************************************************/
							break;
					
					case 4:
							//Sistema de Ecuaciones por metodo del Determinante
							System.out.println("\tSistemas de ecuaciones por metodo de los determinantes");
							System.out.println();
							System.out.println("\tEcuacion 1: ax+by+cz=d");
							n1=doble("\tIngrese a==> ");
							n2=doble("\tIngrese b==> ");
							n3=doble("\tIngrese c==> ");
							ind1=doble("\tIngrese d==> ");
							
							System.out.println();
							System.out.println("\tEcuacion 2: a1x+b1y+c1z=d1");
							n4=doble("\tIngrese a1==> ");
							n5=doble("\tIngrese b1==> ");
							n6=doble("\tIngrese c1==> ");
							ind2=doble("\tIngrese d1==> ");
							
							System.out.println();
							System.out.println("\tEcuacion 3: a2x+b2y+c2z=d2");
							n7=doble("\tIngrese a2==> ");
							n8=doble("\tIngrese b2==> ");
							n9=doble("\tIngrese c2==> ");
							ind3=doble("\tIngrese d2==> ");
							
							System.out.println();
							ecu=m.ecuacionmat(n1,n2,n3,n4,n5,n6,n7,n8,n9);
							ecu3=m.inversa(ecu,3);
							ecu2=m.ecuacionvec(ind1,ind2,ind3);
							System.out.println();
							m.ecuaciones(ecu3,ecu2);
							/****************************************************/
							break;
							
					case 5: 
							System.out.println("\tFin del programa");
							break;
							
					default: 
							System.out.println("\tOpcion errada!!!");
				}
		}
		while(op!=5);
	}
}
