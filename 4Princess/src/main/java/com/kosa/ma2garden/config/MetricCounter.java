package com.kosa.ma2garden.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;

@Component
public class MetricCounter {

	private final List<Counter> counter;

	public MetricCounter(MeterRegistry registry) {
		this.counter = new ArrayList<Counter>();
		counter.add(registry.counter("getAllAirplants"));
	}
	
	public void increment(String counterName) {
		for(Counter c: this.counter) {
			if(c.getId().getName().contentEquals(counterName))
				c.increment();
		}
	}

}
