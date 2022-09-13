package io.github.julianobrl.pl4japp.singletons;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class TestSingleton {
	private static TestSingleton instance;
	
	@Getter
	@Setter
	private List<String> data = new ArrayList<>(); 
	
	public static TestSingleton getIntance() {
		if(instance == null)
			instance = new TestSingleton();
		return instance;
	}

}
