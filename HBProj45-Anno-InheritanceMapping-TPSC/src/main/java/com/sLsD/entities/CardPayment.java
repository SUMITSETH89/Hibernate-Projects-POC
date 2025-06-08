package com.sLsD.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Entity
@PrimaryKeyJoinColumn(name = "PAYMENT_ID",referencedColumnName = "TX_ID")
@DynamicInsert
@DynamicUpdate
public class CardPayment extends Payment {
	
	@Column(name="CARD_NO")
	private Long cardNo;
	@Column(name="CARD_TYPE",length=10)
	private String cardType;
	@Column(name="ISSUER",length = 10)
	private String gateway;
	
	public CardPayment() {
		System.out.println("No Args Constructor:: CardPayment");
	}
	
	public String toString() {
		return String.format("CardNo:: %d,CardType:: %s,Gateway:: %s,Super:: %s",cardNo,cardType,gateway,super.toString());
	}
	
	

}
