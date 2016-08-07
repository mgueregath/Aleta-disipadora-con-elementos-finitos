import java.io.*;

class matrices {
	
	static int[][] lee_M(int f, int c) throws IOException {
		lectura o4=new lectura();
		o4.ini();
		int matriz[][]=new int[1][1];
		try {
			matriz=new int[f][c];
			for(int i=0; i<matriz.length; i++) {
				for (int j=0; j<matriz[0].length; j++) {
					matriz[i][j]=o4.entero("\tIngrese el elemento ["+i+"] ["+j+"]==> ");
				}
				System.out.println();
			}
		} catch (NegativeArraySizeException e) {
			System.out.println("\tERROR: TAMANO DE LA MATRIZ NEGATIVO");
		}
		return matriz;
	}
	
	static void imp_M(int x[][]) {
		try {
			for(int i=0; i<x.length; i++) {
				for (int j=0; j<x[0].length; j++) {
					System.out.print("\t"+x[i][j]+"  ");
				}
				System.out.println();
			}
		}catch(NegativeArraySizeException e){
			System.out.println("\tERROR: TAMANO DE LA MATRIZ NEGATIVO");
		}
	}
	
	static void imp_M2(double x[][]) {
		try {
			for(int i=0; i<x.length; i++) {
				for (int j=0; j<x[0].length; j++) {
					System.out.print("\t"+x[i][j]+"  ");
				}
				System.out.println();
			}
		}catch(NegativeArraySizeException e){
			System.out.println("\tERROR: TAMANO DE LA MATRIZ NEGATIVO");
		}
	}
	
	static void imp_V(double x[]) {
		try {
			for(int i=0; i<x.length; i++) {
				System.out.print("\t"+x[i]+"  ");
			}
			System.out.println();
		}catch(NegativeArraySizeException e){
			System.out.println("\tERROR: TAMANO DE LA MATRIZ NEGATIVO");
		}
	}
	
	//Matriz transpuesta
	static int[][] transpuesta(int x[][], int f, int c) {
		int resp[][]=new int[1][1];
		try {
			resp=new int[c][f];
			for(int i=0; i<c; i++) {
				for(int j=0; j<f; j++){
					resp[i][j]=x[j][i];
				}
			}
		} catch (NegativeArraySizeException e) {
			System.out.println("\tERROR: TAMANO DEL VECTOR NEGATIVO");
		}
		return resp;
	}
	/****************************************************/
	
	
	//Determinante de una matriz
	static double determinate(int x[][], int f) {
		try {
			for(int k=0; k<x.length-1; k++) {
				for(int i=k+1; i<x[0].length; i++){
					for(int j=k+1; j<x.length; j++){
						x[i][j]-=x[i][k]*x[k][j]/x[k][k];
					}
				}
			}
		}catch (NegativeArraySizeException e) {
			System.out.println("\tERROR: TAMANO DE LA MATRIZ NEGATIVO");
		}
		
		double deter=1.0;
		for(int i=0; i<x.length; i++){
            deter*=x[i][i];
        }
        return deter;
	}
	/****************************************************/
	
	
	//Matriz inversa double
	static double[][] inversa(double x[][], int f) {
		double resp[][]=new double[1][1];
		double resp2[][]=new double[1][1];
		
		try {
			resp=new double [f][f];
			resp2=new double[f][f];
		
			for(int i=0; i<f; i++) {
				resp[i][i]=1.0;
			}
		
			for(int k=0; k<f-1; k++) {
				for(int i=k+1; i<f; i++) {
					for(int s=0; s<f; s++) {
						resp[i][s]-=x[i][k]*resp[k][s]/x[k][k];
					}
					for(int j=k+1; j<f; j++) {
						x[i][j]-=x[i][k]*x[k][j]/x[k][k];
					}
				}
			}
		
			for(int s=0; s<f; s++){
            	resp2[f-1][s]=resp[f-1][s]/x[f-1][f-1];
            	for(int i=f-2; i>=0; i--){
                	resp2[i][s]=resp[i][s]/x[i][i];
                	for(int k=f-1; k>i; k--){
                    	resp2[i][s]-=x[i][k]*resp2[k][s]/x[i][i];
                	}
            	}
        	}
        }catch (NegativeArraySizeException e) {
			System.out.println("\tERROR: TAMANO DE LA MATRIZ NEGATIVO");
		}
        return resp2;
	}
	/****************************************************/
	
	//Matriz inversa entero
	static double[][] inversa2(int x[][], int f) {
		double resp[][]=new double[1][1];
		double resp2[][]=new double[1][1];
		
		try {
			resp=new double [f][f];
			resp2=new double[f][f];
		
			for(int i=0; i<f; i++) {
				resp[i][i]=1.0;
			}
		
			for(int k=0; k<f-1; k++) {
				for(int i=k+1; i<f; i++) {
					for(int s=0; s<f; s++) {
						resp[i][s]-=x[i][k]*resp[k][s]/x[k][k];
					}
					for(int j=k+1; j<f; j++) {
						x[i][j]-=x[i][k]*x[k][j]/x[k][k];
					}
				}
			}
		
			for(int s=0; s<f; s++){
            	resp2[f-1][s]=resp[f-1][s]/x[f-1][f-1];
            	for(int i=f-2; i>=0; i--){
                	resp2[i][s]=resp[i][s]/x[i][i];
                	for(int k=f-1; k>i; k--){
                    	resp2[i][s]-=x[i][k]*resp2[k][s]/x[i][i];
                	}
            	}
        	}
        }catch (NegativeArraySizeException e) {
			System.out.println("\tERROR: TAMANO DE LA MATRIZ NEGATIVO");
		}
        return resp2;
	}
	/****************************************************/
	
	
	//Sistema de ecuaciones MATRIZ
	static double[][] ecuacionmat(double a, double b, double c, double d, double e, double f, double g, double h, double i) {
		double matriz[][]={{a,b,c},{d,e,f},{g,h,i}};
		return matriz;
	}
	/****************************************************/
	
	
	//Sistema de ecuaciones VECTOR
	static double[] ecuacionvec(double a,double b, double c) {
		double vec[]={a,b,c};
		return vec;
	}
	/****************************************************/
	
	
	//Obtener incognitas
	static void ecuaciones(double mat[][],double vec[]) {
		double resp[]=new double[1];
		try {
			resp=new double[3];
			for(int i=0; i<mat.length; i++) {
				for(int j=0; j<mat[0].length; j++) {
					resp[i]+=mat[i][j]*vec[j];				
				}
			}
			
			System.out.println();
			System.out.println("\tx= "+Math.rint(resp[0]));				
			System.out.println("\ty= "+Math.rint(resp[1]));
			System.out.println("\tz= "+Math.rint(resp[2]));
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("\tERROR: TAMANO DEL VECTOR INSUFICIENTE");
		}
	}
	/****************************************************/
	
	
	public static void main(String args[]) throws IOException {
		matrices o=new matrices();
		lectura o2=new lectura();
		
		o2.ini();
		
		o2.menu(o2.op);
	}
}
