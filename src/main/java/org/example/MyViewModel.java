package org.example;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;

public class MyViewModel {

	private int count;

	private String msg;

	@Init
	public void init() {
		count = 100;
		msg = "Hello World";
	}

	@Command
	@NotifyChange("count")
	public void cmd() {
		++count;
	}

	public int getCount() {
		return count;
	}

	public String getMsg() {
		return msg;
	}
}
