


//���˻�Աע������������֤
function checkpersonreg()
{
	if (document.regform.realname.value.replace(/\s+$|^\s+/g,"").length<=0)
	{
		alert("\����д�����ʵ����"); 
		document.regform.realname.focus();
		return false;
    }
    if (document.regform.sheng.value.replace(/\s+$|^\s+/g,"").length<=0)
	{
		alert("\��ѡ��ʡ��"); 
		document.regform.sheng.focus();
		return false;
    }
    if (document.regform.city.value.replace(/\s+$|^\s+/g,"").length<=0)
	{
		alert("\��ѡ�����ڳ��У�"); 
		document.regform.city.focus();
		return false;
    }
	if (document.regform.telphone.value.replace(/\s+$|^\s+/g,"").length<7)
	{
		alert("\����ȷ��д�����ϵ�绰����������λ���ϣ�ֻ��Ϊ���֣�"); 
		document.regform.telphone.focus();
		return false;
    }
	if (document.regform.email.value.replace(/\s+$|^\s+/g,"").length<=0)
	{
		alert("\����д������䣡"); 
		document.regform.email.focus();
		return false;
     }
	 if(!/(\S)+[@]{1}(\S)+[.]{1}(\w)+/.test(document.regform.email.value)) 
    {
        alert("�������ʽ��ȷ�� e-mail ��ַ��");
        document.regform.email.focus();
        return false;         
    }
	if (document.regform.question.value.replace(/\s+$|^\s+/g,"").length<=0)
	{
		alert("\����д������ʾ���⣡"); 
		document.regform.question.focus();
		return false;
     }
	 if (document.regform.answer.value.replace(/\s+$|^\s+/g,"").length<=0)
	{
		alert("\����д���뱣���𰸣�"); 
		document.regform.answer.focus();
		return false;
     }
	 if (document.regform.question.value==document.regform.answer.value)
	{
		alert("\���뱣����ʾ����ʹ𰸲���һ��"); 
		document.regform.answer.focus();
		return false;
     }
	 if (document.regform.uid.value.replace(/\s+$|^\s+/g,"").length<=0)
		{
			alert("\����д������֤�ţ�"); 
			document.regform.uid.focus();
			return false;
	     }
	 if (document.regform.uid.value.replace(/\s+$|^\s+/g,"").length>18||document.regform.uid.value.replace(/\s+$|^\s+/g,"").length<18)
		{
			alert("\���֤���볤�ȴ���"); 
			document.regform.uid.focus();
			return false;
	     }
     regform.submit();
}	
//��֤��ҵ��Աע������
function checkcoreg()
{
	if (document.reg.coname.value.replace(/\s+$|^\s+/g,"").length<=0)
	{
		alert("\����д��˾��ƣ�"); 
		document.reg.coname.focus();
		return false;
     }
	 if (document.reg.address.value.replace(/\s+$|^\s+/g,"").length<=0)
	{
		alert("\����д��˾��ַ��"); 
		document.reg.address.focus();
		return false;
     }
	 if (document.reg.postnum.value.replace(/\s+$|^\s+/g,"").length>0&&document.reg.postnum.value.replace(/\s+$|^\s+/g,"").length!=6)
	{
		alert("\��������Ϊ��λ���֣�"); 
		document.reg.postnum.focus();
		return false;
     }
	if (document.reg.telphone.value.replace(/\s+$|^\s+/g,"").length<7)
	{
		alert("\����ȷ��д�����ϵ�绰����������λ���ϣ�ֻ��Ϊ���֣�"); 
		document.reg.telphone.focus();
		return false;
    }
	if (document.reg.email.value.replace(/\s+$|^\s+/g,"").length<=0)
	{
		alert("\����д������䣡"); 
		document.reg.email.focus();
		return false;
     }
	 if(!/(\S)+[@]{1}(\S)+[.]{1}(\w)+/.test(document.reg.email.value)) 
    {
        alert("�������ʽ��ȷ�� e-mail ��ַ��");
        document.reg.email.focus();
        return false;         
    }
	if (document.reg.question.value.replace(/\s+$|^\s+/g,"").length<=0)
	{
		alert("\����д������ʾ���⣡"); 
		document.reg.question.focus();
		return false;
     }
	 if (document.reg.answer.value.replace(/\s+$|^\s+/g,"").length<=0)
	{
		alert("\����д���뱣���𰸣�"); 
		document.reg.answer.focus();
		return false;
     }
	 if (document.reg.question.value==document.reg.answer.value)
	{
		alert("\���뱣����ʾ����ʹ𰸲���һ��"); 
		document.reg.answer.focus();
		return false;
     }
	 if (document.reg.intro.value.replace(/\s+$|^\s+/g,"").length>500)
	{
		alert("\��˾������500�����ڣ�"); 
		document.reg.intro.focus();
		return false;
     }
     reg.submit();
}
