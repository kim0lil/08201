package aop.introduction;

import org.springframework.beans.factory.annotation.Autowired;

public class SimpleDbLog implements LogDatabase {

	@Override
	public void logDB(String dbName) {
		System.out.println("DB LOG : "+dbName);
	}

}
