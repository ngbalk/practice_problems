package practice_problems;


public class SkyView{
    public double[][] view;
    
    /**
    * Would throw index out of bounds error if scanned%(numCols-1) != 0
    *
    */
    public SkyView(int numRows, int numCols, double[] scanned){
    	this.view = new double[numRows][numCols];
        int scannedInd = 0;
        for(int i = 0; i<numRows;i+=2){
            scannedInd = buildRight(scannedInd, numCols-1, i, scanned);
            scannedInd = buildLeft(scannedInd, numCols-1, i+1, scanned);
        }
        
        
    }
    private int buildLeft(int currentInd, int numCols, int rowInd, double[] scanned){
        for(int i = 0;i<=numCols;i++){
            if(currentInd>scanned.length-1){
                break;
            }
            view[rowInd][numCols - i] = scanned[currentInd];
            currentInd++;
        }
        return currentInd;
    }
    private int buildRight(int currentInd, int numCols, int rowInd, double[] scanned){
        for(int i=0;i<=numCols;i++){
            if(currentInd>scanned.length-1){
                break;
            }
            view[rowInd][i] = scanned[currentInd];
            currentInd++;
        }
        return currentInd;
    }
    
    /**
     * Return the average value of the cells included int the specified region
     */
    public double getAverage(int startRow, int endRow, int startCol, int endCol){
        double cellsInSection = 0;
        double runningSum = 0;
        for(int i=0;i<this.view.length;i++){
            for(int j=0;j<this.view[0].length;j++){
                if(i>=startRow && i<=endRow && j>=startCol && j<=endCol){
                    cellsInSection++;
                    runningSum+=this.view[i][j];
                }
            }
        }
        return runningSum/cellsInSection;
        
        
        
        
        
        
        
        
        
    }
    public  void printView(){
    	String ret = "";
    	for(int i = 0;i<this.view.length;i++){
    		for(int j = 0;j<this.view[0].length;j++){
    			System.out.print(view[i][j] + " ");
    		}
    		System.out.println();
    	}

    }
    public static void main(String args[]){
    	
    	double[] input = {1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0};
    	SkyView skyView = new SkyView(2,4,input);
    	skyView.printView();
    	
    	System.out.println(skyView.getAverage(0, 1, 0, 1));
    	
    }
    

}
