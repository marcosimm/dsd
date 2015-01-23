<?php
	ini_set('display_errors',0);
	session_start();
switch ($_REQUEST['msg']) {
	case 'ok':
		echo "<h2 style='margin-left:7%;'><font color='#f00'>Registro se grabo satisfactoriamente.</font></h2>";
		break;
	case 'cod':
		echo "<h4 style='margin-left:7%;'><font color='#f00'>Se ha enviado a su cuenta ".$_SESSION['correorecupera']." un correo con el codigo de activaci&oacute;n.</font></h4>";
		break;
	case 'errrec':
		echo "<h4><font color='#f00'>No se pudo recuperar la clave. Intente nuevamente.</font></h4>";
		break;
}
?>