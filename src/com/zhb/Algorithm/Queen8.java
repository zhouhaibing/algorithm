package com.zhb.Algorithm;
//�е㸴��
public class Queen8 {

	int QUEEN_COUNT = 8; // �Ƕ��ٻʺ�
	static final int EMPTY = 0;
	int[][] count = new int[QUEEN_COUNT][QUEEN_COUNT];
	int[] QueenIndex = new int[QUEEN_COUNT];
	int resultCount = 0;
	long time = System.currentTimeMillis();

	public void putQueenIndex(int row) {
		for (int col = 0; col < QUEEN_COUNT; col++) {
			if (count[row][col] == EMPTY) {
				for (int iRow = row + 1; iRow < QUEEN_COUNT; iRow++) {
					count[iRow][col]++;
					if ((col - iRow + row) >= 0) {
						count[iRow][col - iRow + row]++;
					}
					if ((col + iRow - row) < QUEEN_COUNT) {
						count[iRow][col + iRow - row]++;
					}
				}
				QueenIndex[row] = col;
				if (row == QUEEN_COUNT - 1) {
					print(++resultCount);
				} else {
					putQueenIndex(row + 1);
				}
				for (int iRow = row + 1; iRow < QUEEN_COUNT; iRow++) {
					count[iRow][col]--;
					if ((col - iRow + row) >= 0) {
						count[iRow][col - iRow + row]--;
					}
					if ((col + iRow - row) < QUEEN_COUNT) {
						count[iRow][col + iRow - row]--;
					}
				}
			}
		}
		if (row == 0) {
			System.out.println(QUEEN_COUNT + "�ʺ��� " + resultCount + " ����\n"
					+ (System.currentTimeMillis() - time) + "����");
		}
	}

	public void print(int n) {
		System.out.println(QUEEN_COUNT + "�ʺ�ĵ� " + n + " ���⣺");
		for (int i = 0; i < QUEEN_COUNT; i++) {
			for (int j = 0; j < QUEEN_COUNT; j++) {
				System.out.print(QueenIndex[i] == j ? " * " : " - ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void main(String[] args) {
		new Queen8().putQueenIndex(0);
	}
}
