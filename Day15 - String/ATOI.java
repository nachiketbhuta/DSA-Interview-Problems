
public class ATOI {

	public static void main(String[] args) {

		String str = "32a4a";
		int n = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
				n++;
			}
		}

		int power = (int) Math.pow(10, n - 1);

		int ans = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
				int num = str.charAt(i) - '0';
				ans += num * power;
				power /= 10;
			}
		}

		System.out.println(ans);
	}
}
