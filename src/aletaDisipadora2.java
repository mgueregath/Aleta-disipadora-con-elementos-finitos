public class aletaDisipadora2{
	static double [][] matrizA;
	static double [] matrizB;
	static int nodos;
	static double[] temperaturas;
	static void matriz(int n, double ti, double tf, double k,double h,double l,double an,double al){
		n=n+2;
		nodos=n;
		double largo=l/1000;
		double ancho=an/1000;
		double alto=al/1000;
		matrizA = new double[n][n];
		matrizB = new double[n];
		matrizA[0][0]=1;
		matrizA[n-1][n-1]=1;
		matrizB[0]=ti;
		matrizB[n-1]=tf;
		double a,b,c,d,area,perimetro,paso;
		paso=largo/(nodos-2);
		area=ancho*alto;
		perimetro=ancho+ancho+alto+alto;
		d=h*perimetro*tf;		
		a=(k*area)/(paso*paso);
		c=a;
		b=-a*2-h*perimetro;
		for(int i=1;i<n-1;i++){
			if(i!=1&&i!=n-2){
				matrizB[i]=-d;
				matrizA[i][i-1]=a;
				matrizA[i][i]=b;
				matrizA[i][i+1]=c;
			}
			else if(i==1){
				matrizB[1]=-ti*a-d;
				matrizA[1][1]=b;
				matrizA[1][2]=c;
			}
			else{
				matrizB[n-2]=-tf*a-d;
				matrizA[i][i]=b;
				matrizA[i][i-1]=a;
			}
		}
			
	}
	static double[] matrizPorMatriz(double [][] Ma, double [] Mb){
		double [] resultante =new double[nodos];
		double suma=0;
		for(int i=0;i<nodos;i++){
			for(int j=0;j<nodos;j++){
				suma+=Ma[i][j]*Mb[j];
			}
			resultante[i]=Math.rint(suma*1000)/1000;
			suma=0;
		}
		return resultante;
	}
	public static double[] calcular (int n, double ti, double tf, double k,double h,double l,double an,double al){
		matriz(n,ti,tf,k,h,l,an,al);
		double [][] m=matrices.inversa(matrizA,nodos);
		temperaturas=matrizPorMatriz(m,matrizB);
                return temperaturas;

	}

}
