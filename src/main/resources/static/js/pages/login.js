$(function () {
//	alert("123");
//	$("#loginBtn").on("click",function(){
//	$.ajax({
//	type : 'POST',
//	url :   'user/userAction.action',
//	data : {
//	"userInfo.username" : $("#username").val(),
//	"userInfo.password" : $("#password").val()
//	},
//	error : function(XMLHttpRequest, textStatus, errorThrown) {
//	},
//	success : function(data) {
//	alert(data);
//	switch (data.info) {
//	case '3':
//	$("#validationCode").val("");
//	yipin.showIcon.error($("#authCodetTip1"), "验证码错误!");
//	nextValidateCode("imgLogin1");
//	return;
//	case '4':
//	$("#fileName").val($('#uploadFile').val());
//	document.getElementById("sellerIn_form").submit();
//	break;//表示成功
//	default:
//	break;
//	}
//	},
//	dataType : 'json'
//	});
//	});
	$("#logoutBtn").bind("click",function(){
		document.getElementById("logoutForm").submit();
	});
});