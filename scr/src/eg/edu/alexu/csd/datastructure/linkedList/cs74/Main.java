package eg.edu.alexu.csd.datastructure.linkedList.cs74;

public class Main {

	public static void main(String[] args) {
	int [][] terms1={
			{4,4},
			{-3,2},
			{1,0},
			
	};
	int [][] terms2={
			
			{-5,5},
			{2,2},
			{-1,1},
			{-9,0}
	};
	PolynomialSolver test1=new PolynomialSolver();
	test1.setPolynomial('a', terms1);
	test1.setPolynomial('b', terms2); 
	int [][] resault =new int [4][2];
	resault = test1.add('a', 'b');
	
	for (int i = 0; i < resault.length; i++) {
		for (int j = 0; j < 2; j++) {
			System.out.println(resault[i][j]);
		}
		
	}
	}

}
