function validausuario(){
	if (document.frmUsuarioNuevo.txtClave.value!=document.frmUsuarioNuevo.txtReClave.value)
	{
		alert('Las CLAVES ingresadas deben coincidir.');
		document.frmUsuarioNuevo.txtReClave.focus();
		return false;
	}else{return true}
}