package com.xu.module.jianshu.ui.handler;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


/**
 * 自定义消息队列
 *
 * @author xu
 */
public class MessageQueue {

    /**
     * 阻塞队列
     */
    private BlockingQueue<Message> blockingQueue;
    /**
     * 队列里面最大的数量
     */
    private static final int MAX_COUNT = 10;


    public MessageQueue() {
        blockingQueue = new ArrayBlockingQueue<>(MAX_COUNT);
    }



    public void enqueueMessage(Message msg) {
        try {
            blockingQueue.put(msg);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    public Message next() {
        Message msg = null;
        try {
            msg = blockingQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return msg;
    }

}
