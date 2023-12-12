package application;

import java.util.ArrayList;
import java.util.Arrays;

import javafx.animation.ParallelTransition;
import javafx.animation.Transition;
import javafx.scene.paint.Color;

public class BinarySearchVisualize extends AbstractSort {

	private ArrayList<Transition> transitions;
	private int toSearch;
	private  long time1;
	  public BinarySearchVisualize(int s) {
	    this.transitions = new ArrayList<>();
	    this.toSearch=s;
	    this.time1=0;
	  }
	@Override
	public ArrayList<Transition> startSort(DataNode[] arr) {
		// TODO Auto-generated method stub
		for (int i = 1; i < arr.length; i++) {
		      int j = i - 1;
		      DataNode key = arr[i];
		      //DataValues k=t[i];
		      int keyIndx = i;

		      ParallelTransition pt = new ParallelTransition();

		      transitions.add(colorCNode(arr, SELECT_COLOR, i));

		      while(j >= 0 && arr[j].getValue() > key.getValue()) {
		        pt.getChildren().add(arr[j].moveX(DX));
		        arr[j + 1] = arr[j];
		        j--;
		      }

		      arr[j + 1] = key;

		      pt.getChildren().add(key.moveX(DX * (j + 1 - i)));
		      transitions.add(pt);
		      transitions.add(colorCNode(arr, START_COLOR, j + 1));

		    }
			time1=System.nanoTime();
		    //transitions.add(colorCNode(Arrays.asList(arr), START_COLOR));
		    int begin = 0, end = arr.length - 1;
	        while (begin <= end) {
	            int middle = (begin + end) / 2;
	            int mid = arr[middle].getValue();
	            ParallelTransition pt=new ParallelTransition();
	            transitions.add(colorCNodeforSearch(arr, SELECT_COLOR,middle));
	            transitions.add(pt);
	            if (mid == toSearch) {
	            	transitions.add(colorCNodeforSearch(arr, Color.GREEN, middle));
	                break;
	            }
	            if (mid < toSearch) {
	                begin = middle + 1;
	                transitions.add(colorCNodeforSearch(arr, Color.AQUAMARINE, middle));
	            }
	            if (mid > toSearch) {
	                end = middle - 1;
	                transitions.add(colorCNodeforSearch(arr, Color.AQUAMARINE, middle));
	            }
	        }
	        time1=System.nanoTime()-time1;
		return this.transitions;
	}
	public long getTime() {
		return time1;
	}

}
