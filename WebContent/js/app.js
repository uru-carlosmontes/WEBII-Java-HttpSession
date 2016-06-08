var xhr = new XMLHttpRequest();

function $ (id) {
	return document.getElementById(id);
}

function getResult () {
	var x = $("x").value;
	var y = $("y").value;
	
	var url = "./test";
	
	xhr.onreadystatechange = function () {
		if (xhr.status === 200 && xhr.readyState === 4) {
			var data = JSON.parse(xhr.responseText);
			$("z").value = data.z;
		}
	}
	
	xhr.open("POST", url, true);
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	var params = "x="+x+"&y="+y;
	xhr.send(params);
}




