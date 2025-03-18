package com.liubz.androidtea.cherish.concurrent.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class RRWLCacheDataManager {


    public static void main(String[] args) {
        CacheData cacheData = new CacheData();
        cacheData.processCachedData();
    }

    public static class CacheData {
        private final ReentrantReadWriteLock rrwl = new ReentrantReadWriteLock();

        private Object data;
        private boolean cacheValid = false;

        public void processCachedData() {
            rrwl.readLock().lock();
            if (!cacheValid) {
                rrwl.readLock().unlock();
                rrwl.writeLock().lock();
                try {
                    if (!cacheValid) {
                        data = loadData();
                        cacheValid = true;
                    }
                    rrwl.readLock().lock();
                } finally {
                    rrwl.writeLock().unlock();
                }
            }
            try {
                consumeData(data);
            } finally {
                rrwl.readLock().unlock();
            }
        }

        private Object loadData() {
            return new Object();
        }

        private void consumeData(Object data) {
            System.out.println("consume data: " + data);
        }
    }
}
