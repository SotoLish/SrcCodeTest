package org.soto.app;

import java.util.*;

/**
 * 双色球
 */
public class DoubleColorBall {

    /**
     * 由6个红色球号码和1个蓝色球号码组成。
     * 红色球号码从1--33中选择；蓝色球号码从1--16中选择
     *
     * @param args
     */
    public static void main(String[] args) {
        Set<String> redBalls = new HashSet<String>() {{
            for (int i = 1; i <= 33; i++) {
                String numStr = Objects.toString(i);
                add(numStr.length() < 2 ? "0" + numStr : numStr);
            }
        }};
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
        System.out.println(result);
    }

    /**
     * 移除数组元素
     * @param objArr 源数组
     * @param index 移除元素
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
