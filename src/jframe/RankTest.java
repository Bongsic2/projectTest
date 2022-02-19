//package jframe;
//
//import java.net.URL;
//import java.util.ResourceBundle;
//
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.chart.PieChart;
//import javafx.scene.chart.PieChart.Data;
//
//public class RankTest implements Initializable {
//	@FXML
//	private PieChart pieChart;
//	// 개별데이터 -> 리스트 -> 파이차트에 set
//	int java = 10;
//	int cs = 10;
//	int py = 10;
//	int js = 10;
//
//	ObservableList<Data> list = null;
//
//	@Override
//	public void initialize(URL location, ResourceBundle resources) {
//		System.out.println("FXML 완");
//		list = FXCollections.observableArrayList();
//		list.add(new PieChart.Data("Java", java));
//		list.add(new PieChart.Data("C#", cs));
//		list.add(new PieChart.Data("Python", py));
//		list.add(new PieChart.Data("Java Script", js));
//		pieChart.setTitle("선호 언어"); // 타이틀
//		pieChart.setLabelsVisible(true); // 라벨 여부
//		pieChart.setData(list); // 데이터 적용
//	}
//
//}