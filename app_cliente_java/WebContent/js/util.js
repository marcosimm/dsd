function trim(string) {
	return string.replace(/^\s\s*/, '').replace(/\s\s*$/, '');
}
function validar_requerido(field) {
	with (field) {
		if (value == null || value == "") {
			alert('Incomplete Data, please check.');
			focus();
			return false;
		} else {
			return true;
		}
	}
}