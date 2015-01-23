<?php
class Login
{
	private $cod_usuario;
	private $nom_usuario;
	private $nom_correo;
	private $nom_clave;
	private $nom_empresa;
	private $nom_estado;

	public function __GET($k){ return $this->$k; }
	public function __SET($k, $v){ return $this->$k = $v; }
}