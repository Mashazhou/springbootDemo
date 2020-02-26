package com.example.springboot.sort;

import java.util.Arrays;

/**
 * @Description : desc
 * @Author masz
 * @Date 2019/9/2 16:12
 */
public class Sort {
    public static void main(String[] args) {
        Sort b = new Sort();
//        b.bubbleSort1();//冒泡排序
//        b.bubbleSort2();
//        b.SelectionSort();//选择排序
//        b.InsertionSort();//插入排序
        b.ShellSort();//希尔排序

    }


    public void bubbleSort1() {
        int[] arr = { 3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48 };
        // 统计比较次数
        int count = 0;
        // 第一轮比较
        for (int i = 0; i < arr.length - 1; i++) {
            // 第二轮比较
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // 交换位置
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
                count++;
            }
            System.out.println(" i = " + i);
        }

        System.out.println(Arrays.toString(arr));
        System.out.println("一共比较了:" + count + "次");
    }

    public void bubbleSort2() {
        int[] arr = { 3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48 };
        // 统计比较次数
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // 交换位置
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = false;
                }
                count++;
            }
            System.out.println(" i = " + i);
            if(flag) {
                System.out.println("此时 i = " + i + ", 值 = " + arr[i]);
                break;
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.println("一共比较了:" + count + "次");
    }


    public void SelectionSort() {
        int[] arr = { 3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48 };
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;
            for (int j = 1 + i; j < arr.length; j++) {
                if (arr[j] < arr[index]) {
                    index = j;// 保存最小元素的下标
                }
                count++;
            }
            // 此时已经找到最小元素的下标
            // 将最小元素与前面的元素交换
            int temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
        }
        System.out.println(Arrays.toString(arr));
        System.out.println("一共比较了:" + count + "次");

    }

    public void InsertionSort() {
        int[] arr = { 3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48 };
        int count = 0;
        for (int i = 1; i < arr.length; i++) {
            // 定义待插入的数
            int insertValue = arr[i];
            // 找到待插入数的前一个数的下标
            int insertIndex = i - 1;
            while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
                count++;
            }
            arr[insertIndex + 1] = insertValue;
        }
        System.out.println(Arrays.toString(arr));
        System.out.println("插入排序>>>一共比较了:" + count + "次");

    }


    public void ShellSort() {
        int[] arr = { 3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48 };
        int count = 0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {

            // 对数组元素进行分组
            for (int i = gap; i < arr.length; i++) {
                // 遍历各组中的元素
                for (int j = i - gap; j >= 0; j -= gap) {
                    // 交换元素
                    if (arr[j] > arr[j + gap]) {
                        int temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                        System.out.print(Arrays.toString(arr));
                        System.out.println(" 交换的值 " + arr[j + gap] + " - " + arr[j]);
                    }else{
                        System.out.print(Arrays.toString(arr));
                        System.out.println("未交换");
                    }
                    count++;
                }
            }
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>重-新-分-组<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        }

        System.out.println(Arrays.toString(arr));
        System.out.println("希尔排序>>>一共比较了:" + count + "次");
    }

}
