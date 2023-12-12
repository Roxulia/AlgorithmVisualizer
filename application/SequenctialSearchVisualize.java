package application;

import java.util.ArrayList;

import javafx.animation.ParallelTransition;
import javafx.animation.Transition;
import javafx.scene.paint.Color;

public class SequenctialSearchVisualize extends AbstractSort {

	private ArrayList<Transition> transitions;
	private int tosearch;
	  public SequenctialSearchVisualize(int s) {
	    this.transitions = new ArrayList<>();
	    this.tosearch=s;
	  }
	@Override
	public ArrayList<Transition> startSort(DataNode[] arr) {
		// TODO Auto-generated method stub
		for (int i = 0; i < arr.length; i++) {
		      ParallelTransition pt = new ParallelTransition();

		      transitions.add(colorCNodeforSearch(arr, SELECT_COLOR, i));
		      transitions.add(pt);
		      if(arr[i].getValue()==tosearch)
		      {
		    	  transitions.add(colorCNodeforSearch(arr, Color.GREEN, i));
		    	  break;
		      }
		}
		//transitions.add(colorCNode(arr,START_COLOR,i));
		return this.transitions;
	}

}
