﻿<HTML>
<HEAD>

	<TITLE>Blinkomom</TITLE>
	
</HEAD>
<BODY>

<div><img src="images/jbosscorp_logo.png"></div>
<h1>Blinkomom<h1>

<div id="nav" height=200px;width=100px;float:left>
<p><%= out.print(request.getParameter("n")); %></p>
 <select>
  <option value="volvo">Королевский</option>
  
</select> 
</div>

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

