package com.zhb.basic;

/**
 * 
 * @author Administrator
 * ����ѡ����  ����ʵ��
 * ˼·��
 * �������ʾ�����Ƿ���λ��״̬ 1,0
 * ��ͷ��ʼ�����ñ�������¼�������٣�����kʱ��Ǻ���״̬Ϊ0,p=p%sum��ʾѭ������
 * ���ֱ��ʣ��һ������Ϊֹ���˳�ѭ����
 */
public class SelectKing_Array {
	public static int sum = 10;
	public static int num = 3;
	public static void main(String[] args){
		int[] monkeys = new int[sum];
		for(int i=1;i <=sum;i++){
			monkeys[i-1]=1;//���еĺ��Ӷ���λ
		}
		int p = 0;//�±�
		int m = 0;//����������һ�μ�һ
		int n = sum;//��λ�ĺ���
		while(n > 1){//ֻ��һ�����ӵ�ʱ���˳�ѭ��
			while(m < num){//��������num��ʾ�˳�Ȧ��
				if(monkeys[p] == 1){
					m++;
					if(m == num){
						monkeys[p] = 0;//�˳�Ȧ��
					}
				}
				p++;
				p=p%sum;////��һ����Ϊ�˽��ѭ������ɻ�������Ŀ��
			}
			m = 0;//����������
			n--;//������Ӽ�һ
		}
		int kingNum = 0;
		for(int i = 1;i <= sum; i++){
			if(monkeys[i - 1] == 1){
				kingNum = i;
			}
		}
		System.out.println("the king is :" + kingNum);
	}

}
