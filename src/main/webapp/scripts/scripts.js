function cargarCabecera(){
	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			cabecera(this);
		}
	};
	xhttp.open("GET", "/paginas/menus.xml", true);
	xhttp.send();
}

function cargarFooter(){
	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			footer(this);
		}
	};
	xhttp.open("GET", "/paginas/menus.xml", true);
	xhttp.send();
}

function cabecera(xml) {
	let xmlDoc=xml.responseXML;
	let txt="";
	let x=xmlDoc.getElementsByTagName("CABECERA");
	let y=x[0].getElementsByTagName("ENTRADA");
	h="";
	for (let i=0;i<y.length;i++){
		txt=txt+'<li class="nav"><a class="nav" href="' + y[i].getElementsByTagName("DIRECCION")[0].childNodes[0].nodeValue + '">' + y[i].getElementsByTagName("NOMBRE")[0].childNodes[0].nodeValue + '</a> </li>';
	}
	document.getElementById("navVar").innerHTML=txt;
}; 

function footer(xml) {
	let xmlDoc=xml.responseXML;
	let txt="";
	let x=xmlDoc.getElementsByTagName("FOOTER");
	let y=x[0].getElementsByTagName("ENTRADA");
	h="";
	for (let i=0;i<y.length;i++){
		txt=txt+'<li> <a href="' + y[i].getElementsByTagName("DIRECCION")[0].childNodes[0].nodeValue + '">' + y[i].getElementsByTagName("NOMBRE")[0].childNodes[0].nodeValue + '</a> </li>';
	}
	document.getElementById("links-footer").innerHTML=txt;
}; 

function menus(){
	cargarCabecera();
	cargarFooter();
}

function iluminar(){
	let img=document.getElementById("logo_menu");
	img.style.background="radial-gradient(farthest-side at center, #4ecca3 40%, #232931)";
	img.style.height="115px";
	img.style.width="115px";
	let contenedor=document.getElementById("contenedor_logo");
	contenedor.style.padding="0px 0px 0px 0px";
}

function apagar(){
	let img=document.getElementById("logo_menu");
	img.style.background="none";
	img.style.height="100px";
	img.style.width="100px";
	let contenedor=document.getElementById("contenedor_logo");
	contenedor.style.padding="7.5px";
	
}