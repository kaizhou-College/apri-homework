--��ϰһ����ʽ�α꣨�α����ԣ���
declare
      dno number;
begin
      dno:='&dno';
      update emp set sal = sal+100 where deptno=dno;
      if sql%rowcount>0 then
         dbms_output.put_line('ִ�гɹ���ִ����'||sql%rowcount||'�м�¼');
      else
         dbms_output.put_line('ִ��ʧ��');
      end if;
end;

--��ϰ������ʽ�α�
--ʹ����ʽ�α��дһ����������ʾscott�û���emp���dept���е�empno��ename��sal��deptno��dname����ֶ�ֵ��
declare
      cursor em is select * from emp;  --emp���α�
      cursor dp(dno number) is select dname from dept where deptno=dno;  --dept���α�
      emn emp%rowtype;  --emp��¼�Ա���
      dpn dept%rowtype;  --dept �����ͱ���
begin
     for emn in em
      Loop
         for dpn in dp(emn.deptno)
             Loop
                 dbms_output.put_line(emn.empno||'------------'||emn.ename||'--------'||emn.sal||'------------'||emn.deptno||'------------'||dpn.dname);
             end loop;
      end loop;
     
end;

--��ϰ����ѭ���α� for
--��д��������ʾ���������ƺ͸ò��Ű�����Ա��������Ҫ��ʹ����ʽ��ѭ���α�ʵ�֡�
declare
      cursor dp is select * from dept;  
      cursor em(dno number) is select ename from emp where deptno=dno;  
      emn emp%rowtype;  
      dpn dept%rowtype;  
      num number:=1;
begin
     for dpn in dp
      Loop
              dbms_output.put_line('--------------------------------------------');
             dbms_output.put_line('���ű�ţ�'||dpn.deptno||'�����ƣ�'||dpn.dname);
         for emn in em(dpn.deptno)
             Loop
                    dbms_output.put_line('Ա��'||num||'��'||emn.ename);
                    num:=num+1;
             end loop;
      end loop;
     
end;

--��ϰ�ġ�ʹ���α��������
--��userInfo.dmp�ļ��е����ݵ��뵽Scott�û��£����а���UserInfo��
--����UserInfo���пͻ����뱻�����ˣ����������дPL/SQL��䣬�������������û������룬Ҫ���������Ϊ6λ����
declare
	cursor up is  select * from userinfo for update of password;
  num number:=round(dbms_random.value(100000,999999));
begin
   for use in up
   loop
		update userinfo set password=num	where current of up;      
   end loop;
end; 

--��ϰ�塢REF�α�
--��Scott�û���¼����дһ�δ��룬��ʾ�û�Ҫ�鿴�ĸ���ļ�¼��
--����û����롮E������ʾemp���е�empno��ename�е�ֵ������û����롮D������ʾdept���е�deptno��dname�е�ֵ��
declare
   type Boss is ref cursor;
   DE Boss;
   input varchar2(10):='&�������' ;
   num number;
   name varchar2(20);
begin
    if input='E' then
       open DE for select empno,ename from emp;
     else 
       open DE for select deptno,dname from dept;
      end if;
    loop
      fetch DE into num,name;
            dbms_output.put_line(num||'---'||name);
      exit when DE%notfound;
  end loop;
end;
