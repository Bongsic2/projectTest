package jframe;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFrame;

import clientChat.scoreAll;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;

public class MusicChart extends JFrame {
	private static final long serialVersionUID = 1L;
	public static HashMap<String, Integer> uScore;
	public static List<String> set;
	public static String rankChart1 = "";
	public static String rankChart2 = "";
	public static String rankChart3 = "";
	public static String rankChart4 = "";

	public static int rankScore1 = 0;
	public static int rankScore2 = 0;
	public static int rankScore3 = 0;
	public static int rankScore4 = 0;
	ObservableList<PieChart.Data> pieChartData;

	public void initAndLoadWebView(JFXPanel pnCenter) {
		Group group = new Group();
		Scene scene = new Scene(group);
		pnCenter.setScene(scene);
		uScore = scoreAll.userScore;

		List<String> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();

		Iterator<String> iter = uScore.keySet().iterator();

		for (int i = 0; i < uScore.size(); i++) {
			iter.hasNext();
			String key = iter.next();
			list1.add(key);
			int score = uScore.get(key);
			list2.add(score);
		}
		for (int i = 0; i < list1.size(); i++) {
			if (!rankChart1.contains(list1.get(0))) {
				rankChart1 = list1.get(0);
				rankScore1 = list2.get(0);
			} else if (!rankChart2.contains(list1.get(1))) {
				rankChart2 = list1.get(1);
				rankScore2 = list2.get(1);
			} else if (!rankChart3.contains(list1.get(2))) {
				rankChart3 = list1.get(2);
				rankScore3 = list2.get(2);
			} else if (!rankChart4.contains(list1.get(3))) {
				rankChart4 = list1.get(3);
				rankScore4 = list2.get(3);
			}
		}

		this.add(BorderLayout.CENTER, pnCenter);

		pieChartData = FXCollections.observableArrayList(new PieChart.Data(rankChart1, rankScore1),
				new PieChart.Data(rankChart2, rankScore2), new PieChart.Data(rankChart3, rankScore3),
				new PieChart.Data(rankChart4, rankScore4));

		final PieChart chart = new PieChart(pieChartData);
		chart.setTitle("Game Chart");

		((Group) scene.getRoot()).getChildren().add(chart);
	}

	public MusicChart() {
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JFXPanel pnCenter = new JFXPanel();
		Platform.runLater(new Runnable() {
			public void run() {
				try {
					Thread.sleep(100);
					initAndLoadWebView(pnCenter);
					MusicChart.this.setVisible(true);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void main(String[] args) {
		new MusicChart();
	}
}