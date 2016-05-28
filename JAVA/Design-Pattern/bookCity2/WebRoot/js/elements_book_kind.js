	function tabit(btn){
		var idname = new String(btn.id);
		//window.alert(idname); 
		//window.alert(btn); 
		var s = idname.indexOf("_");
		var e = idname.lastIndexOf("_")+1;
		var tabName = idname.substr(0, s);
		//window.alert(tabName); 
		var id = parseInt(idname.substr(e, 1));
		//window.alert(btn.parentNode);
		//window.alert(btn.parentNode.childNodes);
		var tabNumber = btn.parentNode.childNodes.length;
		//window.alert(tabNumber); 
		for(i=0;i<tabNumber;i++){
			//window.alert(tabName+"_div_"+i); 
			document.getElementById(tabName+"_div_"+i).style.display = "none"; 
			document.getElementById(tabName+"_btn_"+i).className = "mainbookbtn1 daixuanf";
		
		};		
		document.getElementById(tabName+"_div_"+id).style.display = "block"; 
		btn.className = "mainbookbtn1 xuanzhong";
	};
	var fodTime;
	function delaytabit(btn){
		clearTimeout(fodTime);
		fodTime=setTimeout(function(){tabit(btn)},100);
	}
	
	
	function tabit_job(btn){
		var idname = new String(btn.id);
		//document.write(idname);
		var s = idname.indexOf("_");
		var e = idname.lastIndexOf("_")+1;
		var tabName = idname.substr(0, s);
		var id = parseInt(idname.substr(e, 1));
		var tabNumber = btn.parentNode.childNodes.length;
		for(i=0;i<tabNumber;i++)
			{
				document.getElementById(tabName+"_div_"+i).style.display = "none"; 
				document.getElementById(tabName+"_btn_"+i).className = "mainbookbtn1 daixuanf";
			
			};		
			document.getElementById(tabName+"_div_"+id).style.display = "block"; 
			btn.className = "mainbookbtn1 xuanzhong";
	};
	var fodTime;
	function delaytabit_job(btn){
		clearTimeout(fodTime);
		fodTime=setTimeout(function(){tabit_job(btn)},100);
	}
	
	
	function tabit_industry(btn){
		var idname = new String(btn.id);
		//document.write(idname);
		var s = idname.indexOf("_");
		var e = idname.lastIndexOf("_")+1;
		var tabName = idname.substr(0, s);
		var id = parseInt(idname.substr(e, 1));
		var tabNumber = btn.parentNode.childNodes.length;
		for(i=0;i<tabNumber;i++)
			{
				document.getElementById(tabName+"_div_"+i).style.display = "none"; 
				document.getElementById(tabName+"_btn_"+i).className = "mainbookbtn1 daixuanf";
			
			};		
			document.getElementById(tabName+"_div_"+id).style.display = "block"; 
			btn.className = "mainbookbtn1 xuanzhong";
	};
	var fodTime;
	function delaytabit_industry(btn){
		clearTimeout(fodTime);
		fodTime=setTimeout(function(){tabit_industry(btn)},100);
	}
	
	function tabit_rexiao(btn){
		var idname = new String(btn.id);
		//document.write(idname);
		var s = idname.indexOf("_");
		var e = idname.lastIndexOf("_")+1;
		var tabName = idname.substr(0, s);
		var id = parseInt(idname.substr(e, 1));
		var tabNumber = 2;
		//document.write(tabNumber);
		for(i=0;i<tabNumber;i++)
			{
				document.getElementById(tabName+"_div_"+i).style.display = "none"; 
				document.getElementById(tabName+"_btn_"+i).className = "beiweixuan";//ǰʾ
			
			};		
			document.getElementById(tabName+"_div_"+id).style.display = "block"; 
			btn.className = "bei";  //ǰʾ
	};
	var fodTime;
	function delaytabit_rexiao(btn){
		//document.write(btn);
		clearTimeout(fodTime);
		fodTime=setTimeout(function(){tabit_rexiao(btn)},100);
	}
	
	
	function tabit_yinxiang(btn){
		var idname = new String(btn.id);
		//document.write(idname);
		var s = idname.indexOf("_");
		var e = idname.lastIndexOf("_")+1;
		var tabName = idname.substr(0, s);
		var id = parseInt(idname.substr(e, 1));
		var tabNumber = btn.parentNode.childNodes.length;
		//document.write(tabNumber);
		for(i=0;i<tabNumber;i++)
			{
				document.getElementById(tabName+"_div_"+i).style.display = "none"; 
				document.getElementById(tabName+"_btn_"+i).className = "daohang1 dao";//ǰʾ
			
			};		
			document.getElementById(tabName+"_div_"+id).style.display = "block"; 
			btn.className = "daohang4 dao";  //ǰʾ
	};
	var fodTime;
	function delaytabit_yinxiang(btn){
		//document.write(btn);
		clearTimeout(fodTime);
		fodTime=setTimeout(function(){tabit_yinxiang(btn)},100);
	}
	
	
	
	function tabit_tushufenlei(btn){
		var idname = new String(btn.id);
		//document.write(idname);
		var s = idname.indexOf("_");
		var e = idname.lastIndexOf("_")+1;
		var tabName = idname.substr(0, s);
		var id = parseInt(idname.substr(e, 1));
		var tabNumber = btn.parentNode.childNodes.length;
		//document.write(tabNumber);
		for(i=0;i<tabNumber;i++)
			{
				document.getElementById(tabName+"_div_"+i).style.display = "none"; 
				document.getElementById(tabName+"_btn_"+i).className = "beiweixuan";//ǰʾ
			
			};		
			document.getElementById(tabName+"_div_"+id).style.display = "block"; 
			btn.className = "bei";  //ǰʾ
	};
	var fodTime;
	function delaytabit_tushufenlei(btn){
		//document.write(btn);
		clearTimeout(fodTime);
		fodTime=setTimeout(function(){tabit_tushufenlei(btn)},100);
	}
	
	function tabit_fenleiliebiao(btn){
		var idname = new String(btn.id);
		//document.write(idname);
		var s = idname.indexOf("_");
		var e = idname.lastIndexOf("_")+1;
		var tabName = idname.substr(0, s);
		var id = parseInt(idname.substr(e, 1));
		var tabNumber = btn.parentNode.childNodes.length;
		//document.write(tabNumber);
		for(i=0;i<tabNumber;i++)
			{
				document.getElementById(tabName+"_div_"+i).style.display = "none"; 
				document.getElementById(tabName+"_btn_"+i).className = "daohang6 dao";//ǰʾ
			
			};		
			document.getElementById(tabName+"_div_"+id).style.display = "block"; 
			btn.className = "daohang6 daohangx";  //ǰʾ
	};
	var fodTime;
	function delaytabit_fenleiliebiao(btn){
		//document.write(btn);
		clearTimeout(fodTime);
		fodTime=setTimeout(function(){tabit_fenleiliebiao(btn)},100);
	}
	
  	
	
	
	
	function tabit_sousuoliebiao(btn){
		var idname = new String(btn.id);
		//document.write(idname);
		var s = idname.indexOf("_");
		var e = idname.lastIndexOf("_")+1;
		var tabName = idname.substr(0, s);
		var id = parseInt(idname.substr(e, 1));
		var tabNumber = btn.parentNode.childNodes.length;
		//document.write(tabNumber);
		for(i=0;i<tabNumber;i++)
			{
				document.getElementById(tabName+"_div_"+i).style.display = "none"; 
				document.getElementById(tabName+"_btn_"+i).className = "daohang6 dao";//ǰʾ
			
			};		
			document.getElementById(tabName+"_div_"+id).style.display = "block"; 
			btn.className = "daohang6 daohangx";  //ǰʾ
	};
	var fodTime;
	function delaytabit_sousuoliebiao(btn){
		  //document.write(btn);
		clearTimeout(fodTime);
		fodTime=setTimeout(function(){tabit_sousuoliebiao(btn)},100);
	}
	
	
	function tabit_shouyeyetou(btn){
		var idname = new String(btn.id);
		//document.write(idname);
		var s = idname.indexOf("_");
		var e = idname.lastIndexOf("_")+1;
		var tabName = idname.substr(0, s);
		//document.write(tabName);
		var id = parseInt(idname.substr(e, 1));
		var tabNumber = btn.parentNode.childNodes.length;
		//document.write(tabNumber);
		for(i=0;i<tabNumber;i++)
			{
				document.getElementById(tabName+"_div_"+i).style.display = "none"; 
				document.getElementById(tabName+"_btn_"+i).className = "daohang6 dao";//ǰʾ
			
			};		
			document.getElementById(tabName+"_div_"+id).style.display = "block"; 
			btn.className = "daohang6 daohangx";  //ǰʾ
	};
	var fodTime;
	function delaytabit_shouyeyetou(btn){
		  //document.write(btn);
		clearTimeout(fodTime);
		fodTime=setTimeout(function(){tabit_shouyeyetou(btn)},100);
	}
	
	
	
	function tabit_zhongwentushu(btn){
		var idname = new String(btn.id);
		//document.write(idname);
		var s = idname.indexOf("_");
		var e = idname.lastIndexOf("_")+1;
		var tabName = idname.substr(0, s);
		var id = parseInt(idname.substr(e, 1));
		var tabNumber = btn.parentNode.childNodes.length;
		//document.write(tabNumber);
		for(i=0;i<tabNumber;i++)
			{
				document.getElementById(tabName+"_div_"+i).style.display = "none"; 
				document.getElementById(tabName+"_btn_"+i).className = "beiweixuan";//ǰʾ
			
			};		
			document.getElementById(tabName+"_div_"+id).style.display = "block"; 
			btn.className = "bei";  //ǰʾ
	};
	var fodTime;
	function delaytabit_zhongwentushu(btn){
		  //document.write(btn);
		clearTimeout(fodTime);
		fodTime=setTimeout(function(){tabit_zhongwentushu(btn)},100);
	}
	
	function tabit_waiwenyuanban(btn){
		var idname = new String(btn.id);
		//document.write(idname);
		var s = idname.indexOf("_");
		var e = idname.lastIndexOf("_")+1;
		var tabName = idname.substr(0, s);
		var id = parseInt(idname.substr(e, 1));
		var tabNumber = btn.parentNode.childNodes.length;
		//document.write(tabNumber);
		for(i=0;i<tabNumber;i++)
			{
				document.getElementById(tabName+"_div_"+i).style.display = "none"; 
				document.getElementById(tabName+"_btn_"+i).className = "mainbookbtn daixuan";//ǰʾ
			
			};		
			document.getElementById(tabName+"_div_"+id).style.display = "block"; 
			btn.className = "mainbookbtn xuanzhongs";  //ǰʾ
	};
	var fodTime;
	function delaytabit_waiwenyuanban(btn){
		  //document.write(btn);
		clearTimeout(fodTime);
		fodTime=setTimeout(function(){tabit_waiwenyuanban(btn)},100);
	}
	
	
	
	function tabit_guobanwaiwen(btn){
		var idname = new String(btn.id);
		//document.write(idname);
		var s = idname.indexOf("_");
		var e = idname.lastIndexOf("_")+1;
		var tabName = idname.substr(0, s);
		var id = parseInt(idname.substr(e, 1));
		var tabNumber = btn.parentNode.childNodes.length;
		//document.write(tabNumber);
		for(i=0;i<tabNumber;i++)
			{
				document.getElementById(tabName+"_div_"+i).style.display = "none"; 
				document.getElementById(tabName+"_btn_"+i).className = "mainbookbtn daixuan6";//ǰʾ
			
			};		
			document.getElementById(tabName+"_div_"+id).style.display = "block"; 
			btn.className = "mainbookbtn xuanzhongs";  //ǰʾ
	};
	var fodTime;
	function delaytabit_guobanwaiwen(btn){
		  //document.write(btn);
		clearTimeout(fodTime);
		fodTime=setTimeout(function(){tabit_guobanwaiwen(btn)},100);
	}
	
	
	function tabit_zhongwentushu1(btn){
		var idname = new String(btn.id);
		//document.write(idname);
		var s = idname.indexOf("_");
		var e = idname.lastIndexOf("_")+1;
		var tabName = idname.substr(0, s);
		var id = parseInt(idname.substr(e, 1));
		var tabNumber = btn.parentNode.childNodes.length;
		//document.write(tabNumber);
		for(i=0;i<tabNumber;i++)
			{
				document.getElementById(tabName+"_div_"+i).style.display = "none"; 
				document.getElementById(tabName+"_btn_"+i).className = "mainbookbtn daixuan7";//ǰʾ
			
			};		
			document.getElementById(tabName+"_div_"+id).style.display = "block"; 
			btn.className = "mainbookbtn xuanzhongs";  //ǰʾ
	};
	var fodTime;
	function delaytabit_zhongwentushu1(btn){
		  //document.write(btn);
		clearTimeout(fodTime);
		fodTime=setTimeout(function(){tabit_zhongwentushu1(btn)},100);
	}
	
	
	function tabit_yingshiyinyue(btn){
		var idname = new String(btn.id);
		//document.write(idname);
		var s = idname.indexOf("_");
		var e = idname.lastIndexOf("_")+1;
		var tabName = idname.substr(0, s);
		var id = parseInt(idname.substr(e, 1));
		var tabNumber = btn.parentNode.childNodes.length;
		//document.write(tabNumber);
		for(i=0;i<tabNumber;i++)
			{
				document.getElementById(tabName+"_div_"+i).style.display = "none"; 
				document.getElementById(tabName+"_btn_"+i).className = "mainbookbtn daixuan8";//ǰʾ
			
			};		
			document.getElementById(tabName+"_div_"+id).style.display = "block"; 
			btn.className = "mainbookbtn xuanzhongs";  //ǰʾ
	};
	var fodTime;
	function delaytabit_yingshiyinyue(btn){
		  //document.write(btn);
		clearTimeout(fodTime);
		fodTime=setTimeout(function(){tabit_yingshiyinyue(btn)},100);
	}
	
	function tabit_gouwuche(btn){
		var idname = new String(btn.id);
		//document.write(idname);
		var s = idname.indexOf("_");
		var e = idname.lastIndexOf("_")+1;
		var tabName = idname.substr(0, s);
		var id = parseInt(idname.substr(e, 1));
		var tabNumber = btn.parentNode.childNodes.length;
		//document.write(tabNumber);
		for(i=0;i<tabNumber;i++)
			{
				document.getElementById(tabName+"_div_"+i).style.display = "none"; 
				document.getElementById(tabName+"_btn_"+i).className = "mainbookbtn daixuan8";//ǰʾ
			
			};		
			document.getElementById(tabName+"_div_"+id).style.display = "block"; 
			btn.className = "mainbookbtn xuanzhongs";  //ǰʾ
	};
	var fodTime;
	function delaytabit_gouwuche(btn){
		  //document.write(btn);
		clearTimeout(fodTime);
		fodTime=setTimeout(function(){tabit_gouwuche(btn)},100);
	}
	
	function tabit_foreignlanguage(btn){
		var idname = new String(btn.id);
		//document.write(idname);
		var s = idname.indexOf("_");
		var e = idname.lastIndexOf("_")+1;
		var tabName = idname.substr(0, s);
		var id = parseInt(idname.substr(e, 1));
		var tabNumber = btn.parentNode.childNodes.length;
		//document.write(tabNumber);
		for(i=0;i<tabNumber;i++)
			{
				document.getElementById(tabName+"_div_"+i).style.display = "none"; 
				document.getElementById(tabName+"_btn_"+i).className = "bei";//ǰʾ
			
			};		
			document.getElementById(tabName+"_div_"+id).style.display = "block"; 
			btn.className = "beiweixuan";  //ǰʾ
	};
	var fodTime;
	function delaytabit_foreignlanguage(btn){
		  //document.write(btn);
		clearTimeout(fodTime);
		fodTime=setTimeout(function(){tabit_foreignlanguage(btn)},100);
	}
	
	function tabit_nation(btn){
		var idname = new String(btn.id);
		//document.write(idname);
		var s = idname.indexOf("_");
		var e = idname.lastIndexOf("_")+1;
		var tabName = idname.substr(0, s);
		var id = parseInt(idname.substr(e, 1));
		var tabNumber = btn.parentNode.childNodes.length;
		//document.write(tabNumber);
		for(i=0;i<tabNumber;i++)
			{
				document.getElementById(tabName+"_div_"+i).style.display = "none"; 
				document.getElementById(tabName+"_btn_"+i).className = "beiweixuan";//ǰʾ
			
			};		
			document.getElementById(tabName+"_div_"+id).style.display = "block"; 
			btn.className = "bei";  //ǰʾ
	};
	var fodTime;
	function delaytabit_nation(btn){
		  //document.write(btn);
		clearTimeout(fodTime);
		fodTime=setTimeout(function(){tabit_nation(btn)},100);
	}
	
