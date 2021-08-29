package com.sonia.jpa.entities;

public class Notification {
	private int count;

   
    public Notification(int count) {
		super();
		this.count = count;
	}
	public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public void increment() {
        this.count++;
    }

}
