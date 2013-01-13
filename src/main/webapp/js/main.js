

// handle the logoff (any links any where)
$(function(){
	$(document).on("click","a.logoff",function(e){
		var $a = $(this);
		$.ajax("api/user-logoff.do",{type:"POST"}).done(function(){
			window.location = window.location.href;
		});
	});
});