function dyniframesize(down) 
	{ 
	  try{
				var pTar = null; 
				if (document.getElementById)
				{ 
					pTar = document.getElementById(down); 
				} 
				else
				{ 
					eval('pTar = ' + down + ';'); 
				}
				
				if (pTar && !window.opera)
				{ 
					//begin resizing iframe 
					pTar.style.display="block" 
					if (pTar.contentDocument && pTar.contentDocument.body.offsetHeight)
					{ 
					
						//ns6 syntax 
							if (pTar.contentDocument.body.offsetHeight<400) 
						{
							pTar.height=420;
						}
						else
						{
							pTar.height = pTar.contentDocument.body.offsetHeight; 
						}
							
						pTar.width = pTar.contentDocument.body.scrollWidth; 
							
					} 
					else if (pTar.Document && pTar.Document.body.scrollHeight)
					{ 
						//ie5+ syntax 
						if (pTar.Document.body.scrollHeight<420) 
						{
							pTar.height=420;
						}
						else
						{
							pTar.height = pTar.Document.body.scrollHeight; 
						}
						
						pTar.width = pTar.Document.body.scrollWidth; 
							
					} 
					//if (pTar.height<420) {pTar.height=420;}
				} 
    }catch (ex){}
	}
	window.setInterval("dyniframesize('iframeautoheight');", 200);