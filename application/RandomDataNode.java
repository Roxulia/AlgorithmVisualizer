package application;

import java.util.Random;

import javafx.scene.paint.Color;

public class RandomDataNode {
	public static DataNode[] randomCNodes(int n) {
	    DataNode[] arr = new DataNode[n];
	    Random r = new Random();

	    for (int i = 0; i < arr.length; i++) {
	      arr[i] = new DataNode(1 + r.nextInt(100));
	      arr[i].setTranslateX(i * (600 / arr.length));
	      arr[i].setFill(Color.BLACK);
	      setCNodeDim(arr[i], arr.length);
	    }
	    return arr;
	 
	  }

	  private static void setCNodeDim(DataNode cnode, int n) {
	    cnode.setSize((750) / n-10,((300)
	                      / 100) *
	                      cnode.getValue());
	    
	  }
}
