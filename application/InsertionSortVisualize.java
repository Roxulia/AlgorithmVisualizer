package application;

import java.util.ArrayList;
import java.util.Arrays;

import javafx.animation.ParallelTransition;
import javafx.animation.Transition;

public class InsertionSortVisualize extends AbstractSort {

	private ArrayList<Transition> transitions;

	  public InsertionSortVisualize() {
	    this.transitions = new ArrayList<>();
	  }

	  @Override
	  public ArrayList<Transition> startSort(DataNode[] arr) {

	    for (int i = 1; i < arr.length; i++) {
	      int j = i - 1;
	      DataNode key = arr[i];
	      //DataValues k=t[i];
	      int keyIndx = i;

	      ParallelTransition pt = new ParallelTransition();

	      transitions.add(colorCNode(arr, SELECT_COLOR, i));

	      while(j >= 0 && arr[j].getValue() > key.getValue()) {
	        pt.getChildren().addAll(arr[j].moveX(DX));
	        arr[j + 1] = arr[j];
	        j--;
	      }

	      arr[j + 1] = key;

	      pt.getChildren().addAll(key.moveX(DX * (j + 1 - i)));
	      transitions.add(pt);
	      transitions.add(colorCNode(arr, START_COLOR, j + 1));

	    }

	    transitions.add(colorCNode(Arrays.asList(arr), SORTED_COLOR));

	    return transitions;

	  }
	  
}
