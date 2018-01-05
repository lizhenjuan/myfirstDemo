package TestStream;

/**
 * 分布式事务
 */

public class Transaction {

	 private  final  Trader trader;
	private  final  int year;
	private  final  int value;

	public Trader getTrader() {
		return trader;
	}

	public int getYear() {
		return year;
	}

	public int getValue() {
		return value;
	}



	 public  Transaction(Trader trader,int year,int value){
       this.trader=trader;
       this.year=year;
       this.value=value;
	 }

	  //重写String字符串
	 public String toString(){
	 	return "{"+ this.trader+","+
			   "year:"+this.year+","+
			    "value:"+this.value+"}";
	 }


}
