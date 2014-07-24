<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%
// How to show place in google map
// Amit Gaur
// Email: amitt800@gmail.com
// My Blog: amitkgaur.blogspot.com

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script
	src="http://maps.google.com/maps?file=api&v=2&key=AIzaSyDNztoWYAaooc6bQUXJpCJHadfcGHusLck"
	type="text/javascript">
</script>
<body>
	<p>
		<strong>locations in India</strong>
	</p>
	<div id="map" style="width: 800px; height: 600px"></div>

	<script type="text/javascript">
//<![CDATA[
var map = new GMap2(document.getElementById("map"));
map.addControl(new GLargeMapControl());
map.addControl(new GMapTypeControl());
map.addControl(new GScaleControl());
map.setCenter(new GLatLng(23.402800, 78.454100), 5, G_NORMAL_MAP);
function createMarker(point, number)
{
var marker = new GMarker(point);
var html = number;
GEvent.addListener(marker, "click", function() {marker.openInfoWindowHtml(html);});
return marker;
};
<%
	String userName = "root";
	String password = "root";
	String url = "jdbc:mysql://localhost:3306/ajeet";
	try{
		String driver = "com.mysql.jdbc.Driver";
		Class.forName(driver).newInstance();
		Connection conn;
		conn = DriverManager.getConnection(url, "root","root");
		Statement s = conn.createStatement ();
		s.executeQuery ("SELECT *from google_map");
		ResultSet rs = s.getResultSet ();
		int count = 0;
		while (rs.next ()) {
			String lat = rs.getString ("lat");
			String lon = rs.getString ("lon");
			String address=rs.getString ("address");
			out.print("var point = new GLatLng("+lat+","+lon+");\n");
			out.print("var marker = createMarker(point, '"+address+"');\n");
			out.print("map.addOverlay(marker);\n");
			out.print("\n");
		}
		rs.close ();
		s.close ();
	}
	catch(Exception ee){
		System.out.println(ee.toString());	
	}
%>
		//]]>
	</script>
</body>
</html>
