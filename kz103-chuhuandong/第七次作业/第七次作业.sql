--��ϰһ����ʽ�α꣨�α����ԣ�
declare
 dno number;
begin
 dno :='&dno';
 update emp set sal=sal+100 where deptno=dno;
 if sql%rowcount>0 then
    dbms_output.put_line('ִ�гɹ���ִ����'||sql%rowcount||'��');
  else
    dbms_output.put_line('ִ��ʧ�ܲ��Ų�����');
  end if;  
end;

--��ϰ������ʽ�α�
--ʹ����ʽ�α��дһ������
--����ʾscott�û���emp���dept���е�empno��ename��sal��deptno��dname����ֶ�ֵ��
declare
  cursor cur is select * from emp order by deptno;
  cursor curs is select * from dept;
  num emp%rowtype;
  num2 dept%rowtype;
begin
  for num in cur
  loop
       for num2 in curs
       loop
           if num.deptno=num2.deptno then
              dbms_output.put_line(num.empno||'----'||num.ename||'----'||num.sal||'----'||num.deptno||'----'||num2.dname);
           end if;
       end loop;
  end loop;
end;
--��ϰ����ѭ���α� for
declare
  cursor cur is select * from emp;
  cursor curs is select * from dept;
  num emp%rowtype;
  num2 dept%rowtype;
  nums number:=0;
begin
  for num2 in curs
      loop
           dbms_output.put_line('���ű�ţ�'||num2.deptno||'�����ƣ�'||num2.dname);
           for num in cur
           loop
               if num.deptno=num2.deptno then
                  nums:=nums+1;
                  dbms_output.put_line('Ա��'||nums||'��'||num.ename);
               end if;
           end loop;
            dbms_output.put_line('����������������������������������������������������������������������������������������');
      end loop;
end;
--��ϰ�ġ�ʹ���α��������
declare
      cursor cur is select passwords from userinfo for update;
      num number(6):=round(dbms_random.value(100000,999999),0);
      nums number:=0;
begin
      for r in cur
      loop
          update userinfo set passwords = num where current of cur;
          nums := nums+1;
      end loop;
      if sql%found then
               dbms_output.put_line('�ɹ�'||'������'||nums||'��');
      end if;
      commit;
end;
select * from userinfo

--��Scott�û���¼����дһ�δ��룬��ʾ�û�Ҫ�鿴�ĸ���ļ�¼��
--����û����롮E������ʾemp���е�empno��ename�е�ֵ��
--����û����롮D������ʾdept���е�deptno��dname�е�ֵ��
declare
       refs sys_refcursor;
       input varchar(2):='&�������';
       v1 number;
       v2 varchar2(20);
begin
       if input='E' then
          open refs for select empno,ename from emp;
       elsif input='D' then
          open refs for select deptno,dname from dept;
       else
          dbms_output.put_line('��������ȷ�ı�');                                             
       end if;
       loop
           fetch refs into v1,v2;
                 dbms_output.put_line(v1||'������������������������'||v2);
           exit when refs%notfound;
        end loop;
        close refs;
end;
