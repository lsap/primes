<html>
<head><title>Hello</title></head>
<body>
<h1>
<%
if (request.getParameter("name") == null) {
   out.println("Hello World");
}
else {
  out.println("Hello, " + request.getParameter("name"));
}
%>
</h1>
</body></html>