package com.kz.examination.dao;

import java.lang.reflect.Field;
import java.util.List;

import com.kz.examination.entity.QueryView;
import com.kz.examination.entity.TBL_FWXX;
import com.kz.examination.entity.TBL_JD;
import com.kz.examination.entity.TBL_QX;
import com.kz.examination.utils.Returns;

public class TBL_FWXXDao {
	private static boolean IsNotNull(String str){
		if(str!=null&&str.trim().length()>0){
			return true;
		}else{
			return false;
		}
	}
	public static int advancedListCount(QueryView qv,Object obj,int pageSize){
		Class class1 = obj.getClass();
		Field[] fields = class1.getDeclaredFields();
		Field.setAccessible(fields, true);
		StringBuffer sql=new StringBuffer("select count(*) from (select rownum RN,t.* from "+class1.getSimpleName()+" t where 1=1");
		//����
		if(IsNotNull(qv.getTitle())){
			sql.append(" and title like '%"+qv.getTitle()+"%' ");
		}
		
			//�ֵ�
		if( IsNotNull(qv.getJieDao())&&!qv.getJieDao().equals("-1")){
			sql.append(" and jdid="+qv.getJieDao());
		}else{
			//��
			if(IsNotNull(qv.getQu())&&!qv.getQu().equals("-1")){
				List<TBL_JD> listQXid = TBL_JDDao.listQXid(Integer.parseInt(qv.getQu()));
				sql.append(" and JDID = "+listQXid.get(0).getJdid());
				for (int i = 1; i <listQXid.size(); i++) {
					sql.append(" or JDID = "+listQXid.get(i).getJdid());
				}
			}
		}
		//��ʼ���
		if(qv.getZhujingStare()!=null){
			sql.append(" and zj>"+qv.getZhujingStare());
		}
		//�������
		if(qv.getZhujingEnd()!=null){
			sql.append(" and zj<"+qv.getZhujingEnd());
		}
		//��
		if(qv.getShi()!=null&&qv.getShi()!=-1){
			sql.append(" and shi="+qv.getShi());
		}
		//��
		if(qv.getTing()!=null&&qv.getTing()!=-1){
			sql.append(" and ting="+qv.getTing());
		}
		//��������
		if(IsNotNull(qv.getHouseType())){
			String[] split = qv.getHouseType().split(",");
			sql.append(" and lxid="+split[0]);
			for (int i = 1; i < split.length; i++) {
				sql.append(" or lxid="+split[i]);
			}
		} 
		//�������� -1:���� 1:���� 2:������ 3:������ 4:��һ�� 5:���� 6: һ��
		if(IsNotNull(qv.getPublishDate())&&qv.getPublishDate().equals("-1")){
			//ǰһ��
			if(Integer.parseInt(qv.getPublishDate())==1){
				sql.append(" and publishdate=trunc(sysdate )+(INTERVAL '0' DAY) ");
			}else 
			//ǰ����
			if(Integer.parseInt(qv.getPublishDate())==2){
				sql.append(" and publishdate>trunc(sysdate )+(INTERVAL '-2' DAY) ");
			}else //ǰ����
				if(Integer.parseInt(qv.getPublishDate())==3){
				sql.append(" and publishdate>trunc(sysdate )+(INTERVAL '-3' DAY)  ");
			}else //ǰһ��
				if(Integer.parseInt(qv.getPublishDate())==4){
				sql.append(" and publishdate>trunc(sysdate )+(INTERVAL '-7' DAY)  ");
			}else//ǰ����
				if(Integer.parseInt(qv.getPublishDate())==5){
				sql.append(" and publishdate>trunc(sysdate )+(INTERVAL '-14' DAY)  ");
			}else//ǰһ���� 
				if(Integer.parseInt(qv.getPublishDate())==6){
				sql.append(" and publishdate>trunc(sysdate )+(INTERVAL '-1' month)  ");
			}
		}
		sql.append(")");
//		System.out.println(sql);
		int returnUID = new Returns().returnUID(obj, sql.toString(), false);
		
		
		int num = (returnUID-1)/pageSize+1;
		return num;
	}
	public static List advancedList(QueryView qv,Object obj,int pageIndex,int pageSize){
		Class class1 = obj.getClass();
		Field[] fields = class1.getDeclaredFields();
		Field.setAccessible(fields, true);
		StringBuffer sql=new StringBuffer("select * from (select rownum RN,t.* from "+class1.getSimpleName()+" t where 1=1");
		//����
		if(IsNotNull(qv.getTitle())){
			sql.append(" and title like '%"+qv.getTitle()+"%' ");
		}
		
			//�ֵ�
		if( IsNotNull(qv.getJieDao())&&!qv.getJieDao().equals("-1")){
			sql.append(" and jdid="+qv.getJieDao());
		}else{
			//��
			if(IsNotNull(qv.getQu())&&!qv.getQu().equals("-1")){
				List<TBL_JD> listQXid = TBL_JDDao.listQXid(Integer.parseInt(qv.getQu()));
				sql.append(" and JDID = "+listQXid.get(0).getJdid());
				for (int i = 1; i <listQXid.size(); i++) {
					sql.append(" or JDID = "+listQXid.get(i).getJdid());
				}
			}
		}
		//��ʼ���
		if(qv.getZhujingStare()!=null){
			sql.append(" and zj>"+qv.getZhujingStare());
		}
		//�������
		if(qv.getZhujingEnd()!=null){
			sql.append(" and zj<"+qv.getZhujingEnd());
		}
		//��
		if(qv.getShi()!=null&&qv.getShi()!=-1){
			sql.append(" and shi="+qv.getShi());
		}
		//��
		if(qv.getTing()!=null&&qv.getTing()!=-1){
			sql.append(" and ting="+qv.getTing());
		}
		//��������
		if(IsNotNull(qv.getHouseType())){
			String[] split = qv.getHouseType().split(",");
			sql.append(" and lxid="+split[0]);
			for (int i = 1; i < split.length; i++) {
				sql.append(" or lxid="+split[i]);
			}
		} 
		//�������� -1:���� 1:���� 2:������ 3:������ 4:��һ�� 5:���� 6: һ��
		if(IsNotNull(qv.getPublishDate())&&!qv.getPublishDate().equals("-1")){
			//ǰһ��
			if(Integer.parseInt(qv.getPublishDate())==1){
				sql.append(" and publishdate=trunc(sysdate )+(INTERVAL '0' DAY) ");
			}else 
			//ǰ����
			if(Integer.parseInt(qv.getPublishDate())==2){
				sql.append(" and publishdate>trunc(sysdate )+(INTERVAL '-2' DAY) ");
			}else //ǰ����
				if(Integer.parseInt(qv.getPublishDate())==3){
				sql.append(" and publishdate>trunc(sysdate )+(INTERVAL '-3' DAY)  ");
			}else //ǰһ��
				if(Integer.parseInt(qv.getPublishDate())==4){
				sql.append(" and publishdate>trunc(sysdate )+(INTERVAL '-7' DAY)  ");
			}else//ǰ����
				if(Integer.parseInt(qv.getPublishDate())==5){
				sql.append(" and publishdate>trunc(sysdate )+(INTERVAL '-14' DAY)  ");
			}else//ǰһ���� 
				if(Integer.parseInt(qv.getPublishDate())==6){
				sql.append(" and publishdate>trunc(sysdate )+(INTERVAL '-1' month)  ");
			}
		}
		sql.append(")where  rn>"
					+ ((pageIndex - 1) * pageSize) + " and " + "rn<="
					+ pageIndex * pageSize + "" + " order by "
					+ fields[0].getName() + " desc ");
		System.out.println(sql);
		List returnList = new Returns().returnList(obj, sql.toString());
		
		return returnList;
	}
	
	
	
	//ƴ������  �ֵ�
	public static String jiequ(Object obj){
		//����id��ѯ  �ֵ�
		List<TBL_JD> listJd = BaseDao.listID(obj);
		
		List<TBL_QX> listQx = null;
		if(listJd.get(0).getQxid()!=null){
			Integer qxid = listJd.get(0).getQxid();
			TBL_QX  qx=new TBL_QX();
			qx.setQxid(qxid);
			listQx = BaseDao.listID(qx);
		}
		//����ƴ��
		StringBuffer jiequString=new StringBuffer();
		jiequString.append(listQx.get(0).getQx()+"[��(��)],");
		jiequString.append(listJd.get(0).getJd());
		return jiequString.toString();
	}
	public static void main(String[] args) {
		TBL_JD jd=new TBL_JD();
		jd.setJdid(1);
		System.out.println(jiequ(jd));
		
		System.out.println(TBL_FWXXDao.advancedListCount(new QueryView(),new TBL_FWXX(), 5));
	}
}
