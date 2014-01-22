
function isNotBlank(s) {
	return (s !== null && s !== undefined && s !== '');
}

function submitForm() {
	var username = $(":input[name=username]").val() || '';
	var password = $(":input[name=password]").val() || '';
	var ajaxUrl = $(".form-signin").attr('action') || '';

	var warningArea = $("#warning-area");


	if (!isNotBlank(username)) {
		warningArea.css("display","block");
		warningArea.text("请将用户名填写完整！");
		return;
	}

	if (!isNotBlank(password)) {
		warningArea.css("display","block");
		warningArea.text("请将密码填写完整！");
		return;
	}


	$.ajax({
		type: "POST",
		url: ajaxUrl,
		data: {
			j_username : username,
			j_password : password
		},
		error: function(jqXHR, textStatus, errorThrown) {
			warningArea.css("display","block");
			warningArea.text("出错啦, " + textStatus);
		},
		success: function(data, textStatus, jqXHR) {
			var status = data.status;
			var statusInfo = data.statusInfo;
					
			if (status) {
				warningArea.css("display","block");
				warningArea.text("出错啦, " + statusInfo);
			} else {
				warningArea.css("display","block");
				warningArea.text(statusInfo);
				//window.location = "http://localhost:8080/";
			}
		}
	});
		
}


$(document).ready(function(){
	$("#signin-btn").click(submitForm);
});

