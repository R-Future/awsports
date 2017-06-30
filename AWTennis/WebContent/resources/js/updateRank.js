$(document).ready(function(){
	$("a#update").click(function(){
		var entrys=$("input[name='entrys']:checked").serialize();
		$.ajax({
			type:"post",
			url:"updateRank",
			contentType:"application/x-www-form-urlencoded; charset=UTF-8",
			data:entrys,
			success:function(){
				alert("更新成功！");
			}
		});
	});
});