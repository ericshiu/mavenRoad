package maven06.service;

import java.util.Map;

import org.springframework.stereotype.Service;

@Service("service3")
public class service3 {

	public String test3(Map<String, Object> allServiceNeededParams) {
		return "test3";
	}
}
