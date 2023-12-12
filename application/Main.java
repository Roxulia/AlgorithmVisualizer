package application;
	
import java.awt.Label;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;


public class Main extends Application {
    
    AlgrithmTime alt=new AlgrithmTime();
	String[] algorithmlist= {"Selection Sort","Insertion Sort","Bubble Sort","Sequenctial Search","Binary Search"};
	@Override
	public void start(Stage primaryStage) {
		
		try {
			Button btn_show = new Button("show");
			Button btn_run = new Button("run");
			Text txtalgorithm=new Text("Pls Choose a algorithm : ");
			Text txtToSearch=new Text();
			ComboBox cbalgorithm=new ComboBox(FXCollections.observableArrayList(algorithmlist));
			Group g = new Group();
			Pane canvas=new Pane();
			
			
			btn_run.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					// TODO Auto-generated method stub
					if(!g.getChildren().isEmpty())g.getChildren().clear();
					if(!canvas.getChildren().isEmpty())canvas.getChildren().clear();
					btn_run.setDisable(true);
					btn_show.setDisable(true);
					//g.getChildren().add(canvas);
					Text txttime=new Text("Time taken to finish = ");
					txttime.setTranslateX(300);
					txttime.setTranslateY(400);
					
					DataNode[] data=RandomDataNode.randomCNodes(25);
					
					canvas.getChildren().addAll(Arrays.asList(data));
					//canvas.getChildren().addAll(numbers);
					switch(cbalgorithm.getValue().toString())
					{
					case "Bubble Sort":{
						SequentialTransition sq = new SequentialTransition();

						long t1=System.nanoTime();
						sq.getChildren().addAll(new BubbleSortVisualize().startSort(data));
		            
						sq.setOnFinished(e -> {
							btn_run.setDisable(false);
							btn_show.setDisable(false);
							txttime.setText("Time taken to finish = "+((System.nanoTime()-t1)/1000000)+" ms");
							canvas.getChildren().add(txttime);
						});

						sq.play();break;}
					case "Selection Sort":{
						SequentialTransition sq = new SequentialTransition();
						long t1=System.nanoTime();
			            sq.getChildren().addAll(new SelectionSortVisualize().startSort(data));

			            sq.setOnFinished(e -> {
			                btn_run.setDisable(false);
			                btn_show.setDisable(false);
			                txttime.setText("Time taken to finish = "+((System.nanoTime()-t1)/1000000)+" ms");
							canvas.getChildren().add(txttime);
			            });

			            sq.play();
			            break;
					}
					case "Insertion Sort":{
						SequentialTransition sq = new SequentialTransition();
						long t1=System.nanoTime();
			            sq.getChildren().addAll(new InsertionSortVisualize().startSort(data));

			            sq.setOnFinished(e -> {
			                btn_run.setDisable(false);
			                btn_show.setDisable(false);
			                txttime.setText("Time taken to finish = "+((System.nanoTime()-t1)/1000000)+" ms");
							canvas.getChildren().add(txttime);
			            });

			            sq.play();
			            break;}
					case "Sequenctial Search":{
						SequentialTransition sq = new SequentialTransition();
						for(int i=0;i<data.length;i++)
						{
							data[i].setTranslateY(30);
						}
						txtToSearch.setTranslateX(canvas.getMaxWidth()/1.5);
						txtToSearch.setTranslateY(0);
						int tosearch=data[new Random().nextInt(25)].getValue();
						txtToSearch.setText("Value to Search = "+tosearch);
						canvas.getChildren().add(txtToSearch);
						long t1=System.nanoTime();
			            sq.getChildren().addAll(new SequenctialSearchVisualize(tosearch).startSort(data));

			            sq.setOnFinished(e -> {
			                btn_run.setDisable(false);
			                btn_show.setDisable(false);
			                txttime.setText("Time taken to finish = "+((System.nanoTime()-t1)/1000000)+" ms");
							canvas.getChildren().add(txttime);
			            });

			            sq.play();
			            break;

					}
					case "Binary Search":{
						SequentialTransition sq = new SequentialTransition();
						for(int i=0;i<data.length;i++)
						{
							data[i].setTranslateY(30);
						}
						txtToSearch.setTranslateX(canvas.getMaxWidth()/1.5);
						txtToSearch.setTranslateY(0);
						int tosearch=data[new Random().nextInt(25)].getValue();
						txtToSearch.setText("Value to Search = "+tosearch);
						canvas.getChildren().add(txtToSearch);
						BinarySearchVisualize bsv=new BinarySearchVisualize(tosearch);
			            sq.getChildren().addAll(bsv.startSort(data));

			            sq.setOnFinished(e -> {
			                btn_run.setDisable(false);
			                btn_show.setDisable(false);
			                txttime.setText("Time taken to finish = "+(bsv.getTime()/1000)+" microsec");
							canvas.getChildren().add(txttime);
			            });

			            sq.play();
			            break;

					}

					}
					}
				
			});
			
			btn_show.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					// TODO Auto-generated method stub
					if(cbalgorithm.getValue()!=null)
					{
						if(!g.getChildren().isEmpty())g.getChildren().clear();
						if(!canvas.getChildren().isEmpty())canvas.getChildren().clear();
						final NumberAxis x=new NumberAxis(0,50,5);
						x.setLabel("Array length");
						XYChart.Series  series=new XYChart.Series<>();
						switch(cbalgorithm.getValue().toString())
						{
						case "Selection Sort":series.setName("Time Complexity of Selection Sort");break;
						case "Insertion Sort":series.setName("Time Complexity of Insertion Sort");break;
						case "Binary Search":series.setName("Time Complexity of Binary search");break;
						case "Sequenctial Search":series.setName("Time Complexity of Sequenctial Search");break;
						case "Bubble Sort": series.setName("Time Complexity of Bubble Sort");break;
						}
						long ymax=0;long yvalue=0;
						int a[]=alt.generateArray(50);
						for(int i=0;i<50;i+=5)
						{
							
							switch(cbalgorithm.getValue().toString())
							{
							case "Selection Sort":yvalue=alt.selectionSort(i,a);break;
							case "Insertion Sort":yvalue=alt.insertionSort(i,a);break;
							case "Binary Search":yvalue=alt.binarysearch(i,a);break;
							case "Sequenctial Search":yvalue=alt.sequentialSearch(i,a);break;
							case "Bubble Sort":yvalue=alt.bubbleSort(i,a); break;
							}
							series.getData().add(new XYChart.Data(i,yvalue));
							if(yvalue>ymax)ymax=yvalue;
						}
						final NumberAxis y;
						if(ymax<10) y=new NumberAxis(0,10,1);
						else {
							 y=new NumberAxis(0,1100,110);
							 }
						y.setLabel("No of Operation");
						LineChart l=new LineChart(x,y);
						l.getData().add(series);
						g.getChildren().add(l);
					}
					else
					{
						Alert alert = new Alert(Alert.AlertType.ERROR);
						alert.setTitle("Error");
						alert.setContentText("Please choose an algorithm");
						alert.showAndWait();
					}
					
				}
				
				
			});
			
			
			VBox root = new VBox();
			HBox hb= new HBox(txtalgorithm,cbalgorithm,btn_show,btn_run);
			root.getChildren().addAll(hb,g,canvas);
			root.setMargin((javafx.scene.Node)hb, new javafx.geometry.Insets(30,0,0,0));
			root.setMargin((javafx.scene.Node)g, new javafx.geometry.Insets(50,0,0,50));
			root.setMargin((javafx.scene.Node)canvas, new javafx.geometry.Insets(0,0,0,50));
			
			//hb.getChildren().addAll(txttest,b);
			hb.setSpacing(50);
			hb.setMargin((javafx.scene.Node)txtalgorithm, new javafx.geometry.Insets(0,0,0,70));
			Scene scene = new Scene(root,700,600);
			primaryStage.setTitle("Algorithm Visualizer");
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}