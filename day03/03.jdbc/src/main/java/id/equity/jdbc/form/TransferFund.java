package id.equity.jdbc.form;

import lombok.Data;

@Data
public class TransferFund {
	private Long fromId;
	private Long toId;
	private Double balance;
}
