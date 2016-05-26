
var $;
if (document.getElementById) {
  $ = function() {
    var elements = new Array();
    for (var i = 0; i < arguments.length; i++) {
      var element = arguments[i];
      if (typeof element == 'string') {
        element = document.getElementById(element);
      }
      if (arguments.length == 1) {
        return element;
      }
      elements.push(element);
    }
    return elements;
  };
}
else if (document.all) {
  $ = function() {
    var elements = new Array();
    for (var i = 0; i < arguments.length; i++) {
      var element = arguments[i];
      if (typeof element == 'string') {
        element = document.all[element];
      }
      if (arguments.length == 1) {
        return element;
      }
      elements.push(element);
    }
    return elements;
  };
}
				
function chooseCd(defaultid){
   // alert($("tname").value);
	if ($("tname").value != "") {
		$($("tname").value).parentNode.className = "current";
	} else {
		$($("defaultid").value).parentNode.className = "current";
	   
	}

}	
function pageCardOn(defaultid) {
   
	if ($("tname").value != "") {
		$($("tname").value + "l").className = "xxk_on_l";
		$($("tname").value).className = "xxk_on_m";
		$($("tname").value + "r").className = "xxk_on_r";
	} else {
	    $(defaultid + "l").className = "xxk_on_l";
		$(defaultid).className = "xxk_on_m";
		$(defaultid + "r").className = "xxk_on_r";
		$("tname").value = defaultid;
	}
}
function chgCode(objTr,btnId) {
    //alert(btnId);
    __doPostBack(btnId,'');
}
function chgCode1(objTr,btnId) {
    var obj=$("tname");
    obj.value=btnId;
    pageCardOn1();
    
}
function pageCardOn1(defaultid) {
	if ($("tname").value != "") {
	   //alert($("tname").value);
	   var tname=$("tname").value
	    if (tname=="syly")
	    {
	     $($("tname").value + "l").className = "xxk_on_l";
		 $($("tname").value).className = "xxk_on_m";
		 $($("tname").value + "r").className = "xxk_on_r";
		 $("lygll").className = "xxk_off_l";
		 $("lygl").className = "xxk_off_m";
		 $("lyglr").className = "xxk_off_r";
		 $("zjlyl").className = "xxk_off_l";
		 $("zjly").className = "xxk_off_m";
		 $("zjlyr").className = "xxk_off_r";
		 $("cxlyl").className = "xxk_off_l";
		 $("cxly").className = "xxk_off_m";
		 $("cxlyr").className = "xxk_off_r";
		 $("div_syly").style.display="block"
		 $("div_lygl").style.display="none"
		 $("div_zjly").style.display="none"
		 $("div_cxly").style.display="none"
		}
		
		 if (tname=="lygl")
	    {
	     $($("tname").value + "l").className = "xxk_on_l";
		 $($("tname").value).className = "xxk_on_m";
		 $($("tname").value + "r").className = "xxk_on_r";
		 $("sylyl").className = "xxk_off_l";
		 $("syly").className = "xxk_off_m";
		 $("sylyr").className = "xxk_off_r";
		 $("zjlyl").className = "xxk_off_l";
		 $("zjly").className = "xxk_off_m";
		 $("zjlyr").className = "xxk_off_r";
		 $("cxlyl").className = "xxk_off_l";
		 $("cxly").className = "xxk_off_m";
		 $("cxlyr").className = "xxk_off_r";
		 $("div_syly").style.display="none"
		 $("div_lygl").style.display="block"
		 $("div_zjly").style.display="none"
		 $("div_cxly").style.display="none"
		}
				
		if (tname=="zjly")
	    {
	     $($("tname").value + "l").className = "xxk_on_l";
		 $($("tname").value).className = "xxk_on_m";
		 $($("tname").value + "r").className = "xxk_on_r";
		 $("sylyl").className = "xxk_off_l";
		 $("syly").className = "xxk_off_m";
		 $("sylyr").className = "xxk_off_r";
		 $("lygll").className = "xxk_off_l";
		 $("lygl").className = "xxk_off_m";
		 $("lyglr").className = "xxk_off_r";
		 $("cxlyl").className = "xxk_off_l";
		 $("cxly").className = "xxk_off_m";
		 $("cxlyr").className = "xxk_off_r";
		 $("div_syly").style.display="none"
		 $("div_lygl").style.display="none"
		 $("div_zjly").style.display="block"
		 $("div_cxly").style.display="none"
		}
		if (tname=="cxly")
	    {
	     $($("tname").value + "l").className = "xxk_on_l";
		 $($("tname").value).className = "xxk_on_m";
		 $($("tname").value + "r").className = "xxk_on_r";
		 $("sylyl").className = "xxk_off_l";
		 $("syly").className = "xxk_off_m";
		 $("sylyr").className = "xxk_off_r";
		 $("lygll").className = "xxk_off_l";
		 $("lygl").className = "xxk_off_m";
		 $("lyglr").className = "xxk_off_r";
		 $("zjlyl").className = "xxk_off_l";
		 $("zjly").className = "xxk_off_m";
		 $("zjlyr").className = "xxk_off_r";
		 $("div_syly").style.display="none"
		 $("div_lygl").style.display="none"
		 $("div_zjly").style.display="none"
		 $("div_cxly").style.display="block"
		}
		
	} else {
	     $("sylyl").className = "xxk_on_l";
		 $("syly").className = "xxk_on_m";
		 $("sylyr").className = "xxk_on_r";
		 $("lygll").className = "xxk_off_l";
		 $("lygl").className = "xxk_off_m";
		 $("lyglr").className = "xxk_off_r";
		 $("zjlyl").className = "xxk_off_l";
		 $("zjly").className = "xxk_off_m";
		 $("zjlyr").className = "xxk_off_r";
		 $("cxlyl").className = "xxk_off_l";
		 $("cxly").className = "xxk_off_m";
		 $("cxlyr").className = "xxk_off_r";
		 $("div_syly").style.display="block"
		 $("div_lygl").style.display="none"
		 $("div_zjly").style.display="none"
		 $("div_cxly").style.display="none"
	}
}

