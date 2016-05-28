var currId1 = 'NewProduct_1_o';
function changTop1(newId)
{
	if( currId1!=null)
    {
	  setTimeout("currId1none('"+currId1+"')", 500);
	  setTimeout("currId1block('"+currId1+"')", 500);
	}	
	setTimeout("newIdblock('"+newId+"')", 500);
	setTimeout("newIdnone('"+newId+"')", 500);
	currId1 = newId;
}

function currId1none(currId1){
	//window.alert(currId1);
	document.getElementById(currId1).style.display="none";
}

function currId1block(currId1){
	document.getElementById(currId1+'_t').style.display="block";
}

function newIdblock(newId){
	document.getElementById(newId).style.display="block";
}

function newIdnone(newId){
	document.getElementById(newId+'_t').style.display="none";
}


