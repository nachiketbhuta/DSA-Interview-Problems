
public class IntegerToRoman {

	public static void main(String[] args) {
		String ones[] = { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };
		String tens[] = { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
		String hunds[] = { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
		String thous[] = { "", "M", "MM", "MMM" };

		int num = 1345;

		String ans = thous[num / 1000] + hunds[num % 1000 / 100] + tens[num % 100 / 10] + ones[num % 10];
		System.out.println(ans);
	}
}
