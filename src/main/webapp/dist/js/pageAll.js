$(function(){
	var demo = document.getElementById("demo");
	var gg = document.getElementsByTagName("img");
	var ei = document.getElementById("enlarge_images");
	
	var w = document.body.clientWidth;
	
	if(demo != null && gg != null && ei != null){
		for(i=0; i<gg.length; i++){
			var ts = gg[i];
			ts.onmousemove = function(event){
				event = event || window.event;
				ei.style.display = "block";
				ei.innerHTML = '<img src="' + this.src + '" />';
				ei.style.top = (event.pageY) + "px";
				if(event.pageX < w/2){
						ei.style.left = (event.pageX) + "px";
						ei.style.right = "auto";
				}else{
						ei.style.right = (w - event.pageX) + "px";
						ei.style.left = "auto";
				}
			};
			ts.onmouseout = function(){
				ei.innerHTML = "";
				ei.style.display = "none";
			};
		}
	}
});