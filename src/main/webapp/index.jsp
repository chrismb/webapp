<html>
<head>
	<link type="text/css" href="static/css/bootstrap.css" rel="stylesheet">
</head>
<body>
	<script src="static/js/bootstrap.js">
	</script>
	<div class="container-fluid">
<!--FORM class="well" ACTION="/myWebApp/simple" METHOD="POST">
		<CENTER>
			Nom :
			<INPUT class="span3" TYPE="TEXT" NAME="nom" VALUE="Your Name"><BR>
			Mail :
			<INPUT class="span3" TYPE="TEXT" NAME="mail" VALUE="Your Mail"><P>
				<INPUT TYPE="SUBMIT" VALUE="Check">
		</CENTER>
</FORM-->
<H1>
	<CENTER>
		Que voulez vous faire?
	</CENTER>
</H1>
<FORM class="form-horizontal" ACTION="/myWebApp/listeUt" METHOD="POST">
		<CENTER>
				<BUTTON type="submit" class="btn btn-primary">Liste des Utilisateurs</BUTTON>
		</CENTER>
</FORM>



</body>
</html>
