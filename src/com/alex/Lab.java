package com.alex;



import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Lab {
    //Ex1
    //reading input data
    private static int[] readArray(){
        Scanner scan = new Scanner(System.in);
        int dimension = scan.nextInt();
        int[] data = new int[dimension];
        for(int i =0;i<dimension;i++){
            data[i]=scan.nextInt();
        }
        return data;
    }
    //number of paired items in array
    private static int numOfPaired(int[] array){
        int number=0;
        List<Integer> numbers = new ArrayList<Integer>();
        for(int i=0;i<array.length;i++){
            for(int j=i+1;j<array.length;j++){
                if(array[i]==array[j] && numbers.indexOf(array[i])<0)
                    numbers.add(array[i]);
            }
        }
        return numbers.size();
    }
    //sum of element that multiplied by 3
    private static int sumOfElMyltByThree(int[] array){
        int sum=0;
        for(int i=0;i<array.length;i++){
            if(array[i]%3==0)
                sum+=array[i];
        }
        return sum;
    }
    //difference between min and max element in array
    private static int diffMinMax(int[] array){
        return maxElement(array)-minElement(array);
    }
    //mean of array's elements
    private static float mean(int[] array){
        int sum=0;
        for(int i=0;i<array.length;i++){
            sum+=array[i];
        }
        return sum/array.length;
    }
    //sum of the largest and the smallest elements in array
    private static int sumLargAndSmall(int[] array){
        int max = maxElement(array);
        int min = minElement(array);
        int sum = 0;
        for(int i=0;i<array.length;i++){
            if(array[i]==max || array[i]==min)
                sum+=array[i];
        }
        return sum;
    }
    //max element by absolute value
    private static int maxAbs(int[] array){
        int zero=0;
        for(int i=0;i<array.length;i++){
            if(Math.abs(array[i])>zero){
                zero=array[i];
            }
        }
        return zero;
    }
    private static int minElement(int[]array){
        int min = array[0];
        for(int i = 0;i<array.length;i++){
            if(array[i]<min)
                min = array[i];
        }
        return min;
    }
    private static int maxElement(int[] array){
        int max = array[0];
        for(int i=0;i<array.length;i++){
            if(array[i]>max)
                max=array[i];
        }
        return max;
    }

    //Ex2
    //read matrix dimension
    private static  int readDimension(){
        return new Scanner(System.in).nextInt();
    }
    //generating of matrix
    private static int[][] genereteMatrix(int dimension){
        Random rand = new Random();
        int[][] result = new int[dimension][dimension];
        for(int i=0;i<dimension;i++){
            for(int j = 0;j<dimension;j++){
                result[i][j]= rand.nextInt(100000)-50000;
            }
        }
        return result;
    }
    //display matrix
    private static void showMatrix(int[][] matrix){
        for(int i=0;i<matrix.length;i++){
            for(int j =0;j<matrix[i].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.print('\n');
        }
    }
    //displayarray
    private static void showArray(int[] arr){
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    //sum of the elements located behind the first negative element
    private static int[] excersiceA(int[][] matrix){
        int[] sequence=new int[matrix.length];
        for(int i=0;i<matrix.length;i++){

            for(int j = 0;j<matrix[i].length;j++){
                if(matrix[i][j]<0){
                    sequence[i]=0;
                    for(int k=j+1;k<matrix[i].length;k++){
                        sequence[i]+=matrix[i][k];
                    }
                    break;
                }
                else if(j==matrix[i].length-1){
                    sequence[i]=100;
                }
            }
        }
        return sequence;
    }
    //sum of the elements preceding the last negative element
    private static int[] excersiceB(int[][] matrix){
        int[] sequence=new int[matrix.length];
        for(int i=0;i<matrix.length;i++){
            for(int j = matrix[i].length-1;j>=0;j--){
                if(matrix[i][j]<0){
                    sequence[i]=0;
                    for(int k=0;k<j;k++){
                        sequence[i]+=matrix[i][k];
                    }
                    break;
                }
                else if(j==matrix[i].length-1){
                    sequence[i]=100;
                }
            }
        }
        return sequence;
    }
    //number of lines all elements of which are zeros
    private static int excersiceC(int[][] matrix){
        int result=0;
        for(int i = 0;i<matrix.length;i++){
            int counter=0;
            for (int j = 0;j<matrix[i].length;j++){
                if(matrix[i][j]==0)
                    counter++;
            }
            if(counter==matrix.length)
                result++;
        }
        return result;
    }
    //number of lines the elements in each of them are the same.
    private static int excersiceD(int[][] matrix){
        int result=0;
        for(int i = 0;i<matrix.length;i++){
            int counter=0;
            for (int j = 0;j<matrix[i].length;j++){
                if(matrix[i][j]==matrix[i][0])
                    counter++;
            }
            if(counter==matrix.length)
                result++;
        }
        return result;
    }


    public static void main(String[] args) {

        //Ex 1
        int[] dataArray=readArray();
        System.out.println(numOfPaired(dataArray));
        System.out.println(maxAbs(dataArray));
        System.out.println(mean(dataArray));
        System.out.println(sumOfElMyltByThree(dataArray));
        System.out.println(diffMinMax(dataArray));
        System.out.println(sumLargAndSmall(dataArray));
        //Ex2
        int n = readDimension();
        int[][] matrix = genereteMatrix(n);
        showMatrix(matrix);
        showArray(excersiceA(matrix));
        showArray(excersiceB(matrix));
        System.out.println(excersiceC(matrix));
        System.out.println(excersiceD(matrix));
    }
}
