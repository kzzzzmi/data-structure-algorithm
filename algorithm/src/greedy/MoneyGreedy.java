package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MoneyGreedy {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> coinList = new ArrayList<Integer>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int price = Integer.parseInt(st.nextToken());
		int coinNum = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < coinNum; i++) {
			coinList.add(Integer.parseInt(st.nextToken()));
		}

		MoneyGreedy greedy = new MoneyGreedy();

		System.out.println(greedy.coinFunc(price, coinList));

	}

	public int coinFunc(int price, ArrayList<Integer> coinList) {
		int totalCount = 0;
		int coinCount = 0 ;
		for(int i = 0; i < coinList.size(); i++) {
			int currCoinPrice = coinList.get(coinList.size() - i - 1);
			coinCount = price / currCoinPrice;
			System.out.println(currCoinPrice + "원 동전의 갯수 : " + coinCount);
			price %= currCoinPrice;
			totalCount += coinCount;
		}
		return totalCount;
	}

}
