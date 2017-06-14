function getLinkData(searchElement){
//		DOM中element的子节点包括text
		var popupDiv=searchElement.parentNode.getElementsByTagName("Div")[0];
		var popupBody=(popupDiv.getElementsByTagName("select"))[0].getElementsByTagName("tbody")[0];
//		var popupBody=document.getElementById("popupBody");
// 		var user=document.getElementById("user1");
		clearOthers();
		if(searchElement.value!=''){
			$.ajax({
				type:"post",
				url:"linkData",
				contentType:"application/x-www-form-urlencoded; charset=UTF-8",
				data:{search:searchElement.value},
				dataType:"json",
				success: function(data){
					if(data.length==0){
						return;
					}else{
						var tr,td,text;
						for(var i=0;i<data.length;i++){
							setOffset();
							text=document.createTextNode(data[i].value);
							tr=document.createElement("tr");
							td=document.createElement("td");
							td.mouseOver=function(){this.className="mouseOver;"};
							td.mouseOut=function(){this.className="mouseOut;"};
							td.onclick=function(){selected(this);};//被选中行
							td.appendChild(text);
							tr.appendChild(td);
							popupBody.appendChild(tr);
						}
					}
				}
			});
		}else{
			//clearOthers();
		}	
	
		function selected(cell){
			clearInput(searchElement);//清空输入框中的值
			searchElement.value=cell.firstChild.nodeValue;//修改输入框中的值
			clearOthers();//清除其他联想结果
		}
		
		function clearOthers(){
			while(popupBody.childNodes.length>0){
				//删除所有联想结果
				popupBody.removeChild(popupBody.firstChild);
			}
			//影藏联想结果显示框
			popupDiv.style.border="none";
		}
		
		function setOffset(){
			var width=searchElement.offsetWidth;
			var left=getLeft(searchElement);
			var top=getTop(searchElement)+searchElement.offsetHeight;
			
			popupDiv.style.position="absolute";
			popupDiv.style.backgroundColor="white";
			popupDiv.style.border="1px solid lightskyblue";
			popupDiv.style.borderTop="0px"
			popupDiv.style.left=left+"px";
			popupDiv.style.top=top+"px";
			popupDiv.style.width=width+"px";	
		}
		
		function getLeft(element){
			var offset=element.offsetLeft;
			if(element.offsetParent!=null){
				offset+=getLeft(element.offsetParent);
			}
			return offset;
		}
		
		function getTop(element){
			var offset=element.offsetTop;
			if(element.offsetParet!=null){
				offset+=getTop(element.offsetParent);
			}
			return offset;
		}
	}
	function clearInput(searchElement){
// 		var searchElement=document.getElementById("user1");
		searchElement.value="";
	}