//This Ques was asked in Nagarro coding round(Also in Microsoft)

import java.util.Scanner;

public class RotateClockwise90deg {
	static int m;
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		m=scan.nextInt();
int [][]arr=new int[m][m];
int i,j;
for(i=0;i<m;i++){
for(j=0;j<m;j++){
	arr[i][j]=scan.nextInt();
}}
rotater(arr,m);
	}

static void rotater(int [][] mat,int m){
int x,y,temp;
for(x=0;x<m/2;x++){
	for(y=x;y<m-x-1;y++){
		temp=mat[x][y];
		mat[x][y]=mat[m-1-x][y]; //left to top
		mat[m-1-x][y]=mat[m-1-x][m-1-y];//bottom to left
		mat[m-1-x][m-1-y]=mat[x][m-1-y];//r to b
		mat[x][m-1-y]=temp;//top to r 
	}
	for(int i=0;i<m;i++){
		for(int j=0;j<m;j++){
		System.out.print(mat[i][j]);	
		}
		System.out.println();}
}
	
}}