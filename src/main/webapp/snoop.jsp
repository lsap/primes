﻿<HTML>
<HEAD>

	<TITLE>Blinkomom</TITLE>
	
</HEAD>
<BODY>

<div><img src="images/jbosscorp_logo.png"></div>
<h1>Blinkomom<h1>
<button onclick="myFunction()">Try it</button>

<div id="nav" height=200px;width=100px;float:left>
<p id="na"></p>
 <select>
  <option value="volvo">Королевский</option>
  
</select> 
</div>
<script>
function myFunction() {
var person = prompt("Please enter your name", "Harry Potter");
if (person != null) {
    document.getElementById("na").innerHTML =
    '<%=request.getAttribute("s")%>';
}}
</script>
<div id="section" height=200px;width=100px;float:left>
<p>Выпечка</p>
 <select>
  <option value="volvo">-</option>
  
</select> 
</div>
<div>
<p>Основные блюда</p>
 <select>
  <option value="volvo">Борщ</option>
  
</select> 
</div>
<div>
<p>Вторые блюда</p>
 <select>
  <option value="volvo">-</option>
  
</select> 
</div>
</BODY>
</HTML>

