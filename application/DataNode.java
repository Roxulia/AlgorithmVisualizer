package application;

//import java.time.Duration;

import javafx.animation.TranslateTransition;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class DataNode extends Pane{
	  private int value;
	  private Rectangle r;
	  private Text t;
	  public DataNode(int n) {
	    this.value = n;
	    t=new Text(""+this.value);
	    r=new Rectangle();
	    r.setY(20);
	    this.getChildren().addAll(t,r);
	  }
	  public void setSize(int w,int h)
	  {
		  r.setWidth(w);
		  r.setHeight(h);
	  }
	  public void setFill(Color c)
	  {
		  r.setFill(c);
	  }
	  public int getValue() {
	    return this.value;
	  }
	  public Rectangle getR()
	  {
		  return r;
	  }
	  public TranslateTransition moveX(int x) {
	    TranslateTransition t = new TranslateTransition();
	    t.setNode(this);
	    t.setDuration(Duration.millis(100));
	    t.setByX(x);

	    return t; 
	  }
	 
}
