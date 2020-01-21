<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
  List<String> dCities = new ArrayList();
  dCities.add("Roseburg");
  dCities.add("Winston");
  List<String> jCities = new ArrayList();
  jCities.add("Medford");
  jCities.add("Jacksonville");
  List<String> aCities = new ArrayList();
  aCities.add("Oakland");
  aCities.add("Berkeley");
  List<String> mCities = new ArrayList();
  mCities.add("Salinas");
  mCities.add("Gonzales");
  HashMap<String, List<String>> oCounties = new HashMap();
  oCounties.put("Douglas", dCities);
  oCounties.put("Jackson", jCities);
  HashMap<String, List<String>> cCounties = new HashMap();
  cCounties.put("Alameda", aCities);
  cCounties.put("Monterey", mCities);
  HashMap<String, HashMap<String, List<String>>> states = new HashMap(); 
  states.put("Oregon", oCounties); 
  states.put("California", cCounties); 
  pageContext.setAttribute("states", states);
%>
<html>
<head>
<script>
function setOptTwo(chosen,selbox) {
    selbox.options.length = 0;
 	selbox.options[selbox.options.length] = new Option('Select county ','Select county');
<c:forEach  var="state" items="${states}">
	<c:forEach  var="county" items="${state.value}">
		if (chosen == "${state.key}") {
			selbox.options[selbox.options.length] = new Option('${county.key}','${county.key}');
		}
	</c:forEach>
</c:forEach> 
}
function setOptThree(chosen,selbox) {
    selbox.options.length = 0;
 	selbox.options[selbox.options.length] = new Option('Select city ','Select city');
<c:forEach  var="state" items="${states}">
	<c:forEach  var="county" items="${state.value}">
		if (chosen == "${county.key}") {
		<c:forEach  var="city" items="${county.value}">
			selbox.options[selbox.options.length] = new Option('${city}','${city}');
		</c:forEach> 
		}
	</c:forEach>
</c:forEach> 
}
</script>
</head>
<body>
<form name="myform">
 <select name="optone" size="1"
    onchange="setOptTwo(document.myform.optone.options[document.myform.optone.selectedIndex].value, document.myform.opttwo);
	          document.myform.optthree.selectedIndex = 0;">
 <option value="Select state" selected="selected">Select state</option>
 <c:forEach  var="state" items="${states}">
    <option value="${state.key}">${state.key}</option>
 </c:forEach> 
</select><br> <br>
 <select name="opttwo" size="1"
    onchange="setOptThree(document.myform.opttwo.options[document.myform.opttwo.selectedIndex].value, document.myform.optthree);">
 <option value=" " selected="selected">Please select state first</option>
 </select><br> <br>
 <select name="optthree" size="1">
    <option value=" " selected="selected">Please select county first</option>
 </select>
</form>
</body>
</html>