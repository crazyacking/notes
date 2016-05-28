/*
 * jQuery Checkbox Plugin
 * version: 1.0 (2010-4-12)
 * @requires jQuery v1.3.2 or later
 * @author:tommy
 * @email:service@tommyframework.com
 * Examples and documentation at: http://www.tommyframework.com
 * Dual licensed under the MIT and GPL licenses:
 *   http://www.opensource.org/licenses/mit-license.php
 *   http://www.gnu.org/licenses/gpl.html
 */
(function($){
	$.fn.checkbox_all=function(ele){
		$(this).click(function(){
			$(ele).attr('checked',true);
		});
	}
	$.fn.checkbox_none=function(ele){
		$(this).click(function(){
			$(ele).attr('checked',false);
		});
	}
	$.fn.checkbox_anti=function(ele){
		$(this).click(function(){
			$(ele).each(function(){
				if(this.checked==true){
					this.checked=false;
				}else{
					this.checked=true;
				}
			})
		});
	}
	$.fn.checkbox_checkbox=function(ele){
		$(this).click(function(){
			if(this.checked==true){
				$(ele).attr('checked',true);
			}else{
				$(ele).attr('checked',false);
			}
		});
	}
	$.checkbox_get_id=function(ele){
		var selected_id='';
		$(ele).each(function(){
			if($(this).attr('checked')==true){
				selected_id+=$(this).val()+',';
			}
		});
		selected_id=selected_id.slice(0,-1);
		return selected_id;
	}
})(jQuery);