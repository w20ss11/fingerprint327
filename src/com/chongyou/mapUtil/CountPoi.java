package com.chongyou.mapUtil;

import java.util.List;


public class CountPoi {
	private double[] poi=new double[2];
	private double[] sum=new double[328];//363���ο����ÿ���Ĳ�ֵ
	private double[] sum2=new double[328];
	private double m;//һ���ο����ֵ  ÿ����ֵ��5��ap���ܺ�
	
	
	public double[] count(List<WifiAPInfo> wifiAPInfoList2,WifiAPInfo wifiAPInfo_unknow){
//		��һ�� ��� wifiAPInfoList2 wifiAPInfo_unknow�������ݿ�ʹ����wifi
//		System.out.println("wifiAPInfoList2:"+wifiAPInfoList2.toString());
		System.out.println("wifiAPInfo_unknow:"+wifiAPInfo_unknow);
		
		sum[0]=0;
		sum2[0]=0;
		//�ж�wifiAPInfo_unknow�⵽��5��ap������0 os
		if(wifiAPInfo_unknow.getAP1()!=0
				&&wifiAPInfo_unknow.getAP2()!=0
				&&wifiAPInfo_unknow.getAP3()!=0
				&&wifiAPInfo_unknow.getAP4()!=0
				&&wifiAPInfo_unknow.getAP5()!=0){
			for(int i=0;i<wifiAPInfoList2.size();i++){
				WifiAPInfo info=wifiAPInfoList2.get(i);
				m=Math.pow((info.getAP1()-wifiAPInfo_unknow.getAP1()),2)+
						+Math.pow((info.getAP2()-wifiAPInfo_unknow.getAP2()),2)
						+Math.pow((info.getAP3()-wifiAPInfo_unknow.getAP3()),2)
						+Math.pow((info.getAP4()-wifiAPInfo_unknow.getAP4()),2)
						+Math.pow((info.getAP5()-wifiAPInfo_unknow.getAP5()),2);
	//			�ڶ��������363���ο���ʹ������ź�ƽ����ֵ
	//			System.out.println("�м�363���ο���ʹ������ź�ƽ����ֵ��"+m);
				sum[i+1]=Math.sqrt(m);
			}
		}else{
			oneApIs0(wifiAPInfoList2, wifiAPInfo_unknow);
		}
		
		for(int i=0;i<sum.length;i++)
			sum2[i]=sum[i];
		paixu(sum);
		double xSum=0;
		double ySum=0;
		//��Ȩ
		double w=0;
		for(int i=1;i<=4;i++){
			w=1.0/sum[i]+w;
			System.out.println("1/sum[i]:"+1/sum[i]);
		}
		System.out.println("Ȩ�صĺ���"+w);
		for(int i=1;i<=4;i++){
			for(int j=0;j<sum.length;j++){
				if(sum[i]==sum2[j]){
					xSum=xSum+1.0/sum[i]/w*(wifiAPInfoList2.get(j).getX());
					ySum=ySum+1.0/sum[i]/w*(wifiAPInfoList2.get(j).getY());
//					���Ĳ� ����ĸ����� ���Բ鿴���ݿ�  ��j��Ӧ���ݿ���ĸ��ο����ź�ʮ�ֺ�wifi�ɼ����������ź�����
					System.out.println("���ڽ���4������"+i+"_______________:"+j);
				}
			}
		}
		System.out.println("xSum:"+xSum);
		poi[0]=xSum;
		poi[1]=ySum;
		
		
//		�����������sum2 �ټ��sum�ֱ���δ����������Ͳο����ֵ�ļ���
//		for(double n:sum2){
//			System.out.println("��ʼ�ˣ�+++++++++"+n+",");
//		}
		return poi;
	}

	
	private double[] paixu(double[] array) {
		for(int x=0;x<array.length-1;x++){
			for(int y=x+1;y<array.length;y++){
				if(array[x]>array[y]){
					double temp=array[x];//  ��ʱ������¼���ֵ
					array[x]=array[y];
					array[y]=temp;
				}
			}
		}
		return array;
	}

