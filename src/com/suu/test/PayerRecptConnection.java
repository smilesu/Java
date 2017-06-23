package com.suu.test;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
public class PayerRecptConnection {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		URL url = new URL("http://localhost:9099/procPayorPayment");
		
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		
		conn.setDoInput(true);
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type",  "text/xml");  
		OutputStream os = conn.getOutputStream();
		
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
		String soaData = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ser=\"http://server.suu.com/\">"
				+"<soapenv:Header/> <soapenv:Body><ser:returnValue><arg0>"+ reqData +"</arg0></ser:returnValue></soapenv:Body></soapenv:Envelope>";
		os.write(soaData.getBytes());
		InputStream is = conn.getInputStream();
		byte[] b =new byte[1024];
		int len=0;
		String s ="";
		while((len =is.read(b))!=-1){
			String ss = new String(b,0,len,"UTF-8");
			s +=ss;
		}
		System.out.println(s);
		is.close();
		os.close();
		conn.disconnect();
	}

}
