package com.example.root.custominfo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.actuate.info.Info.Builder;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

@Component
public class CustomInfo implements InfoContributor {

	@Override
	public void contribute(Builder builder) {
		Map<String, Integer> map = new HashMap<>();
		map.put("active", 22);
		map.put("inactive", 13);
		builder.withDetail("users", map);
	}

}
