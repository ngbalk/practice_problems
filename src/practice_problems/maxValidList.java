package practice_problems;

public class maxValidList {
	
	public maxValidList() {
		
	}
	public void findMaxCombo(Integer[] list){
		
		Integer[][] dpGrid;
		dpGrid = new Integer[3][list.length/2 + 1];
		dpGrid[0][0] = 0;
		dpGrid[1][0] = 0;
		dpGrid[2][0] = 0;
		int currentGridRow = 1;
			for(int i=0;i<list.length;i=i+2){
				Integer first = list[i];
				Integer second = list[i+1];
				dpGrid[0][currentGridRow] = getMax(dpGrid[0][currentGridRow-1],dpGrid[1][currentGridRow-1] , dpGrid[2][currentGridRow-1]);
				dpGrid[1][currentGridRow] = getMax(dpGrid[0][currentGridRow-1], 0, dpGrid[2][currentGridRow-1]) + first;
				dpGrid[2][currentGridRow] = getMax(dpGrid[0][currentGridRow-1], dpGrid[1][currentGridRow-1], 0) + second;
				currentGridRow++;
			}
		
		this.toString(dpGrid);
		
		
	}
	private  Integer getMax(Integer a, Integer b, Integer c){
		Integer max = 0;
		max = Math.max(a, b);
		max = Math.max(max, c);
		return max;
	}
	private void toString(Integer[][] dpGrid){
		for(int i = 0;i<dpGrid[0].length;i++){
			for(int j = 0;j<3;j++){
				System.out.print(dpGrid[j][i] + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String args[]){
		Integer[] input = {10, 2, 5, 7, 3, 6, 4, 0};
		maxValidList solution = new maxValidList();
		solution.findMaxCombo(input);
	}

	

}
