package application;

import java.util.ArrayList;
import java.util.Arrays;

import javafx.animation.Transition;

public class BubbleSortVisualize extends AbstractSort {
	  private boolean swapped;
	  private ArrayList<Transition> transitions;

	  public BubbleSortVisualize() {
	    this.transitions = new ArrayList<>();
	  }

	  private ArrayList<Transition> compareDataNode(DataNode[] arr, int a, int b) {
	    ArrayList<Transition> transitions = new ArrayList<>();

	    transitions.add(colorCNode(arr, SELECT_COLOR, a, b));

	    if (arr[a].getValue() > arr[b].getValue()) {
	      transitions.add(swap(arr, a, b));
	     
	      swapped = true;
	    } 

	    transitions.add(colorCNode(arr, START_COLOR, a, b));

	    return transitions;
	  }

	  private void bubbleSort(DataNode[] arr) {
	    for (int i = 0; i < arr.length; i++) {
	      swapped = false;
	      for (int j = 0; j < arr.length - 1 - i; j++) {
	        this.transitions.addAll(compareDataNode(arr, j, j + 1));
	      }

	      if (!swapped) {
	        break;
	      }
	    }

	  }

	@Override
	public ArrayList<Transition> startSort(DataNode[] arr) {
		// TODO Auto-generated method stub
		 bubbleSort(arr);

		this.transitions.add(colorCNode(Arrays.asList(arr), SORTED_COLOR));
		return this.transitions;
	}

}
