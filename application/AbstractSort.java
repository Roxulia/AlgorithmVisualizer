package application;

import java.util.ArrayList;
import java.util.List;

import javafx.animation.FillTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.Transition;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Duration;

public abstract class AbstractSort {
	final Color START_COLOR = Color.BLACK;
	  final Color SELECT_COLOR = Color.RED;
	  final Color SORTED_COLOR = Color.GREEN;

	  static int DX;
	  static {
	    DX = 600/25;
	  }

	  ParallelTransition colorCNode(DataNode[] arr, Color color, int...a) {
	    ParallelTransition pt = new ParallelTransition();
	    
	    for (int i = 0; i < a.length; i++) {
	      FillTransition ft = new FillTransition();
	      ft.setShape(arr[a[i]].getR());
	      ft.setToValue(color);
	      ft.setDuration(Duration.millis(10));
	      pt.getChildren().add(ft);
	    }
	    return pt;
	  }
	  ParallelTransition colorCNodeforSearch(DataNode[] arr, Color color, int a) {
		    ParallelTransition pt = new ParallelTransition();
		    
		    
		      FillTransition ft = new FillTransition();
		      ft.setShape(arr[a].getR());
		      ft.setToValue(color);
		      ft.setDuration(Duration.millis(500));
		      pt.getChildren().add(ft);
		    
		    return pt;
		  }
	  ParallelTransition colorCNode(List<DataNode> list, Color color) {
	    ParallelTransition pt = new ParallelTransition();
	    
	    for (DataNode c : list) {
	      FillTransition ft = new FillTransition();
	      ft.setShape(c.getR());
	      ft.setToValue(color);
	      ft.setDuration(Duration.millis(10));
	      pt.getChildren().add(ft);
	    }

	    return pt;
	  }

	  ParallelTransition swap(DataNode[] arr, int i, int j) {
	    ParallelTransition pt = new ParallelTransition();

	    int dxFactor = j - i;
	    //System.out.println(dxFactor+" "+j+" "+i);
	    pt.getChildren().addAll(arr[j].moveX(-DX * dxFactor), arr[i].moveX(DX * dxFactor));
	    
	    //pt.getChildren().addAll();
	    DataNode tmp = arr[i];
	    arr[i] = arr[j];
	    arr[j] = tmp;

	    return pt;
	  }

	  public abstract ArrayList<Transition> startSort(DataNode[] arr);
}
