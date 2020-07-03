package club.banyuan.July2.Homework.Time;

import java.util.ArrayList;
import java.util.List;

/**
 * 比较在基于数组的列表和基于链表的列表的末尾增加n个值所需的时间
 * <p>
 * 1.创建一个计时器。
 * <p>
 * 2.计算将n个值添加到空链表的时间：
 * a.创建一个空的链表
 * b.启动计时器
 * c.依次将0..n-1中的每个值i添加到list中
 * d.停止计时器
 * e.显示时间
 * <p>
 * 3.计算将n个值添加到空数组列表的时间：
 * a.创建一个空的数组列表
 * b.启动计时器
 * c.依次将0..n-1中的每个值i添加到list中
 * d.停止计时器
 * e.显示时间
 */
public class Append implements Timer {
    private static long timeStart;
    private long timeEnd;

    public static void main(String args[]) {
        Append time = new Append();
        List<Integer>list=new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            if(i==0){
                time.start();
                list.add(i);
            }
        }time.stop();
        System.out.println(timeStart);
        System.out.println(time.timeEnd);
        System.out.println(time.getTimeMillisecond());
    }

    @Override
    public void start() throws IllegalStateException {
        if (timeEnd != 0) {
            throw new IllegalStateException("开始计时后没有停止计时");
        }
        timeStart = System.currentTimeMillis();
    }

    @Override
    public void stop() throws IllegalStateException {
        if (timeStart == 0) {
            throw new IllegalStateException("计时未开始，无法停止");
        }
        timeEnd = System.currentTimeMillis();
    }

    @Override
    public void reset() {
        timeStart = 0;
        timeEnd = 0;
    }

    @Override
    public long getTimeMillisecond() {
        return timeEnd - timeStart;
    }
}

