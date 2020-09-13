package com.ivan.recursion;

/**
 * 使用递归模拟迷宫，前后左右顺序决定路线
 * 1111111
 * 1000001
 * 1000001
 * 1110001
 * 1000001
 * 1000001
 * 1000001
 * 1111111
 * ---------------------------------------
 * 1111111   //这里结果不是确定的
 * 1222221
 * 1000021
 * 1110021
 * 1000021
 * 1000021
 * 1000021
 * 1111111
 */

public class LabyrinthRecursion {
    //创建二维数组模拟迷宫


    public static void main(String[] args) {
        LabyrinthRecursion labyrinthRecursion = new LabyrinthRecursion();
        int[][] ints = labyrinthRecursion.setMap();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(ints[i][j]);
            }
            System.out.println();
        }
        labyrinthRecursion.getWay(ints, 1, 1);
        System.out.println("---------------------------------------");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(ints[i][j]);
            }
            System.out.println();
        }

    }

    /**
     * 建墙 上下左右制作1
     * 制作迷宫
     */
    public int[][] setMap() {
        int[][] map = new int[8][7];
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;
        return map;
    }

    /**
     * 结合栈帧容易理解
     *先向那个方向走，决定的路线不通。
     * 就是先模拟一条路，看这条路是否满足结果，怎么看是否满足结果，从终点开始向后退，
     * 如果能退回到起点就没问题。
     * @param map
     * @param i
     * @param j
     * @return
     */
    public boolean getWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            return true; //这里的return 是返回给当前方法结束，也就是栈空了
        } else {
            if (map[i][j] == 0) {
                map[i][j] = 2;
                if (getWay(map, i, j + 1)) {
                    return true; //这里返回给调用他的上一个栈帧 map[i][j] 这里的i 和j 不是初始进来的i j时候调用的
                } else if (getWay(map, i + 1, j)) {
                    return true;
                } else if (getWay(map, i, j - 1)) {
                    return true;
                } else if (getWay(map, i - 1, j)) {
                    return true;
                } else {
                    map[i][j] = 3;//走不通
                    return false;
                }
            } else {
                return false;
            }
        }
    }

}
