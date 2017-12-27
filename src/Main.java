
//import java.util.Scanner;
////import java.util.*;
//import java.lang.Math;
//
//public class Main {
//	static int map[][]; // map size
//	static int k; // 최대로 오래 살 날 임시변수
//	static int N;
//	static int dx[] = { 0, 1, 0, -1 };
//	static int dy[] = { -1, 0, 1, 0 };
//	static int x, y;
//	static int dix, diy;
//	static int day;// 생존 날짜 
//
//
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		N = sc.nextInt();
//		map = new int[N][N];
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				map[i][j] = sc.nextInt();
//			}
//		} // map에 대한 구조 받기
//		for (int i = 0; i < N; i++) { // map에 대해 전체 좌표 다 받아서 돌려보기
//			for (int j = 0; j < N; j++) {
//				k = 0; // 변수 값 초기화
//				solve(i, j); // 메소드 실현
//				day = Math.max(day, k); // 최대값 구하기
//			}
//		}
//		// solve(0, 0); // 0,0 좌표부터 받아보기
//		System.out.println(day);
//	}
//
//	static void solve(int x, int y) {
//		k++; // 일단 시작하니까 1증가시켜주고.
//		// System.out.println(k);
//		// k = Math.max(1,k);
////		System.out.println(k);
//		for (int ii = 0; ii < 4; ii++) {
//			dix = x + dx[ii];
//			diy = y + dy[ii];
//			if (dix >= 0 && diy >= 0 && dix < N && diy < N && map[dix][diy] > map[x][y]) {
//				// System.out.println(map[dix][diy]);
//				solve(dix, diy);
//			}
//		}
//	}
//
//}

import java.util.Scanner;
//import java.util.*;
import java.lang.Math;

public class Main {
	static int map[][]; // map size
	static int visit[][];
	static int k; // 최대로 오래 살 날 임시변수
	static int N;
	static int dx[] = { 0, -1, 0, 1 };
	static int dy[] = { -1, 0, 1, 0 };
	static int x, y;
	static int dix, diy;
	static int day;// 생존 날짜

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		visit = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		} // map에 대한 구조 받기

		for (int i = 0; i < N; i++) { // map에 대해 전체 좌표 다 받아서 돌려보기
			for (int j = 0; j < N; j++) {
				day = Math.max(day, solve(i, j));
			}
		}
		// solve(0, 0); // 0,0 좌표부터 받아보기
		System.out.println(day);
	}

	static int solve(int x, int y) {
		if (visit[x][y] > 0) {
			return visit[x][y];
		}
		visit[x][y] = 1;

		for (int ii = 0; ii < 4; ii++) {
			dix = x + dx[ii];
			diy = y + dy[ii];
			if (dix >= 0 && diy >= 0 && dix < N && diy < N) {
				if (map[dix][diy] > map[x][y])
					// System.out.println(map[dix][diy]);
					visit[x][y] = Math.max(visit[x][y], solve(dix, diy) + 1);

			}
		}
		return visit[x][y];
	}

}