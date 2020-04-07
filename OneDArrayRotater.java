package rotateArray;

public class OneDArrayRotater {
	private int k;
	private int[] array;
	
	public OneDArrayRotater() {	}
	
	public int[] rotateToLeft(int[] array, int k){
		this.k = k;
		this.array = array;
		int[] intermediateArray = new int[this.array.length];
		while(this.k-- > 0) {
			int intermediateValue = this.array[0];
			System.arraycopy(this.array, 1, intermediateArray, 0, this.array.length-1);
			intermediateArray[ this.array.length-1 ]  = intermediateValue;
			this.array = intermediateArray;
		}
		return intermediateArray;
	}
	public int[] rotateToRight(int[] array, int k){
		this.k = k;
		this.array = array;
		int[] intermediateArray = new int[this.array.length];
		while(this.k-- > 0) {
			int intermediateValue = this.array[ this.array.length-1 ];
			System.arraycopy(this.array, 0, intermediateArray, 1, this.array.length-1);
			intermediateArray[ 0 ]  = intermediateValue;
			this.array = intermediateArray;
		}
		return intermediateArray;
	}
}
