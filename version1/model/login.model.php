<?php
class LoginModel
{
	private $pdo;

	public function __CONSTRUCT()
	{
		try
		{
			$this->pdo = new PDO('mysql:host=localhost;dbname=adosacpe_dsd', 'adosacpe_rootdsd', '21846168');
			$this->pdo->exec("SET CHARACTER SET utf8");
			$this->pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);		        
		}
		catch(Exception $e)
		{
			die($e->getMessage());
		}
	}

	public function Obtener($correo, $clave)
	{
		try 
		{
			$stm = $this->pdo
			          ->prepare("SELECT cod_usuario, nom_usuario,nom_correo, nom_empresa, nom_estado FROM tb_usuario WHERE nom_correo = ? AND nom_clave = ?");
		    
			$stm->execute(array($correo, $clave));

			if($stm->rowCount()==0){
				return false;
			}else{
				$r = $stm->fetch(PDO::FETCH_OBJ);
				session_start();
				$_SESSION['codigousuario'] = $r->cod_usuario;
				$_SESSION['nombreusuario'] = $r->nom_usuario;
				$_SESSION['nombrecorreo'] = $r->nom_correo;
				$_SESSION['nombreempresa'] = $r->nom_empresa;
				$_SESSION['nombreestado'] = $r->nom_estado;
				return true;
			}
		} catch (Exception $e) 
		{
			die($e->getMessage());
		}
	}
}