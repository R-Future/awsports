$(document).ready(function(){
	$("a#update").click(function(){
		var loader = $("div.loader");
		var entrys=$("input[name='entrys']:checked").serialize();
		loader.removeClass("hidden");
		$(this).attr("disabled","disabled");
		$.ajax({
			type:"post",
			url:"updateRank",
			contentType:"application/x-www-form-urlencoded; charset=UTF-8",
			data:entrys,
			success:function(){
				loader.addClass("hidden");
				$("a#update").removeAttr("disabled");
				alert("更新成功！");
			}
		});
	});
});