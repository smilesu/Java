package com.suu.test;

import com.suu.client.PayerRecptService;
import com.suu.client.PayerRecptServiceService;

public class PayerRecptTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PayerRecptService prs = new PayerRecptServiceService().getPayerRecptServicePort();
		String reqData = "<Input>"+
				 "<InputParameters>"+
				 " <P_REQUEST_DATA>"+
				  " <HEADERS>"+
				  " <HEADER>"+
				  "    <CASH_RECEIPT_ID>11</CASH_RECEIPT_ID>"+
				   "   <OPERATING_UNIT_CODE>101</OPERATING_UNIT_CODE>"+
				   "   <OPERATING_UNIT>101_嘉会医院</OPERATING_UNIT>"+
				    "  <TRANSACTION_DATE>20170605</TRANSACTION_DATE>"+
				    "  <CURRENCY_CODE>CNY</CURRENCY_CODE>"+
				    "  <RECEIPT_NUMBER>1003201706050004</RECEIPT_NUMBER>"+
				    "  <PAYER_CODE>PATIENT</PAYER_CODE>"+
				    "  <PAYER_NAME>患者</PAYER_NAME> "+
				   " </HEADER>"+
				  " </HEADERS>"+
				 " </P_REQUEST_DATA>"+
				" </InputParameters>"+
				"</Input>";
		String retVal = prs.returnValue(reqData) ;
		System.out.println(retVal);
	}

}
