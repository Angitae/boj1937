
//import java.util.Scanner;
////import java.util.*;
//import java.lang.Math;
//
//public class Main {
//	static int map[][]; // map size
//	static int k; // �ִ�� ���� �� �� �ӽú���
//	static int N;
//	static int dx[] = { 0, 1, 0, -1 };
//	static int dy[] = { -1, 0, 1, 0 };
//	static int x, y;
//	static int dix, diy;
//	static int day;// ���� ��¥ 
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
//		} // map�� ���� ���� �ޱ�
//		for (int i = 0; i < N; i++) { // map�� ���� ��ü ��ǥ �� �޾Ƽ� ��������
//			for (int j = 0; j < N; j++) {
//				k = 0; // ���� �� �ʱ�ȭ
//				solve(i, j); // �޼ҵ� ����
//				day = Math.max(day, k); // �ִ밪 ���ϱ�
//			}
//		}
//		// solve(0, 0); // 0,0 ��ǥ���� �޾ƺ���
//		System.out.println(day);
//	}
//
//	static void solve(int x, int y) {
//		k++; // �ϴ� �����ϴϱ� 1���������ְ�.
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
	static int k; // �ִ�� ���� �� �� �ӽú���
	static int N;
	static int dx[] = { 0, -1, 0, 1 };
	static int dy[] = { -1, 0, 1, 0 };
	static int x, y;
	static int dix, diy;
	static int day;// ���� ��¥

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		visit = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		} // map�� ���� ���� �ޱ�

		for (int i = 0; i < N; i++) { // map�� ���� ��ü ��ǥ �� �޾Ƽ� ��������
			for (int j = 0; j < N; j++) {
				day = Math.max(day, solve(i, j));
			}
		}
		// solve(0, 0); // 0,0 ��ǥ���� �޾ƺ���
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