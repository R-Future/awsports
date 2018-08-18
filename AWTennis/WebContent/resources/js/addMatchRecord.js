$(document).ready(function(){		
	//动态添加比赛记录
	$("a#add").click(function(){
		$.ajax({
			type:"post",
			url:"addRecord",
			contentType:"application/x-www-form-urlencoded; charset=UTF-8",
			data:{matches:$("input#numberOfMatches").val(),sets:$("input#singlematchSets").val()},
			dataType:"html",
			success: function(data){
				$("div#matchRecord").html(data);
				/* Only you can submit the form after you input the match records */
				$("button#submit").removeClass("hidden");
			}
		});
	});
	
});