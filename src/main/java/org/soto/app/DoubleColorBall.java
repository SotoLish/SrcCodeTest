package org.soto.app;

import java.util.*;

/**
 * 双色球，随机选号程序
 */
public class DoubleColorBall {

    /**
     * @param args
     */
    public static void main(String[] args) {

        // 选号
        // randomPick();
        // 开奖
        runLottery();


    }

    public static void runLottery() {
        String exitWord = "exit";
        String space = " ";
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入本期中奖号码（号码中间用空格隔开）：");
        String input = scanner.nextLine();
        // 中奖结果
        String[] result = input.split(space);
        List<String[]> picks = new ArrayList<>();

        System.out.println("请输入本期自选号（号码中间用空格隔开），结束输入exit：");
        while (true) {

            input = scanner.nextLine();
            if (input.equalsIgnoreCase(exitWord)) {
                break;
            }
            String[] inputPick = input.split(space);
            picks.add(inputPick);
        }
        System.out.println("-----------------------------------------");
        System.out.println("--------------  开奖啦  ------------------");
        System.out.println("-----------------------------------------");
        for (String[] pickArr:picks) {
            printStrArr(pickArr);
            String resStr = getWinResult(result,pickArr);
            System.out.println(resStr);
        }


    }

    /**
     * 打印队列
     * @param arr
     */
    public static void printStrArr(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    /**
     * 获奖结果
     */
    public static final String[] winResult = {"未中奖", "一等奖", "二等奖", "三等奖", "四等奖", "五等奖", "六等奖"};

    /**
     * 开奖
     * 双色球由前区6个红球（在1-33个编号中任意选择6个），后区1个蓝色球（1-16个编号中任意选择1个）组合成一注。
     * 只要中几个号码（号码顺序不限），就可以得到对应奖级的奖金。
     * 一等奖：六红一蓝
     * 二等奖：六红
     * 三等奖：五红一蓝
     * 四等奖：五红/四红一蓝（中五颗）
     * 五等奖：四红/三红一蓝（中四颗）
     * 六等奖：二红一篮/一红一蓝/一篮（有蓝就行）
     *
     * @param res  开奖结果
     * @param pick 选号结果
     */
    public static String getWinResult(String[] res, String[] pick) {
        int redIn = 0;
        int blueIn = 0;
        // 默认两个数组长度相等
        for (int i = 0; i < 7; i++) {
            if (res[i].equals(pick[i])) {
                if (i != 6) {
                    redIn++;
                } else {
                    blueIn++;
                }
            }
        }
        if (redIn == 6 && blueIn == 1) {
            return winResult[1];
        } else if (redIn == 6 && blueIn == 0) {
            return winResult[2];
        } else if (redIn == 5 && blueIn == 1) {
            return winResult[3];
        } else if (redIn + blueIn == 5) {
            return winResult[4];
        } else if (redIn + blueIn == 4) {
            return winResult[5];
        } else if (blueIn == 1) {
            return winResult[6];
        }
        return winResult[0];
    }


    /**
     * 随机选号
     * 由6个红色球号码和1个蓝色球号码组成。
     * 红色球号码从1--33中选择；蓝色球号码从1--16中选择
     *
     * @return
     */
    public static List<String> randomPick() {
        // 红球池
        Set<String> redBalls = new HashSet<String>() {{
            for (int i = 1; i <= 33; i++) {
                String numStr = Objects.toString(i);
                add(numStr.length() < 2 ? "0" + numStr : numStr);
            }
        }};
        // 篮球池
        Set<String> blueBalls = new HashSet<String>() {{
            for (int i = 1; i <= 16; i++) {
                String numStr = Objects.toString(i);
                add(numStr.length() < 2 ? "0" + numStr : numStr);
            }
        }};
        // 开奖结果
        List<String> result = new ArrayList<>(7);
        Object[] objRedArr = redBalls.toArray();
        // 红球数量
        int redballNum = 6;
        // 抽红色球
        while (redballNum > 0) {
            int randomIndex = (int) (Math.random() * objRedArr.length);
            result.add(Objects.toString(objRedArr[randomIndex]));
            objRedArr = removeArrItem(objRedArr, randomIndex);
            redballNum--;
        }
        // 抽蓝色球
        Object[] objBuleArr = blueBalls.toArray();
        int blueRandomIndex = (int) (Math.random() / objBuleArr.length);
        result.add(Objects.toString(objBuleArr[blueRandomIndex]));
        return result;
    }

    /**
     * 移除数组元素
     *
     * @param objArr 源数组
     * @param index  移除元素
     * @return
     */
    public static Object[] removeArrItem(Object[] objArr, int index) {
        int size = objArr.length;
        int numMoved = size - index - 1;
        Object[] desc = Arrays.copyOf(objArr, size - 1);
        // 将源数组的后部分复制到新数组的后部分
        System.arraycopy(objArr, index + 1, desc, index, numMoved);
        return desc;
    }
}