function ClearTextValue(TxtId) {
    if($(TxtId).value != "")
    $(TxtId).value=""

}
function ChangeCor(obj,objID){
	var i;
	var obj1=document.getElementById(objID);
				   
				
	for(i=0;i<obj1.rows.length;i++)
	{ if (obj1.rows[i]!=obj)
		  obj1.rows[i].style.backgroundColor="";
	   else
		   obj.style.backgroundColor="ffdead";
	 }
}

function RidBtnList_click(obj,objID){
     var obj1=$(objID);
     var zy;
     var m ;
     var i,j,n;
     for (n=0;n<obj.getElementsByTagName("input").length;n++)
         {
         if (obj.getElementsByTagName("input")[n].checked==true)
             {
               m=obj.getElementsByTagName("input")[n].value;
               break;
             }
         }
     //alert(m);
     for(i=0;i<obj1.rows.length;i++)
        {
         
         for(j=0;j<obj1.rows[i].getElementsByTagName("input").length;j++)
            {
             if (obj1.rows[i].getElementsByTagName("input")[j].checked==true)
				{
				    zy=obj1.rows[i].getElementsByTagName("input")[j].value;
	              
					if (zy == m)
						{
						//alert(zy + "-" + m);
						if (obj1.rows[i].getElementsByTagName("input")[j]!=obj.getElementsByTagName("input")[n])
						    {//alert(i + "-"+ j + "-" + n);
							 obj1.rows[i].getElementsByTagName("input")[j].checked=false;
							}
						} 
				}     
            }
         
        }

}

function DisabledRed(str){
    
     var xxmc=str
     var n,i;
     var obj=$("Table1");
     if (xxmc=="����ʦ����ѧ")
     {
       obj.rows[2].getElementsByTagName("input")[0].disabled="true";
       obj.rows[2].getElementsByTagName("input")[2].disabled="true";
     }
}

 function reMoveCh(form,frame){
     var type;
     type=QueryString("type");
     //alert(type);
     if (type=="1")
      {$(form).removeChild($(frame));}
     
     
	 }
	 
function   QueryString(sName)   
  {   
		var   sSource   =   String(window.document.location);   
		var   sReturn   =   "";   
		var   sQUS   =   "?";   
		var   sAMP   =   "&";   
		var   sEQ   =   "=";   
		var   iPos;   
		    
		iPos   =   sSource.indexOf(sQUS);   
		    
		var   strQuery   =   sSource.substr(iPos,   sSource.length   -   iPos);   
		var   strLCQuery   =   strQuery.toLowerCase();   
		var   strLCName   =   sName.toLowerCase();   
		    
		iPos   =   strLCQuery.indexOf(sQUS   +   strLCName   +   sEQ);   
		if   (iPos   ==   -1)   
			{   
			iPos   =   strLCQuery.indexOf(sAMP   +   strLCName   +   sEQ);   
			if   (iPos   ==   -1)   
			return   "";   
			}   
		    
		sReturn   =   strQuery.substr(iPos   +   sName.length   +   2,strQuery.length-(iPos   +   sName.length   +   2));   
		var   iPosAMP   =   sReturn.indexOf(sAMP);   
		    
		if   (iPosAMP   ==   -1)   
			return   sReturn;   
		else   
			{   
			sReturn   =   sReturn.substr(0,   iPosAMP);   
			}   
		    
		return   sReturn;   
  }   
  
function checkform(txtid,obj1,ts) {
	if (ts=="")
	{
		if ($(txtid).value=="")
		{
		alert("�������ݲ���Ϊ�գ���")
		return false;
		}
	}
	else
	{ 
		var n=$(obj1).length;
	 	for (i=0;i<n;++i)
		{  
			if ($(obj1).options[i].selected)
			{
			
				if ($(obj1).options[i].value=="")
				{
				alert("���������Ϊ�գ���");
				return false;
				}
			}
		}
		
		if ($(txtid).value=="")
		{
		alert("�������ݲ���Ϊ�գ���");
		return false;
		}
	}

}