	private void oneApIs0(List<WifiAPInfo> wifiAPInfoList2,
			WifiAPInfo wifiAPInfo_unknow) {
		if(wifiAPInfo_unknow.getAP1()==0){
			for(int i=0;i<wifiAPInfoList2.size();i++){
				WifiAPInfo info=wifiAPInfoList2.get(i);
				m=+Math.pow((info.getAP2()-wifiAPInfo_unknow.getAP2()),2)
						+Math.pow((info.getAP3()-wifiAPInfo_unknow.getAP3()),2)
						+Math.pow((info.getAP4()-wifiAPInfo_unknow.getAP4()),2)
						+Math.pow((info.getAP5()-wifiAPInfo_unknow.getAP5()),2);
//			�ڶ��������363���ο���ʹ������ź�ƽ����ֵ
//			System.out.println("�м�363���ο���ʹ������ź�ƽ����ֵ��"+m);
				sum[i+1]=Math.sqrt(m);
			}
		}
		else if(wifiAPInfo_unknow.getAP2()==0){
			for(int i=0;i<wifiAPInfoList2.size();i++){
				WifiAPInfo info=wifiAPInfoList2.get(i);
				m=Math.pow((info.getAP1()-wifiAPInfo_unknow.getAP1()),2)+
						+Math.pow((info.getAP3()-wifiAPInfo_unknow.getAP3()),2)
						+Math.pow((info.getAP4()-wifiAPInfo_unknow.getAP4()),2)
						+Math.pow((info.getAP5()-wifiAPInfo_unknow.getAP5()),2);
//			�ڶ��������363���ο���ʹ������ź�ƽ����ֵ
//			System.out.println("�м�363���ο���ʹ������ź�ƽ����ֵ��"+m);
				sum[i+1]=Math.sqrt(m);
			}
		}
		else if(wifiAPInfo_unknow.getAP3()==0){
			for(int i=0;i<wifiAPInfoList2.size();i++){
				WifiAPInfo info=wifiAPInfoList2.get(i);
				m=Math.pow((info.getAP1()-wifiAPInfo_unknow.getAP1()),2)+
						+Math.pow((info.getAP2()-wifiAPInfo_unknow.getAP2()),2)
						+Math.pow((info.getAP4()-wifiAPInfo_unknow.getAP4()),2)
						+Math.pow((info.getAP5()-wifiAPInfo_unknow.getAP5()),2);
//			�ڶ��������363���ο���ʹ������ź�ƽ����ֵ
//			System.out.println("�м�363���ο���ʹ������ź�ƽ����ֵ��"+m);
				sum[i+1]=Math.sqrt(m);
			}
		}
		else if(wifiAPInfo_unknow.getAP4()==0){
			for(int i=0;i<wifiAPInfoList2.size();i++){
				WifiAPInfo info=wifiAPInfoList2.get(i);
				m=Math.pow((info.getAP1()-wifiAPInfo_unknow.getAP1()),2)+
						+Math.pow((info.getAP2()-wifiAPInfo_unknow.getAP2()),2)
						+Math.pow((info.getAP3()-wifiAPInfo_unknow.getAP3()),2)
						+Math.pow((info.getAP5()-wifiAPInfo_unknow.getAP5()),2);
//			�ڶ��������363���ο���ʹ������ź�ƽ����ֵ
//			System.out.println("�м�363���ο���ʹ������ź�ƽ����ֵ��"+m);
				sum[i+1]=Math.sqrt(m);
			}
		}
		else if(wifiAPInfo_unknow.getAP5()==0){
			for(int i=0;i<wifiAPInfoList2.size();i++){
				WifiAPInfo info=wifiAPInfoList2.get(i);
				m=Math.pow((info.getAP1()-wifiAPInfo_unknow.getAP1()),2)+
						+Math.pow((info.getAP2()-wifiAPInfo_unknow.getAP2()),2)
						+Math.pow((info.getAP3()-wifiAPInfo_unknow.getAP3()),2)
						+Math.pow((info.getAP4()-wifiAPInfo_unknow.getAP4()),2);
//			�ڶ��������363���ο���ʹ������ź�ƽ����ֵ
//			System.out.println("�м�363���ο���ʹ������ź�ƽ����ֵ��"+m);
				sum[i+1]=Math.sqrt(m);
			}
		}
	}

}
