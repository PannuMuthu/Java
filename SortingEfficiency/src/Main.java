import java.util.ArrayList;
import java.util.Random;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.time.Instant; 
import java.time.Duration;

public class Main extends Application{
	@Override
	public void start(Stage stage) {
		
		Random random = new Random();
		
		ArrayList<Integer> fiftyKList = new ArrayList<>();
		for (int i = 0; i < 50000; i++) {
			fiftyKList.add(random.nextInt(1000));
		}
		
		ArrayList<Integer> insertionSortFiftyK = new ArrayList<>();
		ArrayList<Integer> bubbleSortFiftyK = new ArrayList<>();
		ArrayList<Integer> selectionSortFiftyK = new ArrayList<>();
		ArrayList<Integer> mergeSortFiftyK = new ArrayList<>();
		ArrayList<Integer> quickSortFiftyK = new ArrayList<>();
		ArrayList<Integer> countingSortFiftyK = new ArrayList<>();
		ArrayList<Integer> radixSortFiftyK = new ArrayList<>();

		for (Integer i : fiftyKList) {
			insertionSortFiftyK.add(i);
			bubbleSortFiftyK.add(i);
			selectionSortFiftyK.add(i);
			mergeSortFiftyK.add(i);
			quickSortFiftyK.add(i);
			countingSortFiftyK.add(i);
			radixSortFiftyK.add(i);
		}
		
		Instant startInsertionFiftyK = Instant.now();
		Sorting.insertionSort(insertionSortFiftyK);
		Instant endInsertionFiftyK = Instant.now();
		Duration insertionFiftyKTime = Duration.between(startInsertionFiftyK, endInsertionFiftyK);
		
		Instant startBubbleFiftyK = Instant.now();
		Sorting.bubbleSort(bubbleSortFiftyK);
		Instant endBubbleFiftyK = Instant.now();
		Duration bubbleFiftyKTime = Duration.between(startBubbleFiftyK, endBubbleFiftyK);
		
		Instant startSelectionFiftyK = Instant.now();
		Sorting.selectionSort(selectionSortFiftyK);
		Instant endSelectionFiftyK = Instant.now();
		Duration selectionFiftyKTime = Duration.between(startSelectionFiftyK, endSelectionFiftyK);
		
		Instant startMergeFiftyK = Instant.now();
		Sorting.mergeSort(mergeSortFiftyK);
		Instant endMergeFiftyK = Instant.now();
		Duration mergeFiftyKTime = Duration.between(startMergeFiftyK, endMergeFiftyK);
		
		Instant startQuickFiftyK = Instant.now();
		Sorting.quickSort(quickSortFiftyK);
		Instant endQuickFiftyK = Instant.now();
		Duration quickFiftyKTime = Duration.between(startQuickFiftyK, endQuickFiftyK);
		
		Instant startCountingFiftyK = Instant.now();
		Sorting.countingSort(countingSortFiftyK);
		Instant endCountingFiftyK = Instant.now();
		Duration countingFiftyKTime = Duration.between(startCountingFiftyK, endCountingFiftyK);
		
		Instant startRadixFiftyK = Instant.now();
		Sorting.radixSort(radixSortFiftyK);
		Instant endRadixFiftyK = Instant.now();
		Duration radixFiftyKTime = Duration.between(startRadixFiftyK, endRadixFiftyK);
		
		ArrayList<Integer> hundredKList = new ArrayList<>();
		for (int i = 0; i < 100000; i++) {
			hundredKList.add(random.nextInt(1000));
		}
		
		ArrayList<Integer> insertionSortHundredK = new ArrayList<>();
		ArrayList<Integer> bubbleSortHundredK = new ArrayList<>();
		ArrayList<Integer> selectionSortHundredK = new ArrayList<>();
		ArrayList<Integer> mergeSortHundredK = new ArrayList<>();
		ArrayList<Integer> quickSortHundredK = new ArrayList<>();
		ArrayList<Integer> countingSortHundredK = new ArrayList<>();
		ArrayList<Integer> radixSortHundredK = new ArrayList<>();

		for (Integer i : hundredKList) {
			insertionSortHundredK.add(i);
			bubbleSortHundredK.add(i);
			selectionSortHundredK.add(i);
			mergeSortHundredK.add(i);
			quickSortHundredK.add(i);
			countingSortHundredK.add(i);
			radixSortHundredK.add(i);
		}
		
		Instant startInsertionHundredK = Instant.now();
		Sorting.insertionSort(insertionSortHundredK);
		Instant endInsertionHundredK = Instant.now();
		Duration insertionHundredKTime = Duration.between(startInsertionHundredK, endInsertionHundredK);
		
		Instant startBubbleHundredK = Instant.now();
		Sorting.bubbleSort(bubbleSortHundredK);
		Instant endBubbleHundredK = Instant.now();
		Duration bubbleHundredKTime = Duration.between(startBubbleHundredK, endBubbleHundredK);
		
		Instant startSelectionHundredK = Instant.now();
		Sorting.selectionSort(selectionSortHundredK);
		Instant endSelectionHundredK = Instant.now();
		Duration selectionHundredKTime = Duration.between(startSelectionHundredK, endSelectionHundredK);
		
		Instant startMergeHundredK = Instant.now();
		Sorting.mergeSort(mergeSortHundredK);
		Instant endMergeHundredK = Instant.now();
		Duration mergeHundredKTime = Duration.between(startMergeHundredK, endMergeHundredK);
		
		Instant startQuickHundredK = Instant.now();
		Sorting.quickSort(quickSortHundredK);
		Instant endQuickHundredK = Instant.now();
		Duration quickHundredKTime = Duration.between(startQuickHundredK, endQuickHundredK);
		
		Instant startCountingHundredK = Instant.now();
		Sorting.countingSort(countingSortHundredK);
		Instant endCountingHundredK = Instant.now();
		Duration countingHundredKTime = Duration.between(startCountingHundredK, endCountingHundredK);
		
		Instant startRadixHundredK = Instant.now();
		Sorting.radixSort(radixSortHundredK);
		Instant endRadixHundredK = Instant.now();
		Duration radixHundredKTime = Duration.between(startRadixHundredK, endRadixHundredK);
		
		ArrayList<Integer> hundredFiftyKList = new ArrayList<>();
		for (int i = 0; i < 150000; i++) {
			hundredFiftyKList.add(random.nextInt(1000));
		}
		
		ArrayList<Integer> insertionSortHundredFiftyK = new ArrayList<>();
		ArrayList<Integer> bubbleSortHundredFiftyK = new ArrayList<>();
		ArrayList<Integer> selectionSortHundredFiftyK = new ArrayList<>();
		ArrayList<Integer> mergeSortHundredFiftyK = new ArrayList<>();
		ArrayList<Integer> quickSortHundredFiftyK = new ArrayList<>();
		ArrayList<Integer> countingSortHundredFiftyK = new ArrayList<>();
		ArrayList<Integer> radixSortHundredFiftyK = new ArrayList<>();

		for (Integer i : hundredFiftyKList) {
			insertionSortHundredFiftyK.add(i);
			bubbleSortHundredFiftyK.add(i);
			selectionSortHundredFiftyK.add(i);
			mergeSortHundredFiftyK.add(i);
			quickSortHundredFiftyK.add(i);
			countingSortHundredFiftyK.add(i);
			radixSortHundredFiftyK.add(i);
		}
		
		Instant startInsertionHundredFiftyK = Instant.now();
		Sorting.insertionSort(insertionSortHundredFiftyK);
		Instant endInsertionHundredFiftyK = Instant.now();
		Duration insertionHundredFiftyKTime = Duration.between(startInsertionHundredFiftyK, endInsertionHundredFiftyK);
		
		Instant startBubbleHundredFiftyK = Instant.now();
		Sorting.bubbleSort(bubbleSortHundredFiftyK);
		Instant endBubbleHundredFiftyK = Instant.now();
		Duration bubbleHundredFiftyKTime = Duration.between(startBubbleHundredFiftyK, endBubbleHundredFiftyK);
		
		Instant startSelectionHundredFiftyK = Instant.now();
		Sorting.selectionSort(selectionSortHundredFiftyK);
		Instant endSelectionHundredFiftyK = Instant.now();
		Duration selectionHundredFiftyKTime = Duration.between(startSelectionHundredFiftyK, endSelectionHundredFiftyK);
		
		Instant startMergeHundredFiftyK = Instant.now();
		Sorting.mergeSort(mergeSortHundredFiftyK);
		Instant endMergeHundredFiftyK = Instant.now();
		Duration mergeHundredFiftyKTime = Duration.between(startMergeHundredFiftyK, endMergeHundredFiftyK);
		
		Instant startQuickHundredFiftyK = Instant.now();
		Sorting.quickSort(quickSortHundredFiftyK);
		Instant endQuickHundredFiftyK = Instant.now();
		Duration quickHundredFiftyKTime = Duration.between(startQuickHundredFiftyK, endQuickHundredFiftyK);
		
		Instant startCountingHundredFiftyK = Instant.now();
		Sorting.countingSort(countingSortHundredFiftyK);
		Instant endCountingHundredFiftyK = Instant.now();
		Duration countingHundredFiftyKTime = Duration.between(startCountingHundredFiftyK, endCountingHundredFiftyK);
		
		Instant startRadixHundredFiftyK = Instant.now();
		Sorting.radixSort(radixSortHundredFiftyK);
		Instant endRadixHundredFiftyK = Instant.now();
		Duration radixHundredFiftyKTime = Duration.between(startRadixHundredFiftyK, endRadixHundredFiftyK);
		
		ArrayList<Integer> twoHundredKList = new ArrayList<>();
		for (int i = 0; i < 200000; i++) {
			twoHundredKList.add(random.nextInt(1000));
		}
		
		ArrayList<Integer> insertionSortTwoHundredK = new ArrayList<>();
		ArrayList<Integer> bubbleSortTwoHundredK = new ArrayList<>();
		ArrayList<Integer> selectionSortTwoHundredK = new ArrayList<>();
		ArrayList<Integer> mergeSortTwoHundredK = new ArrayList<>();
		ArrayList<Integer> quickSortTwoHundredK = new ArrayList<>();
		ArrayList<Integer> countingSortTwoHundredK = new ArrayList<>();
		ArrayList<Integer> radixSortTwoHundredK = new ArrayList<>();

		for (Integer i : twoHundredKList) {
			insertionSortTwoHundredK.add(i);
			bubbleSortTwoHundredK.add(i);
			selectionSortTwoHundredK.add(i);
			mergeSortTwoHundredK.add(i);
			quickSortTwoHundredK.add(i);
			countingSortTwoHundredK.add(i);
			radixSortTwoHundredK.add(i);
		}
		
		Instant startInsertionTwoHundredK = Instant.now();
		Sorting.insertionSort(insertionSortTwoHundredK);
		Instant endInsertionTwoHundredK = Instant.now();
		Duration insertionTwoHundredKTime = Duration.between(startInsertionTwoHundredK, endInsertionTwoHundredK);
		
		Instant startBubbleTwoHundredK = Instant.now();
		Sorting.bubbleSort(bubbleSortTwoHundredK);
		Instant endBubbleTwoHundredK = Instant.now();
		Duration bubbleTwoHundredKTime = Duration.between(startBubbleTwoHundredK, endBubbleTwoHundredK);
		
		Instant startSelectionTwoHundredK = Instant.now();
		Sorting.selectionSort(selectionSortTwoHundredK);
		Instant endSelectionTwoHundredK = Instant.now();
		Duration selectionTwoHundredKTime = Duration.between(startSelectionTwoHundredK, endSelectionTwoHundredK);
		
		Instant startMergeTwoHundredK = Instant.now();
		Sorting.mergeSort(mergeSortTwoHundredK);
		Instant endMergeTwoHundredK = Instant.now();
		Duration mergeTwoHundredKTime = Duration.between(startMergeTwoHundredK, endMergeTwoHundredK);
		
		Instant startQuickTwoHundredK = Instant.now();
		Sorting.quickSort(quickSortTwoHundredK);
		Instant endQuickTwoHundredK = Instant.now();
		Duration quickTwoHundredKTime = Duration.between(startQuickTwoHundredK, endQuickTwoHundredK);
		
		Instant startCountingTwoHundredK = Instant.now();
		Sorting.countingSort(countingSortTwoHundredK);
		Instant endCountingTwoHundredK = Instant.now();
		Duration countingTwoHundredKTime = Duration.between(startCountingTwoHundredK, endCountingTwoHundredK);
		
		Instant startRadixTwoHundredK = Instant.now();
		Sorting.radixSort(radixSortTwoHundredK);
		Instant endRadixTwoHundredK = Instant.now();
		Duration radixTwoHundredKTime = Duration.between(startRadixTwoHundredK, endRadixTwoHundredK);
		
		ArrayList<Integer> twoHundredFiftyKList = new ArrayList<>();
		for (int i = 0; i < 250000; i++) {
			twoHundredFiftyKList.add(random.nextInt(1000));
		}
		
		ArrayList<Integer> insertionSortTwoHundredFiftyK = new ArrayList<>();
		ArrayList<Integer> bubbleSortTwoHundredFiftyK = new ArrayList<>();
		ArrayList<Integer> selectionSortTwoHundredFiftyK = new ArrayList<>();
		ArrayList<Integer> mergeSortTwoHundredFiftyK = new ArrayList<>();
		ArrayList<Integer> quickSortTwoHundredFiftyK = new ArrayList<>();
		ArrayList<Integer> countingSortTwoHundredFiftyK = new ArrayList<>();
		ArrayList<Integer> radixSortTwoHundredFiftyK = new ArrayList<>();

		for (Integer i : twoHundredFiftyKList) {
			insertionSortTwoHundredFiftyK.add(i);
			bubbleSortTwoHundredFiftyK.add(i);
			selectionSortTwoHundredFiftyK.add(i);
			mergeSortTwoHundredFiftyK.add(i);
			quickSortTwoHundredFiftyK.add(i);
			countingSortTwoHundredFiftyK.add(i);
			radixSortTwoHundredFiftyK.add(i);
		}
		
		Instant startInsertionTwoHundredFiftyK = Instant.now();
		Sorting.insertionSort(insertionSortTwoHundredFiftyK);
		Instant endInsertionTwoHundredFiftyK = Instant.now();
		Duration insertionTwoHundredFiftyKTime = Duration.between(startInsertionTwoHundredFiftyK, endInsertionTwoHundredFiftyK);
		
		Instant startBubbleTwoHundredFiftyK = Instant.now();
		Sorting.bubbleSort(bubbleSortTwoHundredFiftyK);
		Instant endBubbleTwoHundredFiftyK = Instant.now();
		Duration bubbleTwoHundredFiftyKTime = Duration.between(startBubbleTwoHundredFiftyK, endBubbleTwoHundredFiftyK);
		
		Instant startSelectionTwoHundredFiftyK = Instant.now();
		Sorting.selectionSort(selectionSortTwoHundredFiftyK);
		Instant endSelectionTwoHundredFiftyK = Instant.now();
		Duration selectionTwoHundredFiftyKTime = Duration.between(startSelectionTwoHundredFiftyK, endSelectionTwoHundredFiftyK);
		
		Instant startMergeTwoHundredFiftyK = Instant.now();
		Sorting.mergeSort(mergeSortTwoHundredFiftyK);
		Instant endMergeTwoHundredFiftyK = Instant.now();
		Duration mergeTwoHundredFiftyKTime = Duration.between(startMergeTwoHundredFiftyK, endMergeTwoHundredFiftyK);
		
		Instant startQuickTwoHundredFiftyK = Instant.now();
		Sorting.quickSort(quickSortTwoHundredFiftyK);
		Instant endQuickTwoHundredFiftyK = Instant.now();
		Duration quickTwoHundredFiftyKTime = Duration.between(startQuickTwoHundredFiftyK, endQuickTwoHundredFiftyK);
		
		Instant startCountingTwoHundredFiftyK = Instant.now();
		Sorting.countingSort(countingSortTwoHundredFiftyK);
		Instant endCountingTwoHundredFiftyK = Instant.now();
		Duration countingTwoHundredFiftyKTime = Duration.between(startCountingTwoHundredFiftyK, endCountingTwoHundredFiftyK);
		
		Instant startRadixTwoHundredFiftyK = Instant.now();
		Sorting.radixSort(radixSortTwoHundredFiftyK);
		Instant endRadixTwoHundredFiftyK = Instant.now();
		Duration radixTwoHundredFiftyKTime = Duration.between(startRadixTwoHundredFiftyK, endRadixTwoHundredFiftyK);
		
		ArrayList<Integer> threeHundredKList = new ArrayList<>();
		for (int i = 0; i < 300000; i++) {
			threeHundredKList.add(random.nextInt(1000));
		}
		
		ArrayList<Integer> insertionSortThreeHundredK = new ArrayList<>();
		ArrayList<Integer> bubbleSortThreeHundredK = new ArrayList<>();
		ArrayList<Integer> selectionSortThreeHundredK = new ArrayList<>();
		ArrayList<Integer> mergeSortThreeHundredK = new ArrayList<>();
		ArrayList<Integer> quickSortThreeHundredK = new ArrayList<>();
		ArrayList<Integer> countingSortThreeHundredK = new ArrayList<>();
		ArrayList<Integer> radixSortThreeHundredK = new ArrayList<>();

		for (Integer i : threeHundredKList) {
			insertionSortThreeHundredK.add(i);
			bubbleSortThreeHundredK.add(i);
			selectionSortThreeHundredK.add(i);
			mergeSortThreeHundredK.add(i);
			quickSortThreeHundredK.add(i);
			countingSortThreeHundredK.add(i);
			radixSortThreeHundredK.add(i);
		}
		
		Instant startInsertionThreeHundredK = Instant.now();
		Sorting.insertionSort(insertionSortThreeHundredK);
		Instant endInsertionThreeHundredK = Instant.now();
		Duration insertionThreeHundredKTime = Duration.between(startInsertionThreeHundredK, endInsertionThreeHundredK);
		
		Instant startBubbleThreeHundredK = Instant.now();
		Sorting.bubbleSort(bubbleSortThreeHundredK);
		Instant endBubbleThreeHundredK = Instant.now();
		Duration bubbleThreeHundredKTime = Duration.between(startBubbleThreeHundredK, endBubbleThreeHundredK);
		
		Instant startSelectionThreeHundredK = Instant.now();
		Sorting.selectionSort(selectionSortThreeHundredK);
		Instant endSelectionThreeHundredK = Instant.now();
		Duration selectionThreeHundredKTime = Duration.between(startSelectionThreeHundredK, endSelectionThreeHundredK);
		
		Instant startMergeThreeHundredK = Instant.now();
		Sorting.mergeSort(mergeSortThreeHundredK);
		Instant endMergeThreeHundredK = Instant.now();
		Duration mergeThreeHundredKTime = Duration.between(startMergeThreeHundredK, endMergeThreeHundredK);
		
		Instant startQuickThreeHundredK = Instant.now();
		Sorting.quickSort(quickSortThreeHundredK);
		Instant endQuickThreeHundredK = Instant.now();
		Duration quickThreeHundredKTime = Duration.between(startQuickThreeHundredK, endQuickThreeHundredK);
		
		Instant startCountingThreeHundredK = Instant.now();
		Sorting.countingSort(countingSortThreeHundredK);
		Instant endCountingThreeHundredK = Instant.now();
		Duration countingThreeHundredKTime = Duration.between(startCountingThreeHundredK, endCountingThreeHundredK);
		
		Instant startRadixThreeHundredK = Instant.now();
		Sorting.radixSort(radixSortThreeHundredK);
		Instant endRadixThreeHundredK = Instant.now();
		Duration radixThreeHundredKTime = Duration.between(startRadixThreeHundredK, endRadixThreeHundredK);
		
		System.out.println("50K ARRAY");
		System.out.println("Insertion Sort: "+ insertionFiftyKTime.toMillis());
		System.out.println("Bubble Sort: "+ bubbleFiftyKTime.toMillis());
		System.out.println("Selection Sort: "+ selectionFiftyKTime.toMillis());
		System.out.println("Merge Sort: "+ mergeFiftyKTime.toMillis());
		System.out.println("Quick Sort: "+ quickFiftyKTime.toMillis());
		System.out.println("Counting Sort: "+ countingFiftyKTime.toMillis());
		System.out.println("Radix Sort: "+ radixFiftyKTime.toMillis());	
		System.out.println("100K ARRAY");
		System.out.println("Insertion Sort: "+ insertionHundredKTime.toMillis());
		System.out.println("Bubble Sort: "+ bubbleHundredKTime.toMillis());
		System.out.println("Selection Sort: "+ selectionHundredKTime.toMillis());
		System.out.println("Merge Sort: "+ mergeHundredKTime.toMillis());
		System.out.println("Quick Sort: "+ quickHundredKTime.toMillis());
		System.out.println("Counting Sort: "+ countingHundredKTime.toMillis());
		System.out.println("Radix Sort: "+ radixHundredKTime.toMillis());
		System.out.println("150K ARRAY");
		System.out.println("Insertion Sort: "+ insertionHundredFiftyKTime.toMillis());
		System.out.println("Bubble Sort: "+ bubbleHundredFiftyKTime.toMillis());
		System.out.println("Selection Sort: "+ selectionHundredFiftyKTime.toMillis());
		System.out.println("Merge Sort: "+ mergeHundredFiftyKTime.toMillis());
		System.out.println("Quick Sort: "+ quickHundredFiftyKTime.toMillis());
		System.out.println("Counting Sort: "+ countingHundredFiftyKTime.toMillis());
		System.out.println("Radix Sort: "+ radixHundredFiftyKTime.toMillis());
		System.out.println("200K ARRAY");
		System.out.println("Insertion Sort: "+ insertionTwoHundredKTime.toMillis());
		System.out.println("Bubble Sort: "+ bubbleTwoHundredKTime.toMillis());
		System.out.println("Selection Sort: "+ selectionTwoHundredKTime.toMillis());
		System.out.println("Merge Sort: "+ mergeTwoHundredKTime.toMillis());
		System.out.println("Quick Sort: "+ quickTwoHundredKTime.toMillis());
		System.out.println("Counting Sort: "+ countingTwoHundredKTime.toMillis());
		System.out.println("Radix Sort: "+ radixTwoHundredKTime.toMillis());
		System.out.println("250K ARRAY");
		System.out.println("Insertion Sort: "+ insertionTwoHundredFiftyKTime.toMillis());
		System.out.println("Bubble Sort: "+ bubbleTwoHundredFiftyKTime.toMillis());
		System.out.println("Selection Sort: "+ selectionTwoHundredFiftyKTime.toMillis());
		System.out.println("Merge Sort: "+ mergeTwoHundredFiftyKTime.toMillis());
		System.out.println("Quick Sort: "+ quickTwoHundredFiftyKTime.toMillis());
		System.out.println("Counting Sort: "+ countingTwoHundredFiftyKTime.toMillis());
		System.out.println("Radix Sort: "+ radixTwoHundredFiftyKTime.toMillis());
		System.out.println("300K ARRAY");
		System.out.println("Insertion Sort: "+ insertionThreeHundredKTime.toMillis());
		System.out.println("Bubble Sort: "+ bubbleThreeHundredKTime.toMillis());
		System.out.println("Selection Sort: "+ selectionThreeHundredKTime.toMillis());
		System.out.println("Merge Sort: "+ mergeThreeHundredKTime.toMillis());
		System.out.println("Quick Sort: "+ quickThreeHundredKTime.toMillis());
		System.out.println("Counting Sort: "+ countingThreeHundredKTime.toMillis());
		System.out.println("Radix Sort: "+ radixThreeHundredKTime.toMillis());
		
		 final NumberAxis xAxis = new NumberAxis();
	     final NumberAxis yAxis = new NumberAxis();
	     xAxis.setLabel("Size of Array");
	     yAxis.setLabel("Time in milliseconds");
	     
	     final LineChart<Number,Number> lineChart = new LineChart<Number,Number>(xAxis,yAxis);
	                
	     lineChart.setTitle("Various Sorting Algorithm Efficiency Comparisons");
	     XYChart.Series insertionSeries = new XYChart.Series();
	     insertionSeries.setName("Insertion Sort");
	     insertionSeries.getData().add(new XYChart.Data(50000, insertionFiftyKTime.toMillis()));
	     insertionSeries.getData().add(new XYChart.Data(100000, insertionHundredKTime.toMillis()));
	     insertionSeries.getData().add(new XYChart.Data(150000, insertionHundredFiftyKTime.toMillis()));
	     insertionSeries.getData().add(new XYChart.Data(200000, insertionTwoHundredKTime.toMillis()));
	     insertionSeries.getData().add(new XYChart.Data(250000, insertionTwoHundredFiftyKTime.toMillis()));
	     insertionSeries.getData().add(new XYChart.Data(300000, insertionThreeHundredKTime.toMillis()));   
	        
	     XYChart.Series bubbleSeries = new XYChart.Series();
	     bubbleSeries.setName("Bubble Sort");
	     bubbleSeries.getData().add(new XYChart.Data(50000, bubbleFiftyKTime.toMillis()));
	     bubbleSeries.getData().add(new XYChart.Data(100000, bubbleHundredKTime.toMillis()));
	     bubbleSeries.getData().add(new XYChart.Data(150000, bubbleHundredFiftyKTime.toMillis()));
	     bubbleSeries.getData().add(new XYChart.Data(200000, bubbleTwoHundredKTime.toMillis()));
	     bubbleSeries.getData().add(new XYChart.Data(250000, bubbleTwoHundredFiftyKTime.toMillis()));
	     bubbleSeries.getData().add(new XYChart.Data(300000, bubbleThreeHundredKTime.toMillis()));  
	     
	     XYChart.Series selectionSeries = new XYChart.Series();
	     selectionSeries.setName("Selection Sort");
	     selectionSeries.getData().add(new XYChart.Data(50000, selectionFiftyKTime.toMillis()));
	     selectionSeries.getData().add(new XYChart.Data(100000, selectionHundredKTime.toMillis()));
	     selectionSeries.getData().add(new XYChart.Data(150000, selectionHundredFiftyKTime.toMillis()));
	     selectionSeries.getData().add(new XYChart.Data(200000, selectionTwoHundredKTime.toMillis()));
	     selectionSeries.getData().add(new XYChart.Data(250000, selectionTwoHundredFiftyKTime.toMillis()));
	     selectionSeries.getData().add(new XYChart.Data(300000, selectionThreeHundredKTime.toMillis()));  
	     
	     XYChart.Series mergeSeries = new XYChart.Series();
	     mergeSeries.setName("Merge Sort");
	     mergeSeries.getData().add(new XYChart.Data(50000, mergeFiftyKTime.toMillis()));
	     mergeSeries.getData().add(new XYChart.Data(100000, mergeHundredKTime.toMillis()));
	     mergeSeries.getData().add(new XYChart.Data(150000, mergeHundredFiftyKTime.toMillis()));
	     mergeSeries.getData().add(new XYChart.Data(200000, mergeTwoHundredKTime.toMillis()));
	     mergeSeries.getData().add(new XYChart.Data(250000, mergeTwoHundredFiftyKTime.toMillis()));
	     mergeSeries.getData().add(new XYChart.Data(300000, mergeThreeHundredKTime.toMillis()));  
	     
	     XYChart.Series quickSeries = new XYChart.Series();
	     quickSeries.setName("Merge Sort");
	     quickSeries.getData().add(new XYChart.Data(50000, quickFiftyKTime.toMillis()));
	     quickSeries.getData().add(new XYChart.Data(100000, quickHundredKTime.toMillis()));
	     quickSeries.getData().add(new XYChart.Data(150000, quickHundredFiftyKTime.toMillis()));
	     quickSeries.getData().add(new XYChart.Data(200000, quickTwoHundredKTime.toMillis()));
	     quickSeries.getData().add(new XYChart.Data(250000, quickTwoHundredFiftyKTime.toMillis()));
	     quickSeries.getData().add(new XYChart.Data(300000, quickThreeHundredKTime.toMillis()));  
	     
	     XYChart.Series countingSeries = new XYChart.Series();
	     countingSeries.setName("Counting Sort");
	     countingSeries.getData().add(new XYChart.Data(50000, countingFiftyKTime.toMillis()));
	     countingSeries.getData().add(new XYChart.Data(100000, countingHundredKTime.toMillis()));
	     countingSeries.getData().add(new XYChart.Data(150000, countingHundredFiftyKTime.toMillis()));
	     countingSeries.getData().add(new XYChart.Data(200000, countingTwoHundredKTime.toMillis()));
	     countingSeries.getData().add(new XYChart.Data(250000, countingTwoHundredFiftyKTime.toMillis()));
	     countingSeries.getData().add(new XYChart.Data(300000, countingThreeHundredKTime.toMillis()));  
	     
	     XYChart.Series radixSeries = new XYChart.Series();
	     radixSeries.setName("Radix Sort");
	     radixSeries.getData().add(new XYChart.Data(50000, radixFiftyKTime.toMillis()));
	     radixSeries.getData().add(new XYChart.Data(100000, radixHundredKTime.toMillis()));
	     radixSeries.getData().add(new XYChart.Data(150000, radixHundredFiftyKTime.toMillis()));
	     radixSeries.getData().add(new XYChart.Data(200000, radixTwoHundredKTime.toMillis()));
	     radixSeries.getData().add(new XYChart.Data(250000, radixTwoHundredFiftyKTime.toMillis()));
	     radixSeries.getData().add(new XYChart.Data(300000, radixThreeHundredKTime.toMillis()));  
	     
		 Scene scene  = new Scene(lineChart,800,600);
	     lineChart.getData().addAll(insertionSeries,bubbleSeries,selectionSeries,mergeSeries,quickSeries,countingSeries,radixSeries);
	     stage.setScene(scene);
	     stage.show();
	}
	public static void main(String[] args) {
		launch(args);
  }
}
