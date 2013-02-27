package com.taobao.feidu.baseapi.random;

/**
 * User: feidu
 * Date: 13-2-27
 * Time: 下午5:09
 */
class Day {
    private int year, month, day;

    public Day(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return this.year;
    }

    public int getMonth() {
        return this.month;
    }

    public int getDay() {
        return this.day;
    }
}