//��ѧ���� �γ̽�������
function KcFormCheck(){
   if($("txt_xmmc").value=="" || $("txt_cc").value=="" || $("txt_yjxk").value=="" ||$("txt_ejxk").value==""|| $("txt_skxss").value=="" || $("txt_sqjf").value=="" || $("qssj").value=="" || $("jssj").value=="" || $("txt_jszb").value=="" || $("DropDownList2").value=="" ){
        alert("��Ѵ�*�ŵ�����д������");
        return false;
        }
 }
//��ѧ���� �̲Ľ�������
function JcFormCheck(){
   if($("txt_xmmc").value=="" ||  $("sqjf").value=="" || $("qssj").value=="" || $("jssj").value==""  ){
        alert("��Ѵ�*�ŵ�����д������");
        return false;
        }
 }
 //��ѧ���� רҵ��������
function JcFormCheck(){
   if($("txt_xmmc").value=="" || $("txt_syzy").value=="" || $("sqjf").value=="" || $("qssj").value=="" || $("jssj").value=="" ||$("txt_zyzb").value==""  ){
        alert("��Ѵ�*�ŵ�����д������");
        return false;
        }
 }
 
  //�����˵�
 function menuFix() {
   var sfEls = document.getElementById("nav").getElementsByTagName("li");
   for (var i=0; i<sfEls.length; i++) {
       sfEls[i].onmouseover=function() {
       this.className+=(this.className.length>0? " ": "") + "sfhover";
       }
       sfEls[i].onMouseDown=function() {
       this.className+=(this.className.length>0? " ": "") + "sfhover";
       }
       sfEls[i].onMouseUp=function() {
       this.className+=(this.className.length>0? " ": "") + "sfhover";
       }
       sfEls[i].onmouseout=function() {
       this.className=this.className.replace(new RegExp("( ?|^)sfhover\\b"), 

"");
       }
   }
}

function ShowDrop(objDrop,popup,evt) {
        if (objDrop.value!=""){
	    document.getElementById("td1").innerText="" + objDrop.options[objDrop.selectedIndex].text;
	     evt=evt?evt:(window.event?window.event:null);
    	x=evt.clientX + document.body.scrollLeft;
	    y=evt.clientY + document.body.scrollTop + 20;
		$(popup).style.display="block"; 
		$(popup).style.left = x;
		$(popup).style.top = y;
		}
}
function HideDrop(popup){
					$(popup).style.display="none";
				}

//�ж��Ƿ���ie�����
function isIE(){ //ie? 
if (window.navigator.userAgent.toLowerCase().indexOf("msie")>=1) 
    return true; 
else 
    return false; 
} 
				

////add by djf 20110127��������default6ҳ��
//�ı�ҳǩ
function yeQChange(objTr,btnId,classStyle,btns,list) {

    var obj=$(objTr);
    obj.value=btnId;
    pageCardFresh(objTr,classStyle,btns,list);
    
}
function pageCardFresh(objTr,classStyle,btns,list) {
    var obj=$(objTr);
    var btid=obj.value;
    if (btid==""){return;}
    var arrBtns=$(btns).value.split("|");
    var i;
    //���ŵڶ������������ѡ��ı���ʽ
    $(btid).parentNode.className = classStyle;
    for (i=0;i<arrBtns.length;i++){
    if (arrBtns[i]!=btid){ $(arrBtns[i]).parentNode.className = "";}
    }  
  //���listΪ���������ŵĸ������Ӹı����Ӳ���
    if (list!=''){var rtn=AjaxForm.showGg(btid);$(list2).innerHTML=rtn.value;$(more2).innerHTML="<A href='ew_newsmore.aspx?lb=" + btid + "' target='_blank'></A>"}
  //�����¼���Ƿ�У��ѧ����¼�޸�
    else{
  //���������Ϣ
    $("txtYhm").value="";
    $("txtXm").value="";
    $("txtMm").value=""; 
   //У��ѧ����¼
    if (btid=='xwxsdl') { 
					if ( isIE()==true){$("lblyhm").innerText="֤���ţ�";}
					else {  $("lblyhm").textContent="֤���ţ�";}    
					     $("lblyhm").innerText="֤���ţ�";
                    $("lblxm").style.display="block";
                     $("lblmm").style.display="none";
                    $("rblJs").style.visibility="hidden";
                     $("xwzc").style.display="block";             
                    }
    else{
    //У��ѧ����¼
         if ( isIE()==true){ $("lblyhm").innerText="�û�����";} else { $("lblyhm").textContent="�û�����";}   
          $("lblxm").style.display="none";
          $("lblmm").style.display="block";
          $("rblJs").style.visibility="visible";
          $("xwzc").style.display="none";
           
          }
  
    }
}

function addxkcs(xkcs) {
//debugger;
    var obj=$("txtxkcs");
    obj.value=xkcs;
    chgCode(this,'btnPost')
    
}
