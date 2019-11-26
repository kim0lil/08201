package aop.introduction;

public class SimpleTransactionLog implements LogTransaction {

	@Override
	public void logTx(String txName) {
		System.out.println("TX LOG : "+txName);
	}
}
